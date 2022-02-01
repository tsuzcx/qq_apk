package com.tencent.mobileqq.apollo.player.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.INSTANCE;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine;
import com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager;", "", "()V", "RECORDER_NUM_THRESHOLD", "", "TAG", "", "activeRecorders", "", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer;", "canRecycle", "", "dressNotReadyRecords", "", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem;", "idleRecorders", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "recordActionQueue", "Ljava/util/Queue;", "recorderActionMap", "recorderKeyListenerMap", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "tryStartQueue", "waitingDoneRecords", "addRecorderListener", "", "actionItem", "checkEnvReady", "checkRoleDressReady", "key", "destroy", "getCurrentActionState", "getIdleRecorder", "isEveryThingDone", "recordAction", "width", "height", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "listener", "recordActionByPriority", "recordActionByRecorder", "recorder", "recordActionReal", "releaseRecorder", "setCanRecycle", "recycle", "tryStartQueueWhenEnvReady", "ActionItem", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayerManager
{
  public static final CMSBornPlayerManager a;
  private static final List<CMSBornPlayer> jdField_a_of_type_JavaUtilList;
  private static final Map<CMSBornPlayer, CMSBornPlayerManager.ActionItem> jdField_a_of_type_JavaUtilMap;
  private static final Queue<CMSBornPlayerManager.ActionItem> jdField_a_of_type_JavaUtilQueue;
  private static final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static final List<CMSBornPlayer> jdField_b_of_type_JavaUtilList;
  private static final Map<String, List<ICMSPlayerListener>> jdField_b_of_type_JavaUtilMap;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static final List<CMSBornPlayerManager.ActionItem> jdField_c_of_type_JavaUtilList;
  private static final Map<String, CMSBornPlayerManager.ActionItem> jdField_c_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager = new CMSBornPlayerManager();
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    jdField_a_of_type_JavaUtilList = (List)new ArrayList();
    jdField_b_of_type_JavaUtilList = (List)new ArrayList();
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    jdField_b_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    jdField_c_of_type_JavaUtilList = (List)new ArrayList();
    jdField_c_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    jdField_a_of_type_JavaUtilQueue = (Queue)new LinkedList();
    ApolloScreenshotController.a.a();
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
        }
        else
        {
          if (jdField_b_of_type_JavaUtilList.size() >= 1) {
            break label94;
          }
          localCMSBornPlayer = new CMSBornPlayer();
        }
        if (localCMSBornPlayer != null) {
          jdField_b_of_type_JavaUtilList.add(localCMSBornPlayer);
        }
        return localCMSBornPlayer;
      }
      finally
      {
        localLock.unlock();
      }
      label94:
      Object localObject2 = null;
    }
  }
  
  private final String a()
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      Object localObject1 = new StringBuilder();
      boolean bool = jdField_a_of_type_JavaUtilMap.isEmpty();
      Object localObject4;
      StringBuilder localStringBuilder;
      if ((bool ^ true))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("current recordActions(total:");
        ((StringBuilder)localObject3).append(jdField_a_of_type_JavaUtilMap.size());
        ((StringBuilder)localObject3).append("), detail:\n");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        localObject3 = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((CMSBornPlayer)((Map.Entry)localObject4).getKey());
          localStringBuilder.append(" -> ");
          localStringBuilder.append(((CMSBornPlayerManager.ActionItem)((Map.Entry)localObject4).getValue()).a().d());
          localStringBuilder.append('\n');
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
      }
      if ((((Collection)jdField_c_of_type_JavaUtilList).isEmpty() ^ true))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("current waiting encode actions(total:");
        ((StringBuilder)localObject3).append(jdField_c_of_type_JavaUtilList.size());
        ((StringBuilder)localObject3).append("), detail:\n");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        localObject3 = ((Iterable)jdField_c_of_type_JavaUtilList).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (CMSBornPlayerManager.ActionItem)((Iterator)localObject3).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((CMSBornPlayerManager.ActionItem)localObject4).a().d());
          localStringBuilder.append('\n');
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
      }
      if ((((Collection)jdField_a_of_type_JavaUtilQueue).isEmpty() ^ true))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("recordActionQueue(total:");
        ((StringBuilder)localObject3).append(jdField_a_of_type_JavaUtilQueue.size());
        ((StringBuilder)localObject3).append("), detail:\n");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        localObject3 = ((Iterable)jdField_a_of_type_JavaUtilQueue).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (CMSBornPlayerManager.ActionItem)((Iterator)localObject3).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((CMSBornPlayerManager.ActionItem)localObject4).a().d());
          localStringBuilder.append('\n');
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("canRecycle:");
      ((StringBuilder)localObject3).append(jdField_b_of_type_Boolean);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
      localObject1 = ((StringBuilder)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
      localLock.unlock();
      return localObject1;
    }
    finally
    {
      localLock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
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
      jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.b();
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
    Object localObject2 = CMSAction.a(paramActionItem.a(), null, null, 3, null);
    Object localObject1 = ApolloScreenshotController.a.a((String)localObject2);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("recordAction ");
      ((StringBuilder)localObject3).append(paramActionItem.a().d());
      ((StringBuilder)localObject3).append(" success from cache, path:");
      ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
      QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, ((StringBuilder)localObject3).toString());
      localObject3 = paramActionItem.a();
      if (localObject3 != null) {
        ((ICMSPlayerListener)localObject3).a(paramActionItem.a(), true, (String)localObject2, ((File)localObject1).getAbsolutePath());
      }
      return;
    }
    localObject1 = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject1).lock();
    try
    {
      localObject3 = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(CMSAction.a(((CMSBornPlayerManager.ActionItem)((Map.Entry)((Iterator)localObject3).next()).getValue()).a(), null, null, 3, null), localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recordAction ");
          ((StringBuilder)localObject2).append(paramActionItem.a().d());
          ((StringBuilder)localObject2).append(", already in recording");
          QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.b(paramActionItem);
          ((Lock)localObject1).unlock();
          return;
        }
      }
      localObject3 = jdField_c_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(CMSAction.a(((CMSBornPlayerManager.ActionItem)((Iterator)localObject3).next()).a(), null, null, 3, null), localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recordAction ");
          ((StringBuilder)localObject2).append(paramActionItem.a().d());
          ((StringBuilder)localObject2).append(", already in waiting encode");
          QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.b(paramActionItem);
          ((Lock)localObject1).unlock();
          return;
        }
      }
      localObject3 = jdField_a_of_type_JavaUtilQueue.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(CMSAction.a(((CMSBornPlayerManager.ActionItem)((Iterator)localObject3).next()).a(), null, null, 3, null), localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recordAction ");
          ((StringBuilder)localObject2).append(paramActionItem.a().d());
          ((StringBuilder)localObject2).append(", already in record queue");
          QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.b(paramActionItem);
          ((Lock)localObject1).unlock();
          return;
        }
      }
      if (jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a())
      {
        if (!jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a((String)localObject2, paramActionItem))
        {
          jdField_c_of_type_JavaUtilMap.put(localObject2, paramActionItem);
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.b(paramActionItem);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recordAction ");
          ((StringBuilder)localObject2).append(paramActionItem.a().d());
          ((StringBuilder)localObject2).append(", dress not ready");
          QLog.e("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
          ((Lock)localObject1).unlock();
          return;
        }
        if (jdField_c_of_type_JavaUtilMap.containsKey(localObject2)) {
          jdField_c_of_type_JavaUtilMap.remove(localObject2);
        }
        localObject2 = jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a();
        if (localObject2 != null)
        {
          jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.a(paramActionItem, (CMSBornPlayer)localObject2);
          ((Lock)localObject1).unlock();
        }
      }
      else
      {
        jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.c();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("add action to record queue, ");
      ((StringBuilder)localObject2).append(paramActionItem.a().d());
      QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
      jdField_a_of_type_JavaUtilQueue.add(paramActionItem);
      ((Lock)localObject1).unlock();
      return;
    }
    finally
    {
      ((Lock)localObject1).unlock();
    }
    for (;;)
    {
      throw paramActionItem;
    }
  }
  
  private final void a(CMSBornPlayerManager.ActionItem paramActionItem, CMSBornPlayer paramCMSBornPlayer)
  {
    CMSBornPlayerManager.recordActionByRecorder.listenerWrapper.1 local1 = new CMSBornPlayerManager.recordActionByRecorder.listenerWrapper.1(paramActionItem, paramCMSBornPlayer);
    Object localObject = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject).lock();
    try
    {
      jdField_a_of_type_JavaUtilMap.put(paramCMSBornPlayer, paramActionItem);
      jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager.b(paramActionItem);
      Unit localUnit = Unit.INSTANCE;
      ((Lock)localObject).unlock();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recordActionByRecorder, ");
      ((StringBuilder)localObject).append(paramActionItem.a().d());
      ((StringBuilder)localObject).append(", width:");
      ((StringBuilder)localObject).append(paramActionItem.a());
      ((StringBuilder)localObject).append(", height:");
      ((StringBuilder)localObject).append(paramActionItem.b());
      ((StringBuilder)localObject).append(", player:");
      ((StringBuilder)localObject).append(paramCMSBornPlayer);
      QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, ((StringBuilder)localObject).toString());
      TraceReportUtil.a(CMSHelper.a.a(paramActionItem.a().a()), null, CMSAction.a(paramActionItem.a(), null, null, 3, null));
      CMSHelper.a.a((Function0)new CMSBornPlayerManager.recordActionByRecorder.2(paramActionItem, paramCMSBornPlayer, local1));
      return;
    }
    finally
    {
      ((Lock)localObject).unlock();
    }
  }
  
  private final boolean a()
  {
    boolean bool1 = CMShowPlatform.a.a(Scene.MEME_PLAYER);
    if (CMShowPlatform.a.b(Scene.MEME_PLAYER))
    {
      boolean bool2 = CECMShowOffscreenEngine.a.a();
      if ((bool1) && (bool2)) {
        return true;
      }
    }
    int i;
    do
    {
      return false;
      if ((!TextUtils.isEmpty((CharSequence)ApolloManagerServiceImpl.sEngineScript)) && (!TextUtils.isEmpty((CharSequence)ApolloManagerServiceImpl.sBasicScript))) {
        i = 1;
      } else {
        i = 0;
      }
    } while ((!bool1) || (i == 0));
    return true;
  }
  
  private final boolean a(String paramString, CMSBornPlayerManager.ActionItem paramActionItem)
  {
    paramString = new CMSBornPlayerManager.checkRoleDressReady.listener.1(paramActionItem, paramString);
    boolean bool2;
    boolean bool1;
    if (!TextUtils.isEmpty((CharSequence)paramActionItem.a().a().a))
    {
      bool2 = ApolloActionHelperImpl.checkRoleDress(paramActionItem.a().a().a, CMSHelper.a.a(), (IApolloResDownloader.OnApolloDownLoadListener)paramString);
      bool1 = bool2;
      if (!bool2)
      {
        List localList = paramString.a();
        String str = paramActionItem.a().a().a;
        Intrinsics.checkExpressionValueIsNotNull(str, "actionItem.action.spriteTask.mSenderUin");
        localList.add(str);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = true;
    }
    if (!TextUtils.isEmpty((CharSequence)paramActionItem.a().a().b))
    {
      boolean bool3 = ApolloActionHelperImpl.checkRoleDress(paramActionItem.a().a().b, CMSHelper.a.a(), (IApolloResDownloader.OnApolloDownLoadListener)paramString);
      bool2 = bool3;
      if (!bool3)
      {
        paramString = paramString.a();
        paramActionItem = paramActionItem.a().a().b;
        Intrinsics.checkExpressionValueIsNotNull(paramActionItem, "actionItem.action.spriteTask.mRecvUin");
        paramString.add(paramActionItem);
        bool2 = bool3;
      }
    }
    else
    {
      bool2 = true;
    }
    return (bool1) && (bool2);
  }
  
  private final void b()
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      try
      {
        CMSBornPlayerManager.ActionItem localActionItem = (CMSBornPlayerManager.ActionItem)jdField_a_of_type_JavaUtilQueue.remove();
        CMSBornPlayerManager localCMSBornPlayerManager = jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager;
        Intrinsics.checkExpressionValueIsNotNull(localActionItem, "item");
        localCMSBornPlayerManager.a(localActionItem);
      }
      finally
      {
        break label59;
      }
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      label48:
      Unit localUnit;
      break label48;
    }
    localUnit = Unit.INSTANCE;
    localLock.unlock();
    return;
    label59:
    localLock.unlock();
    throw localUnit;
  }
  
  private final void b(CMSBornPlayerManager.ActionItem paramActionItem)
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      Object localObject = CMSAction.a(paramActionItem.a(), null, null, 3, null);
      if (!jdField_b_of_type_JavaUtilMap.containsKey(localObject)) {
        jdField_b_of_type_JavaUtilMap.put(localObject, (List)new ArrayList());
      }
      localObject = jdField_b_of_type_JavaUtilMap.get(localObject);
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
  
  private final boolean b()
  {
    Lock localLock = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      if ((jdField_a_of_type_JavaUtilMap.isEmpty()) && (jdField_c_of_type_JavaUtilList.isEmpty()) && (jdField_a_of_type_JavaUtilQueue.isEmpty()))
      {
        bool = jdField_c_of_type_JavaUtilMap.isEmpty();
        if (bool)
        {
          bool = true;
          break label66;
        }
      }
      boolean bool = false;
      label66:
      return bool;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryStartQueueWhenEnvReady after 1000ms, current recordQueue size:");
    localStringBuilder.append(jdField_a_of_type_JavaUtilQueue.size());
    QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, localStringBuilder.toString());
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)local1, 1000L);
  }
  
  public final void a()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((CMSBornPlayer)localIterator.next()).a();
    }
    localIterator = jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((CMSBornPlayer)localIterator.next()).a();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull CMSAction paramCMSAction, @Nullable ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    a(new CMSBornPlayerManager.ActionItem(paramInt1, paramInt2, CMSAction.a(paramCMSAction, null, null, 3, null), paramCMSAction, null, paramICMSPlayerListener));
  }
  
  public final void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCanRecycle to ");
    localStringBuilder.append(paramBoolean);
    QLog.i("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager
 * JD-Core Version:    0.7.0.1
 */