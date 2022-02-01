package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppActivity;
import mqq.util.WeakReference;

public class QQRegisterAction
  extends JumpActionBase
{
  public QQRegisterAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, (String)localObject, "", "", "");
    localObject = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
    if (a().getRegisterPhoneNumActivityClass() == localObject) {
      localIntent.putExtra("key_report_extra_from", 5);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private Class a()
  {
    ILoginRegisterApi localILoginRegisterApi = a();
    Class localClass = localILoginRegisterApi.getRegisterPhoneNumActivityClass();
    int i = BaseApplicationImpl.getApplication().appActivities.size() - 1;
    while (i >= 0)
    {
      Object localObject = (WeakReference)BaseApplicationImpl.getApplication().appActivities.get(i);
      if (localObject != null) {
        localObject = (AppActivity)((WeakReference)localObject).get();
      }
      while (localObject != null)
      {
        localObject = ((Activity)localObject).getLocalClassName();
        if ("activity.RegisterPersonalInfoActivity".equals(localObject))
        {
          return localILoginRegisterApi.getRegisterPersonalInfoActivityClass();
          localObject = null;
        }
        else
        {
          if ("activity.RegisterVerifyCodeActivity".equals(localObject)) {
            return localILoginRegisterApi.getRegisterVerifyCodeActivityClass();
          }
          if ("activity.RegisterByNicknameAndPwdActivity".equals(localObject)) {
            return localILoginRegisterApi.getRegisterByNicknameAndPwdActivityClass();
          }
          if ("activity.RegisterSendUpSms".equals(localObject)) {
            return localILoginRegisterApi.getRegisterSendUpSmsClass();
          }
          if ("activity.RegisterPhoneNumActivity".equals(localObject)) {
            return localClass;
          }
        }
      }
      i -= 1;
    }
    return localClass;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QQRegisterAction", 1, "doAction error: " + localException.getMessage());
      a("QQRegisterAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQRegisterAction
 * JD-Core Version:    0.7.0.1
 */