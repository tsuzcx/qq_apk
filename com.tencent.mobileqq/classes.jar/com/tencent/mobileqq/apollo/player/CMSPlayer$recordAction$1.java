package com.tencent.mobileqq.apollo.player;

import amvg;
import amvh;
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
public final class CMSPlayer$recordAction$1
  extends Lambda
  implements Function0<Unit>
{
  public CMSPlayer$recordAction$1(amvg paramamvg, CMSAction paramCMSAction, String paramString, amvk paramamvk)
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str = CMSAction.a(this.$action, this.$recordKey, null, 2, null);
    QLog.w("cmshow_scripted_[CMSPlayer]", 1, "recordAction, " + this.$action.d());
    File localFile = anbo.a.a(str);
    if ((localFile != null) && (localFile.exists()))
    {
      QLog.w("cmshow_scripted_[CMSPlayer]", 1, "recordAction result from cache, " + this.$action.d() + ", path:" + localFile.getAbsolutePath());
      amvk localamvk = this.$listener;
      if (localamvk != null) {
        localamvk.a(this.$action, CMSActionStatus.COMPLETE);
      }
      localamvk = this.$listener;
      if (localamvk != null) {
        localamvk.a(this.$action, true, str, localFile.getAbsolutePath());
      }
      return;
    }
    this.$action.a(CMSAction.Companion.MODE.ACTION_MODE_RECORD);
    amvy.a.a(amvh.a(amvg.a, (int)DeviceInfoUtil.getPortraitWidth(), amvg.a(this.this$0)), ViewUtils.dpToPx(amvg.b(this.this$0)), this.$action, this.$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.recordAction.1
 * JD-Core Version:    0.7.0.1
 */