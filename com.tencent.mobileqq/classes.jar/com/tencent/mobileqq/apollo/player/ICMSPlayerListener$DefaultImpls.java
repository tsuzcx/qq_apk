package com.tencent.mobileqq.apollo.player;

import com.tencent.mobileqq.apollo.player.action.CMSAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class ICMSPlayerListener$DefaultImpls
{
  public static void a(ICMSPlayerListener paramICMSPlayerListener, @NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
  }
  
  public static void a(ICMSPlayerListener paramICMSPlayerListener, @NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
  }
  
  public static void a(ICMSPlayerListener paramICMSPlayerListener, @NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramCMSActionStatus, "status");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.ICMSPlayerListener.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */