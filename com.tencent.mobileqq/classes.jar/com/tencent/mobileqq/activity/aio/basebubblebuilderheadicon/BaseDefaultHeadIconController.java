package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.avatardoubletap.TouchEventHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseDefaultHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000) || (paramInt == 0) || (paramInt == 1005) || (paramInt == 1001) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 10004) || (paramInt == 1004) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010) || (paramInt == 1011) || (paramInt == 1020) || (paramInt == 1021) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1036) || (paramInt == 1025) || (paramInt == 10002) || (paramInt == 1022);
  }
  
  protected void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar);
  }
  
  protected void c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
    if (((!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal()) && (a(i))) || (i == 10008) || (i == 10009))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin))
      {
        String str1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
        String str2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
        ThreadManager.executeOnSubThread(new BaseDefaultHeadIconController.ProcessMemberNickTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, str1, str2, i, this.jdField_a_of_type_AndroidViewView$OnLongClickListener));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseBubbleBuilder", 2, "AppSetting.enableTalkBack = " + AppSetting.d);
    }
    if (AppSetting.d)
    {
      String str2 = "";
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop != 1)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop != 3000) {
          if (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            break label151;
          }
        }
      }
    }
    label151:
    for (String str1 = HardCodeUtil.a(2131701023);; str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + HardCodeUtil.a(2131701026))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgtype == -3006) {
        str1 = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697673), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
      }
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setContentDescription(str1);
      return;
    }
  }
  
  protected void g()
  {
    new TouchEventHandler().a(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.BaseDefaultHeadIconController
 * JD-Core Version:    0.7.0.1
 */