package com.tencent.luggage.wxa.fh;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class a$a
  implements Runnable
{
  a$a(com.tencent.luggage.wxa.iu.b paramb, String paramString) {}
  
  public final void run()
  {
    Object localObject = this.a.q();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((d)localObject).ap();
    com.tencent.mm.plugin.appbrand.widget.dialog.b localb = new com.tencent.mm.plugin.appbrand.widget.dialog.b(this.a.getContext());
    localb.setMessage((CharSequence)this.b);
    localb.setTitle((CharSequence)this.a.getContext().getString(2131889038));
    localb.setPositiveButton(2131887629, (DialogInterface.OnClickListener)new a.a.a(localb));
    localb.setCanceledOnTouchOutside(false);
    localb.setCancelable(false);
    ((l)localObject).a((i)localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fh.a.a
 * JD-Core Version:    0.7.0.1
 */