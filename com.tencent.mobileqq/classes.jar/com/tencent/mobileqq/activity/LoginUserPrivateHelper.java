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
  private static final String[] i = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  private AppActivity b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  private boolean g;
  private LoginUserPrivateHelper.LoginPermissionCallback h;
  
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
    int j = i.length;
    if (Build.VERSION.SDK_INT > 28) {
      j = 1;
    }
    LoginUserPrivateHelper.2 local2 = new LoginUserPrivateHelper.2(this);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.b, 230);
    String str1 = HardCodeUtil.a(2131907863);
    int k = 2131891429;
    if (j > 1) {
      k = 2131891430;
    }
    String str2 = HardCodeUtil.a(k);
    localQQCustomDialog.setTitle(str1);
    localQQCustomDialog.setMessage(str2);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131891428), local2);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131891427), local2);
    localQQCustomDialog.show();
  }
  
  public void a(LoginUserPrivateHelper.LoginPermissionCallback paramLoginPermissionCallback)
  {
    this.h = paramLoginPermissionCallback;
  }
  
  public boolean a(Context paramContext)
  {
    int j = i.length;
    if (Build.VERSION.SDK_INT > 28) {
      j = 1;
    }
    boolean bool2 = b(paramContext);
    boolean bool1 = bool2;
    if (j > 1)
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
    if ((paramAppActivity != null) && (this.b != paramAppActivity)) {
      this.b = paramAppActivity;
    }
    if ((paramBoolean) && (!PrivacyPolicyHelper.d()))
    {
      paramAppActivity = new LoginUserPrivateHelper.1(this);
      PrivacyPolicyHelper.a(this.b, "", paramAppActivity, paramAppActivity).show();
      return false;
    }
    if ((this.c) && (!a)) {
      return true;
    }
    this.c = true;
    if (!a(this.b))
    {
      a();
      return false;
    }
    return true;
  }
  
  public void b()
  {
    int j = i.length;
    if (Build.VERSION.SDK_INT > 28) {
      j = 1;
    }
    int k;
    if (this.b.checkSelfPermission(i[0]) == 0) {
      k = 1;
    } else {
      k = 0;
    }
    if (j == 1)
    {
      if (k == 0) {
        this.b.requestPermissions(this, 0, new String[] { i[0] });
      }
    }
    else {
      this.b.requestPermissions(this, 0, i);
    }
  }
  
  public boolean b(Context paramContext)
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
          if (paramContext.checkSelfPermission(i[0]) == 0)
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
  
  public boolean c(Context paramContext)
  {
    boolean bool2 = this.g;
    boolean bool1 = bool2;
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission(i[1]) == 0)
          {
            this.g = true;
            return this.g;
          }
        }
      }
      else
      {
        this.g = true;
        bool1 = this.g;
      }
    }
    return bool1;
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.h;
    if (paramArrayOfString != null) {
      paramArrayOfString.b();
    }
    a(this.b, 2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("grant");
    paramArrayOfString.append(paramInt);
    QLog.d("LoginUserPrivateHelper", 1, paramArrayOfString.toString());
    paramArrayOfString = this.h;
    if (paramArrayOfString != null) {
      paramArrayOfString.a();
    }
    a(this.b, 1);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.b.getPackageName(), null));
      this.b.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginUserPrivateHelper
 * JD-Core Version:    0.7.0.1
 */