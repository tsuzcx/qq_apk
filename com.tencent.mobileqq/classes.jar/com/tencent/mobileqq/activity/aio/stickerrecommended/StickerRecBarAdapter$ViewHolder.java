package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.animation.Animator;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.item.view.ApolloIceBreakShow;

public class StickerRecBarAdapter$ViewHolder
{
  Animator jdField_a_of_type_AndroidAnimationAnimator;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  ApolloIceBreakShow jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow;
  IStickerRecEmoticon jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon;
  
  public IStickerRecEmoticon a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a().setVisibility(4);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a().setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.b())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.b();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a().getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */