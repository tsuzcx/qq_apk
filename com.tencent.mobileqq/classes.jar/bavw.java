import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bavw
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bavy jdField_a_of_type_Bavy;
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
  
  public bavw(AppInterface paramAppInterface, bavy parambavy, String paramString1, byte[] paramArrayOfByte1, String paramString2, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bavy = parambavy;
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
      azri.a(BaseApplication.getContext()).a(null, "PtvGuideUpload", true, l, this.jdField_b_of_type_Long + this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      azri.a(BaseApplication.getContext()).a(null, "PtvGuideUpload", false, l, this.jdField_b_of_type_Long + this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 4
    //   12: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 198
    //   20: iconst_2
    //   21: ldc 200
    //   23: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_0
    //   27: invokestatic 208	android/os/SystemClock:uptimeMillis	()J
    //   30: putfield 64	bavw:jdField_a_of_type_Long	J
    //   33: aload_0
    //   34: getfield 210	bavw:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   37: ifnonnull +77 -> 114
    //   40: aload_0
    //   41: new 212	java/io/RandomAccessFile
    //   44: dup
    //   45: aload_0
    //   46: getfield 39	bavw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: ldc 214
    //   51: invokespecial 217	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: putfield 210	bavw:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   57: aload_0
    //   58: getfield 210	bavw:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   61: ifnonnull +53 -> 114
    //   64: aload_0
    //   65: sipush 9303
    //   68: putfield 61	bavw:jdField_d_of_type_Int	I
    //   71: aload_0
    //   72: ldc 219
    //   74: putfield 189	bavw:f	Ljava/lang/String;
    //   77: aload_0
    //   78: getfield 35	bavw:jdField_a_of_type_Bavy	Lbavy;
    //   81: aload_0
    //   82: getfield 61	bavw:jdField_d_of_type_Int	I
    //   85: aload_0
    //   86: getfield 189	bavw:f	Ljava/lang/String;
    //   89: invokeinterface 224 3 0
    //   94: aload_0
    //   95: iconst_0
    //   96: invokespecial 79	bavw:a	(Z)V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_3
    //   102: aload_3
    //   103: invokevirtual 227	java/io/FileNotFoundException:printStackTrace	()V
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 210	bavw:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   111: goto -54 -> 57
    //   114: aload_0
    //   115: getfield 229	bavw:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   118: ifnonnull +77 -> 195
    //   121: aload_0
    //   122: new 212	java/io/RandomAccessFile
    //   125: dup
    //   126: aload_0
    //   127: getfield 37	bavw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   130: ldc 214
    //   132: invokespecial 217	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: putfield 229	bavw:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   138: aload_0
    //   139: getfield 229	bavw:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   142: ifnonnull +53 -> 195
    //   145: aload_0
    //   146: sipush 9303
    //   149: putfield 61	bavw:jdField_d_of_type_Int	I
    //   152: aload_0
    //   153: ldc 231
    //   155: putfield 189	bavw:f	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 35	bavw:jdField_a_of_type_Bavy	Lbavy;
    //   162: aload_0
    //   163: getfield 61	bavw:jdField_d_of_type_Int	I
    //   166: aload_0
    //   167: getfield 189	bavw:f	Ljava/lang/String;
    //   170: invokeinterface 224 3 0
    //   175: aload_0
    //   176: iconst_0
    //   177: invokespecial 79	bavw:a	(Z)V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_3
    //   183: aload_3
    //   184: invokevirtual 227	java/io/FileNotFoundException:printStackTrace	()V
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 229	bavw:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   192: goto -54 -> 138
    //   195: aload_0
    //   196: getfield 43	bavw:jdField_a_of_type_ArrayOfByte	[B
    //   199: arraylength
    //   200: aload_0
    //   201: getfield 41	bavw:jdField_b_of_type_ArrayOfByte	[B
    //   204: arraylength
    //   205: iadd
    //   206: newarray byte
    //   208: astore_3
    //   209: aload_0
    //   210: getfield 43	bavw:jdField_a_of_type_ArrayOfByte	[B
    //   213: iconst_0
    //   214: aload_3
    //   215: iconst_0
    //   216: aload_0
    //   217: getfield 43	bavw:jdField_a_of_type_ArrayOfByte	[B
    //   220: arraylength
    //   221: invokestatic 235	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   224: aload_0
    //   225: getfield 41	bavw:jdField_b_of_type_ArrayOfByte	[B
    //   228: iconst_0
    //   229: aload_3
    //   230: aload_0
    //   231: getfield 43	bavw:jdField_a_of_type_ArrayOfByte	[B
    //   234: arraylength
    //   235: aload_0
    //   236: getfield 41	bavw:jdField_b_of_type_ArrayOfByte	[B
    //   239: arraylength
    //   240: invokestatic 235	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   243: new 148	java/lang/StringBuilder
    //   246: dup
    //   247: invokestatic 239	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   250: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_3
    //   254: invokestatic 115	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   257: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 244
    //   262: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: astore 9
    //   270: aload_0
    //   271: getfield 210	bavw:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   274: invokevirtual 250	java/io/RandomAccessFile:length	()J
    //   277: l2i
    //   278: newarray byte
    //   280: astore_3
    //   281: aload_0
    //   282: getfield 229	bavw:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   285: invokevirtual 250	java/io/RandomAccessFile:length	()J
    //   288: l2i
    //   289: newarray byte
    //   291: astore 5
    //   293: aload_0
    //   294: getfield 210	bavw:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   297: invokevirtual 250	java/io/RandomAccessFile:length	()J
    //   300: aload_0
    //   301: getfield 229	bavw:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   304: invokevirtual 250	java/io/RandomAccessFile:length	()J
    //   307: ladd
    //   308: l2i
    //   309: newarray byte
    //   311: astore 10
    //   313: aload_0
    //   314: getfield 210	bavw:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   317: aload_3
    //   318: invokevirtual 254	java/io/RandomAccessFile:read	([B)I
    //   321: pop
    //   322: aload_0
    //   323: getfield 229	bavw:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   326: aload 5
    //   328: invokevirtual 254	java/io/RandomAccessFile:read	([B)I
    //   331: pop
    //   332: aload_3
    //   333: iconst_0
    //   334: aload 10
    //   336: iconst_0
    //   337: aload_3
    //   338: arraylength
    //   339: invokestatic 235	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   342: aload 5
    //   344: iconst_0
    //   345: aload 10
    //   347: aload_3
    //   348: arraylength
    //   349: aload 5
    //   351: arraylength
    //   352: invokestatic 235	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   355: new 256	java/io/File
    //   358: dup
    //   359: aload 9
    //   361: invokespecial 257	java/io/File:<init>	(Ljava/lang/String;)V
    //   364: invokevirtual 260	java/io/File:delete	()Z
    //   367: pop
    //   368: new 256	java/io/File
    //   371: dup
    //   372: aload 9
    //   374: invokespecial 257	java/io/File:<init>	(Ljava/lang/String;)V
    //   377: astore_3
    //   378: aload_3
    //   379: invokevirtual 263	java/io/File:exists	()Z
    //   382: istore_2
    //   383: iload_2
    //   384: ifne +8 -> 392
    //   387: aload_3
    //   388: invokevirtual 266	java/io/File:createNewFile	()Z
    //   391: pop
    //   392: new 268	java/io/FileOutputStream
    //   395: dup
    //   396: aload_3
    //   397: invokespecial 271	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   400: astore_3
    //   401: new 273	java/io/BufferedOutputStream
    //   404: dup
    //   405: aload_3
    //   406: invokespecial 276	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   409: astore 5
    //   411: aload 5
    //   413: aload 10
    //   415: invokevirtual 280	java/io/BufferedOutputStream:write	([B)V
    //   418: aload 5
    //   420: ifnull +8 -> 428
    //   423: aload 5
    //   425: invokevirtual 283	java/io/BufferedOutputStream:close	()V
    //   428: aload_3
    //   429: ifnull +7 -> 436
    //   432: aload_3
    //   433: invokevirtual 284	java/io/FileOutputStream:close	()V
    //   436: new 286	pttcenterservice/PttShortVideo$PttShortVideoUploadReq
    //   439: dup
    //   440: invokespecial 287	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:<init>	()V
    //   443: astore_3
    //   444: aload_3
    //   445: iconst_1
    //   446: invokevirtual 290	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:setHasFlag	(Z)V
    //   449: aload_3
    //   450: getfield 294	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_fromuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   453: aload_0
    //   454: getfield 57	bavw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   457: invokestatic 300	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   460: invokevirtual 306	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   463: aload_3
    //   464: getfield 309	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_touin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   467: ldc2_w 310
    //   470: invokevirtual 306	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   473: aload_3
    //   474: getfield 315	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_chat_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   477: iconst_1
    //   478: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   481: aload_3
    //   482: getfield 323	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   485: iconst_2
    //   486: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   489: aload_3
    //   490: getfield 326	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   493: lconst_0
    //   494: invokevirtual 306	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   497: aload_3
    //   498: getfield 329	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_agent_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   501: iconst_0
    //   502: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   505: aload_3
    //   506: getfield 332	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   509: iconst_2
    //   510: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   513: new 334	pttcenterservice/PttShortVideo$PttShortVideoFileInfo
    //   516: dup
    //   517: invokespecial 335	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:<init>	()V
    //   520: astore 4
    //   522: new 256	java/io/File
    //   525: dup
    //   526: aload_0
    //   527: getfield 37	bavw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   530: invokespecial 257	java/io/File:<init>	(Ljava/lang/String;)V
    //   533: astore 5
    //   535: aload 5
    //   537: invokevirtual 338	java/io/File:getName	()Ljava/lang/String;
    //   540: astore 6
    //   542: aload 4
    //   544: getfield 342	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   547: aload 6
    //   549: invokevirtual 346	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   552: aload 4
    //   554: getfield 350	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   557: aload_0
    //   558: getfield 41	bavw:jdField_b_of_type_ArrayOfByte	[B
    //   561: invokestatic 356	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   564: invokevirtual 361	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   567: aload 4
    //   569: getfield 364	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   572: aload_0
    //   573: getfield 43	bavw:jdField_a_of_type_ArrayOfByte	[B
    //   576: invokestatic 356	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   579: invokevirtual 361	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   582: aload 4
    //   584: getfield 367	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   587: aload 5
    //   589: invokevirtual 368	java/io/File:length	()J
    //   592: invokevirtual 306	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   595: aload_0
    //   596: aload 5
    //   598: invokevirtual 368	java/io/File:length	()J
    //   601: putfield 97	bavw:jdField_b_of_type_Long	J
    //   604: aload 4
    //   606: getfield 371	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_length	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   609: aload_0
    //   610: getfield 47	bavw:jdField_b_of_type_Int	I
    //   613: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   616: aload 4
    //   618: getfield 374	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   621: aload_0
    //   622: getfield 45	bavw:jdField_a_of_type_Int	I
    //   625: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   628: aload 6
    //   630: aload 6
    //   632: ldc_w 376
    //   635: invokevirtual 380	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   638: iconst_1
    //   639: iadd
    //   640: invokevirtual 383	java/lang/String:substring	(I)Ljava/lang/String;
    //   643: astore 5
    //   645: iconst_m1
    //   646: istore_1
    //   647: ldc_w 385
    //   650: aload 5
    //   652: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   655: ifeq +507 -> 1162
    //   658: iconst_2
    //   659: istore_1
    //   660: aload 4
    //   662: getfield 392	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   665: iload_1
    //   666: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   669: aload 4
    //   671: getfield 395	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   674: aload_0
    //   675: getfield 49	bavw:jdField_c_of_type_Int	I
    //   678: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   681: new 256	java/io/File
    //   684: dup
    //   685: aload_0
    //   686: getfield 39	bavw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   689: invokespecial 257	java/io/File:<init>	(Ljava/lang/String;)V
    //   692: astore 5
    //   694: aload 4
    //   696: getfield 398	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   699: aload 5
    //   701: invokevirtual 368	java/io/File:length	()J
    //   704: invokevirtual 306	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   707: aload_0
    //   708: aload 5
    //   710: invokevirtual 368	java/io/File:length	()J
    //   713: putfield 107	bavw:jdField_c_of_type_Long	J
    //   716: aload_3
    //   717: getfield 402	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:msg_PttShortVideoFileInfo	Lpttcenterservice/PttShortVideo$PttShortVideoFileInfo;
    //   720: aload 4
    //   722: invokevirtual 405	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   725: aload_3
    //   726: invokevirtual 409	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:toByteArray	()[B
    //   729: astore_3
    //   730: new 411	bavx
    //   733: dup
    //   734: aload_0
    //   735: aload 9
    //   737: invokespecial 414	bavx:<init>	(Lbavw;Ljava/lang/String;)V
    //   740: astore 4
    //   742: aload_0
    //   743: new 416	com/tencent/mobileqq/highway/transaction/Transaction
    //   746: dup
    //   747: aload_0
    //   748: getfield 57	bavw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   751: bipush 12
    //   753: aload 9
    //   755: iconst_0
    //   756: aload_0
    //   757: getfield 41	bavw:jdField_b_of_type_ArrayOfByte	[B
    //   760: aload 4
    //   762: aload_3
    //   763: iconst_1
    //   764: invokespecial 419	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[BZ)V
    //   767: putfield 68	bavw:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   770: aload_0
    //   771: getfield 33	bavw:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   774: invokevirtual 423	com/tencent/common/app/AppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   777: aload_0
    //   778: getfield 68	bavw:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   781: invokevirtual 429	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   784: istore_1
    //   785: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   788: ifeq +88 -> 876
    //   791: ldc 198
    //   793: iconst_2
    //   794: new 148	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   801: ldc_w 431
    //   804: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: iload_1
    //   808: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   811: ldc_w 436
    //   814: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: aload_0
    //   818: getfield 68	bavw:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   821: invokevirtual 440	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   824: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   827: ldc_w 442
    //   830: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload_0
    //   834: getfield 41	bavw:jdField_b_of_type_ArrayOfByte	[B
    //   837: invokestatic 115	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   840: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: ldc_w 444
    //   846: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_0
    //   850: getfield 68	bavw:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   853: getfield 447	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   856: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: ldc_w 449
    //   862: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: bipush 12
    //   867: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   870: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: iload_1
    //   877: ifeq +451 -> 1328
    //   880: aload_0
    //   881: iload_1
    //   882: putfield 61	bavw:jdField_d_of_type_Int	I
    //   885: aload_0
    //   886: ldc_w 451
    //   889: putfield 189	bavw:f	Ljava/lang/String;
    //   892: aload_0
    //   893: getfield 35	bavw:jdField_a_of_type_Bavy	Lbavy;
    //   896: aload_0
    //   897: getfield 61	bavw:jdField_d_of_type_Int	I
    //   900: aload_0
    //   901: getfield 189	bavw:f	Ljava/lang/String;
    //   904: invokeinterface 224 3 0
    //   909: aload_0
    //   910: iconst_0
    //   911: invokespecial 79	bavw:a	(Z)V
    //   914: iconst_0
    //   915: ireturn
    //   916: astore 5
    //   918: aload 5
    //   920: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   923: goto -531 -> 392
    //   926: astore 5
    //   928: aconst_null
    //   929: astore_3
    //   930: aload 5
    //   932: invokevirtual 227	java/io/FileNotFoundException:printStackTrace	()V
    //   935: aload_3
    //   936: ifnull +7 -> 943
    //   939: aload_3
    //   940: invokevirtual 283	java/io/BufferedOutputStream:close	()V
    //   943: aload 4
    //   945: ifnull -509 -> 436
    //   948: aload 4
    //   950: invokevirtual 284	java/io/FileOutputStream:close	()V
    //   953: goto -517 -> 436
    //   956: astore_3
    //   957: aload_3
    //   958: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   961: goto -525 -> 436
    //   964: astore 4
    //   966: aload 4
    //   968: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   971: goto -543 -> 428
    //   974: astore_3
    //   975: aload_3
    //   976: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   979: goto -543 -> 436
    //   982: astore_3
    //   983: aload_3
    //   984: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   987: goto -44 -> 943
    //   990: astore 7
    //   992: aconst_null
    //   993: astore 5
    //   995: aload 6
    //   997: astore_3
    //   998: aload_3
    //   999: astore 4
    //   1001: aload 5
    //   1003: astore 6
    //   1005: aload 7
    //   1007: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   1010: aload 5
    //   1012: ifnull +8 -> 1020
    //   1015: aload 5
    //   1017: invokevirtual 283	java/io/BufferedOutputStream:close	()V
    //   1020: aload_3
    //   1021: ifnull -585 -> 436
    //   1024: aload_3
    //   1025: invokevirtual 284	java/io/FileOutputStream:close	()V
    //   1028: goto -592 -> 436
    //   1031: astore_3
    //   1032: aload_3
    //   1033: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   1036: goto -600 -> 436
    //   1039: astore 4
    //   1041: aload 4
    //   1043: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   1046: goto -26 -> 1020
    //   1049: astore 4
    //   1051: aconst_null
    //   1052: astore 5
    //   1054: aload 7
    //   1056: astore_3
    //   1057: aload 4
    //   1059: astore 7
    //   1061: aload_3
    //   1062: astore 4
    //   1064: aload 5
    //   1066: astore 6
    //   1068: aload 7
    //   1070: invokevirtual 453	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1073: aload 5
    //   1075: ifnull +8 -> 1083
    //   1078: aload 5
    //   1080: invokevirtual 283	java/io/BufferedOutputStream:close	()V
    //   1083: aload_3
    //   1084: ifnull -648 -> 436
    //   1087: aload_3
    //   1088: invokevirtual 284	java/io/FileOutputStream:close	()V
    //   1091: goto -655 -> 436
    //   1094: astore_3
    //   1095: aload_3
    //   1096: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   1099: goto -663 -> 436
    //   1102: astore 4
    //   1104: aload 4
    //   1106: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   1109: goto -26 -> 1083
    //   1112: astore_3
    //   1113: aconst_null
    //   1114: astore 5
    //   1116: aload 8
    //   1118: astore 4
    //   1120: aload 5
    //   1122: ifnull +8 -> 1130
    //   1125: aload 5
    //   1127: invokevirtual 283	java/io/BufferedOutputStream:close	()V
    //   1130: aload 4
    //   1132: ifnull +8 -> 1140
    //   1135: aload 4
    //   1137: invokevirtual 284	java/io/FileOutputStream:close	()V
    //   1140: aload_3
    //   1141: athrow
    //   1142: astore 5
    //   1144: aload 5
    //   1146: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   1149: goto -19 -> 1130
    //   1152: astore 4
    //   1154: aload 4
    //   1156: invokevirtual 452	java/io/IOException:printStackTrace	()V
    //   1159: goto -19 -> 1140
    //   1162: ldc_w 455
    //   1165: aload 5
    //   1167: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1170: ifeq +8 -> 1178
    //   1173: iconst_3
    //   1174: istore_1
    //   1175: goto -515 -> 660
    //   1178: ldc_w 457
    //   1181: aload 5
    //   1183: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1186: ifeq +8 -> 1194
    //   1189: iconst_4
    //   1190: istore_1
    //   1191: goto -531 -> 660
    //   1194: ldc_w 459
    //   1197: aload 5
    //   1199: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1202: ifeq +8 -> 1210
    //   1205: iconst_5
    //   1206: istore_1
    //   1207: goto -547 -> 660
    //   1210: ldc_w 461
    //   1213: aload 5
    //   1215: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1218: ifeq +9 -> 1227
    //   1221: bipush 6
    //   1223: istore_1
    //   1224: goto -564 -> 660
    //   1227: ldc_w 463
    //   1230: aload 5
    //   1232: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1235: ifeq +9 -> 1244
    //   1238: bipush 7
    //   1240: istore_1
    //   1241: goto -581 -> 660
    //   1244: ldc_w 465
    //   1247: aload 5
    //   1249: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1252: ifeq +9 -> 1261
    //   1255: bipush 8
    //   1257: istore_1
    //   1258: goto -598 -> 660
    //   1261: ldc_w 467
    //   1264: aload 5
    //   1266: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1269: ifeq +9 -> 1278
    //   1272: bipush 9
    //   1274: istore_1
    //   1275: goto -615 -> 660
    //   1278: ldc_w 469
    //   1281: aload 5
    //   1283: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1286: ifeq +9 -> 1295
    //   1289: bipush 10
    //   1291: istore_1
    //   1292: goto -632 -> 660
    //   1295: ldc_w 471
    //   1298: aload 5
    //   1300: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1303: ifeq +8 -> 1311
    //   1306: iconst_1
    //   1307: istore_1
    //   1308: goto -648 -> 660
    //   1311: ldc_w 473
    //   1314: aload 5
    //   1316: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1319: ifeq -659 -> 660
    //   1322: bipush 11
    //   1324: istore_1
    //   1325: goto -665 -> 660
    //   1328: iconst_1
    //   1329: ireturn
    //   1330: astore 6
    //   1332: aconst_null
    //   1333: astore 5
    //   1335: aload_3
    //   1336: astore 4
    //   1338: aload 6
    //   1340: astore_3
    //   1341: goto -221 -> 1120
    //   1344: astore 6
    //   1346: aload_3
    //   1347: astore 4
    //   1349: aload 6
    //   1351: astore_3
    //   1352: goto -232 -> 1120
    //   1355: astore 6
    //   1357: aload_3
    //   1358: astore 5
    //   1360: aload 6
    //   1362: astore_3
    //   1363: goto -243 -> 1120
    //   1366: astore_3
    //   1367: aload 6
    //   1369: astore 5
    //   1371: goto -251 -> 1120
    //   1374: astore 7
    //   1376: aconst_null
    //   1377: astore 5
    //   1379: goto -318 -> 1061
    //   1382: astore 7
    //   1384: goto -323 -> 1061
    //   1387: astore 7
    //   1389: aconst_null
    //   1390: astore 5
    //   1392: goto -394 -> 998
    //   1395: astore 7
    //   1397: goto -399 -> 998
    //   1400: astore 5
    //   1402: aconst_null
    //   1403: astore 6
    //   1405: aload_3
    //   1406: astore 4
    //   1408: aload 6
    //   1410: astore_3
    //   1411: goto -481 -> 930
    //   1414: astore 4
    //   1416: aload 5
    //   1418: astore 6
    //   1420: aload 4
    //   1422: astore 5
    //   1424: aload_3
    //   1425: astore 4
    //   1427: aload 6
    //   1429: astore_3
    //   1430: goto -500 -> 930
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1433	0	this	bavw
    //   646	679	1	i	int
    //   382	2	2	bool	boolean
    //   101	2	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   182	2	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   208	732	3	localObject1	Object
    //   956	2	3	localIOException1	java.io.IOException
    //   974	2	3	localIOException2	java.io.IOException
    //   982	2	3	localIOException3	java.io.IOException
    //   997	28	3	localObject2	Object
    //   1031	2	3	localIOException4	java.io.IOException
    //   1056	32	3	localIOException5	java.io.IOException
    //   1094	2	3	localIOException6	java.io.IOException
    //   1112	224	3	localObject3	Object
    //   1340	23	3	localObject4	Object
    //   1366	40	3	localObject5	Object
    //   1410	20	3	localObject6	Object
    //   10	939	4	localObject7	Object
    //   964	3	4	localIOException7	java.io.IOException
    //   999	1	4	localObject8	Object
    //   1039	3	4	localIOException8	java.io.IOException
    //   1049	9	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1062	1	4	localObject9	Object
    //   1102	3	4	localIOException9	java.io.IOException
    //   1118	18	4	localObject10	Object
    //   1152	3	4	localIOException10	java.io.IOException
    //   1336	71	4	localObject11	Object
    //   1414	7	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   1425	1	4	localObject12	Object
    //   291	418	5	localObject13	Object
    //   916	3	5	localIOException11	java.io.IOException
    //   926	5	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   993	133	5	localObject14	Object
    //   1142	173	5	localIOException12	java.io.IOException
    //   1333	58	5	localObject15	Object
    //   1400	17	5	localFileNotFoundException5	java.io.FileNotFoundException
    //   1422	1	5	localFileNotFoundException6	java.io.FileNotFoundException
    //   1	1066	6	localObject16	Object
    //   1330	9	6	localObject17	Object
    //   1344	6	6	localObject18	Object
    //   1355	13	6	localObject19	Object
    //   1403	25	6	localObject20	Object
    //   4	1	7	localObject21	Object
    //   990	65	7	localIOException13	java.io.IOException
    //   1059	10	7	localObject22	Object
    //   1374	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1382	1	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1387	1	7	localIOException14	java.io.IOException
    //   1395	1	7	localIOException15	java.io.IOException
    //   7	1110	8	localObject23	Object
    //   268	486	9	str	String
    //   311	103	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   40	57	101	java/io/FileNotFoundException
    //   121	138	182	java/io/FileNotFoundException
    //   387	392	916	java/io/IOException
    //   270	383	926	java/io/FileNotFoundException
    //   387	392	926	java/io/FileNotFoundException
    //   392	401	926	java/io/FileNotFoundException
    //   918	923	926	java/io/FileNotFoundException
    //   948	953	956	java/io/IOException
    //   423	428	964	java/io/IOException
    //   432	436	974	java/io/IOException
    //   939	943	982	java/io/IOException
    //   270	383	990	java/io/IOException
    //   392	401	990	java/io/IOException
    //   918	923	990	java/io/IOException
    //   1024	1028	1031	java/io/IOException
    //   1015	1020	1039	java/io/IOException
    //   270	383	1049	java/lang/OutOfMemoryError
    //   387	392	1049	java/lang/OutOfMemoryError
    //   392	401	1049	java/lang/OutOfMemoryError
    //   918	923	1049	java/lang/OutOfMemoryError
    //   1087	1091	1094	java/io/IOException
    //   1078	1083	1102	java/io/IOException
    //   270	383	1112	finally
    //   387	392	1112	finally
    //   392	401	1112	finally
    //   918	923	1112	finally
    //   1125	1130	1142	java/io/IOException
    //   1135	1140	1152	java/io/IOException
    //   401	411	1330	finally
    //   411	418	1344	finally
    //   930	935	1355	finally
    //   1005	1010	1366	finally
    //   1068	1073	1366	finally
    //   401	411	1374	java/lang/OutOfMemoryError
    //   411	418	1382	java/lang/OutOfMemoryError
    //   401	411	1387	java/io/IOException
    //   411	418	1395	java/io/IOException
    //   401	411	1400	java/io/FileNotFoundException
    //   411	418	1414	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavw
 * JD-Core Version:    0.7.0.1
 */