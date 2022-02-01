import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.net.RoomQueryHandler.1;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.location.RoomOperate.ReqRoomQuery;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class awqd
  extends awpm<awpq>
{
  private static int jdField_a_of_type_Int = 5000;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public awqd(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoom: invoked. ", " uinType: ", Integer.valueOf(paramInt), " sessionUin: ", Long.valueOf(paramLong), " noLimitReq: ", Boolean.valueOf(paramBoolean) });
    }
    long l = System.currentTimeMillis();
    if ((l - this.jdField_a_of_type_Long < this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() * 1000L) && (!paramBoolean))
    {
      QLog.d("RoomQueryHandler", 1, new Object[] { "[queryLocationRoom] requestQueryRoomNoLimit: invoked. frequency limited", " requestIntervalSecond: ", this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger });
      return;
    }
    this.jdField_a_of_type_Long = l;
    RoomOperate.ReqRoomQuery localReqRoomQuery = new RoomOperate.ReqRoomQuery();
    localReqRoomQuery.no_limit.set(paramBoolean);
    Object localObject = awua.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramLong);
    localReqRoomQuery.room_key.set((MessageMicro)localObject);
    localReqRoomQuery.room_key.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQLBSShareSvc.room_query");
    ((ToServiceMsg)localObject).extraData.putInt("uintype", paramInt);
    ((ToServiceMsg)localObject).extraData.putString("uin", String.valueOf(paramLong));
    ((ToServiceMsg)localObject).putWupBuffer(localReqRoomQuery.toByteArray());
    a().sendPbReq((ToServiceMsg)localObject);
  }
  
  private void c()
  {
    a().notifyUI(2, false, null);
  }
  
  private void c(int paramInt, String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", paramString);
      }
    }
    a(paramInt, l1, false);
  }
  
  protected awpq a()
  {
    return awpq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] stopRequestQueryRoomInLoop: invoked. ", " loopQueryStopped: ", this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean });
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", localNumberFormatException);
      }
    }
    awpq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramInt, paramString);
    a(paramInt, l1, true);
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: invokevirtual 239	awqd:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Z
    //   7: ifeq +287 -> 294
    //   10: new 241	tencent/im/oidb/location/RoomOperate$RspRoomQuery
    //   13: dup
    //   14: invokespecial 242	tencent/im/oidb/location/RoomOperate$RspRoomQuery:<init>	()V
    //   17: aload_3
    //   18: checkcast 244	[B
    //   21: checkcast 244	[B
    //   24: invokevirtual 248	tencent/im/oidb/location/RoomOperate$RspRoomQuery:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 241	tencent/im/oidb/location/RoomOperate$RspRoomQuery
    //   30: astore_2
    //   31: aload_2
    //   32: getfield 252	tencent/im/oidb/location/RoomOperate$RspRoomQuery:room_state	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   35: invokevirtual 255	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   38: istore 4
    //   40: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +118 -> 161
    //   46: aload_2
    //   47: getfield 259	tencent/im/oidb/location/RoomOperate$RspRoomQuery:user_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   50: invokevirtual 264	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   53: astore 6
    //   55: new 266	java/util/ArrayList
    //   58: dup
    //   59: invokespecial 267	java/util/ArrayList:<init>	()V
    //   62: astore_3
    //   63: aload 6
    //   65: invokeinterface 273 1 0
    //   70: astore 6
    //   72: aload 6
    //   74: invokeinterface 278 1 0
    //   79: ifeq +42 -> 121
    //   82: aload_3
    //   83: aload 6
    //   85: invokeinterface 282 1 0
    //   90: checkcast 284	tencent/im/oidb/location/RoomOperate$UserData
    //   93: getfield 287	tencent/im/oidb/location/RoomOperate$UserData:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   96: invokevirtual 291	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   99: invokestatic 79	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: invokevirtual 295	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: goto -34 -> 72
    //   109: astore_1
    //   110: ldc 60
    //   112: iconst_1
    //   113: ldc_w 297
    //   116: aload_1
    //   117: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: return
    //   121: ldc 60
    //   123: iconst_2
    //   124: iconst_5
    //   125: anewarray 62	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: ldc_w 299
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: ldc_w 301
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload 4
    //   144: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_3
    //   150: ldc_w 303
    //   153: aastore
    //   154: dup
    //   155: iconst_4
    //   156: aload_3
    //   157: aastore
    //   158: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   161: aload_2
    //   162: getfield 307	tencent/im/oidb/location/RoomOperate$RspRoomQuery:msg_result	Ltencent/im/oidb/location/qq_lbs_share$ResultInfo;
    //   165: invokevirtual 312	tencent/im/oidb/location/qq_lbs_share$ResultInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   168: checkcast 309	tencent/im/oidb/location/qq_lbs_share$ResultInfo
    //   171: invokestatic 315	awua:a	(Ltencent/im/oidb/location/qq_lbs_share$ResultInfo;)Z
    //   174: ifeq +115 -> 289
    //   177: aload_2
    //   178: getfield 319	tencent/im/oidb/location/RoomOperate$RspRoomQuery:req_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   181: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   184: istore 5
    //   186: aload_0
    //   187: getfield 35	awqd:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   190: iload 5
    //   192: invokevirtual 324	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   195: aload_1
    //   196: getfield 159	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   199: ldc 161
    //   201: iconst_m1
    //   202: invokevirtual 328	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   205: istore 5
    //   207: aload_1
    //   208: getfield 159	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   211: ldc 169
    //   213: invokevirtual 332	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore_1
    //   217: iload 4
    //   219: iconst_2
    //   220: if_icmpne +39 -> 259
    //   223: aload_0
    //   224: invokevirtual 334	awqd:a	()V
    //   227: aload_0
    //   228: getfield 123	awqd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   231: invokestatic 221	awpq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lawpq;
    //   234: new 336	awpk
    //   237: dup
    //   238: iload 5
    //   240: aload_1
    //   241: invokespecial 338	awpk:<init>	(ILjava/lang/String;)V
    //   244: iconst_m1
    //   245: invokevirtual 342	awpq:b	(Lawpk;I)V
    //   248: aload_0
    //   249: getfield 123	awqd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   252: iload 5
    //   254: aload_1
    //   255: iconst_0
    //   256: invokestatic 345	awua:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Z)V
    //   259: aload_0
    //   260: invokevirtual 189	awqd:a	()Lawpq;
    //   263: iconst_2
    //   264: iconst_1
    //   265: iconst_3
    //   266: anewarray 62	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: aload_2
    //   272: aastore
    //   273: dup
    //   274: iconst_1
    //   275: iload 5
    //   277: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: dup
    //   282: iconst_2
    //   283: aload_1
    //   284: aastore
    //   285: invokevirtual 204	awpq:notifyUI	(IZLjava/lang/Object;)V
    //   288: return
    //   289: aload_0
    //   290: invokespecial 347	awqd:c	()V
    //   293: return
    //   294: aload_2
    //   295: ifnull +45 -> 340
    //   298: aload_2
    //   299: invokevirtual 352	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   302: istore 4
    //   304: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +33 -> 340
    //   310: ldc 60
    //   312: iconst_2
    //   313: iconst_3
    //   314: anewarray 62	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: ldc_w 299
    //   322: aastore
    //   323: dup
    //   324: iconst_1
    //   325: ldc_w 354
    //   328: aastore
    //   329: dup
    //   330: iconst_2
    //   331: iload 4
    //   333: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: aastore
    //   337: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   340: aload_0
    //   341: invokespecial 347	awqd:c	()V
    //   344: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	awqd
    //   0	345	1	paramToServiceMsg	ToServiceMsg
    //   0	345	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	345	3	paramObject	Object
    //   38	294	4	i	int
    //   184	92	5	j	int
    //   53	31	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	72	109	java/lang/Exception
    //   72	106	109	java/lang/Exception
    //   121	161	109	java/lang/Exception
    //   161	217	109	java/lang/Exception
    //   223	259	109	java/lang/Exception
    //   259	288	109	java/lang/Exception
    //   289	293	109	java/lang/Exception
  }
  
  public void b()
  {
    a();
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoomInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", paramString });
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaLangRunnable = new RoomQueryHandler.1(this, paramInt, paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqd
 * JD-Core Version:    0.7.0.1
 */