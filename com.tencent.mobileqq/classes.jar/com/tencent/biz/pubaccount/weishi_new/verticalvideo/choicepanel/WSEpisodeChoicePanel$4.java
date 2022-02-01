package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;

class WSEpisodeChoicePanel$4
  implements XRecyclerView.RefreshCallback
{
  WSEpisodeChoicePanel$4(WSEpisodeChoicePanel paramWSEpisodeChoicePanel) {}
  
  public void endOfRefresh()
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][endOfRefresh]");
  }
  
  public void startLoadMore(XRecyclerView paramXRecyclerView, int paramInt)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][startLoadMore]");
    this.a.a(false, false);
  }
  
  public void startTopRefresh(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][startTopRefresh]");
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel.4
 * JD-Core Version:    0.7.0.1
 */