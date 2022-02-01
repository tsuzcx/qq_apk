package com.tencent.luggage.wxa.cs;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/luggage/jsapi/version/JsApiUpdateApp$invoke$1$1"}, k=3, mv={1, 1, 16})
final class a$b
  implements Runnable
{
  a$b(d paramd, a parama, com.tencent.luggage.wxa.iu.b paramb, int paramInt) {}
  
  public final void run()
  {
    Object localObject = this.a.ah();
    if (localObject != null) {
      localObject = (Context)localObject;
    } else {
      localObject = this.a.ag();
    }
    com.tencent.mm.plugin.appbrand.widget.dialog.b localb = new com.tencent.mm.plugin.appbrand.widget.dialog.b((Context)localObject);
    localb.setCanceledOnTouchOutside(false);
    localb.setCancelable(false);
    localObject = this.a.ah();
    if (localObject != null)
    {
      localObject = (Context)localObject;
    }
    else
    {
      localObject = this.a.ag();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this.appContext");
    }
    int i;
    if (a.a(this.b, this.a)) {
      i = 2131886825;
    } else {
      i = 2131886826;
    }
    localb.setMessage((CharSequence)((Context)localObject).getString(i, new Object[] { this.a.B().E }));
    localb.setPositiveButton(2131886824, (DialogInterface.OnClickListener)new a.b.1(this));
    localb.setNegativeButton(2131886822, (DialogInterface.OnClickListener)new a.b.2(this));
    this.a.ao().a((i)localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cs.a.b
 * JD-Core Version:    0.7.0.1
 */