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
    //   8: astore_1
    //   9: aconst_null
    //   10: astore_0
    //   11: aconst_null
    //   12: astore_2
    //   13: ldc 81
    //   15: astore_3
    //   16: new 83	java/io/BufferedReader
    //   19: dup
    //   20: new 85	java/io/FileReader
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 88	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 91	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_3
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 95	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +27 -> 67
    //   43: new 97	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   50: aload_0
    //   51: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_2
    //   62: aload_2
    //   63: astore_0
    //   64: goto -30 -> 34
    //   67: aload_1
    //   68: invokevirtual 108	java/io/BufferedReader:close	()V
    //   71: aload_1
    //   72: ifnull +69 -> 141
    //   75: aload_1
    //   76: invokevirtual 108	java/io/BufferedReader:close	()V
    //   79: aload_0
    //   80: areturn
    //   81: astore_1
    //   82: aload_0
    //   83: areturn
    //   84: astore_0
    //   85: aload_3
    //   86: astore_1
    //   87: aload_0
    //   88: astore_3
    //   89: aload_2
    //   90: astore_0
    //   91: aload_3
    //   92: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   95: aload_1
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull -19 -> 79
    //   101: aload_2
    //   102: invokevirtual 108	java/io/BufferedReader:close	()V
    //   105: aload_1
    //   106: areturn
    //   107: astore_0
    //   108: aload_1
    //   109: areturn
    //   110: astore_1
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 108	java/io/BufferedReader:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: goto -3 -> 119
    //   125: astore_2
    //   126: aload_1
    //   127: astore_0
    //   128: aload_2
    //   129: astore_1
    //   130: goto -19 -> 111
    //   133: astore_3
    //   134: aload_1
    //   135: astore_2
    //   136: aload_0
    //   137: astore_1
    //   138: goto -49 -> 89
    //   141: aload_0
    //   142: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   8	68	1	localObject1	Object
    //   81	1	1	localIOException1	IOException
    //   86	23	1	localObject2	Object
    //   110	17	1	localObject3	Object
    //   129	9	1	localObject4	Object
    //   12	90	2	str1	String
    //   125	4	2	localObject5	Object
    //   135	1	2	localObject6	Object
    //   15	77	3	str2	String
    //   133	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   75	79	81	java/io/IOException
    //   16	32	84	java/io/IOException
    //   101	105	107	java/io/IOException
    //   16	32	110	finally
    //   91	95	110	finally
    //   115	119	121	java/io/IOException
    //   34	39	125	finally
    //   43	62	125	finally
    //   67	71	125	finally
    //   34	39	133	java/io/IOException
    //   43	62	133	java/io/IOException
    //   67	71	133	java/io/IOException
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
    String str = "";
    Object localObject = str;
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      for (paramMap = str;; paramMap = paramMap + (String)((Map.Entry)localObject).getValue() + "\r\n")
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
    return localObject;
  }
  
  private File openFile(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("AVCosUpload", "checkFile| filePath == null.");
      localObject = null;
    }
    File localFile;
    do
    {
      return localObject;
      localFile = new File(paramString);
      localObject = localFile;
    } while (localFile.exists());
    Log.e("AVCosUpload", "checkFile| filePath is not exist. path=" + paramString);
    return null;
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
    for (;;)
    {
      return false;
      localObject = ReadFile(paramString1);
      if (!((String)localObject).equals("")) {
        try
        {
          localObject = new JSONObject((String)localObject);
          int i = 1;
          if (((JSONObject)localObject).has(paramString2)) {
            i = ((JSONObject)localObject).getInt(paramString2) + 1;
          }
          if (i < 5)
          {
            ((JSONObject)localObject).put(paramString2, i);
            WriteFile(paramString1, ((JSONObject)localObject).toString());
            return true;
          }
        }
        catch (Exception paramString1) {}
      }
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
        //   0: aconst_null
        //   1: astore 7
        //   3: aconst_null
        //   4: astore 31
        //   6: aconst_null
        //   7: astore 26
        //   9: aconst_null
        //   10: astore 32
        //   12: aconst_null
        //   13: astore 4
        //   15: aconst_null
        //   16: astore 8
        //   18: aconst_null
        //   19: astore 9
        //   21: aconst_null
        //   22: astore 10
        //   24: aconst_null
        //   25: astore 25
        //   27: aconst_null
        //   28: astore 27
        //   30: aconst_null
        //   31: astore 28
        //   33: aconst_null
        //   34: astore 29
        //   36: aconst_null
        //   37: astore 30
        //   39: aconst_null
        //   40: astore 5
        //   42: aconst_null
        //   43: astore 21
        //   45: aconst_null
        //   46: astore 19
        //   48: aconst_null
        //   49: astore 18
        //   51: aconst_null
        //   52: astore 20
        //   54: aconst_null
        //   55: astore 6
        //   57: aconst_null
        //   58: astore 14
        //   60: aconst_null
        //   61: astore 15
        //   63: aconst_null
        //   64: astore 13
        //   66: aconst_null
        //   67: astore 16
        //   69: aconst_null
        //   70: astore 22
        //   72: aconst_null
        //   73: astore 24
        //   75: iconst_0
        //   76: istore_2
        //   77: iconst_0
        //   78: istore_1
        //   79: aconst_null
        //   80: astore 17
        //   82: aconst_null
        //   83: astore 23
        //   85: aconst_null
        //   86: astore 12
        //   88: ldc 56
        //   90: astore 11
        //   92: aload_0
        //   93: getfield 27	com/tencent/av/avgesture/AVCosUpload$2:this$0	Lcom/tencent/av/avgesture/AVCosUpload;
        //   96: aload_0
        //   97: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   100: invokestatic 60	com/tencent/av/avgesture/AVCosUpload:access$300	(Lcom/tencent/av/avgesture/AVCosUpload;Ljava/lang/String;)Ljava/io/File;
        //   103: astore 34
        //   105: aload 34
        //   107: ifnonnull +79 -> 186
        //   110: sipush 8193
        //   113: istore_1
        //   114: aload 24
        //   116: astore 7
        //   118: aload 12
        //   120: astore 9
        //   122: aload 4
        //   124: ifnull +8 -> 132
        //   127: aload 4
        //   129: invokevirtual 65	java/io/FileInputStream:close	()V
        //   132: aload 6
        //   134: ifnull +8 -> 142
        //   137: aload 6
        //   139: invokevirtual 68	java/io/OutputStream:close	()V
        //   142: aload 7
        //   144: ifnull +8 -> 152
        //   147: aload 7
        //   149: invokevirtual 71	java/io/BufferedReader:close	()V
        //   152: aload 5
        //   154: ifnull +8 -> 162
        //   157: aload 5
        //   159: invokevirtual 76	java/net/HttpURLConnection:disconnect	()V
        //   162: aload_0
        //   163: getfield 41	com/tencent/av/avgesture/AVCosUpload$2:val$monitor	Lcom/tencent/av/avgesture/AVCosUpload$UploadFileListener;
        //   166: ifnull +19 -> 185
        //   169: aload_0
        //   170: getfield 41	com/tencent/av/avgesture/AVCosUpload$2:val$monitor	Lcom/tencent/av/avgesture/AVCosUpload$UploadFileListener;
        //   173: iload_1
        //   174: aload_0
        //   175: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   178: aload 9
        //   180: invokeinterface 82 4 0
        //   185: return
        //   186: aload_0
        //   187: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   190: invokestatic 88	com/tencent/av/avgesture/SHA1Utils:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
        //   193: astore 33
        //   195: new 62	java/io/FileInputStream
        //   198: dup
        //   199: aload 34
        //   201: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   204: astore 4
        //   206: aload 27
        //   208: astore 7
        //   210: aload 28
        //   212: astore 8
        //   214: aload 29
        //   216: astore 9
        //   218: aload 30
        //   220: astore 10
        //   222: aload 4
        //   224: invokevirtual 95	java/io/FileInputStream:available	()I
        //   227: istore_3
        //   228: iload_3
        //   229: ifle +27 -> 256
        //   232: aload 27
        //   234: astore 7
        //   236: aload 28
        //   238: astore 8
        //   240: aload 29
        //   242: astore 9
        //   244: aload 30
        //   246: astore 10
        //   248: iload_3
        //   249: aload_0
        //   250: getfield 31	com/tencent/av/avgesture/AVCosUpload$2:val$maxSize	I
        //   253: if_icmple +71 -> 324
        //   256: aload 27
        //   258: astore 7
        //   260: aload 28
        //   262: astore 8
        //   264: aload 29
        //   266: astore 9
        //   268: aload 30
        //   270: astore 10
        //   272: ldc 97
        //   274: new 99	java/lang/StringBuilder
        //   277: dup
        //   278: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   281: ldc 102
        //   283: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   286: aload_0
        //   287: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   290: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   293: ldc 108
        //   295: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   298: iload_3
        //   299: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   302: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   305: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   308: pop
        //   309: sipush 8193
        //   312: istore_1
        //   313: aload 12
        //   315: astore 9
        //   317: aload 24
        //   319: astore 7
        //   321: goto -199 -> 122
        //   324: aload 27
        //   326: astore 7
        //   328: aload 28
        //   330: astore 8
        //   332: aload 29
        //   334: astore 9
        //   336: aload 30
        //   338: astore 10
        //   340: new 123	java/net/URL
        //   343: dup
        //   344: ldc 125
        //   346: iconst_4
        //   347: anewarray 4	java/lang/Object
        //   350: dup
        //   351: iconst_0
        //   352: ldc 127
        //   354: aastore
        //   355: dup
        //   356: iconst_1
        //   357: aload_0
        //   358: getfield 33	com/tencent/av/avgesture/AVCosUpload$2:val$bucket	Ljava/lang/String;
        //   361: aastore
        //   362: dup
        //   363: iconst_2
        //   364: aload_0
        //   365: getfield 35	com/tencent/av/avgesture/AVCosUpload$2:val$type	Ljava/lang/String;
        //   368: aastore
        //   369: dup
        //   370: iconst_3
        //   371: aload_0
        //   372: getfield 37	com/tencent/av/avgesture/AVCosUpload$2:val$cosName	Ljava/lang/String;
        //   375: aastore
        //   376: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   379: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;)V
        //   382: invokevirtual 140	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   385: checkcast 73	java/net/HttpURLConnection
        //   388: astore 5
        //   390: aload 5
        //   392: astore 7
        //   394: aload 5
        //   396: astore 8
        //   398: aload 5
        //   400: astore 9
        //   402: aload 5
        //   404: astore 10
        //   406: aload 5
        //   408: sipush 5000
        //   411: invokevirtual 144	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   414: aload 5
        //   416: astore 7
        //   418: aload 5
        //   420: astore 8
        //   422: aload 5
        //   424: astore 9
        //   426: aload 5
        //   428: astore 10
        //   430: aload 5
        //   432: sipush 30000
        //   435: invokevirtual 147	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   438: aload 5
        //   440: astore 7
        //   442: aload 5
        //   444: astore 8
        //   446: aload 5
        //   448: astore 9
        //   450: aload 5
        //   452: astore 10
        //   454: aload 5
        //   456: iconst_1
        //   457: invokevirtual 151	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   460: aload 5
        //   462: astore 7
        //   464: aload 5
        //   466: astore 8
        //   468: aload 5
        //   470: astore 9
        //   472: aload 5
        //   474: astore 10
        //   476: aload 5
        //   478: iconst_1
        //   479: invokevirtual 154	java/net/HttpURLConnection:setDoInput	(Z)V
        //   482: aload 5
        //   484: astore 7
        //   486: aload 5
        //   488: astore 8
        //   490: aload 5
        //   492: astore 9
        //   494: aload 5
        //   496: astore 10
        //   498: aload 5
        //   500: iconst_0
        //   501: invokevirtual 157	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   504: aload 5
        //   506: astore 7
        //   508: aload 5
        //   510: astore 8
        //   512: aload 5
        //   514: astore 9
        //   516: aload 5
        //   518: astore 10
        //   520: aload 5
        //   522: ldc 159
        //   524: invokevirtual 162	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   527: aload 5
        //   529: astore 7
        //   531: aload 5
        //   533: astore 8
        //   535: aload 5
        //   537: astore 9
        //   539: aload 5
        //   541: astore 10
        //   543: aload 5
        //   545: ldc 164
        //   547: ldc 166
        //   549: invokevirtual 170	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   552: aload 5
        //   554: astore 7
        //   556: aload 5
        //   558: astore 8
        //   560: aload 5
        //   562: astore 9
        //   564: aload 5
        //   566: astore 10
        //   568: aload 5
        //   570: ldc 172
        //   572: aload_0
        //   573: getfield 39	com/tencent/av/avgesture/AVCosUpload$2:val$sign	Ljava/lang/String;
        //   576: invokevirtual 170	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   579: aload 5
        //   581: astore 7
        //   583: aload 5
        //   585: astore 8
        //   587: aload 5
        //   589: astore 9
        //   591: aload 5
        //   593: astore 10
        //   595: aload 5
        //   597: ldc 174
        //   599: new 99	java/lang/StringBuilder
        //   602: dup
        //   603: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   606: ldc 176
        //   608: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   611: ldc 178
        //   613: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   616: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   619: invokevirtual 170	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   622: aload 5
        //   624: astore 7
        //   626: aload 5
        //   628: astore 8
        //   630: aload 5
        //   632: astore 9
        //   634: aload 5
        //   636: astore 10
        //   638: new 180	java/io/DataOutputStream
        //   641: dup
        //   642: aload 5
        //   644: invokevirtual 184	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   647: invokespecial 187	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   650: astore 6
        //   652: new 189	java/util/HashMap
        //   655: dup
        //   656: iconst_3
        //   657: invokespecial 191	java/util/HashMap:<init>	(I)V
        //   660: astore 7
        //   662: aload 7
        //   664: ldc 193
        //   666: ldc 195
        //   668: invokeinterface 201 3 0
        //   673: pop
        //   674: aload 7
        //   676: ldc 203
        //   678: aload 33
        //   680: invokeinterface 201 3 0
        //   685: pop
        //   686: aload 7
        //   688: ldc 205
        //   690: ldc 56
        //   692: invokeinterface 201 3 0
        //   697: pop
        //   698: aload_0
        //   699: getfield 27	com/tencent/av/avgesture/AVCosUpload$2:this$0	Lcom/tencent/av/avgesture/AVCosUpload;
        //   702: aload 7
        //   704: ldc 178
        //   706: invokestatic 209	com/tencent/av/avgesture/AVCosUpload:access$400	(Lcom/tencent/av/avgesture/AVCosUpload;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
        //   709: astore 7
        //   711: new 99	java/lang/StringBuilder
        //   714: dup
        //   715: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   718: aload 7
        //   720: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   723: ldc 211
        //   725: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   728: ldc 178
        //   730: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   733: ldc 213
        //   735: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   738: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   741: astore 7
        //   743: new 99	java/lang/StringBuilder
        //   746: dup
        //   747: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   750: aload 7
        //   752: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   755: ldc 215
        //   757: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   760: aload_0
        //   761: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   764: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   767: ldc 217
        //   769: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   772: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   775: astore 7
        //   777: aload 6
        //   779: new 99	java/lang/StringBuilder
        //   782: dup
        //   783: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   786: aload 7
        //   788: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   791: ldc 219
        //   793: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   796: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   799: invokevirtual 223	java/lang/String:getBytes	()[B
        //   802: invokevirtual 227	java/io/OutputStream:write	([B)V
        //   805: sipush 1024
        //   808: newarray byte
        //   810: astore 7
        //   812: aload 4
        //   814: aload 7
        //   816: invokevirtual 231	java/io/FileInputStream:read	([B)I
        //   819: istore_3
        //   820: iload_3
        //   821: iconst_m1
        //   822: if_icmpeq +61 -> 883
        //   825: aload 6
        //   827: aload 7
        //   829: iconst_0
        //   830: iload_3
        //   831: invokevirtual 234	java/io/OutputStream:write	([BII)V
        //   834: goto -22 -> 812
        //   837: astore 9
        //   839: aload 14
        //   841: astore 8
        //   843: aload 6
        //   845: astore 7
        //   847: aload 9
        //   849: astore 6
        //   851: ldc 97
        //   853: ldc 236
        //   855: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   858: pop
        //   859: sipush 8195
        //   862: istore_1
        //   863: aload 6
        //   865: invokevirtual 239	java/net/UnknownHostException:printStackTrace	()V
        //   868: aload 12
        //   870: astore 9
        //   872: aload 7
        //   874: astore 6
        //   876: aload 8
        //   878: astore 7
        //   880: goto -758 -> 122
        //   883: aload 6
        //   885: new 99	java/lang/StringBuilder
        //   888: dup
        //   889: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   892: ldc 241
        //   894: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   897: ldc 178
        //   899: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   902: ldc 243
        //   904: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   907: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   910: invokevirtual 223	java/lang/String:getBytes	()[B
        //   913: invokevirtual 227	java/io/OutputStream:write	([B)V
        //   916: aload 6
        //   918: invokevirtual 246	java/io/OutputStream:flush	()V
        //   921: aload 5
        //   923: invokevirtual 249	java/net/HttpURLConnection:getResponseCode	()I
        //   926: istore_3
        //   927: ldc 97
        //   929: new 99	java/lang/StringBuilder
        //   932: dup
        //   933: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   936: ldc 251
        //   938: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   941: iload_3
        //   942: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   945: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   948: invokestatic 254	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
        //   951: pop
        //   952: iload_3
        //   953: sipush 200
        //   956: if_icmpne +199 -> 1155
        //   959: new 70	java/io/BufferedReader
        //   962: dup
        //   963: new 256	java/io/InputStreamReader
        //   966: dup
        //   967: aload 5
        //   969: invokevirtual 260	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   972: invokespecial 263	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   975: invokespecial 266	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   978: astore 7
        //   980: aload 11
        //   982: astore 8
        //   984: aload 8
        //   986: astore 9
        //   988: aload 7
        //   990: invokevirtual 269	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   993: astore 8
        //   995: aload 8
        //   997: ifnull +28 -> 1025
        //   1000: new 99	java/lang/StringBuilder
        //   1003: dup
        //   1004: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   1007: aload 9
        //   1009: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1012: aload 8
        //   1014: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1017: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1020: astore 8
        //   1022: goto -38 -> 984
        //   1025: ldc 97
        //   1027: new 99	java/lang/StringBuilder
        //   1030: dup
        //   1031: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   1034: ldc_w 271
        //   1037: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1040: aload 9
        //   1042: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1045: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1048: invokestatic 274	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   1051: pop
        //   1052: new 276	org/json/JSONObject
        //   1055: dup
        //   1056: aload 9
        //   1058: invokespecial 277	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   1061: astore 8
        //   1063: aload 8
        //   1065: ldc_w 279
        //   1068: invokevirtual 283	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   1071: istore_3
        //   1072: iload_3
        //   1073: ifne +24 -> 1097
        //   1076: aload 8
        //   1078: ldc_w 285
        //   1081: invokevirtual 289	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   1084: ldc_w 291
        //   1087: invokevirtual 294	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   1090: astore 8
        //   1092: iload_2
        //   1093: istore_1
        //   1094: goto +530 -> 1624
        //   1097: aload 8
        //   1099: ldc_w 296
        //   1102: invokevirtual 294	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   1105: astore 8
        //   1107: ldc 97
        //   1109: new 99	java/lang/StringBuilder
        //   1112: dup
        //   1113: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   1116: ldc_w 298
        //   1119: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1122: iload_3
        //   1123: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1126: ldc_w 300
        //   1129: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1132: aload 8
        //   1134: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1137: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1140: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   1143: pop
        //   1144: sipush 8195
        //   1147: istore_1
        //   1148: aload 17
        //   1150: astore 8
        //   1152: goto +472 -> 1624
        //   1155: ldc 97
        //   1157: new 99	java/lang/StringBuilder
        //   1160: dup
        //   1161: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   1164: ldc_w 302
        //   1167: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1170: iload_3
        //   1171: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1174: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1177: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   1180: pop
        //   1181: sipush 8195
        //   1184: istore_1
        //   1185: aload 23
        //   1187: astore 8
        //   1189: aload 22
        //   1191: astore 7
        //   1193: goto +431 -> 1624
        //   1196: astore 6
        //   1198: aload 15
        //   1200: astore 8
        //   1202: aload 19
        //   1204: astore 7
        //   1206: aload 31
        //   1208: astore 4
        //   1210: aload 9
        //   1212: astore 5
        //   1214: ldc 97
        //   1216: new 99	java/lang/StringBuilder
        //   1219: dup
        //   1220: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   1223: ldc_w 304
        //   1226: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1229: aload_0
        //   1230: getfield 29	com/tencent/av/avgesture/AVCosUpload$2:val$srcPath	Ljava/lang/String;
        //   1233: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1236: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1239: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   1242: pop
        //   1243: sipush 8193
        //   1246: istore_1
        //   1247: aload 6
        //   1249: invokevirtual 305	java/io/IOException:printStackTrace	()V
        //   1252: aload 12
        //   1254: astore 9
        //   1256: aload 7
        //   1258: astore 6
        //   1260: aload 8
        //   1262: astore 7
        //   1264: goto -1142 -> 122
        //   1267: astore 6
        //   1269: aload 11
        //   1271: astore 9
        //   1273: aload 13
        //   1275: astore 8
        //   1277: aload 18
        //   1279: astore 7
        //   1281: aload 26
        //   1283: astore 4
        //   1285: aload 10
        //   1287: astore 5
        //   1289: ldc 97
        //   1291: new 99	java/lang/StringBuilder
        //   1294: dup
        //   1295: invokespecial 100	java/lang/StringBuilder:<init>	()V
        //   1298: ldc_w 307
        //   1301: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1304: aload 9
        //   1306: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1309: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1312: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   1315: pop
        //   1316: sipush 8195
        //   1319: istore_1
        //   1320: aload 6
        //   1322: invokevirtual 308	org/json/JSONException:printStackTrace	()V
        //   1325: aload 12
        //   1327: astore 9
        //   1329: aload 7
        //   1331: astore 6
        //   1333: aload 8
        //   1335: astore 7
        //   1337: goto -1215 -> 122
        //   1340: astore 6
        //   1342: aload 16
        //   1344: astore 8
        //   1346: aload 20
        //   1348: astore 7
        //   1350: aload 32
        //   1352: astore 4
        //   1354: aload 25
        //   1356: astore 5
        //   1358: aload 6
        //   1360: invokevirtual 309	java/lang/Exception:printStackTrace	()V
        //   1363: aload 12
        //   1365: astore 9
        //   1367: aload 7
        //   1369: astore 6
        //   1371: aload 8
        //   1373: astore 7
        //   1375: goto -1253 -> 122
        //   1378: astore 4
        //   1380: aload 4
        //   1382: invokevirtual 305	java/io/IOException:printStackTrace	()V
        //   1385: goto -1253 -> 132
        //   1388: astore 4
        //   1390: aload 4
        //   1392: invokevirtual 305	java/io/IOException:printStackTrace	()V
        //   1395: goto -1253 -> 142
        //   1398: astore 4
        //   1400: aload 4
        //   1402: invokevirtual 305	java/io/IOException:printStackTrace	()V
        //   1405: goto -1253 -> 152
        //   1408: astore 6
        //   1410: aload 7
        //   1412: astore 5
        //   1414: aload 20
        //   1416: astore 7
        //   1418: aload 16
        //   1420: astore 8
        //   1422: goto -64 -> 1358
        //   1425: astore 8
        //   1427: aload 6
        //   1429: astore 7
        //   1431: aload 8
        //   1433: astore 6
        //   1435: aload 16
        //   1437: astore 8
        //   1439: goto -81 -> 1358
        //   1442: astore 9
        //   1444: aload 7
        //   1446: astore 8
        //   1448: aload 6
        //   1450: astore 7
        //   1452: aload 9
        //   1454: astore 6
        //   1456: goto -98 -> 1358
        //   1459: astore 6
        //   1461: aload 8
        //   1463: astore 5
        //   1465: aload 18
        //   1467: astore 7
        //   1469: aload 13
        //   1471: astore 8
        //   1473: aload 11
        //   1475: astore 9
        //   1477: goto -188 -> 1289
        //   1480: astore 8
        //   1482: aload 6
        //   1484: astore 7
        //   1486: aload 8
        //   1488: astore 6
        //   1490: aload 13
        //   1492: astore 8
        //   1494: aload 11
        //   1496: astore 9
        //   1498: goto -209 -> 1289
        //   1501: astore 10
        //   1503: aload 7
        //   1505: astore 8
        //   1507: aload 6
        //   1509: astore 7
        //   1511: aload 10
        //   1513: astore 6
        //   1515: goto -226 -> 1289
        //   1518: astore 6
        //   1520: aload 9
        //   1522: astore 5
        //   1524: aload 19
        //   1526: astore 7
        //   1528: aload 15
        //   1530: astore 8
        //   1532: goto -318 -> 1214
        //   1535: astore 8
        //   1537: aload 6
        //   1539: astore 7
        //   1541: aload 8
        //   1543: astore 6
        //   1545: aload 15
        //   1547: astore 8
        //   1549: goto -335 -> 1214
        //   1552: astore 9
        //   1554: aload 7
        //   1556: astore 8
        //   1558: aload 6
        //   1560: astore 7
        //   1562: aload 9
        //   1564: astore 6
        //   1566: goto -352 -> 1214
        //   1569: astore 6
        //   1571: aload 8
        //   1573: astore 5
        //   1575: aload 7
        //   1577: astore 4
        //   1579: aload 21
        //   1581: astore 7
        //   1583: aload 14
        //   1585: astore 8
        //   1587: goto -736 -> 851
        //   1590: astore 6
        //   1592: aload 10
        //   1594: astore 5
        //   1596: aload 21
        //   1598: astore 7
        //   1600: aload 14
        //   1602: astore 8
        //   1604: goto -753 -> 851
        //   1607: astore 9
        //   1609: aload 7
        //   1611: astore 8
        //   1613: aload 6
        //   1615: astore 7
        //   1617: aload 9
        //   1619: astore 6
        //   1621: goto -770 -> 851
        //   1624: aload 8
        //   1626: astore 9
        //   1628: goto -1506 -> 122
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1631	0	this	2
        //   78	1242	1	i	int
        //   76	1017	2	j	int
        //   227	944	3	k	int
        //   13	1340	4	localObject1	Object
        //   1378	3	4	localIOException1	IOException
        //   1388	3	4	localIOException2	IOException
        //   1398	3	4	localIOException3	IOException
        //   1577	1	4	localObject2	Object
        //   40	1555	5	localObject3	Object
        //   55	862	6	localObject4	Object
        //   1196	52	6	localIOException4	IOException
        //   1258	1	6	localObject5	Object
        //   1267	54	6	localJSONException1	org.json.JSONException
        //   1331	1	6	localObject6	Object
        //   1340	19	6	localException1	Exception
        //   1369	1	6	localObject7	Object
        //   1408	20	6	localException2	Exception
        //   1433	22	6	localException3	Exception
        //   1459	24	6	localJSONException2	org.json.JSONException
        //   1488	26	6	localJSONException3	org.json.JSONException
        //   1518	20	6	localIOException5	IOException
        //   1543	22	6	localIOException6	IOException
        //   1569	1	6	localUnknownHostException1	java.net.UnknownHostException
        //   1590	24	6	localUnknownHostException2	java.net.UnknownHostException
        //   1619	1	6	localUnknownHostException3	java.net.UnknownHostException
        //   1	1615	7	localObject8	Object
        //   16	1405	8	localObject9	Object
        //   1425	7	8	localException4	Exception
        //   1437	35	8	localObject10	Object
        //   1480	7	8	localJSONException4	org.json.JSONException
        //   1492	39	8	localObject11	Object
        //   1535	7	8	localIOException7	IOException
        //   1547	78	8	localObject12	Object
        //   19	614	9	localObject13	Object
        //   837	11	9	localUnknownHostException4	java.net.UnknownHostException
        //   870	496	9	localObject14	Object
        //   1442	11	9	localException5	Exception
        //   1475	46	9	localObject15	Object
        //   1552	11	9	localIOException8	IOException
        //   1607	11	9	localUnknownHostException5	java.net.UnknownHostException
        //   1626	1	9	localObject16	Object
        //   22	1264	10	localObject17	Object
        //   1501	92	10	localJSONException5	org.json.JSONException
        //   90	1405	11	str1	String
        //   86	1278	12	localObject18	Object
        //   64	1427	13	localObject19	Object
        //   58	1543	14	localObject20	Object
        //   61	1485	15	localObject21	Object
        //   67	1369	16	localObject22	Object
        //   80	1069	17	localObject23	Object
        //   49	1417	18	localObject24	Object
        //   46	1479	19	localObject25	Object
        //   52	1363	20	localObject26	Object
        //   43	1554	21	localObject27	Object
        //   70	1120	22	localObject28	Object
        //   83	1103	23	localObject29	Object
        //   73	245	24	localObject30	Object
        //   25	1330	25	localObject31	Object
        //   7	1275	26	localObject32	Object
        //   28	297	27	localObject33	Object
        //   31	298	28	localObject34	Object
        //   34	299	29	localObject35	Object
        //   37	300	30	localObject36	Object
        //   4	1203	31	localObject37	Object
        //   10	1341	32	localObject38	Object
        //   193	486	33	str2	String
        //   103	97	34	localFile	File
        // Exception table:
        //   from	to	target	type
        //   652	812	837	java/net/UnknownHostException
        //   812	820	837	java/net/UnknownHostException
        //   825	834	837	java/net/UnknownHostException
        //   883	952	837	java/net/UnknownHostException
        //   959	980	837	java/net/UnknownHostException
        //   1155	1181	837	java/net/UnknownHostException
        //   195	206	1196	java/io/IOException
        //   195	206	1267	org/json/JSONException
        //   195	206	1340	java/lang/Exception
        //   127	132	1378	java/io/IOException
        //   137	142	1388	java/io/IOException
        //   147	152	1398	java/io/IOException
        //   222	228	1408	java/lang/Exception
        //   248	256	1408	java/lang/Exception
        //   272	309	1408	java/lang/Exception
        //   340	390	1408	java/lang/Exception
        //   406	414	1408	java/lang/Exception
        //   430	438	1408	java/lang/Exception
        //   454	460	1408	java/lang/Exception
        //   476	482	1408	java/lang/Exception
        //   498	504	1408	java/lang/Exception
        //   520	527	1408	java/lang/Exception
        //   543	552	1408	java/lang/Exception
        //   568	579	1408	java/lang/Exception
        //   595	622	1408	java/lang/Exception
        //   638	652	1408	java/lang/Exception
        //   652	812	1425	java/lang/Exception
        //   812	820	1425	java/lang/Exception
        //   825	834	1425	java/lang/Exception
        //   883	952	1425	java/lang/Exception
        //   959	980	1425	java/lang/Exception
        //   1155	1181	1425	java/lang/Exception
        //   988	995	1442	java/lang/Exception
        //   1000	1022	1442	java/lang/Exception
        //   1025	1072	1442	java/lang/Exception
        //   1076	1092	1442	java/lang/Exception
        //   1097	1144	1442	java/lang/Exception
        //   222	228	1459	org/json/JSONException
        //   248	256	1459	org/json/JSONException
        //   272	309	1459	org/json/JSONException
        //   340	390	1459	org/json/JSONException
        //   406	414	1459	org/json/JSONException
        //   430	438	1459	org/json/JSONException
        //   454	460	1459	org/json/JSONException
        //   476	482	1459	org/json/JSONException
        //   498	504	1459	org/json/JSONException
        //   520	527	1459	org/json/JSONException
        //   543	552	1459	org/json/JSONException
        //   568	579	1459	org/json/JSONException
        //   595	622	1459	org/json/JSONException
        //   638	652	1459	org/json/JSONException
        //   652	812	1480	org/json/JSONException
        //   812	820	1480	org/json/JSONException
        //   825	834	1480	org/json/JSONException
        //   883	952	1480	org/json/JSONException
        //   959	980	1480	org/json/JSONException
        //   1155	1181	1480	org/json/JSONException
        //   988	995	1501	org/json/JSONException
        //   1000	1022	1501	org/json/JSONException
        //   1025	1072	1501	org/json/JSONException
        //   1076	1092	1501	org/json/JSONException
        //   1097	1144	1501	org/json/JSONException
        //   222	228	1518	java/io/IOException
        //   248	256	1518	java/io/IOException
        //   272	309	1518	java/io/IOException
        //   340	390	1518	java/io/IOException
        //   406	414	1518	java/io/IOException
        //   430	438	1518	java/io/IOException
        //   454	460	1518	java/io/IOException
        //   476	482	1518	java/io/IOException
        //   498	504	1518	java/io/IOException
        //   520	527	1518	java/io/IOException
        //   543	552	1518	java/io/IOException
        //   568	579	1518	java/io/IOException
        //   595	622	1518	java/io/IOException
        //   638	652	1518	java/io/IOException
        //   652	812	1535	java/io/IOException
        //   812	820	1535	java/io/IOException
        //   825	834	1535	java/io/IOException
        //   883	952	1535	java/io/IOException
        //   959	980	1535	java/io/IOException
        //   1155	1181	1535	java/io/IOException
        //   988	995	1552	java/io/IOException
        //   1000	1022	1552	java/io/IOException
        //   1025	1072	1552	java/io/IOException
        //   1076	1092	1552	java/io/IOException
        //   1097	1144	1552	java/io/IOException
        //   195	206	1569	java/net/UnknownHostException
        //   222	228	1590	java/net/UnknownHostException
        //   248	256	1590	java/net/UnknownHostException
        //   272	309	1590	java/net/UnknownHostException
        //   340	390	1590	java/net/UnknownHostException
        //   406	414	1590	java/net/UnknownHostException
        //   430	438	1590	java/net/UnknownHostException
        //   454	460	1590	java/net/UnknownHostException
        //   476	482	1590	java/net/UnknownHostException
        //   498	504	1590	java/net/UnknownHostException
        //   520	527	1590	java/net/UnknownHostException
        //   543	552	1590	java/net/UnknownHostException
        //   568	579	1590	java/net/UnknownHostException
        //   595	622	1590	java/net/UnknownHostException
        //   638	652	1590	java/net/UnknownHostException
        //   988	995	1607	java/net/UnknownHostException
        //   1000	1022	1607	java/net/UnknownHostException
        //   1025	1072	1607	java/net/UnknownHostException
        //   1076	1092	1607	java/net/UnknownHostException
        //   1097	1144	1607	java/net/UnknownHostException
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