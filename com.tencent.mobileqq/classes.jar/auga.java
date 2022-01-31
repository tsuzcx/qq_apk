import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.model.TroopInfoManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class auga
  extends Observable
  implements Manager
{
  protected LruCache<String, String> a;
  protected awgf a;
  protected QQAppInterface a;
  private HashMap<String, Long> a;
  protected ConcurrentHashMap<Long, TroopAppInfo> a;
  protected boolean a;
  protected ConcurrentHashMap<String, ArrayList<Long>> b;
  public boolean b;
  protected ConcurrentHashMap<String, List<TroopMessageNavigateInfo>> c;
  private boolean c;
  protected ConcurrentHashMap<Long, bbru> d;
  private boolean d;
  protected ConcurrentHashMap<String, bbpd> e;
  
  /* Error */
  public auga(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 29	java/util/Observable:<init>	()V
    //   4: aload_0
    //   5: new 31	java/util/HashMap
    //   8: dup
    //   9: invokespecial 32	java/util/HashMap:<init>	()V
    //   12: putfield 34	auga:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   15: aload_0
    //   16: new 36	java/util/concurrent/ConcurrentHashMap
    //   19: dup
    //   20: invokespecial 37	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   23: putfield 39	auga:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   26: aload_0
    //   27: aload_1
    //   28: putfield 41	auga:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawgg;
    //   36: invokevirtual 53	awgg:createEntityManager	()Lawgf;
    //   39: putfield 55	auga:jdField_a_of_type_Awgf	Lawgf;
    //   42: aload_0
    //   43: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   46: ifnonnull +25 -> 71
    //   49: aload_0
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   55: ifnonnull +14 -> 69
    //   58: aload_0
    //   59: new 36	java/util/concurrent/ConcurrentHashMap
    //   62: dup
    //   63: invokespecial 37	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   66: putfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_0
    //   72: getfield 59	auga:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: ifnonnull +25 -> 100
    //   78: aload_0
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 59	auga:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   84: ifnonnull +14 -> 98
    //   87: aload_0
    //   88: new 36	java/util/concurrent/ConcurrentHashMap
    //   91: dup
    //   92: invokespecial 37	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   95: putfield 59	auga:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_0
    //   101: getfield 61	auga:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   104: ifnonnull +25 -> 129
    //   107: aload_0
    //   108: monitorenter
    //   109: aload_0
    //   110: getfield 61	auga:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: ifnonnull +14 -> 127
    //   116: aload_0
    //   117: new 36	java/util/concurrent/ConcurrentHashMap
    //   120: dup
    //   121: invokespecial 37	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   124: putfield 61	auga:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_0
    //   130: getfield 63	auga:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   133: ifnonnull +27 -> 160
    //   136: aload_0
    //   137: monitorenter
    //   138: aload_0
    //   139: getfield 63	auga:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   142: ifnonnull +16 -> 158
    //   145: aload_0
    //   146: new 65	android/support/v4/util/LruCache
    //   149: dup
    //   150: bipush 10
    //   152: invokespecial 68	android/support/v4/util/LruCache:<init>	(I)V
    //   155: putfield 63	auga:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_0
    //   161: invokevirtual 70	auga:b	()V
    //   164: return
    //   165: astore_1
    //   166: aload_0
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	auga
    //   0	185	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   51	69	165	finally
    //   69	71	165	finally
    //   166	168	165	finally
    //   80	98	170	finally
    //   98	100	170	finally
    //   171	173	170	finally
    //   109	127	175	finally
    //   127	129	175	finally
    //   176	178	175	finally
    //   138	158	180	finally
    //   158	160	180	finally
    //   181	183	180	finally
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +16 -> 22
    //   9: aload_0
    //   10: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_1
    //   14: invokevirtual 82	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: aload_1
    //   30: invokevirtual 86	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 88	java/util/List
    //   36: new 90	augb
    //   39: dup
    //   40: invokespecial 91	augb:<init>	()V
    //   43: invokestatic 97	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   46: goto -24 -> 22
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	auga
    //   0	54	1	paramString	String
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	49	finally
    //   25	46	49	finally
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          a();
        }
        i = 0;
        Iterator localIterator1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          Object localObject2 = localEntry.getValue();
          if ((localObject2 instanceof List))
          {
            localObject2 = (List)localObject2;
            Iterator localIterator2 = ((List)localObject2).iterator();
            if (localIterator2.hasNext())
            {
              TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localIterator2.next();
              if (localTroopMessageNavigateInfo == null) {
                continue;
              }
              if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 3, null);
                i = 1;
                continue;
              }
              if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_MODIFY)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 4, null);
                i = 1;
                continue;
              }
              if (localTroopMessageNavigateInfo.status != TroopMessageNavigateInfo.STATUS_DELETE) {
                continue;
              }
              localIterator2.remove();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 5, null);
              i = 1;
              continue;
            }
            j = i;
            if (!((List)localObject2).isEmpty()) {
              break label294;
            }
            this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEntry.getKey());
            j = i;
            break label294;
          }
        }
        else
        {
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
          }
          return;
        }
      }
      finally {}
      int j = i;
      label294:
      int i = j;
    }
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	auga:jdField_a_of_type_Boolean	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 101	auga:a	()V
    //   13: aload_0
    //   14: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: ifnull +102 -> 119
    //   20: aload_0
    //   21: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_1
    //   25: invokevirtual 82	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   28: ifeq +91 -> 119
    //   31: aload_0
    //   32: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_1
    //   36: invokevirtual 86	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 88	java/util/List
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +16 -> 60
    //   47: aload_1
    //   48: invokeinterface 163 1 0
    //   53: istore 4
    //   55: iload 4
    //   57: ifeq +9 -> 66
    //   60: iconst_m1
    //   61: istore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: iload_2
    //   65: ireturn
    //   66: aload_1
    //   67: invokeinterface 176 1 0
    //   72: istore_3
    //   73: iconst_0
    //   74: istore_2
    //   75: iload_2
    //   76: iload_3
    //   77: if_icmpge +42 -> 119
    //   80: aload_1
    //   81: iload_2
    //   82: invokeinterface 179 2 0
    //   87: checkcast 129	com/tencent/mobileqq/data/TroopMessageNavigateInfo
    //   90: astore 5
    //   92: aload 5
    //   94: getfield 133	com/tencent/mobileqq/data/TroopMessageNavigateInfo:status	I
    //   97: getstatic 158	com/tencent/mobileqq/data/TroopMessageNavigateInfo:STATUS_DELETE	I
    //   100: if_icmpne +10 -> 110
    //   103: iload_2
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: goto -32 -> 75
    //   110: aload 5
    //   112: getfield 182	com/tencent/mobileqq/data/TroopMessageNavigateInfo:type	I
    //   115: istore_2
    //   116: goto -54 -> 62
    //   119: iconst_m1
    //   120: istore_2
    //   121: goto -59 -> 62
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	auga
    //   0	129	1	paramString	String
    //   61	60	2	i	int
    //   72	6	3	j	int
    //   53	3	4	bool	boolean
    //   90	21	5	localTroopMessageNavigateInfo	TroopMessageNavigateInfo
    // Exception table:
    //   from	to	target	type
    //   2	13	124	finally
    //   13	43	124	finally
    //   47	55	124	finally
    //   66	73	124	finally
    //   80	103	124	finally
    //   110	116	124	finally
  }
  
  /* Error */
  public long a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	auga:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 184	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 34	auga:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 185	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 187	java/lang/Long
    //   24: invokevirtual 191	java/lang/Long:longValue	()J
    //   27: lstore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: lload_2
    //   31: lreturn
    //   32: ldc2_w 192
    //   35: lstore_2
    //   36: goto -8 -> 28
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	auga
    //   0	44	1	paramString	String
    //   27	9	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	28	39	finally
  }
  
  public bbpd a(String paramString)
  {
    return (bbpd)this.e.get(paramString);
  }
  
  public bbpd a(String paramString, bbpd parambbpd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update__:" + paramString + " " + parambbpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramString) + " " + parambbpd.a() + " " + parambbpd.b());
    }
    bbpd localbbpd2 = (bbpd)this.e.get(paramString);
    bbpd localbbpd1 = localbbpd2;
    if (parambbpd != null)
    {
      if (parambbpd.a()) {
        break label105;
      }
      localbbpd1 = localbbpd2;
    }
    label105:
    do
    {
      do
      {
        return localbbpd1;
        if (localbbpd2 != null) {
          break;
        }
        parambbpd = new bbpd(parambbpd);
        this.e.put(paramString, parambbpd);
        localbbpd1 = parambbpd;
      } while (!QLog.isColorLevel());
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: put:" + paramString);
      return parambbpd;
      localbbpd2.a(parambbpd);
      localbbpd1 = localbbpd2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update:" + paramString);
    return localbbpd2;
  }
  
  public bbru a(Long paramLong, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    bbru localbbru2 = (bbru)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    bbru localbbru1 = localbbru2;
    if (localbbru2 == null)
    {
      localbbru1 = localbbru2;
      if (paramBoolean)
      {
        localbbru1 = new bbru(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, localbbru1);
      }
    }
    return localbbru1;
  }
  
  /* Error */
  public Object a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	auga:jdField_a_of_type_Boolean	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 101	auga:a	()V
    //   13: aload_0
    //   14: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: ifnull +102 -> 119
    //   20: aload_0
    //   21: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_1
    //   25: invokevirtual 82	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   28: ifeq +91 -> 119
    //   31: aload_0
    //   32: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_1
    //   36: invokevirtual 86	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 88	java/util/List
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +16 -> 60
    //   47: aload_1
    //   48: invokeinterface 163 1 0
    //   53: istore 4
    //   55: iload 4
    //   57: ifeq +9 -> 66
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: aload_1
    //   67: invokeinterface 176 1 0
    //   72: istore_3
    //   73: iconst_0
    //   74: istore_2
    //   75: iload_2
    //   76: iload_3
    //   77: if_icmpge +42 -> 119
    //   80: aload_1
    //   81: iload_2
    //   82: invokeinterface 179 2 0
    //   87: checkcast 129	com/tencent/mobileqq/data/TroopMessageNavigateInfo
    //   90: astore 5
    //   92: aload 5
    //   94: getfield 133	com/tencent/mobileqq/data/TroopMessageNavigateInfo:status	I
    //   97: getstatic 158	com/tencent/mobileqq/data/TroopMessageNavigateInfo:STATUS_DELETE	I
    //   100: if_icmpne +10 -> 110
    //   103: iload_2
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: goto -32 -> 75
    //   110: aload 5
    //   112: getfield 264	com/tencent/mobileqq/data/TroopMessageNavigateInfo:extObj	Ljava/lang/Object;
    //   115: astore_1
    //   116: goto -54 -> 62
    //   119: aconst_null
    //   120: astore_1
    //   121: goto -59 -> 62
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	auga
    //   0	129	1	paramString	String
    //   74	33	2	i	int
    //   72	6	3	j	int
    //   53	3	4	bool	boolean
    //   90	21	5	localTroopMessageNavigateInfo	TroopMessageNavigateInfo
    // Exception table:
    //   from	to	target	type
    //   2	13	124	finally
    //   13	43	124	finally
    //   47	55	124	finally
    //   66	73	124	finally
    //   80	103	124	finally
    //   110	116	124	finally
  }
  
  public ArrayList<Long> a(String paramString)
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList<TroopAppInfo> a(ArrayList<Long> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (Long)paramArrayList.next();
        localObject = (TroopAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public List<Long> a(String paramString, int paramInt)
  {
    for (;;)
    {
      ArrayList localArrayList;
      StringBuilder localStringBuilder;
      int i;
      try
      {
        localArrayList = new ArrayList();
        if (!this.jdField_a_of_type_Boolean) {
          a();
        }
        localStringBuilder = new StringBuilder("getMultiNatigateSeqList, troopUin:");
        localStringBuilder.append(paramString).append("| type:").append(paramInt).append("| seqList:");
        if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)))
        {
          paramString = (List)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (paramString != null)
          {
            boolean bool = paramString.isEmpty();
            if (!bool) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
          int j = paramString.size();
          i = 0;
          if (i < j)
          {
            TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)paramString.get(i);
            if ((localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE) || (localTroopMessageNavigateInfo.type != paramInt)) {
              break label226;
            }
            localArrayList.add(Long.valueOf(localTroopMessageNavigateInfo.msgseq));
            localStringBuilder.append(localTroopMessageNavigateInfo.msgseq).append(",");
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoManager.troop.special_msg.special_attention", 2, localStringBuilder.toString());
      }
      paramString = localArrayList;
      continue;
      label226:
      i += 1;
    }
  }
  
  public void a()
  {
    for (;;)
    {
      TroopMessageNavigateInfo localTroopMessageNavigateInfo;
      Object localObject4;
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool == true) {
          return;
        }
        Object localObject1 = (ArrayList)this.jdField_a_of_type_Awgf.a(TroopMessageNavigateInfo.class, false, null, null, null, null, null, null);
        if (localObject1 == null) {
          break label229;
        }
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label229;
        }
        localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localIterator.next();
        if ((localTroopMessageNavigateInfo == null) || (TextUtils.isEmpty(localTroopMessageNavigateInfo.troopCode))) {
          continue;
        }
        localObject4 = (List)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localTroopMessageNavigateInfo.troopCode);
        if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localTroopMessageNavigateInfo.troopCode))
        {
          localObject1 = ((List)localObject4).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (TroopMessageNavigateInfo)((Iterator)localObject1).next();
            if ((localObject4 == null) || (((TroopMessageNavigateInfo)localObject4).status != TroopMessageNavigateInfo.STATUS_ADD)) {
              continue;
            }
            ((TroopMessageNavigateInfo)localObject4).status = TroopMessageNavigateInfo.STATUS_MODIFY;
            continue;
          }
          continue;
        }
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_NORMAL;
      }
      finally {}
      Object localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new ArrayList();
      }
      ((List)localObject3).add(localTroopMessageNavigateInfo);
      a(localTroopMessageNavigateInfo.troopCode);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopMessageNavigateInfo.troopCode, localObject3);
      continue;
      label229:
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putBoolean(paramContext, paramBoolean);
    localEditor.commit();
  }
  
  public void a(Long paramLong)
  {
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return;
    }
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramLong);
  }
  
  public void a(Long paramLong, TroopAppInfo paramTroopAppInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, paramTroopAppInfo);
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      List localList;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopInfoManager.troop.special_msg", 2, "clearTroopMsgNavigateInfo, troopCode:" + paramString + "|type:" + paramInt);
        }
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
          continue;
        }
        localList = (List)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if ((localList == null) || (localList.isEmpty())) {
          continue;
        }
        i = localList.size() - 1;
        if (i >= 0)
        {
          TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localList.get(i);
          if ((paramInt != localTroopMessageNavigateInfo.type) && (paramInt != 0)) {
            break label206;
          }
          if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD) {
            localList.remove(i);
          } else {
            localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_DELETE;
          }
        }
      }
      finally {}
      if (localList.isEmpty())
      {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        continue;
        label206:
        i -= 1;
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, Object paramObject)
  {
    if (paramInt1 <= 0) {}
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    List localList;
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopInfoManager", 2, "addTroopMsgNavigateInfo,type:" + paramInt1 + "|seq:" + paramLong + "|summary:" + paramString2 + "|troopCode:" + paramString1);
        }
        localTroopMessageNavigateInfo = new TroopMessageNavigateInfo();
        localTroopMessageNavigateInfo.type = paramInt1;
        localTroopMessageNavigateInfo.troopCode = paramString1;
        localTroopMessageNavigateInfo.msgseq = paramLong;
        localTroopMessageNavigateInfo.summary = paramString2;
        localTroopMessageNavigateInfo.extObj = paramObject;
        if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)) {
          break label433;
        }
        paramObject = null;
        localList = (List)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
        if ((localList == null) || (localList.size() == 0)) {
          break label433;
        }
        if ((paramInt1 != 17) && (paramInt1 != 100) && (paramInt1 != 23) && (paramInt1 != 11)) {
          break label499;
        }
        paramString2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramString2 == null) {}
        for (paramString2 = null;; paramString2 = paramString2.b(paramString1))
        {
          if ((paramString2 == null) || (!paramString2.hasOrgs())) {
            break label499;
          }
          i = localList.size() - 1;
          label226:
          if (i < 0) {
            break label499;
          }
          paramString2 = (TroopMessageNavigateInfo)localList.get(i);
          if (paramInt1 == paramString2.type) {
            break;
          }
          paramString2.status = TroopMessageNavigateInfo.STATUS_DELETE;
          break;
        }
        label276:
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
        label284:
        localList.add(localTroopMessageNavigateInfo);
        a(paramString1);
      }
      finally {}
    }
    label307:
    int i = localList.size() - 1;
    paramString2 = paramObject;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramInt1 == ((TroopMessageNavigateInfo)localList.get(i)).type)
        {
          paramString2 = (TroopMessageNavigateInfo)localList.remove(i);
          break label526;
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.status == TroopMessageNavigateInfo.STATUS_DELETE))
        {
          localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
          if (paramInt1 != 26) {
            break label284;
          }
          localTroopMessageNavigateInfo.receivedFlowserCount = paramInt2;
          break label284;
        }
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_MODIFY;
        if (paramInt1 != 26) {
          break label284;
        }
        paramString2.receivedFlowserCount += paramInt2;
        break label284;
        label433:
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
        if (paramInt1 == 26) {
          localTroopMessageNavigateInfo.receivedFlowserCount = paramInt2;
        }
        paramString2 = new ArrayList();
        paramString2.add(localTroopMessageNavigateInfo);
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
        break;
      }
      break label526;
      i -= 1;
      break label226;
      label499:
      if ((paramInt1 == 17) || (paramInt1 == 100) || (paramInt1 == 10)) {
        break label276;
      }
      if (paramInt1 != 11) {
        break label307;
      }
      break label276;
      label526:
      i -= 1;
    }
  }
  
  public void a(String paramString, ArrayList<Long> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramArrayList);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, bdfr.encodeToString(paramArrayOfByte, 2));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public byte[] a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = bdfr.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  public long b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	auga:jdField_a_of_type_Boolean	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 101	auga:a	()V
    //   13: aload_0
    //   14: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: ifnull +105 -> 122
    //   20: aload_0
    //   21: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_1
    //   25: invokevirtual 82	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   28: ifeq +94 -> 122
    //   31: aload_0
    //   32: getfield 57	auga:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_1
    //   36: invokevirtual 86	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 88	java/util/List
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +16 -> 60
    //   47: aload_1
    //   48: invokeinterface 163 1 0
    //   53: istore 4
    //   55: iload 4
    //   57: ifeq +11 -> 68
    //   60: lconst_0
    //   61: lstore 5
    //   63: aload_0
    //   64: monitorexit
    //   65: lload 5
    //   67: lreturn
    //   68: aload_1
    //   69: invokeinterface 176 1 0
    //   74: istore_3
    //   75: iconst_0
    //   76: istore_2
    //   77: iload_2
    //   78: iload_3
    //   79: if_icmpge +43 -> 122
    //   82: aload_1
    //   83: iload_2
    //   84: invokeinterface 179 2 0
    //   89: checkcast 129	com/tencent/mobileqq/data/TroopMessageNavigateInfo
    //   92: astore 7
    //   94: aload 7
    //   96: getfield 133	com/tencent/mobileqq/data/TroopMessageNavigateInfo:status	I
    //   99: getstatic 158	com/tencent/mobileqq/data/TroopMessageNavigateInfo:STATUS_DELETE	I
    //   102: if_icmpne +10 -> 112
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore_2
    //   109: goto -32 -> 77
    //   112: aload 7
    //   114: getfield 291	com/tencent/mobileqq/data/TroopMessageNavigateInfo:msgseq	J
    //   117: lstore 5
    //   119: goto -56 -> 63
    //   122: lconst_0
    //   123: lstore 5
    //   125: goto -62 -> 63
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	auga
    //   0	133	1	paramString	String
    //   76	33	2	i	int
    //   74	6	3	j	int
    //   53	3	4	bool	boolean
    //   61	63	5	l	long
    //   92	21	7	localTroopMessageNavigateInfo	TroopMessageNavigateInfo
    // Exception table:
    //   from	to	target	type
    //   2	13	128	finally
    //   13	43	128	finally
    //   47	55	128	finally
    //   68	75	128	finally
    //   82	105	128	finally
    //   112	119	128	finally
  }
  
  public bbpd b(String paramString)
  {
    return (bbpd)this.e.remove(paramString);
  }
  
  protected void b()
  {
    ThreadManager.post(new TroopInfoManager.1(this), 8, null, false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void onDestroy()
  {
    c();
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        bbru localbbru = (bbru)localIterator.next();
        if (localbbru != null) {
          localbbru.deleteObservers();
        }
      }
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auga
 * JD-Core Version:    0.7.0.1
 */