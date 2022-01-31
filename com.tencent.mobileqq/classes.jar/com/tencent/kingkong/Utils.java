package com.tencent.kingkong;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Utils
{
  public static String a(int paramInt)
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[paramInt];
    localSecureRandom.nextBytes(arrayOfByte);
    return Base64.encodeToString(arrayOfByte, 0);
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    Common.Log.a("KingKongUtils", "Unable to get current process name!");
    return "";
  }
  
  public static String a(InputStream paramInputStream)
  {
    MessageDigest localMessageDigest;
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream);
      localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      localBufferedInputStream.close();
    }
    catch (Throwable paramInputStream)
    {
      return "";
    }
    paramInputStream.close();
    paramInputStream = Base64.encodeToString(localMessageDigest.digest(), 2).trim();
    return paramInputStream;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 130	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 136	java/io/File:exists	()Z
    //   11: ifne +35 -> 46
    //   14: ldc 75
    //   16: new 138	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   23: ldc 141
    //   25: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 147
    //   34: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 82	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: ldc 27
    //   45: areturn
    //   46: new 138	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: new 152	java/io/BufferedReader
    //   59: dup
    //   60: new 154	java/io/InputStreamReader
    //   63: dup
    //   64: new 156	java/io/FileInputStream
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 157	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   72: invokespecial 158	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   75: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: invokevirtual 164	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   85: astore_2
    //   86: aload_2
    //   87: ifnull +34 -> 121
    //   90: aload_1
    //   91: astore_0
    //   92: aload_3
    //   93: aload_2
    //   94: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: goto -19 -> 79
    //   101: astore_2
    //   102: aload_1
    //   103: astore_0
    //   104: aload_2
    //   105: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 168	java/io/BufferedReader:close	()V
    //   116: aload_3
    //   117: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: areturn
    //   121: aload_1
    //   122: ifnull -6 -> 116
    //   125: aload_1
    //   126: invokevirtual 168	java/io/BufferedReader:close	()V
    //   129: goto -13 -> 116
    //   132: astore_0
    //   133: goto -17 -> 116
    //   136: astore_0
    //   137: aload_2
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 168	java/io/BufferedReader:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: goto -34 -> 116
    //   153: astore_1
    //   154: goto -7 -> 147
    //   157: astore_2
    //   158: aload_0
    //   159: astore_1
    //   160: aload_2
    //   161: astore_0
    //   162: goto -23 -> 139
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: goto -66 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramString	String
    //   78	66	1	localObject1	Object
    //   153	1	1	localIOException1	IOException
    //   159	9	1	str1	String
    //   55	39	2	str2	String
    //   101	37	2	localIOException2	IOException
    //   157	4	2	localObject2	Object
    //   165	1	2	localIOException3	IOException
    //   53	64	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   81	86	101	java/io/IOException
    //   92	98	101	java/io/IOException
    //   125	129	132	java/io/IOException
    //   56	79	136	finally
    //   112	116	149	java/io/IOException
    //   143	147	153	java/io/IOException
    //   81	86	157	finally
    //   92	98	157	finally
    //   104	108	157	finally
    //   56	79	165	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = Base64.encodeToString(localMessageDigest.digest(), 2);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      Common.Log.a("Lynn", "Unable to calculate SHA1");
    }
    return "";
  }
  
  public static StringBuilder a()
  {
    return new StringBuilder();
  }
  
  public static void a(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
    localEditor.clear();
    localEditor.commit();
    a(new File(paramContext.getFilesDir().getAbsolutePath() + Common.d + "kingkong" + Common.d + "download"));
    a(new File(paramContext.getFilesDir().getAbsolutePath() + Common.d + "kingkong" + Common.d + "patches"));
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: iconst_0
    //   10: istore 5
    //   12: new 219	java/io/FileOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 220	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore 6
    //   24: aload 9
    //   26: astore 7
    //   28: new 87	java/io/BufferedInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 224	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   36: aload_1
    //   37: invokevirtual 230	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   40: invokespecial 90	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_0
    //   44: sipush 8192
    //   47: newarray byte
    //   49: astore_1
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 105	java/io/BufferedInputStream:read	([B)I
    //   55: istore_3
    //   56: iload_3
    //   57: iconst_m1
    //   58: if_icmpeq +62 -> 120
    //   61: aload_2
    //   62: aload_1
    //   63: iconst_0
    //   64: iload_3
    //   65: invokevirtual 235	java/io/OutputStream:write	([BII)V
    //   68: goto -18 -> 50
    //   71: astore 6
    //   73: aload_0
    //   74: astore_1
    //   75: aload 6
    //   77: astore_0
    //   78: aload_2
    //   79: astore 6
    //   81: aload_1
    //   82: astore 7
    //   84: ldc 75
    //   86: aload_0
    //   87: invokevirtual 238	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: invokestatic 82	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 112	java/io/BufferedInputStream:close	()V
    //   101: iload 5
    //   103: istore 4
    //   105: aload_2
    //   106: ifnull +11 -> 117
    //   109: aload_2
    //   110: invokevirtual 239	java/io/OutputStream:close	()V
    //   113: iload 5
    //   115: istore 4
    //   117: iload 4
    //   119: ireturn
    //   120: iconst_1
    //   121: istore 4
    //   123: aload_0
    //   124: ifnull +7 -> 131
    //   127: aload_0
    //   128: invokevirtual 112	java/io/BufferedInputStream:close	()V
    //   131: aload_2
    //   132: ifnull -15 -> 117
    //   135: aload_2
    //   136: invokevirtual 239	java/io/OutputStream:close	()V
    //   139: iconst_1
    //   140: ireturn
    //   141: astore_0
    //   142: iconst_1
    //   143: ireturn
    //   144: astore_0
    //   145: aconst_null
    //   146: astore_2
    //   147: aload 7
    //   149: ifnull +8 -> 157
    //   152: aload 7
    //   154: invokevirtual 112	java/io/BufferedInputStream:close	()V
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 239	java/io/OutputStream:close	()V
    //   165: aload_0
    //   166: athrow
    //   167: astore_0
    //   168: goto -37 -> 131
    //   171: astore_0
    //   172: goto -71 -> 101
    //   175: astore_0
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_1
    //   179: goto -22 -> 157
    //   182: astore_1
    //   183: goto -18 -> 165
    //   186: astore_0
    //   187: aload 6
    //   189: astore_2
    //   190: goto -43 -> 147
    //   193: astore_1
    //   194: aload_0
    //   195: astore 7
    //   197: aload_1
    //   198: astore_0
    //   199: goto -52 -> 147
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_2
    //   205: aload 8
    //   207: astore_1
    //   208: goto -130 -> 78
    //   211: astore_0
    //   212: aload 8
    //   214: astore_1
    //   215: goto -137 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramContext	Context
    //   0	218	1	paramString1	String
    //   0	218	2	paramString2	String
    //   55	10	3	i	int
    //   103	19	4	bool1	boolean
    //   10	104	5	bool2	boolean
    //   22	1	6	str1	String
    //   71	5	6	localIOException	IOException
    //   79	109	6	str2	String
    //   1	195	7	localObject1	Object
    //   7	206	8	localObject2	Object
    //   4	21	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   44	50	71	java/io/IOException
    //   50	56	71	java/io/IOException
    //   61	68	71	java/io/IOException
    //   135	139	141	java/io/IOException
    //   12	21	144	finally
    //   127	131	167	java/io/IOException
    //   97	101	171	java/io/IOException
    //   109	113	175	java/io/IOException
    //   152	157	178	java/io/IOException
    //   161	165	182	java/io/IOException
    //   28	44	186	finally
    //   84	93	186	finally
    //   44	50	193	finally
    //   50	56	193	finally
    //   61	68	193	finally
    //   12	21	202	java/io/IOException
    //   28	44	211	java/io/IOException
  }
  
  public static boolean a(File paramFile)
  {
    if (!paramFile.exists()) {}
    while (!paramFile.isDirectory()) {
      return false;
    }
    paramFile = paramFile.listFiles();
    int i = 0;
    for (;;)
    {
      if (i >= paramFile.length) {
        break label61;
      }
      File localFile = paramFile[i];
      if (((localFile.isDirectory()) && (!a(localFile))) || (!localFile.delete())) {
        break;
      }
      i += 1;
    }
    label61:
    return true;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.split(",");
    int j = Build.VERSION.SDK_INT;
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < k)
      {
        if (String.valueOf(j).equals(paramString[i].trim())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      JarFile localJarFile = new JarFile(paramString1);
      Enumeration localEnumeration = localJarFile.entries();
      while (localEnumeration.hasMoreElements())
      {
        Object localObject = (JarEntry)localEnumeration.nextElement();
        if ((!((JarEntry)localObject).isDirectory()) && (!((JarEntry)localObject).getName().startsWith("META-INF/")))
        {
          localObject = a(localJarFile, (JarEntry)localObject);
          if (localObject == null) {
            return false;
          }
          if (localObject.length != 1) {
            return false;
          }
          if (!new Signature(localObject[0].getEncoded()).equals(new Signature(paramString2)))
          {
            Common.Log.a("KingKongUtils", "Signature mismatch in : " + paramString1);
            return false;
          }
        }
      }
    }
    catch (IOException paramString1)
    {
      Common.Log.a("KingKongUtils", "Check file signature failed : " + paramString1);
      return false;
    }
    catch (CertificateEncodingException paramString1)
    {
      Common.Log.a("KingKongUtils", "Check file signature failed : " + paramString1);
      return false;
    }
    Common.Log.a("KingKongUtils", "Check file signatures OK : " + paramString1);
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, false, "");
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramString3.startsWith("META-INF/"))
    {
      Common.Log.a("KingKongUtils", "Reload file with unexpected name : " + paramString3);
      return false;
    }
    if (!paramBoolean) {
      try
      {
        if (a(paramString2, paramString3, paramString1))
        {
          Common.Log.a("KingKongUtils", "Current file changed, reload OK : " + paramString1 + ", " + paramString2);
          return true;
        }
        Common.Log.a("KingKongUtils", "Current file changed and unable to be reloaded : " + paramString1 + ", " + paramString2);
        return false;
      }
      catch (Exception paramString2)
      {
        Common.Log.a("KingKongUtils", "Error occurred while reload file " + paramString1 + " : " + paramString2);
        return false;
      }
    }
    if (b(paramString1, paramString2))
    {
      Common.Log.a("KingKongUtils", "Current file changed, copy OK : " + paramString1);
      return true;
    }
    Common.Log.a("KingKongUtils", "Current file changed and unable to be repaired : " + paramString1);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    try
    {
      JarFile localJarFile = new JarFile(paramString1);
      Enumeration localEnumeration = localJarFile.entries();
      while (localEnumeration.hasMoreElements())
      {
        JarEntry localJarEntry = (JarEntry)localEnumeration.nextElement();
        if ((!localJarEntry.isDirectory()) && (localJarEntry.getName().equals(paramString2)))
        {
          if (paramBoolean)
          {
            Certificate[] arrayOfCertificate = a(localJarFile, localJarEntry);
            if ((arrayOfCertificate == null) || (arrayOfCertificate.length != 1)) {
              continue;
            }
            if (!new Signature(arrayOfCertificate[0].getEncoded()).equals(new Signature(paramString4)))
            {
              Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : Signature mismatch!");
              return false;
            }
          }
          if (a(localJarFile, localJarEntry, paramString3))
          {
            Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " OK");
            return true;
          }
          Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : Read error");
          return false;
        }
      }
      Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : No such file in Apk");
      return false;
    }
    catch (Exception paramString3)
    {
      Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : Exception " + paramString3);
    }
    return false;
  }
  
  private static boolean a(JarFile paramJarFile, JarEntry paramJarEntry, String paramString)
  {
    try
    {
      byte[] arrayOfByte = new byte[8192];
      paramJarFile = new BufferedInputStream(paramJarFile.getInputStream(paramJarEntry));
      paramJarEntry = new FileOutputStream(paramString, false);
      for (;;)
      {
        int i = paramJarFile.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        paramJarEntry.write(arrayOfByte, 0, i);
      }
      paramJarFile.close();
      paramJarEntry.close();
      return true;
    }
    catch (RuntimeException paramJarFile)
    {
      return false;
    }
    catch (IOException paramJarFile) {}
    return false;
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry)
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = new byte[8192];
      paramJarFile = new BufferedInputStream(paramJarFile.getInputStream(paramJarEntry));
      while (paramJarFile.read(arrayOfByte, 0, arrayOfByte.length) != -1) {}
      paramJarFile.close();
      paramJarFile = localObject;
      if (paramJarEntry != null) {
        paramJarFile = paramJarEntry.getCertificates();
      }
      return paramJarFile;
    }
    catch (RuntimeException paramJarFile)
    {
      return null;
    }
    catch (IOException paramJarFile) {}
    return null;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getPackageName();
        boolean bool = TextUtils.isEmpty(paramContext);
        if (bool) {
          return "";
        }
      }
      catch (Exception paramContext) {}
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = a(new FileInputStream(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString) {}
    return "";
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      localObject = new FileOutputStream(paramString1, false);
      FileInputStream localFileInputStream = new FileInputStream(paramString2);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i <= 0)
        {
          ((FileOutputStream)localObject).close();
          localFileInputStream.close();
          Common.Log.a("KingKongUtils", "Copy file " + paramString2 + " to " + paramString1 + " OK");
          return true;
        }
        ((FileOutputStream)localObject).write(arrayOfByte, 0, i);
      }
      return false;
    }
    catch (IOException localIOException)
    {
      Common.Log.a("KingKongUtils", "Copy file " + paramString2 + " to " + paramString1 + " failed:" + localIOException);
      localIOException.printStackTrace();
    }
  }
  
  /* Error */
  public static boolean c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: new 407	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 408	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 412	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 414	java/net/HttpURLConnection
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 417	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: astore 4
    //   27: new 219	java/io/FileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: iconst_0
    //   33: invokespecial 374	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   36: astore 5
    //   38: aload_3
    //   39: sipush 300
    //   42: invokevirtual 421	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   45: aload_3
    //   46: sipush 300
    //   49: invokevirtual 424	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   52: aload_3
    //   53: invokevirtual 427	java/net/HttpURLConnection:connect	()V
    //   56: sipush 1024
    //   59: newarray byte
    //   61: astore 6
    //   63: aload 4
    //   65: aload 6
    //   67: invokevirtual 428	java/io/InputStream:read	([B)I
    //   70: istore_2
    //   71: iload_2
    //   72: ifgt +68 -> 140
    //   75: ldc 75
    //   77: new 138	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 430
    //   87: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 335
    //   97: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 82	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 4
    //   112: ifnull +8 -> 120
    //   115: aload 4
    //   117: invokevirtual 115	java/io/InputStream:close	()V
    //   120: aload 5
    //   122: ifnull +8 -> 130
    //   125: aload 5
    //   127: invokevirtual 379	java/io/FileOutputStream:close	()V
    //   130: aload_3
    //   131: ifnull +7 -> 138
    //   134: aload_3
    //   135: invokevirtual 433	java/net/HttpURLConnection:disconnect	()V
    //   138: iconst_1
    //   139: ireturn
    //   140: aload 5
    //   142: aload 6
    //   144: iconst_0
    //   145: iload_2
    //   146: invokevirtual 378	java/io/FileOutputStream:write	([BII)V
    //   149: goto -86 -> 63
    //   152: astore 7
    //   154: aload 5
    //   156: astore 6
    //   158: aload 7
    //   160: astore 5
    //   162: ldc 75
    //   164: new 138	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 435
    //   174: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 335
    //   184: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_1
    //   188: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 341
    //   194: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 5
    //   199: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 82	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 4
    //   210: ifnull +8 -> 218
    //   213: aload 4
    //   215: invokevirtual 115	java/io/InputStream:close	()V
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 379	java/io/FileOutputStream:close	()V
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 433	java/net/HttpURLConnection:disconnect	()V
    //   236: iconst_0
    //   237: ireturn
    //   238: astore_0
    //   239: aconst_null
    //   240: astore_3
    //   241: aconst_null
    //   242: astore 4
    //   244: aload 7
    //   246: astore 6
    //   248: aload 4
    //   250: ifnull +8 -> 258
    //   253: aload 4
    //   255: invokevirtual 115	java/io/InputStream:close	()V
    //   258: aload 6
    //   260: ifnull +8 -> 268
    //   263: aload 6
    //   265: invokevirtual 379	java/io/FileOutputStream:close	()V
    //   268: aload_3
    //   269: ifnull +7 -> 276
    //   272: aload_3
    //   273: invokevirtual 433	java/net/HttpURLConnection:disconnect	()V
    //   276: aload_0
    //   277: athrow
    //   278: astore_0
    //   279: goto -159 -> 120
    //   282: astore_0
    //   283: goto -153 -> 130
    //   286: astore_0
    //   287: goto -69 -> 218
    //   290: astore_0
    //   291: goto -63 -> 228
    //   294: astore_1
    //   295: goto -37 -> 258
    //   298: astore_1
    //   299: goto -31 -> 268
    //   302: astore_0
    //   303: aconst_null
    //   304: astore 4
    //   306: aload 7
    //   308: astore 6
    //   310: goto -62 -> 248
    //   313: astore_0
    //   314: aload 7
    //   316: astore 6
    //   318: goto -70 -> 248
    //   321: astore_0
    //   322: aload 5
    //   324: astore 6
    //   326: goto -78 -> 248
    //   329: astore_0
    //   330: goto -82 -> 248
    //   333: astore 5
    //   335: aconst_null
    //   336: astore_3
    //   337: aconst_null
    //   338: astore 4
    //   340: goto -178 -> 162
    //   343: astore 5
    //   345: aconst_null
    //   346: astore 4
    //   348: goto -186 -> 162
    //   351: astore 5
    //   353: goto -191 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramString1	String
    //   0	356	1	paramString2	String
    //   70	76	2	i	int
    //   20	317	3	localHttpURLConnection	java.net.HttpURLConnection
    //   25	322	4	localInputStream	InputStream
    //   36	287	5	localObject1	Object
    //   333	1	5	localThrowable1	Throwable
    //   343	1	5	localThrowable2	Throwable
    //   351	1	5	localThrowable3	Throwable
    //   4	321	6	localObject2	Object
    //   1	1	7	localObject3	Object
    //   152	163	7	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   38	63	152	java/lang/Throwable
    //   63	71	152	java/lang/Throwable
    //   75	110	152	java/lang/Throwable
    //   140	149	152	java/lang/Throwable
    //   6	21	238	finally
    //   115	120	278	java/io/IOException
    //   125	130	282	java/io/IOException
    //   213	218	286	java/io/IOException
    //   223	228	290	java/io/IOException
    //   253	258	294	java/io/IOException
    //   263	268	298	java/io/IOException
    //   21	27	302	finally
    //   27	38	313	finally
    //   38	63	321	finally
    //   63	71	321	finally
    //   75	110	321	finally
    //   140	149	321	finally
    //   162	208	329	finally
    //   6	21	333	java/lang/Throwable
    //   21	27	343	java/lang/Throwable
    //   27	38	351	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.kingkong.Utils
 * JD-Core Version:    0.7.0.1
 */