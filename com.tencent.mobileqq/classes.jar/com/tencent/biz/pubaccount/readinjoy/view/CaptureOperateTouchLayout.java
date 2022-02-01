package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class CaptureOperateTouchLayout
  extends FrameLayout
{
  public static int a;
  private static int jdField_b_of_type_Int = -1;
  private float jdField_a_of_type_Float = jdField_b_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(BaseApplication.getContext());
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CaptureOperateTouchLayout.OnCaptureOperateCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout$OnCaptureOperateCallback = null;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private int d;
  private int e = jdField_b_of_type_Int;
  private int f = jdField_b_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 200;
  }
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(float paramFloat)
  {
    return (int)(this.d * paramFloat);
  }
  
  private int a(float paramFloat, boolean paramBoolean)
  {
    return (int)Math.min(Math.max(0, b(paramFloat, paramBoolean)), this.jdField_a_of_type_Long);
  }
  
  private void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i = getWidth();
    int j = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    a(paramInt / (i - j), paramBoolean);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getRawX() >= this.jdField_a_of_type_AndroidWidgetImageView.getX()) && (paramMotionEvent.getRawX() <= this.jdField_a_of_type_AndroidWidgetImageView.getX() + this.jdField_a_of_type_AndroidWidgetImageView.getWidth())) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    a((int)(paramMotionEvent.getRawX() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth() / 3), false);
  }
  
  private float b()
  {
    return ((View)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).getRight() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
  }
  
  private int b(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (int)((paramFloat - this.jdField_a_of_type_Float) * this.f + this.e);
    }
    return (int)((float)this.jdField_a_of_type_Long * paramFloat) / 1000 * 1000;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout$OnCaptureOperateCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout$OnCaptureOperateCallback.a(a());
    }
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    float f1 = (getWidth() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth()) * paramFloat;
    this.jdField_b_of_type_Float = paramFloat;
    this.c = a(paramFloat, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureOperateTouchLayout", 2, "onIndicatorChange percent:" + paramFloat + " progressX:" + f1 + " duration:" + this.jdField_a_of_type_Long + " videoSeekPosition:" + this.c + " longPressStartVideoSeekPercent:" + this.jdField_a_of_type_Float);
    }
    int i = (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() - this.jdField_a_of_type_AndroidWidgetTextView.getWidth()) / 2;
    this.jdField_a_of_type_AndroidWidgetImageView.setX(f1);
    this.jdField_a_of_type_AndroidWidgetTextView.setX(f1 + i);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(this.c / 1000));
    b();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      a(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX() / b(), this.jdField_a_of_type_Boolean);
      invalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getAction() == 0) {
      a(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setDuration(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setOnCaptureOperateCallback(CaptureOperateTouchLayout.OnCaptureOperateCallback paramOnCaptureOperateCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout$OnCaptureOperateCallback = paramOnCaptureOperateCallback;
  }
  
  public void setup(ImageView paramImageView, TextView paramTextView1, TextView paramTextView2, VideoMeasureScaleView paramVideoMeasureScaleView, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView = paramVideoMeasureScaleView;
    this.d = paramInt;
    this.f = (jdField_a_of_type_Int * paramInt);
    paramImageView.setOnTouchListener(new CaptureOperateTouchLayout.IndicatorTouchListener(this, new CaptureOperateTouchLayout.1(this, paramTextView2, paramVideoMeasureScaleView, paramImageView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout
 * JD-Core Version:    0.7.0.1
 */