package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.MessageObserver;
import mqq.os.MqqHandler;

class AddFriendHelper$7
  extends MessageObserver
{
  AddFriendHelper$7(AddFriendHelper paramAddFriendHelper) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.e();
      }
    }
  }
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().post(new AddFriendHelper.7.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AddFriendHelper.7
 * JD-Core Version:    0.7.0.1
 */