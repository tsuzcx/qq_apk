package com.tencent.luggage.wxa.ek;

import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/setting/ui/dialog/WxaSettingDialog$onShow$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialogDismissStateListener;", "onDismiss", "", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$g
  implements j
{
  public void a(@Nullable i parami)
  {
    if ((parami != null) && (Intrinsics.areEqual(parami, this.a)))
    {
      this.a.c().invoke();
      parami = a.a(this.a);
      if (parami != null) {
        parami.b((j)this);
      }
      parami = a.a(this.a);
      if ((parami != null) && (parami.getCurrentDialog() != null)) {
        return;
      }
      parami = (g)this;
      this.a.b().invoke(Boolean.valueOf(true));
      parami = Unit.INSTANCE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ek.a.g
 * JD-Core Version:    0.7.0.1
 */