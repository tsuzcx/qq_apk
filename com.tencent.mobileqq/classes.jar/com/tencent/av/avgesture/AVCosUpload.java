package com.tencent.av.avgesture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

class AVCosUpload
{
  static final String Appid = "1253925544";
  public static final String Bucket = "gzdata2";
  private static final int MaxUploadCount = 5;
  private static final int MinUploadInterval = 3;
  static final String SecretID = "AKIDfHjBUedP6c8Sp17LoupZDoGXdgYFIsfT";
  static final String SecretKey = "zymOoFiBSYTbeXbaUEwSlszvhItU0Qeh";
  public static final String TAG = "AVCosUpload";
  public static final int UPLOAD_FILE_ACCESSERROR = 8193;
  public static final int UPLOAD_NETWORK_FAIL = 8195;
  public static final int UPLOAD_SUCCESS = 0;
  private static AVCosUpload s_instance = null;
  static final ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
  public boolean IsUploading = false;
  public boolean ShouldUpload = false;
  private Timer mUploadTimer;
  
  /* Error */
  private static String ReadFile(String paramString)
  {
    // Byte code:
    //   0: new 76	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 81	java/io/BufferedReader
    //   12: dup
    //   13: new 83	java/io/FileReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 86	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   21: invokespecial 89	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: ldc 91
    //   27: astore_1
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: invokevirtual 95	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +29 -> 65
    //   39: aload_2
    //   40: astore_0
    //   41: new 97	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_3
    //   53: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: goto -34 -> 28
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 108	java/io/BufferedReader:close	()V
    //   71: aload_1
    //   72: astore_0
    //   73: aload_2
    //   74: ifnull +9 -> 83
    //   77: aload_2
    //   78: invokevirtual 108	java/io/BufferedReader:close	()V
    //   81: aload_1
    //   82: astore_0
    //   83: aload_0
    //   84: areturn
    //   85: astore_3
    //   86: aconst_null
    //   87: astore_2
    //   88: ldc 91
    //   90: astore_1
    //   91: aload_2
    //   92: astore_0
    //   93: aload_3
    //   94: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   97: aload_1
    //   98: astore_0
    //   99: aload_2
    //   100: ifnull -17 -> 83
    //   103: aload_2
    //   104: invokevirtual 108	java/io/BufferedReader:close	()V
    //   107: aload_1
    //   108: areturn
    //   109: astore_0
    //   110: aload_1
    //   111: areturn
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 108	java/io/BufferedReader:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_0
    //   126: aload_1
    //   127: areturn
    //   128: astore_0
    //   129: goto -6 -> 123
    //   132: astore_1
    //   133: goto -18 -> 115
    //   136: astore_3
    //   137: goto -46 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   27	84	1	localObject1	Object
    //   112	15	1	str1	String
    //   132	1	1	localObject2	Object
    //   24	80	2	localBufferedReader	java.io.BufferedReader
    //   34	27	3	str2	String
    //   85	9	3	localIOException1	IOException
    //   136	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   9	25	85	java/io/IOException
    //   103	107	109	java/io/IOException
    //   9	25	112	finally
    //   77	81	125	java/io/IOException
    //   119	123	128	java/io/IOException
    //   30	35	132	finally
    //   41	60	132	finally
    //   67	71	132	finally
    //   93	97	132	finally
    //   30	35	136	java/io/IOException
    //   41	60	136	java/io/IOException
    //   67	71	136	java/io/IOException
  }
  
  private static void WriteFile(String paramString1, String paramString2)
    throws IOException
  {
    paramString1 = new FileWriter(paramString1);
    PrintWriter localPrintWriter = new PrintWriter(paramString1);
    localPrintWriter.write(paramString2);
    localPrintWriter.println();
    paramString1.close();
    localPrintWriter.close();
  }
  
  private boolean cacheInputImageTo(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
      paramString = new FileOutputStream(new File(paramString));
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, paramString);
      paramString.flush();
      paramString.close();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static AVCosUpload createInstance()
  {
    if (s_instance == null) {}
    try
    {
      if (s_instance == null) {
        s_instance = new AVCosUpload();
      }
      return s_instance;
    }
    finally {}
  }
  
