import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class awzn
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    for (;;)
    {
      try
      {
        bbaa localbbaa = (bbaa)paramQQAppInterface.getManager(193);
        if (localbbaa.a())
        {
          int i = 2;
          String str = "qboss_splash_ad_res_png";
          if (paramInt == 2)
          {
            i = 1;
            str = "qboss_splash_ad_res_video";
            j = 10082;
            QLog.i("QSplash@QbossSplashUtil", 1, "downloadPicAGifAVideoRes request adid" + paramString1);
            HashMap localHashMap = new HashMap();
            localHashMap.put("qbossSplashresAppid", paramString1);
            a("qbossSplashrequest", localHashMap);
            localbbaa.a(j, "vas", paramString2, 0, paramString2, paramString3 + ".splashtemp", i, 0, true, new awzo(paramQQAppInterface, str, paramString1, paramString3, paramInt, paramString4, paramString2));
          }
        }
        else
        {
          QLog.i("QSplash@QbossSplashUtil", 1, "ctrl.isEnable() = false");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      int j = 10081;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Collection<awzr> paramCollection)
  {
    for (;;)
    {
      awzr localawzr;
      try
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break label156;
        }
        localawzr = (awzr)paramCollection.next();
        if (!localawzr.b())
        {
          QLog.i("QSplash@QbossSplashDownloadManager", 1, "adEntry should not requestRes");
          continue;
        }
        switch (localawzr.a)
        {
        }
      }
      finally {}
      a(paramQQAppInterface, localawzr.jdField_b_of_type_JavaLangString, localawzr.e, localawzr.h, 0, localawzr.k);
      continue;
      a(paramQQAppInterface, localawzr.jdField_b_of_type_JavaLangString, localawzr.e, localawzr.h, 2, localawzr.k);
      continue;
      a(paramQQAppInterface, localawzr.jdField_b_of_type_JavaLangString, localawzr.e, localawzr.h, 1, localawzr.k);
      continue;
      label156:
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = awzm.a(BaseApplicationImpl.getContext(), paramString1);
    paramString1 = ((SharedPreferences)localObject).edit();
    QLog.i("QSplash@QbossSplashDownloadManager", 1, "pic or gif download succ! MD5 checkok");
    boolean bool = ((SharedPreferences)localObject).getBoolean("qboss_exposure_is_low_device_limit_", false);
    QLog.i("QSplash@QbossSplashDownloadManager", 1, "isLowerDeviceLimit = " + bool);
    if (!bool)
    {
      paramString1.putBoolean("qboss_splash_ad_is_limited_" + paramString2, true);
      localObject = awzq.a;
      if ((localObject != null) && (((HashMap)localObject).containsKey(paramString2))) {
        ((awzr)((HashMap)localObject).get(paramString2)).jdField_b_of_type_Boolean = true;
      }
    }
    paramString1.apply();
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null) && (!TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())))
      {
        azri.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString, true, 0L, 0L, paramHashMap, null, false);
        if (QLog.isColorLevel()) {
          QLog.i("QSplash@QbossSplashDownloadManager", 2, "reportqbossSplashBeacon, tagName  " + paramString);
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private static void b(String paramString1, AppInterface paramAppInterface, String paramString2)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      paramAppInterface = (bbaa)paramAppInterface.getManager(193);
      if (paramAppInterface.a()) {
        paramAppInterface.a(paramString1, -1L);
      }
      paramString1 = new HashMap();
      paramString1.put("qbossSplashresAppid", paramString2);
      a("qbossSplashDownloadFailed", paramString1);
      return;
    }
    catch (Exception paramString1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awzn
 * JD-Core Version:    0.7.0.1
 */