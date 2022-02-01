package com.tencent.luggage.opensdk;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Looper;
import com.tencent.luggage.wxa.qz.s;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/OpenSDKTicketTransferDelayRevealDialog;", "Landroid/content/DialogInterface;", "factory", "Lkotlin/Function0;", "Landroid/app/Dialog;", "(Lkotlin/jvm/functions/Function0;)V", "H", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mDialog", "mDismissed", "", "cancel", "", "dismiss", "show", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class h
  implements DialogInterface
{
  private final s a;
  private boolean b;
  private Dialog c;
  private final Function0<Dialog> d;
  
  public h(@NotNull Function0<? extends Dialog> paramFunction0)
  {
    this.d = paramFunction0;
    this.a = new s(Looper.getMainLooper());
  }
  
  public final void a()
  {
    this.a.b((Runnable)new h.a(this), 500L);
  }
  
  public void cancel()
  {
    if (((h)this).c != null)
    {
      Dialog localDialog = this.c;
      if (localDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mDialog");
      }
      localDialog.cancel();
    }
    dismiss();
  }
  
  public void dismiss()
  {
    this.b = true;
    this.a.a(null);
    if (((h)this).c != null) {}
    try
    {
      Dialog localDialog = this.c;
      if (localDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mDialog");
      }
      localDialog.dismiss();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.h
 * JD-Core Version:    0.7.0.1
 */