package com.tencent.mobileqq.activity.emogroupstore;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.widget.TextView;

class EmoticonGroupStoreFragment$4
  extends RecyclerView.OnScrollListener
{
  EmoticonGroupStoreFragment$4(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    paramInt1 = paramRecyclerView.findFirstVisibleItemPosition();
    String str = EmoticonGroupStoreFragment.g(this.a).a(paramInt1);
    if ((str != null) && (paramInt2 != 0))
    {
      EmoticonGroupStoreFragment.h(this.a).setTextSize(16.0F);
      EmoticonGroupStoreFragment.h(this.a).setTextColor(Color.parseColor("#FF000000"));
      EmoticonGroupStoreFragment.h(this.a).setText(str);
    }
    if (paramInt2 < 0)
    {
      paramRecyclerView = paramRecyclerView.findViewByPosition(paramInt1);
      if (paramRecyclerView != null)
      {
        float f = paramRecyclerView.getY();
        if ((paramInt1 == 0) && (0.0F == f))
        {
          EmoticonGroupStoreFragment.h(this.a).setTextSize(14.0F);
          EmoticonGroupStoreFragment.h(this.a).setTextColor(Color.parseColor("#FF777777"));
          EmoticonGroupStoreFragment.h(this.a).setText(EmoticonGroupStoreFragment.i(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.4
 * JD-Core Version:    0.7.0.1
 */