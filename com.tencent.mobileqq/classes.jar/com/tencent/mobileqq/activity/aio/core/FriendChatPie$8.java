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
        if (((String)paramList.next()).equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
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
        QLog.d(this.a.b, 2, String.format("be deleted, current uin: %s", new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
      }
      this.a.q();
    }
  }
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      return;
    }
    if (this.a.c != null) {
      this.a.c.dismiss();
    }
    if (paramBoolean)
    {
      paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
      paramBoolean = false;
      while (paramPBRepeatMessageField.hasNext()) {
        if (String.valueOf(((oidb_0x5d4.DelResult)paramPBRepeatMessageField.next()).uin.get()).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          paramBoolean = true;
        }
      }
      if (!paramBoolean) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        paramPBRepeatMessageField = this.a.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StrangerObserver : onDelete , result=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d(paramPBRepeatMessageField, 2, ((StringBuilder)localObject).toString());
      }
      paramPBRepeatMessageField = new ArrayList();
      paramPBRepeatMessageField.add(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), paramPBRepeatMessageField);
      paramPBRepeatMessageField = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      if (paramPBRepeatMessageField != null)
      {
        localObject = paramPBRepeatMessageField.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.a.b, 4, "StrangerObserver, delete Recent user");
        }
        paramPBRepeatMessageField.a((RecentUser)localObject);
      }
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719157), 0).a();
      if (this.a.j) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1);
      }
      this.a.q();
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719155), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.8
 * JD-Core Version:    0.7.0.1
 */