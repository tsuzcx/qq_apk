package com.tencent.mm.plugin.appbrand.shortlink;

import android.app.Activity;
import com.tencent.luggage.util.c;
import com.tencent.luggage.wxa.ow.b;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "LAUNCH_PHASE_RET", "cgiSuccess", "", "info", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class a$d
  extends Lambda
  implements Function2<Boolean, b, Unit>
{
  a$d(a parama, Activity paramActivity, Function2 paramFunction2, String paramString, boolean paramBoolean)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @Nullable b paramb)
  {
    Activity localActivity = (Activity)new WeakReference(this.b).get();
    if (c.a(localActivity))
    {
      paramb = this.c;
      if (paramb != null) {
        paramb = (Unit)paramb.invoke(WxaShortLinkLaunchErrorCode.CONTEXT_RELEASE, null);
      }
      return;
    }
    if ((paramBoolean) && (c.b(paramb))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if (!this.a.a(localActivity, paramBoolean))
    {
      paramb = this.c;
      if (paramb != null) {
        paramb = (Unit)paramb.invoke(WxaShortLinkLaunchErrorCode.INTERRUPT, null);
      }
      return;
    }
    if (!paramBoolean)
    {
      this.a.a(localActivity, this.d);
      paramb = this.c;
      if (paramb != null) {
        paramb = (Unit)paramb.invoke(WxaShortLinkLaunchErrorCode.DECODE_LINK_FAIL, null);
      }
      return;
    }
    if (paramb == null) {
      Intrinsics.throwNpe();
    }
    Function0 localFunction0 = (Function0)new a.d.a(this, localActivity, paramb);
    if (this.e)
    {
      c.a((Function0)new a.d.1(this, paramb, localFunction0, localActivity));
      return;
    }
    localFunction0.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.a.d
 * JD-Core Version:    0.7.0.1
 */