  private String getParamString(Map<String, String> paramMap, String paramString)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      for (paramMap = "";; paramMap = paramMap + (String)((Map.Entry)localObject).getValue() + "\r\n")
      {
        localObject = paramMap;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        paramMap = paramMap + "--" + paramString + "\r\n";
        paramMap = paramMap + "Content-Disposition: form-data; name=\"" + (String)((Map.Entry)localObject).getKey() + "\"\r\n\r\n";
      }
    }
    Object localObject = "";
    return localObject;
  }
  
  private File openFile(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("AVCosUpload", "checkFile| filePath == null.");
      return null;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      Log.e("AVCosUpload", "checkFile| filePath is not exist. path=" + paramString);
      return null;
    }
    return localFile;
  }
  
  private boolean shouldUpload(String paramString1, String paramString2)
  {
    if ((!this.ShouldUpload) || (this.IsUploading)) {
      return false;
    }
    paramString1 = paramString1 + "/av_cos_uploaded_count.json";
    Object localObject = new File(paramString1);
    if (!((File)localObject).exists()) {
      try
      {
        ((File)localObject).createNewFile();
        localObject = new JSONObject();
        ((JSONObject)localObject).put(paramString2, 1);
        WriteFile(paramString1, ((JSONObject)localObject).toString());
        return true;
      }
      catch (Exception paramString1) {}
    }
    do
    {
      return false;
      localObject = ReadFile(paramString1);
    } while (((String)localObject).equals(""));
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has(paramString2)) {
          break label165;
        }
        i = ((JSONObject)localObject).getInt(paramString2) + 1;
        if (i >= 5) {
          break;
        }
        ((JSONObject)localObject).put(paramString2, i);
        WriteFile(paramString1, ((JSONObject)localObject).toString());
        return true;
      }
      catch (Exception paramString1) {}
      break;
      label165:
      int i = 1;
    }
  }
  
  private void uploadFileImpl(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final int paramInt, final UploadFileListener paramUploadFileListener)
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_2
        //   2: iconst_0
        //   3: istore_1
        //   4: aconst_null
        //   5: astore 9
        //   7: aconst_null
        //   8: astore 6
        //   10: aconst_null
        //   11: astore 10
        //   13: ldc 56
        //   15: astore 8
        //   17: aload_0
        //   18: getfield 27	com/tencent/av/avgesture/AVCosUpload$2:this$0	Lcom/tencent/av/avgesture/AVCosUpload;
        //   21: aload_0
        //   22: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   25: invokestatic 60	com/tencent/av/avgesture/AVCosUpload:access$300	(Lcom/tencent/av/avgesture/AVCosUpload;Ljava/lang/String;)Ljava/io/File;
        //   28: astore 4
        //   30: aload 4
        //   32: ifnonnull +87 -> 119
        //   35: sipush 8193
        //   38: istore_1
        //   39: aconst_null
        //   40: astore 6
        //   42: aconst_null
        //   43: astore 7
        //   45: aconst_null
        //   46: astore 4
        //   48: aconst_null
        //   49: astore 5
        //   51: aload 10
        //   53: astore 8
        //   55: aload 5
        //   57: ifnull +8 -> 65
        //   60: aload 5
        //   62: invokevirtual 65	java/io/FileInputStream:close	()V
        //   65: aload 7
        //   67: ifnull +8 -> 75
        //   70: aload 7
        //   72: invokevirtual 68	java/io/OutputStream:close	()V
        //   75: aload 6
        //   77: ifnull +8 -> 85
        //   80: aload 6
        //   82: invokevirtual 71	java/io/BufferedReader:close	()V
        //   85: aload 4
        //   87: ifnull +8 -> 95
        //   90: aload 4
        //   92: invokevirtual 76	java/net/HttpURLConnection:disconnect	()V
        //   95: aload_0
        //   96: getfield 41	com/tencent/av/avgesture/AVCosUpload$2:val$monitor	Lcom/tencent/av/avgesture/AVCosUpload$UploadFileListener;
        //   99: ifnull +19 -> 118
        //   102: aload_0
        //   103: getfield 41	com/tencent/av/avgesture/AVCosUpload$2:val$monitor	Lcom/tencent/av/avgesture/AVCosUpload$UploadFileListener;
        //   106: iload_1
        //   107: aload_0
        //   108: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   111: aload 8
        //   113: invokeinterface 82 4 0
        //   118: return
        //   119: aload_0
        //   120: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   123: invokestatic 88	com/tencent/av/avgesture/SHA1Utils:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
        //   126: astore 11
        //   128: new 62	java/io/FileInputStream
        //   131: dup
        //   132: aload 4
        //   134: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   137: astore 5
        //   139: aload 5
        //   141: invokevirtual 95	java/io/FileInputStream:available	()I
        //   144: istore_3
        //   145: iload_3
        //   146: ifle +11 -> 157
        //   149: iload_3
        //   150: aload_0
        //   151: getfield 31	com/tencent/av/avgesture/AVCosUpload$2:val$maxSize	I
        //   154: if_icmple +60 -> 214
        //   157: ldc 97
        //   159: new 99	java/lang/StringBuilder
        //   162: dup
        //   163: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   166: ldc 102
        //   168: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   171: aload_0
        //   172: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   175: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   178: ldc 108
        //   180: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   183: iload_3
        //   184: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   187: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   190: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   193: pop
        //   194: sipush 8193
        //   197: istore_1
        //   198: aconst_null
        //   199: astore 6
        //   201: aconst_null
        //   202: astore 7
        //   204: aconst_null
        //   205: astore 4
        //   207: aload 10
        //   209: astore 8
        //   211: goto -156 -> 55
        //   214: new 123	java/net/URL
        //   217: dup
        //   218: ldc 125
        //   220: iconst_4
        //   221: anewarray 4	java/lang/Object
        //   224: dup
        //   225: iconst_0
        //   226: ldc 127
        //   228: aastore
        //   229: dup
        //   230: iconst_1
        //   231: aload_0
        //   232: getfield 33	com/tencent/av/avgesture/AVCosUpload$2:val$bucket	Ljava/lang/String;
        //   235: aastore
        //   236: dup
        //   237: iconst_2
        //   238: aload_0
        //   239: getfield 35	com/tencent/av/avgesture/AVCosUpload$2:val$type	Ljava/lang/String;
        //   242: aastore
        //   243: dup
        //   244: iconst_3
        //   245: aload_0
        //   246: getfield 37	com/tencent/av/avgesture/AVCosUpload$2:val$cosName	Ljava/lang/String;
        //   249: aastore
        //   250: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   253: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;)V
        //   256: invokevirtual 140	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   259: checkcast 73	java/net/HttpURLConnection
        //   262: astore 4
        //   264: aload 4
        //   266: sipush 5000
        //   269: invokevirtual 144	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   272: aload 4
        //   274: sipush 30000
        //   277: invokevirtual 147	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   280: aload 4
        //   282: iconst_1
        //   283: invokevirtual 151	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   286: aload 4
        //   288: iconst_1
        //   289: invokevirtual 154	java/net/HttpURLConnection:setDoInput	(Z)V
        //   292: aload 4
        //   294: iconst_0
        //   295: invokevirtual 157	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   298: aload 4
        //   300: ldc 159
        //   302: invokevirtual 162	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   305: aload 4
        //   307: ldc 164
        //   309: ldc 166
        //   311: invokevirtual 170	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   314: aload 4
        //   316: ldc 172
        //   318: aload_0
        //   319: getfield 39	com/tencent/av/avgesture/AVCosUpload$2:val$sign	Ljava/lang/String;
        //   322: invokevirtual 170	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   325: aload 4
        //   327: ldc 174
        //   329: new 99	java/lang/StringBuilder
        //   332: dup
        //   333: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   336: ldc 176
        //   338: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   341: ldc 178
        //   343: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   346: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   349: invokevirtual 170	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   352: new 180	java/io/DataOutputStream
        //   355: dup
        //   356: aload 4
        //   358: invokevirtual 184	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   361: invokespecial 187	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   364: astore 7
        //   366: new 189	java/util/HashMap
        //   369: dup
        //   370: iconst_3
        //   371: invokespecial 191	java/util/HashMap:<init>	(I)V
        //   374: astore 12
        //   376: aload 12
        //   378: ldc 193
        //   380: ldc 195
        //   382: invokeinterface 201 3 0
        //   387: pop
        //   388: aload 12
        //   390: ldc 203
        //   392: aload 11
        //   394: invokeinterface 201 3 0
        //   399: pop
        //   400: aload 12
        //   402: ldc 205
        //   404: ldc 56
        //   406: invokeinterface 201 3 0
        //   411: pop
        //   412: aload_0
        //   413: getfield 27	com/tencent/av/avgesture/AVCosUpload$2:this$0	Lcom/tencent/av/avgesture/AVCosUpload;
        //   416: aload 12
        //   418: ldc 178
        //   420: invokestatic 209	com/tencent/av/avgesture/AVCosUpload:access$400	(Lcom/tencent/av/avgesture/AVCosUpload;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
        //   423: astore 11
        //   425: new 99	java/lang/StringBuilder
        //   428: dup
        //   429: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   432: aload 11
        //   434: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   437: ldc 211
        //   439: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   442: ldc 178
        //   444: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   447: ldc 213
        //   449: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   452: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   455: astore 11
        //   457: new 99	java/lang/StringBuilder
        //   460: dup
        //   461: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   464: aload 11
        //   466: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   469: ldc 215
        //   471: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   474: aload_0
        //   475: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   478: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   481: ldc 217
        //   483: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   486: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   489: astore 11
        //   491: aload 7
        //   493: new 99	java/lang/StringBuilder
        //   496: dup
        //   497: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   500: aload 11
        //   502: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   505: ldc 219
        //   507: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   510: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   513: invokevirtual 223	java/lang/String:getBytes	()[B
        //   516: invokevirtual 227	java/io/OutputStream:write	([B)V
        //   519: sipush 1024
        //   522: newarray byte
        //   524: astore 11
        //   526: aload 5
        //   528: aload 11
        //   530: invokevirtual 231	java/io/FileInputStream:read	([B)I
        //   533: istore_3
        //   534: iload_3
        //   535: iconst_m1
        //   536: if_icmpeq +72 -> 608
        //   539: aload 7
        //   541: aload 11
        //   543: iconst_0
        //   544: iload_3
        //   545: invokevirtual 234	java/io/OutputStream:write	([BII)V
        //   548: goto -22 -> 526
        //   551: astore 9
        //   553: aconst_null
        //   554: astore 6
        //   556: aload 7
        //   558: astore 8
        //   560: aload 4
        //   562: astore 7
        //   564: aload 8
        //   566: astore 4
        //   568: aload 9
        //   570: astore 8
        //   572: ldc 97
        //   574: ldc 236
        //   576: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   579: pop
        //   580: aload 8
        //   582: invokevirtual 239	java/net/UnknownHostException:printStackTrace	()V
        //   585: aload 7
        //   587: astore 8
        //   589: aload 4
        //   591: astore 7
        //   593: sipush 8195
        //   596: istore_1
        //   597: aload 8
        //   599: astore 4
        //   601: aload 10
        //   603: astore 8
        //   605: goto -550 -> 55
        //   608: aload 7
        //   610: new 99	java/lang/StringBuilder
        //   613: dup
        //   614: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   617: ldc 241
        //   619: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   622: ldc 178
        //   624: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   627: ldc 243
        //   629: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   632: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   635: invokevirtual 223	java/lang/String:getBytes	()[B
        //   638: invokevirtual 227	java/io/OutputStream:write	([B)V
        //   641: aload 7
        //   643: invokevirtual 246	java/io/OutputStream:flush	()V
        //   646: aload 4
        //   648: invokevirtual 249	java/net/HttpURLConnection:getResponseCode	()I
        //   651: istore_3
        //   652: ldc 97
        //   654: new 99	java/lang/StringBuilder
        //   657: dup
        //   658: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   661: ldc 251
        //   663: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   666: iload_3
        //   667: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   670: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   673: invokestatic 254	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
        //   676: pop
        //   677: iload_3
        //   678: sipush 200
        //   681: if_icmpne +199 -> 880
        //   684: new 70	java/io/BufferedReader
        //   687: dup
        //   688: new 256	java/io/InputStreamReader
        //   691: dup
        //   692: aload 4
        //   694: invokevirtual 260	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   697: invokespecial 263	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   700: invokespecial 266	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   703: astore 6
        //   705: aload 6
        //   707: invokevirtual 269	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   710: astore 11
        //   712: aload 11
        //   714: ifnull +32 -> 746
        //   717: new 99	java/lang/StringBuilder
        //   720: dup
        //   721: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   724: aload 8
        //   726: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   729: aload 11
        //   731: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   734: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   737: astore 11
        //   739: aload 11
        //   741: astore 8
        //   743: goto -38 -> 705
        //   746: ldc 97
        //   748: new 99	java/lang/StringBuilder
        //   751: dup
        //   752: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   755: ldc_w 271
        //   758: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   761: aload 8
        //   763: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   766: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   769: invokestatic 274	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   772: pop
        //   773: new 276	org/json/JSONObject
        //   776: dup
        //   777: aload 8
        //   779: invokespecial 277	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   782: astore 11
        //   784: aload 11
        //   786: ldc_w 279
        //   789: invokevirtual 283	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   792: istore_3
        //   793: iload_3
        //   794: ifne +28 -> 822
        //   797: aload 11
        //   799: ldc_w 285
        //   802: invokevirtual 289	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   805: ldc_w 291
        //   808: invokevirtual 294	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   811: astore 9
        //   813: aload 9
        //   815: astore 8
        //   817: iload_2
        //   818: istore_1
        //   819: goto +470 -> 1289
        //   822: aload 11
        //   824: ldc_w 296
        //   827: invokevirtual 294	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   830: astore 11
        //   832: ldc 97
        //   834: new 99	java/lang/StringBuilder
        //   837: dup
        //   838: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   841: ldc_w 298
        //   844: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   847: iload_3
        //   848: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   851: ldc_w 300
        //   854: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   857: aload 11
        //   859: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   862: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   865: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   868: pop
        //   869: sipush 8195
        //   872: istore_1
        //   873: aload 9
        //   875: astore 8
        //   877: goto +412 -> 1289
        //   880: ldc 97
        //   882: new 99	java/lang/StringBuilder
        //   885: dup
        //   886: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   889: ldc_w 302
        //   892: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   895: iload_3
        //   896: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   899: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   902: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   905: pop
        //   906: sipush 8195
        //   909: istore_1
        //   910: aconst_null
        //   911: astore 9
        //   913: goto +384 -> 1297
        //   916: astore 8
        //   918: aconst_null
        //   919: astore 6
        //   921: aconst_null
        //   922: astore 7
        //   924: aconst_null
        //   925: astore 4
        //   927: aconst_null
        //   928: astore 5
        //   930: ldc 97
        //   932: new 99	java/lang/StringBuilder
        //   935: dup
        //   936: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   939: ldc_w 304
        //   942: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   945: aload_0
        //   946: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   949: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   952: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   955: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   958: pop
        //   959: aload 8
        //   961: invokevirtual 305	java/io/IOException:printStackTrace	()V
        //   964: sipush 8193
        //   967: istore_1
        //   968: aload 10
        //   970: astore 8
        //   972: goto -917 -> 55
        //   975: astore 8
        //   977: ldc 56
        //   979: astore 9
        //   981: aconst_null
        //   982: astore 6
        //   984: aconst_null
        //   985: astore 7
        //   987: aconst_null
        //   988: astore 4
        //   990: aconst_null
        //   991: astore 5
        //   993: ldc 97
        //   995: new 99	java/lang/StringBuilder
        //   998: dup
        //   999: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   1002: ldc_w 307
        //   1005: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1008: aload 9
        //   1010: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1013: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1016: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   1019: pop
        //   1020: aload 8
        //   1022: invokevirtual 308	org/json/JSONException:printStackTrace	()V
        //   1025: sipush 8195
        //   1028: istore_1
        //   1029: aload 10
        //   1031: astore 8
        //   1033: goto -978 -> 55
        //   1036: astore 8
        //   1038: aconst_null
        //   1039: astore 6
        //   1041: aconst_null
        //   1042: astore 7
        //   1044: aconst_null
        //   1045: astore 4
        //   1047: aconst_null
        //   1048: astore 5
        //   1050: aload 8
        //   1052: invokevirtual 309	java/lang/Exception:printStackTrace	()V
        //   1055: aload 10
        //   1057: astore 8
        //   1059: goto -1004 -> 55
        //   1062: astore 5
        //   1064: aload 5
        //   1066: invokevirtual 305	java/io/IOException:printStackTrace	()V
        //   1069: goto -1004 -> 65
        //   1072: astore 5
        //   1074: aload 5
        //   1076: invokevirtual 305	java/io/IOException:printStackTrace	()V
        //   1079: goto -1004 -> 75
        //   1082: astore 5
        //   1084: aload 5
        //   1086: invokevirtual 305	java/io/IOException:printStackTrace	()V
        //   1089: goto -1004 -> 85
        //   1092: astore 8
        //   1094: aconst_null
        //   1095: astore 6
        //   1097: aconst_null
        //   1098: astore 7
        //   1100: aconst_null
        //   1101: astore 4
        //   1103: goto -53 -> 1050
        //   1106: astore 8
        //   1108: aconst_null
        //   1109: astore 6
        //   1111: aconst_null
        //   1112: astore 7
        //   1114: goto -64 -> 1050
        //   1117: astore 8
        //   1119: aconst_null
        //   1120: astore 6
        //   1122: goto -72 -> 1050
        //   1125: astore 8
        //   1127: goto -77 -> 1050
        //   1130: astore 8
        //   1132: ldc 56
        //   1134: astore 9
        //   1136: aconst_null
        //   1137: astore 6
        //   1139: aconst_null
        //   1140: astore 7
        //   1142: aconst_null
        //   1143: astore 4
        //   1145: goto -152 -> 993
        //   1148: astore 8
        //   1150: aconst_null
        //   1151: astore 6
        //   1153: aconst_null
        //   1154: astore 7
        //   1156: ldc 56
        //   1158: astore 9
        //   1160: goto -167 -> 993
        //   1163: astore 8
        //   1165: aconst_null
        //   1166: astore 6
        //   1168: ldc 56
        //   1170: astore 9
        //   1172: goto -179 -> 993
        //   1175: astore 11
        //   1177: aload 8
        //   1179: astore 9
        //   1181: aload 11
        //   1183: astore 8
        //   1185: goto -192 -> 993
        //   1188: astore 8
        //   1190: aconst_null
        //   1191: astore 6
        //   1193: aconst_null
        //   1194: astore 7
        //   1196: aconst_null
        //   1197: astore 4
        //   1199: goto -269 -> 930
        //   1202: astore 8
        //   1204: aconst_null
        //   1205: astore 6
        //   1207: aconst_null
        //   1208: astore 7
        //   1210: goto -280 -> 930
        //   1213: astore 8
        //   1215: aconst_null
        //   1216: astore 6
        //   1218: goto -288 -> 930
        //   1221: astore 8
        //   1223: goto -293 -> 930
        //   1226: astore 8
        //   1228: aconst_null
        //   1229: astore 6
        //   1231: aconst_null
        //   1232: astore 4
        //   1234: aconst_null
        //   1235: astore 7
        //   1237: aconst_null
        //   1238: astore 5
        //   1240: goto -668 -> 572
        //   1243: astore 8
        //   1245: aconst_null
        //   1246: astore 6
        //   1248: aconst_null
        //   1249: astore 4
        //   1251: aconst_null
        //   1252: astore 7
        //   1254: goto -682 -> 572
        //   1257: astore 8
        //   1259: aconst_null
        //   1260: astore 6
        //   1262: aload 4
        //   1264: astore 7
        //   1266: aconst_null
        //   1267: astore 4
        //   1269: goto -697 -> 572
        //   1272: astore 8
        //   1274: aload 7
        //   1276: astore 9
        //   1278: aload 4
        //   1280: astore 7
        //   1282: aload 9
        //   1284: astore 4
        //   1286: goto -714 -> 572
        //   1289: aload 6
        //   1291: astore 9
        //   1293: aload 8
        //   1295: astore 6
        //   1297: aload 6
        //   1299: astore 8
        //   1301: aload 9
        //   1303: astore 6
        //   1305: goto -1250 -> 55
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1308	0	this	2
        //   3	1026	1	i	int
        //   1	817	2	j	int
        //   144	752	3	k	int
        //   28	1257	4	localObject1	Object
        //   49	1000	5	localFileInputStream	java.io.FileInputStream
        //   1062	3	5	localIOException1	IOException
        //   1072	3	5	localIOException2	IOException
        //   1082	3	5	localIOException3	IOException
        //   1238	1	5	localObject2	Object
        //   8	1296	6	localObject3	Object
        //   43	1238	7	localObject4	Object
        //   15	861	8	localObject5	Object
        //   916	44	8	localIOException4	IOException
        //   970	1	8	localObject6	Object
        //   975	46	8	localJSONException1	org.json.JSONException
        //   1031	1	8	localObject7	Object
        //   1036	15	8	localException1	Exception
        //   1057	1	8	localObject8	Object
        //   1092	1	8	localException2	Exception
        //   1106	1	8	localException3	Exception
        //   1117	1	8	localException4	Exception
        //   1125	1	8	localException5	Exception
        //   1130	1	8	localJSONException2	org.json.JSONException
        //   1148	1	8	localJSONException3	org.json.JSONException
        //   1163	15	8	localJSONException4	org.json.JSONException
        //   1183	1	8	localObject9	Object
        //   1188	1	8	localIOException5	IOException
        //   1202	1	8	localIOException6	IOException
        //   1213	1	8	localIOException7	IOException
        //   1221	1	8	localIOException8	IOException
        //   1226	1	8	localUnknownHostException1	java.net.UnknownHostException
        //   1243	1	8	localUnknownHostException2	java.net.UnknownHostException
        //   1257	1	8	localUnknownHostException3	java.net.UnknownHostException
        //   1272	22	8	localUnknownHostException4	java.net.UnknownHostException
        //   1299	1	8	localObject10	Object
        //   5	1	9	localObject11	Object
        //   551	18	9	localUnknownHostException5	java.net.UnknownHostException
        //   811	491	9	localObject12	Object
        //   11	1045	10	localObject13	Object
        //   126	732	11	localObject14	Object
        //   1175	7	11	localJSONException5	org.json.JSONException
        //   374	43	12	localHashMap	java.util.HashMap
        // Exception table:
        //   from	to	target	type
        //   366	526	551	java/net/UnknownHostException
        //   526	534	551	java/net/UnknownHostException
        //   539	548	551	java/net/UnknownHostException
        //   608	677	551	java/net/UnknownHostException
        //   684	705	551	java/net/UnknownHostException
        //   880	906	551	java/net/UnknownHostException
        //   128	139	916	java/io/IOException
        //   128	139	975	org/json/JSONException
        //   128	139	1036	java/lang/Exception
        //   60	65	1062	java/io/IOException
        //   70	75	1072	java/io/IOException
        //   80	85	1082	java/io/IOException
        //   139	145	1092	java/lang/Exception
        //   149	157	1092	java/lang/Exception
        //   157	194	1092	java/lang/Exception
        //   214	264	1092	java/lang/Exception
        //   264	366	1106	java/lang/Exception
        //   366	526	1117	java/lang/Exception
        //   526	534	1117	java/lang/Exception
        //   539	548	1117	java/lang/Exception
        //   608	677	1117	java/lang/Exception
        //   684	705	1117	java/lang/Exception
        //   880	906	1117	java/lang/Exception
        //   705	712	1125	java/lang/Exception
        //   717	739	1125	java/lang/Exception
        //   746	793	1125	java/lang/Exception
        //   797	813	1125	java/lang/Exception
        //   822	869	1125	java/lang/Exception
        //   139	145	1130	org/json/JSONException
        //   149	157	1130	org/json/JSONException
        //   157	194	1130	org/json/JSONException
        //   214	264	1130	org/json/JSONException
        //   264	366	1148	org/json/JSONException
        //   366	526	1163	org/json/JSONException
        //   526	534	1163	org/json/JSONException
        //   539	548	1163	org/json/JSONException
        //   608	677	1163	org/json/JSONException
        //   684	705	1163	org/json/JSONException
        //   880	906	1163	org/json/JSONException
        //   705	712	1175	org/json/JSONException
        //   717	739	1175	org/json/JSONException
        //   746	793	1175	org/json/JSONException
        //   797	813	1175	org/json/JSONException
        //   822	869	1175	org/json/JSONException
        //   139	145	1188	java/io/IOException
        //   149	157	1188	java/io/IOException
        //   157	194	1188	java/io/IOException
        //   214	264	1188	java/io/IOException
        //   264	366	1202	java/io/IOException
        //   366	526	1213	java/io/IOException
        //   526	534	1213	java/io/IOException
        //   539	548	1213	java/io/IOException
        //   608	677	1213	java/io/IOException
        //   684	705	1213	java/io/IOException
        //   880	906	1213	java/io/IOException
        //   705	712	1221	java/io/IOException
        //   717	739	1221	java/io/IOException
        //   746	793	1221	java/io/IOException
        //   797	813	1221	java/io/IOException
        //   822	869	1221	java/io/IOException
        //   128	139	1226	java/net/UnknownHostException
        //   139	145	1243	java/net/UnknownHostException
        //   149	157	1243	java/net/UnknownHostException
        //   157	194	1243	java/net/UnknownHostException
        //   214	264	1243	java/net/UnknownHostException
        //   264	366	1257	java/net/UnknownHostException
        //   705	712	1272	java/net/UnknownHostException
        //   717	739	1272	java/net/UnknownHostException
        //   746	793	1272	java/net/UnknownHostException
        //   797	813	1272	java/net/UnknownHostException
        //   822	869	1272	java/net/UnknownHostException
      }
    }).start();
  }
  
  public void startUploadTimer(int paramInt)
  {
    this.IsUploading = true;
    this.mUploadTimer = new Timer();
    this.mUploadTimer.schedule(new UploadTimerTask(), paramInt * 1000);
  }
  
  public void uploadFile(final String paramString1, final String paramString2, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2, final UploadFileListener paramUploadFileListener)
  {
    if (!shouldUpload(paramString1, paramString2)) {
      return;
    }
    singleThreadPool.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          String str1 = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());
          str1 = paramString2 + "_" + str1 + "_" + UUID.randomUUID().toString() + ".jpeg";
          String str2 = paramString1 + str1;
          if (AVCosUpload.this.cacheInputImageTo(str2, paramArrayOfByte, paramInt1, paramInt2))
          {
            if (AVGestureWrapper.mReport != null) {
              AVGestureWrapper.mReport.avGestureUploadReport("0X800839B", "0");
            }
            String str3 = AVGestureWrapper.getMultiSign("1253925544", "gzdata2", "AKIDfHjBUedP6c8Sp17LoupZDoGXdgYFIsfT", "zymOoFiBSYTbeXbaUEwSlszvhItU0Qeh");
            AVCosUpload.this.uploadFileImpl(str2, paramString2, str1, "gzdata2", str3, 20971520, paramUploadFileListener);
            AVCosUpload.this.startUploadTimer(3);
          }
          return;
        }
        catch (Exception localException)
        {
          Log.e("uploadFile", localException.toString());
          paramUploadFileListener.onCompleted(8193, null, null);
        }
      }
    });
  }
  
  public static abstract interface UploadFileListener
  {
    public abstract void onCompleted(int paramInt, String paramString1, String paramString2);
  }
  
  class UploadTimerTask
    extends TimerTask
  {
    UploadTimerTask() {}
    
    public void run()
    {
      AVCosUpload.this.IsUploading = false;
      AVCosUpload.this.mUploadTimer.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.avgesture.AVCosUpload
 * JD-Core Version:    0.7.0.1
 */