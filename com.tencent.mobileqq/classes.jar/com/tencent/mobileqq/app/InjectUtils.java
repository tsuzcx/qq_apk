package com.tencent.mobileqq.app;

import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.commonsdk.soload.DexReleasor;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class InjectUtils
{
  public static final String SUCCESS = "Success";
  private static final String TAG = "DexLoadOat";
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[8192];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    return l;
  }
  
  /* Error */
  private static String extractMd5File(Application paramApplication, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 42	android/app/Application:getFilesDir	()Ljava/io/File;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +11 -> 17
    //   9: aload_2
    //   10: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   13: astore_2
    //   14: goto +6 -> 20
    //   17: ldc 50
    //   19: astore_2
    //   20: new 44	java/io/File
    //   23: dup
    //   24: aload_2
    //   25: aload_1
    //   26: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: astore 4
    //   31: aconst_null
    //   32: astore_3
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_0
    //   36: invokevirtual 57	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   39: aload_1
    //   40: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   43: astore_0
    //   44: new 65	java/io/FileOutputStream
    //   47: dup
    //   48: aload 4
    //   50: iconst_0
    //   51: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_2
    //   55: aload_0
    //   56: aload_2
    //   57: invokestatic 70	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   60: pop2
    //   61: aload_0
    //   62: ifnull +10 -> 72
    //   65: aload_0
    //   66: invokevirtual 73	java/io/InputStream:close	()V
    //   69: goto +3 -> 72
    //   72: aload_2
    //   73: ifnull +120 -> 193
    //   76: aload_2
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 74	java/io/OutputStream:close	()V
    //   82: goto +111 -> 193
    //   85: astore_3
    //   86: aload_0
    //   87: astore_1
    //   88: aload_3
    //   89: astore_0
    //   90: goto +111 -> 201
    //   93: astore_3
    //   94: aload_0
    //   95: astore_1
    //   96: aload_2
    //   97: astore_0
    //   98: goto +38 -> 136
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_0
    //   105: astore_1
    //   106: aload_2
    //   107: astore_0
    //   108: aload_3
    //   109: astore_2
    //   110: goto +91 -> 201
    //   113: astore_3
    //   114: aconst_null
    //   115: astore_2
    //   116: aload_0
    //   117: astore_1
    //   118: aload_2
    //   119: astore_0
    //   120: goto +16 -> 136
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_3
    //   127: astore_1
    //   128: goto +73 -> 201
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_0
    //   134: aload_2
    //   135: astore_1
    //   136: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +36 -> 175
    //   142: new 82	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   149: astore_2
    //   150: aload_2
    //   151: aload 4
    //   153: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_2
    //   158: ldc 89
    //   160: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 94
    //   166: iconst_2
    //   167: aload_2
    //   168: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aload_3
    //   172: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload_1
    //   176: ifnull +10 -> 186
    //   179: aload_1
    //   180: invokevirtual 73	java/io/InputStream:close	()V
    //   183: goto +3 -> 186
    //   186: aload_0
    //   187: ifnull +6 -> 193
    //   190: goto -112 -> 78
    //   193: ldc 8
    //   195: areturn
    //   196: astore_3
    //   197: aload_0
    //   198: astore_2
    //   199: aload_3
    //   200: astore_0
    //   201: aload_1
    //   202: ifnull +10 -> 212
    //   205: aload_1
    //   206: invokevirtual 73	java/io/InputStream:close	()V
    //   209: goto +3 -> 212
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 74	java/io/OutputStream:close	()V
    //   220: goto +5 -> 225
    //   223: aload_0
    //   224: athrow
    //   225: goto -2 -> 223
    //   228: astore_0
    //   229: goto -157 -> 72
    //   232: astore_0
    //   233: goto -40 -> 193
    //   236: astore_1
    //   237: goto -51 -> 186
    //   240: astore_1
    //   241: goto -29 -> 212
    //   244: astore_1
    //   245: goto -25 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramApplication	Application
    //   0	248	1	paramString	String
    //   4	93	2	localObject1	Object
    //   101	6	2	localObject2	Object
    //   109	108	2	localObject3	Object
    //   32	1	3	localObject4	Object
    //   85	4	3	localObject5	Object
    //   93	1	3	localThrowable1	Throwable
    //   103	6	3	localObject6	Object
    //   113	14	3	localThrowable2	Throwable
    //   131	41	3	localThrowable3	Throwable
    //   196	4	3	localObject7	Object
    //   29	123	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   55	61	85	finally
    //   55	61	93	java/lang/Throwable
    //   44	55	101	finally
    //   44	55	113	java/lang/Throwable
    //   35	44	123	finally
    //   35	44	131	java/lang/Throwable
    //   136	175	196	finally
    //   65	69	228	java/io/IOException
    //   78	82	232	java/io/IOException
    //   179	183	236	java/io/IOException
    //   205	209	240	java/io/IOException
    //   216	220	244	java/io/IOException
  }
  
  public static String getStartupClassName(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Foo");
    String str;
    if (paramInt == 0) {
      str = "";
    } else {
      str = String.valueOf(paramInt + 1);
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  private static String injectExtraDexManual(Application paramApplication, boolean paramBoolean)
  {
    localObject1 = "Success";
    try
    {
      arrayOfString = DexReleasor.sExtraDexes;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        try
        {
          String[] arrayOfString;
          int i;
          Object localObject2;
          String str3;
          String str2;
          String str1;
          boolean bool;
          new File(paramApplication.getFilesDir(), str1).delete();
          try
          {
            new File(paramApplication.getFilesDir(), str1).delete();
            localObject2 = localObject1;
          }
          catch (Exception paramApplication)
          {
            Object localObject3 = localObject1;
            continue;
          }
          i += 1;
          continue;
          return localObject2;
          paramApplication = finally;
          continue;
          throw paramApplication;
          continue;
        }
        catch (Exception localException)
        {
          continue;
        }
        localObject1 = "/data/data/com.tencent.mobileqq/files";
      }
    }
    localObject2 = localObject1;
    if (i < arrayOfString.length)
    {
      str3 = arrayOfString[i];
      str2 = getStartupClassName(i);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(arrayOfString[i]);
      ((StringBuilder)localObject2).append(".MD5");
      str1 = ((StringBuilder)localObject2).toString();
      localObject2 = localObject1;
      if ((SoLoadCore.isLibExtracted(paramApplication.getApplicationContext(), DexReleasor.sExtraJarDexes[i], str1) ^ true))
      {
        if (paramBoolean)
        {
          localObject2 = null;
          break label259;
        }
        if (!SoLoadCore.releaseDexFromApk(paramApplication.getApplicationContext(), str3)) {
          localObject2 = null;
        } else {
          localObject2 = extractMd5File(paramApplication, str1);
        }
      }
      localObject1 = localObject2;
      if ("Success".equals(localObject2))
      {
        localObject1 = paramApplication.getFilesDir();
        if (localObject1 == null) {
          break label290;
        }
        localObject1 = ((File)localObject1).getAbsolutePath();
        localObject1 = SystemClassLoaderInjector.inject(paramApplication, new File((String)localObject1, DexReleasor.sExtraJarDexes[i]).getAbsolutePath(), str2, true);
      }
      QLog.e("DexLoadOat", 1, (String)localObject1);
      bool = "Success".equals(localObject1);
      if (bool) {}
    }
  }
  
  public static String injectExtraDexes(Application paramApplication, boolean paramBoolean)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 21) {
        try
        {
          DexReleasor.initDexCount(paramApplication);
          paramApplication = injectExtraDexManual(paramApplication, paramBoolean);
          return paramApplication;
        }
        catch (Throwable paramApplication)
        {
          QLog.e("DexLoadOat", 1, "", paramApplication);
          return null;
        }
      }
      return "Success";
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.InjectUtils
 * JD-Core Version:    0.7.0.1
 */