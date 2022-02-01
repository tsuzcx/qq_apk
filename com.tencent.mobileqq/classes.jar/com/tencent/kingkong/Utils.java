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
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream);
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
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
      paramInputStream.close();
      paramInputStream = Base64.encodeToString(localMessageDigest.digest(), 2).trim();
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      label70:
      break label70;
    }
    return "";
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
    //   11: ifne +43 -> 54
    //   14: new 138	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc 141
    //   25: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_1
    //   30: aload_0
    //   31: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: ldc 147
    //   38: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 75
    //   44: aload_1
    //   45: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 82	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: ldc 27
    //   53: areturn
    //   54: new 138	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   61: astore 4
    //   63: aconst_null
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_1
    //   67: new 152	java/io/BufferedReader
    //   70: dup
    //   71: new 154	java/io/InputStreamReader
    //   74: dup
    //   75: new 156	java/io/FileInputStream
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 157	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   83: invokespecial 158	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   86: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 164	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +13 -> 109
    //   99: aload 4
    //   101: aload_1
    //   102: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: goto -16 -> 90
    //   109: aload_0
    //   110: invokevirtual 165	java/io/BufferedReader:close	()V
    //   113: goto +36 -> 149
    //   116: astore_2
    //   117: aload_0
    //   118: astore_1
    //   119: aload_2
    //   120: astore_0
    //   121: goto +34 -> 155
    //   124: astore_2
    //   125: goto +10 -> 135
    //   128: astore_0
    //   129: goto +26 -> 155
    //   132: astore_2
    //   133: aload_3
    //   134: astore_0
    //   135: aload_0
    //   136: astore_1
    //   137: aload_2
    //   138: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 165	java/io/BufferedReader:close	()V
    //   149: aload 4
    //   151: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: areturn
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 165	java/io/BufferedReader:close	()V
    //   163: goto +5 -> 168
    //   166: aload_0
    //   167: athrow
    //   168: goto -2 -> 166
    //   171: astore_0
    //   172: goto -23 -> 149
    //   175: astore_1
    //   176: goto -13 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramString	String
    //   21	139	1	localObject1	Object
    //   175	1	1	localIOException1	IOException
    //   116	4	2	localObject2	Object
    //   124	1	2	localIOException2	IOException
    //   132	6	2	localIOException3	IOException
    //   64	70	3	localObject3	Object
    //   61	89	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   90	95	116	finally
    //   99	106	116	finally
    //   90	95	124	java/io/IOException
    //   99	106	124	java/io/IOException
    //   67	90	128	finally
    //   137	141	128	finally
    //   67	90	132	java/io/IOException
    //   109	113	171	java/io/IOException
    //   145	149	171	java/io/IOException
    //   159	163	175	java/io/IOException
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
      label29:
      break label29;
    }
    Common.Log.a("Lynn", "Unable to calculate SHA1");
    return "";
  }
  
  public static StringBuilder a()
  {
    return new StringBuilder();
  }
  
  public static void a(Context paramContext)
  {
    Object localObject = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
    ((SharedPreferences.Editor)localObject).clear();
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append(Common.d);
    ((StringBuilder)localObject).append("kingkong");
    ((StringBuilder)localObject).append(Common.d);
    ((StringBuilder)localObject).append("download");
    a(new File(((StringBuilder)localObject).toString()));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append(Common.d);
    ((StringBuilder)localObject).append("kingkong");
    ((StringBuilder)localObject).append(Common.d);
    ((StringBuilder)localObject).append("patches");
    a(new File(((StringBuilder)localObject).toString()));
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: new 219	java/io/FileOutputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 220	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload 5
    //   20: astore 4
    //   22: aload_2
    //   23: astore 5
    //   25: new 87	java/io/BufferedInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokevirtual 224	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   33: aload_1
    //   34: invokevirtual 230	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: invokespecial 90	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_0
    //   41: sipush 8192
    //   44: newarray byte
    //   46: astore_1
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 105	java/io/BufferedInputStream:read	([B)I
    //   52: istore_3
    //   53: iload_3
    //   54: iconst_m1
    //   55: if_icmpeq +13 -> 68
    //   58: aload_2
    //   59: aload_1
    //   60: iconst_0
    //   61: iload_3
    //   62: invokevirtual 235	java/io/OutputStream:write	([BII)V
    //   65: goto -18 -> 47
    //   68: aload_0
    //   69: invokevirtual 112	java/io/BufferedInputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 236	java/io/OutputStream:close	()V
    //   76: iconst_1
    //   77: ireturn
    //   78: astore_1
    //   79: aload_0
    //   80: astore 4
    //   82: aload_1
    //   83: astore_0
    //   84: goto +66 -> 150
    //   87: astore_1
    //   88: goto +22 -> 110
    //   91: astore_1
    //   92: aload 6
    //   94: astore_0
    //   95: goto +15 -> 110
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_2
    //   101: goto +49 -> 150
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: aload 6
    //   109: astore_0
    //   110: aload_0
    //   111: astore 4
    //   113: aload_2
    //   114: astore 5
    //   116: ldc 75
    //   118: aload_1
    //   119: invokevirtual 239	java/io/IOException:getMessage	()Ljava/lang/String;
    //   122: invokestatic 82	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: ifnull +10 -> 136
    //   129: aload_0
    //   130: invokevirtual 112	java/io/BufferedInputStream:close	()V
    //   133: goto +3 -> 136
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 236	java/io/OutputStream:close	()V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_0
    //   147: aload 5
    //   149: astore_2
    //   150: aload 4
    //   152: ifnull +11 -> 163
    //   155: aload 4
    //   157: invokevirtual 112	java/io/BufferedInputStream:close	()V
    //   160: goto +3 -> 163
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 236	java/io/OutputStream:close	()V
    //   171: goto +5 -> 176
    //   174: aload_0
    //   175: athrow
    //   176: goto -2 -> 174
    //   179: astore_0
    //   180: goto -108 -> 72
    //   183: astore_0
    //   184: iconst_1
    //   185: ireturn
    //   186: astore_0
    //   187: goto -51 -> 136
    //   190: astore_0
    //   191: iconst_0
    //   192: ireturn
    //   193: astore_1
    //   194: goto -31 -> 163
    //   197: astore_1
    //   198: goto -27 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramContext	Context
    //   0	201	1	paramString1	String
    //   0	201	2	paramString2	String
    //   52	10	3	i	int
    //   4	152	4	localObject1	Object
    //   1	147	5	str	String
    //   7	101	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	47	78	finally
    //   47	53	78	finally
    //   58	65	78	finally
    //   41	47	87	java/io/IOException
    //   47	53	87	java/io/IOException
    //   58	65	87	java/io/IOException
    //   25	41	91	java/io/IOException
    //   9	18	98	finally
    //   9	18	104	java/io/IOException
    //   25	41	146	finally
    //   116	125	146	finally
    //   68	72	179	java/io/IOException
    //   72	76	183	java/io/IOException
    //   129	133	186	java/io/IOException
    //   140	144	190	java/io/IOException
    //   155	160	193	java/io/IOException
    //   167	171	197	java/io/IOException
  }
  
  public static boolean a(File paramFile)
  {
    if (!paramFile.exists()) {
      return false;
    }
    if (!paramFile.isDirectory()) {
      return false;
    }
    paramFile = paramFile.listFiles();
    int i = 0;
    while (i < paramFile.length)
    {
      File localFile = paramFile[i];
      if ((localFile.isDirectory()) && (!a(localFile))) {
        return false;
      }
      if (!localFile.delete()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    paramString = paramString.split(",");
    int j = Build.VERSION.SDK_INT;
    int k = paramString.length;
    int i = 0;
    while (i < k)
    {
      if (String.valueOf(j).equals(paramString[i].trim())) {
        return true;
      }
      i += 1;
    }
    return false;
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
            paramString2 = new StringBuilder();
            paramString2.append("Signature mismatch in : ");
            paramString2.append(paramString1);
            Common.Log.a("KingKongUtils", paramString2.toString());
            return false;
          }
        }
      }
      paramString2 = new StringBuilder();
      paramString2.append("Check file signatures OK : ");
      paramString2.append(paramString1);
      Common.Log.a("KingKongUtils", paramString2.toString());
      return true;
    }
    catch (CertificateEncodingException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("Check file signature failed : ");
      paramString2.append(paramString1);
      Common.Log.a("KingKongUtils", paramString2.toString());
      return false;
    }
    catch (IOException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("Check file signature failed : ");
      paramString2.append(paramString1);
      Common.Log.a("KingKongUtils", paramString2.toString());
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, false, "");
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramString3.startsWith("META-INF/"))
    {
      paramString1 = new StringBuilder();
      paramString1.append("Reload file with unexpected name : ");
      paramString1.append(paramString3);
      Common.Log.a("KingKongUtils", paramString1.toString());
      return false;
    }
    if (!paramBoolean) {}
    try
    {
      paramBoolean = a(paramString2, paramString3, paramString1);
      if (paramBoolean)
      {
        paramString3 = new StringBuilder();
        paramString3.append("Current file changed, reload OK : ");
        paramString3.append(paramString1);
        paramString3.append(", ");
        paramString3.append(paramString2);
        Common.Log.a("KingKongUtils", paramString3.toString());
        return true;
      }
      paramString3 = new StringBuilder();
      paramString3.append("Current file changed and unable to be reloaded : ");
      paramString3.append(paramString1);
      paramString3.append(", ");
      paramString3.append(paramString2);
      Common.Log.a("KingKongUtils", paramString3.toString());
      return false;
    }
    catch (Exception paramString2)
    {
      paramString3 = new StringBuilder();
      paramString3.append("Error occurred while reload file ");
      paramString3.append(paramString1);
      paramString3.append(" : ");
      paramString3.append(paramString2);
      Common.Log.a("KingKongUtils", paramString3.toString());
    }
    if (b(paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("Current file changed, copy OK : ");
      paramString2.append(paramString1);
      Common.Log.a("KingKongUtils", paramString2.toString());
      return true;
    }
    paramString2 = new StringBuilder();
    paramString2.append("Current file changed and unable to be repaired : ");
    paramString2.append(paramString1);
    Common.Log.a("KingKongUtils", paramString2.toString());
    return false;
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
              paramString3 = new StringBuilder();
              paramString3.append("Extract ");
              paramString3.append(paramString2);
              paramString3.append(" from ");
              paramString3.append(paramString1);
              paramString3.append(" failed : Signature mismatch!");
              Common.Log.a("KingKongUtils", paramString3.toString());
              return false;
            }
          }
          if (a(localJarFile, localJarEntry, paramString3))
          {
            paramString3 = new StringBuilder();
            paramString3.append("Extract ");
            paramString3.append(paramString2);
            paramString3.append(" from ");
            paramString3.append(paramString1);
            paramString3.append(" OK");
            Common.Log.a("KingKongUtils", paramString3.toString());
            return true;
          }
          paramString3 = new StringBuilder();
          paramString3.append("Extract ");
          paramString3.append(paramString2);
          paramString3.append(" from ");
          paramString3.append(paramString1);
          paramString3.append(" failed : Read error");
          Common.Log.a("KingKongUtils", paramString3.toString());
          return false;
        }
      }
      paramString3 = new StringBuilder();
      paramString3.append("Extract ");
      paramString3.append(paramString2);
      paramString3.append(" from ");
      paramString3.append(paramString1);
      paramString3.append(" failed : No such file in Apk");
      Common.Log.a("KingKongUtils", paramString3.toString());
      return false;
    }
    catch (Exception paramString3)
    {
      paramString4 = new StringBuilder();
      paramString4.append("Extract ");
      paramString4.append(paramString2);
      paramString4.append(" from ");
      paramString4.append(paramString1);
      paramString4.append(" failed : Exception ");
      paramString4.append(paramString3);
      Common.Log.a("KingKongUtils", paramString4.toString());
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
    catch (IOException|RuntimeException paramJarFile) {}
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
    catch (IOException|RuntimeException paramJarFile) {}
    return null;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageName();
      boolean bool = TextUtils.isEmpty(paramContext);
      if (!bool) {
        return paramContext;
      }
      return "";
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = a(new FileInputStream(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      label14:
      break label14;
    }
    return "";
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    Object localObject1 = new File(paramString1);
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    try
    {
      localObject1 = new FileOutputStream(paramString1, false);
      Object localObject2 = new FileInputStream(paramString2);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = ((FileInputStream)localObject2).read(arrayOfByte);
        if (i <= 0)
        {
          ((FileOutputStream)localObject1).close();
          ((FileInputStream)localObject2).close();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Copy file ");
          ((StringBuilder)localObject1).append(paramString2);
          ((StringBuilder)localObject1).append(" to ");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(" OK");
          Common.Log.a("KingKongUtils", ((StringBuilder)localObject1).toString());
          return true;
        }
        ((FileOutputStream)localObject1).write(arrayOfByte, 0, i);
      }
      return false;
    }
    catch (IOException localIOException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Copy file ");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" to ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" failed:");
      ((StringBuilder)localObject2).append(localIOException);
      Common.Log.a("KingKongUtils", ((StringBuilder)localObject2).toString());
      localIOException.printStackTrace();
    }
  }
  
  /* Error */
  public static boolean c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 407	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 408	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 412	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 414	java/net/HttpURLConnection
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 417	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   19: astore 5
    //   21: new 219	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: iconst_0
    //   27: invokespecial 374	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   30: astore 10
    //   32: aload_3
    //   33: astore 6
    //   35: aload 5
    //   37: astore 8
    //   39: aload 10
    //   41: astore 9
    //   43: aload_3
    //   44: sipush 300
    //   47: invokevirtual 421	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   50: aload_3
    //   51: astore 6
    //   53: aload 5
    //   55: astore 8
    //   57: aload 10
    //   59: astore 9
    //   61: aload_3
    //   62: sipush 300
    //   65: invokevirtual 424	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   68: aload_3
    //   69: astore 6
    //   71: aload 5
    //   73: astore 8
    //   75: aload 10
    //   77: astore 9
    //   79: aload_3
    //   80: invokevirtual 427	java/net/HttpURLConnection:connect	()V
    //   83: aload_3
    //   84: astore 6
    //   86: aload 5
    //   88: astore 8
    //   90: aload 10
    //   92: astore 9
    //   94: sipush 1024
    //   97: newarray byte
    //   99: astore 4
    //   101: aload_3
    //   102: astore 6
    //   104: aload 5
    //   106: astore 8
    //   108: aload 10
    //   110: astore 9
    //   112: aload 5
    //   114: aload 4
    //   116: invokevirtual 428	java/io/InputStream:read	([B)I
    //   119: istore_2
    //   120: iload_2
    //   121: ifgt +145 -> 266
    //   124: aload_3
    //   125: astore 6
    //   127: aload 5
    //   129: astore 8
    //   131: aload 10
    //   133: astore 9
    //   135: new 138	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   142: astore 4
    //   144: aload_3
    //   145: astore 6
    //   147: aload 5
    //   149: astore 8
    //   151: aload 10
    //   153: astore 9
    //   155: aload 4
    //   157: ldc_w 430
    //   160: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_3
    //   165: astore 6
    //   167: aload 5
    //   169: astore 8
    //   171: aload 10
    //   173: astore 9
    //   175: aload 4
    //   177: aload_0
    //   178: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_3
    //   183: astore 6
    //   185: aload 5
    //   187: astore 8
    //   189: aload 10
    //   191: astore 9
    //   193: aload 4
    //   195: ldc_w 335
    //   198: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_3
    //   203: astore 6
    //   205: aload 5
    //   207: astore 8
    //   209: aload 10
    //   211: astore 9
    //   213: aload 4
    //   215: aload_1
    //   216: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_3
    //   221: astore 6
    //   223: aload 5
    //   225: astore 8
    //   227: aload 10
    //   229: astore 9
    //   231: ldc 75
    //   233: aload 4
    //   235: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 82	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload 5
    //   243: ifnull +8 -> 251
    //   246: aload 5
    //   248: invokevirtual 115	java/io/InputStream:close	()V
    //   251: aload 10
    //   253: invokevirtual 379	java/io/FileOutputStream:close	()V
    //   256: aload_3
    //   257: ifnull +7 -> 264
    //   260: aload_3
    //   261: invokevirtual 433	java/net/HttpURLConnection:disconnect	()V
    //   264: iconst_1
    //   265: ireturn
    //   266: aload_3
    //   267: astore 6
    //   269: aload 5
    //   271: astore 8
    //   273: aload 10
    //   275: astore 9
    //   277: aload 10
    //   279: aload 4
    //   281: iconst_0
    //   282: iload_2
    //   283: invokevirtual 378	java/io/FileOutputStream:write	([BII)V
    //   286: goto -185 -> 101
    //   289: astore 4
    //   291: aload_3
    //   292: astore 7
    //   294: aload 10
    //   296: astore_3
    //   297: goto +69 -> 366
    //   300: astore_0
    //   301: aconst_null
    //   302: astore 9
    //   304: goto +262 -> 566
    //   307: astore 4
    //   309: aconst_null
    //   310: astore 6
    //   312: aload_3
    //   313: astore 7
    //   315: aload 6
    //   317: astore_3
    //   318: goto +48 -> 366
    //   321: astore_0
    //   322: goto +24 -> 346
    //   325: astore 4
    //   327: aconst_null
    //   328: astore 6
    //   330: aload 6
    //   332: astore 5
    //   334: aload_3
    //   335: astore 7
    //   337: aload 6
    //   339: astore_3
    //   340: goto +26 -> 366
    //   343: astore_0
    //   344: aconst_null
    //   345: astore_3
    //   346: aconst_null
    //   347: astore 5
    //   349: aconst_null
    //   350: astore 9
    //   352: goto +214 -> 566
    //   355: astore 4
    //   357: aconst_null
    //   358: astore 5
    //   360: aload 5
    //   362: astore_3
    //   363: aload_3
    //   364: astore 7
    //   366: aload 7
    //   368: astore 6
    //   370: aload 5
    //   372: astore 8
    //   374: aload_3
    //   375: astore 9
    //   377: new 138	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   384: astore 10
    //   386: aload 7
    //   388: astore 6
    //   390: aload 5
    //   392: astore 8
    //   394: aload_3
    //   395: astore 9
    //   397: aload 10
    //   399: ldc_w 435
    //   402: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 7
    //   408: astore 6
    //   410: aload 5
    //   412: astore 8
    //   414: aload_3
    //   415: astore 9
    //   417: aload 10
    //   419: aload_0
    //   420: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 7
    //   426: astore 6
    //   428: aload 5
    //   430: astore 8
    //   432: aload_3
    //   433: astore 9
    //   435: aload 10
    //   437: ldc_w 335
    //   440: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 7
    //   446: astore 6
    //   448: aload 5
    //   450: astore 8
    //   452: aload_3
    //   453: astore 9
    //   455: aload 10
    //   457: aload_1
    //   458: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 7
    //   464: astore 6
    //   466: aload 5
    //   468: astore 8
    //   470: aload_3
    //   471: astore 9
    //   473: aload 10
    //   475: ldc_w 348
    //   478: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 7
    //   484: astore 6
    //   486: aload 5
    //   488: astore 8
    //   490: aload_3
    //   491: astore 9
    //   493: aload 10
    //   495: aload 4
    //   497: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 7
    //   503: astore 6
    //   505: aload 5
    //   507: astore 8
    //   509: aload_3
    //   510: astore 9
    //   512: ldc 75
    //   514: aload 10
    //   516: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 82	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: aload 5
    //   524: ifnull +11 -> 535
    //   527: aload 5
    //   529: invokevirtual 115	java/io/InputStream:close	()V
    //   532: goto +3 -> 535
    //   535: aload_3
    //   536: ifnull +10 -> 546
    //   539: aload_3
    //   540: invokevirtual 379	java/io/FileOutputStream:close	()V
    //   543: goto +3 -> 546
    //   546: aload 7
    //   548: ifnull +8 -> 556
    //   551: aload 7
    //   553: invokevirtual 433	java/net/HttpURLConnection:disconnect	()V
    //   556: iconst_0
    //   557: ireturn
    //   558: astore_0
    //   559: aload 8
    //   561: astore 5
    //   563: aload 6
    //   565: astore_3
    //   566: aload 5
    //   568: ifnull +11 -> 579
    //   571: aload 5
    //   573: invokevirtual 115	java/io/InputStream:close	()V
    //   576: goto +3 -> 579
    //   579: aload 9
    //   581: ifnull +11 -> 592
    //   584: aload 9
    //   586: invokevirtual 379	java/io/FileOutputStream:close	()V
    //   589: goto +3 -> 592
    //   592: aload_3
    //   593: ifnull +7 -> 600
    //   596: aload_3
    //   597: invokevirtual 433	java/net/HttpURLConnection:disconnect	()V
    //   600: goto +5 -> 605
    //   603: aload_0
    //   604: athrow
    //   605: goto -2 -> 603
    //   608: astore_0
    //   609: goto -358 -> 251
    //   612: astore_0
    //   613: goto -357 -> 256
    //   616: astore_0
    //   617: goto -82 -> 535
    //   620: astore_0
    //   621: goto -75 -> 546
    //   624: astore_1
    //   625: goto -46 -> 579
    //   628: astore_1
    //   629: goto -37 -> 592
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	paramString1	String
    //   0	632	1	paramString2	String
    //   119	164	2	i	int
    //   14	583	3	localObject1	Object
    //   99	181	4	localObject2	Object
    //   289	1	4	localThrowable1	Throwable
    //   307	1	4	localThrowable2	Throwable
    //   325	1	4	localThrowable3	Throwable
    //   355	141	4	localThrowable4	Throwable
    //   19	553	5	localObject3	Object
    //   33	531	6	localObject4	Object
    //   292	260	7	localObject5	Object
    //   37	523	8	localObject6	Object
    //   41	544	9	localObject7	Object
    //   30	485	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   43	50	289	java/lang/Throwable
    //   61	68	289	java/lang/Throwable
    //   79	83	289	java/lang/Throwable
    //   94	101	289	java/lang/Throwable
    //   112	120	289	java/lang/Throwable
    //   135	144	289	java/lang/Throwable
    //   155	164	289	java/lang/Throwable
    //   175	182	289	java/lang/Throwable
    //   193	202	289	java/lang/Throwable
    //   213	220	289	java/lang/Throwable
    //   231	241	289	java/lang/Throwable
    //   277	286	289	java/lang/Throwable
    //   21	32	300	finally
    //   21	32	307	java/lang/Throwable
    //   15	21	321	finally
    //   15	21	325	java/lang/Throwable
    //   0	15	343	finally
    //   0	15	355	java/lang/Throwable
    //   43	50	558	finally
    //   61	68	558	finally
    //   79	83	558	finally
    //   94	101	558	finally
    //   112	120	558	finally
    //   135	144	558	finally
    //   155	164	558	finally
    //   175	182	558	finally
    //   193	202	558	finally
    //   213	220	558	finally
    //   231	241	558	finally
    //   277	286	558	finally
    //   377	386	558	finally
    //   397	406	558	finally
    //   417	424	558	finally
    //   435	444	558	finally
    //   455	462	558	finally
    //   473	482	558	finally
    //   493	501	558	finally
    //   512	522	558	finally
    //   246	251	608	java/io/IOException
    //   251	256	612	java/io/IOException
    //   527	532	616	java/io/IOException
    //   539	543	620	java/io/IOException
    //   571	576	624	java/io/IOException
    //   584	589	628	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.Utils
 * JD-Core Version:    0.7.0.1
 */