package com.tencent.hippy.qq.update;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import noe;

public class HippyQQFileUtil
{
  /* Error */
  public static void downLoad(String paramString, File paramFile, HippyQQFileUtil.DownLoadCallBack paramDownLoadCallBack)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 17	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 20	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 24	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 26	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: iconst_1
    //   23: invokevirtual 30	java/net/HttpURLConnection:setDoInput	(Z)V
    //   26: aload_0
    //   27: invokevirtual 34	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   30: astore_0
    //   31: new 36	java/io/FileOutputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 39	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore 5
    //   41: sipush 1024
    //   44: newarray byte
    //   46: astore 4
    //   48: aload_0
    //   49: aload 4
    //   51: invokevirtual 45	java/io/InputStream:read	([B)I
    //   54: istore_3
    //   55: iload_3
    //   56: iconst_m1
    //   57: if_icmpeq +63 -> 120
    //   60: aload 5
    //   62: aload 4
    //   64: iconst_0
    //   65: iload_3
    //   66: invokevirtual 49	java/io/FileOutputStream:write	([BII)V
    //   69: goto -21 -> 48
    //   72: astore 6
    //   74: aload_0
    //   75: astore 4
    //   77: aload 5
    //   79: astore_0
    //   80: aload 6
    //   82: astore 5
    //   84: aload 5
    //   86: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   89: aload_2
    //   90: ifnull +11 -> 101
    //   93: aload_2
    //   94: iconst_m1
    //   95: aload_1
    //   96: invokeinterface 58 3 0
    //   101: aload 4
    //   103: ifnull +8 -> 111
    //   106: aload 4
    //   108: invokevirtual 61	java/io/InputStream:close	()V
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   119: return
    //   120: aload_0
    //   121: invokevirtual 61	java/io/InputStream:close	()V
    //   124: aload 5
    //   126: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   129: aload_2
    //   130: ifnull +11 -> 141
    //   133: aload_2
    //   134: iconst_0
    //   135: aload_1
    //   136: invokeinterface 58 3 0
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 61	java/io/InputStream:close	()V
    //   149: aload 5
    //   151: ifnull -32 -> 119
    //   154: aload 5
    //   156: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   159: return
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   165: return
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   171: goto -22 -> 149
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   179: goto -68 -> 111
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   187: return
    //   188: astore 4
    //   190: iconst_0
    //   191: istore_3
    //   192: aconst_null
    //   193: astore_0
    //   194: aload 6
    //   196: astore 5
    //   198: aload_2
    //   199: ifnull +11 -> 210
    //   202: aload_2
    //   203: iload_3
    //   204: aload_1
    //   205: invokeinterface 58 3 0
    //   210: aload_0
    //   211: ifnull +7 -> 218
    //   214: aload_0
    //   215: invokevirtual 61	java/io/InputStream:close	()V
    //   218: aload 5
    //   220: ifnull +8 -> 228
    //   223: aload 5
    //   225: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   228: aload 4
    //   230: athrow
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   236: goto -18 -> 218
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   244: goto -16 -> 228
    //   247: astore 4
    //   249: iconst_0
    //   250: istore_3
    //   251: aload 6
    //   253: astore 5
    //   255: goto -57 -> 198
    //   258: astore 4
    //   260: iconst_0
    //   261: istore_3
    //   262: goto -64 -> 198
    //   265: astore 5
    //   267: aload 4
    //   269: astore 6
    //   271: iconst_m1
    //   272: istore_3
    //   273: aload 5
    //   275: astore 4
    //   277: aload_0
    //   278: astore 5
    //   280: aload 6
    //   282: astore_0
    //   283: goto -85 -> 198
    //   286: astore 5
    //   288: aconst_null
    //   289: astore_0
    //   290: goto -206 -> 84
    //   293: astore 5
    //   295: aconst_null
    //   296: astore 6
    //   298: aload_0
    //   299: astore 4
    //   301: aload 6
    //   303: astore_0
    //   304: goto -220 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramString	String
    //   0	307	1	paramFile	File
    //   0	307	2	paramDownLoadCallBack	HippyQQFileUtil.DownLoadCallBack
    //   54	219	3	i	int
    //   4	103	4	localObject1	Object
    //   188	41	4	localObject2	Object
    //   247	1	4	localObject3	Object
    //   258	10	4	localObject4	Object
    //   275	25	4	localObject5	Object
    //   39	215	5	localObject6	Object
    //   265	9	5	localObject7	Object
    //   278	1	5	str	String
    //   286	1	5	localException1	java.lang.Exception
    //   293	1	5	localException2	java.lang.Exception
    //   1	1	6	localObject8	Object
    //   72	180	6	localException3	java.lang.Exception
    //   269	33	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   41	48	72	java/lang/Exception
    //   48	55	72	java/lang/Exception
    //   60	69	72	java/lang/Exception
    //   120	129	72	java/lang/Exception
    //   154	159	160	java/io/IOException
    //   145	149	166	java/io/IOException
    //   106	111	174	java/io/IOException
    //   115	119	182	java/io/IOException
    //   6	31	188	finally
    //   214	218	231	java/io/IOException
    //   223	228	239	java/io/IOException
    //   31	41	247	finally
    //   41	48	258	finally
    //   48	55	258	finally
    //   60	69	258	finally
    //   120	129	258	finally
    //   84	89	265	finally
    //   6	31	286	java/lang/Exception
    //   31	41	293	java/lang/Exception
  }
  
  public static File getCDNDownloadFile()
  {
    try
    {
      File localFile = new File(getHippyFile(), "libs");
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      return localFile;
    }
    finally {}
  }
  
  public static String getCoreJsFilePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      File localFile;
      do
      {
        return null;
        localFile = getOfflineDownloadFile();
        if ((localFile != null) && (localFile.exists()))
        {
          localFile = new File(localFile, paramString);
          if ((localFile != null) && (localFile.exists())) {
            return localFile.getAbsolutePath();
          }
        }
        localFile = getCDNDownloadFile();
      } while ((localFile == null) || (!localFile.exists()));
      paramString = new File(localFile, paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return paramString.getAbsolutePath();
  }
  
  public static File getDiffFile(String paramString, int paramInt)
  {
    try
    {
      File localFile = new File(getHippyFile(), "dif");
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      paramString = new File(localFile, paramString + paramInt + ".dif");
      return paramString;
    }
    finally {}
  }
  
  private static File getHippyFile()
  {
    Object localObject = BaseApplicationImpl.getContext();
    if (localObject != null)
    {
      localObject = new File(((Context)localObject).getFilesDir(), "hippy");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      return localObject;
    }
    return null;
  }
  
  public static File getModuleFile(String paramString, int paramInt)
  {
    try
    {
      File localFile = new File(getHippyFile(), "bundle");
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      paramString = new File(localFile, paramString);
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      if (paramInt < 0) {
        return paramString;
      }
      paramString = new File(paramString, paramInt + "");
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      return paramString;
    }
    finally {}
  }
  
  public static File getModuleIndex(String paramString, int paramInt)
  {
    return new File(getModuleFile(paramString, paramInt), "index.android.jsbundle");
  }
  
  public static File getOfflineDownloadFile()
  {
    Object localObject = noe.a("1011");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = new File((String)localObject + "1011");
    } while ((localObject == null) || (!((File)localObject).exists()));
    return localObject;
  }
  
  public static File getZipFile(String paramString, int paramInt)
  {
    try
    {
      File localFile = new File(getHippyFile(), "zip");
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      paramString = new File(localFile, paramString + paramInt + ".zip");
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQFileUtil
 * JD-Core Version:    0.7.0.1
 */