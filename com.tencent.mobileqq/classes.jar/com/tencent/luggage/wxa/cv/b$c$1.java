package com.tencent.luggage.wxa.cv;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.qw.du;
import com.tencent.luggage.wxa.qw.dx;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class b$c$1
  implements DialogInterface.OnClickListener
{
  b$c$1(b.c paramc, du paramdu, dx paramdx) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.b;
    b.a();
    paramDialogInterface.b = 1;
    this.a.e.invoke();
    b.a(this.a.a, this.a.f, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.c.1
 * JD-Core Version:    0.7.0.1
 */