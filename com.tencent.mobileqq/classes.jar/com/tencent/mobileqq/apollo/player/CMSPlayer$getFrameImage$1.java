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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFrameImage, ");
    localStringBuilder.append(this.$action.d());
    localStringBuilder.append(", timeOffset:");
    localStringBuilder.append(this.$timeOffset);
    QLog.w("[cmshow][scripted][CMSPlayer]", 1, localStringBuilder.toString());
    localObject = ApolloScreenshotController.a.a((String)localObject);
    if ((localObject != null) && (((File)localObject).exists()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFrameImage result from cache, ");
      localStringBuilder.append(this.$action.d());
      localStringBuilder.append(", path:");
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      QLog.w("[cmshow][scripted][CMSPlayer]", 1, localStringBuilder.toString());
      this.$callback.a(true, ((File)localObject).getAbsolutePath(), this.$action);
      return;
    }
    long l = System.currentTimeMillis();
    localObject = this.$action;
    ((CMSAction)localObject).a(MODE.ACTION_MODE_FRAME);
    ((CMSAction)localObject).a().b = CMSPlayer.Companion.a(CMSPlayer.a, this.$timeOffset);
    localObject = new CMSPlayer.GetFrameImageListener(this.$callback, l);
    CMSBornPlayerManager.a.a((int)DeviceInfoUtil.i(), ViewUtils.b(CMSPlayer.a(this.this$0)), this.$action, (ICMSPlayerListener)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.getFrameImage.1
 * JD-Core Version:    0.7.0.1
 */