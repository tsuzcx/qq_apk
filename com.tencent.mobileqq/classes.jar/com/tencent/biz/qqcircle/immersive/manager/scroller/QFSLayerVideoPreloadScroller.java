package com.tencent.biz.qqcircle.immersive.manager.scroller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.helpers.QCircleVideoPreloadHelper;
import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import java.util.ArrayList;

public class QFSLayerVideoPreloadScroller
  extends QFSLayerBaseScroller
{
  private final QFSLayerPageAdapter b;
  private int c = -1;
  private int d = -1;
  private QCircleVideoPreloadHelper e;
  
  public QFSLayerVideoPreloadScroller(QFSLayerPageAdapter paramQFSLayerPageAdapter)
  {
    this.b = paramQFSLayerPageAdapter;
  }
  
  private void a(int paramInt)
  {
    int i = paramInt + 5;
    if (i >= this.b.getDataList().size()) {
      i = this.b.getDataList().size();
    }
    for (;;)
    {
      paramInt += 1;
      if (paramInt >= i) {
        break;
      }
      b().a(((FeedBlockData)this.b.getDataList().get(paramInt)).b());
      this.c = paramInt;
    }
  }
  
  private QCircleVideoPreloadHelper b()
  {
    if (this.e == null) {
      this.e = new QCircleVideoPreloadHelper(this.d);
    }
    return this.e;
  }
  
  private boolean d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    return this.c - 5 <= paramQFSFeedSelectInfo.b();
  }
  
  public void a(QFSFeedSelectInfo paramQFSFeedSelectInfo, RecyclerView.ViewHolder paramViewHolder)
  {
    super.a(paramQFSFeedSelectInfo, paramViewHolder);
    if (d(paramQFSFeedSelectInfo))
    {
      this.d = paramViewHolder.itemView.getContext().hashCode();
      a(paramQFSFeedSelectInfo.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.manager.scroller.QFSLayerVideoPreloadScroller
 * JD-Core Version:    0.7.0.1
 */