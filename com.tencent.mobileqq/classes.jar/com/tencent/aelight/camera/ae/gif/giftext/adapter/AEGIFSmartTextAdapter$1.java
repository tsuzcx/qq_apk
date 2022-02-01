package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFSmartTextData;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import java.util.ArrayList;
import java.util.List;

class AEGIFSmartTextAdapter$1
  implements View.OnClickListener
{
  AEGIFSmartTextAdapter$1(AEGIFSmartTextAdapter paramAEGIFSmartTextAdapter, AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder paramQIMGIFSmartTextViewHolder, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (AEGIFSmartTextAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter) != this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter$QIMGIFSmartTextViewHolder.getLayoutPosition()) {
      AEBaseDataReporter.a().k(this.jdField_a_of_type_JavaLangString);
    }
    if ((AEGIFSmartTextAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter) == -1) && (TextUtils.isEmpty(AEGIFSmartTextAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter).a())))
    {
      AEGIFSmartTextAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter).a(this.jdField_a_of_type_JavaLangString, ((AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.a.get(0)).jdField_a_of_type_JavaLangString, ((AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.a.get(0)).b);
      AEGIFSmartTextAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter).a(true, false);
    }
    else
    {
      AEGIFSmartTextAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter).a(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter.a();
    AEGIFSmartTextAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter, this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter$QIMGIFSmartTextViewHolder.getLayoutPosition());
    ((AEGIFSmartTextData)AEGIFSmartTextAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter).get(AEGIFSmartTextAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter) - 1)).a(true);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter$QIMGIFSmartTextViewHolder.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFSmartTextAdapter.1
 * JD-Core Version:    0.7.0.1
 */