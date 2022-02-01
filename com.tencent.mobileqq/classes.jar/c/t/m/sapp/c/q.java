package c.t.m.sapp.c;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class q
{
  public static final Object a = new Object();
  public static String b = "TencentLocation_sapp/comp";
  public static String c = "TencentLocation_sapp/odex";
  public static String d = "complist_loading_sapp";
  public static long e = 0L;
  public static String f = "01234567890ABCDEF";
  public static HashMap<String, r> g = new HashMap();
  
  public static double a(double paramDouble)
  {
    return paramDouble * 3.141592653589793D / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    paramDouble1 = Math.round(Math.asin(Math.sqrt(Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D))) * 2.0D * 6378.1369999999997D * 10000.0D);
    Double.isNaN(paramDouble1);
    return paramDouble1 / 10000.0D * 1000.0D;
  }
  
  public static r a(Context paramContext, String paramString)
  {
    if (g.containsKey(paramString)) {
      return (r)g.get(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/TencentLocation_sapp/conf/");
    localStringBuilder.append(paramString);
    paramContext = new r(localStringBuilder.toString());
    g.put(paramString, paramContext);
    return paramContext;
  }
  
  public static Long a(Context paramContext, String paramString, Long paramLong)
  {
    paramContext = a(paramContext, paramString).a(String.valueOf(paramLong));
    try
    {
      long l = Long.parseLong(paramContext);
      return Long.valueOf(l);
    }
    catch (Exception paramContext) {}
    return paramLong;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1).a(paramString2);
  }
  
  public static String a(File paramFile)
  {
    if (!paramFile.isFile()) {
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      paramFile = new FileInputStream(paramFile);
      for (;;)
      {
        int i = paramFile.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
      return a(localMessageDigest.digest());
    }
    catch (Exception paramFile) {}
    return null;
  }
  
  public static String a(List<a> paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      localStringBuilder1.append(locala.a);
      localStringBuilder1.append(",");
      localStringBuilder1.append(locala.b);
      localStringBuilder1.append(",");
      if (!locala.c.contains(".dex"))
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(locala.c);
        localStringBuilder2.append(".dex");
        locala.c = localStringBuilder2.toString();
      }
      localStringBuilder1.append(locala.c);
      localStringBuilder1.append(",");
      localStringBuilder1.append(locala.d);
      localStringBuilder1.append(",");
      localStringBuilder1.append(locala.e);
      localStringBuilder1.append(",");
      localStringBuilder1.append(locala.f);
      localStringBuilder1.append(";");
    }
    return localStringBuilder1.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString().toLowerCase();
  }
  
  public static List<String> a(Context paramContext, File paramFile)
  {
    boolean bool = paramFile.exists();
    paramContext = "";
    if ((bool) && (paramFile.isDirectory()))
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        int j = arrayOfFile.length;
        int i = 0;
        for (;;)
        {
          localObject = paramContext;
          paramFile = localArrayList;
          if (i >= j) {
            break;
          }
          paramFile = arrayOfFile[i];
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramFile.getName());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(paramFile.length());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(a(paramFile));
          localArrayList.add(((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append(paramFile.getName());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(paramFile.length());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(a(paramFile));
          ((StringBuilder)localObject).append(";");
          paramContext = ((StringBuilder)localObject).toString();
          i += 1;
        }
      }
    }
    paramFile = null;
    Object localObject = paramContext;
    paramContext = new StringBuilder();
    paramContext.append("before check ,private dir files:");
    paramContext.append((String)localObject);
    j.a(paramContext.toString());
    return paramFile;
  }
  
  public static void a()
  {
    long l = System.currentTimeMillis();
    b = "TencentLocation/comp";
    c = "TencentLocation/odex";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("_atuo_");
    localStringBuilder.append(l);
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("_atuo_");
    localStringBuilder.append(l);
    c = localStringBuilder.toString();
  }
  
  public static void a(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/TencentLocation");
    paramContext = new File(localStringBuilder.toString()).listFiles();
    if ((paramContext != null) && (paramContext.length > 0))
    {
      int i = 0;
      while (i < paramContext.length)
      {
        localStringBuilder = paramContext[i];
        String str = localStringBuilder.getName();
        if ((localStringBuilder.isDirectory()) && (str.contains("_atuo_")) && (!b.contains(str)))
        {
          b(localStringBuilder.getAbsolutePath());
          localStringBuilder.delete();
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString3);
    paramString3 = localStringBuilder.toString();
    paramString2 = new File(paramString2);
    if (!paramString2.exists()) {
      paramString2.mkdir();
    }
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    try
    {
      paramContext = paramContext.getResources().getAssets().open(paramString1);
      bool2 = bool3;
      paramString2 = new ByteArrayOutputStream();
      bool2 = bool3;
      paramContext.available();
      bool2 = bool3;
      paramString1 = new BufferedOutputStream(new FileOutputStream(paramString3, true), 1024);
      for (;;)
      {
        bool2 = bool3;
        int i = paramContext.read(paramArrayOfByte);
        if (i <= 0) {
          break;
        }
        bool2 = bool3;
        paramString2.write(paramArrayOfByte, 0, i);
      }
      bool2 = bool3;
      paramString2.close();
      bool2 = bool3;
      paramString2 = paramString2.toByteArray();
      bool2 = bool3;
      paramString2 = c(m.a(paramString2, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
      if (paramString2 != null)
      {
        bool2 = bool3;
        paramString1.write(paramString2);
        bool2 = bool3;
        paramString1.close();
        bool1 = true;
      }
      bool2 = bool1;
      paramContext.close();
      return bool1;
    }
    catch (Exception paramContext)
    {
      j.a("copy base to private dir", paramContext);
    }
    return bool2;
  }
  
  public static boolean a(Context paramContext, List<a> paramList)
  {
    List localList = e(a(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", ""));
    if (paramList.size() == 0) {
      return false;
    }
    if (localList.size() == 0) {
      return b(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(paramList));
    }
    int i = 0;
    while (i < localList.size())
    {
      a locala1 = (a)localList.get(i);
      int j = 0;
      while (j < paramList.size())
      {
        a locala2 = (a)paramList.get(j);
        if (locala2.a == locala1.a)
        {
          locala1.c = locala2.c;
          locala1.b = locala2.b;
          locala1.d = locala2.d;
          locala1.e = locala2.e;
          break;
        }
        j += 1;
      }
      i += 1;
    }
    return b(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(localList));
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      ((File)localObject).mkdirs();
      return true;
    }
    localObject = ((File)localObject).list();
    if (localObject != null)
    {
      if (localObject.length == 0) {
        return true;
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        File localFile = new File(paramString, localObject[i]);
        if (localFile.isDirectory())
        {
          b(localFile.getAbsolutePath());
          localFile.delete();
        }
        else
        {
          localFile.delete();
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < arrayOfByte.length)
    {
      arrayOfByte[paramInt] = Integer.valueOf(i & 0xFF).byteValue();
      i >>= 8;
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  public static int b()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getContentResolver();
      paramContext = Settings.System.getString(paramContext, "android_id");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return "01234567890ABCDEF";
  }
  
  public static String b(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramContext = paramContext.getAssets().open(paramString);
      paramString = new BufferedReader(new InputStreamReader(paramContext, "UTF-8"));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      paramString.close();
      paramContext.close();
    }
    catch (UnsupportedEncodingException|IOException paramContext)
    {
      label62:
      break label62;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean b(Context paramContext, String paramString, Long paramLong)
  {
    return a(paramContext, paramString).a(String.valueOf(paramLong).getBytes(), false);
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1).a(paramString2.getBytes(), false);
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte)
  {
    paramContext = new StringBuilder();
    paramContext.append(paramString2);
    paramContext.append(File.separator);
    paramContext.append(paramString3);
    paramContext = paramContext.toString();
    paramString2 = new File(paramString2);
    if (!paramString2.exists()) {
      paramString2.mkdir();
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      paramString1 = new FileInputStream(paramString1);
      bool1 = bool2;
      paramContext = new FileOutputStream(paramContext);
      for (;;)
      {
        bool1 = bool2;
        int i = paramString1.read(paramArrayOfByte);
        if (i <= 0) {
          break;
        }
        bool1 = bool2;
        paramContext.write(paramArrayOfByte, 0, i);
      }
      bool1 = bool2;
      paramContext.close();
      bool1 = true;
      paramString1.close();
      return true;
    }
    catch (Exception paramContext) {}
    return bool1;
  }
  
  public static boolean b(String paramString)
  {
    Object localObject = new File(paramString);
    boolean bool = ((File)localObject).exists();
    int i = 0;
    if (!bool) {
      return false;
    }
    localObject = ((File)localObject).list();
    if (localObject != null)
    {
      if (localObject.length == 0) {
        return true;
      }
      int j = localObject.length;
      while (i < j)
      {
        File localFile = new File(paramString, localObject[i]);
        if (localFile.isDirectory())
        {
          b(localFile.getAbsolutePath());
          localFile.delete();
        }
        else
        {
          localFile.delete();
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    Object localObject;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      localObject = new GZIPOutputStream(localByteArrayOutputStream);
      ((GZIPOutputStream)localObject).write(paramArrayOfByte);
      ((GZIPOutputStream)localObject).close();
      localObject = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        return localObject;
      }
      catch (Throwable paramArrayOfByte) {}
      paramArrayOfByte.printStackTrace();
    }
    catch (Throwable paramArrayOfByte)
    {
      localObject = null;
    }
    return localObject;
  }
  
  public static String c()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/proc/");
      ((StringBuilder)localObject).append(Process.myPid());
      ((StringBuilder)localObject).append("/cmdline");
      localObject = new BufferedReader(new FileReader(new File(((StringBuilder)localObject).toString())));
      String str = ((BufferedReader)localObject).readLine().trim();
      ((BufferedReader)localObject).close();
      return str;
    }
    catch (Exception localException)
    {
      label72:
      break label72;
    }
    Log.e(j.a, "getProcessNameByReadLocalFile,ignore this");
    return null;
  }
  
  public static String c(Context paramContext)
  {
    String str;
    try
    {
      str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      str = paramContext.versionName;
      int i = paramContext.versionCode;
      if (str != null) {
        if (str.trim().length() > 0) {
          return str;
        }
      }
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(i);
      paramContext = paramContext.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return "";
    }
    return str;
  }
  
  public static String c(String paramString)
  {
    try
    {
      String str = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  /* Error */
  public static byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ifnull +306 -> 313
    //   10: aload_0
    //   11: arraylength
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 349	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 350	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore_2
    //   25: new 551	java/io/ByteArrayInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 553	java/io/ByteArrayInputStream:<init>	([B)V
    //   33: astore_0
    //   34: new 555	java/util/zip/GZIPInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 558	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_3
    //   43: ldc_w 559
    //   46: newarray byte
    //   48: astore 4
    //   50: aload_3
    //   51: aload 4
    //   53: invokevirtual 560	java/util/zip/GZIPInputStream:read	([B)I
    //   56: istore_1
    //   57: iload_1
    //   58: iflt +14 -> 72
    //   61: aload_2
    //   62: aload 4
    //   64: iconst_0
    //   65: iload_1
    //   66: invokevirtual 371	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -19 -> 50
    //   72: aload_2
    //   73: invokevirtual 375	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   76: astore 4
    //   78: aload 4
    //   80: astore 5
    //   82: aload_3
    //   83: invokevirtual 561	java/util/zip/GZIPInputStream:close	()V
    //   86: aload 4
    //   88: astore 5
    //   90: aload_0
    //   91: invokevirtual 562	java/io/ByteArrayInputStream:close	()V
    //   94: aload 4
    //   96: astore 5
    //   98: aload_2
    //   99: invokevirtual 372	java/io/ByteArrayOutputStream:close	()V
    //   102: aload 4
    //   104: areturn
    //   105: astore 5
    //   107: aload_2
    //   108: astore 4
    //   110: aload_0
    //   111: astore_2
    //   112: aload 5
    //   114: astore_0
    //   115: goto +97 -> 212
    //   118: aload_0
    //   119: astore 4
    //   121: aload_3
    //   122: astore_0
    //   123: goto +124 -> 247
    //   126: aload_0
    //   127: astore 4
    //   129: aload_3
    //   130: astore_0
    //   131: goto +145 -> 276
    //   134: astore 6
    //   136: aload 5
    //   138: astore_3
    //   139: aload_2
    //   140: astore 4
    //   142: aload_0
    //   143: astore_2
    //   144: aload 6
    //   146: astore_0
    //   147: goto +65 -> 212
    //   150: aconst_null
    //   151: astore_3
    //   152: aload_0
    //   153: astore 4
    //   155: aload_3
    //   156: astore_0
    //   157: goto +90 -> 247
    //   160: aconst_null
    //   161: astore_3
    //   162: aload_0
    //   163: astore 4
    //   165: aload_3
    //   166: astore_0
    //   167: goto +109 -> 276
    //   170: astore_0
    //   171: aconst_null
    //   172: astore 6
    //   174: aload 5
    //   176: astore_3
    //   177: aload_2
    //   178: astore 4
    //   180: aload 6
    //   182: astore_2
    //   183: goto +29 -> 212
    //   186: aconst_null
    //   187: astore_0
    //   188: aload_0
    //   189: astore 4
    //   191: goto +56 -> 247
    //   194: aconst_null
    //   195: astore_0
    //   196: aload_0
    //   197: astore 4
    //   199: goto +77 -> 276
    //   202: astore_0
    //   203: aconst_null
    //   204: astore 4
    //   206: aload 4
    //   208: astore_2
    //   209: aload 5
    //   211: astore_3
    //   212: aload_3
    //   213: ifnull +7 -> 220
    //   216: aload_3
    //   217: invokevirtual 561	java/util/zip/GZIPInputStream:close	()V
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 562	java/io/ByteArrayInputStream:close	()V
    //   228: aload 4
    //   230: ifnull +8 -> 238
    //   233: aload 4
    //   235: invokevirtual 372	java/io/ByteArrayOutputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: aconst_null
    //   241: astore_0
    //   242: aload_0
    //   243: astore_2
    //   244: aload_2
    //   245: astore 4
    //   247: aload_0
    //   248: ifnull +11 -> 259
    //   251: aload 6
    //   253: astore 5
    //   255: aload_0
    //   256: invokevirtual 561	java/util/zip/GZIPInputStream:close	()V
    //   259: aload 4
    //   261: ifnull +96 -> 357
    //   264: aload 6
    //   266: astore 5
    //   268: aload 4
    //   270: invokevirtual 562	java/io/ByteArrayInputStream:close	()V
    //   273: goto +84 -> 357
    //   276: aload_0
    //   277: ifnull +11 -> 288
    //   280: aload 6
    //   282: astore 5
    //   284: aload_0
    //   285: invokevirtual 561	java/util/zip/GZIPInputStream:close	()V
    //   288: aload 4
    //   290: ifnull +84 -> 374
    //   293: aload 6
    //   295: astore 5
    //   297: aload 4
    //   299: invokevirtual 562	java/io/ByteArrayInputStream:close	()V
    //   302: goto +72 -> 374
    //   305: aload 6
    //   307: astore 5
    //   309: aload_2
    //   310: invokevirtual 372	java/io/ByteArrayOutputStream:close	()V
    //   313: aconst_null
    //   314: areturn
    //   315: astore_0
    //   316: goto +48 -> 364
    //   319: astore_0
    //   320: goto -80 -> 240
    //   323: astore_0
    //   324: goto -130 -> 194
    //   327: astore_0
    //   328: goto -142 -> 186
    //   331: astore_3
    //   332: goto -172 -> 160
    //   335: astore_3
    //   336: goto -186 -> 150
    //   339: astore 4
    //   341: goto -215 -> 126
    //   344: astore 4
    //   346: goto -228 -> 118
    //   349: astore_0
    //   350: aload 5
    //   352: areturn
    //   353: astore_2
    //   354: goto -116 -> 238
    //   357: aload_2
    //   358: ifnull -45 -> 313
    //   361: goto -56 -> 305
    //   364: aconst_null
    //   365: astore_0
    //   366: aload_0
    //   367: astore_2
    //   368: aload_2
    //   369: astore 4
    //   371: goto -95 -> 276
    //   374: aload_2
    //   375: ifnull -62 -> 313
    //   378: goto -73 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	paramArrayOfByte	byte[]
    //   56	10	1	i	int
    //   24	286	2	localObject1	Object
    //   353	5	2	localException1	Exception
    //   367	8	2	arrayOfByte1	byte[]
    //   42	175	3	localObject2	Object
    //   331	1	3	localException2	Exception
    //   335	1	3	localError1	java.lang.Error
    //   48	250	4	localObject3	Object
    //   339	1	4	localException3	Exception
    //   344	1	4	localError2	java.lang.Error
    //   369	1	4	arrayOfByte2	byte[]
    //   4	93	5	localObject4	Object
    //   105	105	5	localObject5	Object
    //   253	98	5	localObject6	Object
    //   1	1	6	localObject7	Object
    //   134	11	6	localObject8	Object
    //   172	134	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   43	50	105	finally
    //   50	57	105	finally
    //   61	69	105	finally
    //   72	78	105	finally
    //   34	43	134	finally
    //   25	34	170	finally
    //   17	25	202	finally
    //   17	25	315	java/lang/Exception
    //   17	25	319	java/lang/Error
    //   25	34	323	java/lang/Exception
    //   25	34	327	java/lang/Error
    //   34	43	331	java/lang/Exception
    //   34	43	335	java/lang/Error
    //   43	50	339	java/lang/Exception
    //   50	57	339	java/lang/Exception
    //   61	69	339	java/lang/Exception
    //   72	78	339	java/lang/Exception
    //   43	50	344	java/lang/Error
    //   50	57	344	java/lang/Error
    //   61	69	344	java/lang/Error
    //   72	78	344	java/lang/Error
    //   82	86	349	java/lang/Exception
    //   90	94	349	java/lang/Exception
    //   98	102	349	java/lang/Exception
    //   255	259	349	java/lang/Exception
    //   268	273	349	java/lang/Exception
    //   284	288	349	java/lang/Exception
    //   297	302	349	java/lang/Exception
    //   309	313	349	java/lang/Exception
    //   216	220	353	java/lang/Exception
    //   224	228	353	java/lang/Exception
    //   233	238	353	java/lang/Exception
  }
  
  public static long d()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    return 0L;
  }
  
  public static String d(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      localObject1 = paramString.getString("status");
      localObject2 = e.b();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("statucode:");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((e)localObject2).a("DRG", ((StringBuilder)localObject3).toString());
      boolean bool = ((String)localObject1).equals("-3");
      if (bool) {
        return null;
      }
      bool = ((String)localObject1).equals("0");
      if (bool)
      {
        localObject1 = paramString.getJSONArray("compList");
        int i = 0;
        paramString = "";
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject4 = ((JSONArray)localObject1).getJSONObject(i);
          int j = ((JSONObject)localObject4).getInt("compId");
          localObject2 = ((JSONObject)localObject4).getString("compVer");
          localObject3 = ((JSONObject)localObject4).getString("md5");
          int k = ((JSONObject)localObject4).getInt("size");
          localObject4 = ((JSONObject)localObject4).getString("compName");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(j);
          localStringBuilder.append(",");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(",");
          localStringBuilder.append((String)localObject4);
          localStringBuilder.append(",");
          localStringBuilder.append(k);
          localStringBuilder.append(",");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(",;");
          paramString = localStringBuilder.toString();
          i += 1;
        }
        return paramString;
      }
      bool = ((String)localObject1).equals("-1");
      if (bool) {
        return null;
      }
      bool = ((String)localObject1).equals("-2");
      if (bool) {
        return null;
      }
      bool = ((String)localObject1).equals("-4");
      if (bool) {
        return null;
      }
      bool = ((String)localObject1).equals("-5");
      if (bool) {
        return null;
      }
    }
    catch (Exception paramString)
    {
      Object localObject1 = e.b();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("statucode:");
      ((StringBuilder)localObject2).append(paramString.toString());
      ((e)localObject1).a("DRG", ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  public static String e()
  {
    try
    {
      String str = Build.MANUFACTURER;
      str = str.replaceAll("[_]", "");
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String e(Context paramContext)
  {
    String str = f(paramContext);
    paramContext = str;
    if (str == null) {
      paramContext = c();
    }
    return paramContext;
  }
  
  public static List<a> e(String paramString)
  {
    localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = paramString.split(";");
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          arrayOfString = paramString[i];
          arrayOfString = arrayOfString.split(",");
          int k = arrayOfString.length;
          if (k < 5) {}
        }
      }
      catch (Exception paramString)
      {
        int i;
        String[] arrayOfString;
        a locala;
        return localArrayList;
      }
      try
      {
        locala = new a();
        locala.a = Integer.valueOf(arrayOfString[0]).intValue();
        locala.b = arrayOfString[1];
        locala.c = arrayOfString[2];
        locala.d = Integer.valueOf(arrayOfString[3]).intValue();
        locala.e = arrayOfString[4];
        if (arrayOfString.length > 5) {
          locala.f = arrayOfString[5];
        }
        localArrayList.add(locala);
      }
      catch (Exception localException)
      {
        continue;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String f()
  {
    try
    {
      String str = Build.MODEL;
      str = str.replaceAll("[_]", "");
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      } while (localRunningAppProcessInfo.pid != i);
      paramContext = localRunningAppProcessInfo.processName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label57:
      break label57;
    }
    Log.e(j.a, "getProcessNameByService,ignore this");
    return null;
  }
  
  public static int g()
  {
    return Process.myPid();
  }
  
  public static int g(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    boolean bool5 = k(paramContext);
    int i1 = 0;
    boolean bool3 = false;
    try
    {
      localObject = (WifiManager)paramContext.getSystemService("wifi");
      if (localObject != null)
      {
        bool1 = ((WifiManager)localObject).isWifiEnabled();
        bool2 = bool1;
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject;
      boolean bool4;
      int j;
      label73:
      int k;
      break label88;
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        bool4 = ((WifiManager)localObject).isScanAlwaysAvailable();
        if (bool4)
        {
          j = 1;
          break label73;
        }
      }
      j = 0;
      k = 1;
    }
    catch (Throwable localThrowable2)
    {
      bool1 = bool2;
      break label91;
    }
    j = 0;
    k = 0;
    bool1 = false;
    break label95;
    label88:
    bool1 = false;
    label91:
    j = 0;
    k = 0;
    try
    {
      label95:
      localObject = (LocationManager)paramContext.getSystemService("location");
      if (localObject == null) {}
    }
    catch (Exception paramContext)
    {
      int i;
      label128:
      break label178;
    }
    try
    {
      paramContext = paramContext.getContentResolver();
      i = Settings.Secure.getInt(paramContext, "location_mode");
    }
    catch (Throwable paramContext)
    {
      break label128;
    }
    i = 0;
    try
    {
      bool4 = ((LocationManager)localObject).isProviderEnabled("gps");
      paramContext = ((LocationManager)localObject).getAllProviders();
      if (paramContext == null) {
        bool2 = bool3;
      } else {
        bool2 = paramContext.contains("gps");
      }
      i1 = bool4;
      n = i;
    }
    catch (Exception paramContext)
    {
      int n;
      label178:
      label180:
      int m;
      break label180;
    }
    i = 0;
    bool2 = false;
    n = i;
    m = bool5 ^ true;
    i = m;
    if (!bool1) {
      i = m + 2;
    }
    m = i;
    if (i1 == 0) {
      m = i + 4;
    }
    i = m;
    if (k == 0) {
      i = m + 8;
    }
    k = i;
    if (!bool2) {
      k = i + 16;
    }
    i = k;
    if (j == 0) {
      i = k + 32;
    }
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3) {
            return i;
          }
          return i + 512;
        }
        return i + 256;
      }
      return i + 128;
    }
    return i + 64;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String h(Context paramContext)
  {
    Object localObject = f;
    if ((localObject != null) && (((String)localObject).length() != 0) && (!"01234567890ABCDEF".equals(f))) {
      return f;
    }
    try
    {
      localObject = (TelephonyManager)paramContext.getSystemService("phone");
      if (Build.VERSION.SDK_INT > 28) {
        f = b(paramContext);
      } else if (Build.VERSION.SDK_INT >= 26) {
        f = PhoneInfoMonitor.getImei((TelephonyManager)localObject);
      } else {
        f = PhoneInfoMonitor.getDeviceId((TelephonyManager)localObject);
      }
    }
    catch (Throwable paramContext)
    {
      label87:
      break label87;
    }
    f = "01234567890ABCDEF";
    return f;
  }
  
  public static String i(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(c);
    return localStringBuilder.toString();
  }
  
  public static boolean j(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null)
        {
          int i = paramContext.getType();
          if (i == 1) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      label36:
      break label36;
    }
    return false;
  }
  
  public static boolean k(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.getSimState();
      return i == 5;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static String l(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        if (paramContext.containsKey("TencentGeoLocationSDK")) {
          return paramContext.getString("TencentGeoLocationSDK");
        }
        if (paramContext.containsKey("TencentMapSDK"))
        {
          paramContext = paramContext.getString("TencentMapSDK");
          return paramContext;
        }
      }
      return "";
    }
    catch (Exception paramContext) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.q
 * JD-Core Version:    0.7.0.1
 */