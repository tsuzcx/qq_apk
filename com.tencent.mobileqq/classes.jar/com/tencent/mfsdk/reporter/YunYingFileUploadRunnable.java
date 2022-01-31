package com.tencent.mfsdk.reporter;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import mqq.os.MqqHandler;

public class YunYingFileUploadRunnable
  extends BaseUploadRunnable
{
  private int jdField_a_of_type_Int;
  private IReporter.ReportResultCallback jdField_a_of_type_ComTencentMfsdkReporterIReporter$ReportResultCallback;
  private File jdField_a_of_type_JavaIoFile;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream;
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(128);
  private URL jdField_a_of_type_JavaNetURL;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private FileChannel jdField_a_of_type_JavaNioChannelsFileChannel;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = -1;
  private String jdField_c_of_type_JavaLangString;
  private int d = -1;
  
  public YunYingFileUploadRunnable(URL paramURL, String paramString, IReporter.ReportResultCallback paramReportResultCallback, int paramInt, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_JavaNetURL = paramURL;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMfsdkReporterIReporter$ReportResultCallback = paramReportResultCallback;
    this.d = paramInt;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    if (QLog.isColorLevel()) {
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  private void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaNioChannelsFileChannel != null)
      {
        this.jdField_a_of_type_JavaNioChannelsFileChannel.close();
        this.jdField_a_of_type_JavaNioChannelsFileChannel = null;
      }
      if (this.jdField_a_of_type_JavaIoFileInputStream != null)
      {
        this.jdField_a_of_type_JavaIoFileInputStream.close();
        this.jdField_a_of_type_JavaIoFileInputStream = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean a()
  {
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    Object localObject2;
    long l;
    if ((localObject1 != null) && (((File)localObject1).isFile()))
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaIoFile = new File((String)localObject1);
      localObject2 = new StringBuilder(128);
      ((StringBuilder)localObject2).append("attachment; filename=\"").append(this.jdField_a_of_type_JavaIoFile.getName()).append("\"");
      this.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      this.jdField_b_of_type_JavaLangString = MD5.toMD5((String)localObject1);
      l = this.jdField_a_of_type_JavaIoFile.length();
      this.jdField_c_of_type_Int = ((int)Math.ceil(l / 1048576.0D));
      if (l <= 1048576L) {
        break label255;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(1048576);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label255:
        int i;
        a();
        return false;
      }
      try
      {
        this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(this.jdField_a_of_type_JavaIoFile);
        this.jdField_a_of_type_JavaNioChannelsFileChannel = this.jdField_a_of_type_JavaIoFileInputStream.getChannel();
        return true;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        a();
      }
      if (((File)localObject1).isDirectory())
      {
        localObject1 = ((File)localObject1).getParent();
        l = System.currentTimeMillis();
        localObject2 = "out_" + String.valueOf(l) + ".zip";
        localObject1 = (String)localObject1 + "/" + (String)localObject2;
        FileUtils.e(this.jdField_a_of_type_JavaLangString, (String)localObject1);
        break;
      }
      return false;
      if (l > 0L)
      {
        i = (int)l;
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(i);
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {}
    while ((!paramString.contains("success")) && (!(paramString.contains("-") & paramString.contains("/")))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 179	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Boolean	Z
    //   7: ifne +16 -> 23
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 179	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Boolean	Z
    //   15: aload_0
    //   16: invokespecial 181	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:a	()Z
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aload_0
    //   24: getfield 63	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 128	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   34: ifnonnull +22 -> 56
    //   37: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +11 -> 51
    //   43: ldc 183
    //   45: iconst_2
    //   46: ldc 185
    //   48: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: invokespecial 167	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:a	()V
    //   55: return
    //   56: aconst_null
    //   57: astore 9
    //   59: aconst_null
    //   60: astore 10
    //   62: aconst_null
    //   63: astore 8
    //   65: aconst_null
    //   66: astore 11
    //   68: aload_0
    //   69: getfield 56	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   72: aload_0
    //   73: getfield 128	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   76: invokevirtual 192	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   79: istore_1
    //   80: iconst_m1
    //   81: iload_1
    //   82: if_icmpeq +796 -> 878
    //   85: iload_1
    //   86: ifeq +792 -> 878
    //   89: aload_0
    //   90: getfield 37	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNetURL	Ljava/net/URL;
    //   93: invokevirtual 198	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   96: checkcast 200	java/net/HttpURLConnection
    //   99: astore 7
    //   101: aload 7
    //   103: astore 10
    //   105: aload 8
    //   107: astore 9
    //   109: aload 7
    //   111: sipush 30000
    //   114: invokevirtual 203	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   117: aload 7
    //   119: astore 10
    //   121: aload 8
    //   123: astore 9
    //   125: aload 7
    //   127: sipush 30000
    //   130: invokevirtual 206	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   133: aload 7
    //   135: astore 10
    //   137: aload 8
    //   139: astore 9
    //   141: aload 7
    //   143: iconst_0
    //   144: invokevirtual 210	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   147: aload 7
    //   149: astore 10
    //   151: aload 8
    //   153: astore 9
    //   155: aload 7
    //   157: iconst_1
    //   158: invokevirtual 213	java/net/HttpURLConnection:setDoInput	(Z)V
    //   161: aload 7
    //   163: astore 10
    //   165: aload 8
    //   167: astore 9
    //   169: aload 7
    //   171: iconst_0
    //   172: invokevirtual 216	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   175: aload 7
    //   177: astore 10
    //   179: aload 8
    //   181: astore 9
    //   183: aload 7
    //   185: ldc 218
    //   187: invokevirtual 221	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   190: aload 7
    //   192: astore 10
    //   194: aload 8
    //   196: astore 9
    //   198: aload 7
    //   200: ldc 223
    //   202: ldc 225
    //   204: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload 7
    //   209: astore 10
    //   211: aload 8
    //   213: astore 9
    //   215: aload 7
    //   217: ldc 231
    //   219: ldc 233
    //   221: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 7
    //   226: astore 10
    //   228: aload 8
    //   230: astore 9
    //   232: aload 7
    //   234: ldc 235
    //   236: aload_0
    //   237: getfield 97	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   240: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 7
    //   245: astore 10
    //   247: aload 8
    //   249: astore 9
    //   251: aload 7
    //   253: ldc 237
    //   255: aload_0
    //   256: getfield 105	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   259: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload 7
    //   264: astore 10
    //   266: aload 8
    //   268: astore 9
    //   270: aload 7
    //   272: ldc 239
    //   274: new 26	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   281: ldc 241
    //   283: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload_1
    //   287: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload 7
    //   298: astore 10
    //   300: aload 8
    //   302: astore 9
    //   304: aload 7
    //   306: ldc 246
    //   308: ldc 248
    //   310: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload 7
    //   315: astore 10
    //   317: aload 8
    //   319: astore 9
    //   321: aload_0
    //   322: getfield 31	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   325: iconst_0
    //   326: aload_0
    //   327: getfield 31	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   330: invokevirtual 251	java/lang/StringBuilder:length	()I
    //   333: invokevirtual 255	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 7
    //   339: astore 10
    //   341: aload 8
    //   343: astore 9
    //   345: aload_0
    //   346: getfield 31	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   349: ldc_w 257
    //   352: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_0
    //   356: getfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   359: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 176
    //   364: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   371: iload_1
    //   372: iadd
    //   373: iconst_1
    //   374: isub
    //   375: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: ldc 159
    //   380: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_0
    //   384: getfield 80	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   387: invokevirtual 109	java/io/File:length	()J
    //   390: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   393: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: astore 12
    //   398: aload 7
    //   400: astore 10
    //   402: aload 8
    //   404: astore 9
    //   406: aload 7
    //   408: ldc_w 264
    //   411: aload 12
    //   413: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload 7
    //   418: astore 10
    //   420: aload 8
    //   422: astore 9
    //   424: aload_0
    //   425: aload_0
    //   426: getfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   429: iload_1
    //   430: iadd
    //   431: putfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   434: aload 7
    //   436: astore 10
    //   438: aload 8
    //   440: astore 9
    //   442: new 266	java/io/DataOutputStream
    //   445: dup
    //   446: aload 7
    //   448: invokevirtual 270	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   451: invokespecial 273	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   454: astore 8
    //   456: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +30 -> 489
    //   462: ldc 183
    //   464: iconst_2
    //   465: new 26	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 275
    //   475: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload 12
    //   480: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 278	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: aload 8
    //   491: aload_0
    //   492: getfield 128	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   495: invokevirtual 282	java/nio/ByteBuffer:array	()[B
    //   498: invokevirtual 286	java/io/DataOutputStream:write	([B)V
    //   501: aload 8
    //   503: invokevirtual 289	java/io/DataOutputStream:flush	()V
    //   506: aload_0
    //   507: getfield 128	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   510: invokevirtual 293	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   513: pop
    //   514: aload_0
    //   515: new 295	java/io/BufferedInputStream
    //   518: dup
    //   519: aload 7
    //   521: invokevirtual 299	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   524: invokespecial 302	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   527: invokestatic 307	com/tencent/mfsdk/tools/NetworkWatcher:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   530: invokevirtual 309	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:a	(Ljava/lang/String;)Z
    //   533: istore_3
    //   534: iload_3
    //   535: ifne +81 -> 616
    //   538: aload_0
    //   539: getfield 56	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   542: invokevirtual 312	java/nio/channels/FileChannel:position	()J
    //   545: lstore 5
    //   547: aload_0
    //   548: getfield 56	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   551: lload 5
    //   553: iload_1
    //   554: i2l
    //   555: lsub
    //   556: invokevirtual 315	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   559: pop
    //   560: aload_0
    //   561: getfield 128	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   564: invokevirtual 293	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   567: pop
    //   568: aload_0
    //   569: aload_0
    //   570: getfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   573: iload_1
    //   574: isub
    //   575: putfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   578: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   581: ifeq +35 -> 616
    //   584: ldc 183
    //   586: iconst_2
    //   587: iconst_3
    //   588: anewarray 317	java/lang/Object
    //   591: dup
    //   592: iconst_0
    //   593: ldc_w 319
    //   596: aastore
    //   597: dup
    //   598: iconst_1
    //   599: aload_0
    //   600: getfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   603: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   606: aastore
    //   607: dup
    //   608: iconst_2
    //   609: ldc_w 324
    //   612: aastore
    //   613: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   616: aload 8
    //   618: ifnull +8 -> 626
    //   621: aload 8
    //   623: invokevirtual 328	java/io/DataOutputStream:close	()V
    //   626: aload 7
    //   628: ifnull +498 -> 1126
    //   631: aload 7
    //   633: invokevirtual 331	java/net/HttpURLConnection:disconnect	()V
    //   636: iload_3
    //   637: istore 4
    //   639: iload_1
    //   640: istore_2
    //   641: iload 4
    //   643: ifeq +306 -> 949
    //   646: iconst_m1
    //   647: iload_2
    //   648: if_icmpne +266 -> 914
    //   651: aload_0
    //   652: invokespecial 167	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:a	()V
    //   655: return
    //   656: astore 7
    //   658: aconst_null
    //   659: astore 7
    //   661: aconst_null
    //   662: astore 8
    //   664: aload_0
    //   665: getfield 56	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   668: invokevirtual 312	java/nio/channels/FileChannel:position	()J
    //   671: lstore 5
    //   673: aload_0
    //   674: getfield 56	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   677: lload 5
    //   679: iload_1
    //   680: i2l
    //   681: lsub
    //   682: invokevirtual 315	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   685: pop
    //   686: aload_0
    //   687: getfield 128	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   690: invokevirtual 293	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   693: pop
    //   694: aload_0
    //   695: aload_0
    //   696: getfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   699: iload_1
    //   700: isub
    //   701: putfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   704: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq +35 -> 742
    //   710: ldc 183
    //   712: iconst_2
    //   713: iconst_3
    //   714: anewarray 317	java/lang/Object
    //   717: dup
    //   718: iconst_0
    //   719: ldc_w 319
    //   722: aastore
    //   723: dup
    //   724: iconst_1
    //   725: aload_0
    //   726: getfield 259	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_Int	I
    //   729: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   732: aastore
    //   733: dup
    //   734: iconst_2
    //   735: ldc_w 324
    //   738: aastore
    //   739: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   742: aload 7
    //   744: ifnull +8 -> 752
    //   747: aload 7
    //   749: invokevirtual 328	java/io/DataOutputStream:close	()V
    //   752: aload 8
    //   754: ifnull +367 -> 1121
    //   757: aload 8
    //   759: invokevirtual 331	java/net/HttpURLConnection:disconnect	()V
    //   762: iconst_0
    //   763: istore_3
    //   764: goto -128 -> 636
    //   767: astore 7
    //   769: aconst_null
    //   770: astore 7
    //   772: aload 11
    //   774: astore 8
    //   776: aload 7
    //   778: astore 10
    //   780: aload 8
    //   782: astore 9
    //   784: aload_0
    //   785: iconst_0
    //   786: putfield 51	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_b_of_type_Int	I
    //   789: aload 8
    //   791: ifnull +8 -> 799
    //   794: aload 8
    //   796: invokevirtual 328	java/io/DataOutputStream:close	()V
    //   799: aload 7
    //   801: ifnull +320 -> 1121
    //   804: aload 7
    //   806: invokevirtual 331	java/net/HttpURLConnection:disconnect	()V
    //   809: iconst_0
    //   810: istore_3
    //   811: goto -175 -> 636
    //   814: astore 7
    //   816: iconst_0
    //   817: istore_3
    //   818: aload 10
    //   820: astore 8
    //   822: aload 8
    //   824: ifnull +8 -> 832
    //   827: aload 8
    //   829: invokevirtual 328	java/io/DataOutputStream:close	()V
    //   832: aload 9
    //   834: ifnull +8 -> 842
    //   837: aload 9
    //   839: invokevirtual 331	java/net/HttpURLConnection:disconnect	()V
    //   842: aload 7
    //   844: athrow
    //   845: astore 7
    //   847: iload_1
    //   848: istore_2
    //   849: iload_3
    //   850: istore 4
    //   852: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq -214 -> 641
    //   858: ldc 183
    //   860: iconst_2
    //   861: aload 7
    //   863: iconst_0
    //   864: anewarray 317	java/lang/Object
    //   867: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   870: iload_1
    //   871: istore_2
    //   872: iload_3
    //   873: istore 4
    //   875: goto -234 -> 641
    //   878: iload 4
    //   880: istore_3
    //   881: aload_0
    //   882: getfield 41	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_ComTencentMfsdkReporterIReporter$ReportResultCallback	Lcom/tencent/mfsdk/reporter/IReporter$ReportResultCallback;
    //   885: ifnull -249 -> 636
    //   888: aload_0
    //   889: getfield 41	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_ComTencentMfsdkReporterIReporter$ReportResultCallback	Lcom/tencent/mfsdk/reporter/IReporter$ReportResultCallback;
    //   892: aload_0
    //   893: getfield 35	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:d	I
    //   896: invokeinterface 338 2 0
    //   901: iload 4
    //   903: istore_3
    //   904: goto -268 -> 636
    //   907: astore 7
    //   909: iconst_1
    //   910: istore_3
    //   911: goto -64 -> 847
    //   914: aload_0
    //   915: aload_0
    //   916: getfield 33	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_c_of_type_Int	I
    //   919: iconst_1
    //   920: isub
    //   921: putfield 33	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_c_of_type_Int	I
    //   924: aload_0
    //   925: getfield 33	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_c_of_type_Int	I
    //   928: iflt +16 -> 944
    //   931: aload_0
    //   932: getfield 43	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   935: aload_0
    //   936: ldc2_w 339
    //   939: invokevirtual 346	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   942: pop
    //   943: return
    //   944: aload_0
    //   945: invokespecial 167	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:a	()V
    //   948: return
    //   949: aload_0
    //   950: getfield 51	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_b_of_type_Int	I
    //   953: ifle +36 -> 989
    //   956: aload_0
    //   957: aload_0
    //   958: getfield 33	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_c_of_type_Int	I
    //   961: iconst_1
    //   962: iadd
    //   963: putfield 33	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_c_of_type_Int	I
    //   966: aload_0
    //   967: aload_0
    //   968: getfield 51	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_b_of_type_Int	I
    //   971: iconst_1
    //   972: isub
    //   973: putfield 51	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_b_of_type_Int	I
    //   976: aload_0
    //   977: getfield 43	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   980: aload_0
    //   981: ldc2_w 347
    //   984: invokevirtual 346	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   987: pop
    //   988: return
    //   989: aload_0
    //   990: invokespecial 167	com/tencent/mfsdk/reporter/YunYingFileUploadRunnable:a	()V
    //   993: return
    //   994: astore 7
    //   996: bipush 254
    //   998: istore_1
    //   999: iconst_0
    //   1000: istore_3
    //   1001: goto -154 -> 847
    //   1004: astore 7
    //   1006: goto -159 -> 847
    //   1009: astore 7
    //   1011: iconst_0
    //   1012: istore_3
    //   1013: goto -166 -> 847
    //   1016: astore 7
    //   1018: iconst_0
    //   1019: istore_3
    //   1020: aload 9
    //   1022: astore 8
    //   1024: aload 10
    //   1026: astore 9
    //   1028: goto -206 -> 822
    //   1031: astore 10
    //   1033: iconst_0
    //   1034: istore_3
    //   1035: aload 7
    //   1037: astore 9
    //   1039: aload 10
    //   1041: astore 7
    //   1043: goto -221 -> 822
    //   1046: astore 10
    //   1048: aload 7
    //   1050: astore 9
    //   1052: aload 10
    //   1054: astore 7
    //   1056: goto -234 -> 822
    //   1059: astore 10
    //   1061: iconst_0
    //   1062: istore_3
    //   1063: aload 8
    //   1065: astore 9
    //   1067: aload 7
    //   1069: astore 8
    //   1071: aload 10
    //   1073: astore 7
    //   1075: goto -253 -> 822
    //   1078: astore 8
    //   1080: aload 11
    //   1082: astore 8
    //   1084: goto -308 -> 776
    //   1087: astore 9
    //   1089: goto -313 -> 776
    //   1092: astore 8
    //   1094: aload 7
    //   1096: astore 8
    //   1098: aconst_null
    //   1099: astore 7
    //   1101: goto -437 -> 664
    //   1104: astore 9
    //   1106: aload 7
    //   1108: astore 9
    //   1110: aload 8
    //   1112: astore 7
    //   1114: aload 9
    //   1116: astore 8
    //   1118: goto -454 -> 664
    //   1121: iconst_0
    //   1122: istore_3
    //   1123: goto -487 -> 636
    //   1126: goto -490 -> 636
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1129	0	this	YunYingFileUploadRunnable
    //   79	920	1	i	int
    //   640	232	2	j	int
    //   533	590	3	bool1	boolean
    //   1	901	4	bool2	boolean
    //   545	133	5	l	long
    //   99	533	7	localHttpURLConnection	java.net.HttpURLConnection
    //   656	1	7	localException1	Exception
    //   659	89	7	localObject1	Object
    //   767	1	7	localOutOfMemoryError1	OutOfMemoryError
    //   770	35	7	localObject2	Object
    //   814	29	7	localObject3	Object
    //   845	17	7	localException2	Exception
    //   907	1	7	localException3	Exception
    //   994	1	7	localException4	Exception
    //   1004	1	7	localException5	Exception
    //   1009	1	7	localException6	Exception
    //   1016	20	7	localObject4	Object
    //   1041	72	7	localObject5	Object
    //   63	1007	8	localObject6	Object
    //   1078	1	8	localOutOfMemoryError2	OutOfMemoryError
    //   1082	1	8	localObject7	Object
    //   1092	1	8	localException7	Exception
    //   1096	21	8	localObject8	Object
    //   57	1009	9	localObject9	Object
    //   1087	1	9	localOutOfMemoryError3	OutOfMemoryError
    //   1104	1	9	localException8	Exception
    //   1108	7	9	localObject10	Object
    //   60	965	10	localObject11	Object
    //   1031	9	10	localObject12	Object
    //   1046	7	10	localObject13	Object
    //   1059	13	10	localObject14	Object
    //   66	1015	11	localObject15	Object
    //   396	83	12	str	String
    // Exception table:
    //   from	to	target	type
    //   89	101	656	java/lang/Exception
    //   89	101	767	java/lang/OutOfMemoryError
    //   89	101	814	finally
    //   827	832	845	java/lang/Exception
    //   837	842	845	java/lang/Exception
    //   842	845	845	java/lang/Exception
    //   881	901	907	java/lang/Exception
    //   68	80	994	java/lang/Exception
    //   621	626	1004	java/lang/Exception
    //   631	636	1004	java/lang/Exception
    //   747	752	1009	java/lang/Exception
    //   757	762	1009	java/lang/Exception
    //   794	799	1009	java/lang/Exception
    //   804	809	1009	java/lang/Exception
    //   109	117	1016	finally
    //   125	133	1016	finally
    //   141	147	1016	finally
    //   155	161	1016	finally
    //   169	175	1016	finally
    //   183	190	1016	finally
    //   198	207	1016	finally
    //   215	224	1016	finally
    //   232	243	1016	finally
    //   251	262	1016	finally
    //   270	296	1016	finally
    //   304	313	1016	finally
    //   321	337	1016	finally
    //   345	398	1016	finally
    //   406	416	1016	finally
    //   424	434	1016	finally
    //   442	456	1016	finally
    //   784	789	1016	finally
    //   456	489	1031	finally
    //   489	534	1031	finally
    //   538	616	1046	finally
    //   664	742	1059	finally
    //   109	117	1078	java/lang/OutOfMemoryError
    //   125	133	1078	java/lang/OutOfMemoryError
    //   141	147	1078	java/lang/OutOfMemoryError
    //   155	161	1078	java/lang/OutOfMemoryError
    //   169	175	1078	java/lang/OutOfMemoryError
    //   183	190	1078	java/lang/OutOfMemoryError
    //   198	207	1078	java/lang/OutOfMemoryError
    //   215	224	1078	java/lang/OutOfMemoryError
    //   232	243	1078	java/lang/OutOfMemoryError
    //   251	262	1078	java/lang/OutOfMemoryError
    //   270	296	1078	java/lang/OutOfMemoryError
    //   304	313	1078	java/lang/OutOfMemoryError
    //   321	337	1078	java/lang/OutOfMemoryError
    //   345	398	1078	java/lang/OutOfMemoryError
    //   406	416	1078	java/lang/OutOfMemoryError
    //   424	434	1078	java/lang/OutOfMemoryError
    //   442	456	1078	java/lang/OutOfMemoryError
    //   456	489	1087	java/lang/OutOfMemoryError
    //   489	534	1087	java/lang/OutOfMemoryError
    //   538	616	1087	java/lang/OutOfMemoryError
    //   109	117	1092	java/lang/Exception
    //   125	133	1092	java/lang/Exception
    //   141	147	1092	java/lang/Exception
    //   155	161	1092	java/lang/Exception
    //   169	175	1092	java/lang/Exception
    //   183	190	1092	java/lang/Exception
    //   198	207	1092	java/lang/Exception
    //   215	224	1092	java/lang/Exception
    //   232	243	1092	java/lang/Exception
    //   251	262	1092	java/lang/Exception
    //   270	296	1092	java/lang/Exception
    //   304	313	1092	java/lang/Exception
    //   321	337	1092	java/lang/Exception
    //   345	398	1092	java/lang/Exception
    //   406	416	1092	java/lang/Exception
    //   424	434	1092	java/lang/Exception
    //   442	456	1092	java/lang/Exception
    //   456	489	1104	java/lang/Exception
    //   489	534	1104	java/lang/Exception
    //   538	616	1104	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.YunYingFileUploadRunnable
 * JD-Core Version:    0.7.0.1
 */