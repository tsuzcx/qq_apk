package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import android.support.v7.widget.RecyclerView.LayoutManager;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

class WSEpisodeChoicePanel$7
  implements Runnable
{
  WSEpisodeChoicePanel$7(WSEpisodeChoicePanel paramWSEpisodeChoicePanel, int paramInt) {}
  
  public void run()
  {
    WSTopSmoothScroller localWSTopSmoothScroller = new WSTopSmoothScroller(WSEpisodeChoicePanel.a(this.this$0));
    localWSTopSmoothScroller.setTargetPosition(this.a);
    WSEpisodeChoicePanel.a(this.this$0).getRecyclerView().getLayoutManager().startSmoothScroll(localWSTopSmoothScroller);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel.7
 * JD-Core Version:    0.7.0.1
 */