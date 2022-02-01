package com.tencent.mobileqq.activity.contact.phonecontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MobileUnityBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParserException;

public class PhoneUnityManager
  implements Manager
{
  public boolean a = false;
  public PhoneUnityBannerData b;
  public PhoneUnityVersionInfo c;
  public QQAppInterface d;
  public boolean e;
  public boolean f = false;
  public boolean g = false;
  public Bundle h;
  Runnable i = new PhoneUnityManager.1(this);
  Runnable j = new PhoneUnityManager.2(this);
  public long k;
  
  public PhoneUnityManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 7))
    {
      int m = paramString.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(0, m - 8));
      localStringBuilder.append("******");
      localStringBuilder.append(paramString.substring(m - 2));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("needResult", true);
    localIntent.putExtra("business", 16384L);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramString != null))
    {
      int i1 = 0;
      int n = paramBundle.getInt("status", 0);
      int m = 4;
      if (n == 4) {
        return;
      }
      String str = paramBundle.getString("phone");
      boolean bool1 = paramBundle.getBoolean("phone_verified", true);
      boolean bool2 = paramBundle.getBoolean("bool_is_IOT", false);
      n = paramBundle.getInt("status", 0);
      if (bool2) {
        m = 6;
      } else if ((bool1 ^ true)) {
        m = 5;
      } else if (n != 3) {
        if (!TextUtils.isEmpty(str)) {
          m = 1;
        } else {
          m = 3;
        }
      }
      n = i1;
      if (paramBundle.getInt("need_unify", 0) == 1)
      {
        n = i1;
        if (!TextUtils.isEmpty(str)) {
          n = 1;
        }
      }
      if (n != 0) {
        m = 2;
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, m, 0, "", "", "", "");
    }
  }
  
  private void i()
  {
    Object localObject1 = e();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("tryShowBannerInner ve");
      ((StringBuilder)localObject2).append(this.c);
      QLog.d("MobileUnityManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (((PhoneUnityVersionInfo)localObject1).e > 0L)
    {
      ((PhoneUnityVersionInfo)localObject1).e -= 1L;
      a((PhoneUnityVersionInfo)localObject1);
      return;
    }
    if (localObject1 != null)
    {
      if (((PhoneUnityVersionInfo)localObject1).a == -1) {
        return;
      }
      localObject2 = h();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryShowBannerInner bd ");
        localStringBuilder.append(localObject2);
        QLog.d("MobileUnityManager", 2, localStringBuilder.toString());
      }
      if ((localObject2 != null) && (((PhoneUnityBannerData)localObject2).g > 0))
      {
        if (((PhoneUnityBannerData)localObject2).c <= 0) {
          return;
        }
        if (!((PhoneUnityBannerData)localObject2).h) {
          return;
        }
        if (((PhoneUnityVersionInfo)localObject1).d > 0L)
        {
          long l3 = ((PhoneUnityVersionInfo)localObject1).b;
          int n = ((PhoneUnityBannerData)localObject2).d;
          int m = 1;
          long l1 = (n + 1) * 24 * 60 * 60 * 1000;
          long l2 = System.currentTimeMillis();
          l3 = l2 - l3;
          if (l3 > l1)
          {
            ((PhoneUnityVersionInfo)localObject1).b = l2;
            ((PhoneUnityVersionInfo)localObject1).d -= 1L;
            ((PhoneUnityVersionInfo)localObject1).c = (((PhoneUnityBannerData)localObject2).c - 1);
            a((PhoneUnityVersionInfo)localObject1);
          }
          else if ((l3 < 86400000L) && (((PhoneUnityVersionInfo)localObject1).c > 0))
          {
            ((PhoneUnityVersionInfo)localObject1).d -= 1L;
            ((PhoneUnityVersionInfo)localObject1).c -= 1;
            a((PhoneUnityVersionInfo)localObject1);
          }
          else
          {
            m = 0;
          }
          if (m != 0) {
            if (((IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
            {
              if (QLog.isColorLevel()) {
                QLog.d("MobileUnityManager", 2, "tryShowBannerInner already binded");
              }
            }
            else
            {
              localObject1 = Message.obtain();
              ((Message)localObject1).obj = localObject2;
              BannerManager.a().a(MobileUnityBannerProcessor.a, 2, (Message)localObject1);
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, PhoneUnityBannerData paramPhoneUnityBannerData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "saveBannerConfig");
    }
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    if (TextUtils.isEmpty(((QQAppInterface)localObject).getCurrentAccountUin())) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveBannerConfig ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MobileUnityManager", 2, ((StringBuilder)localObject).toString());
    }
    localObject = g();
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        FileUtils.deleteFile((String)localObject);
        a(null);
        this.b = null;
        return;
      }
      if (paramPhoneUnityBannerData != null)
      {
        FileUtils.createFile((String)localObject);
        FileUtils.writeFile((String)localObject, paramString);
        this.b = paramPhoneUnityBannerData;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("saveBannerConfig date = ");
          paramString.append(this.b);
          QLog.d("MobileUnityManager", 2, paramString.toString());
        }
        ReportController.b(this.d, "CliOper", "", "", "0X8005B71 ", "0X8005B71 ", 0, 0, "", "", "", "");
        paramString = e();
        if (paramString != null)
        {
          paramString.b = 0L;
          paramString.a = paramInt;
          paramString.d = paramPhoneUnityBannerData.e;
          paramString.c = paramPhoneUnityBannerData.c;
          paramString.e = paramPhoneUnityBannerData.g;
          a(paramString);
          d();
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      FileUtils.delete((String)localObject, true);
      QLog.e("MobileUnityManager", 1, "", paramString);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.h = paramBundle;
    this.e = false;
    IPhoneContactService localIPhoneContactService = null;
    Object localObject = localIPhoneContactService;
    if (paramBundle != null)
    {
      if (paramBundle.getInt("need_unify") == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.e = bool;
      Bundle[] arrayOfBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
      localObject = localIPhoneContactService;
      if (arrayOfBundle != null)
      {
        localObject = null;
        m = 0;
        while (m < arrayOfBundle.length)
        {
          localIPhoneContactService = arrayOfBundle[m];
          int n = localIPhoneContactService.getInt("phone_type");
          if (n != 2)
          {
            if (n == 3) {
              localObject = localIPhoneContactService.getString("phone");
            }
          }
          else
          {
            String str = localIPhoneContactService.getString("phone");
            if ((localIPhoneContactService.getInt("status") == 1) && (!TextUtils.isEmpty(str))) {
              bool = true;
            } else {
              bool = false;
            }
            this.f = bool;
          }
          m += 1;
        }
      }
    }
    localIPhoneContactService = (IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "");
    int m = localIPhoneContactService.getSelfBindState();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (m <= 5)) {}
    while (((TextUtils.isEmpty((CharSequence)localObject)) && (m > 5)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (m >= 8)) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (m == 7)))
    {
      bool = true;
      break;
    }
    boolean bool = false;
    if (bool) {
      localIPhoneContactService.checkUpdateBindStateAndListIgnoreBindState(true, false, 13);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MobileUnityManager", 2, String.format("onGetBindInfo [%s, %s, %s, %s]", new Object[] { Integer.valueOf(m), Boolean.valueOf(bool), localObject, paramBundle }));
    }
  }
  
  public void a(PhoneUnityVersionInfo paramPhoneUnityVersionInfo)
  {
    if (paramPhoneUnityVersionInfo == null)
    {
      this.c = null;
      c().edit().remove("mobileunityversion").commit();
      return;
    }
    this.c = paramPhoneUnityVersionInfo;
    c().edit().putString("mobileunityversion", paramPhoneUnityVersionInfo.a()).commit();
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public void b()
  {
    ThreadManager.post(this.j, 5, null, false);
  }
  
  public SharedPreferences c()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhoneUnityManager_");
    localStringBuilder.append(this.d.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "tryShowBanner");
    }
    ThreadManager.getSubThreadHandler().postDelayed(this.i, 5000L);
  }
  
  public PhoneUnityVersionInfo e()
  {
    PhoneUnityVersionInfo localPhoneUnityVersionInfo = this.c;
    if (localPhoneUnityVersionInfo != null) {
      return localPhoneUnityVersionInfo;
    }
    localPhoneUnityVersionInfo = PhoneUnityVersionInfo.a(c().getString("mobileunityversion", ""));
    this.c = localPhoneUnityVersionInfo;
    return localPhoneUnityVersionInfo;
  }
  
  public int f()
  {
    return e().a;
  }
  
  public String g()
  {
    Object localObject1 = BaseApplicationImpl.getContext();
    Object localObject2 = this.d.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Context)localObject1).getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(".mobileunity");
    localObject1 = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getBannerConfigFilePath path = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("MobileUnityManager", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public PhoneUnityBannerData h()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return localObject;
    }
    localObject = g();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.b = null;
      return null;
    }
    BaseApplicationImpl.getContext();
    localObject = new File((String)localObject);
    try
    {
      if (((File)localObject).exists()) {
        this.b = PhoneUnityBannerData.a(FileUtils.readFileContent((File)localObject));
      }
      localObject = this.b;
      return localObject;
    }
    catch (XmlPullParserException|IOException|Exception localXmlPullParserException)
    {
      label68:
      break label68;
    }
    return this.b;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager
 * JD-Core Version:    0.7.0.1
 */