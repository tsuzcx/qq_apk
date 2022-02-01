package com.tencent.luggage.wxa.ng;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class g$g
  implements DialogInterface.OnDismissListener
{
  g$g(g paramg) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (g.f(this.a) != null)
    {
      paramDialogInterface = g.f(this.a);
      if (paramDialogInterface == null) {
        Intrinsics.throwNpe();
      }
      if (!paramDialogInterface.isAlive())
      {
        paramDialogInterface = this.a;
        View localView = g.g(paramDialogInterface);
        if (localView == null) {
          Intrinsics.throwNpe();
        }
        g.a(paramDialogInterface, localView.getViewTreeObserver());
      }
      paramDialogInterface = g.f(this.a);
      if (paramDialogInterface == null) {
        Intrinsics.throwNpe();
      }
      paramDialogInterface.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.a);
      g.a(this.a, (ViewTreeObserver)null);
    }
    this.a.a().invoke(Integer.valueOf(((Collection)this.a.h().c()).size() + ((Collection)this.a.h().b()).size()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g.g
 * JD-Core Version:    0.7.0.1
 */