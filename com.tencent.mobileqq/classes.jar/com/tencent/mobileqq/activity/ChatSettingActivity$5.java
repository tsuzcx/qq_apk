package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;

class ChatSettingActivity$5
  extends ProtoUtils.TroopProtocolObserver
{
  ChatSettingActivity$5(ChatSettingActivity paramChatSettingActivity, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity), 2, "errorCode = [" + paramInt + "], bundle = [" + paramBundle + "]");
    }
    if (paramInt == 0)
    {
      paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.ret_code.get();
        paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
        QLog.i(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity), 1, "ret_code: " + paramInt + ", err_msg: " + paramArrayOfByte);
        if (paramInt != 0)
        {
          if (!QLog.isColorLevel()) {
            break label498;
          }
          QLog.d(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + ", op:" + this.jdField_a_of_type_JavaLangString + ", errMsg:" + paramArrayOfByte);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, 1, paramArrayOfByte, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          QLog.e(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity), 1, "pb parse error: " + paramArrayOfByte);
        }
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean) {
          break label486;
        }
      }
      boolean bool = true;
      paramArrayOfByte.jdField_a_of_type_Boolean = bool;
      ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean)
      {
        ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, false);
        ((ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(0, 1, ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
        ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity).setOnCheckedChangeListener(null);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_JavaLangString, 2, "sendOperateFollowUser, mIsShield=" + ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + ", mIsFollowed=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean);
        }
        ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
        ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity).setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
      if (this.jdField_a_of_type_JavaLangString.equals("1")) {}
      for (paramInt = 2131694426;; paramInt = 2131694434)
      {
        QQToast.a(paramArrayOfByte, 2, paramBundle.getString(paramInt), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
        return;
        label486:
        bool = false;
        break;
      }
    }
    label498:
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
    if (this.jdField_a_of_type_JavaLangString.equals("1")) {}
    for (paramInt = 2131694425;; paramInt = 2131694433)
    {
      paramArrayOfByte = paramArrayOfByte.getString(paramInt);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, 1, paramArrayOfByte, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + ", op:" + this.jdField_a_of_type_JavaLangString + ", re:" + paramArrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */