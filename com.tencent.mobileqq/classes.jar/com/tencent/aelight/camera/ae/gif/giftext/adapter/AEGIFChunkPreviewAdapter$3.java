package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;

class AEGIFChunkPreviewAdapter$3
  implements Observer<String>
{
  AEGIFChunkPreviewAdapter$3(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals("")) {}
    }
    else
    {
      str = HardCodeUtil.a(2131700185);
    }
    paramString = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    int i;
    if (str.indexOf('\n') > 0) {
      i = AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter) * 3 / 10;
    } else {
      i = AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter) * 11 / 50;
    }
    paramString.height = i;
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setTextSize(DisplayUtil.c(AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter), 23.0F));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(DisplayUtil.a(AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter), 2.0F));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setText(str);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setLayoutParams(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.3
 * JD-Core Version:    0.7.0.1
 */