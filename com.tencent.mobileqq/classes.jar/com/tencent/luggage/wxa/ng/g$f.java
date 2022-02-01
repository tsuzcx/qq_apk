package com.tencent.luggage.wxa.ng;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.p;
import com.tencent.luggage.wxa.nf.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k=3, mv={1, 1, 16})
final class g$f
  implements DialogInterface.OnCancelListener
{
  g$f(g paramg) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = g.c(this.a);
    if (paramDialogInterface != null) {
      paramDialogInterface = (Unit)paramDialogInterface.invoke(null, Integer.valueOf(0));
    }
    this.a.g().c().a((p)g.e(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g.f
 * JD-Core Version:    0.7.0.1
 */