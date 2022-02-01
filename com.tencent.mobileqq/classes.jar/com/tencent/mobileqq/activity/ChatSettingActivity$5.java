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
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], bundle = [");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        localObject = ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pb parse error: ");
        localStringBuilder.append(paramArrayOfByte);
        QLog.e((String)localObject, 1, localStringBuilder.toString());
      }
      paramInt = paramBundle.ret_code.get();
      paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
      paramBundle = ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ret_code: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", err_msg: ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
      if (paramInt != 0)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
          paramBundle.append("Q.nearby.follow");
          paramBundle = paramBundle.toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendOperateFollowUser,targetUin:");
          ((StringBuilder)localObject).append(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
          ((StringBuilder)localObject).append(", op:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(", errMsg:");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, 1, paramArrayOfByte, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
        }
      }
      else
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
        paramArrayOfByte.jdField_a_of_type_Boolean ^= true;
        ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean)
        {
          ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, false);
          ((ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(0, 1, ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
          ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity).setOnCheckedChangeListener(null);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_JavaLangString;
            paramBundle = new StringBuilder();
            paramBundle.append("sendOperateFollowUser, mIsShield=");
            paramBundle.append(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
            paramBundle.append(", mIsFollowed=");
            paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean);
            QLog.d(paramArrayOfByte, 2, paramBundle.toString());
          }
          ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
          ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity).setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
        }
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
        if (this.jdField_a_of_type_JavaLangString.equals("1")) {
          paramInt = 2131694391;
        } else {
          paramInt = 2131694399;
        }
        QQToast.a(paramArrayOfByte, 2, paramArrayOfByte.getString(paramInt), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
        return;
      }
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
    if (this.jdField_a_of_type_JavaLangString.equals("1")) {
      paramInt = 2131694390;
    } else {
      paramInt = 2131694398;
    }
    paramArrayOfByte = paramArrayOfByte.getString(paramInt);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, 1, paramArrayOfByte, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
      paramBundle.append("Q.nearby.follow");
      paramBundle = paramBundle.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendOperateFollowUser,targetUin:");
      ((StringBuilder)localObject).append(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
      ((StringBuilder)localObject).append(", op:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", re:");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */