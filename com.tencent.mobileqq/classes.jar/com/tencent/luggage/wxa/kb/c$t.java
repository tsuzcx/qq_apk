package com.tencent.luggage.wxa.kb;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k=3, mv={1, 1, 16})
final class c$t
  implements DialogInterface.OnCancelListener
{
  c$t(b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a("user cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.t
 * JD-Core Version:    0.7.0.1
 */