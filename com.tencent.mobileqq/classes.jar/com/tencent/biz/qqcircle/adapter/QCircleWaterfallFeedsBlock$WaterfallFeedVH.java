package com.tencent.biz.qqcircle.adapter;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;

public class QCircleWaterfallFeedsBlock$WaterfallFeedVH
  extends RecyclerView.ViewHolder
{
  public QCircleWaterfallFeedsBlock$WaterfallFeedVH(QCircleWaterfallFeedsBlock paramQCircleWaterfallFeedsBlock, View paramView)
  {
    super(paramView);
  }
  
  private boolean a(FeedBlockData paramFeedBlockData)
  {
    boolean bool3 = this.itemView instanceof BaseWidgetView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if ((((BaseWidgetView)this.itemView).getData() instanceof FeedBlockData))
      {
        FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)((BaseWidgetView)this.itemView).getData()).b();
        bool1 = bool2;
        if (localStFeed != null)
        {
          bool1 = bool2;
          if (paramFeedBlockData.b() != null)
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(localStFeed.id.get()))
            {
              bool1 = bool2;
              if (localStFeed.id.get().equals(paramFeedBlockData.b().id.get()))
              {
                bool1 = bool2;
                if (localStFeed.likeInfo.count.get() == paramFeedBlockData.b().likeInfo.count.get()) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void a(FeedBlockData paramFeedBlockData, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, int paramInt)
  {
    if (a(paramFeedBlockData)) {
      return;
    }
    if (!(this.itemView instanceof QCircleWaterfallFeedItemView))
    {
      QLog.i("QCircleWaterfallFeedsBlock", 1, "itemView != QCircleWaterfallFeedItemView");
      return;
    }
    ((QCircleWaterfallFeedItemView)this.itemView).setExtraTypeInfo(paramQCircleExtraTypeInfo);
    ((QCircleWaterfallFeedItemView)this.itemView).setData(paramFeedBlockData, paramInt);
    ((QCircleWaterfallFeedItemView)this.itemView).setDataPosInList(paramInt);
    ((QCircleWaterfallFeedItemView)this.itemView).setExtraTypeInfo(this.a.a);
    ((QCircleWaterfallFeedItemView)this.itemView).setInteractor(this.a.getInteractor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock.WaterfallFeedVH
 * JD-Core Version:    0.7.0.1
 */