import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class biqd
{
  public static final String a = "file:///android_asset" + File.separator + "Page/system";
  
  public static int a()
  {
    return biip.a().a().getSharedPreferences("qzoneappcenter", 4).getInt("appTabVersionCode", -1);
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(d());
    long l = localStatFs.getAvailableBlocks();
    return localStatFs.getBlockSize() * l;
  }
  
  /* Error */
  public static long a(java.io.InputStream paramInputStream, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 21	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 81	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 84	java/io/File:mkdir	()Z
    //   20: pop
    //   21: new 21	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore 4
    //   32: new 89	java/io/FileOutputStream
    //   35: dup
    //   36: aload 4
    //   38: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: sipush 4096
    //   47: newarray byte
    //   49: astore 5
    //   51: aload_2
    //   52: astore_1
    //   53: aload_0
    //   54: aload 5
    //   56: invokevirtual 98	java/io/InputStream:read	([B)I
    //   59: istore_3
    //   60: iconst_m1
    //   61: iload_3
    //   62: if_icmpeq +32 -> 94
    //   65: aload_2
    //   66: astore_1
    //   67: aload_2
    //   68: aload 5
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 102	java/io/FileOutputStream:write	([BII)V
    //   75: goto -24 -> 51
    //   78: astore_0
    //   79: aload_2
    //   80: astore_1
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   92: aload_0
    //   93: athrow
    //   94: aload_2
    //   95: astore_1
    //   96: aload_2
    //   97: invokevirtual 108	java/io/FileOutputStream:flush	()V
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   108: aload 4
    //   110: invokevirtual 111	java/io/File:length	()J
    //   113: lreturn
    //   114: astore_0
    //   115: goto -7 -> 108
    //   118: astore_1
    //   119: goto -27 -> 92
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -41 -> 84
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -50 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramInputStream	java.io.InputStream
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   59	13	3	i	int
    //   30	79	4	localFile	File
    //   49	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   44	51	78	java/lang/Exception
    //   53	60	78	java/lang/Exception
    //   67	75	78	java/lang/Exception
    //   96	100	78	java/lang/Exception
    //   44	51	83	finally
    //   53	60	83	finally
    //   67	75	83	finally
    //   81	83	83	finally
    //   96	100	83	finally
    //   104	108	114	java/lang/Exception
    //   88	92	118	java/lang/Exception
    //   32	42	122	finally
    //   32	42	128	java/lang/Exception
  }
  
  public static String a(WebView paramWebView, HashMap<String, avnl> paramHashMap, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    label736:
    for (;;)
    {
      try
      {
        localJSONObject.put("r", "-1");
        localJSONObject.put("data", localJSONArray1);
        JSONArray localJSONArray2 = new JSONArray(URLDecoder.decode(paramString, "UTF-8"));
        int i = 0;
        String str1;
        String str2;
        Object localObject;
        if (i < localJSONArray2.length())
        {
          paramWebView = localJSONArray2.optJSONObject(i);
          if (paramWebView == null) {
            break label736;
          }
          paramString = paramWebView.optString("ns");
          str1 = paramWebView.optString("method");
          str2 = paramWebView.optString("guid");
          paramWebView = paramWebView.optString("args");
          bisy.c("Common", "nameSpace:" + paramString + ",methodName=" + str1 + ",paramsStr=" + paramWebView);
          localObject = new ArrayList();
        }
        int j;
        Method[] arrayOfMethod;
        int k;
        i += 1;
      }
      catch (UnsupportedEncodingException paramWebView)
      {
        try
        {
          paramWebView = new JSONArray(paramWebView);
          j = 0;
          if (j < paramWebView.length())
          {
            ((List)localObject).add(paramWebView.getString(j));
            j += 1;
          }
          else
          {
            paramWebView = (Class)biql.jdField_a_of_type_JavaUtilHashMap.get(paramString);
            if (biql.jdField_a_of_type_JavaUtilArrayList.contains(str1)) {
              ((List)localObject).add(str2);
            }
            if (paramWebView != null)
            {
              arrayOfMethod = paramWebView.getMethods();
              k = arrayOfMethod.length;
              j = 0;
              if (j < k)
              {
                paramWebView = arrayOfMethod[j];
                if ((paramWebView.getName().equals(str1)) && (paramWebView.getParameterTypes().length == ((List)localObject).size()))
                {
                  if (paramWebView == null) {
                    break label736;
                  }
                  paramString = paramHashMap.get(paramString);
                  try
                  {
                    bisy.c("Common", "callBatch <call> class : " + paramString.getClass().getName() + " , method : " + str1 + "\n , args : " + localObject.toString());
                    if (((List)localObject).size() != 0) {
                      continue;
                    }
                    paramString = paramWebView.invoke(paramString, new Object[0]);
                    paramWebView = paramWebView.getReturnType();
                    if ((paramWebView == Void.TYPE) || (paramWebView == Void.class) || (paramString == null)) {
                      break label736;
                    }
                    if (!(paramString instanceof String)) {
                      continue;
                    }
                    ((String)paramString).replace("\\", "\\\\").replace("'", "\\'");
                    paramWebView = (String)paramString;
                    paramString = new JSONObject();
                    localObject = new JSONArray();
                    paramString.put("guid", str2);
                    paramString.put("r", 0);
                    paramString.put("data", paramWebView);
                    ((JSONArray)localObject).put("interface." + str1);
                    ((JSONArray)localObject).put(paramString);
                    localJSONArray1.put(localObject);
                  }
                  catch (Exception paramWebView)
                  {
                    bisy.c("Common", "callBatch error", paramWebView);
                  }
                  paramWebView = paramWebView;
                  bisy.b("Common", "callBatch decode params format err", paramWebView);
                  return localJSONObject.toString();
                }
              }
            }
          }
        }
        catch (Exception paramWebView)
        {
          bisy.e("Common", "callBatch args error : " + paramWebView.toString());
        }
      }
      catch (JSONException paramWebView)
      {
        bisy.b("Common", "callBatch request params format err", paramWebView);
        continue;
        j += 1;
        continue;
        paramString = paramWebView.invoke(paramString, ((List)localObject).toArray());
        continue;
        if (((paramString instanceof Number)) || ((paramString instanceof Long)) || ((paramString instanceof Integer)) || ((paramString instanceof Double)) || ((paramString instanceof Float)))
        {
          paramWebView = paramString.toString();
        }
        else if ((paramString instanceof Boolean))
        {
          paramWebView = paramString.toString();
          continue;
          localJSONObject.put("r", 0);
          localJSONObject.put("data", localJSONArray1);
          bisy.c("Common", "Response<callBatch> syncCallBatch result : " + localJSONObject);
        }
        else
        {
          paramWebView = "";
          continue;
          paramWebView = null;
        }
      }
    }
  }
  
  public static String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      if (i != 0)
      {
        localStringBuilder.append(str1 + "=" + URLEncoder.encode(str2, "utf-8"));
        i = 0;
      }
      for (;;)
      {
        break;
        if (str2 != null) {
          localStringBuilder.append("&" + str1 + "=" + URLEncoder.encode(str2, "utf-8"));
        } else {
          localStringBuilder.append("&" + str1 + "=");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      Object localObject;
      if (!paramString.startsWith("?"))
      {
        localObject = paramString;
        if (!paramString.startsWith("&")) {}
      }
      else
      {
        localObject = paramString.substring(1);
      }
      paramString = ((String)localObject).split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramString[i].split("=");
        if (localObject.length > 1)
        {
          String str = URLDecoder.decode(localObject[1]);
          localHashMap.put(localObject[0], str);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static void a()
  {
    try
    {
      bisy.b("Common", "<initSystemFolder> begin to init system file... ");
      File localFile = new File(c());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      a(true);
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = biip.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putInt("appTabVersionCode", paramInt);
    localEditor.commit();
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = biip.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putLong("remaxage", paramLong1);
    localEditor.putLong("relasttime", paramLong2);
    localEditor.commit();
  }
  
  public static void a(String paramString)
  {
    bisy.c("Common", "setResourceMD5=" + paramString);
    SharedPreferences.Editor localEditor = biip.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putString("relastmd5", paramString);
    localEditor.commit();
  }
  
  /* Error */
  public static void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 420	java/util/concurrent/Executors:newSingleThreadScheduledExecutor	()Ljava/util/concurrent/ScheduledExecutorService;
    //   6: astore_3
    //   7: new 422	com/tencent/open/appcommon/Common$1
    //   10: dup
    //   11: invokespecial 423	com/tencent/open/appcommon/Common$1:<init>	()V
    //   14: astore 4
    //   16: iload_0
    //   17: ifeq +24 -> 41
    //   20: ldc2_w 424
    //   23: lstore_1
    //   24: aload_3
    //   25: aload 4
    //   27: lload_1
    //   28: getstatic 431	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   31: invokeinterface 437 5 0
    //   36: pop
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: lconst_0
    //   42: lstore_1
    //   43: goto -19 -> 24
    //   46: astore_3
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_3
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramBoolean	boolean
    //   23	20	1	l	long
    //   6	19	3	localScheduledExecutorService	java.util.concurrent.ScheduledExecutorService
    //   46	5	3	localObject	Object
    //   14	12	4	local1	com.tencent.open.appcommon.Common.1
    // Exception table:
    //   from	to	target	type
    //   3	16	46	finally
    //   24	37	46	finally
  }
  
  public static boolean a()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    while (new File("/mnt/sdcard-ext").isDirectory()) {
      return true;
    }
    return false;
  }
  
  public static long[] a()
  {
    SharedPreferences localSharedPreferences = biip.a().a().getSharedPreferences("qzoneappcenter", 4);
    return new long[] { localSharedPreferences.getLong("remaxage", 0L), localSharedPreferences.getLong("relasttime", 0L) };
  }
  
  public static String[] a(String paramString)
  {
    String str2;
    String str1;
    if (paramString.toLowerCase().startsWith("sd://"))
    {
      str2 = paramString.substring("sd://".length());
      int i = str2.indexOf("?");
      if (i != -1)
      {
        str1 = str2.substring(0, i);
        paramString = str2.substring(i + 1);
        if (new File(g() + File.separator + str1).exists())
        {
          str2 = "file:///" + g() + File.separator + str1;
          str1 = paramString;
        }
      }
    }
    for (;;)
    {
      paramString = str1;
      if (!TextUtils.isEmpty(str1)) {
        paramString = "&" + str1;
      }
      bisy.c("Common", "url params= " + str2 + " " + paramString);
      return new String[] { str2, paramString };
      str2 = "file:///android_asset/Page/system/" + str1;
      str1 = paramString;
      continue;
      paramString = "";
      str1 = str2;
      break;
      str1 = "";
      str2 = paramString;
    }
  }
  
  public static void b(String paramString)
  {
    bisy.c("Common", "setLastResourceZipMd5=" + paramString);
    SharedPreferences.Editor localEditor = biip.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putString("lastresourcezipmd5", paramString);
    localEditor.commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = biip.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putBoolean("appstoreclearcache", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b()
  {
    return biip.a().a().getSharedPreferences("qzoneappcenter", 4).getBoolean("appstoreclearcache", false);
  }
  
  public static String c()
  {
    return e() + File.separator + ".AppCenterWebBuffer_QQ";
  }
  
  public static void c(String paramString)
  {
    SharedPreferences.Editor localEditor = biip.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putString("appstoreagentversion", paramString);
    localEditor.commit();
  }
  
  public static String d()
  {
    try
    {
      if ("mounted".equals(Environment.getExternalStorageState())) {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
      }
      if (new File("/mnt/sdcard-ext").isDirectory()) {
        return "/mnt/sdcard-ext";
      }
    }
    catch (Exception localException) {}
    return ".";
  }
  
  public static void d(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = biip.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
      localEditor.putString("sdhtmldir", paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String e()
  {
    String str = bhgh.a().a();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return ".";
  }
  
  public static String f()
  {
    return g() + File.separator + "qapp_center_index.htm";
  }
  
  public static String g()
  {
    String str = q();
    bisy.b("Common", "<getSDResDir> getSDResDir=" + str);
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return c() + File.separator + str;
  }
  
  public static String h()
  {
    return c() + File.separator + "tmp";
  }
  
  public static String i()
  {
    return c() + File.separator + "system_old_";
  }
  
  public static String j()
  {
    return c() + File.separator + "resource.zip";
  }
  
  public static String k()
  {
    return c() + File.separator + "resource.diff";
  }
  
  public static String l()
  {
    return c() + File.separator + "resource_merged.zip";
  }
  
  public static String m()
  {
    return "file:///android_asset" + File.separator + "Page/system";
  }
  
  public static String n()
  {
    return biip.a().a().getSharedPreferences("qzoneappcenter", 4).getString("relastmd5", "");
  }
  
  public static String o()
  {
    return biip.a().a().getSharedPreferences("qzoneappcenter", 4).getString("lastresourcezipmd5", "");
  }
  
  public static String p()
  {
    return biip.a().a().getSharedPreferences("qzoneappcenter", 4).getString("appstoreagentversion", "");
  }
  
  public static String q()
  {
    return biip.a().a().getSharedPreferences("qzoneappcenter", 4).getString("sdhtmldir", "");
  }
  
  public static String r()
  {
    int i = Process.myPid();
    try
    {
      Object localObject = biip.a().a();
      if (localObject != null)
      {
        localObject = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningAppProcesses().iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == i)
          {
            localObject = localRunningAppProcessInfo.processName;
            return localObject;
          }
        }
      }
    }
    catch (Exception localException)
    {
      bisy.c("Common", "exception happened!");
      return "";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqd
 * JD-Core Version:    0.7.0.1
 */