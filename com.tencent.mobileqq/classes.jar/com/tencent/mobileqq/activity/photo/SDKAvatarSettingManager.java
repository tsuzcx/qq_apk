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
  protected boolean a = false;
  protected boolean b = false;
  protected QQProgressDialog c;
  QQCustomDialog d = null;
  protected QQCustomDialog e = null;
  protected QQCustomDialog f = null;
  private Activity g;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k;
  private String l;
  private String m;
  private boolean n = false;
  private boolean o = false;
  private Handler p;
  private Runnable q = new SDKAvatarSettingManager.4(this);
  private Runnable r = new SDKAvatarSettingManager.5(this);
  
  public SDKAvatarSettingManager(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " onCreate ");
    }
    this.g = paramActivity;
    this.p = new Handler();
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
      ((Intent)localObject).setPackage(this.j);
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
      int i1 = ProfileCardUtil.b(this.g);
      localObject = new Intent();
      ((Intent)localObject).setFlags(603979776);
      ((Intent)localObject).putExtra("Business_Origin", 100);
      ((Intent)localObject).putExtra("FROM_WHERE", "FROM_SDK_AVATAR_SET_IMAGE");
      Class localClass = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
      PhotoUtils.startPhotoEditForResult((Intent)localObject, this.g, localClass.getName(), i1, i1, 1080, 1080, paramString, FaceUtil.a(), 1035);
      this.o = true;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "set from sdk path null");
    }
  }
  
  private void g()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.g.getString(2131916399));
    ((StringBuilder)localObject1).append(this.i);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject3;
    if (!TextUtils.isEmpty(this.j)) {
      try
      {
        localObject1 = this.g.getPackageManager().getPackageInfo(this.j, 64);
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
      ((StringBuilder)localObject3).append(this.k);
      ((StringBuilder)localObject3).append(", mPkgName=");
      ((StringBuilder)localObject3).append(this.j);
      ((StringBuilder)localObject3).append(",signature=");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(",mSdkVerdion=");
      ((StringBuilder)localObject3).append(this.m);
      QLog.d("SDKAvatarSettingManager", 2, ((StringBuilder)localObject3).toString());
    }
    if ((!TextUtils.isEmpty(this.k)) && (!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("sdkVersion", this.m);
      ((Bundle)localObject3).putString("pkgName", this.j);
      ((Bundle)localObject3).putString("signature", (String)localObject2);
      a(2131916575);
      this.p.postDelayed(this.q, 5000L);
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(this.g, 1, this.k, (Bundle)localObject3).a("sdk_avatar_edit", null, new SDKAvatarSettingManager.2(this, str));
      return;
    }
    QLog.e("SDKAvatarSettingManager", 1, new Object[] { "check, invalid param, mShareAppId=", this.k, ", pkgName=", this.j, ", signature=", localObject2 });
    try
    {
      localObject2 = DialogUtil.a(this.g, 230);
      ((QQCustomDialog)localObject2).setMessage(HardCodeUtil.a(2131911062));
      ((QQCustomDialog)localObject2).setNegativeButton(2131887648, new SDKAvatarSettingManager.1(this));
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
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append("， mShareOpenId =");
      ((StringBuilder)localObject).append(this.l);
      QLog.w("SDKAvatarSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(this.g, false, Long.valueOf(this.k).longValue(), false);
      b();
      this.g.moveTaskToBack(true);
      return;
    }
    OpenID localOpenID;
    if ((!TextUtils.isEmpty(this.k)) && (!TextUtils.isEmpty(this.l)))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localOpenID = ((QQAppInterface)localObject).getMsgHandler().e(this.k);
      if (localOpenID == null)
      {
        a(2131916575);
        this.p.postDelayed(this.r, 8000L);
      }
    }
    try
    {
      long l1 = Long.parseLong(((QQAppInterface)localObject).getCurrentAccountUin());
      ((QQAppInterface)localObject).getMsgHandler().a(l1, this.l, Long.valueOf(this.k).longValue(), new SDKAvatarSettingManager.3(this));
      return;
    }
    catch (Exception localException) {}
    if (!this.l.equals(localOpenID.openID))
    {
      if (QLog.isColorLevel()) {
        QLog.w("SDKAvatarSettingManager", 2, "-->preForward--openid doesn't equal current local openid");
      }
      e();
      return;
    }
    d();
    b(this.h);
    return;
    d();
    b(this.h);
    return;
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt)
  {
    if (this.c == null)
    {
      Activity localActivity = this.g;
      this.c = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299920));
    }
    this.c.c(paramInt);
    if (!this.g.isFinishing()) {
      this.c.show();
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
        this.n = true;
        a(this.i);
      }
      else
      {
        this.n = false;
        a(this.g, false, Long.valueOf(this.k).longValue(), false);
        b();
        this.g.moveTaskToBack(true);
      }
    }
    else if (paramInt == 0)
    {
      paramIntent = new Intent();
      this.g.setResult(0, paramIntent);
      this.g.finish();
      this.g.moveTaskToBack(true);
    }
    else
    {
      this.g.finish();
    }
    this.o = false;
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getBundleExtra("profile_extra");
    if (paramIntent != null)
    {
      this.h = paramIntent.getString("key_from_sdk_set_avatar_path", null);
      this.i = paramIntent.getString("key_from_sdk_set_avatar_appname", null);
      this.k = paramIntent.getString("key_from_sdk_set_avatar_share_id", null);
      this.l = paramIntent.getString("key_from_sdk_set_avatar_open_id", null);
      this.j = paramIntent.getString("pkg_name", null);
      this.m = paramIntent.getString("sdk_version");
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " initParam ");
    }
  }
  
  void a(String paramString)
  {
    if (this.g.isFinishing()) {
      return;
    }
    Object localObject = this.d;
    if ((localObject != null) && (!((QQCustomDialog)localObject).isShowing()))
    {
      this.d.show();
      return;
    }
    this.d = DialogUtil.a(this.g, 230);
    this.d.setTitle(HardCodeUtil.a(2131911064));
    String str1 = this.g.getString(2131916399);
    String str2 = this.g.getString(2131916400);
    localObject = str1;
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new SDKAvatarSettingManager.6(this, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.d.setPositiveButton(str2, paramString);
    this.d.setNegativeButton((String)localObject, paramString);
    this.d.setOnKeyListener(new SDKAvatarSettingManager.7(this));
    this.d.show();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = this.f;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.e = DialogUtil.a(this.g, 230);
    this.e.setMessage(paramString1);
    paramString1 = new SDKAvatarSettingManager.9(this);
    this.e.setNegativeButton(paramString2, paramString1);
    this.e.show();
  }
  
  protected void b()
  {
    Intent localIntent = new Intent();
    this.g.setResult(-1, localIntent);
    this.g.finish();
  }
  
  public void b(Intent paramIntent)
  {
    if (!this.o)
    {
      f();
      a(paramIntent);
      a();
      return;
    }
    a(this.g, false, Long.valueOf(this.k).longValue(), false);
    b();
    this.g.moveTaskToBack(true);
  }
  
  public void c()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" gotoConversation isSuccess = ");
      ((StringBuilder)localObject).append(this.n);
      QLog.w("SDKAvatarSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.n)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(this.g, SplashActivity.class);
      ((Intent)localObject).setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      ((Intent)localObject).setFlags(67108864);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.a);
      ((Intent)localObject).putExtra("fragment_id", 1);
      this.g.startActivity((Intent)localObject);
    }
  }
  
  public void d()
  {
    QQProgressDialog localQQProgressDialog = this.c;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.c.dismiss();
    }
  }
  
  protected void e()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        this.e.show();
      }
      return;
    }
    this.e = DialogUtil.a(this.g, 230);
    this.e.setMessage(HardCodeUtil.a(2131911063));
    this.e.setTitle(2131889094);
    localObject = new SDKAvatarSettingManager.8(this);
    this.e.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    this.e.setPositiveButton(2131916409, (DialogInterface.OnClickListener)localObject);
    this.e.show();
  }
  
  public void f()
  {
    QQCustomDialog localQQCustomDialog = this.d;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.n = false;
    this.o = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager
 * JD-Core Version:    0.7.0.1
 */