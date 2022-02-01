package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import java.util.Set;

class AEGIFChunkPreviewAdapter$1
  implements View.OnClickListener
{
  AEGIFChunkPreviewAdapter$1(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, AEGIFPreviewWrapper paramAEGIFPreviewWrapper, int paramInt, AEGIFChunkPreviewAdapter.ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFPreviewWrapper.jdField_a_of_type_Int == 13)
    {
      boolean bool = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFPreviewWrapper.a() ^ true;
      if (bool)
      {
        AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter).add(Integer.valueOf(this.jdField_a_of_type_Int));
        AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter, true);
      }
      else
      {
        AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter).remove(Integer.valueOf(this.jdField_a_of_type_Int));
        if (AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter).size() < 1) {
          AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter, false);
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFPreviewWrapper.a(bool);
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter$ViewHolder.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.1
 * JD-Core Version:    0.7.0.1
 */