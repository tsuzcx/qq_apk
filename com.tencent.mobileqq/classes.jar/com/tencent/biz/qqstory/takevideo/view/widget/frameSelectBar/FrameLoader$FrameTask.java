package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;
import com.tencent.maxvideo.trim.TrimNative;

public class FrameLoader$FrameTask
  extends Task
{
  private Integer i;
  private MediaMetadataRetriever j;
  private int k;
  private int l;
  private long m;
  private int n;
  private boolean o;
  private boolean p;
  private FrameLoader.GetFrameReport q;
  
  public FrameLoader$FrameTask(ImageView paramImageView, MediaMetadataRetriever paramMediaMetadataRetriever, Integer paramInteger, int paramInt1, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean1, FrameLoader.GetFrameReport paramGetFrameReport, boolean paramBoolean2)
  {
    super(paramImageView);
    this.i = paramInteger;
    this.j = paramMediaMetadataRetriever;
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramLong;
    this.n = paramInt3;
    this.o = paramBoolean1;
    this.q = paramGetFrameReport;
    this.p = paramBoolean2;
  }
  
  @TargetApi(10)
  public void a()
  {
    SLog.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround:%s", new Object[] { b() });
    long l3 = System.currentTimeMillis();
    if ((UIUtils.c()) && (this.p))
    {
      SLog.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative:%s", new Object[] { b() });
      try
      {
        Bitmap localBitmap1;
        if (this.o) {
          localBitmap1 = Bitmap.createBitmap(this.l, this.k, Bitmap.Config.ARGB_8888);
        } else {
          localBitmap1 = Bitmap.createBitmap(this.k, this.l, Bitmap.Config.ARGB_8888);
        }
        this.i.intValue();
        int i1 = this.n;
        long l2 = (this.i.intValue() + 1) * this.n;
        l1 = l2;
        if (l2 > this.m) {
          l1 = this.m;
        }
        if (TrimNative.getThumbnail(0L, l1, localBitmap1) == 0)
        {
          Bitmap localBitmap2 = localBitmap1.copy(Bitmap.Config.RGB_565, true);
          localObject2 = localBitmap2;
          if (this.o) {
            localObject2 = UIUtils.a(localBitmap2, 90.0F);
          }
          a(new BitmapDrawable((Bitmap)localObject2));
          localBitmap1.recycle();
          l1 = System.currentTimeMillis() - l3;
          SLog.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative 完成时间:%s,key=%s", new Object[] { Long.valueOf(l1), b() });
          this.q.a(this.i.intValue(), l1);
          return;
        }
        if ((localBitmap1 != null) && (!localBitmap1.isRecycled())) {
          localBitmap1.recycle();
        } else {
          SLog.e("Q.qqstory.frameWidget.FrameLoader", "TrimNative return error!");
        }
      }
      catch (Exception localException)
      {
        SLog.e("Q.qqstory.frameWidget.FrameLoader", "create bitmap width=%s,height=%s,error:%s", new Object[] { Integer.valueOf(this.k), Integer.valueOf(this.l), localException });
      }
    }
    Object localObject1 = this.j;
    if (localObject1 == null)
    {
      SLog.e("Q.qqstory.frameWidget.FrameLoader", "mRetriever is null!");
      return;
    }
    localObject1 = ((MediaMetadataRetriever)localObject1).getFrameAtTime(this.i.intValue() * this.n * 1000L);
    if (localObject1 == null)
    {
      SLog.e("Q.qqstory.frameWidget.FrameLoader", "mRetriever return null!");
      return;
    }
    Object localObject2 = new Matrix();
    if (this.o)
    {
      float f1 = this.k / ((Bitmap)localObject1).getHeight();
      float f2 = this.l / ((Bitmap)localObject1).getWidth();
      ((Matrix)localObject2).postRotate(90.0F);
      ((Matrix)localObject2).postScale(f1, f2);
    }
    else
    {
      ((Matrix)localObject2).postScale(this.k / ((Bitmap)localObject1).getWidth(), this.l / ((Bitmap)localObject1).getHeight());
    }
    localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject2, true);
    ((Bitmap)localObject1).recycle();
    a(new BitmapDrawable((Bitmap)localObject2));
    long l1 = System.currentTimeMillis() - l3;
    SLog.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: mRetriever 完成时间:%s,key=%s", new Object[] { Long.valueOf(l1), b() });
    this.q.a(this.i.intValue(), l1);
  }
  
  public String b()
  {
    return String.valueOf(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.FrameLoader.FrameTask
 * JD-Core Version:    0.7.0.1
 */