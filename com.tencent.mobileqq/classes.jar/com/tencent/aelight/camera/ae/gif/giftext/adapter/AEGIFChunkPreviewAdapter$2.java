package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;

class AEGIFChunkPreviewAdapter$2
  implements Observer<AEGIFTextColorConfig.SmartTextColor>
{
  AEGIFChunkPreviewAdapter$2(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable AEGIFTextColorConfig.SmartTextColor paramSmartTextColor)
  {
    if (paramSmartTextColor != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setTextColor(paramSmartTextColor.a);
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramSmartTextColor.b);
      if (paramSmartTextColor.a.equals("#ccffffff"))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setShadow(true);
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setStroke(false);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setShadow(false);
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setStroke(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.2
 * JD-Core Version:    0.7.0.1
 */