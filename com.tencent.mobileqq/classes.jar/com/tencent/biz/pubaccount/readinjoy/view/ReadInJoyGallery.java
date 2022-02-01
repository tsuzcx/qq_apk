package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.widget.Gallery;

public class ReadInJoyGallery
  extends Gallery
{
  public static final String a;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(getContext());
  protected ReadInJoyGallery.OnDoubleTapListener a;
  private ReadInJoyGallery.OnScrollChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$OnScrollChangeListener;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  boolean jdField_b_of_type_Boolean = false;
  private boolean j = false;
  private boolean k = false;
  private int jdField_l_of_type_Int = 1;
  private boolean jdField_l_of_type_Boolean = false;
  private boolean m;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas." + ReadInJoyGallery.class.getSimpleName();
  }
  
  public ReadInJoyGallery(Context paramContext)
  {
    super(paramContext);
    F_();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    F_();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    F_();
  }
  
  protected void F_()
  {
    setMaxScale(2.147484E+009F);
    this.jdField_a_of_type_Int = (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 3);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.a(paramInt1, paramInt2, paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$OnScrollChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$OnScrollChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    case 3: 
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    do
    {
      return bool;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.k = false;
      break;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          super.dispatchTouchEvent(paramMotionEvent);
          return true;
        }
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      f1 = paramMotionEvent.getX() - this.jdField_a_of_type_Float;
      f2 = paramMotionEvent.getY() - this.jdField_b_of_type_Float;
    } while ((Math.abs(f1) <= this.jdField_a_of_type_Int) && (Math.abs(f2) <= this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Boolean = true;
    if (Math.abs(f1) > Math.abs(f2))
    {
      this.jdField_b_of_type_Boolean = true;
      this.k = true;
      if (f1 < 0.0F) {}
      for (int i = 1;; i = 2)
      {
        this.jdField_l_of_type_Int = i;
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
      }
    }
    if (this.d)
    {
      this.jdField_b_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    this.jdField_b_of_type_Boolean = false;
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void forceLayout()
  {
    super.forceLayout();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$OnDoubleTapListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$OnDoubleTapListener.a();
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.m)
    {
      if (paramMotionEvent.getPointerCount() >= 2) {}
      do
      {
        do
        {
          return false;
          switch (paramMotionEvent.getAction())
          {
          case 3: 
          default: 
            return super.onInterceptTouchEvent(paramMotionEvent);
          case 0: 
            onTouchEvent(paramMotionEvent);
            return false;
          case 1: 
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.k) {
                return super.onInterceptTouchEvent(paramMotionEvent);
              }
              onTouchEvent(paramMotionEvent);
              return false;
            }
            paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
            paramMotionEvent.setAction(3);
            onTouchEvent(paramMotionEvent);
            return false;
          }
        } while (!this.jdField_a_of_type_Boolean);
        if (!this.m) {
          break;
        }
      } while ((!this.k) || (this.jdField_l_of_type_Int != 2));
      return super.onInterceptTouchEvent(paramMotionEvent);
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void setIsListPage(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setOnDoubleTapListener(ReadInJoyGallery.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$OnDoubleTapListener = paramOnDoubleTapListener;
  }
  
  public void setOnScrollChangeListener(ReadInJoyGallery.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$OnScrollChangeListener = paramOnScrollChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyGallery
 * JD-Core Version:    0.7.0.1
 */