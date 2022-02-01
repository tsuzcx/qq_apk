package com.tencent.avcore.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.avcore.util.AVCoreLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class Common
{
  public static final String AV_ENGINE_VERSION = "V2.9.0304.001";
  public static final String AV_SHARP_VERSION = "6.0.0";
  public static final String CONFIG_INFO = "ConfigInfo";
  public static final int EM_DEVICE_ANDROID = 201;
  public static final String FILE_NAME = "VideoConfigInfo";
  public static final String SHARP_CONFIG_PAYLOAD_FILE_NAME = "SharpConfigPayload_" + Build.MODEL;
  public static final String SHARP_CONFIG_TYPE_CLEAR = "0";
  public static final String SHARP_CONFIG_TYPE_PAYLOAD = "1";
  public static final String SHARP_CONFIG_TYPE_URL = "2";
  private static final String TAG = "Common";
  public static final ConcurrentHashMap<String, byte[]> mBuffer = new ConcurrentHashMap();
  
  public static void deleteFile(Context paramContext, String paramString)
  {
    try
    {
      mBuffer.remove(paramString);
      paramContext.deleteFile(paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String getVersion(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return "6.0.0";
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.versionName.trim())))
        {
          paramContext = paramContext.versionName.trim();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "6.0.0";
  }
  
  public static int intPow(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      j = 0;
      return j;
    }
    int j = 1;
    int i = paramInt2;
    paramInt2 = j;
    for (;;)
    {
      j = paramInt2;
      if (i <= 0) {
        break;
      }
      paramInt2 *= paramInt1;
      i -= 1;
    }
  }
  
  /* Error */
  public static byte[] readFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 65	com/tencent/avcore/config/Common:mBuffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 123	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 125	[B
    //   10: astore 4
    //   12: aload 4
    //   14: astore_3
    //   15: aload 4
    //   17: ifnonnull +49 -> 66
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 129	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   25: astore 5
    //   27: aload 5
    //   29: astore_0
    //   30: aload 4
    //   32: astore_3
    //   33: aload 5
    //   35: invokevirtual 135	java/io/FileInputStream:available	()I
    //   38: istore_2
    //   39: iload_2
    //   40: ifgt +68 -> 108
    //   43: aload 5
    //   45: astore_0
    //   46: aload 4
    //   48: astore_3
    //   49: aload 5
    //   51: invokevirtual 138	java/io/FileInputStream:close	()V
    //   54: aload 5
    //   56: ifnull +8 -> 64
    //   59: aload 5
    //   61: invokevirtual 138	java/io/FileInputStream:close	()V
    //   64: aconst_null
    //   65: astore_3
    //   66: aload_3
    //   67: areturn
    //   68: astore_0
    //   69: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   72: ifeq -8 -> 64
    //   75: ldc 33
    //   77: new 40	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   84: ldc 146
    //   86: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 148
    //   95: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: aload_0
    //   102: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: goto -41 -> 64
    //   108: aload 5
    //   110: astore_0
    //   111: aload 4
    //   113: astore_3
    //   114: iload_2
    //   115: newarray byte
    //   117: astore 4
    //   119: aload 5
    //   121: astore_0
    //   122: aload 4
    //   124: astore_3
    //   125: aload 5
    //   127: aload 4
    //   129: invokevirtual 156	java/io/FileInputStream:read	([B)I
    //   132: pop
    //   133: aload 5
    //   135: astore_0
    //   136: aload 4
    //   138: astore_3
    //   139: getstatic 65	com/tencent/avcore/config/Common:mBuffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   142: aload_1
    //   143: aload 4
    //   145: invokevirtual 160	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: aload 4
    //   151: astore_3
    //   152: aload 5
    //   154: ifnull -88 -> 66
    //   157: aload 5
    //   159: invokevirtual 138	java/io/FileInputStream:close	()V
    //   162: aload 4
    //   164: areturn
    //   165: astore_0
    //   166: aload 4
    //   168: astore_3
    //   169: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   172: ifeq -106 -> 66
    //   175: ldc 33
    //   177: new 40	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   184: ldc 146
    //   186: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 148
    //   195: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aload_0
    //   202: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload 4
    //   207: areturn
    //   208: astore_3
    //   209: aconst_null
    //   210: astore 5
    //   212: aload 5
    //   214: astore_0
    //   215: invokestatic 163	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   218: ifeq +36 -> 254
    //   221: aload 5
    //   223: astore_0
    //   224: ldc 33
    //   226: new 40	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   233: ldc 165
    //   235: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc 148
    //   244: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: aload_3
    //   251: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload 4
    //   256: astore_3
    //   257: aload 5
    //   259: ifnull -193 -> 66
    //   262: aload 5
    //   264: invokevirtual 138	java/io/FileInputStream:close	()V
    //   267: aload 4
    //   269: areturn
    //   270: astore_0
    //   271: aload 4
    //   273: astore_3
    //   274: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   277: ifeq -211 -> 66
    //   280: ldc 33
    //   282: new 40	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   289: ldc 146
    //   291: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_1
    //   295: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc 148
    //   300: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload_0
    //   307: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   310: aload 4
    //   312: areturn
    //   313: astore_3
    //   314: aconst_null
    //   315: astore_0
    //   316: aload_0
    //   317: ifnull +7 -> 324
    //   320: aload_0
    //   321: invokevirtual 138	java/io/FileInputStream:close	()V
    //   324: aload_3
    //   325: athrow
    //   326: astore_0
    //   327: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   330: ifeq -6 -> 324
    //   333: ldc 33
    //   335: new 40	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   342: ldc 146
    //   344: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_1
    //   348: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc 148
    //   353: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: aload_0
    //   360: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   363: goto -39 -> 324
    //   366: astore_3
    //   367: goto -51 -> 316
    //   370: astore_0
    //   371: aload_3
    //   372: astore 4
    //   374: aload_0
    //   375: astore_3
    //   376: goto -164 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramContext	Context
    //   0	379	1	paramString	String
    //   38	77	2	i	int
    //   14	155	3	localObject1	Object
    //   208	43	3	localException	Exception
    //   256	18	3	localObject2	Object
    //   313	12	3	localObject3	Object
    //   366	6	3	localObject4	Object
    //   375	1	3	localContext	Context
    //   10	363	4	localObject5	Object
    //   25	238	5	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   59	64	68	java/io/IOException
    //   157	162	165	java/io/IOException
    //   20	27	208	java/lang/Exception
    //   262	267	270	java/io/IOException
    //   20	27	313	finally
    //   320	324	326	java/io/IOException
    //   33	39	366	finally
    //   49	54	366	finally
    //   114	119	366	finally
    //   125	133	366	finally
    //   139	149	366	finally
    //   215	221	366	finally
    //   224	254	366	finally
    //   33	39	370	java/lang/Exception
    //   49	54	370	java/lang/Exception
    //   114	119	370	java/lang/Exception
    //   125	133	370	java/lang/Exception
    //   139	149	370	java/lang/Exception
  }
  
  public static void writeFile(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject3 = null;
    StringBuilder localStringBuilder = null;
    Object localObject2 = localStringBuilder;
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        mBuffer.put(paramString, paramArrayOfByte);
        localObject2 = localStringBuilder;
        localObject1 = localObject3;
        paramContext = paramContext.openFileOutput(paramString, 0);
        localObject2 = paramContext;
        localObject1 = paramContext;
        paramContext.write(paramArrayOfByte);
      }
      catch (Exception paramContext)
      {
        localObject1 = localObject2;
        localStringBuilder = new StringBuilder().append("writeFile, Exception, fileName[").append(paramString).append("], bytes[");
        if (paramArrayOfByte == null) {
          continue;
        }
        bool1 = true;
        localObject1 = localObject2;
        AVCoreLog.e("Common", bool1 + "]", paramContext);
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject2).close();
          return;
        }
        catch (IOException paramContext) {}
        if (!AVCoreLog.isDevelopLevel()) {
          continue;
        }
        paramString = new StringBuilder().append("writeFile, IOException, fileName[").append(paramString).append("], bytes[");
        if (paramArrayOfByte == null) {
          continue;
        }
        bool1 = bool2;
        AVCoreLog.e("Common", bool1 + "]", paramContext);
        return;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
      finally
      {
        if (localObject1 == null) {
          break label270;
        }
      }
      try
      {
        paramContext.close();
        return;
      }
      catch (IOException paramContext)
      {
        if (AVCoreLog.isDevelopLevel())
        {
          paramString = new StringBuilder().append("writeFile, IOException, fileName[").append(paramString).append("], bytes[");
          if (paramArrayOfByte != null)
          {
            AVCoreLog.e("Common", bool1 + "]", paramContext);
            return;
          }
          bool1 = false;
        }
      }
    }
    try
    {
      ((FileOutputStream)localObject1).close();
      label270:
      throw paramContext;
    }
    catch (IOException localIOException)
    {
      while (!AVCoreLog.isDevelopLevel()) {}
      paramString = new StringBuilder().append("writeFile, IOException, fileName[").append(paramString).append("], bytes[");
      if (paramArrayOfByte == null) {}
    }
    for (bool1 = bool3;; bool1 = false)
    {
      AVCoreLog.e("Common", bool1 + "]", localIOException);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.config.Common
 * JD-Core Version:    0.7.0.1
 */