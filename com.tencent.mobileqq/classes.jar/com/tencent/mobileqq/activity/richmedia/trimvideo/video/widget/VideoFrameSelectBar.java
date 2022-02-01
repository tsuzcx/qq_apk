package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.mobileqq.utils.ViewUtils;

public class VideoFrameSelectBar
  extends View
  implements FrameParent, FramesProcessor.OnMoveListener, RangeProcessor.OnRangeChangeListener
{
  private static final int jdField_a_of_type_Int = ViewUtils.a(13.0F);
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private FramesProcessor jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor;
  private RangeProcessor jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor;
  private VideoFrameSelectBar.OnFramesClipChangeListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$OnFramesClipChangeListener;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 3000;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean = false;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h;
  
  public VideoFrameSelectBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private float a(float paramFloat)
  {
    return paramFloat / this.jdField_d_of_type_Float * this.jdField_c_of_type_Int;
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor.a(paramMotionEvent);
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor.a(paramMotionEvent);
    }
  }
  
  private void e()
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaLangString = String.format("%.1f''", new Object[] { Float.valueOf(this.g / 1000.0F) });
    this.h = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
    VideoFrameSelectBar.OnFramesClipChangeListener localOnFramesClipChangeListener = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$OnFramesClipChangeListener;
    if (localOnFramesClipChangeListener != null) {
      localOnFramesClipChangeListener.a(this.g);
    }
  }
  
  public float a()
  {
    return this.e + this.f;
  }
  
  void a()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.f = a((int)(paramFloat1 - this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor.b()));
    this.g = a(paramFloat2 - paramFloat1);
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor.a((int)paramFloat1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor.b((int)paramFloat2);
    invalidate();
    VideoFrameSelectBar.OnFramesClipChangeListener localOnFramesClipChangeListener = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$OnFramesClipChangeListener;
    if (localOnFramesClipChangeListener != null) {
      localOnFramesClipChangeListener.a((int)a(), (int)b());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.e = a(paramFloat1);
    f();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor;
    if (localObject != null) {
      ((RangeProcessor)localObject).a(paramFloat2, paramFloat3);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$OnFramesClipChangeListener;
    if (localObject != null) {
      ((VideoFrameSelectBar.OnFramesClipChangeListener)localObject).a((int)a(), (int)b());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    int i;
    if (paramInt < 12000)
    {
      this.jdField_c_of_type_Int = 2000;
      i = (int)Math.ceil(paramInt * 1.0F / 2000.0F);
    }
    else
    {
      this.jdField_c_of_type_Int = (paramInt / 6);
      i = 6;
    }
    int j = getResources().getDisplayMetrics().widthPixels;
    float f1 = j * 0.925F / 6.0F;
    this.jdField_d_of_type_Float = f1;
    this.jdField_c_of_type_Float = f1;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor = new RangeProcessor(this, this.jdField_d_of_type_Float, this.jdField_c_of_type_Float, i, this.jdField_c_of_type_Int, j, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor.a(this);
    this.g = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor.c());
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor = new FramesProcessor(this, paramString, paramInt, i, this.jdField_d_of_type_Float, this.jdField_c_of_type_Float, j, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor.b(), this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor.a(this);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public float b()
  {
    return this.e + this.f + this.g;
  }
  
  void b()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor;
    if (localObject != null) {
      ((RangeProcessor)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor;
    if (localObject != null) {
      ((FramesProcessor)localObject).b();
    }
    this.jdField_d_of_type_Boolean = false;
    this.e = 0.0F;
    this.f = 0.0F;
    this.g = 0.0F;
  }
  
  public boolean c()
  {
    FramesProcessor localFramesProcessor = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFramesProcessor != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor == null) {
        return false;
      }
      if (!localFramesProcessor.a())
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor.a()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor;
    if (localObject != null) {
      ((RangeProcessor)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor;
    if (localObject != null) {
      ((FramesProcessor)localObject).b();
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_d_of_type_Boolean = false;
    this.e = 0.0F;
    this.f = 0.0F;
    this.g = 0.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor == null) {
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(40.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      paramCanvas.translate(0.0F, jdField_a_of_type_Int + 50);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor;
      if (localObject != null) {
        ((FramesProcessor)localObject).a(paramCanvas);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor;
      if (localObject != null) {
        ((RangeProcessor)localObject).a(paramCanvas);
      }
      paramCanvas.translate(0.0F, -jdField_a_of_type_Int - 50);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor != null))
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), (int)(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor.a() + 50.0F + jdField_a_of_type_Int));
      return;
    }
    setMeasuredDimension(0, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = isEnabled();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor == null) {
        return false;
      }
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              if (b())
              {
                b();
                a(paramMotionEvent);
                setPressed(false);
              }
              invalidate();
            }
          }
          else if (b())
          {
            a(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > this.jdField_b_of_type_Int)
          {
            setPressed(true);
            invalidate();
            a();
            a(paramMotionEvent);
            e();
          }
        }
        else
        {
          if (b())
          {
            a(paramMotionEvent);
            b();
            setPressed(false);
          }
          else
          {
            a();
            a(paramMotionEvent);
            b();
          }
          invalidate();
        }
      }
      else
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float - 50.0F);
        this.jdField_b_of_type_Boolean = false;
        if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
          return super.onTouchEvent(paramMotionEvent);
        }
        setPressed(true);
        invalidate();
        a();
        a(paramMotionEvent);
        e();
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Boolean) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void postInvalidate()
  {
    super.postInvalidate();
  }
  
  public void setOnFramesClipChangeListener(VideoFrameSelectBar.OnFramesClipChangeListener paramOnFramesClipChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$OnFramesClipChangeListener = paramOnFramesClipChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */