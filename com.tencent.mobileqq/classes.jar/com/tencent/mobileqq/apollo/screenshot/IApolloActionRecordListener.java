package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "", "encodeEnd", "", "result", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "path", "", "encodeStart", "getActionId", "", "getBusinessConfig", "Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;", "getCurrentRecordKey", "getRecordMode", "Lcom/tencent/mobileqq/apollo/meme/action/MODE;", "getTaskId", "onRecordDone", "status", "recordKey", "onRecordFrameEnd", "onRecordFrameStart", "onRecordSingleFrame", "index", "pixels", "", "width", "height", "frameTime", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloActionRecordListener
{
  @NotNull
  public abstract String a();
  
  public abstract void a(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(@NotNull ActionStatus paramActionStatus);
  
  public abstract void a(@NotNull ActionStatus paramActionStatus, @Nullable String paramString);
  
  public abstract void a(@NotNull ActionStatus paramActionStatus, @NotNull String paramString1, @Nullable String paramString2);
  
  public abstract void b();
  
  public abstract void c();
  
  @NotNull
  public abstract MODE d();
  
  public abstract int e();
  
  public abstract int f();
  
  @NotNull
  public abstract BusinessConfig g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.IApolloActionRecordListener
 * JD-Core Version:    0.7.0.1
 */