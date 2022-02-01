package com.tencent.biz.pubaccount.weishi_new.drama;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.OnCheckedListener;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSDramaMiddlePart$2
  implements OnCheckedListener<WSEpisodeItemData>
{
  WSDramaMiddlePart$2(WSDramaMiddlePart paramWSDramaMiddlePart) {}
  
  public void a(WSEpisodeItemData paramWSEpisodeItemData, int paramInt)
  {
    WSDramaMiddlePart.a(this.a, 1);
    WSDramaBeaconReport.a(paramWSEpisodeItemData, this.a.i(), this.a.k());
    WSDramaMiddlePart.b(this.a);
    WSDramaMiddlePart.a(this.a, paramWSEpisodeItemData, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaMiddlePart.java][episodeChecked] mDramaId:");
    localStringBuilder.append(WSDramaMiddlePart.c(this.a));
    WSLog.e("WSDramaMiddlePartnel-log", localStringBuilder.toString());
    this.a.a(false, paramWSEpisodeItemData.b(), paramWSEpisodeItemData.c());
    WSDramaMiddlePart.d(this.a).getLayoutManager().smoothScrollToPosition(WSDramaMiddlePart.d(this.a), new RecyclerView.State(), paramInt);
  }
  
  public void b(WSEpisodeItemData paramWSEpisodeItemData, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaMiddlePart.2
 * JD-Core Version:    0.7.0.1
 */