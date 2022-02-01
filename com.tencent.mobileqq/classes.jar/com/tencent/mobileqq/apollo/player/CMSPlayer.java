package com.tencent.mobileqq.apollo.player;

import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/CMSPlayer;", "", "width", "", "height", "(II)V", "offScreenHeight", "", "getFrameImage", "", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "timeOffset", "callback", "Lcom/tencent/mobileqq/apollo/player/GetFrameCallback;", "recordAction", "recordKey", "", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "Companion", "GetFrameImageListener", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class CMSPlayer
{
  public static final CMSPlayer.Companion a;
  private final float a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer$Companion = new CMSPlayer.Companion(null);
  }
  
  public CMSPlayer(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Float = CmShowWnsUtils.a();
  }
  
  public final void a(@NotNull CMSAction paramCMSAction, float paramFloat, @NotNull GetFrameCallback paramGetFrameCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramGetFrameCallback, "callback");
    CMSHelper.a.b((Function0)new CMSPlayer.getFrameImage.1(this, paramCMSAction, paramFloat, paramGetFrameCallback));
  }
  
  public final void a(@Nullable String paramString, @NotNull CMSAction paramCMSAction, @Nullable ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    CMSHelper.a.b((Function0)new CMSPlayer.recordAction.1(this, paramCMSAction, paramString, paramICMSPlayerListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer
 * JD-Core Version:    0.7.0.1
 */