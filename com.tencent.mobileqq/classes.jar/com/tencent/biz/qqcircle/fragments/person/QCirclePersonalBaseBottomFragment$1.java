package com.tencent.biz.qqcircle.fragments.person;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartManager;

class QCirclePersonalBaseBottomFragment$1
  extends RecyclerView.OnScrollListener
{
  QCirclePersonalBaseBottomFragment$1(QCirclePersonalBaseBottomFragment paramQCirclePersonalBaseBottomFragment) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if ((this.a.D() != null) && (this.a.D().p() != null)) {
      this.a.D().p().a("personal_page_action_title_bar_hide_follow_animation", Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment.1
 * JD-Core Version:    0.7.0.1
 */