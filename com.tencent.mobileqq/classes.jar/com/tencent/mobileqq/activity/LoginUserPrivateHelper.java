package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class LoginUserPrivateHelper
  implements DialogInterface.OnClickListener, QQPermissionCallback
{
  public static boolean a = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  private LoginUserPrivateHelper.LoginPermissionCallback jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper$LoginPermissionCallback;
  private AppActivity jdField_a_of_type_MqqAppAppActivity;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e;
  private boolean f;
  
  private void a(AppActivity paramAppActivity, int paramInt)
  {
    String str = QQDeviceInfo.getNoLoginUserId();
    if ((paramAppActivity instanceof RegisterPhoneNumActivity)) {
      paramAppActivity = "0X800A9DF";
    } else {
      paramAppActivity = "0X800A9DE";
    }
    ReportController.a(null, "dc00898", "", "", paramAppActivity, paramAppActivity, paramInt, 0, "", "", str, "");
  }
  
  public void a()
  {
    int i = jdField_a_of_type_ArrayOfJavaLangString.length;
    if (Build.VERSION.SDK_INT > 28) {
      i = 1;
    }
    LoginUserPrivateHelper.2 local2 = new LoginUserPrivateHelper.2(this);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_MqqAppAppActivity, 230);
    String str1 = HardCodeUtil.a(2131710159);
    int j = 2131693849;
    if (i > 1) {
      j = 2131693850;
    }
    String str2 = HardCodeUtil.a(j);
    localQQCustomDialog.setTitle(str1);
    localQQCustomDialog.setMessage(str2);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131693848), local2);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131693847), local2);
    localQQCustomDialog.show();
  }
  
  public void a(LoginUserPrivateHelper.LoginPermissionCallback paramLoginPermissionCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper$LoginPermissionCallback = paramLoginPermissionCallback;
  }
  
  public boolean a(Context paramContext)
  {
    int i = jdField_a_of_type_ArrayOfJavaLangString.length;
    if (Build.VERSION.SDK_INT > 28) {
      i = 1;
    }
    boolean bool2 = b(paramContext);
    boolean bool1 = bool2;
    if (i > 1)
    {
      bool1 = c(paramContext);
      if ((bool2) && (bool1)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean a(AppActivity paramAppActivity)
  {
    return a(paramAppActivity, true);
  }
  
  @TargetApi(23)
  public boolean a(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if ((paramAppActivity != null) && (this.jdField_a_of_type_MqqAppAppActivity != paramAppActivity)) {
      this.jdField_a_of_type_MqqAppAppActivity = paramAppActivity;
    }
    if ((paramBoolean) && (!PrivacyPolicyHelper.a()))
    {
      paramAppActivity = new LoginUserPrivateHelper.1(this);
      PrivacyPolicyHelper.a(this.jdField_a_of_type_MqqAppAppActivity, "", paramAppActivity, paramAppActivity).show();
      return false;
    }
    if ((this.b) && (!jdField_a_of_type_Boolean)) {
      return true;
    }
    this.b = true;
    if (!a(this.jdField_a_of_type_MqqAppAppActivity))
    {
      a();
      return false;
    }
    return true;
  }
  
  public void b()
  {
    int i = jdField_a_of_type_ArrayOfJavaLangString.length;
    if (Build.VERSION.SDK_INT > 28) {
      i = 1;
    }
    int j;
    if (this.jdField_a_of_type_MqqAppAppActivity.checkSelfPermission(jdField_a_of_type_ArrayOfJavaLangString[0]) == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == 1)
    {
      if (j == 0) {
        this.jdField_a_of_type_MqqAppAppActivity.requestPermissions(this, 0, new String[] { jdField_a_of_type_ArrayOfJavaLangString[0] });
      }
    }
    else {
      this.jdField_a_of_type_MqqAppAppActivity.requestPermissions(this, 0, jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  public boolean b(Context paramContext)
  {
    boolean bool2 = this.e;
    boolean bool1 = bool2;
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission(jdField_a_of_type_ArrayOfJavaLangString[0]) == 0)
          {
            this.e = true;
            return this.e;
          }
        }
      }
      else
      {
        this.e = true;
        bool1 = this.e;
      }
    }
    return bool1;
  }
  
  public boolean c(Context paramContext)
  {
    boolean bool2 = this.f;
    boolean bool1 = bool2;
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission(jdField_a_of_type_ArrayOfJavaLangString[1]) == 0)
          {
            this.f = true;
            return this.f;
          }
        }
      }
      else
      {
        this.f = true;
        bool1 = this.f;
      }
    }
    return bool1;
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper$LoginPermissionCallback;
    if (paramArrayOfString != null) {
      paramArrayOfString.b();
    }
    a(this.jdField_a_of_type_MqqAppAppActivity, 2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("grant");
    paramArrayOfString.append(paramInt);
    QLog.d("LoginUserPrivateHelper", 1, paramArrayOfString.toString());
    paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper$LoginPermissionCallback;
    if (paramArrayOfString != null) {
      paramArrayOfString.a();
    }
    a(this.jdField_a_of_type_MqqAppAppActivity, 1);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.jdField_a_of_type_MqqAppAppActivity.getPackageName(), null));
      this.jdField_a_of_type_MqqAppAppActivity.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginUserPrivateHelper
 * JD-Core Version:    0.7.0.1
 */