import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class azkd
{
  private static Process jdField_a_of_type_JavaLangProcess;
  private static Process jdField_b_of_type_JavaLangProcess;
  private int jdField_a_of_type_Int;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private azkg jdField_a_of_type_Azkg = new azkg(null);
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor;
  private String jdField_b_of_type_JavaLangString;
  
  public azkd(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private int a()
  {
    int i = 0;
    this.jdField_a_of_type_Azkg.jdField_a_of_type_JavaNioByteBuffer.position(0);
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Azkg.jdField_a_of_type_JavaNioByteBuffer, 0) <= 0)
    {
      a();
      i = -5;
    }
    do
    {
      return i;
      this.jdField_a_of_type_Azkg.jdField_a_of_type_JavaNioByteBuffer.position(0);
    } while (this.jdField_b_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Azkg.jdField_a_of_type_JavaNioByteBuffer, 0) > 0);
    a();
    return -6;
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 64	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   3: invokestatic 69	azjy:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 5
    //   8: new 71	java/io/File
    //   11: dup
    //   12: aload 5
    //   14: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 78	java/io/File:exists	()Z
    //   24: ifeq +326 -> 350
    //   27: aload 4
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 82	java/io/File:setExecutable	(ZZ)Z
    //   34: istore_3
    //   35: new 84	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   42: ldc 87
    //   44: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 94	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aconst_null
    //   55: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: aload_0
    //   59: iload_2
    //   60: invokestatic 104	azkd:b	(Ljava/lang/String;I)I
    //   63: pop
    //   64: new 106	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 107	java/util/ArrayList:<init>	()V
    //   71: astore 4
    //   73: aload 4
    //   75: aload 5
    //   77: invokeinterface 113 2 0
    //   82: pop
    //   83: aload 4
    //   85: ldc 115
    //   87: invokeinterface 113 2 0
    //   92: pop
    //   93: aload 4
    //   95: ldc 117
    //   97: invokeinterface 113 2 0
    //   102: pop
    //   103: aload 4
    //   105: ldc 119
    //   107: invokeinterface 113 2 0
    //   112: pop
    //   113: aload 4
    //   115: ldc 121
    //   117: invokeinterface 113 2 0
    //   122: pop
    //   123: aload 4
    //   125: ldc 123
    //   127: invokeinterface 113 2 0
    //   132: pop
    //   133: aload 4
    //   135: aload_0
    //   136: invokeinterface 113 2 0
    //   141: pop
    //   142: aload 4
    //   144: ldc 125
    //   146: invokeinterface 113 2 0
    //   151: pop
    //   152: aload 4
    //   154: ldc 127
    //   156: invokeinterface 113 2 0
    //   161: pop
    //   162: aload 4
    //   164: ldc 129
    //   166: invokeinterface 113 2 0
    //   171: pop
    //   172: aload 4
    //   174: ldc 131
    //   176: invokeinterface 113 2 0
    //   181: pop
    //   182: aload 4
    //   184: aload_1
    //   185: invokeinterface 113 2 0
    //   190: pop
    //   191: aload 4
    //   193: invokestatic 64	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   196: invokestatic 133	azjy:b	(Landroid/content/Context;)Ljava/lang/String;
    //   199: invokeinterface 113 2 0
    //   204: pop
    //   205: new 135	azkf
    //   208: dup
    //   209: aconst_null
    //   210: invokespecial 136	azkf:<init>	(Lazke;)V
    //   213: astore_0
    //   214: new 138	java/lang/ProcessBuilder
    //   217: dup
    //   218: iconst_0
    //   219: anewarray 140	java/lang/String
    //   222: invokespecial 143	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   225: astore 5
    //   227: aload 5
    //   229: iconst_1
    //   230: invokevirtual 147	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   233: pop
    //   234: aload 5
    //   236: aload 4
    //   238: invokevirtual 151	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   241: pop
    //   242: aload 5
    //   244: invokevirtual 155	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   247: astore 4
    //   249: aload 4
    //   251: putstatic 157	azkd:jdField_b_of_type_JavaLangProcess	Ljava/lang/Process;
    //   254: aload_0
    //   255: aload 4
    //   257: putfield 159	azkf:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   260: aload_0
    //   261: invokevirtual 160	azkf:a	()V
    //   264: aload 4
    //   266: invokevirtual 165	java/lang/Process:waitFor	()I
    //   269: pop
    //   270: aload 4
    //   272: invokevirtual 168	java/lang/Process:exitValue	()I
    //   275: istore_2
    //   276: iload_2
    //   277: ifeq +47 -> 324
    //   280: new 71	java/io/File
    //   283: dup
    //   284: aload_1
    //   285: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 78	java/io/File:exists	()Z
    //   293: ifeq +8 -> 301
    //   296: aload_1
    //   297: invokevirtual 171	java/io/File:delete	()Z
    //   300: pop
    //   301: new 84	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   308: ldc 173
    //   310: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload_2
    //   314: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: aconst_null
    //   321: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   324: aload_0
    //   325: invokevirtual 178	azkf:b	()V
    //   328: aload 4
    //   330: ifnull +18 -> 348
    //   333: aload 4
    //   335: invokevirtual 181	java/lang/Process:destroy	()V
    //   338: getstatic 157	azkd:jdField_b_of_type_JavaLangProcess	Ljava/lang/Process;
    //   341: ifnull +7 -> 348
    //   344: aconst_null
    //   345: putstatic 157	azkd:jdField_b_of_type_JavaLangProcess	Ljava/lang/Process;
    //   348: iload_2
    //   349: ireturn
    //   350: bipush 244
    //   352: ireturn
    //   353: astore_0
    //   354: ldc 183
    //   356: aload_0
    //   357: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: bipush 245
    //   362: ireturn
    //   363: astore 5
    //   365: ldc 183
    //   367: aload 5
    //   369: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   372: goto -102 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramString1	String
    //   0	375	1	paramString2	String
    //   0	375	2	paramInt	int
    //   34	14	3	bool	boolean
    //   17	317	4	localObject1	Object
    //   6	237	5	localObject2	Object
    //   363	5	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   242	254	353	java/io/IOException
    //   264	270	363	java/lang/InterruptedException
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return b(paramString1, paramString2, paramString3, paramInt);
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
  
  public static boolean a()
  {
    boolean bool = false;
    b("[@]  ffmpegProcess try destroy!", null);
    if ((jdField_a_of_type_JavaLangProcess != null) && (!xtl.a(jdField_a_of_type_JavaLangProcess)))
    {
      jdField_a_of_type_JavaLangProcess.destroy();
      jdField_a_of_type_JavaLangProcess = null;
      b("[@]  ffmpegProcess, destroyMergeProcess!", null);
    }
    for (int i = 1;; i = 0)
    {
      if ((jdField_b_of_type_JavaLangProcess != null) && (!xtl.a(jdField_b_of_type_JavaLangProcess)))
      {
        jdField_b_of_type_JavaLangProcess.destroy();
        jdField_b_of_type_JavaLangProcess = null;
        b("[@]  ffmpegProcess, destroyRecodeProcess!", null);
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          bool = true;
        }
        return bool;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
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
  
  public static final int b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = new azkd(paramString1, paramString2).a(null, paramInt);
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
  
  /* Error */
  private static int c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 64	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   3: invokestatic 69	azjy:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 6
    //   8: new 71	java/io/File
    //   11: dup
    //   12: aload 6
    //   14: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 78	java/io/File:exists	()Z
    //   24: ifeq +418 -> 442
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 82	java/io/File:setExecutable	(ZZ)Z
    //   34: istore 4
    //   36: new 84	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   43: ldc 87
    //   45: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 94	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 275
    //   56: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload 5
    //   61: invokevirtual 279	java/io/File:length	()J
    //   64: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: aconst_null
    //   71: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: aload_0
    //   75: iload_3
    //   76: invokestatic 104	azkd:b	(Ljava/lang/String;I)I
    //   79: pop
    //   80: new 106	java/util/ArrayList
    //   83: dup
    //   84: invokespecial 107	java/util/ArrayList:<init>	()V
    //   87: astore 5
    //   89: aload 5
    //   91: aload 6
    //   93: invokeinterface 113 2 0
    //   98: pop
    //   99: aload 5
    //   101: ldc 115
    //   103: invokeinterface 113 2 0
    //   108: pop
    //   109: aload 5
    //   111: ldc 117
    //   113: invokeinterface 113 2 0
    //   118: pop
    //   119: aload 5
    //   121: ldc 119
    //   123: invokeinterface 113 2 0
    //   128: pop
    //   129: aload 5
    //   131: ldc 121
    //   133: invokeinterface 113 2 0
    //   138: pop
    //   139: aload 5
    //   141: ldc 123
    //   143: invokeinterface 113 2 0
    //   148: pop
    //   149: aload 5
    //   151: aload_0
    //   152: invokeinterface 113 2 0
    //   157: pop
    //   158: aload 5
    //   160: ldc 123
    //   162: invokeinterface 113 2 0
    //   167: pop
    //   168: aload 5
    //   170: aload_1
    //   171: invokeinterface 113 2 0
    //   176: pop
    //   177: aload 5
    //   179: ldc_w 284
    //   182: invokeinterface 113 2 0
    //   187: pop
    //   188: aload 5
    //   190: ldc_w 286
    //   193: invokeinterface 113 2 0
    //   198: pop
    //   199: aload 5
    //   201: ldc_w 288
    //   204: invokeinterface 113 2 0
    //   209: pop
    //   210: aload 5
    //   212: ldc_w 286
    //   215: invokeinterface 113 2 0
    //   220: pop
    //   221: aload 5
    //   223: aload_2
    //   224: invokeinterface 113 2 0
    //   229: pop
    //   230: aload 5
    //   232: invokestatic 64	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   235: invokestatic 133	azjy:b	(Landroid/content/Context;)Ljava/lang/String;
    //   238: invokeinterface 113 2 0
    //   243: pop
    //   244: new 84	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   251: ldc_w 290
    //   254: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 5
    //   259: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: aconst_null
    //   266: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   269: new 135	azkf
    //   272: dup
    //   273: aconst_null
    //   274: invokespecial 136	azkf:<init>	(Lazke;)V
    //   277: astore_0
    //   278: new 138	java/lang/ProcessBuilder
    //   281: dup
    //   282: iconst_0
    //   283: anewarray 140	java/lang/String
    //   286: invokespecial 143	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   289: astore_1
    //   290: aload_1
    //   291: iconst_1
    //   292: invokevirtual 147	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   295: pop
    //   296: aload_1
    //   297: aload 5
    //   299: invokevirtual 151	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   302: pop
    //   303: aload_1
    //   304: invokevirtual 155	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   307: astore_1
    //   308: aload_1
    //   309: putstatic 209	azkd:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   312: aload_0
    //   313: aload_1
    //   314: putfield 159	azkf:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   317: aload_0
    //   318: invokevirtual 160	azkf:a	()V
    //   321: aload_1
    //   322: invokevirtual 165	java/lang/Process:waitFor	()I
    //   325: pop
    //   326: aload_1
    //   327: invokevirtual 168	java/lang/Process:exitValue	()I
    //   330: istore_3
    //   331: iload_3
    //   332: ifeq +50 -> 382
    //   335: new 71	java/io/File
    //   338: dup
    //   339: aload_2
    //   340: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   343: astore 5
    //   345: aload 5
    //   347: invokevirtual 78	java/io/File:exists	()Z
    //   350: ifeq +9 -> 359
    //   353: aload 5
    //   355: invokevirtual 171	java/io/File:delete	()Z
    //   358: pop
    //   359: new 84	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   366: ldc 173
    //   368: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: iload_3
    //   372: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: aconst_null
    //   379: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   382: new 71	java/io/File
    //   385: dup
    //   386: aload_2
    //   387: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   390: astore_2
    //   391: new 84	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   398: ldc_w 295
    //   401: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_2
    //   405: invokevirtual 78	java/io/File:exists	()Z
    //   408: invokevirtual 94	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   411: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: aconst_null
    //   415: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   418: aload_0
    //   419: invokevirtual 178	azkf:b	()V
    //   422: aload_1
    //   423: ifnull +17 -> 440
    //   426: aload_1
    //   427: invokevirtual 181	java/lang/Process:destroy	()V
    //   430: getstatic 209	azkd:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   433: ifnull +7 -> 440
    //   436: aconst_null
    //   437: putstatic 209	azkd:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   440: iload_3
    //   441: ireturn
    //   442: bipush 244
    //   444: ireturn
    //   445: astore_0
    //   446: ldc 183
    //   448: aload_0
    //   449: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   452: bipush 245
    //   454: ireturn
    //   455: astore 5
    //   457: ldc 183
    //   459: aload 5
    //   461: invokestatic 101	azkd:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   464: goto -138 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	paramString1	String
    //   0	467	1	paramString2	String
    //   0	467	2	paramString3	String
    //   0	467	3	paramInt	int
    //   34	15	4	bool	boolean
    //   17	337	5	localObject	Object
    //   455	5	5	localInterruptedException	java.lang.InterruptedException
    //   6	86	6	str	String
    // Exception table:
    //   from	to	target	type
    //   303	312	445	java/io/IOException
    //   321	326	455	java/lang/InterruptedException
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
      this.jdField_a_of_type_Azkg.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
      this.jdField_a_of_type_Azkg.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat);
      this.jdField_a_of_type_Azkg.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkd
 * JD-Core Version:    0.7.0.1
 */