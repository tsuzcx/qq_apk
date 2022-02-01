import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.AvatarPendantUtil.1;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public final class bfua
{
  public static int a;
  private static long a;
  public static String a;
  public static final ArrayList<String> a;
  public static ConcurrentHashMap<Long, Integer> a;
  public static volatile boolean a;
  public static final String b;
  public static ConcurrentHashMap<Long, Integer> b;
  public static String c;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaLangString = "https://i.gtimg.cn/qqshow/admindata/comdata/AndroidIconZip/icon.zip";
    jdField_b_of_type_JavaLangString = AppConstants.SDCARD_PATH + "avatarPendantIcons";
    c = jdField_b_of_type_JavaLangString + "/icon";
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Int = 5000;
    jdField_a_of_type_Long = -1L;
  }
  
  public static float a(Paint paramPaint, Rect paramRect, String paramString)
  {
    int i = paramRect.width();
    float f2;
    if (i <= 0)
    {
      f2 = 0.0F;
      return f2;
    }
    paramPaint = new TextPaint(paramPaint);
    float f1 = paramRect.height();
    paramPaint.setTextSize(f1);
    for (;;)
    {
      if (paramPaint.measureText(paramString) <= i)
      {
        f2 = f1;
        if (Math.ceil(paramPaint.getFontMetrics().descent - paramPaint.getFontMetrics().ascent) <= paramRect.height()) {
          break;
        }
      }
      f2 = f1;
      if (f1 <= 0.0F) {
        break;
      }
      f1 -= 1.0F;
      paramPaint.setTextSize(f1);
    }
  }
  
  public static String a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("pendant.");
    localStringBuilder.append(paramLong);
    switch (paramInt)
    {
    case 3: 
    default: 
      localStringBuilder.append(".other.zip");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(".xydata.js");
      continue;
      localStringBuilder.append(".other.zip");
      continue;
      localStringBuilder.append(".aio_50.png");
    }
  }
  
  public static String a(File paramFile)
  {
    String str2 = "";
    String str1 = str2;
    if (paramFile != null)
    {
      str1 = str2;
      if (!paramFile.exists()) {}
    }
    try
    {
      paramFile = new String(FileUtils.fileToBytes(paramFile));
      int i = paramFile.indexOf("\"seriesID\":");
      str1 = str2;
      if (i != -1)
      {
        int j = paramFile.indexOf(",", i + 10);
        str1 = str2;
        if (j != -1) {
          str1 = paramFile.substring(i + 11, j);
        }
      }
      return str1;
    }
    catch (Exception paramFile) {}
    return "";
  }
  
  public static String a(String paramString)
  {
    return AppConstants.SDCARD_PENDANT_ROOT + "font_info/" + paramString + File.separator + paramString + ".ttf";
  }
  
  public static void a()
  {
    File localFile = new File(AppConstants.SDCARD_PATH + "avatarPendantDefaultHead");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(AppConstants.SDCARD_PENDANT_ROOT);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "saveMarketOpenTime, entrance=" + paramString1 + ", uin=" + paramString2 + ", context=" + paramContext);
      }
    }
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences(String.format("sp_pendant_market_open_time_%s", new Object[] { paramString2 }), 0);
    } while (paramContext == null);
    paramContext.edit().putLong(paramString1, paramLong).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, size=" + jdField_a_of_type_JavaUtilArrayList.size());
    }
    long l = 0L;
    boolean bool2;
    label65:
    boolean bool1;
    if (jdField_a_of_type_JavaUtilArrayList.size() >= 5)
    {
      bool2 = true;
      if (jdField_a_of_type_Long == -1L) {
        break label225;
      }
      l = System.currentTimeMillis() - jdField_a_of_type_Long;
      if (l < jdField_a_of_type_Int) {
        break label173;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, thresholdReached=" + bool2 + ", intervalReached=" + bool1);
      }
      if ((!bool2) && (!bool1) && (jdField_a_of_type_Boolean))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, condition unavailable, abort");
        return;
        bool2 = false;
        break label65;
        label173:
        bool1 = false;
        continue;
      }
      paramQQAppInterface = new AvatarPendantUtil.1(paramQQAppInterface);
      if ((bool2) || (bool1))
      {
        ThreadManagerV2.excute(paramQQAppInterface, 128, null, false);
        return;
      }
      jdField_a_of_type_Boolean = true;
      ThreadManager.getUIHandler().postDelayed(paramQQAppInterface, jdField_a_of_type_Int - l);
      return;
      label225:
      bool1 = true;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    a(paramQQAppInterface, paramContext, true, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, aufo paramaufo)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, entrance=" + paramString1 + ", uin=" + paramString2 + ", context=" + paramContext + ", app=" + paramQQAppInterface);
      }
    }
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while (paramQQAppInterface == null);
        paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13);
        if (paramQQAppInterface == null) {
          break;
        }
        l = paramContext.getSharedPreferences(String.format("sp_pendant_market_open_time_%s", new Object[] { paramString2 }), 0).getLong(paramString1, 0L);
      } while (System.currentTimeMillis() - l >= 604800000L);
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, startWebProcess");
      }
      paramQQAppInterface.a(-1, new bfub(paramaufo));
      return;
    } while (!QLog.isColorLevel());
    QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, web process alive aready");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Intent localIntent;
    int i;
    azvi localazvi;
    int j;
    label127:
    int k;
    label142:
    int m;
    label157:
    int n;
    label172:
    int i1;
    label187:
    int i2;
    if (paramAllInOne != null)
    {
      localIntent = new Intent(paramContext, AvatarPendantActivity.class);
      localIntent.putExtra("AllInOne", paramAllInOne);
      bboi localbboi = (bboi)paramQQAppInterface.getManager(12);
      i = localbboi.a("100005.100006");
      if ((i == 1) || (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "Clear pendant red flag");
        }
        localIntent.putExtra("key_update_flag", true);
        localazvi = (azvi)paramQQAppInterface.getManager(36);
        localazvi.b("100005.100006");
        if (localbboi.a("100005.100003") == -1) {
          break label445;
        }
        j = 1;
        if (localbboi.a("100005.100002") == -1) {
          break label451;
        }
        k = 1;
        if (localbboi.a("100005.100001") == -1) {
          break label457;
        }
        m = 1;
        if (localbboi.a("100005.100018") == -1) {
          break label463;
        }
        n = 1;
        if (localbboi.a("100005.100020") == -1) {
          break label469;
        }
        i1 = 1;
        if (localbboi.a("100005.100021") == -1) {
          break label475;
        }
        i2 = 1;
        label202:
        if (!((gb)paramQQAppInterface.getManager(42)).jdField_a_of_type_Boolean) {
          break label495;
        }
        if (localbboi.a("100005.100011") == -1) {
          break label481;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label232:
      if ((j == 0) && (k == 0) && (m == 0) && (n == 0) && (i == 0) && (i1 == 0) && (i2 == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "Clear parent red flag");
        }
        localazvi.b("100005");
      }
      if (paramAllInOne == null)
      {
        localIntent.putExtra("hide_left_button", false);
        localIntent.putExtra("show_right_close_button", false);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("url", bgev.a(paramContext, "pendant", ""));
        localIntent.putExtra("business", 512L);
        if (!paramBoolean) {
          break label487;
        }
      }
      label445:
      label451:
      label457:
      label463:
      label469:
      label475:
      label481:
      label487:
      for (i = 40202;; i = 40201)
      {
        localIntent.putExtra("individuation_url_type", i);
        VasWebviewUtil.insertVasWbPluginToIntent(512L, localIntent);
        localIntent.putExtra("isShowAd", false);
        paramContext.startActivity(localIntent);
        bcef.b(paramQQAppInterface, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
        return;
        localIntent = new Intent(paramContext, QQBrowserActivity.class);
        break;
        j = 0;
        break label127;
        k = 0;
        break label142;
        m = 0;
        break label157;
        n = 0;
        break label172;
        i1 = 0;
        break label187;
        i2 = 0;
        break label202;
        i = 0;
        break label232;
      }
      label495:
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((VasExtensionHandler)paramQQAppInterface.getBusinessHandler(71)).a(new String[] { paramString }, new int[] { 27235 });
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
        return;
      }
    }
    jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public static boolean a(long paramLong)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localInteger == null) {
      return true;
    }
    if (localInteger.intValue() == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(a(paramString)).exists();
  }
  
  public static String b(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT).append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("aio_50.png");
      continue;
      localStringBuilder.append("aio_file.zip");
      continue;
      localStringBuilder.append("aio_file");
      continue;
      localStringBuilder.append("preview_50.png");
      continue;
      localStringBuilder.append("market_dynamic_50.gif");
      continue;
      localStringBuilder.append("thumb_nail_50.png");
      continue;
      localStringBuilder.append("config.json");
      continue;
      localStringBuilder.append("avatarfit.png");
    }
  }
  
  public static String b(String paramString)
  {
    return AppConstants.SDCARD_PENDANT_ROOT + "font_info/" + paramString + "/";
  }
  
  public static boolean b(long paramLong)
  {
    Integer localInteger = (Integer)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantUtil", 2, "isDiy=" + localInteger);
    }
    if (localInteger == null) {
      return true;
    }
    if ((localInteger.intValue() == 1) || (localInteger.intValue() == 2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(String paramString)
  {
    paramString = paramString.replace("faceAddon.sticker.", "");
    return new File(AppConstants.SDCARD_PENDANT_ROOT + "sticker_info", paramString).exists();
  }
  
  public static String c(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipFaceAddon_").append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return aqyy.a("VIP_avatar", localStringBuilder.toString());
      localStringBuilder.append("aio_50.png");
      continue;
      localStringBuilder.append("aio_file.zip");
      continue;
      localStringBuilder.append("list_50.png");
      continue;
      localStringBuilder.append("preview_50.gif");
      continue;
      localStringBuilder.append("thumb_nail_50.png");
      continue;
      localStringBuilder.append("xydata.js");
      continue;
      localStringBuilder.append("avatarfit.png");
    }
  }
  
  public static String c(String paramString)
  {
    return AppConstants.SDCARD_PENDANT_ROOT + "sticker_info/" + paramString + ".png";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfua
 * JD-Core Version:    0.7.0.1
 */