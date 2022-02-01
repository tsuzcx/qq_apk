package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$createTabListView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowSwitchLayout$createTabListView$$inlined$apply$lambda$1
  extends RecyclerView.OnScrollListener
{
  FlashShowSwitchLayout$createTabListView$$inlined$apply$lambda$1(FlashShowSwitchLayout paramFlashShowSwitchLayout, Context paramContext, ColorStateList paramColorStateList, float paramFloat, int paramInt) {}
  
  public void onScrollStateChanged(@NotNull RecyclerView paramRecyclerView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "recyclerView");
    if (paramInt == 0)
    {
      paramRecyclerView = FlashShowSwitchLayout.a(this.a).getLayoutManager();
      if (paramRecyclerView != null)
      {
        paramInt = ((LinearLayoutManager)paramRecyclerView).findFirstVisibleItemPosition();
        RecyclerView.Adapter localAdapter = FlashShowSwitchLayout.a(this.a).getAdapter();
        if (localAdapter != null)
        {
          paramRecyclerView = localAdapter;
          if (!(localAdapter instanceof FlashShowSwitchLayout.TabItemAdapter)) {
            paramRecyclerView = null;
          }
          paramRecyclerView = (FlashShowSwitchLayout.TabItemAdapter)paramRecyclerView;
          if (paramRecyclerView != null)
          {
            paramRecyclerView.a(paramInt);
            paramRecyclerView.notifyDataSetChanged();
          }
        }
        paramRecyclerView = this.a.getTabSwitchListener();
        if (paramRecyclerView != null) {
          paramRecyclerView.a(paramInt);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout.createTabListView..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */