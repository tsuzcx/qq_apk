package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoRealItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  public ShortVideoRealItemBuilder.ChatVideoView a;
  public MessageProgressView a;
  public int e;
  public int f;
  
  public ShortVideoRealItemBuilder$Holder(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.b.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      ((QQLiveDrawable)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.b.getCurrDrawable()).recyleAndKeepPostion();
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "onMovedToScrapHeap(): recyleAndKeepPostion ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */