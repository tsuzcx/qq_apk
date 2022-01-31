import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class axdr
{
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:APPID=" + AppSetting.a() + " subVersion=" + "8.3.0" + " buildnum=" + "4480", null);
    String str;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      str = "new_qq_android_native_short_video_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 65)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInShortVideo=" + 65, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_filter_"))
    {
      str = "new_qq_android_native_short_filter_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 62)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPendant=" + 62, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_"))
    {
      str = "new_qq_android_native_art_filter_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 9)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInArt=" + 9, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_new_other_"))
    {
      str = "new_qq_android_native_short_new_other_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 1)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_"))
    {
      str = "new_qq_android_native_short_other_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 1)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else
    {
      if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        return bbnv.a(paramSVConfigItem);
      }
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_"))
      {
        str = "new_qq_android_native_portrait_filter_" + paramSVConfigItem.versionCode;
        if (paramSVConfigItem.name.equalsIgnoreCase(str))
        {
          if (paramSVConfigItem.versionCode < 9)
          {
            VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPortrait=" + 9, null);
            return -2;
          }
        }
        else {
          return -4;
        }
      }
      else
      {
        if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_")) {
          return axex.a(paramSVConfigItem);
        }
        if (paramSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_")) {
          return axeh.a(paramSVConfigItem);
        }
      }
    }
    return 0;
  }
  
  private static boolean a()
  {
    boolean bool = llw.e();
    VideoEnvironment.a("ShortVideoResourceManager", "isArmV7aAndNeon:isNeon=" + bool + ",SDK_INT=" + Build.VERSION.SDK_INT, null);
    return (bool) && (Build.VERSION.SDK_INT >= 15);
  }
  
  public static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    boolean bool1 = true;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      boolean bool2 = VideoEnvironment.a(paramSVConfigItem.versionCode);
      VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload[Builtin Mode]:needDownload=" + bool2 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      bool1 = bool2;
      if (bool2) {
        bool1 = VideoEnvironment.d(paramAppInterface);
      }
    }
    for (;;)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:needDownload=" + bool1 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      return bool1;
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_filter_")) {
        bool1 = a();
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
        bool1 = axdn.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
        bool1 = axdz.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        bool1 = bbnv.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        bool1 = axea.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_")) {
        bool1 = axex.a(paramAppInterface, paramSVConfigItem);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.e(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_short_filter_")) {
      return axle.a(VideoEnvironment.a());
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return axdn.a();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return axdz.a();
    }
    if (paramString.startsWith("msf_quic_lib")) {
      return bbnv.a(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return axea.a();
    }
    if (paramString.startsWith("new_qq_android_native_object_tracking_")) {
      return axex.a();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool1 = true;
    if (paramString1 == null) {}
    do
    {
      return false;
      if (paramString1.startsWith("new_qq_android_native_short_video_"))
      {
        bool1 = VideoEnvironment.a(paramQQAppInterface, paramString3, paramInt);
        if (bool1)
        {
          VideoEnvironment.a(false, paramQQAppInterface);
          return bool1;
        }
        VideoEnvironment.a(true, paramQQAppInterface);
        return bool1;
      }
      if (paramString1.startsWith("new_qq_android_native_short_filter_"))
      {
        boolean bool2 = axde.a(paramString2, paramString3);
        if (!bool2) {}
        for (;;)
        {
          axde.a(bool1);
          return bool2;
          bool1 = false;
        }
      }
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        return axdn.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_short_other_")) {
        return axdz.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("msf_quic_lib")) {
        return bbnv.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
        return axea.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        return axex.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
    } while (!paramString1.startsWith("new_qq_android_native_ptu_res_"));
    return axeh.a(paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axdr
 * JD-Core Version:    0.7.0.1
 */