import android.os.Build.VERSION;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import dov.com.tencent.mobileqq.shortvideo.PendantVersionManager;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoArtResourceMgr;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoPortraitResourceManager;

public class anyz
{
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      str = "new_qq_android_native_short_video_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str)) {
        if (paramSVConfigItem.versionCode >= 56) {
          break label115;
        }
      }
    }
    do
    {
      return -2;
      return -4;
      if (!paramSVConfigItem.name.startsWith("new_qq_android_native_short_filter_")) {
        break label120;
      }
      str = "new_qq_android_native_short_filter_" + paramSVConfigItem.versionCode;
      if (!paramSVConfigItem.name.equalsIgnoreCase(str)) {
        break;
      }
    } while (paramSVConfigItem.versionCode < 2);
    label115:
    label120:
    do
    {
      do
      {
        do
        {
          do
          {
            return 0;
            return -4;
            if (!paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
              break label180;
            }
            str = "new_qq_android_native_art_filter_" + paramSVConfigItem.versionCode;
            if (!paramSVConfigItem.name.equalsIgnoreCase(str)) {
              break;
            }
          } while (paramSVConfigItem.versionCode >= 3);
          return -2;
          return -4;
          if (!paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
            break label240;
          }
          str = "new_qq_android_native_short_other_" + paramSVConfigItem.versionCode;
          if (!paramSVConfigItem.name.equalsIgnoreCase(str)) {
            break;
          }
        } while (paramSVConfigItem.versionCode >= 1);
        return -2;
        return -4;
      } while (!paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_"));
      str = "new_qq_android_native_portrait_filter_" + paramSVConfigItem.versionCode;
      if (!paramSVConfigItem.name.equalsIgnoreCase(str)) {
        break;
      }
    } while (paramSVConfigItem.versionCode >= 4);
    label180:
    label240:
    return -2;
    return -4;
  }
  
  private static boolean a()
  {
    boolean bool = VcSystemInfo.e();
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
        bool1 = ShortVideoArtResourceMgr.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
        bool1 = anza.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        bool1 = ShortVideoPortraitResourceManager.a(paramAppInterface, paramSVConfigItem);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.e(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_short_filter_")) {
      return PtvFilterSoLoad.b(VideoEnvironment.a());
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return ShortVideoArtResourceMgr.a();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return anza.a();
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return SoLoader.f();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      bool1 = VideoEnvironment.a(paramQQAppInterface, paramString3, paramInt);
      if (bool1) {
        VideoEnvironment.a(false, paramQQAppInterface);
      }
    }
    do
    {
      return bool1;
      VideoEnvironment.a(true, paramQQAppInterface);
      return bool1;
      if (paramString1.startsWith("new_qq_android_native_short_filter_"))
      {
        bool2 = PendantVersionManager.a(paramString2, paramString3);
        if (!bool2) {}
        for (;;)
        {
          PendantVersionManager.a(bool1);
          return bool2;
          bool1 = false;
        }
      }
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        return ShortVideoArtResourceMgr.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_short_other_")) {
        return anza.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      bool1 = bool2;
    } while (!paramString1.startsWith("new_qq_android_native_portrait_filter_"));
    return ShortVideoPortraitResourceManager.a(paramQQAppInterface, paramString2, paramString3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyz
 * JD-Core Version:    0.7.0.1
 */