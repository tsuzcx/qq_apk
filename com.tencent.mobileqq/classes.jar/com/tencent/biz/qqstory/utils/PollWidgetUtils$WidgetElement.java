package com.tencent.biz.qqstory.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import ota;

public abstract class PollWidgetUtils$WidgetElement
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ota(this);
  View jdField_a_of_type_AndroidViewView;
  PollWidgetUtils.OnSelectedChangedListener jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnSelectedChangedListener;
  public PollWidgetUtils.OnWidgetElementClickListener a;
  public PollWidgetUtils.WidgetWrapper a;
  boolean b = false;
  
  public PollWidgetUtils$WidgetElement(PollWidgetUtils.WidgetWrapper paramWidgetWrapper, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetWrapper = paramWidgetWrapper;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public Rect a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getHitRect(localRect);
    return localRect;
  }
  
  public abstract CharSequence a();
  
  public void a(float paramFloat) {}
  
  void a(PollWidgetUtils.OnSelectedChangedListener paramOnSelectedChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnSelectedChangedListener = paramOnSelectedChangedListener;
  }
  
  public void a(PollWidgetUtils.OnWidgetElementClickListener paramOnWidgetElementClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnWidgetElementClickListener = paramOnWidgetElementClickListener;
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnWidgetElementClickListener != null)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
  }
  
  public void a(CharSequence paramCharSequence) {}
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a()
  {
    return this.b;
  }
  
  public abstract CharSequence b();
  
  public void b(CharSequence paramCharSequence) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      PollWidgetUtils.OnSelectedChangedListener localOnSelectedChangedListener = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnSelectedChangedListener;
      if (localOnSelectedChangedListener != null) {
        localOnSelectedChangedListener.a(this, paramBoolean);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement
 * JD-Core Version:    0.7.0.1
 */