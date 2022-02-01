package com.tencent.luggage.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.luggage.widget.c;
import com.tencent.mm.ui.base.i.d;
import com.tencent.mm.ui.base.i.e;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/luggage/ui/WxaPreviewImageUI$onCreate$1$1$3", "com/tencent/luggage/ui/WxaPreviewImageUI$$special$$inlined$apply$lambda$3"}, k=3, mv={1, 1, 16})
final class WxaPreviewImageUI$d
  implements View.OnLongClickListener
{
  WxaPreviewImageUI$d(c paramc1, c paramc2, String paramString, WxaPreviewImageUI paramWxaPreviewImageUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    paramView = new MMBottomSheet(this.a.getContext(), 1, false);
    paramView.setOnCreateMenuListener((i.d)new WxaPreviewImageUI.d.1(1));
    paramView.setOnMenuSelectedListener((i.e)new WxaPreviewImageUI.d.2(1, this));
    paramView.tryShow();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI.d
 * JD-Core Version:    0.7.0.1
 */