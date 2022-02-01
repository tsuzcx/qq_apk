package com.tencent.biz.qqcircle.widgets.feed;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleTimeLineFeedItemView$1
  extends GridLayoutManager.SpanSizeLookup
{
  QCircleTimeLineFeedItemView$1(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView) {}
  
  public int getSpanSize(int paramInt)
  {
    if (((this.this$0.getData() instanceof FeedBlockData)) && (((FeedBlockData)this.this$0.getData()).b().type.get() == 2) && (((FeedBlockData)this.this$0.getData()).b().images.size() > 1)) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView.1
 * JD-Core Version:    0.7.0.1
 */