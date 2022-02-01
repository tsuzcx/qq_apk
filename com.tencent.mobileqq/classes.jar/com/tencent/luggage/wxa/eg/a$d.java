package com.tencent.luggage.wxa.eg;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.ik.c;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class a$d
  implements View.OnClickListener
{
  a$d(a parama, d paramd) {}
  
  public final void onClick(View paramView)
  {
    View localView = c.a.a(a.b(this.a), this.b.f(), a.b(this.a).getResources().getDimensionPixelSize(2131296404));
    MMAlertDialog.Builder localBuilder = new MMAlertDialog.Builder(a.b(this.a));
    localBuilder.setTitle(this.a.a());
    localBuilder.setPositiveBtnText(a.b(this.a).getString(2131886911));
    localBuilder.setView(localView);
    localBuilder.setCancelable(false);
    localBuilder.setOnCancelListener((DialogInterface.OnCancelListener)a.d.a.a);
    localBuilder.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eg.a.d
 * JD-Core Version:    0.7.0.1
 */