package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

class WSEpisodeChoicePanel$1
  extends RecyclerView.OnScrollListener
{
  WSEpisodeChoicePanel$1(WSEpisodeChoicePanel paramWSEpisodeChoicePanel) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java] onScrolled");
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (((LinearLayoutManager)WSEpisodeChoicePanel.a(this.a).getRecyclerView().getLayoutManager()).findFirstVisibleItemPosition() >= 10) {
      return;
    }
    WSEpisodeChoicePanel.a(this.a);
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel.1
 * JD-Core Version:    0.7.0.1
 */