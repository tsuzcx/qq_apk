package com.tencent.mobileqq.apollo.meme.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.INSTANCE;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine;
import com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.COMPLETE;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayerManager;", "", "()V", "RECORDER_NUM_THRESHOLD", "", "TAG", "", "activeRecorders", "", "Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer;", "canRecycle", "", "dressNotReadyRecords", "", "Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayerManager$ActionItem;", "idleRecorders", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "recordActionQueue", "Ljava/util/Queue;", "recorderActionMap", "recorderKeyListenerMap", "Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;", "tryStartQueue", "waitingDoneRecords", "addRecorderListener", "", "actionItem", "checkEnvReady", "checkRoleDressReady", "key", "destroy", "destroyForAccountChange", "getCurrentActionState", "getIdleRecorder", "getMemeEngine", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "isEveryThingDone", "recordAction", "width", "height", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "listener", "recordActionByPriority", "recordActionByRecorder", "recorder", "recordActionReal", "releaseRecorder", "setCanRecycle", "recycle", "tryStartQueueWhenEnvReady", "ActionItem", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeBornPlayerManager
{
  public static final MemeBornPlayerManager a = new MemeBornPlayerManager();
  private static final ReentrantLock b = new ReentrantLock();
  private static volatile boolean c;
  private static volatile boolean d;
  private static final List<MemeBornPlayer> e = (List)new ArrayList();
  private static final List<MemeBornPlayer> f = (List)new ArrayList();
  private static final Map<MemeBornPlayer, MemeBornPlayerManager.ActionItem> g = (Map)new LinkedHashMap();
  private static final Map<String, List<IMemePlayerListener>> h = (Map)new LinkedHashMap();
  private static final List<MemeBornPlayerManager.ActionItem> i = (List)new ArrayList();
  private static final Map<String, MemeBornPlayerManager.ActionItem> j = (Map)new LinkedHashMap();
  private static final Queue<MemeBornPlayerManager.ActionItem> k = (Queue)new LinkedList();
  
  static
  {
    ApolloScreenshotController.a.a();
    MemeBornPlayerManager.logScheduler.1 local1 = new MemeBornPlayerManager.logScheduler.1();
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)local1, 10000L);
  }
  
  private final void a(MemeBornPlayer paramMemeBornPlayer)
  {
    Lock localLock = (Lock)b;
    localLock.lock();
    try
    {
      g.remove(paramMemeBornPlayer);
      e.add(paramMemeBornPlayer);
      f.remove(paramMemeBornPlayer);
      a.d();
      paramMemeBornPlayer = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final void a(MemeBornPlayerManager.ActionItem paramActionItem)
  {
    Object localObject2 = MemeAction.a(paramActionItem.c(), null, null, 3, null);
    Object localObject1 = ApolloScreenshotController.a.a((String)localObject2);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("recordAction ");
      ((StringBuilder)localObject3).append(paramActionItem.c().h());
      ((StringBuilder)localObject3).append(" success from cache, path:");
      ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
      QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, ((StringBuilder)localObject3).toString());
      paramActionItem.c().a((ActionStatus)COMPLETE.a);
      localObject3 = paramActionItem.d();
      if (localObject3 != null) {
        ((IMemePlayerListener)localObject3).a(paramActionItem.c(), true, (String)localObject2, ((File)localObject1).getAbsolutePath());
      }
      return;
    }
    localObject1 = (Lock)b;
    ((Lock)localObject1).lock();
    try
    {
      localObject3 = g.entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(MemeAction.a(((MemeBornPlayerManager.ActionItem)((Map.Entry)((Iterator)localObject3).next()).getValue()).c(), null, null, 3, null), localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recordAction ");
          ((StringBuilder)localObject2).append(paramActionItem.c().h());
          ((StringBuilder)localObject2).append(", already in recording");
          QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
          a.b(paramActionItem);
          ((Lock)localObject1).unlock();
          return;
        }
      }
      localObject3 = i.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(MemeAction.a(((MemeBornPlayerManager.ActionItem)((Iterator)localObject3).next()).c(), null, null, 3, null), localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recordAction ");
          ((StringBuilder)localObject2).append(paramActionItem.c().h());
          ((StringBuilder)localObject2).append(", already in waiting encode");
          QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
          a.b(paramActionItem);
          ((Lock)localObject1).unlock();
          return;
        }
      }
      localObject3 = k.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Intrinsics.areEqual(MemeAction.a(((MemeBornPlayerManager.ActionItem)((Iterator)localObject3).next()).c(), null, null, 3, null), localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recordAction ");
          ((StringBuilder)localObject2).append(paramActionItem.c().h());
          ((StringBuilder)localObject2).append(", already in record queue");
          QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
          a.b(paramActionItem);
          ((Lock)localObject1).unlock();
          return;
        }
      }
      if (a.f())
      {
        if (!a.a((String)localObject2, paramActionItem))
        {
          j.put(localObject2, paramActionItem);
          a.b(paramActionItem);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recordAction ");
          ((StringBuilder)localObject2).append(paramActionItem.c().h());
          ((StringBuilder)localObject2).append(", dress not ready");
          QLog.e("[cmshow][MemePlayer]MemeBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
          ((Lock)localObject1).unlock();
          return;
        }
        if (j.containsKey(localObject2)) {
          j.remove(localObject2);
        }
        localObject2 = a.c();
        if (localObject2 != null)
        {
          a.a(paramActionItem, (MemeBornPlayer)localObject2);
          ((Lock)localObject1).unlock();
        }
      }
      else
      {
        a.g();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("add action to record queue, ");
      ((StringBuilder)localObject2).append(paramActionItem.c().h());
      QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, ((StringBuilder)localObject2).toString());
      k.add(paramActionItem);
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
  
  private final void a(MemeBornPlayerManager.ActionItem paramActionItem, MemeBornPlayer paramMemeBornPlayer)
  {
    MemeBornPlayerManager.recordActionByRecorder.listenerWrapper.1 local1 = new MemeBornPlayerManager.recordActionByRecorder.listenerWrapper.1(paramActionItem, paramMemeBornPlayer);
    Object localObject = (Lock)b;
    ((Lock)localObject).lock();
    try
    {
      g.put(paramMemeBornPlayer, paramActionItem);
      a.b(paramActionItem);
      Unit localUnit = Unit.INSTANCE;
      ((Lock)localObject).unlock();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recordActionByRecorder, ");
      ((StringBuilder)localObject).append(paramActionItem.c().h());
      ((StringBuilder)localObject).append(", width:");
      ((StringBuilder)localObject).append(paramActionItem.a());
      ((StringBuilder)localObject).append(", height:");
      ((StringBuilder)localObject).append(paramActionItem.b());
      ((StringBuilder)localObject).append(", player:");
      ((StringBuilder)localObject).append(paramMemeBornPlayer);
      QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, ((StringBuilder)localObject).toString());
      TraceReportUtil.a(MemeHelper.a.a(paramActionItem.c().i()), null, MemeAction.a(paramActionItem.c(), null, null, 3, null));
      MemeHelper.a.a((Function0)new MemeBornPlayerManager.recordActionByRecorder.2(paramActionItem, paramMemeBornPlayer, local1));
      return;
    }
    finally
    {
      ((Lock)localObject).unlock();
    }
  }
  
  private final boolean a(String paramString, MemeBornPlayerManager.ActionItem paramActionItem)
  {
    paramString = new MemeBornPlayerManager.checkRoleDressReady.listener.1(paramActionItem, paramString);
    paramActionItem = paramActionItem.c().c();
    int m;
    if (ApolloActionData.isAction3DModel(paramActionItem.f)) {
      m = 2;
    } else {
      m = 1;
    }
    String str = paramActionItem.j;
    boolean bool1;
    boolean bool2;
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      Object localObject;
      if (MemeHelper.a.a() != null)
      {
        localObject = ApolloResManagerFacade.a.a(Scene.MEME_PLAYER);
        Intrinsics.checkExpressionValueIsNotNull(str, "senderUin");
        bool1 = ((IApolloResManager)localObject).a(str, m, MemeHelper.a.a(), (IApolloResDownloader.OnApolloDownLoadListener)paramString);
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        localObject = paramString.a();
        Intrinsics.checkExpressionValueIsNotNull(str, "senderUin");
        ((List)localObject).add(str);
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = true;
    }
    str = paramActionItem.k;
    paramActionItem = paramActionItem.a();
    Intrinsics.checkExpressionValueIsNotNull(paramActionItem, "spriteTask.isDoubleSpriteTask");
    boolean bool3;
    if ((paramActionItem.booleanValue()) && (!TextUtils.isEmpty((CharSequence)str)))
    {
      if (MemeHelper.a.a() != null)
      {
        paramActionItem = ApolloResManagerFacade.a.a(Scene.MEME_PLAYER);
        Intrinsics.checkExpressionValueIsNotNull(str, "recvUin");
        bool1 = paramActionItem.a(str, m, MemeHelper.a.a(), (IApolloResDownloader.OnApolloDownLoadListener)paramString);
      }
      else
      {
        bool1 = true;
      }
      bool3 = bool1;
      if (!bool1)
      {
        paramString = paramString.a();
        Intrinsics.checkExpressionValueIsNotNull(str, "recvUin");
        paramString.add(str);
        bool3 = bool1;
      }
    }
    else
    {
      bool3 = true;
    }
    return (bool2) && (bool3);
  }
  
  private final void b(MemeBornPlayerManager.ActionItem paramActionItem)
  {
    Lock localLock = (Lock)b;
    localLock.lock();
    try
    {
      Object localObject = MemeAction.a(paramActionItem.c(), null, null, 3, null);
      if (!h.containsKey(localObject)) {
        h.put(localObject, (List)new ArrayList());
      }
      localObject = h.get(localObject);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      List localList = (List)localObject;
      paramActionItem = paramActionItem.d();
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
  
  private final MemeBornPlayer c()
  {
    Lock localLock = (Lock)b;
    localLock.lock();
    for (;;)
    {
      try
      {
        MemeBornPlayer localMemeBornPlayer;
        if (e.size() > 0)
        {
          localMemeBornPlayer = (MemeBornPlayer)e.remove(0);
        }
        else
        {
          if (f.size() >= 1) {
            break label94;
          }
          localMemeBornPlayer = new MemeBornPlayer();
        }
        if (localMemeBornPlayer != null) {
          f.add(localMemeBornPlayer);
        }
        return localMemeBornPlayer;
      }
      finally
      {
        localLock.unlock();
      }
      label94:
      Object localObject2 = null;
    }
  }
  
  private final void d()
  {
    Lock localLock = (Lock)b;
    localLock.lock();
    try
    {
      try
      {
        MemeBornPlayerManager.ActionItem localActionItem = (MemeBornPlayerManager.ActionItem)k.remove();
        MemeBornPlayerManager localMemeBornPlayerManager = a;
        Intrinsics.checkExpressionValueIsNotNull(localActionItem, "item");
        localMemeBornPlayerManager.a(localActionItem);
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
  
  private final String e()
  {
    Lock localLock = (Lock)b;
    localLock.lock();
    try
    {
      Object localObject1 = new StringBuilder();
      boolean bool = g.isEmpty();
      Object localObject4;
      StringBuilder localStringBuilder;
      if ((bool ^ true))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("current recordActions(total:");
        ((StringBuilder)localObject3).append(g.size());
        ((StringBuilder)localObject3).append("), detail:\n");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        localObject3 = g.entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((MemeBornPlayer)((Map.Entry)localObject4).getKey());
          localStringBuilder.append(" -> ");
          localStringBuilder.append(((MemeBornPlayerManager.ActionItem)((Map.Entry)localObject4).getValue()).c().h());
          localStringBuilder.append('\n');
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
      }
      if ((((Collection)i).isEmpty() ^ true))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("current waiting encode actions(total:");
        ((StringBuilder)localObject3).append(i.size());
        ((StringBuilder)localObject3).append("), detail:\n");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        localObject3 = ((Iterable)i).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (MemeBornPlayerManager.ActionItem)((Iterator)localObject3).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((MemeBornPlayerManager.ActionItem)localObject4).c().h());
          localStringBuilder.append('\n');
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
      }
      if ((((Collection)k).isEmpty() ^ true))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("recordActionQueue(total:");
        ((StringBuilder)localObject3).append(k.size());
        ((StringBuilder)localObject3).append("), detail:\n");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        localObject3 = ((Iterable)k).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (MemeBornPlayerManager.ActionItem)((Iterator)localObject3).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((MemeBornPlayerManager.ActionItem)localObject4).c().h());
          localStringBuilder.append('\n');
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("canRecycle:");
      ((StringBuilder)localObject3).append(d);
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
  
  private final boolean f()
  {
    boolean bool1 = CMShowPlatform.a.a(Scene.MEME_PLAYER);
    if (CMShowPlatform.a.b(Scene.MEME_PLAYER))
    {
      boolean bool2 = CECMShowOffscreenEngine.a.b();
      if ((bool1) && (bool2)) {
        return true;
      }
    }
    int m;
    do
    {
      return false;
      if ((!TextUtils.isEmpty((CharSequence)ApolloManagerServiceImpl.sEngineScript)) && (!TextUtils.isEmpty((CharSequence)ApolloManagerServiceImpl.sBasicScript))) {
        m = 1;
      } else {
        m = 0;
      }
    } while ((!bool1) || (m == 0));
    return true;
  }
  
  private final void g()
  {
    if (c) {
      return;
    }
    c = true;
    MemeBornPlayerManager.tryStartQueueWhenEnvReady.scheduler.1 local1 = new MemeBornPlayerManager.tryStartQueueWhenEnvReady.scheduler.1();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryStartQueueWhenEnvReady after 1000ms, current recordQueue size:");
    localStringBuilder.append(k.size());
    QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, localStringBuilder.toString());
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)local1, 1000L);
  }
  
  private final boolean h()
  {
    Lock localLock = (Lock)b;
    localLock.lock();
    try
    {
      if ((g.isEmpty()) && (i.isEmpty()) && (k.isEmpty()))
      {
        bool = j.isEmpty();
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
  
  public final void a()
  {
    MemeHelper.a.b((Function0)MemeBornPlayerManager.destroyForAccountChange.1.INSTANCE);
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull MemeAction paramMemeAction, @Nullable IMemePlayerListener paramIMemePlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    a(new MemeBornPlayerManager.ActionItem(paramInt1, paramInt2, MemeAction.a(paramMemeAction, null, null, 3, null), paramMemeAction, null, paramIMemePlayerListener));
  }
  
  public final void a(boolean paramBoolean)
  {
    d = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCanRecycle to ");
    localStringBuilder.append(paramBoolean);
    QLog.i("[cmshow][MemePlayer]MemeBornPlayerManager", 1, localStringBuilder.toString());
  }
  
  public final void b()
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((MemeBornPlayer)localIterator.next()).a();
    }
    localIterator = f.iterator();
    while (localIterator.hasNext()) {
      ((MemeBornPlayer)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager
 * JD-Core Version:    0.7.0.1
 */