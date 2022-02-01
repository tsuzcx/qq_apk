package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.image.URLImageView;

public class TransitionProviderGridAdapter$ConvertViewTag
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TransitionCategoryItem jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTransitionCategoryItem;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  boolean jdField_a_of_type_Boolean = false;
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTransitionCategoryItem != null))
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          localView.setBackgroundResource(2130844496);
          return;
        }
        localView.setBackgroundResource(2130844515);
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localView.setBackgroundResource(0);
        return;
      }
      localView.setBackgroundResource(2130844512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.TransitionProviderGridAdapter.ConvertViewTag
 * JD-Core Version:    0.7.0.1
 */