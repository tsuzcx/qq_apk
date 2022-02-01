package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.RECORD_COMPLETE;
import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig;
import com.tencent.mobileqq.apollo.screenshot.IApolloActionRecordListener;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.PlayActionScript;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornRecordListener;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "listener", "Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;", "timeoutRunnable", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;Ljava/lang/Runnable;)V", "playActionScript", "Lcom/tencent/mobileqq/cmshow/engine/action/PlayActionScript;", "getPlayActionScript", "()Lcom/tencent/mobileqq/cmshow/engine/action/PlayActionScript;", "setPlayActionScript", "(Lcom/tencent/mobileqq/cmshow/engine/action/PlayActionScript;)V", "encodeEnd", "", "result", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "path", "", "encodeStart", "getActionId", "", "getBusinessConfig", "Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;", "getCurrentRecordKey", "getRecordMode", "Lcom/tencent/mobileqq/apollo/meme/action/MODE;", "getTaskId", "onRecordDone", "status", "recordKey", "onRecordFrameEnd", "onRecordFrameStart", "onRecordSingleFrame", "index", "pixels", "", "width", "height", "frameTime", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class MemeBornPlayer$BornRecordListener
  implements IApolloActionRecordListener
{
  @Nullable
  private PlayActionScript a;
  private final MemeAction b;
  private final IMemePlayerListener c;
  private final Runnable d;
  
  public MemeBornPlayer$BornRecordListener(@NotNull MemeAction paramMemeAction, @NotNull IMemePlayerListener paramIMemePlayerListener, @NotNull Runnable paramRunnable)
  {
    this.b = paramMemeAction;
    this.c = paramIMemePlayerListener;
    this.d = paramRunnable;
  }
  
  @NotNull
  public String a()
  {
    return MemeAction.a(this.b, null, null, 3, null);
  }
  
  public void a(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    this.c.a(this.b, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(@NotNull ActionStatus paramActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramActionStatus, "status");
    TraceReportUtil.a(MemeHelper.a.a(this.b.i()), MemeAction.a(this.b, null, null, 3, null), 2, paramActionStatus.a(), new Object[] { this.b.h() });
  }
  
  public void a(@NotNull ActionStatus paramActionStatus, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActionStatus, "result");
    int i = MemeHelper.a.a(this.b.i());
    String str = MemeAction.a(this.b, null, null, 3, null);
    int j = paramActionStatus.a();
    paramActionStatus = new StringBuilder();
    paramActionStatus.append(this.b.h());
    paramActionStatus.append(", zipLevel:1, path:");
    paramActionStatus.append(paramString);
    TraceReportUtil.a(i, str, 3, j, new Object[] { paramActionStatus.toString() });
  }
  
  public void a(@NotNull ActionStatus paramActionStatus, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramActionStatus, "status");
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    ThreadManager.getSubThreadHandler().removeCallbacks(this.d);
    boolean bool = Intrinsics.areEqual(paramActionStatus, RECORD_COMPLETE.a);
    this.b.a(paramActionStatus);
    PlayActionScript localPlayActionScript = this.a;
    if (localPlayActionScript != null) {
      localPlayActionScript.a(paramActionStatus);
    }
    this.c.a(this.b, bool, paramString1, paramString2);
  }
  
  public final void a(@Nullable PlayActionScript paramPlayActionScript)
  {
    this.a = paramPlayActionScript;
  }
  
  public void b()
  {
    TraceReportUtil.a(MemeHelper.a.a(this.b.i()), MemeAction.a(this.b, null, null, 3, null), 2);
  }
  
  public void c()
  {
    TraceReportUtil.a(MemeHelper.a.a(this.b.i()), MemeAction.a(this.b, null, null, 3, null), 3);
  }
  
  @NotNull
  public MODE d()
  {
    return this.b.i();
  }
  
  public int e()
  {
    return this.b.c().a;
  }
  
  public int f()
  {
    return this.b.l();
  }
  
  @NotNull
  public BusinessConfig g()
  {
    return this.b.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayer.BornRecordListener
 * JD-Core Version:    0.7.0.1
 */