package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.ISingleFileSaveCallBack;

class ShortVideoItemBuilder$3
  implements ISingleFileSaveCallBack
{
  ShortVideoItemBuilder$3(ShortVideoItemBuilder paramShortVideoItemBuilder, String paramString, ShortVideoItemBuilder.Holder paramHolder) {}
  
  public void a()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
    }
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder, paramFileSaveResult, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder, this);
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder, paramInt, false);
  }
  
  public void b(FileSaveResult paramFileSaveResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */