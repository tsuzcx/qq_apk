package com.tencent.mobileqq.apollo.player;

import amvg;
import amvh;
import amvi;
import amvj;
import amvk;
import amvy;
import anbo;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSAction.Companion.MODE;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class CMSPlayer$getFrameImage$1
  extends Lambda
  implements Function0<Unit>
{
  public CMSPlayer$getFrameImage$1(amvg paramamvg, CMSAction paramCMSAction, float paramFloat, amvj paramamvj)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject1 = CMSAction.a(this.$action, null, "frame", 1, null);
    QLog.w("cmshow_scripted_[CMSPlayer]", 1, "getFrameImage, " + this.$action.d() + ", timeOffset:" + this.$timeOffset);
    Object localObject2 = anbo.a.a((String)localObject1);
    if ((localObject2 != null) && (((File)localObject2).exists()))
    {
      QLog.w("cmshow_scripted_[CMSPlayer]", 1, "getFrameImage result from cache, " + this.$action.d() + ", path:" + ((File)localObject2).getAbsolutePath());
      this.$callback.a(true, ((File)localObject2).getAbsolutePath(), new Error());
      return;
    }
    long l = System.currentTimeMillis();
    localObject2 = this.$action;
    ((CMSAction)localObject2).a(CMSAction.Companion.MODE.ACTION_MODE_FRAME);
    ((CMSAction)localObject2).a().b = amvh.a(amvg.a, this.$timeOffset);
    localObject1 = new amvi(this, l, (String)localObject1);
    amvy.a.a(amvh.a(amvg.a, (int)DeviceInfoUtil.getPortraitWidth(), amvg.a(this.this$0)), ViewUtils.dpToPx(amvg.b(this.this$0)), this.$action, (amvk)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.getFrameImage.1
 * JD-Core Version:    0.7.0.1
 */