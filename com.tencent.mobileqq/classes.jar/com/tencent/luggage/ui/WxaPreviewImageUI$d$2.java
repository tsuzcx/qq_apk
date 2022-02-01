package com.tencent.luggage.ui;

import android.view.MenuItem;
import com.tencent.luggage.widget.c;
import com.tencent.mm.ui.base.i.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected", "com/tencent/luggage/ui/WxaPreviewImageUI$onCreate$1$1$3$1$2", "com/tencent/luggage/ui/WxaPreviewImageUI$onCreate$1$1$3$$special$$inlined$apply$lambda$1", "com/tencent/luggage/ui/WxaPreviewImageUI$$special$$inlined$apply$lambda$3$2"}, k=3, mv={1, 1, 16})
final class WxaPreviewImageUI$d$2
  implements i.e
{
  WxaPreviewImageUI$d$2(int paramInt, WxaPreviewImageUI.d paramd) {}
  
  public final void a(MenuItem paramMenuItem, int paramInt)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramMenuItem, "menuItem");
    if (paramMenuItem.getItemId() == this.a) {
      WxaPreviewImageUI.a(this.b.d, this.b.b.getSourceUri());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI.d.2
 * JD-Core Version:    0.7.0.1
 */