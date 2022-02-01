package com.tencent.mobileqq.apollo.meme;

import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.INSTANCE;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.COMPLETE;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class MemeHelper$recordAction$1
  extends Lambda
  implements Function0<Unit>
{
  MemeHelper$recordAction$1(MemeAction paramMemeAction, String paramString, IMemePlayerListener paramIMemePlayerListener)
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str = MemeAction.a(this.$action, this.$recordKey, null, 2, null);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("recordAction, ");
    ((StringBuilder)localObject1).append(this.$action.h());
    QLog.w("[cmshow][MemePlayer]", 1, ((StringBuilder)localObject1).toString());
    localObject1 = ApolloScreenshotController.a.a(str);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("recordAction result from cache, ");
      ((StringBuilder)localObject2).append(this.$action.h());
      ((StringBuilder)localObject2).append(", path:");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      QLog.w("[cmshow][MemePlayer]", 1, ((StringBuilder)localObject2).toString());
      this.$action.a((ActionStatus)COMPLETE.a);
      localObject2 = this.$listener;
      if (localObject2 != null) {
        ((IMemePlayerListener)localObject2).a(this.$action, true, str, ((File)localObject1).getAbsolutePath());
      }
      return;
    }
    if (this.$action.i() != MODE.ACTION_MODE_RECORD_GIF) {
      this.$action.a(MODE.ACTION_MODE_RECORD_APNG);
    }
    MemeBornPlayerManager.a.a((int)DeviceInfoUtil.D(), ViewUtils.dpToPx(MemeHelper.a(MemeHelper.a)), this.$action, this.$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.MemeHelper.recordAction.1
 * JD-Core Version:    0.7.0.1
 */