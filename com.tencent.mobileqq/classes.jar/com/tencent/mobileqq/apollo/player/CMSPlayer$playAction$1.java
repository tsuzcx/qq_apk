package com.tencent.mobileqq.apollo.player;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager;
import com.tencent.mobileqq.apollo.player.manager.CMSFramePlayerManager;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSPlayer$playAction$1
  extends Lambda
  implements Function0<Unit>
{
  CMSPlayer$playAction$1(CMSPlayer paramCMSPlayer, CMSAction paramCMSAction, String paramString, ICMSPlayerListener paramICMSPlayerListener)
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str = CMSAction.a(this.$action, this.$recordKey, null, 2, null);
    QLog.w("cmshow_scripted_[CMSPlayer]", 1, "playAction, " + this.$action.d());
    if (Intrinsics.areEqual(CMSPlayer.a(this.this$0), this.$action))
    {
      QLog.w("cmshow_scripted_[CMSPlayer]", 1, "playAction, " + this.$action.d() + " already played");
      return;
    }
    this.this$0.a();
    Object localObject = this.this$0;
    CMSAction localCMSAction = this.$action;
    localCMSAction.a(MODE.ACTION_MODE_PLAY);
    CMSPlayer.a((CMSPlayer)localObject, localCMSAction);
    localObject = ApolloScreenshotController.a.a(str);
    if (localObject != null)
    {
      CMSFramePlayerManager.a.a(CMSPlayer.a(this.this$0), (File)localObject);
      return;
    }
    CMSBornPlayerManager.a.a(CMSPlayer.a(this.this$0), CMSPlayer.b(this.this$0), str, this.$action, CMSPlayer.a(this.this$0), this.$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.playAction.1
 * JD-Core Version:    0.7.0.1
 */