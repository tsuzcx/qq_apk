package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class AddRequestActivity$12
  extends MessageObserver
{
  AddRequestActivity$12(AddRequestActivity paramAddRequestActivity) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if ((this.a.g != null) && (this.a.g.isShowing())) {
      this.a.dismissDialog(2);
    }
    paramString = this.a;
    paramString.showToast(2130839806, paramString.getString(2131916595));
  }
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((this.a.g != null) && (this.a.g.isShowing())) {
      this.a.dismissDialog(2);
    }
    paramString = this.a;
    paramString.showToast(2130839806, paramString.getString(2131916581));
  }
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    if (AddRequestActivity.j(this.a))
    {
      paramString = this.a.getString(2131916977);
      QQToast.makeText(this.a, 1, paramString, 0).show(this.a.getTitleBarHeight());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionError");
    }
    AddRequestActivity.a(this.a, false);
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (!AddRequestActivity.h(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionFin");
      }
      return;
    }
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d("Q.systemmsg.AddRequestActivity", 2, String.format("onSendSystemMsgActionFin isSuc=%s actionType=%s msgDetail=%s resultCode=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) }));
    }
    long l2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        l1 = Long.parseLong(paramString1);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        l1 = l2;
      }
    }
    structmsg.StructMsg localStructMsg = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
    if (!paramBoolean)
    {
      if (TextUtils.isEmpty(paramString3)) {
        paramString3 = this.a.getResources().getString(2131916242);
      }
      QQToast.makeText(this.a, 1, paramString3, 0).show(this.a.getTitleBarHeight());
      if (SystemMsgUtils.a(localStructMsg, paramInt3, paramString2, paramString4)) {
        this.a.finish();
      }
    }
    else
    {
      SystemMsgUtils.a(localStructMsg, paramInt1, paramString2, paramInt2);
      if ((AddRequestActivity.i(this.a)) && (localStructMsg != null)) {
        localStructMsg.msg.friend_info.msg_blacklist.setHasFlag(false);
      }
      paramString2 = null;
      if (paramInt1 == 1)
      {
        this.a.setResult(-1);
        this.a.finish();
        paramString1 = this.a.getResources().getString(2131889687);
      }
      else
      {
        paramString1 = paramString2;
        if (paramInt1 == 0)
        {
          paramString1 = paramString2;
          if (localStructMsg != null)
          {
            paramString2 = this.a.getResources().getString(2131889681);
            paramString3 = new Bundle();
            paramString3.putString("base_uin", String.valueOf(localStructMsg.req_uin.get()));
            paramString1 = this.a.l;
            if (TextUtils.isEmpty(this.a.l)) {
              paramString1 = this.a.a;
            }
            paramString3.putString("base_nick", paramString1);
            paramString3.putInt("verfy_type", AddRequestActivity.f(this.a));
            paramString3.putString("verfy_msg", AddRequestActivity.g(this.a));
            if (AddRequestActivity.a(this.a) != null) {
              paramBoolean = bool1;
            } else {
              paramBoolean = false;
            }
            paramString3.putBoolean("isFromWzry", paramBoolean);
            AutoRemarkActivity.a(this.a, 0, String.valueOf(localStructMsg.req_uin.get()), l1, paramString3);
            paramString1 = paramString2;
          }
        }
      }
      QQToast.makeText(this.a, 2, paramString1, 0).show(this.a.getTitleBarHeight());
    }
    AddRequestActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.12
 * JD-Core Version:    0.7.0.1
 */