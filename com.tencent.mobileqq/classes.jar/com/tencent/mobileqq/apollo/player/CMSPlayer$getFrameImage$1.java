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
final class CMSPlayer$getFrameImage$1
  extends Lambda
  implements Function0<Unit>
{
  CMSPlayer$getFrameImage$1(CMSPlayer paramCMSPlayer, CMSAction paramCMSAction, float paramFloat, GetFrameCallback paramGetFrameCallback)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = CMSAction.a(this.$action, null, "frame", 1, null);
    QLog.w("cmshow_scripted_[CMSPlayer]", 1, "getFrameImage, " + this.$action.d() + ", timeOffset:" + this.$timeOffset);
    localObject = ApolloScreenshotController.a.a((String)localObject);
    if ((localObject != null) && (((File)localObject).exists()))
    {
      QLog.w("cmshow_scripted_[CMSPlayer]", 1, "getFrameImage result from cache, " + this.$action.d() + ", path:" + ((File)localObject).getAbsolutePath());
      this.$callback.a(true, ((File)localObject).getAbsolutePath(), this.$action);
      return;
    }
    long l = System.currentTimeMillis();
    localObject = this.$action;
    ((CMSAction)localObject).a(MODE.ACTION_MODE_FRAME);
    ((CMSAction)localObject).a().b = CMSPlayer.Companion.a(CMSPlayer.a, this.$timeOffset);
    localObject = new CMSPlayer.GetFrameImageListener(this.$callback, l);
    CMSBornPlayerManager.a.a(CMSPlayer.Companion.a(CMSPlayer.a, (int)DeviceInfoUtil.i(), CMSPlayer.a(this.this$0)), ViewUtils.b(CMSPlayer.b(this.this$0)), this.$action, (ICMSPlayerListener)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.getFrameImage.1
 * JD-Core Version:    0.7.0.1
 */