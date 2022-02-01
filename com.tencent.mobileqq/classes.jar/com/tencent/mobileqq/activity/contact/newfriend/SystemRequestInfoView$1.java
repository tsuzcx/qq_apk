package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class SystemRequestInfoView$1
  extends MessageObserver
{
  SystemRequestInfoView$1(SystemRequestInfoView paramSystemRequestInfoView) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString) {}
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString) {}
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    if (this.a.a())
    {
      paramString = this.a.getResources().getString(2131719418);
      QQToast.a(this.a.getContext(), 1, paramString, 0).b(this.a.a());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemRequestInfoView", 2, "onSendSystemMsgActionError");
    }
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemRequestInfoView", 2, "onSendSystemMsgActionFin");
    }
    if (!this.a.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemRequestInfoView", 2, "onSendSystemMsgActionFin stopProgress = fasle");
      }
      return;
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
        paramString3 = this.a.getResources().getString(2131718739);
      }
      QQToast.a(this.a.getContext(), 1, paramString3, 0).b(this.a.a());
      if (SystemMsgUtils.a(localStructMsg, paramInt3, paramString2, paramString4)) {
        SystemRequestInfoView.a(this.a).finish();
      }
    }
    else
    {
      SystemMsgUtils.a(localStructMsg, paramInt1, paramString2, paramInt2);
      paramString2 = null;
      if (paramInt1 == 1)
      {
        SystemRequestInfoView.a(this.a).finish();
        paramString1 = this.a.getResources().getString(2131692662);
      }
      else
      {
        paramString1 = paramString2;
        if (paramInt1 == 0)
        {
          paramString1 = paramString2;
          if (localStructMsg != null)
          {
            paramString1 = this.a.getResources().getString(2131692656);
            AutoRemarkActivity.a(SystemRequestInfoView.a(this.a), 1017, String.valueOf(localStructMsg.req_uin.get()), l1, null);
          }
        }
      }
      QQToast.a(this.a.getContext(), 2, paramString1, 0).b(this.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemRequestInfoView.1
 * JD-Core Version:    0.7.0.1
 */