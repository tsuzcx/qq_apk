package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;

class PicPreviewMoveAdapter$PicViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private RoundCorneredRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout;
  
  public PicPreviewMoveAdapter$PicViewHolder(PicPreviewMoveAdapter paramPicPreviewMoveAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2064122322));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122304));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122759));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)paramView.findViewById(2064122539));
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    int i = ViewUtils.a(3.0F);
    paramPicPreviewMoveAdapter = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout;
    float f = i;
    paramPicPreviewMoveAdapter.setRadius(f, f, f, f);
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if (paramView == this.jdField_a_of_type_ComTencentImageURLImageView)
    {
      if (PicPreviewMoveAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter) != null) {
        PicPreviewMoveAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter).a(paramView, i);
      }
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      PicPreviewMoveAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter.PicViewHolder
 * JD-Core Version:    0.7.0.1
 */