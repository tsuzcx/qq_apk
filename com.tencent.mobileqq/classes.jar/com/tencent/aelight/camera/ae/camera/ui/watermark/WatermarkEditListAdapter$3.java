package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$3
  implements View.OnClickListener
{
  WatermarkEditListAdapter$3(WatermarkEditListAdapter paramWatermarkEditListAdapter, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder, WMElement paramWMElement) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter).getWindowToken(), 0);
    WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter).setTextColor(-1);
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter;
    WatermarkEditListAdapter.a(paramView, WatermarkEditListAdapter.a(paramView));
    WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.a);
    if (AECameraEntryManager.k(WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter).getIntent())) {
      WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter).setTextColor(WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter).getResources().getColor(2063925310));
    } else {
      WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter).setTextColor(WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter).getResources().getColor(2063925311));
    }
    WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_OrgLightBeanWMElement);
    if (WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter) != null)
    {
      paramView = WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_OrgLightBeanWMElement.getInnerValue());
      WatermarkEditListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter).a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.3
 * JD-Core Version:    0.7.0.1
 */