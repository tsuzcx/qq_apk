package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$1
  implements View.OnClickListener
{
  WatermarkEditListAdapter$1(WatermarkEditListAdapter paramWatermarkEditListAdapter, WMElement paramWMElement, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder) {}
  
  public void onClick(View paramView)
  {
    if ("CHECK_IN".equals(this.jdField_a_of_type_OrgLightBeanWMElement.type))
    {
      WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.a.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.1
 * JD-Core Version:    0.7.0.1
 */