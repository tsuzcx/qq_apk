package com.tencent.mobileqq.apollo.player.manager;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSBornPlayerManager$playActionByBornPlayer$3
  extends Lambda
  implements Function0<Unit>
{
  CMSBornPlayerManager$playActionByBornPlayer$3(CMSBornPlayerManager.ActionItem paramActionItem, CMSBornPlayer paramCMSBornPlayer, CMSBornPlayerManager.playActionByBornPlayer.listenerWrapper.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = this.$actionItem.a();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((FrameLayout)localObject).removeAllViews();
    localObject = this.$player;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
    ((CMSBornPlayer)localObject).a((Context)localBaseApplicationImpl, this.$actionItem.a(), this.$actionItem.b(), this.$actionItem.a(), this.$actionItem.a(), (ICMSPlayerListener)this.$listenerWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.playActionByBornPlayer.3
 * JD-Core Version:    0.7.0.1
 */