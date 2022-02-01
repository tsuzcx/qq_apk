package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class AEGIFTextColorAdapter$1
  implements View.OnClickListener
{
  AEGIFTextColorAdapter$1(AEGIFTextColorAdapter paramAEGIFTextColorAdapter, int paramInt, AEGIFTextColorAdapter.TextEditColorViewHolder paramTextEditColorViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != AEGIFTextColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter))
    {
      paramView = (AEGIFTextColorAdapter.TextEditColorViewHolder)AEGIFTextColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter).findViewHolderForAdapterPosition(AEGIFTextColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter));
      if (paramView != null) {
        paramView.a(false);
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter$TextEditColorViewHolder.a(true);
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter.a(this.jdField_a_of_type_Int);
      if (AEGIFTextColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter) != null) {
        AEGIFTextColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter).setTextColor(Color.parseColor(AEGIFTextColorAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFTextColorAdapter)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFTextColorAdapter.1
 * JD-Core Version:    0.7.0.1
 */