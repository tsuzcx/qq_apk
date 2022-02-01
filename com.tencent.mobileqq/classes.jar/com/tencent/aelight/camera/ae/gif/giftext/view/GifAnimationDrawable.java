package com.tencent.aelight.camera.ae.gif.giftext.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GifAnimationDrawable
  extends Drawable
  implements Animatable
{
  private static Set<SoftReference<Bitmap>> jdField_b_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected Context a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private GifAnimationDrawable.Frame jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame;
  private GifAnimationDrawable.InvalidationHandler jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$InvalidationHandler;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private Set<SoftReference<Bitmap>> jdField_a_of_type_JavaUtilSet;
  protected volatile boolean a;
  private long jdField_b_of_type_Long;
  private ArrayList<GifAnimationDrawable.AnimationCallback> jdField_b_of_type_JavaUtilArrayList;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  private boolean e;
  
  public GifAnimationDrawable(Context paramContext, ArrayList<String> paramArrayList, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FastAnimationDrawable@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Int = -1;
    this.c = false;
    this.e = false;
    this.jdField_a_of_type_Long = 34L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$InvalidationHandler = new GifAnimationDrawable.InvalidationHandler(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilSet = jdField_b_of_type_JavaUtilSet;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private void a(GifAnimationDrawable.Frame paramFrame)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("frameReady() called next=");
      localStringBuilder.append(paramFrame);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.d = false;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("android.resource://main_tab_animation_");
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame.jdField_a_of_type_Int));
      if (CommonImageCacheHelper.a(((StringBuilder)localObject).toString()) == null) {
        this.jdField_a_of_type_JavaUtilSet.add(new SoftReference(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap()));
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame = paramFrame;
    if (!isRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "frameReady() isRunning = false");
      }
      return;
    }
    invalidateSelf();
    b(paramFrame);
    if ((this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (this.c))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$InvalidationHandler.postDelayed(new GifAnimationDrawable.1(this), this.jdField_a_of_type_Long);
      return;
    }
    a();
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "reset");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(GifAnimationDrawable.Frame paramFrame)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GifAnimationDrawable.AnimationCallback)localIterator.next()).a(paramFrame.jdField_a_of_type_Int);
    }
  }
  
  private void c()
  {
    Log.i(this.jdField_a_of_type_JavaLangString, "dispatchAnimationStart: ");
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GifAnimationDrawable.AnimationCallback)localIterator.next()).a(this);
    }
  }
  
  private void d()
  {
    Log.i(this.jdField_a_of_type_JavaLangString, "dispatchAnimationEnd: ");
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GifAnimationDrawable.AnimationCallback)localIterator.next()).b(this);
    }
  }
  
  protected void a()
  {
    if (isRunning())
    {
      if (this.d) {
        return;
      }
      this.d = true;
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_Int %= this.jdField_a_of_type_JavaUtilArrayList.size();
      long l2 = SystemClock.uptimeMillis();
      long l1 = l2;
      if (!this.jdField_b_of_type_Boolean) {
        l1 = l2 + this.jdField_a_of_type_Long;
      }
      ThreadManagerV2.postImmediately(new GifAnimationDrawable.Decoder(this, new GifAnimationDrawable.Frame(this.jdField_a_of_type_Int, l1, null)), null, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    l1 -= l2;
    if (l2 == 0L) {
      l1 = 0L;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("draw() called diff=[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame != null)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        c();
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(getBounds());
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap();
        if (localObject1 != null)
        {
          localObject2 = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("draw() called with: w=");
          localStringBuilder.append(((Bitmap)localObject1).getWidth());
          localStringBuilder.append(", h=");
          localStringBuilder.append(((Bitmap)localObject1).getHeight());
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        else
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "draw() called with: null bitmap");
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setFilterBitmap(true);
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewGifAnimationDrawable$Frame.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.draw(paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "draw() called null bitmap");
    }
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public int getIntrinsicHeight()
  {
    return getBounds().height();
  }
  
  public int getIntrinsicWidth()
  {
    return getBounds().width();
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVisible changed:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" visible:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" restart:");
      localStringBuilder.append(paramBoolean2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      if (bool)
      {
        start();
        if (paramBoolean2)
        {
          b();
          return bool;
        }
        start();
        return bool;
      }
    }
    else if (bool) {
      stop();
    }
    return bool;
  }
  
  public void start()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      a();
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop() called");
    }
    if (isRunning()) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.view.GifAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */