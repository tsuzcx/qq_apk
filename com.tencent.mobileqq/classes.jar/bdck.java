import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

public class bdck
  implements Handler.Callback, Manager
{
  Handler jdField_a_of_type_AndroidOsHandler;
  avki<bdch, QQAppInterface> jdField_a_of_type_Avki;
  bdcn jdField_a_of_type_Bdcn = new bdcl(this);
  QQLruCache<String, List<TofuItem>> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2021, 8, 1);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  Set<String> jdField_a_of_type_JavaUtilSet;
  
  public bdck(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Avki = new bdcm(this);
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Bdcn, true);
  }
  
  private static TofuItem a(List<TofuItem> paramList, int paramInt)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TofuItem localTofuItem = (TofuItem)paramList.next();
      if (localTofuItem.busId == paramInt) {
        return localTofuItem;
      }
    }
    return null;
  }
  
  private void a(String paramString, int paramInt)
  {
    List localList = a(paramString, paramInt);
    if ((NetworkUtil.isNetworkAvailable()) && (a(paramString, localList))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_TofuManager", 2, String.format("WHAT_PREPARE_PULL_TOFUDATA uin=%s reqSize=%d hasReq=%b", new Object[] { MobileQQ.getShortUinStr(paramString), Integer.valueOf(localList.size()), Boolean.valueOf(bool) }));
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString, List<oidb_0xe61.BeancurdCubeInfoResult> paramList)
  {
    List localList;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      localList = a(paramString);
    }
    try
    {
      aezm localaezm = (aezm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
      a(paramList, new bdcd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaezm, this.jdField_a_of_type_Avki));
      paramBoolean = a(paramString, paramList, localList);
      if (localList.size() > 0) {
        a(paramString, localList, paramBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_TofuManager", 2, String.format("WHAT_GET_PULLED_DATA frdUin=%s", new Object[] { MobileQQ.getShortUinStr(paramString) }));
      }
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return paramEntityManager.update(paramEntity);
      }
    }
    QLog.d("Tofu_TofuManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  @NotNull
  protected List<TofuItem> a(String paramString)
  {
    long l;
    synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
    {
      ??? = (List)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
      if (??? != null) {
        break label228;
      }
      l = System.currentTimeMillis();
    }
    for (;;)
    {
      try
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TofuItem.class, false, "frdUin=?", new String[] { paramString }, null, null, null, null);
        ??? = ???;
        ??? = ???;
        if (??? == null) {
          ??? = new ArrayList(bdcf.a.length);
        }
        int i = localException.size();
      }
      catch (Exception localException)
      {
        synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
        {
          this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, ???);
          if (QLog.isColorLevel())
          {
            paramString = MobileQQ.getShortUinStr(paramString);
            if (??? == null)
            {
              i = 0;
              QLog.i("Tofu_TofuManager", 2, String.format("readTofuItems %s size=%d cost=%dms", new Object[] { paramString, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) }));
            }
          }
          else
          {
            return ???;
            paramString = finally;
            throw paramString;
            localException = localException;
            QLog.d("Tofu_TofuManager", 1, "readTofuItems exception + " + localException.getMessage(), localException);
          }
        }
      }
    }
    label228:
    return ???;
  }
  
  @NotNull
  protected List<TofuItem> a(String paramString, int paramInt)
  {
    List localList = a(paramString);
    ArrayList localArrayList = new ArrayList(bdcf.a.length);
    long l = System.currentTimeMillis() / 1000L;
    int i = 0;
    while (i < bdcf.a.length)
    {
      bdce localbdce = ((bdch)this.jdField_a_of_type_Avki.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).a(i);
      TofuItem localTofuItem2 = a(localList, i);
      TofuItem localTofuItem1 = localTofuItem2;
      if (localTofuItem2 == null) {
        localTofuItem1 = new TofuItem(paramString, i);
      }
      localTofuItem1 = localbdce.a(localTofuItem1, l, paramInt);
      if (localTofuItem1 != null) {
        localArrayList.add(localTofuItem1);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(String paramString)
  {
    int j = -1;
    List localList;
    synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
    {
      localList = (List)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.remove(paramString);
    }
    try
    {
      ??? = TableBuilder.getTableName(TofuItem.class);
      i = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete((String)???, "frdUin=?", new String[] { paramString });
      if (QLog.isColorLevel())
      {
        if (localList == null) {
          QLog.i("Tofu_TofuManager", 2, String.format("onDelFriend frdUin=%s delCacheItems=%d delDbCnt=%d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(i) }));
        }
      }
      else
      {
        return;
        paramString = finally;
        throw paramString;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        QLog.d("Tofu_TofuManager", 1, localInstantiationException.getMessage(), localInstantiationException);
        i = -1;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        QLog.d("Tofu_TofuManager", 1, localIllegalAccessException.getMessage(), localIllegalAccessException);
        i = -1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("Tofu_TofuManager", 1, localThrowable.getMessage(), localThrowable);
        int i = -1;
        continue;
        j = localList.size();
      }
    }
  }
  
  /* Error */
  protected void a(String paramString, List<TofuItem> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 252	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getfield 83	bdck:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: invokevirtual 339	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   12: astore 6
    //   14: aload 6
    //   16: invokevirtual 344	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_2
    //   20: invokeinterface 95 1 0
    //   25: astore 7
    //   27: aload 7
    //   29: invokeinterface 101 1 0
    //   34: ifeq +152 -> 186
    //   37: aload 7
    //   39: invokeinterface 105 1 0
    //   44: checkcast 107	com/tencent/mobileqq/tofumsg/TofuItem
    //   47: astore 8
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 83	bdck:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   54: aload 8
    //   56: invokespecial 346	bdck:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   59: pop
    //   60: goto -33 -> 27
    //   63: astore 7
    //   65: ldc 138
    //   67: iconst_1
    //   68: new 224	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 348
    //   78: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 7
    //   83: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   86: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: aload 7
    //   94: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   97: aload 6
    //   99: invokevirtual 351	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   102: iload_3
    //   103: ifeq +25 -> 128
    //   106: aload_0
    //   107: getfield 31	bdck:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   110: astore 6
    //   112: aload 6
    //   114: monitorenter
    //   115: aload_0
    //   116: getfield 31	bdck:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   119: aload_1
    //   120: aload_2
    //   121: invokevirtual 272	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: pop
    //   125: aload 6
    //   127: monitorexit
    //   128: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +54 -> 185
    //   134: ldc 138
    //   136: iconst_2
    //   137: ldc_w 353
    //   140: iconst_4
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: aload_1
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: aload_2
    //   151: invokeinterface 150 1 0
    //   156: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: invokestatic 252	java/lang/System:currentTimeMillis	()J
    //   165: lload 4
    //   167: lsub
    //   168: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: aastore
    //   172: dup
    //   173: iconst_3
    //   174: iload_3
    //   175: invokestatic 161	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   178: aastore
    //   179: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   182: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: return
    //   186: aload 6
    //   188: invokevirtual 356	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   191: aload 6
    //   193: invokevirtual 351	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   196: goto -94 -> 102
    //   199: astore_1
    //   200: aload 6
    //   202: invokevirtual 351	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   205: aload_1
    //   206: athrow
    //   207: astore_1
    //   208: aload 6
    //   210: monitorexit
    //   211: aload_1
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	bdck
    //   0	213	1	paramString	String
    //   0	213	2	paramList	List<TofuItem>
    //   0	213	3	paramBoolean	boolean
    //   3	163	4	l	long
    //   25	13	7	localIterator	Iterator
    //   63	30	7	localException	Exception
    //   47	8	8	localTofuItem	TofuItem
    // Exception table:
    //   from	to	target	type
    //   19	27	63	java/lang/Exception
    //   27	60	63	java/lang/Exception
    //   186	191	63	java/lang/Exception
    //   19	27	199	finally
    //   27	60	199	finally
    //   65	97	199	finally
    //   186	191	199	finally
    //   115	128	207	finally
    //   208	211	207	finally
  }
  
  protected void a(List<oidb_0xe61.BeancurdCubeInfoResult> paramList, Comparator paramComparator)
  {
    if ((paramList == null) || (paramList.size() <= 1)) {
      return;
    }
    Collections.sort(paramList, paramComparator);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    String str = MobileQQ.getShortUinStr(paramString);
    if ((TextUtils.isEmpty(paramString)) || (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
    {
      QLog.i("Tofu_TofuManager", 1, String.format("startCheckPullTofuData return. [%s, %d]", new Object[] { str, Integer.valueOf(paramInt) }));
      return false;
    }
    QLog.i("Tofu_TofuManager", 1, String.format("startCheckPullTofuData [%s, %d]", new Object[] { str, Integer.valueOf(paramInt) }));
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, paramInt, 0, paramString).sendToTarget();
    return true;
  }
  
  protected boolean a(String paramString, List<TofuItem> paramList)
  {
    if (paramList.size() == 0) {
      return false;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (TofuItem)paramList.next();
      localObject = ((bdch)this.jdField_a_of_type_Avki.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).a(((TofuItem)localObject).busId).a((TofuItem)localObject);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    ((bdci)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(177)).a(paramString, localArrayList);
    return true;
  }
  
  protected boolean a(String paramString, List<oidb_0xe61.BeancurdCubeInfoResult> paramList, List<TofuItem> paramList1)
  {
    long l = System.currentTimeMillis() / 1000L;
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      oidb_0xe61.BeancurdCubeInfoResult localBeancurdCubeInfoResult = (oidb_0xe61.BeancurdCubeInfoResult)localIterator.next();
      if ((localBeancurdCubeInfoResult == null) || (!localBeancurdCubeInfoResult.beancurdCubeInfo.has()) || (localBeancurdCubeInfoResult.beancurdCubeInfo.get() == null) || (!localBeancurdCubeInfoResult.beancurdCubeInfo.uint64_busi_id.has())) {
        break label183;
      }
      int i = bdcf.b((int)((oidb_0xe61.BeancurdCubeInfo)localBeancurdCubeInfoResult.beancurdCubeInfo.get()).uint64_busi_id.get());
      if (i != -1)
      {
        paramList = a(paramList1, i);
        if (paramList != null) {
          break label180;
        }
        paramList = new TofuItem(paramString, i);
        paramList1.add(paramList);
        bool = true;
        label145:
        ((bdch)this.jdField_a_of_type_Avki.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).a(i).a(paramList, localBeancurdCubeInfoResult, l);
      }
    }
    label180:
    label183:
    for (;;)
    {
      break;
      return bool;
      break label145;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      a((String)paramMessage.obj, paramMessage.arg1);
      return false;
    }
    paramMessage = (Object[])paramMessage.obj;
    a(((Boolean)paramMessage[0]).booleanValue(), (String)paramMessage[1], (List)paramMessage[2]);
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdcn);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    ((bdch)this.jdField_a_of_type_Avki.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdck
 * JD-Core Version:    0.7.0.1
 */