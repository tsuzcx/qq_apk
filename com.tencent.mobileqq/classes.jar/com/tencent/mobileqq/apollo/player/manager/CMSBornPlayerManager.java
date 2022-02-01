package com.tencent.mobileqq.apollo.player.manager;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
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
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager;", "", "()V", "PLAYER_NUM_THRESHOLD", "", "RECORDER_NUM_THRESHOLD", "TAG", "", "activePlayers", "", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer;", "activeRecorders", "dressNotReadyRecords", "", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem;", "idlePlayers", "idleRecorders", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "pausedActions", "pausedRecords", "playActionQueue", "Ljava/util/PriorityQueue;", "playerActionMap", "recordActionQueue", "recorderActionMap", "recorderKeyListenerMap", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "tryStartQueue", "", "waitingDoneRecords", "addRecorderListener", "", "actionItem", "checkEnvReady", "checkRoleDressReady", "key", "deletePausedActionItem", "target", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "deletePausedRecordItem", "findPausedActionItem", "delete", "findPausedRecordItem", "findPlayerByAction", "Lkotlin/Pair;", "findPlayerByPriority", "priority", "findRecordByAction", "getCurrentActionState", "getIdlePlayer", "getIdleRecorder", "pauseActionPlay", "action", "pauseActionRecord", "playAction", "width", "height", "recordKey", "container", "Landroid/widget/FrameLayout;", "listener", "playActionByBornPlayer", "player", "playActionByFramePlayer", "playActionByPriority", "playActionReal", "recordAction", "recordActionByPriority", "recordActionByRecorder", "recorder", "recordActionReal", "releasePlayer", "releaseRecorder", "resumeActionPlay", "resumeActionRecord", "stopActionPlay", "stopActionRecord", "tryStartQueueWhenEnvReady", "ActionItem", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayerManager
{
  public static final CMSBornPlayerManager a;
  private static final List<CMSBornPlayer> jdField_a_of_type_JavaUtilList;
  private static final Map<CMSBornPlayer, CMSBornPlayerManager.ActionItem> jdField_a_of_type_JavaUtilMap;
  private static final PriorityQueue<CMSBornPlayerManager.ActionItem> jdField_a_of_type_JavaUtilPriorityQueue;
  private static final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static final List<CMSBornPlayer> jdField_b_of_type_JavaUtilList;
  private static final Map<CMSBornPlayer, CMSBornPlayerManager.ActionItem> jdField_b_of_type_JavaUtilMap;
  private static final PriorityQueue<CMSBornPlayerManager.ActionItem> jdField_b_of_type_JavaUtilPriorityQueue;
  private static final List<CMSBornPlayerManager.ActionItem> jdField_c_of_type_JavaUtilList;
  private static final Map<String, List<ICMSPlayerListener>> jdField_c_of_type_JavaUtilMap;
  private static final List<CMSBornPlayer> jdField_d_of_type_JavaUtilList;
  private static final Map<String, CMSBornPlayerManager.ActionItem> jdField_d_of_type_JavaUtilMap;
  private static final List<CMSBornPlayer> e;
  private static final List<CMSBornPlayerManager.ActionItem> f;
  private static final List<CMSBornPlayerManager.ActionItem> g;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager = new CMSBornPlayerManager();
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    jdField_a_of_type_JavaUtilList = (List)new ArrayList();
    jdField_b_of_type_JavaUtilList = (List)new ArrayList();
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    jdField_c_of_type_JavaUtilList = (List)new ArrayList();
    jdField_a_of_type_JavaUtilPriorityQueue = new PriorityQueue(6, (Comparator)CMSBornPlayerManager.playActionQueue.1.a);
    jdField_d_of_type_JavaUtilList = (List)new ArrayList();
    e = (List)new ArrayList();
    jdField_b_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    jdField_c_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    f = (List)new ArrayList();
    g = (List)new ArrayList();
    jdField_d_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    jdField_b_of_type_JavaUtilPriorityQueue = new PriorityQueue(2, (Comparator)CMSBornPlayerManager.recordActionQueue.1.a);
    ApolloScreenshotController.a();
    CMSBornPlayerManager.logScheduler.1 local1 = new CMSBornPlayerManager.logScheduler.1();
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)local1, 10000L);
  }
  
  private final CMSBornPlayer a()
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    for (;;)
    {
      try
      {
        CMSBornPlayer localCMSBornPlayer;
        if (jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localCMSBornPlayer = (CMSBornPlayer)jdField_a_of_type_JavaUtilList.remove(0);
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 2, "getIdlePlayer from idlePlayers " + localCMSBornPlayer);
          if (localCMSBornPlayer != null) {
            jdField_b_of_type_JavaUtilList.add(localCMSBornPlayer);
          }
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 2, "getIdlePlayer return:" + localCMSBornPlayer + ", idlePlayer size:" + jdField_a_of_type_JavaUtilList.size() + ", activePlayer size:" + jdField_b_of_type_JavaUtilList.size());
          return localCMSBornPlayer;
        }
        if (jdField_b_of_type_JavaUtilList.size() < 3)
        {
          localCMSBornPlayer = new CMSBornPlayer();
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 2, "getIdlePlayer by create " + localCMSBornPlayer);
          continue;
        }
        QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 2, "getIdlePlayer failed return null");
      }
      finally
      {
        localLock.unlock();
      }
      Object localObject2 = null;
    }
  }
  
  private final CMSBornPlayerManager.ActionItem a(CMSAction paramCMSAction, boolean paramBoolean)
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    for (;;)
    {
      CMSBornPlayerManager.ActionItem localActionItem1;
      try
      {
        localActionItem1 = (CMSBornPlayerManager.ActionItem)null;
        Iterator localIterator = jdField_c_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          CMSBornPlayerManager.ActionItem localActionItem2 = (CMSBornPlayerManager.ActionItem)localIterator.next();
          if (!Intrinsics.areEqual(localActionItem2.a(), paramCMSAction)) {
            continue;
          }
          paramCMSAction = localActionItem2;
          if ((paramBoolean) && (paramCMSAction != null)) {
            jdField_c_of_type_JavaUtilList.remove(paramCMSAction);
          }
          return paramCMSAction;
        }
      }
      finally
      {
        localLock.unlock();
      }
      paramCMSAction = localActionItem1;
    }
  }
  
  private final String a()
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    label771:
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
              break label739;
            }
            localObject3 = (Map.Entry)localIterator.next();
            ((StringBuilder)localObject1).append((CMSBornPlayer)((Map.Entry)localObject3).getKey() + " -> " + ((CMSBornPlayerManager.ActionItem)((Map.Entry)localObject3).getValue()).a().d() + " \n");
            continue;
          }
          if (((Collection)jdField_a_of_type_JavaUtilPriorityQueue).isEmpty()) {
            break label742;
          }
          i = 1;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append("playActionQueue(total:" + jdField_a_of_type_JavaUtilPriorityQueue.size() + "), detail:\n");
            localIterator = ((Iterable)jdField_a_of_type_JavaUtilPriorityQueue).iterator();
            if (!localIterator.hasNext()) {
              break label747;
            }
            localObject3 = (CMSBornPlayerManager.ActionItem)localIterator.next();
            ((StringBuilder)localObject1).append(((CMSBornPlayerManager.ActionItem)localObject3).a().d() + '\n');
            continue;
          }
          if (jdField_b_of_type_JavaUtilMap.isEmpty()) {
            break label750;
          }
          i = 1;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append("current recordActions(total:" + jdField_b_of_type_JavaUtilMap.size() + "), detail:\n");
            localIterator = jdField_b_of_type_JavaUtilMap.entrySet().iterator();
            if (!localIterator.hasNext()) {
              break label755;
            }
            localObject3 = (Map.Entry)localIterator.next();
            ((StringBuilder)localObject1).append((CMSBornPlayer)((Map.Entry)localObject3).getKey() + " -> " + ((CMSBornPlayerManager.ActionItem)((Map.Entry)localObject3).getValue()).a().d() + '\n');
            continue;
          }
          if (((Collection)g).isEmpty()) {
            break label758;
          }
          i = 1;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append("current waiting encode actions(total:" + g.size() + "), detail:\n");
            localIterator = ((Iterable)g).iterator();
            if (!localIterator.hasNext()) {
              break label763;
            }
            localObject3 = (CMSBornPlayerManager.ActionItem)localIterator.next();
            ((StringBuilder)localObject1).append(((CMSBornPlayerManager.ActionItem)localObject3).a().d() + '\n');
            continue;
          }
          if (((Collection)jdField_b_of_type_JavaUtilPriorityQueue).isEmpty()) {
            break label766;
          }
          i = 1;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append("recordActionQueue(total:" + jdField_b_of_type_JavaUtilPriorityQueue.size() + "), detail:\n");
            localIterator = ((Iterable)jdField_b_of_type_JavaUtilPriorityQueue).iterator();
            if (!localIterator.hasNext()) {
              break label771;
            }
            localObject3 = (CMSBornPlayerManager.ActionItem)localIterator.next();
            ((StringBuilder)localObject1).append(((CMSBornPlayerManager.ActionItem)localObject3).a().d() + '\n');
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
      label739:
      continue;
      label742:
      i = 0;
      continue;
      label747:
      continue;
      label750:
      i = 0;
      continue;
      label755:
      continue;
      label758:
      i = 0;
      continue;
      label763:
      continue;
      label766:
      i = 0;
    }
  }
  
  private final Pair<CMSBornPlayer, CMSBornPlayerManager.ActionItem> a(int paramInt)
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      Pair localPair = (Pair)null;
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((CMSBornPlayerManager.ActionItem)localEntry.getValue()).a().b() >= paramInt) {
          break label188;
        }
        if (localPair != null)
        {
          int i = ((CMSBornPlayerManager.ActionItem)localEntry.getValue()).a().b();
          Object localObject2 = localPair.getSecond();
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          if (i >= ((CMSBornPlayerManager.ActionItem)localObject2).a().b()) {
            break label188;
          }
        }
        localPair = new Pair(localEntry.getKey(), localEntry.getValue());
      }
      for (;;)
      {
        break;
        if (localPair != null) {}
        for (;;)
        {
          return localPair;
          localPair = new Pair(null, null);
        }
      }
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final Pair<CMSBornPlayer, CMSBornPlayerManager.ActionItem> a(CMSAction paramCMSAction)
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (Intrinsics.areEqual(((CMSBornPlayerManager.ActionItem)localEntry.getValue()).a(), paramCMSAction))
        {
          paramCMSAction = new Pair(localEntry.getKey(), localEntry.getValue());
          return paramCMSAction;
        }
      }
      paramCMSAction = new Pair(null, null);
      return paramCMSAction;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  /* Error */
  private final void a()
  {
    // Byte code:
    //   0: getstatic 117	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   3: checkcast 198	java/util/concurrent/locks/Lock
    //   6: astore_1
    //   7: aload_1
    //   8: invokeinterface 200 1 0
    //   13: getstatic 149	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager:jdField_a_of_type_JavaUtilPriorityQueue	Ljava/util/PriorityQueue;
    //   16: invokevirtual 367	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   19: checkcast 258	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem
    //   22: astore_2
    //   23: getstatic 372	com/tencent/mobileqq/apollo/player/CMSHelper:a	Lcom/tencent/mobileqq/apollo/player/CMSHelper;
    //   26: new 374	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$playActionByPriority$1$1
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 377	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$playActionByPriority$1$1:<init>	(Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem;)V
    //   34: checkcast 379	kotlin/jvm/functions/Function0
    //   37: invokevirtual 382	com/tencent/mobileqq/apollo/player/CMSHelper:a	(Lkotlin/jvm/functions/Function0;)V
    //   40: getstatic 388	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   43: astore_2
    //   44: aload_1
    //   45: invokeinterface 250 1 0
    //   50: return
    //   51: astore_2
    //   52: aload_1
    //   53: invokeinterface 250 1 0
    //   58: aload_2
    //   59: athrow
    //   60: astore_2
    //   61: goto -21 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	CMSBornPlayerManager
    //   6	47	1	localLock	Lock
    //   22	22	2	localObject1	Object
    //   51	8	2	localObject2	Object
    //   60	1	2	localNoSuchElementException	java.util.NoSuchElementException
    // Exception table:
    //   from	to	target	type
    //   13	40	51	finally
    //   40	44	51	finally
    //   13	40	60	java/util/NoSuchElementException
  }
  
  private final void a(CMSBornPlayer paramCMSBornPlayer)
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      jdField_a_of_type_JavaUtilMap.remove(paramCMSBornPlayer);
      jdField_a_of_type_JavaUtilList.add(paramCMSBornPlayer);
      jdField_b_of_type_JavaUtilList.remove(paramCMSBornPlayer);
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 2, "releasePlayer " + paramCMSBornPlayer + ", idlePlayer size:" + jdField_a_of_type_JavaUtilList.size() + ", activePlayer size:" + jdField_b_of_type_JavaUtilList.size());
      jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a();
      paramCMSBornPlayer = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final void a(CMSBornPlayerManager.ActionItem paramActionItem)
  {
    if (a(paramActionItem)) {
      return;
    }
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      CMSBornPlayer localCMSBornPlayer = jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a();
      if (localCMSBornPlayer != null)
      {
        jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a(paramActionItem, localCMSBornPlayer);
        return;
      }
      Object localObject = jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a(paramActionItem.a().b());
      localCMSBornPlayer = (CMSBornPlayer)((Pair)localObject).component1();
      localObject = (CMSBornPlayerManager.ActionItem)((Pair)localObject).component2();
      if ((localCMSBornPlayer != null) && (localObject != null))
      {
        QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "find low priority action, interrupt it!! " + ((CMSBornPlayerManager.ActionItem)localObject).a().d());
        CMSHelper.a.a((Function0)new CMSBornPlayerManager.playActionReal.1.2((CMSBornPlayerManager.ActionItem)localObject));
        if (!jdField_c_of_type_JavaUtilList.contains(localObject)) {
          jdField_c_of_type_JavaUtilList.add(localObject);
        }
        jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a(paramActionItem, localCMSBornPlayer);
        return;
      }
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "add action to queue, " + paramActionItem.a().d());
      jdField_a_of_type_JavaUtilPriorityQueue.add(paramActionItem);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final void a(CMSBornPlayerManager.ActionItem paramActionItem, CMSBornPlayer paramCMSBornPlayer)
  {
    CMSBornPlayerManager.playActionByBornPlayer.listenerWrapper.1 local1 = new CMSBornPlayerManager.playActionByBornPlayer.listenerWrapper.1(paramActionItem, paramCMSBornPlayer);
    Object localObject = CMSHelper.a;
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "playActionByBornPlayer, " + paramActionItem.a().d() + ", width:" + paramActionItem.a() + ", height:" + paramActionItem.b() + ", player:" + paramCMSBornPlayer);
    localObject = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject).lock();
    try
    {
      CMSBornPlayerManager.ActionItem localActionItem = (CMSBornPlayerManager.ActionItem)jdField_a_of_type_JavaUtilMap.put(paramCMSBornPlayer, paramActionItem);
      ((Lock)localObject).unlock();
      CMSHelper.a.a((Function0)new CMSBornPlayerManager.playActionByBornPlayer.3(paramActionItem, paramCMSBornPlayer, local1));
      return;
    }
    finally
    {
      ((Lock)localObject).unlock();
    }
  }
  
  private final boolean a()
  {
    return (ApolloEngine.a()) && (!TextUtils.isEmpty((CharSequence)ApolloManagerServiceImpl.sEngineScript)) && (!TextUtils.isEmpty((CharSequence)ApolloManagerServiceImpl.sBasicScript));
  }
  
  private final boolean a(CMSBornPlayerManager.ActionItem paramActionItem)
  {
    Object localObject = ApolloScreenshotController.a.a(paramActionItem.a());
    if (localObject != null)
    {
      CMSFramePlayerManager localCMSFramePlayerManager = CMSFramePlayerManager.a;
      FrameLayout localFrameLayout = paramActionItem.a();
      if (localFrameLayout == null) {
        Intrinsics.throwNpe();
      }
      localCMSFramePlayerManager.a(localFrameLayout, (File)localObject);
      localObject = CMSHelper.a;
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "playActionByFramePlayer, " + paramActionItem.a().d());
      return true;
    }
    return false;
  }
  
  private final boolean a(String paramString, CMSBornPlayerManager.ActionItem paramActionItem)
  {
    paramString = new CMSBornPlayerManager.checkRoleDressReady.listener.1(paramActionItem, paramString);
    boolean bool1;
    if (!TextUtils.isEmpty((CharSequence)paramActionItem.a().a().a))
    {
      bool1 = ApolloActionHelperImpl.checkRoleDress(paramActionItem.a().a().a, CMSHelper.a.a(), (IApolloResDownloader.OnApolloDownLoadListener)paramString);
      if (!bool1)
      {
        List localList = paramString.a();
        String str = paramActionItem.a().a().a;
        Intrinsics.checkExpressionValueIsNotNull(str, "actionItem.action.spriteTask.mSenderUin");
        localList.add(str);
      }
    }
    for (;;)
    {
      boolean bool3;
      if (!TextUtils.isEmpty((CharSequence)paramActionItem.a().a().b))
      {
        bool3 = ApolloActionHelperImpl.checkRoleDress(paramActionItem.a().a().b, CMSHelper.a.a(), (IApolloResDownloader.OnApolloDownLoadListener)paramString);
        bool2 = bool3;
        if (!bool3)
        {
          paramString = paramString.a();
          paramActionItem = paramActionItem.a().a().b;
          Intrinsics.checkExpressionValueIsNotNull(paramActionItem, "actionItem.action.spriteTask.mRecvUin");
          paramString.add(paramActionItem);
        }
      }
      for (boolean bool2 = bool3;; bool2 = true) {
        return (bool1) && (bool2);
      }
      bool1 = true;
    }
  }
  
  private final CMSBornPlayer b()
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    for (;;)
    {
      try
      {
        CMSBornPlayer localCMSBornPlayer;
        if (jdField_d_of_type_JavaUtilList.size() > 0)
        {
          localCMSBornPlayer = (CMSBornPlayer)jdField_d_of_type_JavaUtilList.remove(0);
          if (localCMSBornPlayer != null) {
            e.add(localCMSBornPlayer);
          }
          return localCMSBornPlayer;
        }
        if (e.size() < 1) {
          localCMSBornPlayer = new CMSBornPlayer();
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
  
  /* Error */
  private final void b()
  {
    // Byte code:
    //   0: getstatic 117	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   3: checkcast 198	java/util/concurrent/locks/Lock
    //   6: astore_1
    //   7: aload_1
    //   8: invokeinterface 200 1 0
    //   13: getstatic 170	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager:jdField_b_of_type_JavaUtilPriorityQueue	Ljava/util/PriorityQueue;
    //   16: invokevirtual 367	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   19: checkcast 258	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem
    //   22: astore_2
    //   23: getstatic 112	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager:jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager	Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager;
    //   26: astore_3
    //   27: aload_2
    //   28: ldc_w 534
    //   31: invokestatic 338	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   34: aload_3
    //   35: aload_2
    //   36: invokespecial 536	com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager:b	(Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem;)V
    //   39: getstatic 388	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   42: astore_2
    //   43: aload_1
    //   44: invokeinterface 250 1 0
    //   49: return
    //   50: astore_2
    //   51: aload_1
    //   52: invokeinterface 250 1 0
    //   57: aload_2
    //   58: athrow
    //   59: astore_2
    //   60: goto -21 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	CMSBornPlayerManager
    //   6	46	1	localLock	Lock
    //   22	21	2	localObject1	Object
    //   50	8	2	localObject2	Object
    //   59	1	2	localNoSuchElementException	java.util.NoSuchElementException
    //   26	9	3	localCMSBornPlayerManager	CMSBornPlayerManager
    // Exception table:
    //   from	to	target	type
    //   13	39	50	finally
    //   39	43	50	finally
    //   13	39	59	java/util/NoSuchElementException
  }
  
  private final void b(CMSBornPlayer paramCMSBornPlayer)
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      jdField_b_of_type_JavaUtilMap.remove(paramCMSBornPlayer);
      jdField_d_of_type_JavaUtilList.add(paramCMSBornPlayer);
      e.remove(paramCMSBornPlayer);
      CMSHelper.a.b((Function0)CMSBornPlayerManager.releaseRecorder.1.1.INSTANCE);
      paramCMSBornPlayer = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final void b(CMSBornPlayerManager.ActionItem paramActionItem)
  {
    Object localObject1 = CMSAction.a(paramActionItem.a(), null, null, 3, null);
    Object localObject2 = ApolloScreenshotController.a.a((String)localObject1);
    Object localObject3;
    if (localObject2 != null)
    {
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramActionItem.a().d() + " success from cache, path:" + ((File)localObject2).getAbsolutePath());
      localObject3 = paramActionItem.a();
      if (localObject3 != null) {
        ((ICMSPlayerListener)localObject3).a(paramActionItem.a(), true, (String)localObject1, ((File)localObject2).getAbsolutePath());
      }
      return;
    }
    localObject2 = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject2).lock();
    try
    {
      localObject3 = jdField_b_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(CMSAction.a(((CMSBornPlayerManager.ActionItem)((Map.Entry)((Iterator)localObject3).next()).getValue()).a(), null, null, 3, null), localObject1))
        {
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramActionItem.a().d() + ", already in recording");
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.c(paramActionItem);
          return;
        }
      }
      localObject3 = g.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(CMSAction.a(((CMSBornPlayerManager.ActionItem)((Iterator)localObject3).next()).a(), null, null, 3, null), localObject1))
        {
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramActionItem.a().d() + ", already in waiting encode");
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.c(paramActionItem);
          return;
        }
      }
      localObject3 = jdField_b_of_type_JavaUtilPriorityQueue.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(CMSAction.a(((CMSBornPlayerManager.ActionItem)((Iterator)localObject3).next()).a(), null, null, 3, null), localObject1))
        {
          QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramActionItem.a().d() + ", already in record queue");
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.c(paramActionItem);
          return;
        }
      }
      if (jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a())
      {
        if (!jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a((String)localObject1, paramActionItem))
        {
          jdField_d_of_type_JavaUtilMap.put(localObject1, paramActionItem);
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.c(paramActionItem);
          QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramActionItem.a().d() + ", dress not ready");
          return;
        }
        if (jdField_d_of_type_JavaUtilMap.containsKey(localObject1)) {
          jdField_d_of_type_JavaUtilMap.remove(localObject1);
        }
        localObject1 = jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.b();
        if (localObject1 != null) {
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.b(paramActionItem, (CMSBornPlayer)localObject1);
        }
      }
      else
      {
        jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.c();
      }
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "add action to record queue, " + paramActionItem.a().d());
      jdField_b_of_type_JavaUtilPriorityQueue.add(paramActionItem);
      return;
    }
    finally
    {
      ((Lock)localObject2).unlock();
    }
  }
  
  private final void b(CMSBornPlayerManager.ActionItem paramActionItem, CMSBornPlayer paramCMSBornPlayer)
  {
    CMSBornPlayerManager.recordActionByRecorder.listenerWrapper.1 local1 = new CMSBornPlayerManager.recordActionByRecorder.listenerWrapper.1(paramActionItem, paramCMSBornPlayer);
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      jdField_b_of_type_JavaUtilMap.put(paramCMSBornPlayer, paramActionItem);
      jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.c(paramActionItem);
      Unit localUnit = Unit.INSTANCE;
      localLock.unlock();
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordActionByRecorder, " + paramActionItem.a().d() + ", width:" + paramActionItem.a() + ", height:" + paramActionItem.b() + ", player:" + paramCMSBornPlayer);
      TraceReportUtil.a(paramActionItem.a().a().toReportFeatureId(), null, CMSAction.a(paramActionItem.a(), null, null, 3, null));
      CMSHelper.a.b((Function0)new CMSBornPlayerManager.recordActionByRecorder.2(paramActionItem, paramCMSBornPlayer, local1));
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final void c()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    CMSBornPlayerManager.tryStartQueueWhenEnvReady.scheduler.1 local1 = new CMSBornPlayerManager.tryStartQueueWhenEnvReady.scheduler.1();
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "tryStartQueueWhenEnvReady after 1000ms, current recordQueue size:" + jdField_b_of_type_JavaUtilPriorityQueue.size());
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)local1, 1000L);
  }
  
  private final void c(CMSBornPlayerManager.ActionItem paramActionItem)
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      Object localObject = CMSAction.a(paramActionItem.a(), null, null, 3, null);
      if (!jdField_c_of_type_JavaUtilMap.containsKey(localObject)) {
        jdField_c_of_type_JavaUtilMap.put(localObject, (List)new ArrayList());
      }
      localObject = jdField_c_of_type_JavaUtilMap.get(localObject);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      List localList = (List)localObject;
      paramActionItem = paramActionItem.a();
      if (paramActionItem != null) {
        localList.add(paramActionItem);
      }
      paramActionItem = (List)localObject;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final void d(CMSAction paramCMSAction)
  {
    a(paramCMSAction, true);
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull CMSAction paramCMSAction, @Nullable ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    b(new CMSBornPlayerManager.ActionItem(paramInt1, paramInt2, CMSAction.a(paramCMSAction, null, null, 3, null), paramCMSAction, null, paramICMSPlayerListener));
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull String paramString, @NotNull CMSAction paramCMSAction, @NotNull FrameLayout paramFrameLayout, @Nullable ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "recordKey");
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramFrameLayout, "container");
    a(new CMSBornPlayerManager.ActionItem(paramInt1, paramInt2, paramString, paramCMSAction, paramFrameLayout, paramICMSPlayerListener));
  }
  
  public final void a(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Object localObject3 = a(paramCMSAction);
    Object localObject1 = (CMSBornPlayer)((Pair)localObject3).component1();
    localObject3 = (CMSBornPlayerManager.ActionItem)((Pair)localObject3).component2();
    if (localObject1 != null) {
      jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a((CMSBornPlayer)localObject1);
    }
    if (localObject3 != null)
    {
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "pauseAction " + CMSAction.a(paramCMSAction, null, null, 3, null) + ", detail:" + paramCMSAction);
      CMSHelper.a.a((Function0)new CMSBornPlayerManager.pauseActionPlay.2.1((CMSBornPlayerManager.ActionItem)localObject3));
      paramCMSAction = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
      paramCMSAction.lock();
    }
    try
    {
      if (!jdField_c_of_type_JavaUtilList.contains(localObject3)) {
        jdField_c_of_type_JavaUtilList.add(localObject3);
      }
      localObject1 = Unit.INSTANCE;
      return;
    }
    finally
    {
      paramCMSAction.unlock();
    }
  }
  
  public final void b(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    CMSBornPlayerManager.ActionItem localActionItem = a(paramCMSAction, true);
    if (localActionItem != null)
    {
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "resumeAction " + paramCMSAction.d());
      jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a(localActionItem);
    }
  }
  
  public final void c(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    a(paramCMSAction);
    d(paramCMSAction);
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "stopAction " + paramCMSAction.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager
 * JD-Core Version:    0.7.0.1
 */