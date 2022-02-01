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

class ChatSettingActivity$6
  extends ProtoUtils.TroopProtocolObserver
{
  ChatSettingActivity$6(ChatSettingActivity paramChatSettingActivity, String paramString) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = ChatSettingActivity.e(this.b);
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
        localObject = ChatSettingActivity.e(this.b);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pb parse error: ");
        localStringBuilder.append(paramArrayOfByte);
        QLog.e((String)localObject, 1, localStringBuilder.toString());
      }
      paramInt = paramBundle.ret_code.get();
      paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
      paramBundle = ChatSettingActivity.e(this.b);
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
          paramBundle.append(ChatSettingActivity.e(this.b));
          paramBundle.append("Q.nearby.follow");
          paramBundle = paramBundle.toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendOperateFollowUser,targetUin:");
          ((StringBuilder)localObject).append(ChatSettingActivity.a(this.b));
          ((StringBuilder)localObject).append(", op:");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append(", errMsg:");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
          QQToast.makeText(this.b, 1, paramArrayOfByte, 0).show(this.b.getTitleBarHeight());
        }
      }
      else
      {
        paramArrayOfByte = this.b;
        paramArrayOfByte.b ^= true;
        ChatSettingActivity.f(this.b);
        if (this.b.b)
        {
          ChatSettingActivity.a(this.b, false);
          ((ShieldMsgManger)this.b.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(0, 1, ChatSettingActivity.a(this.b));
          ChatSettingActivity.g(this.b).setOnCheckedChangeListener(null);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = this.b.a;
            paramBundle = new StringBuilder();
            paramBundle.append("sendOperateFollowUser, mIsShield=");
            paramBundle.append(ChatSettingActivity.h(this.b));
            paramBundle.append(", mIsFollowed=");
            paramBundle.append(this.b.b);
            QLog.d(paramArrayOfByte, 2, paramBundle.toString());
          }
          ChatSettingActivity.i(this.b);
          ChatSettingActivity.g(this.b).setOnCheckedChangeListener(this.b);
        }
        paramArrayOfByte = this.b;
        if (this.a.equals("1")) {
          paramInt = 2131892070;
        } else {
          paramInt = 2131892078;
        }
        QQToast.makeText(paramArrayOfByte, 2, paramArrayOfByte.getString(paramInt), 0).show(this.b.getTitleBarHeight());
        return;
      }
    }
    paramArrayOfByte = this.b;
    if (this.a.equals("1")) {
      paramInt = 2131892069;
    } else {
      paramInt = 2131892077;
    }
    paramArrayOfByte = paramArrayOfByte.getString(paramInt);
    QQToast.makeText(this.b, 1, paramArrayOfByte, 0).show(this.b.getTitleBarHeight());
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append(ChatSettingActivity.e(this.b));
      paramBundle.append("Q.nearby.follow");
      paramBundle = paramBundle.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendOperateFollowUser,targetUin:");
      ((StringBuilder)localObject).append(ChatSettingActivity.a(this.b));
      ((StringBuilder)localObject).append(", op:");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(", re:");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.6
 * JD-Core Version:    0.7.0.1
 */