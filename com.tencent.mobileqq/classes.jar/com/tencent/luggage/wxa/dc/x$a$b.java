package com.tencent.luggage.wxa.dc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.pc.h;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class x$a$b
  extends Lambda
  implements Function0<MMAlertDialog>
{
  x$a$b(Activity paramActivity, h.a parama)
  {
    super(0);
  }
  
  public final MMAlertDialog a()
  {
    MMAlertDialog localMMAlertDialog = new MMAlertDialog.Builder((Context)this.a).setTitle(this.b.b()).setMsg(this.b.c()).setCancelable(false).setPositiveBtnText(2131886911).setPositiveBtnListener((DialogInterface.OnClickListener)x.a.b.1.a).create();
    x.a.a(x.a.a).a(this.a, localMMAlertDialog);
    localMMAlertDialog.show();
    return localMMAlertDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.x.a.b
 * JD-Core Version:    0.7.0.1
 */