package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.giftext.DrawableImageView;

class AEGIFChunkPreviewAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AEGIFOutlineTextView jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView;
  private DrawableImageView jdField_a_of_type_ComTencentAelightCameraAeGifGiftextDrawableImageView;
  private ImageView b;
  
  public AEGIFChunkPreviewAdapter$ViewHolder(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, View paramView, String paramString)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064121997));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2064122525));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextDrawableImageView = ((DrawableImageView)paramView.findViewById(2064121899));
    this.b = ((ImageView)paramView.findViewById(2064121900));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)paramView.findViewById(2064122466));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setFontId(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838037);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2064056588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */