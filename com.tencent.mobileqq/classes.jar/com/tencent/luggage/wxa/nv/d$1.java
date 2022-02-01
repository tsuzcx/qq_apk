package com.tencent.luggage.wxa.nv;

import android.view.View;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;

final class d$1
  implements d.a
{
  d$1(MMBottomSheet paramMMBottomSheet, d.a parama) {}
  
  public void a(View paramView, int paramInt)
  {
    if (this.a.isShowing()) {
      this.a.tryHide();
    }
    this.b.a(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nv.d.1
 * JD-Core Version:    0.7.0.1
 */