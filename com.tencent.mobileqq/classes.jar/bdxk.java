import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;

public class bdxk
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bdxm jdField_a_of_type_Bdxm;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private RandomAccessFile jdField_b_of_type_JavaIoRandomAccessFile;
  private String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  
  public bdxk(AppInterface paramAppInterface, bdxm parambdxm, String paramString1, byte[] paramArrayOfByte1, String paramString2, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bdxm = parambdxm;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
  }
  
  private void a(boolean paramBoolean)
  {
    long l = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
    this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_c_of_type_Long));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_BDH_Cache_Diff", String.valueOf(this.jdField_a_of_type_Boolean));
    if (paramBoolean) {
      bctj.a(BaseApplication.getContext()).a(null, "PtvGuideUpload", true, l, this.jdField_b_of_type_Long + this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    while (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null)
        {
          localStringBuilder.append("&");
          localStringBuilder.append(str);
          localStringBuilder.append("=");
          localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_d_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.f);
      bctj.a(BaseApplication.getContext()).a(null, "PtvGuideUpload", false, l, this.jdField_b_of_type_Long + this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          this.jdField_d_of_type_Int = 9303;
          this.f = "read thumb file error";
          this.jdField_a_of_type_Bdxm.a(this.jdField_d_of_type_Int, this.f);
          a(false);
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          localFileNotFoundException1.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_b_of_type_JavaLangString, "r");
        if (this.jdField_b_of_type_JavaIoRandomAccessFile == null)
        {
          this.jdField_d_of_type_Int = 9303;
          this.f = "read video file error";
          this.jdField_a_of_type_Bdxm.a(this.jdField_d_of_type_Int, this.f);
          a(false);
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          localFileNotFoundException2.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    return true;
  }
  
  public int a(String paramString)
  {
    int i = -1;
    if ("avi".equals(paramString)) {
      i = 2;
    }
    do
    {
      return i;
      if ("mp4".equals(paramString)) {
        return 3;
      }
      if ("wmv".equals(paramString)) {
        return 4;
      }
      if ("mkv".equals(paramString)) {
        return 5;
      }
      if ("rmvb".equals(paramString)) {
        return 6;
      }
      if ("rm".equals(paramString)) {
        return 7;
      }
      if ("afs".equals(paramString)) {
        return 8;
      }
      if ("mov".equals(paramString)) {
        return 9;
      }
      if ("mod".equals(paramString)) {
        return 10;
      }
      if ("ts".equals(paramString)) {
        return 1;
      }
    } while (!"mts".equals(paramString));
    return 11;
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_0
    //   12: getfield 43	bdxk:jdField_a_of_type_ArrayOfByte	[B
    //   15: arraylength
    //   16: aload_0
    //   17: getfield 41	bdxk:jdField_b_of_type_ArrayOfByte	[B
    //   20: arraylength
    //   21: iadd
    //   22: newarray byte
    //   24: astore_2
    //   25: aload_0
    //   26: getfield 43	bdxk:jdField_a_of_type_ArrayOfByte	[B
    //   29: iconst_0
    //   30: aload_2
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 43	bdxk:jdField_a_of_type_ArrayOfByte	[B
    //   36: arraylength
    //   37: invokestatic 250	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   40: aload_0
    //   41: getfield 41	bdxk:jdField_b_of_type_ArrayOfByte	[B
    //   44: iconst_0
    //   45: aload_2
    //   46: aload_0
    //   47: getfield 43	bdxk:jdField_a_of_type_ArrayOfByte	[B
    //   50: arraylength
    //   51: aload_0
    //   52: getfield 41	bdxk:jdField_b_of_type_ArrayOfByte	[B
    //   55: arraylength
    //   56: invokestatic 250	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   59: new 148	java/lang/StringBuilder
    //   62: dup
    //   63: invokestatic 254	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   66: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_2
    //   70: invokestatic 115	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   73: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 259
    //   79: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 8
    //   87: aload_0
    //   88: getfield 194	bdxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   91: invokevirtual 265	java/io/RandomAccessFile:length	()J
    //   94: l2i
    //   95: newarray byte
    //   97: astore_2
    //   98: aload_0
    //   99: getfield 213	bdxk:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   102: invokevirtual 265	java/io/RandomAccessFile:length	()J
    //   105: l2i
    //   106: newarray byte
    //   108: astore 4
    //   110: aload_0
    //   111: getfield 194	bdxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   114: invokevirtual 265	java/io/RandomAccessFile:length	()J
    //   117: aload_0
    //   118: getfield 213	bdxk:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   121: invokevirtual 265	java/io/RandomAccessFile:length	()J
    //   124: ladd
    //   125: l2i
    //   126: newarray byte
    //   128: astore 9
    //   130: aload_0
    //   131: getfield 194	bdxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   134: aload_2
    //   135: invokevirtual 269	java/io/RandomAccessFile:read	([B)I
    //   138: pop
    //   139: aload_0
    //   140: getfield 213	bdxk:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   143: aload 4
    //   145: invokevirtual 269	java/io/RandomAccessFile:read	([B)I
    //   148: pop
    //   149: aload_2
    //   150: iconst_0
    //   151: aload 9
    //   153: iconst_0
    //   154: aload_2
    //   155: arraylength
    //   156: invokestatic 250	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   159: aload 4
    //   161: iconst_0
    //   162: aload 9
    //   164: aload_2
    //   165: arraylength
    //   166: aload 4
    //   168: arraylength
    //   169: invokestatic 250	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   172: new 271	java/io/File
    //   175: dup
    //   176: aload 8
    //   178: invokespecial 272	java/io/File:<init>	(Ljava/lang/String;)V
    //   181: invokevirtual 275	java/io/File:delete	()Z
    //   184: pop
    //   185: new 271	java/io/File
    //   188: dup
    //   189: aload 8
    //   191: invokespecial 272	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: astore_2
    //   195: aload_2
    //   196: invokevirtual 278	java/io/File:exists	()Z
    //   199: istore_1
    //   200: iload_1
    //   201: ifne +8 -> 209
    //   204: aload_2
    //   205: invokevirtual 281	java/io/File:createNewFile	()Z
    //   208: pop
    //   209: new 283	java/io/FileOutputStream
    //   212: dup
    //   213: aload_2
    //   214: invokespecial 286	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   217: astore_2
    //   218: new 288	java/io/BufferedOutputStream
    //   221: dup
    //   222: aload_2
    //   223: invokespecial 291	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   226: astore 4
    //   228: aload 4
    //   230: aload 9
    //   232: invokevirtual 295	java/io/BufferedOutputStream:write	([B)V
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 298	java/io/BufferedOutputStream:close	()V
    //   245: aload_2
    //   246: ifnull +7 -> 253
    //   249: aload_2
    //   250: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   253: aload 8
    //   255: areturn
    //   256: astore 4
    //   258: aload 4
    //   260: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   263: goto -54 -> 209
    //   266: astore 4
    //   268: aconst_null
    //   269: astore_2
    //   270: aload 4
    //   272: invokevirtual 211	java/io/FileNotFoundException:printStackTrace	()V
    //   275: aload_2
    //   276: ifnull +7 -> 283
    //   279: aload_2
    //   280: invokevirtual 298	java/io/BufferedOutputStream:close	()V
    //   283: aload_3
    //   284: ifnull -31 -> 253
    //   287: aload_3
    //   288: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   291: aload 8
    //   293: areturn
    //   294: astore_2
    //   295: aload_2
    //   296: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   299: aload 8
    //   301: areturn
    //   302: astore_3
    //   303: aload_3
    //   304: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   307: goto -62 -> 245
    //   310: astore_2
    //   311: aload_2
    //   312: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   315: aload 8
    //   317: areturn
    //   318: astore_2
    //   319: aload_2
    //   320: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   323: goto -40 -> 283
    //   326: astore 6
    //   328: aconst_null
    //   329: astore 4
    //   331: aload 5
    //   333: astore_2
    //   334: aload_2
    //   335: astore_3
    //   336: aload 4
    //   338: astore 5
    //   340: aload 6
    //   342: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   345: aload 4
    //   347: ifnull +8 -> 355
    //   350: aload 4
    //   352: invokevirtual 298	java/io/BufferedOutputStream:close	()V
    //   355: aload_2
    //   356: ifnull -103 -> 253
    //   359: aload_2
    //   360: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   363: aload 8
    //   365: areturn
    //   366: astore_2
    //   367: aload_2
    //   368: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   371: aload 8
    //   373: areturn
    //   374: astore_3
    //   375: aload_3
    //   376: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   379: goto -24 -> 355
    //   382: astore_3
    //   383: aconst_null
    //   384: astore 4
    //   386: aload 6
    //   388: astore_2
    //   389: aload_3
    //   390: astore 6
    //   392: aload_2
    //   393: astore_3
    //   394: aload 4
    //   396: astore 5
    //   398: aload 6
    //   400: invokevirtual 301	java/lang/OutOfMemoryError:printStackTrace	()V
    //   403: aload 4
    //   405: ifnull +8 -> 413
    //   408: aload 4
    //   410: invokevirtual 298	java/io/BufferedOutputStream:close	()V
    //   413: aload_2
    //   414: ifnull -161 -> 253
    //   417: aload_2
    //   418: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   421: aload 8
    //   423: areturn
    //   424: astore_2
    //   425: aload_2
    //   426: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   429: aload 8
    //   431: areturn
    //   432: astore_3
    //   433: aload_3
    //   434: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   437: goto -24 -> 413
    //   440: astore_2
    //   441: aconst_null
    //   442: astore 4
    //   444: aload 7
    //   446: astore_3
    //   447: aload 4
    //   449: ifnull +8 -> 457
    //   452: aload 4
    //   454: invokevirtual 298	java/io/BufferedOutputStream:close	()V
    //   457: aload_3
    //   458: ifnull +7 -> 465
    //   461: aload_3
    //   462: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   465: aload_2
    //   466: athrow
    //   467: astore 4
    //   469: aload 4
    //   471: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   474: goto -17 -> 457
    //   477: astore_3
    //   478: aload_3
    //   479: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   482: goto -17 -> 465
    //   485: astore 5
    //   487: aconst_null
    //   488: astore 4
    //   490: aload_2
    //   491: astore_3
    //   492: aload 5
    //   494: astore_2
    //   495: goto -48 -> 447
    //   498: astore 5
    //   500: aload_2
    //   501: astore_3
    //   502: aload 5
    //   504: astore_2
    //   505: goto -58 -> 447
    //   508: astore 5
    //   510: aload_2
    //   511: astore 4
    //   513: aload 5
    //   515: astore_2
    //   516: goto -69 -> 447
    //   519: astore_2
    //   520: aload 5
    //   522: astore 4
    //   524: goto -77 -> 447
    //   527: astore 6
    //   529: aconst_null
    //   530: astore 4
    //   532: goto -140 -> 392
    //   535: astore 6
    //   537: goto -145 -> 392
    //   540: astore 6
    //   542: aconst_null
    //   543: astore 4
    //   545: goto -211 -> 334
    //   548: astore 6
    //   550: goto -216 -> 334
    //   553: astore 4
    //   555: aconst_null
    //   556: astore 5
    //   558: aload_2
    //   559: astore_3
    //   560: aload 5
    //   562: astore_2
    //   563: goto -293 -> 270
    //   566: astore_3
    //   567: aload 4
    //   569: astore 5
    //   571: aload_3
    //   572: astore 4
    //   574: aload_2
    //   575: astore_3
    //   576: aload 5
    //   578: astore_2
    //   579: goto -309 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	bdxk
    //   199	2	1	bool	boolean
    //   24	256	2	localObject1	Object
    //   294	2	2	localIOException1	java.io.IOException
    //   310	2	2	localIOException2	java.io.IOException
    //   318	2	2	localIOException3	java.io.IOException
    //   333	27	2	localObject2	Object
    //   366	2	2	localIOException4	java.io.IOException
    //   388	30	2	localIOException5	java.io.IOException
    //   424	2	2	localIOException6	java.io.IOException
    //   440	51	2	localObject3	Object
    //   494	22	2	localObject4	Object
    //   519	40	2	localObject5	Object
    //   562	17	2	localObject6	Object
    //   10	278	3	localObject7	Object
    //   302	2	3	localIOException7	java.io.IOException
    //   335	1	3	localObject8	Object
    //   374	2	3	localIOException8	java.io.IOException
    //   382	8	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   393	1	3	localObject9	Object
    //   432	2	3	localIOException9	java.io.IOException
    //   446	16	3	localObject10	Object
    //   477	2	3	localIOException10	java.io.IOException
    //   491	69	3	localObject11	Object
    //   566	6	3	localFileNotFoundException1	FileNotFoundException
    //   575	1	3	localObject12	Object
    //   108	133	4	localObject13	Object
    //   256	3	4	localIOException11	java.io.IOException
    //   266	5	4	localFileNotFoundException2	FileNotFoundException
    //   329	124	4	localObject14	Object
    //   467	3	4	localIOException12	java.io.IOException
    //   488	56	4	localObject15	Object
    //   553	15	4	localFileNotFoundException3	FileNotFoundException
    //   572	1	4	localFileNotFoundException4	FileNotFoundException
    //   1	396	5	localObject16	Object
    //   485	8	5	localObject17	Object
    //   498	5	5	localObject18	Object
    //   508	13	5	localObject19	Object
    //   556	21	5	localObject20	Object
    //   4	1	6	localObject21	Object
    //   326	61	6	localIOException13	java.io.IOException
    //   390	9	6	localObject22	Object
    //   527	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   535	1	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   540	1	6	localIOException14	java.io.IOException
    //   548	1	6	localIOException15	java.io.IOException
    //   7	438	7	localObject23	Object
    //   85	345	8	str	String
    //   128	103	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   204	209	256	java/io/IOException
    //   87	200	266	java/io/FileNotFoundException
    //   204	209	266	java/io/FileNotFoundException
    //   209	218	266	java/io/FileNotFoundException
    //   258	263	266	java/io/FileNotFoundException
    //   287	291	294	java/io/IOException
    //   240	245	302	java/io/IOException
    //   249	253	310	java/io/IOException
    //   279	283	318	java/io/IOException
    //   87	200	326	java/io/IOException
    //   209	218	326	java/io/IOException
    //   258	263	326	java/io/IOException
    //   359	363	366	java/io/IOException
    //   350	355	374	java/io/IOException
    //   87	200	382	java/lang/OutOfMemoryError
    //   204	209	382	java/lang/OutOfMemoryError
    //   209	218	382	java/lang/OutOfMemoryError
    //   258	263	382	java/lang/OutOfMemoryError
    //   417	421	424	java/io/IOException
    //   408	413	432	java/io/IOException
    //   87	200	440	finally
    //   204	209	440	finally
    //   209	218	440	finally
    //   258	263	440	finally
    //   452	457	467	java/io/IOException
    //   461	465	477	java/io/IOException
    //   218	228	485	finally
    //   228	235	498	finally
    //   270	275	508	finally
    //   340	345	519	finally
    //   398	403	519	finally
    //   218	228	527	java/lang/OutOfMemoryError
    //   228	235	535	java/lang/OutOfMemoryError
    //   218	228	540	java/io/IOException
    //   228	235	548	java/io/IOException
    //   218	228	553	java/io/FileNotFoundException
    //   228	235	566	java/io/FileNotFoundException
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> doUpload ");
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (!b()) {
      return false;
    }
    String str1 = a();
    Object localObject1 = new PttShortVideo.PttShortVideoUploadReq();
    ((PttShortVideo.PttShortVideoUploadReq)localObject1).setHasFlag(true);
    ((PttShortVideo.PttShortVideoUploadReq)localObject1).uint64_fromuin.set(Long.parseLong(this.jdField_c_of_type_JavaLangString));
    ((PttShortVideo.PttShortVideoUploadReq)localObject1).uint64_touin.set(255L);
    ((PttShortVideo.PttShortVideoUploadReq)localObject1).uint32_chat_type.set(1);
    ((PttShortVideo.PttShortVideoUploadReq)localObject1).uint32_client_type.set(2);
    ((PttShortVideo.PttShortVideoUploadReq)localObject1).uint64_group_code.set(0L);
    ((PttShortVideo.PttShortVideoUploadReq)localObject1).uint32_agent_type.set(0);
    ((PttShortVideo.PttShortVideoUploadReq)localObject1).uint32_business_type.set(2);
    Object localObject2 = new PttShortVideo.PttShortVideoFileInfo();
    File localFile = new File(this.jdField_b_of_type_JavaLangString);
    String str2 = localFile.getName();
    ((PttShortVideo.PttShortVideoFileInfo)localObject2).str_file_name.set(str2);
    ((PttShortVideo.PttShortVideoFileInfo)localObject2).bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
    ((PttShortVideo.PttShortVideoFileInfo)localObject2).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
    ((PttShortVideo.PttShortVideoFileInfo)localObject2).uint64_file_size.set(localFile.length());
    this.jdField_b_of_type_Long = localFile.length();
    ((PttShortVideo.PttShortVideoFileInfo)localObject2).uint32_file_res_length.set(this.jdField_b_of_type_Int);
    ((PttShortVideo.PttShortVideoFileInfo)localObject2).uint32_file_res_width.set(this.jdField_a_of_type_Int);
    int i = a(str2.substring(str2.lastIndexOf(".") + 1));
    ((PttShortVideo.PttShortVideoFileInfo)localObject2).uint32_file_format.set(i);
    ((PttShortVideo.PttShortVideoFileInfo)localObject2).uint32_file_time.set(this.jdField_c_of_type_Int);
    localFile = new File(this.jdField_a_of_type_JavaLangString);
    ((PttShortVideo.PttShortVideoFileInfo)localObject2).uint64_thumb_file_size.set(localFile.length());
    this.jdField_c_of_type_Long = localFile.length();
    ((PttShortVideo.PttShortVideoUploadReq)localObject1).msg_PttShortVideoFileInfo.set((MessageMicro)localObject2);
    localObject1 = ((PttShortVideo.PttShortVideoUploadReq)localObject1).toByteArray();
    localObject2 = new bdxl(this, str1);
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_c_of_type_JavaLangString, 12, str1, 0, this.jdField_b_of_type_ArrayOfByte, (ITransactionCallback)localObject2, (byte[])localObject1, true);
    i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " MD5:" + HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte) + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 12);
    }
    if (i != 0)
    {
      this.jdField_d_of_type_Int = i;
      this.f = "SubmitError";
      this.jdField_a_of_type_Bdxm.a(this.jdField_d_of_type_Int, this.f);
      a(false);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxk
 * JD-Core Version:    0.7.0.1
 */