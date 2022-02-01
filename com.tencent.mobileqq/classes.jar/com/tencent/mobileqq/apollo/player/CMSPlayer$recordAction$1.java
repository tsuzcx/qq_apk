package com.tencent.mobileqq.apollo.player;

import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.MODE;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.INSTANCE;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSPlayer$recordAction$1
  extends Lambda
  implements Function0<Unit>
{
  CMSPlayer$recordAction$1(CMSPlayer paramCMSPlayer, CMSAction paramCMSAction, String paramString, ICMSPlayerListener paramICMSPlayerListener)
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str = CMSAction.a(this.$action, this.$recordKey, null, 2, null);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("recordAction, ");
    ((StringBuilder)localObject1).append(this.$action.d());
    QLog.w("[cmshow][scripted][CMSPlayer]", 1, ((StringBuilder)localObject1).toString());
    localObject1 = ApolloScreenshotController.a.a(str);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("recordAction result from cache, ");
      ((StringBuilder)localObject2).append(this.$action.d());
      ((StringBuilder)localObject2).append(", path:");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      QLog.w("[cmshow][scripted][CMSPlayer]", 1, ((StringBuilder)localObject2).toString());
      localObject2 = this.$listener;
      if (localObject2 != null) {
        ((ICMSPlayerListener)localObject2).a(this.$action, CMSActionStatus.COMPLETE);
      }
      localObject2 = this.$listener;
      if (localObject2 != null) {
        ((ICMSPlayerListener)localObject2).a(this.$action, true, str, ((File)localObject1).getAbsolutePath());
      }
      return;
    }
    if (this.$action.a() != MODE.ACTION_MODE_RECORD_GIF) {
      this.$action.a(MODE.ACTION_MODE_RECORD_APNG);
    }
    CMSBornPlayerManager.a.a((int)DeviceInfoUtil.i(), ViewUtils.b(CMSPlayer.a(this.this$0)), this.$action, this.$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.recordAction.1
 * JD-Core Version:    0.7.0.1
 */