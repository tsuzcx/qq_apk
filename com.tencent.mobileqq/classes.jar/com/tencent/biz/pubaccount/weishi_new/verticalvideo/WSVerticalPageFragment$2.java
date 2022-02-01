package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;

class WSVerticalPageFragment$2
  implements View.OnLayoutChangeListener
{
  WSVerticalPageFragment$2(WSVerticalPageFragment paramWSVerticalPageFragment, RecyclerView paramRecyclerView, TextView paramTextView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.removeOnLayoutChangeListener(this);
    paramInt1 = (int)((int)(this.a.getHeight() * 0.3F) - this.b.getPaddingTop() - this.b.getTextSize());
    paramView = this.b;
    paramView.setPadding(paramView.getPaddingLeft(), this.b.getPaddingTop(), this.b.getPaddingRight(), paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment.2
 * JD-Core Version:    0.7.0.1
 */