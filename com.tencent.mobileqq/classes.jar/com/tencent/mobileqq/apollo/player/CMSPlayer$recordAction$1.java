package com.tencent.mobileqq.apollo.player;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
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
    QLog.w("cmshow_scripted_[CMSPlayer]", 1, "recordAction, " + this.$action.d());
    File localFile = ApolloScreenshotController.a.a(str);
    if ((localFile != null) && (localFile.exists()))
    {
      QLog.w("cmshow_scripted_[CMSPlayer]", 1, "recordAction result from cache, " + this.$action.d() + ", path:" + localFile.getAbsolutePath());
      ICMSPlayerListener localICMSPlayerListener = this.$listener;
      if (localICMSPlayerListener != null) {
        localICMSPlayerListener.a(this.$action, CMSActionStatus.COMPLETE);
      }
      localICMSPlayerListener = this.$listener;
      if (localICMSPlayerListener != null) {
        localICMSPlayerListener.a(this.$action, true, str, localFile.getAbsolutePath());
      }
      return;
    }
    if (this.$action.a() != MODE.ACTION_MODE_RECORD_GIF) {
      this.$action.a(MODE.ACTION_MODE_RECORD_APNG);
    }
    CMSBornPlayerManager.a.a(CMSPlayer.Companion.a(CMSPlayer.a, (int)DeviceInfoUtil.i(), CMSPlayer.a(this.this$0)), ViewUtils.b(CMSPlayer.b(this.this$0)), this.$action, this.$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.recordAction.1
 * JD-Core Version:    0.7.0.1
 */