package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;

class AEGIFStickerAdapter$1
  implements View.OnClickListener
{
  AEGIFStickerAdapter$1(AEGIFStickerAdapter paramAEGIFStickerAdapter, int paramInt, AEMaterialWrapper paramAEMaterialWrapper) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("[ItemView.onClick] position=");
    paramView.append(this.jdField_a_of_type_Int);
    paramView.append(", mClickedPos=");
    paramView.append(AEGIFStickerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter));
    paramView.append(", mActivatedPos=");
    paramView.append(AEGIFStickerAdapter.b(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter));
    AEQLog.a("AEGIFStickerAdapter", paramView.toString());
    AEGIFStickerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter, this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialWrapper.jdField_a_of_type_Int;
    AEGIFStickerAdapter.OnMaterialClickCallback localOnMaterialClickCallback1 = null;
    paramView = null;
    if ((i != 2) && (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialWrapper.b != 1))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialWrapper.jdField_a_of_type_Int == 0)
      {
        AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_NOT_DOWNLOAD");
        if (AEGIFStickerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter) != null)
        {
          localOnMaterialClickCallback1 = AEGIFStickerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter);
          if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialWrapper.b != 1) {
            paramView = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialWrapper;
          }
          localOnMaterialClickCallback1.a(paramView);
        }
      }
      else
      {
        AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADING");
      }
    }
    else
    {
      AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADED");
      AEGIFStickerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int != AEGIFStickerAdapter.b(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter))
      {
        AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] position != mActivatedPos");
        i = AEGIFStickerAdapter.b(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter);
        AEGIFStickerAdapter.b(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter.notifyItemChanged(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter.notifyItemChanged(i);
        if (AEGIFStickerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter) != null)
        {
          AEGIFStickerAdapter.OnMaterialClickCallback localOnMaterialClickCallback2 = AEGIFStickerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter);
          if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialWrapper.b == 1) {
            paramView = localOnMaterialClickCallback1;
          } else {
            paramView = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialWrapper;
          }
          localOnMaterialClickCallback2.a(paramView);
        }
        AEBaseReportParam.a().r(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialWrapper.jdField_a_of_type_JavaLangString);
        AEBaseDataReporter.a().al();
        paramView = new StringBuilder();
        paramView.append("[ItemView.onClick] gifMaterialClick, id=");
        paramView.append(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialWrapper.jdField_a_of_type_JavaLangString);
        AEQLog.b("AEGIFStickerAdapter", paramView.toString());
        return;
      }
      AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] position == mActivatedPos");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFStickerAdapter.1
 * JD-Core Version:    0.7.0.1
 */