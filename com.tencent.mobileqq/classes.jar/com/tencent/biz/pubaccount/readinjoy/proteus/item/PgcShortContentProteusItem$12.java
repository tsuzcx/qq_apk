package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;

class PgcShortContentProteusItem$12
  implements View.OnAttachStateChangeListener
{
  PgcShortContentProteusItem$12(PgcShortContentProteusItem paramPgcShortContentProteusItem) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (PgcShortContentProteusItem.a(this.a) != null)
    {
      PgcShortContentProteusItem.a(this.a).b();
      PgcShortContentProteusItem.a(this.a, null);
    }
    if (PgcShortContentProteusItem.a(this.a) != null)
    {
      PgcShortContentProteusItem.a(this.a).a();
      PgcShortContentProteusItem.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcShortContentProteusItem.12
 * JD-Core Version:    0.7.0.1
 */