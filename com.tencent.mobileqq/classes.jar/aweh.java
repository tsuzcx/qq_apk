import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class aweh
{
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:APPID=" + AppSetting.a() + " subVersion=" + "8.2.6" + " buildnum=" + "4370", null);
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
        if (paramSVConfigItem.versionCode < 59)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPendant=" + 59, null);
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
        if (paramSVConfigItem.versionCode < 7)
        {
          VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInArt=" + 7, null);
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
        return ball.a(paramSVConfigItem);
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
          return awfn.a(paramSVConfigItem);
        }
        if (paramSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_")) {
          return awex.a(paramSVConfigItem);
        }
      }
    }
    return 0;
  }
  
  private static boolean a()
  {
    boolean bool = lbk.e();
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
        bool1 = awed.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
        bool1 = awep.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        bool1 = ball.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        bool1 = aweq.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_")) {
        bool1 = awfn.a(paramAppInterface, paramSVConfigItem);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.e(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_short_filter_")) {
      return awlw.a(VideoEnvironment.a());
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return awed.a();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return awep.a();
    }
    if (paramString.startsWith("msf_quic_lib")) {
      return ball.a(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return aweq.a();
    }
    if (paramString.startsWith("new_qq_android_native_object_tracking_")) {
      return awfn.a();
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
        boolean bool2 = awdu.a(paramString2, paramString3);
        if (!bool2) {}
        for (;;)
        {
          awdu.a(bool1);
          return bool2;
          bool1 = false;
        }
      }
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        return awed.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_short_other_")) {
        return awep.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("msf_quic_lib")) {
        return ball.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
        return aweq.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        return awfn.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
    } while (!paramString1.startsWith("new_qq_android_native_ptu_res_"));
    return awex.a(paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aweh
 * JD-Core Version:    0.7.0.1
 */