package com.tencent.mobileqq.apollo.meme.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.action.PlayActionScript;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.script.plugin.BornPlayerPlugin;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornActionContext;", "", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "ssm", "Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;", "engine", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "listener", "Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;", "start", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "context", "", "(Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "setAction", "(Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;)V", "cacheUins", "", "", "getCacheUins", "()Ljava/util/Set;", "cmdPlugin", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/BornPlayerPlugin;", "getCmdPlugin", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/BornPlayerPlugin;", "dressChangeListener", "Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionObserver;", "getDressChangeListener", "()Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionObserver;", "dressChangeListener$delegate", "Lkotlin/Lazy;", "getEngine", "()Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "getListener", "()Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;", "setListener", "(Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;)V", "value", "Lcom/tencent/mobileqq/cmshow/engine/action/PlayActionScript;", "playActionScript", "getPlayActionScript", "()Lcom/tencent/mobileqq/cmshow/engine/action/PlayActionScript;", "setPlayActionScript", "(Lcom/tencent/mobileqq/cmshow/engine/action/PlayActionScript;)V", "recordListener", "Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornRecordListener;", "getRecordListener", "()Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornRecordListener;", "setRecordListener", "(Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornRecordListener;)V", "screenshotController", "Lcom/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController;", "getScreenshotController", "()Lcom/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController;", "getSsm", "()Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;", "getStart", "()Lkotlin/jvm/functions/Function1;", "timeoutRunnable", "Ljava/lang/Runnable;", "getTimeoutRunnable", "()Ljava/lang/Runnable;", "setTimeoutRunnable", "(Ljava/lang/Runnable;)V", "viewListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ISurfaceStateListener;", "getViewListener", "()Lcom/tencent/mobileqq/cmshow/engine/render/ISurfaceStateListener;", "viewListener$delegate", "addCacheUins", "reset", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class MemeBornPlayer$BornActionContext
{
  @NotNull
  public MemeBornPlayer.BornRecordListener a;
  @NotNull
  public Runnable b;
  @NotNull
  private final Set<String> c;
  @NotNull
  private final Lazy d;
  @NotNull
  private final BornPlayerPlugin e;
  @Nullable
  private PlayActionScript f;
  @NotNull
  private final ApolloScreenshotController g;
  @NotNull
  private final Lazy h;
  @NotNull
  private MemeAction i;
  @NotNull
  private final SpriteScriptManager j;
  @NotNull
  private final ICMShowEngine k;
  @NotNull
  private InnerMemePlayerListener l;
  @NotNull
  private final Function1<BornActionContext, Unit> m;
  
  public MemeBornPlayer$BornActionContext(@NotNull MemeAction paramMemeAction, @NotNull SpriteScriptManager paramSpriteScriptManager, @NotNull ICMShowEngine paramICMShowEngine, @NotNull InnerMemePlayerListener paramInnerMemePlayerListener, @NotNull Function1<? super BornActionContext, Unit> paramFunction1)
  {
    this.i = paramMemeAction;
    this.j = paramSpriteScriptManager;
    this.k = paramICMShowEngine;
    this.l = paramInnerMemePlayerListener;
    this.m = paramFunction1;
    this.c = ((Set)new LinkedHashSet());
    this.d = LazyKt.lazy((Function0)new MemeBornPlayer.BornActionContext.viewListener.2(this));
    this.e = new BornPlayerPlugin(this.i, this.l);
    this.g = new ApolloScreenshotController(this.k.e());
    this.k.c().a((IRecordFrameListener)new MemeBornPlayer.BornActionContext.1(this));
    this.h = LazyKt.lazy((Function0)new MemeBornPlayer.BornActionContext.dressChangeListener.2(this));
  }
  
  @NotNull
  public final Set<String> a()
  {
    return this.c;
  }
  
  public final void a(@NotNull MemeAction paramMemeAction)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "<set-?>");
    this.i = paramMemeAction;
  }
  
  public final void a(@NotNull InnerMemePlayerListener paramInnerMemePlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramInnerMemePlayerListener, "<set-?>");
    this.l = paramInnerMemePlayerListener;
  }
  
  public final void a(@Nullable PlayActionScript paramPlayActionScript)
  {
    MemeBornPlayer.BornRecordListener localBornRecordListener = this.a;
    if (localBornRecordListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recordListener");
    }
    localBornRecordListener.a(paramPlayActionScript);
  }
  
  @NotNull
  public final ISurfaceStateListener b()
  {
    return (ISurfaceStateListener)this.d.getValue();
  }
  
  @NotNull
  public final BornPlayerPlugin c()
  {
    return this.e;
  }
  
  @Nullable
  public final PlayActionScript d()
  {
    return this.f;
  }
  
  @NotNull
  public final MemeBornPlayer.BornRecordListener e()
  {
    MemeBornPlayer.BornRecordListener localBornRecordListener = this.a;
    if (localBornRecordListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recordListener");
    }
    return localBornRecordListener;
  }
  
  @NotNull
  public final Runnable f()
  {
    Runnable localRunnable = this.b;
    if (localRunnable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
    }
    return localRunnable;
  }
  
  @NotNull
  public final ApolloScreenshotController g()
  {
    return this.g;
  }
  
  public final void h()
  {
    this.b = ((Runnable)new MemeBornPlayer.BornActionContext.reset.1(this));
    MemeAction localMemeAction = this.i;
    IMemePlayerListener localIMemePlayerListener = (IMemePlayerListener)this.l;
    Runnable localRunnable = this.b;
    if (localRunnable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
    }
    this.a = new MemeBornPlayer.BornRecordListener(localMemeAction, localIMemePlayerListener, localRunnable);
  }
  
  @NotNull
  public final ApolloExtensionObserver i()
  {
    return (ApolloExtensionObserver)this.h.getValue();
  }
  
  public final void j()
  {
    String str = this.i.c().j;
    Set localSet;
    if ((!TextUtils.isEmpty((CharSequence)str)) && (!this.c.contains(str)))
    {
      localSet = this.c;
      Intrinsics.checkExpressionValueIsNotNull(str, "senderUin");
      localSet.add(str);
    }
    str = this.i.c().k;
    if ((!TextUtils.isEmpty((CharSequence)str)) && (!this.c.contains(str)))
    {
      localSet = this.c;
      Intrinsics.checkExpressionValueIsNotNull(str, "receiverUin");
      localSet.add(str);
    }
  }
  
  @NotNull
  public final MemeAction k()
  {
    return this.i;
  }
  
  @NotNull
  public final SpriteScriptManager l()
  {
    return this.j;
  }
  
  @NotNull
  public final ICMShowEngine m()
  {
    return this.k;
  }
  
  @NotNull
  public final InnerMemePlayerListener n()
  {
    return this.l;
  }
  
  @NotNull
  public final Function1<BornActionContext, Unit> o()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayer.BornActionContext
 * JD-Core Version:    0.7.0.1
 */