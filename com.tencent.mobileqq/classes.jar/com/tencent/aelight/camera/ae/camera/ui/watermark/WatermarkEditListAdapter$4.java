package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$4
  implements View.OnFocusChangeListener
{
  WatermarkEditListAdapter$4(WatermarkEditListAdapter paramWatermarkEditListAdapter, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder, WMElement paramWMElement) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_OrgLightBeanWMElement);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2064056412);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.4
 * JD-Core Version:    0.7.0.1
 */