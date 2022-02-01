package com.tencent.mobileqq.apollo.player;

import com.tencent.mobileqq.apollo.player.action.CMSAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "", "onActionStatusChange", "", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "status", "Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "onFirstFrame", "onRecordDone", "success", "", "recordKey", "", "recordPath", "onRecordFrame", "index", "", "pixels", "", "width", "height", "frameTime", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ICMSPlayerListener
{
  public abstract void a(@NotNull CMSAction paramCMSAction);
  
  public abstract void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus);
  
  public abstract void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.ICMSPlayerListener
 * JD-Core Version:    0.7.0.1
 */