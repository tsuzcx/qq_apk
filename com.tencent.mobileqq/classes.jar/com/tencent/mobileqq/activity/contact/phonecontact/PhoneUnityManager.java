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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.model.PhoneContactManager;
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
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 7)) {
      return "";
    }
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, i - 8));
    localStringBuilder.append("******");
    localStringBuilder.append(paramString.substring(i - 2));
    return localStringBuilder.toString();
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
    int i = 4;
    int j = 1;
    if ((paramBundle == null) || (paramString == null) || (paramBundle.getInt("status", 0) == 4)) {
      return;
    }
    String str = paramBundle.getString("phone");
    if (paramBundle.getInt("status", 0) == 3)
    {
      if ((paramBundle.getInt("need_unify", 0) != 1) || (TextUtils.isEmpty(str))) {
        break label111;
      }
      label63:
      if (j == 0) {
        break label117;
      }
      i = 2;
    }
    label111:
    label117:
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(str))
      {
        i = 1;
        break;
      }
      i = 3;
      break;
      j = 0;
      break label63;
    }
  }
  
  private void c()
  {
    Object localObject = a();
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "tryShowBannerInner ve" + this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityVersionInfo);
    }
    if (((PhoneUnityVersionInfo)localObject).c > 0L)
    {
      ((PhoneUnityVersionInfo)localObject).c -= 1L;
      a((PhoneUnityVersionInfo)localObject);
      break label68;
    }
    label68:
    PhoneUnityBannerData localPhoneUnityBannerData;
    label341:
    for (;;)
    {
      return;
      if ((localObject != null) && (((PhoneUnityVersionInfo)localObject).jdField_a_of_type_Int != -1))
      {
        localPhoneUnityBannerData = a();
        if (QLog.isColorLevel()) {
          QLog.d("MobileUnityManager", 2, "tryShowBannerInner bd " + localPhoneUnityBannerData);
        }
        if ((localPhoneUnityBannerData == null) || (localPhoneUnityBannerData.e <= 0) || (localPhoneUnityBannerData.jdField_a_of_type_Int <= 0) || (!localPhoneUnityBannerData.jdField_a_of_type_Boolean) || (((PhoneUnityVersionInfo)localObject).jdField_b_of_type_Long <= 0L)) {
          break;
        }
        int j = 0;
        long l1 = ((PhoneUnityVersionInfo)localObject).jdField_a_of_type_Long;
        long l2 = (localPhoneUnityBannerData.jdField_b_of_type_Int + 1) * 24 * 60 * 60 * 1000;
        long l3 = System.currentTimeMillis();
        int i;
        if (l3 - l1 > l2)
        {
          ((PhoneUnityVersionInfo)localObject).jdField_a_of_type_Long = l3;
          ((PhoneUnityVersionInfo)localObject).jdField_b_of_type_Long -= 1L;
          ((PhoneUnityVersionInfo)localObject).jdField_b_of_type_Int = (localPhoneUnityBannerData.jdField_a_of_type_Int - 1);
          a((PhoneUnityVersionInfo)localObject);
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label341;
          }
          if (!((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).i()) {
            break label343;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MobileUnityManager", 2, "tryShowBannerInner already binded");
          return;
          i = j;
          if (l3 - l1 < 86400000L)
          {
            i = j;
            if (((PhoneUnityVersionInfo)localObject).jdField_b_of_type_Int > 0)
            {
              ((PhoneUnityVersionInfo)localObject).jdField_b_of_type_Long -= 1L;
              ((PhoneUnityVersionInfo)localObject).jdField_b_of_type_Int -= 1;
              a((PhoneUnityVersionInfo)localObject);
              i = 1;
            }
          }
        }
      }
    }
    label343:
    localObject = Message.obtain();
    ((Message)localObject).obj = localPhoneUnityBannerData;
    BannerManager.a().a(9, 2, (Message)localObject);
  }
  
  public int a()
  {
    return a().jdField_a_of_type_Int;
  }
  
  public SharedPreferences a()
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("PhoneUnityManager_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public PhoneUnityBannerData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData;
    }
    Object localObject = a();
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
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData = PhoneUnityBannerData.a(FileUtils.a((File)localObject));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData;
      return localObject;
    }
    catch (Exception localException)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData;
    }
    catch (IOException localIOException)
    {
      break label70;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      label70:
      break label70;
    }
  }
  
  public PhoneUnityVersionInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityVersionInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityVersionInfo;
    }
    PhoneUnityVersionInfo localPhoneUnityVersionInfo = PhoneUnityVersionInfo.a(a().getString("mobileunityversion", ""));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityVersionInfo = localPhoneUnityVersionInfo;
    return localPhoneUnityVersionInfo;
  }
  
  public String a()
  {
    Object localObject = BaseApplicationImpl.getContext();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject = ((Context)localObject).getFilesDir().getAbsolutePath() + File.separator + str + ".mobileunity";
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "getBannerConfigFilePath path = " + (String)localObject);
    }
    return localObject;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      String str;
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        if (QLog.isColorLevel()) {
          QLog.d("MobileUnityManager", 2, "saveBannerConfig " + paramString);
        }
        str = a();
        try
        {
          if (TextUtils.isEmpty(paramString))
          {
            FileUtils.e(str);
            a(null);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData = null;
            return;
          }
        }
        catch (Throwable paramString)
        {
          FileUtils.a(str, true);
          QLog.e("MobileUnityManager", 1, "", paramString);
          return;
        }
      } while (paramPhoneUnityBannerData == null);
      FileUtils.a(str);
      FileUtils.a(str, paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData = paramPhoneUnityBannerData;
      if (QLog.isColorLevel()) {
        QLog.d("MobileUnityManager", 2, "saveBannerConfig date = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B71 ", "0X8005B71 ", 0, 0, "", "", "", "");
      paramString = a();
    } while (paramString == null);
    paramString.jdField_a_of_type_Long = 0L;
    paramString.jdField_a_of_type_Int = paramInt;
    paramString.jdField_b_of_type_Long = paramPhoneUnityBannerData.c;
    paramString.jdField_b_of_type_Int = paramPhoneUnityBannerData.jdField_a_of_type_Int;
    paramString.c = paramPhoneUnityBannerData.e;
    a(paramString);
    b();
  }
  
  public void a(Bundle paramBundle)
  {
    String str = null;
    Object localObject1 = null;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_b_of_type_Boolean = false;
    Object localObject2 = str;
    boolean bool;
    if (paramBundle != null)
    {
      if (paramBundle.getInt("need_unify") == 1)
      {
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        Bundle[] arrayOfBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
        localObject2 = str;
        if (arrayOfBundle == null) {
          break label183;
        }
        i = 0;
        label67:
        localObject2 = localObject1;
        if (i >= arrayOfBundle.length) {
          break label183;
        }
        localObject2 = arrayOfBundle[i];
        switch (((Bundle)localObject2).getInt("phone_type"))
        {
        }
      }
      for (;;)
      {
        i += 1;
        break label67;
        bool = false;
        break;
        str = ((Bundle)localObject2).getString("phone");
        if ((((Bundle)localObject2).getInt("status") == 1) && (!TextUtils.isEmpty(str))) {}
        for (bool = true;; bool = false)
        {
          this.c = bool;
          break;
        }
        localObject1 = ((Bundle)localObject2).getString("phone");
      }
    }
    label183:
    localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    int i = ((PhoneContactManagerImp)localObject1).d();
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i <= 5)) {
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ((PhoneContactManagerImp)localObject1).a(true, false, 13);
      }
      if (QLog.isColorLevel()) {
        QLog.i("MobileUnityManager", 2, String.format("onGetBindInfo [%s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), localObject2, paramBundle }));
      }
      return;
      if ((TextUtils.isEmpty((CharSequence)localObject2)) && (i > 5)) {
        bool = true;
      } else if ((TextUtils.isEmpty((CharSequence)localObject2)) && (i >= 8)) {
        bool = true;
      } else if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i == 7)) {
        bool = true;
      } else {
        bool = false;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager
 * JD-Core Version:    0.7.0.1
 */