package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class PhotoGridAdapter$PhotoItemClickListener
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public PhotoGridAdapter$PhotoItemClickListener(PhotoGridAdapter paramPhotoGridAdapter) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter.a(paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetCheckBox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter.PhotoItemClickListener
 * JD-Core Version:    0.7.0.1
 */