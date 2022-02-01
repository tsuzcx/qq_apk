import android.support.annotation.Nullable;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class bcnb
  extends bcmy
{
  private volatile int jdField_a_of_type_Int;
  private volatile long jdField_a_of_type_Long;
  private ConcurrentHashMap<Integer, bcmz> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int b = -1;
  
  public bcnb(bcmx parambcmx)
  {
    super(parambcmx);
  }
  
  private bcmz a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (bcmz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    bcmz localbcmz = new bcmz();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localbcmz);
    return localbcmz;
  }
  
  @Nullable
  private String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.stt_ShardSttRcv", 2, "tryGetContinuouslyString start Start = " + this.jdField_a_of_type_Int + " | Current = " + this.b);
    }
    if (this.b < this.jdField_a_of_type_Int) {
      localObject = null;
    }
    int i;
    String str;
    do
    {
      return localObject;
      i = this.jdField_a_of_type_Int;
      str = "";
      localObject = str;
    } while (i > this.b);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))) {}
    for (Object localObject = (bcmz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));; localObject = null)
    {
      if ((localObject == null) || (!((bcmz)localObject).jdField_a_of_type_Boolean))
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("tryGetContinuouslyString return null index = ").append(i).append(" | tempPacket is ");
          if (localObject != null) {
            break label172;
          }
        }
        label172:
        for (str = "null";; str = "not end")
        {
          QLog.d("Q.stt_ShardSttRcv", 2, str);
          return null;
        }
      }
      localObject = new String(((bcmz)localObject).jdField_a_of_type_JavaNioByteBuffer.array());
      str = str + (String)localObject;
      i += 1;
      break;
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Long == 0L) || (paramInt == 0)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = 0L;
    l1 = (l1 - l2) / paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.stt_ShardSttRcv", 2, "PttSttReport reportPackageTimeInterval timeInterval = " + l1);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("timeInterval", l1 + "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttShardSttReveivePartTimeInterval", true, 0L, 0L, localHashMap, null);
  }
  
  private void b()
  {
    try
    {
      this.jdField_a_of_type_Int = 0;
      this.b = -1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c()
  {
    b();
  }
  
  /* Error */
  public int a(tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody paramMsgBody)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 24	bcnb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: astore 8
    //   8: aload 8
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnonnull +10 -> 22
    //   15: aload 8
    //   17: monitorexit
    //   18: sipush 4001
    //   21: ireturn
    //   22: aload_1
    //   23: getfield 159	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$MsgBody:msg_ptt_shard_resp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp;
    //   26: astore 9
    //   28: aload 9
    //   30: invokevirtual 164	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:has	()Z
    //   33: ifne +31 -> 64
    //   36: aload_0
    //   37: invokespecial 166	bcnb:c	()V
    //   40: aload_0
    //   41: getfield 169	bcnb:jdField_a_of_type_Bcmx	Lbcmx;
    //   44: iconst_4
    //   45: sipush 2007
    //   48: invokevirtual 174	bcmx:a	(II)V
    //   51: aload 8
    //   53: monitorexit
    //   54: sipush 4001
    //   57: ireturn
    //   58: astore_1
    //   59: aload 8
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: aload 9
    //   66: getfield 178	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:uint64_sessionid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   69: invokevirtual 182	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   72: invokestatic 187	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   75: astore 11
    //   77: aload 9
    //   79: getfield 191	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:uint32_error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore_2
    //   86: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +38 -> 127
    //   92: ldc 57
    //   94: iconst_2
    //   95: new 59	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   102: ldc 198
    //   104: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload_2
    //   108: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc 200
    //   113: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 11
    //   118: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: iload_2
    //   128: ifeq +23 -> 151
    //   131: aload_0
    //   132: invokespecial 166	bcnb:c	()V
    //   135: aload_0
    //   136: getfield 169	bcnb:jdField_a_of_type_Bcmx	Lbcmx;
    //   139: iconst_4
    //   140: iload_2
    //   141: invokevirtual 174	bcmx:a	(II)V
    //   144: aload 8
    //   146: monitorexit
    //   147: sipush 4002
    //   150: ireturn
    //   151: aload_0
    //   152: getfield 24	bcnb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   155: invokevirtual 206	java/util/concurrent/ConcurrentHashMap:size	()I
    //   158: ifne +19 -> 177
    //   161: aload_0
    //   162: getfield 110	bcnb:jdField_a_of_type_Long	J
    //   165: lconst_0
    //   166: lcmp
    //   167: ifne +10 -> 177
    //   170: aload_0
    //   171: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   174: putfield 110	bcnb:jdField_a_of_type_Long	J
    //   177: aload 9
    //   179: getfield 209	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:uint32_total_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   182: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   185: istore 4
    //   187: iload 4
    //   189: aload_0
    //   190: getfield 68	bcnb:jdField_a_of_type_Int	I
    //   193: if_icmpge +8 -> 201
    //   196: aload 8
    //   198: monitorexit
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_0
    //   202: getfield 17	bcnb:b	I
    //   205: iload 4
    //   207: if_icmpge +9 -> 216
    //   210: aload_0
    //   211: iload 4
    //   213: putfield 17	bcnb:b	I
    //   216: aload_0
    //   217: iload 4
    //   219: invokespecial 211	bcnb:a	(I)Lbcmz;
    //   222: astore 10
    //   224: aload 9
    //   226: getfield 215	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:all_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   229: invokevirtual 218	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:has	()Z
    //   232: ifeq +229 -> 461
    //   235: aload 9
    //   237: getfield 215	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:all_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   240: astore_1
    //   241: iconst_1
    //   242: istore 7
    //   244: aload_1
    //   245: getfield 221	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_pos	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   248: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   251: istore_2
    //   252: aload_1
    //   253: getfield 224	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   256: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   259: istore 5
    //   261: aload_1
    //   262: getfield 227	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_total_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   265: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   268: istore 6
    //   270: aload_0
    //   271: aload 10
    //   273: iload_2
    //   274: iload 5
    //   276: iload 6
    //   278: iconst_1
    //   279: aload_1
    //   280: getfield 230	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   283: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   286: ishl
    //   287: aload_1
    //   288: getfield 234	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:bytes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   291: invokevirtual 239	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   294: invokevirtual 244	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   297: invokevirtual 247	bcnb:a	(Lbcmz;IIII[B)Lbcmz;
    //   300: pop
    //   301: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +108 -> 412
    //   307: ldc 57
    //   309: iconst_2
    //   310: new 59	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   317: ldc 249
    //   319: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 11
    //   324: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   327: ldc 200
    //   329: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: iload_2
    //   333: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: ldc 200
    //   338: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload 5
    //   343: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: ldc 200
    //   348: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: iload 6
    //   353: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: ldc 57
    //   364: iconst_2
    //   365: new 59	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   372: ldc 251
    //   374: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: iload 4
    //   379: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc 253
    //   384: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload 7
    //   389: invokevirtual 256	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   392: ldc_w 258
    //   395: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 10
    //   400: getfield 84	bcmz:jdField_a_of_type_Boolean	Z
    //   403: invokevirtual 256	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   406: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aload 10
    //   414: getfield 84	bcmz:jdField_a_of_type_Boolean	Z
    //   417: ifeq +293 -> 710
    //   420: iload 7
    //   422: ifeq +117 -> 539
    //   425: aload_0
    //   426: getfield 68	bcnb:jdField_a_of_type_Int	I
    //   429: istore_2
    //   430: aload_0
    //   431: iload 4
    //   433: putfield 68	bcnb:jdField_a_of_type_Int	I
    //   436: iload_2
    //   437: iload 4
    //   439: if_icmpge +100 -> 539
    //   442: aload_0
    //   443: getfield 24	bcnb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   446: iload_2
    //   447: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   450: invokevirtual 261	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   453: pop
    //   454: iload_2
    //   455: iconst_1
    //   456: iadd
    //   457: istore_2
    //   458: goto -22 -> 436
    //   461: aload 9
    //   463: getfield 264	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:cur_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   466: invokevirtual 218	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:has	()Z
    //   469: ifne +58 -> 527
    //   472: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq +30 -> 505
    //   478: ldc 57
    //   480: iconst_2
    //   481: new 59	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 266
    //   491: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload 11
    //   496: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload_0
    //   506: invokespecial 166	bcnb:c	()V
    //   509: aload_0
    //   510: getfield 169	bcnb:jdField_a_of_type_Bcmx	Lbcmx;
    //   513: iconst_4
    //   514: sipush 2007
    //   517: invokevirtual 174	bcmx:a	(II)V
    //   520: aload 8
    //   522: monitorexit
    //   523: sipush 4001
    //   526: ireturn
    //   527: aload 9
    //   529: getfield 264	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:cur_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   532: astore_1
    //   533: iconst_0
    //   534: istore 7
    //   536: goto -292 -> 244
    //   539: aload_0
    //   540: invokespecial 268	bcnb:a	()Ljava/lang/String;
    //   543: astore_1
    //   544: aload_1
    //   545: ifnull +150 -> 695
    //   548: aload 9
    //   550: getfield 272	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:bool_is_total_end	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   553: invokevirtual 276	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   556: istore 7
    //   558: aload_0
    //   559: getfield 169	bcnb:jdField_a_of_type_Bcmx	Lbcmx;
    //   562: aload_1
    //   563: iload 7
    //   565: invokevirtual 279	bcmx:a	(Ljava/lang/String;Z)V
    //   568: iload_3
    //   569: istore_2
    //   570: iload 7
    //   572: ifne +7 -> 579
    //   575: sipush -10001
    //   578: istore_2
    //   579: aload_0
    //   580: getfield 146	bcnb:jdField_a_of_type_Boolean	Z
    //   583: ifne +12 -> 595
    //   586: aload_0
    //   587: iconst_1
    //   588: putfield 146	bcnb:jdField_a_of_type_Boolean	Z
    //   591: sipush -10002
    //   594: istore_2
    //   595: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   598: ifeq +68 -> 666
    //   601: new 94	java/lang/String
    //   604: dup
    //   605: aload 10
    //   607: getfield 97	bcmz:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   610: invokevirtual 103	java/nio/ByteBuffer:array	()[B
    //   613: invokespecial 106	java/lang/String:<init>	([B)V
    //   616: astore 9
    //   618: ldc 57
    //   620: iconst_2
    //   621: new 59	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 281
    //   631: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 9
    //   636: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 283
    //   642: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: iload 7
    //   647: invokevirtual 256	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   650: ldc_w 285
    //   653: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload_1
    //   657: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: iload 7
    //   668: ifeq +47 -> 715
    //   671: aload_0
    //   672: aload_0
    //   673: getfield 17	bcnb:b	I
    //   676: invokespecial 287	bcnb:a	(I)V
    //   679: goto +36 -> 715
    //   682: aload_0
    //   683: getfield 169	bcnb:jdField_a_of_type_Bcmx	Lbcmx;
    //   686: iconst_1
    //   687: invokevirtual 290	bcmx:a	(Z)V
    //   690: aload 8
    //   692: monitorexit
    //   693: iload_2
    //   694: ireturn
    //   695: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   698: ifeq +12 -> 710
    //   701: ldc 57
    //   703: iconst_2
    //   704: ldc_w 292
    //   707: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: iconst_0
    //   711: istore_2
    //   712: goto -30 -> 682
    //   715: goto -33 -> 682
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	bcnb
    //   0	718	1	paramMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody
    //   85	627	2	i	int
    //   1	568	3	j	int
    //   185	255	4	k	int
    //   259	83	5	m	int
    //   268	84	6	n	int
    //   242	425	7	bool	boolean
    //   6	685	8	localConcurrentHashMap	ConcurrentHashMap
    //   222	384	10	localbcmz	bcmz
    //   75	420	11	localLong	java.lang.Long
    // Exception table:
    //   from	to	target	type
    //   15	18	58	finally
    //   22	54	58	finally
    //   59	62	58	finally
    //   64	127	58	finally
    //   131	147	58	finally
    //   151	177	58	finally
    //   177	199	58	finally
    //   201	216	58	finally
    //   216	241	58	finally
    //   244	412	58	finally
    //   412	420	58	finally
    //   425	436	58	finally
    //   442	454	58	finally
    //   461	505	58	finally
    //   505	523	58	finally
    //   527	533	58	finally
    //   539	544	58	finally
    //   548	568	58	finally
    //   579	591	58	finally
    //   595	666	58	finally
    //   671	679	58	finally
    //   682	693	58	finally
    //   695	710	58	finally
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnb
 * JD-Core Version:    0.7.0.1
 */