package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import com.tencent.biz.pubaccount.weishi_new.drama.checkable.OnCheckedListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalChoiceVideoPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;

class WSEpisodeChoicePanel$3
  implements OnCheckedListener<WSVerticalItemData>
{
  WSEpisodeChoicePanel$3(WSEpisodeChoicePanel paramWSEpisodeChoicePanel) {}
  
  public void a(WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    WSEpisodeChoicePanel.a(this.a, paramInt);
    this.a.a().a().a().scrollToPosition(paramInt);
    WSEpisodeChoicePanel.a(this.a, true);
    this.a.dismiss();
    WSEpisodeChoicePanel.a(this.a, paramWSVerticalItemData);
  }
  
  public void b(WSVerticalItemData paramWSVerticalItemData, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel.3
 * JD-Core Version:    0.7.0.1
 */