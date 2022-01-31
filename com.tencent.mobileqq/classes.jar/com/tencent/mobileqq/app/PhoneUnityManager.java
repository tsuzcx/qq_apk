package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParserException;
import zgd;
import zge;

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
  public Bundle b;
  Runnable b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public PhoneUnityManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable = new zgd(this);
    this.jdField_b_of_type_JavaLangRunnable = new zge(this);
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
  
  private void d()
  {
    Object localObject = a();
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "tryShowBannerInner ve" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityVersionInfo);
    }
    if (((PhoneUnityVersionInfo)localObject).c > 0L)
    {
      ((PhoneUnityVersionInfo)localObject).c -= 1L;
      a((PhoneUnityVersionInfo)localObject);
    }
    label68:
    PhoneUnityBannerData localPhoneUnityBannerData;
    label340:
    label342:
    do
    {
      break label68;
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
              break label340;
            }
            if (!((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).g()) {
              break label342;
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    } while (localObject == null);
    Message localMessage = Message.obtain();
    localMessage.what = 1040;
    localMessage.obj = localPhoneUnityBannerData;
    ((MqqHandler)localObject).sendMessage(localMessage);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityBannerData != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityBannerData;
    }
    Object localObject = a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityBannerData = null;
      return null;
    }
    BaseApplicationImpl.getContext();
    localObject = new File((String)localObject);
    try
    {
      if (((File)localObject).exists()) {
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityBannerData = PhoneUnityBannerData.a(FileUtils.a((File)localObject));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityBannerData;
      return localObject;
    }
    catch (Exception localException)
    {
      return this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityBannerData;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityVersionInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityVersionInfo;
    }
    PhoneUnityVersionInfo localPhoneUnityVersionInfo = PhoneUnityVersionInfo.a(a().getString("mobileunityversion", ""));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityVersionInfo = localPhoneUnityVersionInfo;
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
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(34);
    if (localSecSvcHandler != null) {
      localSecSvcHandler.a(paramInt1, paramInt2, paramString1, paramString2);
    }
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
            FileUtils.d(str);
            a(null);
            this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityBannerData = null;
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
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityBannerData = paramPhoneUnityBannerData;
      if (QLog.isColorLevel()) {
        QLog.d("MobileUnityManager", 2, "saveBannerConfig date = " + this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityBannerData);
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
    this.d = true;
    this.jdField_b_of_type_AndroidOsBundle = paramBundle;
    if (paramBundle == null)
    {
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.jdField_a_of_type_AndroidOsBundle = null;
      return;
    }
    PhoneContactManagerImp localPhoneContactManagerImp;
    if (paramBundle.getInt("src") == 0)
    {
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("phone")))
      {
        localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (!localPhoneContactManagerImp.g()) {
          localPhoneContactManagerImp.a(true, false);
        }
      }
    }
    if (paramBundle.getInt("need_unify") == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      paramBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
      if (paramBundle == null) {
        break;
      }
      int i = 0;
      while (i < paramBundle.length)
      {
        localPhoneContactManagerImp = paramBundle[i];
        int j = localPhoneContactManagerImp.getInt("phone_type");
        localPhoneContactManagerImp.getString("phone");
        switch (j)
        {
        case 1: 
        case 2: 
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          i += 1;
        }
      }
    }
    if (localPhoneContactManagerImp.getInt("status") == 2) {}
    for (bool = true;; bool = false)
    {
      this.c = bool;
      break;
    }
  }
  
  public void a(PhoneUnityVersionInfo paramPhoneUnityVersionInfo)
  {
    if (paramPhoneUnityVersionInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityVersionInfo = null;
      a().edit().remove("mobileunityversion").commit();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityVersionInfo = paramPhoneUnityVersionInfo;
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
  
  public void c()
  {
    long l2 = a().getLong("mobileunity_reqtime", 0L);
    long l1 = System.currentTimeMillis();
    l2 = l1 - l2;
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, new Object[] { "getPhoneUnityInfoUnderCtrl ", Long.valueOf(l2) });
    }
    if ((l2 > 3600000L) || (l2 < 0L))
    {
      a(0, 31, null, null);
      a().edit().putLong("mobileunity_reqtime", l1).commit();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneUnityManager
 * JD-Core Version:    0.7.0.1
 */