import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tencent.im.s2c.msgtype0x210.submsgtype0x103.submsgtype0x103.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x104.submsgtype0x104.MsgBody;

public class aoeu
  extends amiz
{
  awbw jdField_a_of_type_Awbw = null;
  private QQConcurrentHashMap<String, ConfessConvInfo> jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap = new QQConcurrentHashMap(1005, 0, 100);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public aoeu(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private awbw a()
  {
    if ((this.jdField_a_of_type_Awbw == null) || (!this.jdField_a_of_type_Awbw.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Awbw == null) || (!this.jdField_a_of_type_Awbw.a())) {
        this.jdField_a_of_type_Awbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_Awbw;
    }
  }
  
  /* Error */
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: iload_3
    //   5: invokestatic 56	aoep:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +33 -> 43
    //   13: aload_0
    //   14: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 60	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +22 -> 43
    //   24: aload_0
    //   25: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 64	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 66	com/tencent/mobileqq/confess/ConfessConvInfo
    //   35: getfield 70	com/tencent/mobileqq/confess/ConfessConvInfo:unreadCount	I
    //   38: istore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_2
    //   42: ireturn
    //   43: iconst_0
    //   44: istore_2
    //   45: goto -6 -> 39
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	aoeu
    //   0	53	1	paramString	String
    //   0	53	2	paramInt1	int
    //   0	53	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	9	48	finally
    //   13	39	48	finally
  }
  
  /* Error */
  public long a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: iload_3
    //   5: invokestatic 56	aoep:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +35 -> 45
    //   13: aload_0
    //   14: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 60	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +24 -> 45
    //   24: aload_0
    //   25: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 64	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 66	com/tencent/mobileqq/confess/ConfessConvInfo
    //   35: getfield 75	com/tencent/mobileqq/confess/ConfessConvInfo:lastread	J
    //   38: lstore 4
    //   40: aload_0
    //   41: monitorexit
    //   42: lload 4
    //   44: lreturn
    //   45: lconst_0
    //   46: lstore 4
    //   48: goto -8 -> 40
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	aoeu
    //   0	56	1	paramString	String
    //   0	56	2	paramInt1	int
    //   0	56	3	paramInt2	int
    //   38	9	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	9	51	finally
    //   13	40	51	finally
  }
  
  /* Error */
  public ConfessConvInfo a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: iload_3
    //   5: invokestatic 56	aoep:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +30 -> 40
    //   13: aload_0
    //   14: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 60	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +19 -> 40
    //   24: aload_0
    //   25: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 64	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 66	com/tencent/mobileqq/confess/ConfessConvInfo
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: areturn
    //   40: aconst_null
    //   41: astore_1
    //   42: goto -6 -> 36
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	aoeu
    //   0	50	1	paramString	String
    //   0	50	2	paramInt1	int
    //   0	50	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	9	45	finally
    //   13	36	45	finally
  }
  
  public Set<ConfessConvInfo> a()
  {
    try
    {
      HashSet localHashSet1 = new HashSet(this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.values());
      return localHashSet1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.confess.unread.ConfessProxy", 2, "cloneConfessConvInfoSet OOM!", localOutOfMemoryError);
        }
        HashSet localHashSet2 = new HashSet();
      }
    }
    finally {}
  }
  
  protected void a() {}
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: iload_3
    //   5: invokestatic 56	aoep:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   8: astore 5
    //   10: aload_0
    //   11: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   14: aload 5
    //   16: invokevirtual 60	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   19: ifeq +52 -> 71
    //   22: aload_0
    //   23: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   26: aload 5
    //   28: invokevirtual 64	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: ifnull +40 -> 71
    //   34: aload_0
    //   35: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   38: aload 5
    //   40: invokevirtual 64	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 66	com/tencent/mobileqq/confess/ConfessConvInfo
    //   46: astore 5
    //   48: aload_0
    //   49: aload_1
    //   50: iload_2
    //   51: iload_3
    //   52: aload 5
    //   54: getfield 75	com/tencent/mobileqq/confess/ConfessConvInfo:lastread	J
    //   57: aload 5
    //   59: getfield 70	com/tencent/mobileqq/confess/ConfessConvInfo:unreadCount	I
    //   62: iload 4
    //   64: iadd
    //   65: invokevirtual 108	aoeu:a	(Ljava/lang/String;IIJI)V
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: aload_0
    //   72: aload_1
    //   73: iload_2
    //   74: iload_3
    //   75: lconst_0
    //   76: iload 4
    //   78: invokevirtual 108	aoeu:a	(Ljava/lang/String;IIJI)V
    //   81: goto -13 -> 68
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	aoeu
    //   0	89	1	paramString	String
    //   0	89	2	paramInt1	int
    //   0	89	3	paramInt2	int
    //   0	89	4	paramInt3	int
    //   8	50	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	68	84	finally
    //   71	81	84	finally
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      String str = aoep.a(paramString, paramInt1, paramInt2);
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(str))
      {
        ConfessConvInfo localConfessConvInfo = (ConfessConvInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str);
        if (localConfessConvInfo != null)
        {
          localConfessConvInfo.holmesTolCount = paramInt4;
          localConfessConvInfo.holmesCurCount = paramInt3;
          a(paramString, paramInt1, localConfessConvInfo);
          if (QLog.isColorLevel()) {
            QLog.d("Q.confess.unread.ConfessProxy", 2, "updateHolmesProgress key=" + str + " curCount=" + paramInt3);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = aoep.a(paramString, paramInt1, paramInt2);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConfessConvInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if ((((ConfessConvInfo)localObject).lastread != paramLong) || (((ConfessConvInfo)localObject).unreadCount != paramInt3))
          {
            ((ConfessConvInfo)localObject).lastread = paramLong;
            ((ConfessConvInfo)localObject).unreadCount = Math.max(0, paramInt3);
            QLog.d("Q.confess.unread.ConfessProxy", 1, "insertOrUpdateUnread update=" + localObject.toString());
            a(paramString, paramInt1, (ConfessConvInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.confess.unread.ConfessProxy", 2, "insertOrUpdateUnread nochange=" + localObject.toString());
          continue;
        }
        localConfessConvInfo = new ConfessConvInfo(paramString, paramInt1, paramInt2, paramLong, Math.max(0, paramInt3));
      }
      finally {}
      ConfessConvInfo localConfessConvInfo;
      QLog.d("Q.confess.unread.ConfessProxy", 1, "insertOrUpdateUnread insert=" + localConfessConvInfo.toString());
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConfessConvInfo);
      b(paramString, paramInt1, localConfessConvInfo);
    }
  }
  
  protected void a(String paramString, int paramInt, ConfessConvInfo paramConfessConvInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConfessConvInfo.getConversationInfoTableName(), paramConfessConvInfo, 4, null);
  }
  
  public void a(submsgtype0x103.MsgBody paramMsgBody)
  {
    if (!aoeh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return;
    }
    long l2;
    long l3;
    int i;
    long l1;
    if ((paramMsgBody != null) && (paramMsgBody.uint64_from.has()) && (paramMsgBody.uint64_to.has()) && (paramMsgBody.uint32_topic_id.has()) && (paramMsgBody.uint32_cur_count.has()) && (paramMsgBody.uint32_total_count.has()))
    {
      l2 = paramMsgBody.uint64_from.get();
      l3 = paramMsgBody.uint64_to.get();
      i = -1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() == l2)
      {
        i = 1033;
        l1 = l3;
      }
    }
    for (;;)
    {
      label106:
      Object localObject;
      int j;
      int k;
      int m;
      if (l1 > 0L)
      {
        a(l1 + "", i, paramMsgBody.uint32_topic_id.get(), paramMsgBody.uint32_cur_count.get(), paramMsgBody.uint32_total_count.get());
        if ((paramMsgBody.uint32_total_count.get() > 0) && (paramMsgBody.uint32_cur_count.get() == paramMsgBody.uint32_total_count.get()))
        {
          localObject = aoep.a(l1 + "", i, paramMsgBody.uint32_topic_id.get());
          aoeh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, true);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009572", "0X8009572", 0, 0, paramMsgBody.uint32_topic_id.get() + "", "", l2 + "", l3 + "");
        }
        localObject = (aoei)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125);
        if (localObject != null)
        {
          j = paramMsgBody.uint32_topic_id.get();
          k = paramMsgBody.uint32_cur_count.get();
          m = paramMsgBody.uint32_total_count.get();
          if (i != 1033) {
            break label508;
          }
        }
      }
      label508:
      for (boolean bool = true;; bool = false)
      {
        ((aoei)localObject).notifyUI(8, true, new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.confess.unread.ConfessProxy", 2, "onReceiveHolmesProgressOnLinePush from:" + l2 + " to:" + l3);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() != l3) {
          break label530;
        }
        i = 1034;
        l1 = l2;
        break label106;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.confess.unread.ConfessProxy", 2, "onReceiveHolmesProgressOnLinePush no msg data");
      return;
      label530:
      l1 = -1L;
    }
  }
  
  public void a(submsgtype0x104.MsgBody paramMsgBody)
  {
    if (!aoeh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    label213:
    for (;;)
    {
      return;
      long l1;
      long l2;
      int i;
      if ((paramMsgBody != null) && (paramMsgBody.uint64_from.has()) && (paramMsgBody.uint64_to.has()) && (paramMsgBody.uint32_topic_id.has()) && (paramMsgBody.bytes_wording.has()))
      {
        l1 = paramMsgBody.uint64_from.get();
        l2 = paramMsgBody.uint64_to.get();
        i = -1;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() == l1)
        {
          i = 1033;
          l1 = l2;
        }
      }
      for (;;)
      {
        if (l1 <= 0L) {
          break label213;
        }
        String str = paramMsgBody.bytes_wording.get().toStringUtf8();
        if (!TextUtils.isEmpty(str))
        {
          aoep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1 + "", str, i, paramMsgBody.uint32_topic_id.get());
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() == l2) {
            i = 1034;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.confess.unread.ConfessProxy", 2, "onReceiveHolmesGrayTipsOnLinePush grayTip empty");
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.confess.unread.ConfessProxy", 2, "onReceiveHolmesGrayTipsOnLinePush no msg data");
          return;
        }
        l1 = -1L;
      }
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.clear();
    if ((this.jdField_a_of_type_Awbw != null) && (this.jdField_a_of_type_Awbw.a())) {
      this.jdField_a_of_type_Awbw.a();
    }
  }
  
  protected void b(String paramString, int paramInt, ConfessConvInfo paramConfessConvInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConfessConvInfo.getConversationInfoTableName(), paramConfessConvInfo, 3, null);
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   6: invokevirtual 306	com/tencent/commonsdk/cache/QQConcurrentHashMap:clear	()V
    //   9: aload_0
    //   10: invokespecial 313	aoeu:a	()Lawbw;
    //   13: ldc 66
    //   15: invokestatic 168	com/tencent/mobileqq/confess/ConfessConvInfo:getConversationInfoTableName	()Ljava/lang/String;
    //   18: iconst_0
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 316	awbw:a	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lawcg;)Ljava/util/List;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +4 -> 35
    //   34: return
    //   35: iload_2
    //   36: istore_1
    //   37: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +36 -> 76
    //   43: ldc 95
    //   45: iconst_2
    //   46: new 120	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 318
    //   56: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_3
    //   60: invokeinterface 323 1 0
    //   65: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: iload_2
    //   75: istore_1
    //   76: iload_1
    //   77: aload_3
    //   78: invokeinterface 323 1 0
    //   83: if_icmpge -49 -> 34
    //   86: aload_0
    //   87: getfield 29	aoeu:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   90: aload_3
    //   91: iload_1
    //   92: invokeinterface 326 2 0
    //   97: checkcast 66	com/tencent/mobileqq/confess/ConfessConvInfo
    //   100: getfield 330	com/tencent/mobileqq/confess/ConfessConvInfo:uin	Ljava/lang/String;
    //   103: aload_3
    //   104: iload_1
    //   105: invokeinterface 326 2 0
    //   110: checkcast 66	com/tencent/mobileqq/confess/ConfessConvInfo
    //   113: getfield 333	com/tencent/mobileqq/confess/ConfessConvInfo:type	I
    //   116: aload_3
    //   117: iload_1
    //   118: invokeinterface 326 2 0
    //   123: checkcast 66	com/tencent/mobileqq/confess/ConfessConvInfo
    //   126: getfield 336	com/tencent/mobileqq/confess/ConfessConvInfo:topicId	I
    //   129: invokestatic 56	aoep:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   132: aload_3
    //   133: iload_1
    //   134: invokeinterface 326 2 0
    //   139: invokevirtual 159	com/tencent/commonsdk/cache/QQConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: iload_1
    //   144: iconst_1
    //   145: iadd
    //   146: istore_1
    //   147: goto -71 -> 76
    //   150: astore_3
    //   151: aload_3
    //   152: athrow
    //   153: astore_3
    //   154: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	aoeu
    //   36	111	1	i	int
    //   1	74	2	j	int
    //   29	104	3	localList	java.util.List
    //   150	2	3	localObject	Object
    //   153	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   76	143	150	finally
    //   76	143	153	java/lang/Exception
  }
  
  public void d()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          ConfessConvInfo localConfessConvInfo = (ConfessConvInfo)localIterator.next();
          if (localConfessConvInfo.unreadCount > 0)
          {
            localConfessConvInfo.unreadCount = 0;
            a(localConfessConvInfo.uin, localConfessConvInfo.type, localConfessConvInfo);
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoeu
 * JD-Core Version:    0.7.0.1
 */