package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import veg;
import vjk;
import vjl;
import vxy;

public class MultiBlockVideoPlayer
  extends ImageViewVideoPlayer
{
  private RuntimeException jdField_a_of_type_JavaLangRuntimeException;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksLock.newCondition();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private vjl jdField_a_of_type_Vjl;
  private Bitmap b;
  
  public MultiBlockVideoPlayer(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiBlockVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void a()
  {
    if (VideoEnvironment.b(7))
    {
      VideoSourceHelper localVideoSourceHelper = null;
      WeakReference localWeakReference = VideoSourceHelper.sCurrentRef;
      if (localWeakReference != null) {
        localVideoSourceHelper = (VideoSourceHelper)localWeakReference.get();
      }
      if (localVideoSourceHelper != null) {
        localVideoSourceHelper.setCurrentVideoFrameRange(false, 0L, 0L, 1L, 1L);
      }
    }
  }
  
  public Bitmap a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject1 = VideoSourceHelper.sCurrentRef;
    if (localObject1 != null) {}
    Object localObject3;
    for (localObject1 = (VideoSourceHelper)((WeakReference)localObject1).get();; localObject3 = null)
    {
      if (localObject1 == null) {
        return null;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
        this.b = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        for (;;)
        {
          Bitmap localBitmap1 = this.b;
          if (localBitmap1 != null) {
            break;
          }
          try
          {
            veg.c("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "generateVideoFrameBitmap wait for bitmap cache");
            if (!this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.await(200L, TimeUnit.MILLISECONDS))
            {
              veg.d("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "generateVideoFrameBitmap current thread [tid=%d] wait time out !!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
              if (this.jdField_a_of_type_JavaLangRuntimeException != null) {
                veg.b("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "Client use the bitmap too long time", this.jdField_a_of_type_JavaLangRuntimeException);
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            veg.b("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "generateVideoFrameBitmap current thread InterruptedException", localInterruptedException);
          }
        }
        localBitmap2 = this.b;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      Bitmap localBitmap2;
      this.b = null;
      paramInt1 = localObject2.getVideoFrameBitmap(localBitmap2, paramLong);
      if (paramInt1 != 0) {
        veg.e("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "getVideoFrameBitmap error code = %d, frame index = %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      return localBitmap2;
    }
  }
  
  @NonNull
  public List<vjk> a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Object localObject = null;
    WeakReference localWeakReference = VideoSourceHelper.sCurrentRef;
    if (localWeakReference != null) {
      localObject = (VideoSourceHelper)localWeakReference.get();
    }
    if (localObject == null) {
      return Collections.emptyList();
    }
    long l = SystemClock.uptimeMillis();
    long[] arrayOfLong = new long[(paramInt1 + 4) * 2];
    int i = ((VideoSourceHelper)localObject).getFirstFrameIndexArray(paramLong, arrayOfLong);
    veg.b("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "getFirstFrameIndexArray cost %d ms", Long.valueOf(SystemClock.uptimeMillis() - l));
    if (i != 0)
    {
      veg.e("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "getFirstFrameIndexArray failed %d", new Object[] { Integer.valueOf(i) });
      return Collections.emptyList();
    }
    i = 0;
    while (i < arrayOfLong.length / 2)
    {
      veg.c("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "frame index = " + arrayOfLong[(i * 2)] + ", time = " + arrayOfLong[(i * 2 + 1)]);
      i += 1;
    }
    if ((arrayOfLong[(paramInt1 * 2)] != -1L) || (arrayOfLong[(paramInt1 * 2 + 1)] != -1L))
    {
      int j = 0;
      i = paramInt1 * 2 + 2;
      while ((i < arrayOfLong.length) && (arrayOfLong[i] != -1L) && (arrayOfLong[(i + 1)] != -1L))
      {
        arrayOfLong[(paramInt1 * 2)] = arrayOfLong[i];
        arrayOfLong[(paramInt1 * 2 + 1)] = arrayOfLong[(i + 1)];
        arrayOfLong[i] = -1L;
        arrayOfLong[(i + 1)] = -1L;
        j = 1;
        i += 2;
      }
      if (j != 0)
      {
        paramInt1 = 0;
        while (paramInt1 < arrayOfLong.length / 2)
        {
          veg.c("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "frame index = " + arrayOfLong[(paramInt1 * 2)] + ", time = " + arrayOfLong[(paramInt1 * 2 + 1)]);
          paramInt1 += 1;
        }
      }
    }
    paramLong = SystemClock.uptimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramInt1 = 0;
    if ((paramInt1 < arrayOfLong.length) && (paramInt1 + 2 < arrayOfLong.length))
    {
      if ((arrayOfLong[paramInt1] != -1L) && (arrayOfLong[(paramInt1 + 2)] != -1L))
      {
        localWeakReference = null;
        localObject = localWeakReference;
        if (paramBoolean)
        {
          Bitmap localBitmap = a(arrayOfLong[paramInt1], paramInt2, paramInt3);
          if (localBitmap == null) {
            break label571;
          }
          localObject = vxy.a(localBitmap, paramFloat, false);
          a(localBitmap);
        }
      }
      for (;;)
      {
        if ((paramBoolean) && (localObject == null)) {
          veg.e("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "resizeBitmapByScale failed ! please check BitmapUtils.resizeBitmapByScale() ! frame index = %d", new Object[] { Long.valueOf(arrayOfLong[paramInt1]) });
        }
        localArrayList.add(new vjk(paramInt1 / 2, arrayOfLong[paramInt1], arrayOfLong[(paramInt1 + 2)], arrayOfLong[(paramInt1 + 1)], arrayOfLong[(paramInt1 + 3)], (Bitmap)localObject));
        paramInt1 += 2;
        break;
        label571:
        veg.e("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "getVideoFrameBitmap failed error ! please check generateVideoFrameBitmapByFrameIndex");
        localObject = localWeakReference;
      }
    }
    veg.b("Q.qqstory.publish.edit.MultiBlockVideoPlayer", "getMultiVideoInfo count = %d, cost %d ms", Integer.valueOf(localArrayList.size()), Long.valueOf(SystemClock.uptimeMillis() - paramLong));
    return localArrayList;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      throw new IllegalArgumentException("bitmap should not be null or recycled");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    if (this.b != null) {
      throw new IllegalStateException("add bitmap as buffer duplicate");
    }
    this.jdField_a_of_type_JavaLangRuntimeException = null;
    try
    {
      this.b = paramBitmap;
      this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.signal();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    paramView = this.jdField_a_of_type_Vjl;
    if (paramView != null) {
      paramView.l();
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    paramView = this.jdField_a_of_type_Vjl;
    if (paramView != null) {
      paramView.l();
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    paramView = this.jdField_a_of_type_Vjl;
    if (paramView != null) {
      paramView.l();
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramView, paramURLDrawable);
    paramView = this.jdField_a_of_type_Vjl;
    if (paramView != null) {
      paramView.i();
    }
  }
  
  public void setCurrentVideoFragment(vjk paramvjk)
  {
    if (paramvjk != null)
    {
      VideoSourceHelper localVideoSourceHelper = null;
      WeakReference localWeakReference = VideoSourceHelper.sCurrentRef;
      if (localWeakReference != null) {
        localVideoSourceHelper = (VideoSourceHelper)localWeakReference.get();
      }
      if (localVideoSourceHelper == null) {
        throw new MultiBlockVideoPlayer.MultiOperateException("can not find active VideoSourceHelper");
      }
      int i = localVideoSourceHelper.setCurrentVideoFrameRange(true, paramvjk.a, paramvjk.c, paramvjk.b, paramvjk.d);
      if (i != 0) {
        throw new MultiBlockVideoPlayer.MultiOperateException("setCurrentVideoFrameRange failed " + i);
      }
    }
  }
  
  public void setVideoLoadListener(vjl paramvjl)
  {
    this.jdField_a_of_type_Vjl = paramvjl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer
 * JD-Core Version:    0.7.0.1
 */