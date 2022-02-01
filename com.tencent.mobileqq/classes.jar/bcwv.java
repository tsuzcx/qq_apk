import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class bcwv
{
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    VideoEnvironment.a("ShortVideoResourceManager", "userCheckNeedDownload:APPID=" + AppSetting.a() + " subVersion=" + "8.4.5" + " buildnum=" + "4745", null);
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
        return bhwb.a(paramSVConfigItem);
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
      else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_"))
      {
        return bcye.a(paramSVConfigItem);
      }
    }
    return 0;
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
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
        bool1 = bcwr.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
        bool1 = bcxd.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        bool1 = bhwb.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        bool1 = bcxe.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_")) {
        bool1 = bcye.a(paramAppInterface, paramSVConfigItem);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.e(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return bcwr.a();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return bcxd.a();
    }
    if (paramString.startsWith("msf_quic_lib")) {
      return bhwb.a(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return bcxe.a();
    }
    if (paramString.startsWith("new_qq_android_native_object_tracking_")) {
      return bcye.a();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 == null) {
      return false;
    }
    boolean bool;
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      bool = VideoEnvironment.a(paramQQAppInterface, paramString3, paramInt);
      if (bool) {
        VideoEnvironment.a(false, paramQQAppInterface);
      }
    }
    for (;;)
    {
      return bool;
      VideoEnvironment.a(true, paramQQAppInterface);
      continue;
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        bool = bcwr.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else if (paramString1.startsWith("new_qq_android_native_short_other_")) {
        bool = bcxd.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else if (paramString1.startsWith("msf_quic_lib")) {
        bool = bhwb.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
        bool = bcxe.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        bool = bcye.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwv
 * JD-Core Version:    0.7.0.1
 */