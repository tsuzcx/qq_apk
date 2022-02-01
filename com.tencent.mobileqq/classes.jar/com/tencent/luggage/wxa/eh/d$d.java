package com.tencent.luggage.wxa.eh;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"}, k=3, mv={1, 1, 16})
final class d$d
  implements View.OnCreateContextMenuListener
{
  d$d(View paramView) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.context");
    paramContextMenu.add(0, 1, 0, (CharSequence)paramView.getResources().getString(2131886924));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eh.d.d
 * JD-Core Version:    0.7.0.1
 */