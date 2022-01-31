package com.tencent.mobileqq.app.qzonelover;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_PAIR.sweet_pair_check_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class QzoneLoverService
  implements BusinessObserver
{
  private static volatile QzoneLoverService jdField_a_of_type_ComTencentMobileqqAppQzoneloverQzoneLoverService;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  
  public static QzoneLoverService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppQzoneloverQzoneLoverService == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqAppQzoneloverQzoneLoverService == null) {
        jdField_a_of_type_ComTencentMobileqqAppQzoneloverQzoneLoverService = new QzoneLoverService();
      }
      return jdField_a_of_type_ComTencentMobileqqAppQzoneloverQzoneLoverService;
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (sweet_pair_check_rsp)paramBundle.getSerializable("rsp_data");
    if ((paramBundle == null) || (!paramBoolean) || (paramBundle.req_comm == null)) {}
    long l;
    AppRuntime localAppRuntime;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramBundle.req_comm.uin != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        l = paramBundle.req_comm.loveuin;
      } while (l <= 10000L);
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localAppRuntime instanceof QQAppInterface));
    ((FriendListHandler)((QQAppInterface)localAppRuntime).a(1)).a(String.valueOf(l));
    QLog.i("QzoneLoverService", 1, "onGetLoverCheckData succed(" + paramBoolean + "), uin:" + paramBundle.req_comm.uin);
  }
  
  private boolean a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("StepUpdate", 0).getBoolean("checkQzoneLover", true);
  }
  
  private void b()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).edit().putBoolean("checkQzoneLoverSend", true).apply();
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).getBoolean("checkQzoneLoverSend", false);
  }
  
  public void a()
  {
    if ((!a()) || (b()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneLoverService", 1, "startQzoneLoverCheck false");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QzoneLoverService", 1, "startQzoneLoverCheck true");
    }
    b();
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), QzoneLoverCheckServlet.class);
    QzoneLoverCheckServlet.a(localNewIntent, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    if (!this.jdField_a_of_type_Boolean)
    {
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
      this.jdField_a_of_type_Boolean = true;
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.qzonelover.QzoneLoverService
 * JD-Core Version:    0.7.0.1
 */