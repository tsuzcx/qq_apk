package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "", "encodeEnd", "", "success", "", "path", "", "encodeStart", "getActionId", "", "getBusinessConfig", "Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "getCurrentRecordKey", "getRecordMode", "Lcom/tencent/mobileqq/apollo/api/player/action/MODE;", "getTargetHeight", "getTargetWidth", "getTaskId", "onRecordDone", "errorCode", "recordKey", "onRecordFrameEnd", "onRecordFrameStart", "onRecordSingleFrame", "index", "pixels", "", "width", "height", "frameTime", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloActionRecordListener
{
  public abstract int a();
  
  @NotNull
  public abstract MODE a();
  
  @NotNull
  public abstract BusinessConfig a();
  
  @NotNull
  public abstract String a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, @NotNull String paramString1, @Nullable String paramString2);
  
  public abstract void a(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(boolean paramBoolean, @Nullable String paramString);
  
  public abstract int b();
  
  public abstract void b();
  
  public abstract int c();
  
  public abstract int d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.IApolloActionRecordListener
 * JD-Core Version:    0.7.0.1
 */