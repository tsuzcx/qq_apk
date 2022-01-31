package com.tencent.mobileqq.apollo.process.data;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import yol;

public class CmGameManager
  implements Manager
{
  protected BroadcastReceiver a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ApolloCmdChannel jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public CmGameManager(AppInterface paramAppInterface)
  {
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] created.");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel = new ApolloCmdChannel(CmGameUtil.a());
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yol();
    paramAppInterface = new IntentFilter();
    paramAppInterface.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    try
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramAppInterface, "com.tencent.msg.permission.pushnotify", null);
      }
      return;
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("cmgame_process.CmGameManager", 1, paramAppInterface, new Object[0]);
    }
  }
  
  public ApolloCmdChannel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel;
  }
  
  public CmGameLauncher a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      CmGameLauncher localCmGameLauncher = (CmGameLauncher)localIterator.next();
      if ((localCmGameLauncher != null) && (!CmGameUtil.a(localCmGameLauncher.a()))) {
        return localCmGameLauncher;
      }
    }
    return null;
  }
  
  public CmGameLauncher a(int paramInt)
  {
    try
    {
      CmGameLauncher localCmGameLauncher2 = c(paramInt);
      CmGameLauncher localCmGameLauncher1 = localCmGameLauncher2;
      if (localCmGameLauncher2 == null)
      {
        localCmGameLauncher1 = new CmGameLauncher(paramInt);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localCmGameLauncher1);
        QLog.i("cmgame_process.CmGameManager", 1, "add a new launcher, gameId:" + paramInt + ",total size:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      }
      return localCmGameLauncher1;
    }
    finally {}
  }
  
  /* Error */
  public CmGameLauncher a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/mobileqq/apollo/process/data/CmGameManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 91	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 6
    //   11: aload 6
    //   13: invokeinterface 97 1 0
    //   18: ifeq +49 -> 67
    //   21: aload 6
    //   23: invokeinterface 101 1 0
    //   28: checkcast 103	com/tencent/mobileqq/apollo/process/data/CmGameLauncher
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull -24 -> 11
    //   38: aload 5
    //   40: invokevirtual 145	com/tencent/mobileqq/apollo/process/data/CmGameLauncher:a	()Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   43: astore 7
    //   45: aload 7
    //   47: ifnull -36 -> 11
    //   50: aload 7
    //   52: invokevirtual 151	com/tencent/mobileqq/apollo/ApolloSurfaceView:getLuaState	()J
    //   55: lstore_3
    //   56: lload_3
    //   57: lload_1
    //   58: lcmp
    //   59: ifne -48 -> 11
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 5
    //   66: areturn
    //   67: aconst_null
    //   68: astore 5
    //   70: goto -8 -> 62
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	CmGameManager
    //   0	80	1	paramLong	long
    //   55	2	3	l	long
    //   31	38	5	localCmGameLauncher	CmGameLauncher
    //   73	5	5	localObject	Object
    //   9	13	6	localIterator	Iterator
    //   43	8	7	localApolloSurfaceView	com.tencent.mobileqq.apollo.ApolloSurfaceView
    // Exception table:
    //   from	to	target	type
    //   2	11	73	finally
    //   11	33	73	finally
    //   38	45	73	finally
    //   50	56	73	finally
  }
  
  public String a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) != null) {
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    return "^(apollo_game_[_a-zA-Z0-9.]*|apollo_aio_game[_a-zA-Z0-9.]*)";
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "ssoCmdRule gameId: " + paramInt + ", rule: ", paramString });
    }
    if ((paramInt > 0) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramString);
    }
  }
  
  /* Error */
  public CmGameLauncher b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/mobileqq/apollo/process/data/CmGameManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 91	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface 97 1 0
    //   16: ifeq +80 -> 96
    //   19: aload_3
    //   20: invokeinterface 101 1 0
    //   25: checkcast 103	com/tencent/mobileqq/apollo/process/data/CmGameLauncher
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -20 -> 10
    //   33: iload_1
    //   34: aload_2
    //   35: invokevirtual 106	com/tencent/mobileqq/apollo/process/data/CmGameLauncher:a	()I
    //   38: if_icmpne -28 -> 10
    //   41: aload_0
    //   42: getfield 24	com/tencent/mobileqq/apollo/process/data/CmGameManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   45: aload_2
    //   46: invokevirtual 192	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   49: ifeq -39 -> 10
    //   52: ldc 31
    //   54: iconst_1
    //   55: new 122	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   62: ldc 194
    //   64: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc 134
    //   73: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: getfield 24	com/tencent/mobileqq/apollo/process/data/CmGameManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   80: invokevirtual 137	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   83: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 39	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_2
    //   95: areturn
    //   96: aconst_null
    //   97: astore_2
    //   98: goto -6 -> 92
    //   101: astore_2
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_2
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	CmGameManager
    //   0	106	1	paramInt	int
    //   28	70	2	localCmGameLauncher	CmGameLauncher
    //   101	4	2	localObject	Object
    //   9	11	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	10	101	finally
    //   10	29	101	finally
    //   33	92	101	finally
  }
  
  public CmGameLauncher c(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      CmGameLauncher localCmGameLauncher = (CmGameLauncher)localIterator.next();
      if ((localCmGameLauncher != null) && (paramInt == localCmGameLauncher.a())) {
        return localCmGameLauncher;
      }
    }
    return null;
  }
  
  public void onDestroy()
  {
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] destroyed.");
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameManager", 1, "[doDestroy] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameManager
 * JD-Core Version:    0.7.0.1
 */