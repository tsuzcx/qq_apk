package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.download.AEDownloadStateWrapper;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;
import com.tencent.aelight.camera.ae.gif.video.MaterialWrapper;
import com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class AEGIFChunkPreviewFragment$6$1
  implements Observer<AEDownloadStateWrapper>
{
  AEGIFChunkPreviewFragment$6$1(AEGIFChunkPreviewFragment.6 param6, RecognizedEmotionBean paramRecognizedEmotionBean) {}
  
  public void a(@Nullable AEDownloadStateWrapper paramAEDownloadStateWrapper)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if (paramAEDownloadStateWrapper != null)
    {
      if (AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a) == null) {
        return;
      }
      int i = this.jdField_a_of_type_ComTencentAelightCameraAeGifRecognizedEmotionBean.jdField_a_of_type_Int + 1;
      while (i < AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a).size())
      {
        AEGIFPreviewWrapper localAEGIFPreviewWrapper = (AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a).get(i);
        if ((localAEGIFPreviewWrapper != null) && (localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(paramAEDownloadStateWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localAEGIFPreviewWrapper.jdField_b_of_type_Int != paramAEDownloadStateWrapper.jdField_a_of_type_Int) {
            localAEGIFPreviewWrapper.jdField_b_of_type_Int = paramAEDownloadStateWrapper.jdField_a_of_type_Int;
          }
          if (localAEGIFPreviewWrapper.jdField_b_of_type_Int != 2) {
            break;
          }
          localAEGIFPreviewWrapper.jdField_b_of_type_JavaLangString = AEGifMaterialManager.a().a(localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          paramAEDownloadStateWrapper = new StringBuilder();
          paramAEDownloadStateWrapper.append("path===");
          paramAEDownloadStateWrapper.append(localAEGIFPreviewWrapper.jdField_b_of_type_JavaLangString);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", paramAEDownloadStateWrapper.toString() });
          paramAEDownloadStateWrapper = new MaterialWrapper();
          paramAEDownloadStateWrapper.jdField_a_of_type_Int = i;
          paramAEDownloadStateWrapper.jdField_a_of_type_JavaLangString = localAEGIFPreviewWrapper.jdField_b_of_type_JavaLangString;
          if ((localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localAEGIFPreviewWrapper.jdField_a_of_type_JavaLangString == null) || (localAEGIFPreviewWrapper.jdField_a_of_type_JavaLangString.equals(""))))
          {
            if (localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              paramAEDownloadStateWrapper.jdField_b_of_type_JavaLangString = "";
              paramAEDownloadStateWrapper.c = ((String)localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
            else
            {
              paramAEDownloadStateWrapper.jdField_b_of_type_JavaLangString = "";
              paramAEDownloadStateWrapper.c = "";
            }
          }
          else if (localAEGIFPreviewWrapper.jdField_a_of_type_JavaLangString == null) {
            paramAEDownloadStateWrapper.jdField_b_of_type_JavaLangString = "";
          } else {
            paramAEDownloadStateWrapper.jdField_b_of_type_JavaLangString = localAEGIFPreviewWrapper.jdField_a_of_type_JavaLangString;
          }
          AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a).a(paramAEDownloadStateWrapper);
          localAEGIFPreviewWrapper.jdField_a_of_type_Int = 12;
          AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a).notifyItemChanged(i);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.6.1
 * JD-Core Version:    0.7.0.1
 */