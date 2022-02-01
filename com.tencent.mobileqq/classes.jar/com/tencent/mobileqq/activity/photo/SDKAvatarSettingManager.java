package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;

public class SDKAvatarSettingManager
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  protected QQProgressDialog a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SDKAvatarSettingManager.4(this);
  private String jdField_a_of_type_JavaLangString = null;
  protected boolean a;
  protected QQCustomDialog b;
  private Runnable jdField_b_of_type_JavaLangRunnable = new SDKAvatarSettingManager.5(this);
  private String jdField_b_of_type_JavaLangString = null;
  protected boolean b;
  protected QQCustomDialog c;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private String e;
  private String f;
  
  public SDKAvatarSettingManager(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " onCreate ");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(Activity paramActivity, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sdk_share:sdk callback=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" appid=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("SDKAvatarSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    if (paramBoolean2) {
      ((Intent)localObject).putExtra("stay_back_stack", true);
    }
    if (paramBoolean1) {
      ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), "sdkSetAvatar" })));
    } else {
      ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error", new Object[] { Long.valueOf(paramLong), "sdkSetAvatar" })));
    }
    if (paramActivity.getIntent() != null) {
      ((Intent)localObject).setPackage(this.jdField_c_of_type_JavaLangString);
    }
    try
    {
      paramActivity.startActivity((Intent)localObject);
      return;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKAvatarSettingManager", 2, paramActivity.getMessage());
      }
    }
  }
  
  private void b(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->openPhotoEdit--path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("SDKAvatarSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      int i = ProfileCardUtil.b(this.jdField_a_of_type_AndroidAppActivity);
      localObject = new Intent();
      ((Intent)localObject).setFlags(603979776);
      ((Intent)localObject).putExtra("Business_Origin", 100);
      ((Intent)localObject).putExtra("FROM_WHERE", "FROM_SDK_AVATAR_SET_IMAGE");
      Class localClass = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
      PhotoUtils.startPhotoEditForResult((Intent)localObject, this.jdField_a_of_type_AndroidAppActivity, localClass.getName(), i, i, 1080, 1080, paramString, FaceUtil.a(), 1035);
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "set from sdk path null");
    }
  }
  
  private void g()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidAppActivity.getString(2131718866));
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject3;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getPackageManager().getPackageInfo(this.jdField_c_of_type_JavaLangString, 64);
        if (localObject1 == null) {
          break label132;
        }
        localObject1 = ((PackageInfo)localObject1).signatures;
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label132;
        }
        localObject3 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject3).update(localObject1[0].toByteArray());
        localObject1 = HexUtil.bytes2HexStr(((MessageDigest)localObject3).digest());
      }
      catch (Exception localException1)
      {
        QLog.e("SDKAvatarSettingManager", 1, "check, get signature exception=", localException1);
        break label132;
      }
    } else {
      QLog.e("SDKAvatarSettingManager", 1, "check, pkgName null");
    }
    label132:
    Object localObject2 = null;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("checkApiPermission api, mShareAppId=");
      ((StringBuilder)localObject3).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject3).append(", mPkgName=");
      ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject3).append(",signature=");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(",mSdkVerdion=");
      ((StringBuilder)localObject3).append(this.f);
      QLog.d("SDKAvatarSettingManager", 2, ((StringBuilder)localObject3).toString());
    }
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("sdkVersion", this.f);
      ((Bundle)localObject3).putString("pkgName", this.jdField_c_of_type_JavaLangString);
      ((Bundle)localObject3).putString("signature", (String)localObject2);
      a(2131719039);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_d_of_type_JavaLangString, (Bundle)localObject3).a("sdk_avatar_edit", null, new SDKAvatarSettingManager.2(this, str));
      return;
    }
    QLog.e("SDKAvatarSettingManager", 1, new Object[] { "check, invalid param, mShareAppId=", this.jdField_d_of_type_JavaLangString, ", pkgName=", this.jdField_c_of_type_JavaLangString, ", signature=", localObject2 });
    try
    {
      localObject2 = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      ((QQCustomDialog)localObject2).setMessage(HardCodeUtil.a(2131713513));
      ((QQCustomDialog)localObject2).setNegativeButton(2131690728, new SDKAvatarSettingManager.1(this));
      ((QQCustomDialog)localObject2).setCancelable(false);
      ((QQCustomDialog)localObject2).show();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("SDKAvatarSettingManager", 1, "show invalid param dialog, exception=", localException2);
    }
  }
  
  private void h()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" checkJumpAction mShareAppId = ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append("， mShareOpenId =");
      ((StringBuilder)localObject).append(this.e);
      QLog.w("SDKAvatarSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(this.jdField_a_of_type_AndroidAppActivity, false, Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), false);
      b();
      this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
      return;
    }
    OpenID localOpenID;
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.e)))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localOpenID = ((QQAppInterface)localObject).getMsgHandler().a(this.jdField_d_of_type_JavaLangString);
      if (localOpenID == null)
      {
        a(2131719039);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 8000L);
      }
    }
    try
    {
      long l = Long.parseLong(((QQAppInterface)localObject).getCurrentAccountUin());
      ((QQAppInterface)localObject).getMsgHandler().a(l, this.e, Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), new SDKAvatarSettingManager.3(this));
      return;
    }
    catch (Exception localException) {}
    if (!this.e.equals(localOpenID.openID))
    {
      if (QLog.isColorLevel()) {
        QLog.w("SDKAvatarSettingManager", 2, "-->preForward--openid doesn't equal current local openid");
      }
      e();
      return;
    }
    d();
    b(this.jdField_a_of_type_JavaLangString);
    return;
    d();
    b(this.jdField_a_of_type_JavaLangString);
    return;
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299168));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onActivityResult resultCode = ");
      localStringBuilder.append(paramInt);
      QLog.w("SDKAvatarSettingManager", 2, localStringBuilder.toString());
    }
    if (paramInt == -1)
    {
      if (paramIntent.getBooleanExtra("key_from_sdk_set_avatar_result", false))
      {
        this.jdField_c_of_type_Boolean = true;
        a(this.jdField_b_of_type_JavaLangString);
      }
      else
      {
        this.jdField_c_of_type_Boolean = false;
        a(this.jdField_a_of_type_AndroidAppActivity, false, Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), false);
        b();
        this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
      }
    }
    else if (paramInt == 0)
    {
      paramIntent = new Intent();
      this.jdField_a_of_type_AndroidAppActivity.setResult(0, paramIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
    }
    else
    {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getBundleExtra("profile_extra");
    if (paramIntent != null)
    {
      this.jdField_a_of_type_JavaLangString = paramIntent.getString("key_from_sdk_set_avatar_path", null);
      this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_from_sdk_set_avatar_appname", null);
      this.jdField_d_of_type_JavaLangString = paramIntent.getString("key_from_sdk_set_avatar_share_id", null);
      this.e = paramIntent.getString("key_from_sdk_set_avatar_open_id", null);
      this.jdField_c_of_type_JavaLangString = paramIntent.getString("pkg_name", null);
      this.f = paramIntent.getString("sdk_version");
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " initParam ");
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject != null) && (!((QQCustomDialog)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(HardCodeUtil.a(2131713515));
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131718866);
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131718867);
    localObject = str1;
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new SDKAvatarSettingManager.6(this, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(str2, paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject, paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new SDKAvatarSettingManager.7(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString1);
    paramString1 = new SDKAvatarSettingManager.9(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString2, paramString1);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void b()
  {
    Intent localIntent = new Intent();
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void b(Intent paramIntent)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      f();
      a(paramIntent);
      a();
      return;
    }
    a(this.jdField_a_of_type_AndroidAppActivity, false, Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), false);
    b();
    this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
  }
  
  public void c()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" gotoConversation isSuccess = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      QLog.w("SDKAvatarSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      ((Intent)localObject).setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      ((Intent)localObject).setFlags(67108864);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.a);
      ((Intent)localObject).putExtra("fragment_id", 1);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    }
  }
  
  public void d()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void e()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(HardCodeUtil.a(2131713514));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692113);
    localObject = new SDKAvatarSettingManager.8(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131718876, (DialogInterface.OnClickListener)localObject);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void f()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager
 * JD-Core Version:    0.7.0.1
 */