package com.tencent.biz.qqcircle.scrollers;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.events.QCircleTimeLineCreateTimeEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleTimeLineAndGridScroller
  extends QCircleFeedBaseScroller
{
  private void c(View paramView)
  {
    if ((paramView instanceof QCircleTimeLineFeedItemView))
    {
      paramView = (QCircleTimeLineFeedItemView)paramView;
      if ((paramView.getData() instanceof FeedBlockData))
      {
        paramView = ((FeedBlockData)paramView.getData()).b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendFirstItemViewData feedId:");
        localStringBuilder.append(paramView.id.get());
        localStringBuilder.append("   createTime:");
        localStringBuilder.append(paramView.createTime.get());
        QLog.d("QCircleTimeLineAndGridScroller", 1, localStringBuilder.toString());
        SimpleEventBus.getInstance().dispatchEvent(new QCircleTimeLineCreateTimeEvent(paramView.createTime.get()));
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof GridLayoutManager))
      {
        paramRecyclerView = (GridLayoutManager)paramRecyclerView;
        if (paramRecyclerView.getSpanCount() == 1)
        {
          c(paramRecyclerView.findViewByPosition(paramRecyclerView.findFirstVisibleItemPosition()));
          return;
        }
      }
    }
    catch (Exception paramRecyclerView)
    {
      QLog.d("QCircleTimeLineAndGridScroller", 1, paramRecyclerView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleTimeLineAndGridScroller
 * JD-Core Version:    0.7.0.1
 */