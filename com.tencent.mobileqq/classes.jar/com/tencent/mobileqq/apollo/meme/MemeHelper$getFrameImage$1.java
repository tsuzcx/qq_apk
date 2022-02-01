package com.tencent.mobileqq.apollo.meme;

import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager;
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
final class MemeHelper$getFrameImage$1
  extends Lambda
  implements Function0<Unit>
{
  MemeHelper$getFrameImage$1(MemeAction paramMemeAction, float paramFloat, GetFrameCallback paramGetFrameCallback)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = MemeAction.a(this.$action, null, "frame", 1, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFrameImage, ");
    localStringBuilder.append(this.$action.h());
    localStringBuilder.append(", timeOffset:");
    localStringBuilder.append(this.$timeOffset);
    QLog.w("[cmshow][MemePlayer]", 1, localStringBuilder.toString());
    localObject = ApolloScreenshotController.a.a((String)localObject);
    if ((localObject != null) && (((File)localObject).exists()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFrameImage result from cache, ");
      localStringBuilder.append(this.$action.h());
      localStringBuilder.append(", path:");
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      QLog.w("[cmshow][MemePlayer]", 1, localStringBuilder.toString());
      this.$callback.a(true, ((File)localObject).getAbsolutePath(), this.$action);
      return;
    }
    long l = System.currentTimeMillis();
    localObject = this.$action;
    ((MemeAction)localObject).a(MODE.ACTION_MODE_FRAME);
    ((MemeAction)localObject).c().B = MemeHelper.a(MemeHelper.a, this.$timeOffset);
    localObject = new MemeHelper.GetFrameImageListener(this.$callback, l);
    MemeBornPlayerManager.a.a((int)DeviceInfoUtil.D(), ViewUtils.dpToPx(MemeHelper.a(MemeHelper.a)), this.$action, (IMemePlayerListener)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.MemeHelper.getFrameImage.1
 * JD-Core Version:    0.7.0.1
 */