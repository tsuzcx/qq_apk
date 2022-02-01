package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.views.QFSLayerFeedItemView;
import com.tencent.qphone.base.util.QLog;

class QFSLayerPageAdapter$LayerPagerHolder
  extends RecyclerView.ViewHolder
{
  public QFSLayerPageAdapter$LayerPagerHolder(@NonNull View paramView)
  {
    super(paramView);
  }
  
  public void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (!(this.itemView instanceof QFSLayerFeedItemView))
    {
      QLog.e("QFSLayerPageAdapter", 1, "setData  itemView != FSLayerFeedItemView");
      return;
    }
    ((QFSLayerFeedItemView)this.itemView).setData(paramFeedBlockData, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter.LayerPagerHolder
 * JD-Core Version:    0.7.0.1
 */