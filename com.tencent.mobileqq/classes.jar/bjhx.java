import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class bjhx
{
  private static bjib jdField_a_of_type_Bjib;
  private static Object jdField_a_of_type_JavaLangObject;
  private static String jdField_a_of_type_JavaLangString = "";
  private static final HashMap<String, bjhz> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean;
  private static String jdField_b_of_type_JavaLangString;
  private static HashMap<String, String> jdField_b_of_type_JavaUtilHashMap;
  private static HashMap<String, Boolean> c;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    c = new HashMap();
  }
  
  public static final long a()
  {
    if (!a()) {
      return -1L;
    }
    Object localObject = p();
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getBlockCount();
      return i * l;
    }
    catch (Exception localException)
    {
      QLog.e("CacheManager", 1, "", localException);
    }
    return -1L;
  }
  
  public static bjhz a()
  {
    return a("audio", 104857600, 41943040);
  }
  
  public static bjhz a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      AssertUtil.assertTrue(bool);
      synchronized (jdField_a_of_type_JavaUtilHashMap)
      {
        bjhz localbjhz2 = (bjhz)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        bjhz localbjhz1 = localbjhz2;
        if (localbjhz2 == null)
        {
          localbjhz1 = new bjhz(paramString, 1, paramInt1, paramInt2);
          localbjhz1.a(a());
          jdField_a_of_type_JavaUtilHashMap.put(paramString, localbjhz1);
        }
        return localbjhz1;
      }
      bool = false;
    }
  }
  
  public static bjib a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bjib == null) {
        jdField_a_of_type_Bjib = new bjib(new bjhy());
      }
      return jdField_a_of_type_Bjib;
    }
  }
  
  public static final String a()
  {
    return d().a();
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "byte";
    }
    if (paramInt == 1) {
      return "KB";
    }
    if (paramInt == 2) {
      return "MB";
    }
    if (paramInt == 3) {
      return "GB";
    }
    if (paramInt == 4) {
      return "TB";
    }
    if (paramInt == 5) {
      return "PB";
    }
    return "";
  }
  
  private static final String a(int paramInt, float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return "";
    }
    if (paramFloat < 1024.0F) {
      return String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }) + a(paramInt);
    }
    return a(paramInt + 1, paramFloat / 1024.0F);
  }
  
  private static final String a(long paramLong)
  {
    return a(0, (float)paramLong);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = c(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      int i = paramString.hashCode();
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        paramContext = bjih.q;
        if (paramContext != null) {
          break label95;
        }
      }
      label95:
      for (paramContext = null;; paramContext = paramContext + File.separator + String.valueOf(i))
      {
        return paramContext;
        paramContext = paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone" + File.separator + "image";
        break;
      }
      paramString = str;
    }
  }
  
  public static String a(String paramString)
  {
    String str = p();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString = new File(str + File.separator + paramString);
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return a(paramString);
  }
  
  public static void a()
  {
    c.clear();
    jdField_a_of_type_Boolean = false;
    a(false);
  }
  
  public static void a(long paramLong)
  {
    b(paramLong);
  }
  
  public static void a(Context paramContext)
  {
    paramContext = bjih.q;
    if (paramContext != null) {
      arso.c(paramContext);
    }
    arso.c(bjih.t);
    paramContext = bjih.r;
    if (paramContext != null) {
      arso.c(paramContext);
    }
    arso.c(bjih.s);
    paramContext = bjih.u;
    if (paramContext != null) {
      arso.c(paramContext);
    }
    paramContext = bjih.v;
    if (paramContext != null) {
      arso.c(paramContext);
    }
    paramContext = p();
    if (paramContext != null) {
      arso.c(paramContext);
    }
    paramContext = n();
    if (paramContext != null) {
      arso.c(paramContext);
    }
  }
  
  static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        jdField_b_of_type_JavaLangString = n();
        File localFile = new File(jdField_b_of_type_JavaLangString);
        if ((!localFile.exists()) && (!localFile.mkdirs()) && (QLog.isColorLevel())) {
          QLog.w("CacheManager", 2, "Unable to create external cache directory");
        }
        if (!localFile.exists()) {
          return;
        }
        localFile = new File(jdField_b_of_type_JavaLangString, ".nomedia");
        if (localFile.exists()) {
          return;
        }
        localFile.createNewFile();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("CacheManager", 1, "", localException);
      }
      jdField_b_of_type_JavaLangString = bjih.jdField_b_of_type_JavaLangString;
    }
  }
  
  public static boolean a()
  {
    return SDCardMountMonitorReceiver.a().a();
  }
  
  public static boolean a(String paramString)
  {
    String str = Environment.getDataDirectory().getAbsolutePath();
    return (paramString != null) && (paramString.startsWith(str));
  }
  
  public static final long b()
  {
    if (!a()) {
      return -1L;
    }
    Object localObject = p();
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getAvailableBlocks();
      return i * l;
    }
    catch (Exception localException)
    {
      QLog.e("CacheManager", 1, "", localException);
    }
    return -1L;
  }
  
  public static bjhz b()
  {
    return a("offline", 104857600, 20971520);
  }
  
  public static String b()
  {
    return a("video");
  }
  
  public static String b(String paramString)
  {
    String str = n();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString = new File(str + File.separator + paramString);
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static void b()
  {
    a();
    f();
    b();
    d();
    h();
    a().a();
  }
  
  private static void b(long paramLong)
  {
    String str1 = LocalMultiProcConfig.getString("qua", "");
    String str2 = bjdm.a();
    if (!str1.equals(str2))
    {
      LocalMultiProcConfig.putString4Uin("getMapLastGetTime", "", paramLong);
      LocalMultiProcConfig.putString("qua", str2);
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        return true;
      }
    } while (!URLUtil.isNetworkUrl(paramString));
    return true;
  }
  
  public static bjhz c()
  {
    return a("zip_cache", 104857600, 20971520);
  }
  
  public static String c()
  {
    Object localObject = bjih.jdField_b_of_type_JavaLangString;
    if (localObject != null)
    {
      File localFile = new File((String)localObject);
      if (localFile.isFile()) {
        FileUtils.delete(localFile);
      }
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    localObject = new File((String)localObject + File.separator + "video_cache");
    if (((File)localObject).isFile()) {
      FileUtils.delete((File)localObject);
    }
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return ((File)localObject).getAbsolutePath();
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (b(paramString))
    {
      int k = paramString.indexOf('/', 8);
      int j = paramString.indexOf("ek=1");
      int i = j;
      if (j == -1)
      {
        j = paramString.indexOf('#');
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
      }
      str = paramString.substring(k + 1, i);
    }
    return str;
  }
  
  public static boolean c(String paramString)
  {
    localObject = (Boolean)c.get(paramString);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    bool2 = false;
    bool1 = false;
    long l = Thread.currentThread().getId();
    localObject = new File(paramString + "/qz" + l);
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          continue;
        }
        if (((File)localObject).delete()) {
          bool1 = ((File)localObject).createNewFile();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CacheManager", 1, "", localThrowable);
        ((File)localObject).delete();
        bool1 = bool2;
        continue;
      }
      finally
      {
        ((File)localObject).delete();
      }
      c.put(paramString, Boolean.valueOf(bool1));
      return bool1;
      bool1 = ((File)localObject).createNewFile();
    }
  }
  
  public static bjhz d()
  {
    return a("personalise_font", 104857600, 41943040);
  }
  
  public static String d()
  {
    return a("rapid_comment");
  }
  
  public static bjhz e()
  {
    return a("qzone_widgetai", 104857600, 20971520);
  }
  
  public static String e()
  {
    return a("gift_fullscreen");
  }
  
  public static bjhz f()
  {
    return a("avatar", 52428800, 20971520);
  }
  
  public static String f()
  {
    return a("passive_praise");
  }
  
  public static bjhz g()
  {
    return a("personality_canvas", 2097152, 1048576);
  }
  
  public static String g()
  {
    return a("dehaze_pic");
  }
  
  public static bjhz h()
  {
    return a("batch_image", 104857600, 62914560);
  }
  
  public static String h()
  {
    return a("plus_operation");
  }
  
  public static String i()
  {
    return a("plus_decorate");
  }
  
  public static String j()
  {
    return a("moodlistIcons");
  }
  
  public static String k()
  {
    return a("head_drop_operaion");
  }
  
  public static String l()
  {
    return a("surprise");
  }
  
  public static String m()
  {
    return a("smart_beautify");
  }
  
  public static String n()
  {
    File localFile = BaseApplicationImpl.getContext().getCacheDir();
    if (localFile != null) {
      return localFile.getAbsolutePath() + File.separator + "qzone";
    }
    return null;
  }
  
  public static String o()
  {
    return bdzf.a(alof.bd + UUID.randomUUID().toString() + ".jpg");
  }
  
  public static String p()
  {
    if (jdField_b_of_type_JavaLangString == null) {}
    try
    {
      if (jdField_b_of_type_JavaLangString == null) {
        a(false);
      }
      return jdField_b_of_type_JavaLangString;
    }
    finally {}
  }
  
  public static final String q()
  {
    long l = a();
    if (l >= 0L) {
      return a(l);
    }
    return "无SD Card";
  }
  
  public static final String r()
  {
    long l = b();
    if (l >= 0L) {
      return a(l);
    }
    return "无SD Card";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjhx
 * JD-Core Version:    0.7.0.1
 */