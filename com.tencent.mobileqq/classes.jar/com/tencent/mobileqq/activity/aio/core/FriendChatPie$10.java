package com.tencent.mobileqq.activity.aio.core;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

class FriendChatPie$10
  extends StrangerObserver
{
  FriendChatPie$10(FriendChatPie paramFriendChatPie) {}
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (!((String)paramList.next()).equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.b, 2, String.format("be deleted, current uin: %s", new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
        }
        this.a.K();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {}
    label339:
    label340:
    for (;;)
    {
      return;
      if (this.a.c != null) {
        this.a.c.dismiss();
      }
      if (paramBoolean)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        paramBoolean = false;
        if (paramPBRepeatMessageField.hasNext())
        {
          if (!String.valueOf(((oidb_0x5d4.DelResult)paramPBRepeatMessageField.next()).uin.get()).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label339;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        break;
        if (!paramBoolean) {
          break label340;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a.b, 2, "StrangerObserver : onDelete , result=" + paramBoolean);
        }
        paramPBRepeatMessageField = new ArrayList();
        paramPBRepeatMessageField.add(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), paramPBRepeatMessageField);
        paramPBRepeatMessageField = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        if (paramPBRepeatMessageField != null)
        {
          RecentUser localRecentUser = paramPBRepeatMessageField.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          if (QLog.isDevelopLevel()) {
            QLog.d(this.a.b, 4, "StrangerObserver, delete Recent user");
          }
          paramPBRepeatMessageField.a(localRecentUser);
        }
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719439), 0).a();
        if (this.a.n) {
          this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1);
        }
        this.a.K();
        return;
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719437), 0).a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.10
 * JD-Core Version:    0.7.0.1
 */