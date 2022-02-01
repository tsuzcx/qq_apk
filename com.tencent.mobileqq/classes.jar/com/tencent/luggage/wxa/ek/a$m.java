package com.tencent.luggage.wxa.ek;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/setting/ui/dialog/WxaSettingDialog$onShow$8", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$m
  implements AbsListView.OnScrollListener
{
  public void onScroll(@NotNull AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsListView, "view");
  }
  
  public void onScrollStateChanged(@NotNull AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    Intrinsics.checkParameterIsNotNull(paramAbsListView, "view");
    if (1 == paramInt)
    {
      paramAbsListView = this.a.getCurrentFocus();
      if (paramAbsListView != null) {
        paramAbsListView.clearFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ek.a.m
 * JD-Core Version:    0.7.0.1
 */