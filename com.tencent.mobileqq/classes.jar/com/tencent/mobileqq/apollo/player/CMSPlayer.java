package com.tencent.mobileqq.apollo.player;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/CMSPlayer;", "", "width", "", "height", "(II)V", "containerView", "Landroid/widget/FrameLayout;", "currentAction", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "density", "", "offScreenHeight", "destroy", "", "getFrameImage", "action", "timeOffset", "callback", "Lcom/tencent/mobileqq/apollo/player/GetFrameCallback;", "getView", "Landroid/view/View;", "pause", "playAction", "recordKey", "", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "recordAction", "resume", "Companion", "GetFrameImageListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class CMSPlayer
{
  public static final CMSPlayer.Companion a;
  private final float jdField_a_of_type_Float = DeviceInfoUtil.a();
  private final int jdField_a_of_type_Int;
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout((Context)BaseApplicationImpl.getApplication());
  private volatile CMSAction jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
  private final float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer$Companion = new CMSPlayer.Companion(null);
  }
  
  public CMSPlayer(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = CMSPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer$Companion, paramInt1, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Int = CMSPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer$Companion, paramInt2, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = CmShowWnsUtils.a();
  }
  
  public final void a()
  {
    CMSAction localCMSAction = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
    if (localCMSAction != null) {
      CMSHelper.a.c((Function0)new CMSPlayer.destroy.1.1(localCMSAction));
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction = ((CMSAction)null);
    CMSHelper.a.a((Function0)new CMSPlayer.destroy.2(this));
  }
  
  public final void a(@NotNull CMSAction paramCMSAction, float paramFloat, @NotNull GetFrameCallback paramGetFrameCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramGetFrameCallback, "callback");
    CMSHelper.a.c((Function0)new CMSPlayer.getFrameImage.1(this, paramCMSAction, paramFloat, paramGetFrameCallback));
  }
  
  public final void a(@Nullable String paramString, @NotNull CMSAction paramCMSAction, @Nullable ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    CMSHelper.a.c((Function0)new CMSPlayer.recordAction.1(this, paramCMSAction, paramString, paramICMSPlayerListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer
 * JD-Core Version:    0.7.0.1
 */