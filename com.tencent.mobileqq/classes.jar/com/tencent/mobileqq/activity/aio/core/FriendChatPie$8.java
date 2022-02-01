package com.tencent.mobileqq.activity.aio.core;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

class FriendChatPie$8
  extends StrangerObserver
{
  FriendChatPie$8(FriendChatPie paramFriendChatPie) {}
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (((String)paramList.next()).equals(this.a.ah.b))
        {
          i = 1;
          break label61;
        }
      }
    }
    int i = 0;
    label61:
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, String.format("be deleted, current uin: %s", new Object[] { this.a.ah.b }));
      }
      this.a.L();
    }
  }
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.a.f.isFinishing()) {
      return;
    }
    if (this.a.ao != null) {
      this.a.ao.dismiss();
    }
    if (paramBoolean)
    {
      paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
      paramBoolean = false;
      while (paramPBRepeatMessageField.hasNext()) {
        if (String.valueOf(((oidb_0x5d4.DelResult)paramPBRepeatMessageField.next()).uin.get()).equalsIgnoreCase(this.a.ah.b)) {
          paramBoolean = true;
        }
      }
      if (!paramBoolean) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        paramPBRepeatMessageField = this.a.c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StrangerObserver : onDelete , result=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d(paramPBRepeatMessageField, 2, ((StringBuilder)localObject).toString());
      }
      paramPBRepeatMessageField = new ArrayList();
      paramPBRepeatMessageField.add(this.a.ah.b);
      ChatActivityFacade.a(this.a.d, BaseApplication.getContext(), paramPBRepeatMessageField);
      paramPBRepeatMessageField = this.a.d.getProxyManager().g();
      if (paramPBRepeatMessageField != null)
      {
        localObject = paramPBRepeatMessageField.b(this.a.ah.b, this.a.ah.a);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.a.c, 4, "StrangerObserver, delete Recent user");
        }
        paramPBRepeatMessageField.a((RecentUser)localObject);
      }
      QQToast.makeText(this.a.f, 2, this.a.f.getResources().getString(2131916693), 0).show();
      if (this.a.ap) {
        this.a.f.setResult(-1);
      }
      this.a.L();
      return;
    }
    QQToast.makeText(this.a.f, this.a.f.getResources().getString(2131916691), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.8
 * JD-Core Version:    0.7.0.1
 */