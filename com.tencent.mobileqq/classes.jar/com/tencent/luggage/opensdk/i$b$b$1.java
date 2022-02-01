package com.tencent.luggage.opensdk;

import android.content.Context;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/dialog/WeUIProgresssDialog;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class i$b$b$1
  extends Lambda
  implements Function0<WeUIProgresssDialog>
{
  i$b$b$1(i.b.b paramb)
  {
    super(0);
  }
  
  public final WeUIProgresssDialog a()
  {
    Object localObject = i.b.b(this.a.a).a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request.env");
    localObject = ((a.a)localObject).d();
    if (localObject == null) {
      localObject = r.a();
    }
    localObject = WeUIProgresssDialog.getProgressDialog((Context)localObject, (CharSequence)r.a().getString(2131892339), false, null);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WeUIProgresssDialog.getP…                    null)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b.b.1
 * JD-Core Version:    0.7.0.1
 */