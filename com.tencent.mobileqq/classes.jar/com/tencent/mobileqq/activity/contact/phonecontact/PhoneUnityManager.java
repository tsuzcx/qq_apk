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
  public long a;
  public Bundle a;
  public PhoneUnityBannerData a;
  public PhoneUnityVersionInfo a;
  public QQAppInterface a;
  Runnable a;
  public boolean a;
  Runnable b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  
  public PhoneUnityManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new PhoneUnityManager.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new PhoneUnityManager.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 7))
    {
      int i = paramString.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(0, i - 8));
      localStringBuilder.append("******");
      localStringBuilder.append(paramString.substring(i - 2));
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
      int k = 0;
      int j = paramBundle.getInt("status", 0);
      int i = 4;
      if (j == 4) {
        return;
      }
      String str = paramBundle.getString("phone");
      boolean bool = paramBundle.getBoolean("phone_verified", true);
      j = paramBundle.getInt("status", 0);
      if ((bool ^ true)) {
        i = 5;
      } else if (j != 3) {
        if (!TextUtils.isEmpty(str)) {
          i = 1;
        } else {
          i = 3;
        }
      }
      j = k;
      if (paramBundle.getInt("need_unify", 0) == 1)
      {
        j = k;
        if (!TextUtils.isEmpty(str)) {
          j = 1;
        }
      }
      if (j != 0) {
        i = 2;
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
    }
  }
  
  private void c()
  {
    Object localObject1 = a();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("tryShowBannerInner ve");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityVersionInfo);
      QLog.d("MobileUnityManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (((PhoneUnityVersionInfo)localObject1).c > 0L)
    {
      ((PhoneUnityVersionInfo)localObject1).c -= 1L;
      a((PhoneUnityVersionInfo)localObject1);
      return;
    }
    if (localObject1 != null)
    {
      if (((PhoneUnityVersionInfo)localObject1).jdField_a_of_type_Int == -1) {
        return;
      }
      localObject2 = a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryShowBannerInner bd ");
        localStringBuilder.append(localObject2);
        QLog.d("MobileUnityManager", 2, localStringBuilder.toString());
      }
      if ((localObject2 != null) && (((PhoneUnityBannerData)localObject2).e > 0))
      {
        if (((PhoneUnityBannerData)localObject2).jdField_a_of_type_Int <= 0) {
          return;
        }
        if (!((PhoneUnityBannerData)localObject2).jdField_a_of_type_Boolean) {
          return;
        }
        if (((PhoneUnityVersionInfo)localObject1).jdField_b_of_type_Long > 0L)
        {
          long l3 = ((PhoneUnityVersionInfo)localObject1).jdField_a_of_type_Long;
          int j = ((PhoneUnityBannerData)localObject2).jdField_b_of_type_Int;
          int i = 1;
          long l1 = (j + 1) * 24 * 60 * 60 * 1000;
          long l2 = System.currentTimeMillis();
          l3 = l2 - l3;
          if (l3 > l1)
          {
            ((PhoneUnityVersionInfo)localObject1).jdField_a_of_type_Long = l2;
            ((PhoneUnityVersionInfo)localObject1).jdField_b_of_type_Long -= 1L;
            ((PhoneUnityVersionInfo)localObject1).jdField_b_of_type_Int = (((PhoneUnityBannerData)localObject2).jdField_a_of_type_Int - 1);
            a((PhoneUnityVersionInfo)localObject1);
          }
          else if ((l3 < 86400000L) && (((PhoneUnityVersionInfo)localObject1).jdField_b_of_type_Int > 0))
          {
            ((PhoneUnityVersionInfo)localObject1).jdField_b_of_type_Long -= 1L;
            ((PhoneUnityVersionInfo)localObject1).jdField_b_of_type_Int -= 1;
            a((PhoneUnityVersionInfo)localObject1);
          }
          else
          {
            i = 0;
          }
          if (i != 0) {
            if (((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
            {
              if (QLog.isColorLevel()) {
                QLog.d("MobileUnityManager", 2, "tryShowBannerInner already binded");
              }
            }
            else
            {
              localObject1 = Message.obtain();
              ((Message)localObject1).obj = localObject2;
              BannerManager.a().a(MobileUnityBannerProcessor.jdField_a_of_type_Int, 2, (Message)localObject1);
            }
          }
        }
      }
    }
  }
  
  public int a()
  {
    return a().jdField_a_of_type_Int;
  }
  
  public SharedPreferences a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhoneUnityManager_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public PhoneUnityBannerData a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData;
    if (localObject != null) {
      return localObject;
    }
    localObject = a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData = null;
      return null;
    }
    BaseApplicationImpl.getContext();
    localObject = new File((String)localObject);
    try
    {
      if (((File)localObject).exists()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData = PhoneUnityBannerData.a(FileUtils.readFileContent((File)localObject));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData;
      return localObject;
    }
    catch (XmlPullParserException|IOException|Exception localXmlPullParserException)
    {
      label68:
      break label68;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData;
  }
  
  public PhoneUnityVersionInfo a()
  {
    PhoneUnityVersionInfo localPhoneUnityVersionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityVersionInfo;
    if (localPhoneUnityVersionInfo != null) {
      return localPhoneUnityVersionInfo;
    }
    localPhoneUnityVersionInfo = PhoneUnityVersionInfo.a(a().getString("mobileunityversion", ""));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityVersionInfo = localPhoneUnityVersionInfo;
    return localPhoneUnityVersionInfo;
  }
  
  public String a()
  {
    Object localObject1 = BaseApplicationImpl.getContext();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
  
  public void a()
  {
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
  }
  
  public void a(int paramInt, String paramString, PhoneUnityBannerData paramPhoneUnityBannerData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "saveBannerConfig");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    localObject = a();
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        FileUtils.deleteFile((String)localObject);
        a(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData = null;
        return;
      }
      if (paramPhoneUnityBannerData != null)
      {
        FileUtils.createFile((String)localObject);
        FileUtils.writeFile((String)localObject, paramString);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData = paramPhoneUnityBannerData;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("saveBannerConfig date = ");
          paramString.append(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData);
          QLog.d("MobileUnityManager", 2, paramString.toString());
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B71 ", "0X8005B71 ", 0, 0, "", "", "", "");
        paramString = a();
        if (paramString != null)
        {
          paramString.jdField_a_of_type_Long = 0L;
          paramString.jdField_a_of_type_Int = paramInt;
          paramString.jdField_b_of_type_Long = paramPhoneUnityBannerData.c;
          paramString.jdField_b_of_type_Int = paramPhoneUnityBannerData.jdField_a_of_type_Int;
          paramString.c = paramPhoneUnityBannerData.e;
          a(paramString);
          b();
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
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_b_of_type_Boolean = false;
    IPhoneContactService localIPhoneContactService = null;
    Object localObject = localIPhoneContactService;
    if (paramBundle != null)
    {
      if (paramBundle.getInt("need_unify") == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_b_of_type_Boolean = bool;
      Bundle[] arrayOfBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
      localObject = localIPhoneContactService;
      if (arrayOfBundle != null)
      {
        localObject = null;
        i = 0;
        while (i < arrayOfBundle.length)
        {
          localIPhoneContactService = arrayOfBundle[i];
          int j = localIPhoneContactService.getInt("phone_type");
          if (j != 2)
          {
            if (j == 3) {
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
            this.c = bool;
          }
          i += 1;
        }
      }
    }
    localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    int i = localIPhoneContactService.getSelfBindState();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i <= 5)) {}
    while (((TextUtils.isEmpty((CharSequence)localObject)) && (i > 5)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (i >= 8)) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (i == 7)))
    {
      bool = true;
      break;
    }
    boolean bool = false;
    if (bool) {
      localIPhoneContactService.checkUpdateBindStateAndListIgnoreBindState(true, false, 13);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MobileUnityManager", 2, String.format("onGetBindInfo [%s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), localObject, paramBundle }));
    }
  }
  
  public void a(PhoneUnityVersionInfo paramPhoneUnityVersionInfo)
  {
    if (paramPhoneUnityVersionInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityVersionInfo = null;
      a().edit().remove("mobileunityversion").commit();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityVersionInfo = paramPhoneUnityVersionInfo;
    a().edit().putString("mobileunityversion", paramPhoneUnityVersionInfo.a()).commit();
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "tryShowBanner");
    }
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager
 * JD-Core Version:    0.7.0.1
 */