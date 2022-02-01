import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class bcxa
{
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:APPID=" + AppSetting.a() + " subVersion=" + "8.4.10" + " buildnum=" + "4875", null);
    String str;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      str = "new_qq_android_native_short_video_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 65)
        {
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInShortVideo=" + 65, null);
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
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInArt=" + 9, null);
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
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
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
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
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
        return bhld.a(paramSVConfigItem);
      }
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_"))
      {
        str = "new_qq_android_native_portrait_filter_" + paramSVConfigItem.versionCode;
        if (paramSVConfigItem.name.equalsIgnoreCase(str))
        {
          if (paramSVConfigItem.versionCode < 9)
          {
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPortrait=" + 9, null);
            return -2;
          }
        }
        else {
          return -4;
        }
      }
      else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_"))
      {
        return bcyi.a(paramSVConfigItem);
      }
    }
    return 0;
  }
  
  public static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    boolean bool1 = true;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      boolean bool2 = VideoEnvironment.needDownloadCurrentServerVersion(paramSVConfigItem.versionCode);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload[Builtin Mode]:needDownload=" + bool2 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      bool1 = bool2;
      if (bool2) {
        bool1 = VideoEnvironment.supportShortVideoDownloadSo(paramAppInterface);
      }
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:needDownload=" + bool1 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      return bool1;
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
        bool1 = bcww.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
        bool1 = bcxh.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        bool1 = bhld.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        bool1 = bcxi.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_")) {
        bool1 = bcyi.a(paramAppInterface, paramSVConfigItem);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.checkAVCodecLoadIsOK(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return bcww.a();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return bcxh.a();
    }
    if (paramString.startsWith("msf_quic_lib")) {
      return bhld.a(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return bcxi.a();
    }
    if (paramString.startsWith("new_qq_android_native_object_tracking_")) {
      return bcyi.a();
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
      bool = VideoEnvironment.uncompressZipSo(paramQQAppInterface, paramString3, paramInt);
      if (bool) {
        VideoEnvironment.Notify(false, paramQQAppInterface);
      }
    }
    for (;;)
    {
      return bool;
      VideoEnvironment.Notify(true, paramQQAppInterface);
      continue;
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        bool = bcww.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else if (paramString1.startsWith("new_qq_android_native_short_other_")) {
        bool = bcxh.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else if (paramString1.startsWith("msf_quic_lib")) {
        bool = bhld.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
        bool = bcxi.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        bool = bcyi.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      } else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxa
 * JD-Core Version:    0.7.0.1
 */