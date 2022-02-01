import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSAction.Companion.MODE;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.logScheduler.1;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.recordActionByRecorder.2;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.releaseRecorder.1.1;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.tryStartQueueWhenEnvReady.scheduler.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager;", "", "()V", "PLAYER_NUM_THRESHOLD", "", "RECORDER_NUM_THRESHOLD", "TAG", "", "activePlayers", "", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer;", "activeRecorders", "idlePlayers", "idleRecorders", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "pausedActions", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem;", "pausedRecords", "playActionQueue", "Ljava/util/PriorityQueue;", "playerActionMap", "", "recordActionQueue", "recorderActionMap", "recorderKeyListenerMap", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "tryStartQueue", "", "waitingDoneRecords", "addRecorderListener", "", "actionItem", "checkEnvReady", "deletePausedActionItem", "target", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "deletePausedRecordItem", "findPausedActionItem", "delete", "findPausedRecordItem", "findPlayerByAction", "Lkotlin/Pair;", "findPlayerByPriority", "priority", "findRecordByAction", "getCurrentActionState", "getIdlePlayer", "getIdleRecorder", "pauseActionPlay", "action", "pauseActionRecord", "playAction", "width", "height", "recordKey", "container", "Landroid/widget/FrameLayout;", "listener", "playActionByBornPlayer", "player", "playActionByFramePlayer", "playActionByPriority", "playActionReal", "recordAction", "recordActionByPriority", "recordActionByRecorder", "recorder", "recordActionReal", "releasePlayer", "releaseRecorder", "resumeActionPlay", "resumeActionRecord", "stopActionPlay", "stopActionRecord", "tryStartQueueWhenEnvReady", "ActionItem", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amvy
{
  public static final amvy a;
  private static final List<amvq> jdField_a_of_type_JavaUtilList;
  private static final Map<amvq, amvz> jdField_a_of_type_JavaUtilMap;
  private static final PriorityQueue<amvz> jdField_a_of_type_JavaUtilPriorityQueue;
  private static final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static final List<amvq> jdField_b_of_type_JavaUtilList;
  private static final Map<amvq, amvz> jdField_b_of_type_JavaUtilMap;
  private static final PriorityQueue<amvz> jdField_b_of_type_JavaUtilPriorityQueue;
  private static final List<amvz> jdField_c_of_type_JavaUtilList;
  private static final Map<String, List<amvk>> jdField_c_of_type_JavaUtilMap;
  private static final List<amvq> d;
  private static final List<amvq> e;
  private static final List<amvz> f;
  private static final List<amvz> g;
  
  static
  {
    jdField_a_of_type_Amvy = new amvy();
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    jdField_a_of_type_JavaUtilList = (List)new ArrayList();
    jdField_b_of_type_JavaUtilList = (List)new ArrayList();
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    jdField_c_of_type_JavaUtilList = (List)new ArrayList();
    jdField_a_of_type_JavaUtilPriorityQueue = new PriorityQueue(6, (Comparator)amwa.a);
    d = (List)new ArrayList();
    e = (List)new ArrayList();
    jdField_b_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    jdField_c_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    f = (List)new ArrayList();
    g = (List)new ArrayList();
    jdField_b_of_type_JavaUtilPriorityQueue = new PriorityQueue(2, (Comparator)amwc.a);
    anbo.a();
    CMSBornPlayerManager.logScheduler.1 local1 = new CMSBornPlayerManager.logScheduler.1();
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)local1, 10000L);
  }
  
  private final amvq a()
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    for (;;)
    {
      try
      {
        amvq localamvq;
        if (d.size() > 0)
        {
          localamvq = (amvq)d.remove(0);
          if (localamvq != null) {
            e.add(localamvq);
          }
          return localamvq;
        }
        if (e.size() < 1) {
          localamvq = new amvq();
        } else {
          Object localObject2 = null;
        }
      }
      finally
      {
        localLock.unlock();
      }
    }
  }
  
  private final String a()
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    label733:
    label736:
    label741:
    label744:
    label749:
    label752:
    label757:
    label760:
    label765:
    for (;;)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        if (!jdField_a_of_type_JavaUtilMap.isEmpty())
        {
          i = 1;
          Iterator localIterator;
          Object localObject3;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append("current playActions(total:" + jdField_a_of_type_JavaUtilMap.size() + "), detail:\n");
            localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
            if (!localIterator.hasNext()) {
              break label733;
            }
            localObject3 = (Map.Entry)localIterator.next();
            ((StringBuilder)localObject1).append((amvq)((Map.Entry)localObject3).getKey() + " -> " + ((amvz)((Map.Entry)localObject3).getValue()).a().d() + " \n");
            continue;
          }
          if (((Collection)jdField_a_of_type_JavaUtilPriorityQueue).isEmpty()) {
            break label736;
          }
          i = 1;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append("playActionQueue(total:" + jdField_a_of_type_JavaUtilPriorityQueue.size() + "), detail:\n");
            localIterator = ((Iterable)jdField_a_of_type_JavaUtilPriorityQueue).iterator();
            if (!localIterator.hasNext()) {
              break label741;
            }
            localObject3 = (amvz)localIterator.next();
            ((StringBuilder)localObject1).append(((amvz)localObject3).a().d() + '\n');
            continue;
          }
          if (jdField_b_of_type_JavaUtilMap.isEmpty()) {
            break label744;
          }
          i = 1;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append("current recordActions(total:" + jdField_b_of_type_JavaUtilMap.size() + "), detail:\n");
            localIterator = jdField_b_of_type_JavaUtilMap.entrySet().iterator();
            if (!localIterator.hasNext()) {
              break label749;
            }
            localObject3 = (Map.Entry)localIterator.next();
            ((StringBuilder)localObject1).append((amvq)((Map.Entry)localObject3).getKey() + " -> " + ((amvz)((Map.Entry)localObject3).getValue()).a().d() + '\n');
            continue;
          }
          if (((Collection)g).isEmpty()) {
            break label752;
          }
          i = 1;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append("current waiting encode actions(total:" + g.size() + "), detail:\n");
            localIterator = ((Iterable)g).iterator();
            if (!localIterator.hasNext()) {
              break label757;
            }
            localObject3 = (amvz)localIterator.next();
            ((StringBuilder)localObject1).append(((amvz)localObject3).a().d() + '\n');
            continue;
          }
          if (((Collection)jdField_b_of_type_JavaUtilPriorityQueue).isEmpty()) {
            break label760;
          }
          i = 1;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append("recordActionQueue(total:" + jdField_b_of_type_JavaUtilPriorityQueue.size() + "), detail:\n");
            localIterator = ((Iterable)jdField_b_of_type_JavaUtilPriorityQueue).iterator();
            if (!localIterator.hasNext()) {
              break label765;
            }
            localObject3 = (amvz)localIterator.next();
            ((StringBuilder)localObject1).append(((amvz)localObject3).a().d() + '\n');
            continue;
          }
          localObject1 = ((StringBuilder)localObject1).toString();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
          return localObject1;
        }
      }
      finally
      {
        localLock.unlock();
      }
      int i = 0;
      continue;
      continue;
      i = 0;
      continue;
      continue;
      i = 0;
      continue;
      continue;
      i = 0;
      continue;
      continue;
      i = 0;
    }
  }
  
  /* Error */
  private final void a()
  {
    // Byte code:
    //   0: getstatic 114	amvy:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   3: checkcast 193	java/util/concurrent/locks/Lock
    //   6: astore_1
    //   7: aload_1
    //   8: invokeinterface 195 1 0
    //   13: getstatic 165	amvy:jdField_b_of_type_JavaUtilPriorityQueue	Ljava/util/PriorityQueue;
    //   16: invokevirtual 316	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   19: checkcast 270	amvz
    //   22: astore_2
    //   23: getstatic 109	amvy:jdField_a_of_type_Amvy	Lamvy;
    //   26: astore_3
    //   27: aload_2
    //   28: ldc_w 318
    //   31: invokestatic 305	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   34: aload_3
    //   35: aload_2
    //   36: invokespecial 321	amvy:a	(Lamvz;)V
    //   39: getstatic 327	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   42: astore_2
    //   43: aload_1
    //   44: invokeinterface 212 1 0
    //   49: return
    //   50: astore_2
    //   51: aload_1
    //   52: invokeinterface 212 1 0
    //   57: aload_2
    //   58: athrow
    //   59: astore_2
    //   60: goto -21 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	amvy
    //   6	46	1	localLock	Lock
    //   22	21	2	localObject1	Object
    //   50	8	2	localObject2	Object
    //   59	1	2	localNoSuchElementException	java.util.NoSuchElementException
    //   26	9	3	localamvy	amvy
    // Exception table:
    //   from	to	target	type
    //   13	39	50	finally
    //   39	43	50	finally
    //   13	39	59	java/util/NoSuchElementException
  }
  
  private final void a(amvq paramamvq)
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      jdField_b_of_type_JavaUtilMap.remove(paramamvq);
      d.add(paramamvq);
      e.remove(paramamvq);
      amve.a.a((Function0)CMSBornPlayerManager.releaseRecorder.1.1.INSTANCE);
      paramamvq = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final void a(amvz paramamvz)
  {
    Object localObject1 = CMSAction.a(paramamvz.a(), null, null, 3, null);
    Object localObject2 = anbo.a.a((String)localObject1);
    Object localObject3;
    if (localObject2 != null)
    {
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramamvz.a().d() + " success from cache, path:" + ((File)localObject2).getAbsolutePath());
      localObject3 = paramamvz.a();
      if (localObject3 != null) {
        ((amvk)localObject3).a(paramamvz.a(), true, (String)localObject1, ((File)localObject2).getAbsolutePath());
      }
      return;
    }
    localObject2 = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject2).lock();
    try
    {
      localObject3 = jdField_b_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(CMSAction.a(((amvz)((Map.Entry)((Iterator)localObject3).next()).getValue()).a(), null, null, 3, null), localObject1))
        {
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramamvz.a().d() + ", already in recording");
          jdField_a_of_type_Amvy.b(paramamvz);
          return;
        }
      }
      localObject3 = g.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(CMSAction.a(((amvz)((Iterator)localObject3).next()).a(), null, null, 3, null), localObject1))
        {
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramamvz.a().d() + ", already in waiting encode");
          jdField_a_of_type_Amvy.b(paramamvz);
          return;
        }
      }
      localObject3 = jdField_b_of_type_JavaUtilPriorityQueue.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(CMSAction.a(((amvz)((Iterator)localObject3).next()).a(), null, null, 3, null), localObject1))
        {
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramamvz.a().d() + ", already in record queue");
          jdField_a_of_type_Amvy.b(paramamvz);
          return;
        }
      }
      if (jdField_a_of_type_Amvy.a())
      {
        localObject1 = jdField_a_of_type_Amvy.a();
        if (localObject1 != null) {
          jdField_a_of_type_Amvy.a(paramamvz, (amvq)localObject1);
        }
      }
      else
      {
        jdField_a_of_type_Amvy.b();
      }
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "add action to record queue, " + paramamvz.a().d());
      jdField_b_of_type_JavaUtilPriorityQueue.add(paramamvz);
      return;
    }
    finally
    {
      ((Lock)localObject2).unlock();
    }
  }
  
  private final void a(amvz paramamvz, amvq paramamvq)
  {
    amwb localamwb = new amwb(paramamvz, paramamvq);
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      jdField_b_of_type_JavaUtilMap.put(paramamvq, paramamvz);
      jdField_a_of_type_Amvy.b(paramamvz);
      Unit localUnit = Unit.INSTANCE;
      localLock.unlock();
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordActionByRecorder, " + paramamvz.a().d() + ", width:" + paramamvz.a() + ", height:" + paramamvz.b() + ", player:" + paramamvq);
      anis.a(paramamvz.a().a().toReportFeatureId(), null, CMSAction.a(paramamvz.a(), null, null, 3, null));
      amve.a.a((Function0)new CMSBornPlayerManager.recordActionByRecorder.2(paramamvz, paramamvq, localamwb));
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final boolean a()
  {
    return (ApolloEngine.a()) && (!TextUtils.isEmpty((CharSequence)amme.d)) && (!TextUtils.isEmpty((CharSequence)amme.e));
  }
  
  private final void b()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    CMSBornPlayerManager.tryStartQueueWhenEnvReady.scheduler.1 local1 = new CMSBornPlayerManager.tryStartQueueWhenEnvReady.scheduler.1();
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "tryStartQueueWhenEnvReady after 1000ms, current recordQueue size:" + jdField_b_of_type_JavaUtilPriorityQueue.size());
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)local1, 1000L);
  }
  
  private final void b(amvz paramamvz)
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      Object localObject = CMSAction.a(paramamvz.a(), null, null, 3, null);
      if (!jdField_c_of_type_JavaUtilMap.containsKey(localObject)) {
        jdField_c_of_type_JavaUtilMap.put(localObject, (List)new ArrayList());
      }
      localObject = jdField_c_of_type_JavaUtilMap.get(localObject);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      List localList = (List)localObject;
      paramamvz = paramamvz.a();
      if (paramamvz != null) {
        localList.add(paramamvz);
      }
      paramamvz = (List)localObject;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull CMSAction paramCMSAction, @Nullable amvk paramamvk)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    a(new amvz(paramInt1, paramInt2, CMSAction.a(paramCMSAction, null, null, 3, null), paramCMSAction, null, paramamvk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvy
 * JD-Core Version:    0.7.0.1
 */