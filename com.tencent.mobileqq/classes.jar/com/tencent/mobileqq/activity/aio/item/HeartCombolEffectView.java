package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class HeartCombolEffectView
  extends View
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = null;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HeartCombolEffectView.OneHeartTracker jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker;
  private String jdField_a_of_type_JavaLangString = "chat_item_for_qqbixin_strong";
  private ArrayList<HeartCombolEffectView.OneHeartTracker> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  private int d = 0;
  private int e = 0;
  
  public HeartCombolEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public HeartCombolEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public HeartCombolEffectView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramContext);
  }
  
  @TargetApi(11)
  private HeartCombolEffectView.OneHeartTracker a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, int paramInt6)
  {
    HeartCombolEffectView.OneHeartTracker localOneHeartTracker = new HeartCombolEffectView.OneHeartTracker(this);
    localOneHeartTracker.jdField_a_of_type_Boolean = false;
    localOneHeartTracker.jdField_a_of_type_Int = paramInt1;
    localOneHeartTracker.jdField_b_of_type_Int = paramInt2;
    localOneHeartTracker.c = paramInt3;
    localOneHeartTracker.d = paramInt4;
    localOneHeartTracker.e = paramInt5;
    localOneHeartTracker.jdField_a_of_type_Float = paramFloat;
    localOneHeartTracker.h = paramInt6;
    localOneHeartTracker.jdField_b_of_type_Boolean = false;
    localOneHeartTracker.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext(), new DecelerateInterpolator());
    localOneHeartTracker.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext(), new DecelerateInterpolator());
    localOneHeartTracker.jdField_b_of_type_AndroidWidgetScroller = new Scroller(getContext(), new AccelerateInterpolator());
    localOneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { localOneHeartTracker.jdField_a_of_type_Float, 0.0F });
    localOneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1100 - localOneHeartTracker.h);
    localOneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new HeartCombolEffectView.3(this, localOneHeartTracker));
    return localOneHeartTracker;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(-1.0F, 1.0F);
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
    return null;
  }
  
  void a(Context paramContext)
  {
    setOnTouchListener(new HeartCombolEffectView.1(this));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(getResources(), 2130839093);
    paramContext = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (paramContext != null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(paramContext);
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels - ImmersiveUtils.getStatusBarHeight(getContext()) * 2;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramContext = this.jdField_a_of_type_JavaUtilArrayList;
    int k = (int)(i * 1.2F);
    float f = j;
    paramContext.add(a(300, k, (int)(0.37F * f), 0, (int)(0.15F * f), 1.0F, 500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(780, k, (int)(0.42F * f), 0, (int)(0.25F * f), 0.95F, 500));
    paramContext = this.jdField_a_of_type_JavaUtilArrayList;
    int n = (int)(0.46F * f);
    double d1 = -i;
    Double.isNaN(d1);
    int m = (int)(0.06D * d1);
    paramContext.add(a(180, k, n, m, (int)(0.27F * f), 1.42F, 500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(450, k, (int)(0.51F * f), 0, (int)(0.45F * f), 0.92F, 500));
    paramContext = this.jdField_a_of_type_JavaUtilArrayList;
    n = (int)(0.56F * f);
    Double.isNaN(d1);
    paramContext.add(a(0, k, n, (int)(0.1D * d1), (int)(0.6F * f), 0.55F, 500));
    paramContext = this.jdField_a_of_type_JavaUtilArrayList;
    n = (int)(0.63F * f);
    Double.isNaN(d1);
    paramContext.add(a(620, k, n, (int)(d1 * 0.04D), (int)(0.75F * f), 1.3F, 500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(410, k, (int)(0.71F * f), m, (int)(f * 0.89F), 0.88F, 500));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker = ((HeartCombolEffectView.OneHeartTracker)this.jdField_a_of_type_JavaUtilArrayList.get(1));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new HeartCombolEffectView.2(this));
    this.jdField_a_of_type_Int = i;
    this.jdField_b_of_type_Int = j;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    if (this.jdField_a_of_type_Boolean) {
      ThreadManager.postImmediately(new HeartCombolEffectView.4(this), null, true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramMessage = (HeartCombolEffectView.OneHeartTracker)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (l1 - l2 >= paramMessage.jdField_a_of_type_Int)
        {
          if (!paramMessage.jdField_a_of_type_Boolean)
          {
            int k;
            if (this.jdField_b_of_type_Boolean)
            {
              j = paramMessage.jdField_b_of_type_Int;
              k = paramMessage.d;
            }
            else
            {
              j = this.jdField_a_of_type_Int - paramMessage.jdField_b_of_type_Int;
              k = this.jdField_a_of_type_Int - paramMessage.d;
            }
            paramMessage.jdField_a_of_type_AndroidWidgetScroller.startScroll(j, 0, k - j, 0, 1100);
            paramMessage.jdField_b_of_type_AndroidWidgetScroller.startScroll(0, paramMessage.c, 0, paramMessage.e - paramMessage.c, 1100);
            paramMessage.jdField_a_of_type_Boolean = true;
          }
          if (paramMessage.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
          {
            paramMessage.jdField_b_of_type_AndroidWidgetScroller.computeScrollOffset();
            if ((paramMessage.jdField_a_of_type_AndroidWidgetScroller.timePassed() > paramMessage.h) && (paramMessage.jdField_b_of_type_Float == paramMessage.jdField_a_of_type_Float)) {
              paramMessage.jdField_a_of_type_AndroidAnimationValueAnimator.start();
            }
            paramMessage.f = paramMessage.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
            paramMessage.g = paramMessage.jdField_b_of_type_AndroidWidgetScroller.getCurrY();
          }
        }
        i += 1;
      }
      i = this.jdField_a_of_type_Int;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.d;
      float f = ((Float)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).floatValue();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.jdField_a_of_type_Boolean) && ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.f <= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.d)) && ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.f >= i - j)) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.jdField_b_of_type_Boolean) || (f <= 0.001D)))
      {
        if (this.jdField_a_of_type_Boolean) {
          HapticManager.a().c(this.c);
        }
        this.c = 0;
        return false;
      }
      postInvalidate();
      paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramMessage.what = 2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 25L);
      return false;
    }
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramMessage.hasNext())
    {
      HeartCombolEffectView.OneHeartTracker localOneHeartTracker = (HeartCombolEffectView.OneHeartTracker)paramMessage.next();
      localOneHeartTracker.jdField_a_of_type_Boolean = false;
      localOneHeartTracker.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      localOneHeartTracker.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
      localOneHeartTracker.f = localOneHeartTracker.jdField_b_of_type_Int;
      localOneHeartTracker.g = localOneHeartTracker.c;
      localOneHeartTracker.jdField_b_of_type_Float = localOneHeartTracker.jdField_a_of_type_Float;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.c = HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsBitmap == null)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      HeartCombolEffectView.OneHeartTracker localOneHeartTracker = (HeartCombolEffectView.OneHeartTracker)localIterator.next();
      if (localOneHeartTracker.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.d = ((int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * localOneHeartTracker.jdField_b_of_type_Float / 2.0F));
        this.e = ((int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * localOneHeartTracker.jdField_b_of_type_Float / 2.0F));
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localOneHeartTracker.f, localOneHeartTracker.g);
        this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(localOneHeartTracker.jdField_b_of_type_Float, localOneHeartTracker.jdField_b_of_type_Float);
        if (this.jdField_b_of_type_Boolean) {
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
        } else {
          paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView
 * JD-Core Version:    0.7.0.1
 */