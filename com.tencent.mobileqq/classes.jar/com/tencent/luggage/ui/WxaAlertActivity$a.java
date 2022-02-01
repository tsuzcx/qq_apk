package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.luggage.wxa.dc.h.a;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaAlertActivity$Companion;", "", "()V", "KEY_ALERT_PARCEL", "", "TAG", "showAlert", "", "inContext", "Landroid/content/Context;", "alertParams", "Lcom/tencent/luggage/login/ITdiTransferAlertService$AlertParams;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaAlertActivity$a
{
  public final void a(@Nullable Context paramContext, @NotNull h.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "alertParams");
    parama = new Intent().setClass(r.a(), WxaAlertActivity.class).putExtra("KEY_ALERT_PARCEL", (Parcelable)parama);
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      if ((!localActivity.isFinishing()) && (!localActivity.isDestroyed()))
      {
        paramContext.startActivity(parama);
        return;
      }
    }
    parama.addFlags(268435456);
    r.a().startActivity(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaAlertActivity.a
 * JD-Core Version:    0.7.0.1
 */