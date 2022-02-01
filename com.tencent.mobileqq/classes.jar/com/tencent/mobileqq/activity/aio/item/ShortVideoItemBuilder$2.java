package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;

class ShortVideoItemBuilder$2
  implements MessageProgressView.AnimRunnableListener
{
  ShortVideoItemBuilder$2(ShortVideoItemBuilder paramShortVideoItemBuilder, ShortVideoItemBuilder.Holder paramHolder) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if (paramString.equals(localStringBuilder.toString())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */