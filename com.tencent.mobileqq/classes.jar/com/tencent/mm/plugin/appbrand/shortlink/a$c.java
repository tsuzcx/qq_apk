package com.tencent.mm.plugin.appbrand.shortlink;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "LAUNCH_PHASE_RET", "ret", "invoke", "(Ljava/lang/Object;)V"}, k=3, mv={1, 1, 16})
final class a$c
  extends Lambda
  implements Function1<LAUNCH_PHASE_RET, Unit>
{
  a$c(a parama, Activity paramActivity, a.b paramb, Function2 paramFunction2)
  {
    super(1);
  }
  
  public final void a(LAUNCH_PHASE_RET paramLAUNCH_PHASE_RET)
  {
    boolean bool = this.a.a(paramLAUNCH_PHASE_RET);
    this.a.a(this.b, this.c.d(), bool);
    Function2 localFunction2 = this.d;
    if (localFunction2 != null)
    {
      WxaShortLinkLaunchErrorCode localWxaShortLinkLaunchErrorCode;
      if (bool) {
        localWxaShortLinkLaunchErrorCode = WxaShortLinkLaunchErrorCode.SUCCESS;
      } else {
        localWxaShortLinkLaunchErrorCode = WxaShortLinkLaunchErrorCode.LAUNCH_PHASE_FAIL;
      }
      if (bool) {
        paramLAUNCH_PHASE_RET = null;
      }
      paramLAUNCH_PHASE_RET = (Unit)localFunction2.invoke(localWxaShortLinkLaunchErrorCode, paramLAUNCH_PHASE_RET);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.a.c
 * JD-Core Version:    0.7.0.1
 */