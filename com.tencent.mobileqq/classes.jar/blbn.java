import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TargetApi(18)
public class blbn
{
  private int jdField_a_of_type_Int;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private blbq jdField_a_of_type_Blbq = new blbq(null);
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor;
  private String jdField_b_of_type_JavaLangString;
  
  public blbn(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private int a()
  {
    int i = 0;
    this.jdField_a_of_type_Blbq.jdField_a_of_type_JavaNioByteBuffer.position(0);
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Blbq.jdField_a_of_type_JavaNioByteBuffer, 0) <= 0)
    {
      a();
      i = -5;
    }
    do
    {
      return i;
      this.jdField_a_of_type_Blbq.jdField_a_of_type_JavaNioByteBuffer.position(0);
    } while (this.jdField_b_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Blbq.jdField_a_of_type_JavaNioByteBuffer, 0) > 0);
    a();
    return -6;
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 65	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   3: invokestatic 70	blbm:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 4
    //   8: new 72	java/io/File
    //   11: dup
    //   12: aload 4
    //   14: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 79	java/io/File:exists	()Z
    //   24: ifeq +439 -> 463
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 83	java/io/File:setExecutable	(ZZ)Z
    //   34: istore_3
    //   35: new 85	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   42: ldc 88
    //   44: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aconst_null
    //   55: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: new 104	java/util/ArrayList
    //   61: dup
    //   62: invokespecial 105	java/util/ArrayList:<init>	()V
    //   65: astore 5
    //   67: aload 5
    //   69: aload 4
    //   71: invokeinterface 111 2 0
    //   76: pop
    //   77: aload 5
    //   79: ldc 113
    //   81: invokeinterface 111 2 0
    //   86: pop
    //   87: aload 5
    //   89: ldc 115
    //   91: invokeinterface 111 2 0
    //   96: pop
    //   97: aload 5
    //   99: ldc 117
    //   101: invokeinterface 111 2 0
    //   106: pop
    //   107: aload 5
    //   109: ldc 119
    //   111: invokeinterface 111 2 0
    //   116: pop
    //   117: aload 5
    //   119: ldc 121
    //   121: invokeinterface 111 2 0
    //   126: pop
    //   127: aload 5
    //   129: aload_0
    //   130: invokeinterface 111 2 0
    //   135: pop
    //   136: aload 5
    //   138: ldc 123
    //   140: invokeinterface 111 2 0
    //   145: pop
    //   146: aload 5
    //   148: ldc 125
    //   150: invokeinterface 111 2 0
    //   155: pop
    //   156: aload 5
    //   158: ldc 127
    //   160: invokeinterface 111 2 0
    //   165: pop
    //   166: aload 5
    //   168: ldc 129
    //   170: invokeinterface 111 2 0
    //   175: pop
    //   176: aload 5
    //   178: ldc 131
    //   180: invokeinterface 111 2 0
    //   185: pop
    //   186: aload 5
    //   188: invokestatic 136	axkr:d	()I
    //   191: invokestatic 142	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: invokeinterface 111 2 0
    //   199: pop
    //   200: aload 5
    //   202: ldc 144
    //   204: invokeinterface 111 2 0
    //   209: pop
    //   210: aload 5
    //   212: ldc 146
    //   214: invokeinterface 111 2 0
    //   219: pop
    //   220: aload 5
    //   222: ldc 148
    //   224: invokeinterface 111 2 0
    //   229: pop
    //   230: aload 5
    //   232: ldc 150
    //   234: invokeinterface 111 2 0
    //   239: pop
    //   240: aload 5
    //   242: aload_1
    //   243: invokeinterface 111 2 0
    //   248: pop
    //   249: aload 5
    //   251: invokestatic 65	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   254: invokestatic 152	blbm:b	(Landroid/content/Context;)Ljava/lang/String;
    //   257: invokeinterface 111 2 0
    //   262: pop
    //   263: new 154	java/lang/ProcessBuilder
    //   266: dup
    //   267: iconst_0
    //   268: anewarray 138	java/lang/String
    //   271: invokespecial 157	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   274: astore_0
    //   275: aload_0
    //   276: iconst_1
    //   277: invokevirtual 161	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   280: pop
    //   281: aload_0
    //   282: aload 5
    //   284: invokevirtual 165	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   287: pop
    //   288: aload_0
    //   289: invokevirtual 169	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   292: astore_0
    //   293: new 85	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   300: astore 4
    //   302: new 171	java/io/BufferedReader
    //   305: dup
    //   306: new 173	java/io/InputStreamReader
    //   309: dup
    //   310: aload_0
    //   311: invokevirtual 179	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   314: invokespecial 182	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   317: invokespecial 185	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   320: astore 5
    //   322: aload 5
    //   324: invokevirtual 188	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   327: astore 6
    //   329: aload 6
    //   331: ifnull +32 -> 363
    //   334: aload 4
    //   336: aload 6
    //   338: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: goto -20 -> 322
    //   345: astore 5
    //   347: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +13 -> 363
    //   353: ldc 195
    //   355: iconst_2
    //   356: ldc 197
    //   358: aload 5
    //   360: invokestatic 201	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   363: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +29 -> 395
    //   369: ldc 195
    //   371: iconst_2
    //   372: new 85	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   379: ldc 197
    //   381: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 4
    //   386: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 207	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload_0
    //   396: invokevirtual 210	java/lang/Process:waitFor	()I
    //   399: pop
    //   400: aload_0
    //   401: invokevirtual 213	java/lang/Process:exitValue	()I
    //   404: istore_2
    //   405: iload_2
    //   406: ifeq +47 -> 453
    //   409: new 72	java/io/File
    //   412: dup
    //   413: aload_1
    //   414: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   417: astore_1
    //   418: aload_1
    //   419: invokevirtual 79	java/io/File:exists	()Z
    //   422: ifeq +8 -> 430
    //   425: aload_1
    //   426: invokevirtual 216	java/io/File:delete	()Z
    //   429: pop
    //   430: new 85	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   437: ldc 218
    //   439: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: iload_2
    //   443: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   446: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: aconst_null
    //   450: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   453: aload_0
    //   454: ifnull +7 -> 461
    //   457: aload_0
    //   458: invokevirtual 224	java/lang/Process:destroy	()V
    //   461: iload_2
    //   462: ireturn
    //   463: bipush 244
    //   465: ireturn
    //   466: astore_0
    //   467: ldc 226
    //   469: aload_0
    //   470: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   473: bipush 245
    //   475: ireturn
    //   476: astore 4
    //   478: ldc 226
    //   480: aload 4
    //   482: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   485: goto -85 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	paramString1	String
    //   0	488	1	paramString2	String
    //   404	58	2	i	int
    //   34	14	3	bool	boolean
    //   6	379	4	localObject1	Object
    //   476	5	4	localInterruptedException	java.lang.InterruptedException
    //   17	306	5	localObject2	Object
    //   345	14	5	localException	Exception
    //   327	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   302	322	345	java/lang/Exception
    //   322	329	345	java/lang/Exception
    //   334	342	345	java/lang/Exception
    //   288	293	466	java/io/IOException
    //   395	400	476	java/lang/InterruptedException
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return b(paramString1, paramString2, paramString3, paramInt);
  }
  
  /* Error */
  private static int a(List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: invokeinterface 233 1 0
    //   10: ifne +8 -> 18
    //   13: bipush 247
    //   15: istore_1
    //   16: iload_1
    //   17: ireturn
    //   18: invokestatic 65	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   21: invokestatic 70	blbm:a	(Landroid/content/Context;)Ljava/lang/String;
    //   24: astore 4
    //   26: new 72	java/io/File
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 79	java/io/File:exists	()Z
    //   42: ifeq +200 -> 242
    //   45: aload 5
    //   47: iconst_1
    //   48: iconst_1
    //   49: invokevirtual 83	java/io/File:setExecutable	(ZZ)Z
    //   52: istore_3
    //   53: new 85	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   60: ldc 235
    //   62: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_3
    //   66: invokevirtual 95	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: aconst_null
    //   73: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: aload 4
    //   80: invokeinterface 238 3 0
    //   85: aload_0
    //   86: iconst_1
    //   87: ldc 113
    //   89: invokeinterface 238 3 0
    //   94: aload_0
    //   95: iconst_2
    //   96: ldc 119
    //   98: invokeinterface 238 3 0
    //   103: aload_0
    //   104: iconst_3
    //   105: ldc 115
    //   107: invokeinterface 238 3 0
    //   112: aload_0
    //   113: iconst_4
    //   114: ldc 240
    //   116: invokeinterface 238 3 0
    //   121: aload_0
    //   122: invokestatic 65	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   125: invokestatic 152	blbm:b	(Landroid/content/Context;)Ljava/lang/String;
    //   128: invokeinterface 111 2 0
    //   133: pop
    //   134: new 242	blbp
    //   137: dup
    //   138: aconst_null
    //   139: invokespecial 243	blbp:<init>	(Lblbo;)V
    //   142: astore 4
    //   144: new 154	java/lang/ProcessBuilder
    //   147: dup
    //   148: iconst_0
    //   149: anewarray 138	java/lang/String
    //   152: invokespecial 157	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   155: astore 5
    //   157: aload 5
    //   159: iconst_1
    //   160: invokevirtual 161	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   163: pop
    //   164: aload 5
    //   166: aload_0
    //   167: invokevirtual 165	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 169	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   176: astore_0
    //   177: aload 4
    //   179: aload_0
    //   180: putfield 246	blbp:a	Ljava/lang/Process;
    //   183: aload 4
    //   185: invokevirtual 247	blbp:a	()V
    //   188: aload_0
    //   189: invokevirtual 210	java/lang/Process:waitFor	()I
    //   192: pop
    //   193: aload_0
    //   194: invokevirtual 213	java/lang/Process:exitValue	()I
    //   197: istore_2
    //   198: iload_2
    //   199: ifeq +26 -> 225
    //   202: new 85	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   209: ldc 218
    //   211: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_2
    //   215: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: aconst_null
    //   222: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload 4
    //   227: invokevirtual 249	blbp:b	()V
    //   230: iload_2
    //   231: istore_1
    //   232: aload_0
    //   233: ifnull -217 -> 16
    //   236: aload_0
    //   237: invokevirtual 224	java/lang/Process:destroy	()V
    //   240: iload_2
    //   241: ireturn
    //   242: bipush 244
    //   244: ireturn
    //   245: astore_0
    //   246: ldc 226
    //   248: aload_0
    //   249: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: bipush 245
    //   254: ireturn
    //   255: astore 5
    //   257: ldc 226
    //   259: aload 5
    //   261: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: goto -71 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramList	List<String>
    //   15	217	1	i	int
    //   197	44	2	j	int
    //   52	14	3	bool	boolean
    //   24	202	4	localObject1	Object
    //   35	137	5	localObject2	Object
    //   255	5	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   171	177	245	java/io/IOException
    //   188	193	255	java/lang/InterruptedException
  }
  
  private final MediaExtractor a(String paramString)
  {
    if (a(paramString)) {
      localMediaExtractor = new MediaExtractor();
    }
    try
    {
      localMediaExtractor.setDataSource(paramString);
      int i = localMediaExtractor.getTrackCount();
      if (i != 1) {
        localMediaExtractor.release();
      }
      return localMediaExtractor;
    }
    catch (IOException localIOException1)
    {
      try
      {
        b("createExtractor:invalid media file:numTracks=" + i + " path=" + paramString, null);
        return null;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localMediaExtractor = null;
        }
      }
      localIOException1 = localIOException1;
      b("createExtractor path:" + paramString, localIOException1);
      localMediaExtractor.release();
      return null;
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    if (this.jdField_b_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_b_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_b_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  public static boolean a(List<String> paramList, String paramString, int paramInt)
  {
    String str1 = "concat:";
    int i = 0;
    String str2;
    if (i < paramList.size())
    {
      String str3 = (String)paramList.get(i);
      str2 = str1;
      if (i > 0) {
        str2 = str1 + "|";
      }
      str1 = str3.replace(".mp4", ".ts");
      int j = c(str3, str1);
      if (j != 0) {
        if (QLog.isColorLevel()) {
          QLog.e("HwVideoMerge", 2, "ffmpegMp4toTs fail, err: " + j);
        }
      }
    }
    do
    {
      return false;
      str1 = str2 + str1;
      i += 1;
      break;
      paramList = paramString.replace(".mp4", ".ts");
      i = b(str1, paramList);
      if (i == 0) {
        break label207;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HwVideoMerge", 2, "ffmpegMergeTs fail, err: " + i);
    return false;
    label207:
    if (paramInt == 90) {
      i = 270;
    }
    for (;;)
    {
      paramInt = a(new ArrayList(Arrays.asList(new String[] { "-i", paramList, "-metadata:s", "rotate=" + i, "-vcodec", "copy", "-acodec", "copy", "-absf", "aac_adtstoasc", paramString })));
      if (paramInt == 0) {
        break label372;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("HwVideoMerge", 2, "ffmpegTstoMp4 fail, err: " + paramInt);
      return false;
      i = paramInt;
      if (paramInt == 270) {
        i = 90;
      }
    }
    label372:
    return true;
  }
  
  private static int b(String paramString, int paramInt)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = null;
      try
      {
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramString = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HwVideoMerge", 2, localException, new Object[0]);
        }
      }
      localMediaMetadataRetriever.release();
      if (paramString == null) {
        return paramInt;
      }
      int i;
      return paramInt;
    }
    catch (IllegalArgumentException paramString)
    {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString) {}
      paramString = paramString;
      return paramInt;
    }
  }
  
  private static int b(String paramString1, String paramString2)
  {
    return a(new ArrayList(Arrays.asList(new String[] { "-i", paramString1, "-c", "copy", paramString2 })));
  }
  
  public static final int b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = new blbn(paramString1, paramString2).a(null, paramInt);
    int i;
    if ((j == -2) || (j == -4) || (j == -6)) {
      if (new File(paramString1).renameTo(new File(paramString3))) {
        i = 0;
      }
    }
    do
    {
      return i;
      return -10;
      i = j;
    } while (j != -9);
    return c(paramString1, paramString2, paramString3, paramInt);
  }
  
  private static void b(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("HwVideoMerge", 2, paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("HwVideoMerge", 2, paramString);
  }
  
  private static int c(String paramString1, String paramString2)
  {
    return a(new ArrayList(Arrays.asList(new String[] { "-i", paramString1, "-c", "copy", "-bsf:v", "h264_mp4toannexb", "-f", "mpegts", paramString2 })));
  }
  
  /* Error */
  private static int c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 65	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   3: invokestatic 70	blbm:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 6
    //   8: new 72	java/io/File
    //   11: dup
    //   12: aload 6
    //   14: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 79	java/io/File:exists	()Z
    //   24: ifeq +326 -> 350
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 83	java/io/File:setExecutable	(ZZ)Z
    //   34: istore 4
    //   36: new 85	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   43: ldc 235
    //   45: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 95	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aconst_null
    //   57: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_0
    //   61: iload_3
    //   62: invokestatic 381	blbn:b	(Ljava/lang/String;I)I
    //   65: pop
    //   66: new 104	java/util/ArrayList
    //   69: dup
    //   70: invokespecial 105	java/util/ArrayList:<init>	()V
    //   73: astore 5
    //   75: aload 5
    //   77: aload 6
    //   79: invokeinterface 111 2 0
    //   84: pop
    //   85: aload 5
    //   87: ldc 113
    //   89: invokeinterface 111 2 0
    //   94: pop
    //   95: aload 5
    //   97: ldc 119
    //   99: invokeinterface 111 2 0
    //   104: pop
    //   105: aload 5
    //   107: ldc 115
    //   109: invokeinterface 111 2 0
    //   114: pop
    //   115: aload 5
    //   117: ldc 240
    //   119: invokeinterface 111 2 0
    //   124: pop
    //   125: aload 5
    //   127: ldc 121
    //   129: invokeinterface 111 2 0
    //   134: pop
    //   135: aload 5
    //   137: aload_0
    //   138: invokeinterface 111 2 0
    //   143: pop
    //   144: aload 5
    //   146: ldc 121
    //   148: invokeinterface 111 2 0
    //   153: pop
    //   154: aload 5
    //   156: aload_1
    //   157: invokeinterface 111 2 0
    //   162: pop
    //   163: aload 5
    //   165: ldc_w 311
    //   168: invokeinterface 111 2 0
    //   173: pop
    //   174: aload 5
    //   176: ldc_w 313
    //   179: invokeinterface 111 2 0
    //   184: pop
    //   185: aload 5
    //   187: ldc_w 315
    //   190: invokeinterface 111 2 0
    //   195: pop
    //   196: aload 5
    //   198: ldc_w 313
    //   201: invokeinterface 111 2 0
    //   206: pop
    //   207: aload 5
    //   209: aload_2
    //   210: invokeinterface 111 2 0
    //   215: pop
    //   216: aload 5
    //   218: invokestatic 65	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   221: invokestatic 152	blbm:b	(Landroid/content/Context;)Ljava/lang/String;
    //   224: invokeinterface 111 2 0
    //   229: pop
    //   230: new 242	blbp
    //   233: dup
    //   234: aconst_null
    //   235: invokespecial 243	blbp:<init>	(Lblbo;)V
    //   238: astore_0
    //   239: new 154	java/lang/ProcessBuilder
    //   242: dup
    //   243: iconst_0
    //   244: anewarray 138	java/lang/String
    //   247: invokespecial 157	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   250: astore_1
    //   251: aload_1
    //   252: iconst_1
    //   253: invokevirtual 161	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   256: pop
    //   257: aload_1
    //   258: aload 5
    //   260: invokevirtual 165	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   263: pop
    //   264: aload_1
    //   265: invokevirtual 169	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   268: astore_1
    //   269: aload_0
    //   270: aload_1
    //   271: putfield 246	blbp:a	Ljava/lang/Process;
    //   274: aload_0
    //   275: invokevirtual 247	blbp:a	()V
    //   278: aload_1
    //   279: invokevirtual 210	java/lang/Process:waitFor	()I
    //   282: pop
    //   283: aload_1
    //   284: invokevirtual 213	java/lang/Process:exitValue	()I
    //   287: istore_3
    //   288: iload_3
    //   289: ifeq +47 -> 336
    //   292: new 72	java/io/File
    //   295: dup
    //   296: aload_2
    //   297: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   300: astore_2
    //   301: aload_2
    //   302: invokevirtual 79	java/io/File:exists	()Z
    //   305: ifeq +8 -> 313
    //   308: aload_2
    //   309: invokevirtual 216	java/io/File:delete	()Z
    //   312: pop
    //   313: new 85	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   320: ldc 218
    //   322: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: iload_3
    //   326: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: aconst_null
    //   333: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: aload_0
    //   337: invokevirtual 249	blbp:b	()V
    //   340: aload_1
    //   341: ifnull +7 -> 348
    //   344: aload_1
    //   345: invokevirtual 224	java/lang/Process:destroy	()V
    //   348: iload_3
    //   349: ireturn
    //   350: bipush 244
    //   352: ireturn
    //   353: astore_0
    //   354: ldc 226
    //   356: aload_0
    //   357: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: bipush 245
    //   362: ireturn
    //   363: astore 5
    //   365: ldc 226
    //   367: aload 5
    //   369: invokestatic 102	blbn:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   372: goto -89 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramString1	String
    //   0	375	1	paramString2	String
    //   0	375	2	paramString3	String
    //   0	375	3	paramInt	int
    //   34	15	4	bool	boolean
    //   17	242	5	localObject	Object
    //   363	5	5	localInterruptedException	java.lang.InterruptedException
    //   6	72	6	str	String
    // Exception table:
    //   from	to	target	type
    //   264	269	353	java/io/IOException
    //   278	283	363	java/lang/InterruptedException
  }
  
  public int a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = a(this.jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor == null) {
      i = -1;
    }
    MediaFormat localMediaFormat;
    Object localObject;
    int j;
    do
    {
      return i;
      this.jdField_b_of_type_AndroidMediaMediaExtractor = a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_AndroidMediaMediaExtractor == null)
      {
        a();
        return -2;
      }
      localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(0);
      localObject = localMediaFormat.getString("mime");
      this.jdField_a_of_type_Int = localMediaFormat.getInteger("width");
      this.jdField_b_of_type_Int = localMediaFormat.getInteger("height");
      if (!((String)localObject).startsWith("video/")) {
        break;
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(0);
      localObject = this.jdField_b_of_type_AndroidMediaMediaExtractor.getTrackFormat(0);
      if (!((MediaFormat)localObject).getString("mime").startsWith("audio/")) {
        break label198;
      }
      this.jdField_b_of_type_AndroidMediaMediaExtractor.selectTrack(0);
      this.jdField_a_of_type_Blbq.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      j = a();
      i = j;
    } while (j != 0);
    if (!a(paramString))
    {
      a();
      return -9;
      a();
      return -3;
      label198:
      a();
      return -4;
    }
    try
    {
      if (new File(paramString).exists())
      {
        a();
        return -8;
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramString, 0);
      paramInt = b(this.jdField_a_of_type_JavaLangString, paramInt);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramInt);
      this.jdField_a_of_type_Blbq.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat);
      this.jdField_a_of_type_Blbq.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
      return j;
    }
    catch (IOException paramString)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      a();
    }
    return -7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     blbn
 * JD-Core Version:    0.7.0.1
 */