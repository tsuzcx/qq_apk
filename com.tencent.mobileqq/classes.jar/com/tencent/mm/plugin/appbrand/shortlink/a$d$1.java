package com.tencent.mm.plugin.appbrand.shortlink;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.ow.b;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "LAUNCH_PHASE_RET", "invoke"}, k=3, mv={1, 1, 16})
final class a$d$1
  extends Lambda
  implements Function0<Unit>
{
  a$d$1(a.d paramd, b paramb, Function0 paramFunction0, Activity paramActivity)
  {
    super(0);
  }
  
  public final void a()
  {
    MMAlertDialog.Builder localBuilder = new MMAlertDialog.Builder((Context)this.a.b);
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = this.a.b.getString(2131886896);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ctx.getString(R.string.a…rt_link_launch_alert_mgs)");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.b.e();
    localObject = String.format((String)localObject, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    localBuilder.setMsg((String)localObject);
    localBuilder.setCancelable(false);
    localBuilder.setPositiveBtnText(this.a.b.getString(2131886894));
    localBuilder.setNegativeBtnText(this.a.b.getString(2131886895));
    localBuilder.setPositiveBtnListener((DialogInterface.OnClickListener)new a.d.1.1(this));
    localBuilder.setNegativeBtnListener((DialogInterface.OnClickListener)new a.d.1.2(this));
    localBuilder.create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.a.d.1
 * JD-Core Version:    0.7.0.1
 */