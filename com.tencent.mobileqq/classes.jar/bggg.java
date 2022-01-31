import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import common.config.service.QZoneConfigHelper.1;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

public class bggg
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_Int = 180000;
    jdField_a_of_type_JavaLangString = "qapp://detail?param=";
  }
  
  public static int a()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportSamples", 10);
  }
  
  public static long a()
  {
    return bggi.a().a("contentboxlaunch", "gocontentboxminiprogram", 0);
  }
  
  public static String a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GdtCgiReportHost", "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com");
  }
  
  public static void a(bggh parambggh)
  {
    if (parambggh != null) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneConfigHelper.1(parambggh));
    }
  }
  
  public static boolean a()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "ShowFeedOpLayer", 0);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "ShowFeedOpLayer :" + Integer.toString(i));
    }
    return i == 1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      boolean bool = ((askp)paramQQAppInterface.getManager(10)).b();
      return bool;
    }
    catch (Throwable paramQQAppInterface)
    {
      QZLog.e("QZoneMsgManager.enableQZoneContextBox", 2, paramQQAppInterface, new Object[0]);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "famousWhiteList", "1696127668,536264505,622000659,622009484,1872005011");
    boolean bool1 = bool2;
    int j;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (localObject[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String[] a()
  {
    return QzoneConfig.getInstance().getConfig("QzoneCover", "UploadQuality", "70,70,70").split(",");
  }
  
  public static int b()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "ActivitySwitchAccReportSamples", 10);
  }
  
  public static String b()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "YingyongbaoSwitchPrefix", jdField_a_of_type_JavaLangString);
  }
  
  public static boolean b()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "use_new_command", 1);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "use_new_command:" + i);
    }
    return i != 0;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "sharewhitelist", "100733645,1101218289,100497308,1103394134,1106611629,1105705811,1104466820");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].equals(paramString)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static String[] b()
  {
    return QzoneConfig.getInstance().getConfig("QzoneCover", "UploadResolution", "640*640,640*640,640*640").replace("*", ",").split(",");
  }
  
  public static int c()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportCount", 50);
  }
  
  public static String c()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_schema", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&uin={UIN}&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarSchema:" + str);
    }
    return str;
  }
  
  public static boolean c()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "can_report_task_run_at_front", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "canShareStructLongMessage", "qzone.qq.com");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.endsWith(localObject[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static int d()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportInterval", 600) * 1000;
  }
  
  public static String d()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "FeedLoveDiamond", "https://h5.qzone.qq.com/lover/vipDialog?_wv=16777219&_proxy=1&qzUseTransparentNavBar=1&friendUin={friendUin}");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getFeedLoverIconUrl:" + str);
    }
    return str;
  }
  
  public static boolean d()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "passiveBannerSwitch", 1);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getIsBubbleStyle:" + i);
    }
    return i == 1;
  }
  
  public static int e()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "DelayShowLoading", 200);
  }
  
  public static String e()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "PersonalizeMainPage", "https://h5.qzone.qq.com/show/home?_wv=131072&_fv=0&_wwv=128&_proxy=1&reddot={reddot}");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizeSettingPage:" + str);
    }
    return str;
  }
  
  public static boolean e()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "enableExtendFeeds", 1) == 1;
  }
  
  public static int f()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictBeginTime", 1170) * 60000;
  }
  
  public static String f()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "CustomVipMall", "https://h5.qzone.qq.com/personalVipStore/index?_wv=2098179&refresh=1&qua={qua}&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizeVipHomePage:" + str);
    }
    return str;
  }
  
  public static boolean f()
  {
    return (QzoneConfig.getInstance().getConfig("K_QZKuolieEnterance", "SK_QZKuoliePartyEnteranceConfig", 0) == 1) && (Build.VERSION.SDK_INT > 20);
  }
  
  public static int g()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictEndTime", 1440) * 60000;
  }
  
  public static String g()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "CustomVipPreview", "https://h5.qzone.qq.com/personalVipStore/detail/{id}?_wv=2098179&qua={qua}&router=detail&id={id}&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizePreview:" + str);
    }
    return str;
  }
  
  public static boolean g()
  {
    return QzoneConfig.getInstance().getConfigSync("QZoneSetting", "timecapsule_default_expand", 0) == 1;
  }
  
  public static int h()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FriendMaxSelectCount", 30)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 30;
  }
  
  public static String h()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "PassivePraisePreview", "https://h5.qzone.qq.com/show/passivelike/preview?id={id}&prevPath=mall&_proxy=1&_wv=2098179");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizePreview:" + str);
    }
    return str;
  }
  
  public static int i()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedBannerDuration", 7000)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10000;
  }
  
  public static String i()
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "DressUpGroupUrl", "https://h5.qzone.qq.com/show/record/{uin}/{type}?_wv=2&_proxy=1");
  }
  
  public static int j()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedBannerActiveMaxCount", 5)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 5;
  }
  
  public static String j()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "passiveText", "消息");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPassiveTabName:" + str);
    }
    return str;
  }
  
  public static int k()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FriendMaxSelectCountComment", 10)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10;
  }
  
  public static int l()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictFlag", 0);
  }
  
  public static int m()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_music_visiable", 0);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeMusicBarShow:" + i);
    }
    return i;
  }
  
  public static int n()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextCount", 2000);
  }
  
  public static int o()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxCommentBubbleTextCount", 40);
  }
  
  public static int p()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextVisibleLineCount", 7);
  }
  
  public static int q()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "DetailMaxPicShowNum", 18);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizeSettingPage:" + i);
    }
    return i;
  }
  
  public static int r()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "max_pending_report_task_num", 1000);
  }
  
  public static int s()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "max_report_task_pengding_day", 3);
  }
  
  public static int t()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "avatar_timeout", 1500);
  }
  
  public static int u()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedsShowPhotoBubble", 0);
  }
  
  public static int v()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedsShowMoodEntry", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bggg
 * JD-Core Version:    0.7.0.1
 */