package com.tencent.luggage.wxa.el;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/util/WxaAuthorizeUIHelper$Companion;", "", "()V", "showCloseAuthorizeAlert", "", "cxt", "Landroid/content/Context;", "onPositiveClick", "Landroid/content/DialogInterface$OnClickListener;", "onNegativeCLick", "onCancelCLick", "Landroid/content/DialogInterface$OnCancelListener;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$a
{
  @JvmStatic
  public final void a(@NotNull Context paramContext, @NotNull DialogInterface.OnClickListener paramOnClickListener1, @NotNull DialogInterface.OnClickListener paramOnClickListener2, @NotNull DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "cxt");
    Intrinsics.checkParameterIsNotNull(paramOnClickListener1, "onPositiveClick");
    Intrinsics.checkParameterIsNotNull(paramOnClickListener2, "onNegativeCLick");
    Intrinsics.checkParameterIsNotNull(paramOnCancelListener, "onCancelCLick");
    MMAlertDialog.Builder localBuilder = new MMAlertDialog.Builder(paramContext);
    localBuilder.setMsg(paramContext.getString(2131886760));
    localBuilder.setPositiveBtnText(paramContext.getString(2131886759));
    localBuilder.setPositiveBtnListener(paramOnClickListener1);
    localBuilder.setNegativeBtnText(paramContext.getString(2131887626));
    localBuilder.setNegativeBtnListener(paramOnClickListener2);
    localBuilder.setOnCancelListener(paramOnCancelListener);
    paramContext = localBuilder.create();
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.el.a.a
 * JD-Core Version:    0.7.0.1
 */