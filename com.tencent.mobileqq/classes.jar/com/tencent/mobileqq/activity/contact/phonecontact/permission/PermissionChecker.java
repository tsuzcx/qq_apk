package com.tencent.mobileqq.activity.contact.phonecontact.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class PermissionChecker
{
  PermissionParam jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam;
  WeakReference<PermissionListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static int a()
  {
    int j = 0;
    int i = 0;
    Context localContext;
    if (VersionUtils.k()) {
      localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    }
    label67:
    label105:
    for (;;)
    {
      try
      {
        if (localContext.checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
          i = 1;
        }
        j = i;
        int k = localContext.checkSelfPermission("android.permission.WRITE_CONTACTS");
        if (k != 0) {
          break label105;
        }
        i |= 0x2;
        QLog.d("contact.PermissionChecker", 1, "CheckPermission exception:" + localThrowable1.getMessage(), localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          k = localContext.checkSelfPermission("android.permission.GET_ACCOUNTS");
          j = i;
          if (k == 0) {
            j = i | 0x4;
          }
          return j;
        }
        catch (Throwable localThrowable2)
        {
          break label67;
        }
        localThrowable1 = localThrowable1;
        i = j;
      }
      return i;
      return 7;
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "checkReadContactPermission error");
      }
    }
    do
    {
      do
      {
        return;
        paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
        boolean bool = paramQQAppInterface.k();
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, String.format("checkReadContactPermission [%s, %s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(VersionUtils.k()) }));
        }
        if (!bool) {
          break;
        }
      } while (paramRunnable1 == null);
      paramRunnable1.run();
      return;
      if (VersionUtils.k())
      {
        if ((paramRunnable2 instanceof DenyRunnable)) {
          ((DenyRunnable)paramRunnable2).a();
        }
        PermissionParam localPermissionParam = new PermissionParam();
        localPermissionParam.jdField_a_of_type_JavaLangRunnable = paramRunnable1;
        localPermissionParam.jdField_b_of_type_JavaLangRunnable = paramRunnable2;
        localPermissionParam.jdField_a_of_type_Int = 1;
        paramQQAppInterface.a().a(paramActivity, localPermissionParam, null, new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" });
        return;
      }
    } while (paramRunnable2 == null);
    paramRunnable2.run();
  }
  
  private void a(boolean paramBoolean)
  {
    PermissionListener localPermissionListener;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam.jdField_b_of_type_Int = a();
      QLog.d("contact.PermissionChecker", 1, "onPermissionResult = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        break label78;
      }
      localPermissionListener = null;
      if (localPermissionListener == null) {
        break label92;
      }
      localPermissionListener.a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam = null;
      return;
      label78:
      localPermissionListener = (PermissionListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
      label92:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam.a(paramBoolean);
    }
  }
  
  public static boolean a()
  {
    return (!a("android.permission.READ_CONTACTS")) || (!a("android.permission.WRITE_CONTACTS")) || (!a("android.permission.GET_ACCOUNTS"));
  }
  
  public static boolean a(String paramString)
  {
    Context localContext;
    if (VersionUtils.k()) {
      localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    }
    try
    {
      int i = localContext.checkSelfPermission(paramString);
      return i == 0;
    }
    catch (Throwable paramString)
    {
      QLog.d("contact.PermissionChecker", 1, "CheckPermission exception:" + paramString.getMessage(), paramString);
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam = null;
  }
  
  public void a(Activity paramActivity, PermissionParam paramPermissionParam, PermissionListener paramPermissionListener, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (paramActivity == null) {}
    for (;;)
    {
      try
      {
        paramActivity = BaseActivity.sTopActivity;
        AppActivity localAppActivity = (AppActivity)paramActivity;
        paramActivity = paramPermissionParam;
        if (paramPermissionParam == null) {
          paramActivity = new PermissionParam();
        }
        paramPermissionParam = new StringBuilder(512);
        ArrayList localArrayList = new ArrayList();
        int j = paramVarArgs.length;
        int i = 0;
        if (i < j)
        {
          String str = paramVarArgs[i];
          localArrayList.add(str);
          paramPermissionParam.append(str).append(",");
          i += 1;
        }
        else
        {
          paramActivity.jdField_a_of_type_JavaUtilList = localArrayList;
          this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam = paramActivity;
          this.jdField_a_of_type_JavaLangRefWeakReference = null;
          if (paramPermissionListener != null) {
            this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPermissionListener);
          }
          QLog.d("contact.PermissionChecker", 1, "requestPermissions = " + paramPermissionParam.toString());
          localAppActivity.requestPermissions(this, 1, paramVarArgs);
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        QLog.d("contact.PermissionChecker", 1, "requestPermissions exception:" + paramActivity.getMessage(), paramActivity);
        return;
      }
    }
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("contact.PermissionChecker", 1, "CheckPermission user denied = ");
    a(false);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("contact.PermissionChecker", 1, "CheckPermission user grant = ");
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionChecker
 * JD-Core Version:    0.7.0.1
 */