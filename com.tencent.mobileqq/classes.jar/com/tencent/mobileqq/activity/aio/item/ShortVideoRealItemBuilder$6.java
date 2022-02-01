package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;

class ShortVideoRealItemBuilder$6
  implements MessageProgressView.AnimRunnableListener
{
  ShortVideoRealItemBuilder$6(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, ShortVideoRealItemBuilder.Holder paramHolder) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if (paramString.equals(localStringBuilder.toString())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */