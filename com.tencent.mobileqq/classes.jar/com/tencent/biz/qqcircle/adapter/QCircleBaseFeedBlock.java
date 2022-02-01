package com.tencent.biz.qqcircle.adapter;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedBaseScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedScrollManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;

public abstract class QCircleBaseFeedBlock
  extends QCircleBaseMultiViewBlock<FeedBlockData>
{
  protected QCircleExtraTypeInfo a;
  protected QCircleFeedScrollManager b;
  protected QCircleFeedReportScroller c;
  protected int d = 0;
  
  public QCircleBaseFeedBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected void a()
  {
    QCircleFeedScrollManager localQCircleFeedScrollManager = this.b;
    if (localQCircleFeedScrollManager != null) {
      localQCircleFeedScrollManager.f();
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    QCircleFeedScrollManager localQCircleFeedScrollManager = this.b;
    if (localQCircleFeedScrollManager != null) {
      localQCircleFeedScrollManager.b(paramInt);
    }
  }
  
  protected void a(RecyclerView paramRecyclerView)
  {
    this.b = new QCircleFeedScrollManager(getContext(), paramRecyclerView, this);
    this.b.a(new QCircleFeedPicPreloadScroller());
    Object localObject = b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QCircleFeedBaseScroller localQCircleFeedBaseScroller = (QCircleFeedBaseScroller)((Iterator)localObject).next();
        this.b.a(localQCircleFeedBaseScroller);
      }
    }
    this.c = new QCircleFeedReportScroller(getPageId(), getReportBean());
    this.b.a(this.c);
    this.b.a(this.a);
    this.b.b(this.d);
    addOnScrollListener(this.b);
    this.b.a(paramRecyclerView);
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.a = paramQCircleExtraTypeInfo;
    paramQCircleExtraTypeInfo = this.b;
    if (paramQCircleExtraTypeInfo != null) {
      paramQCircleExtraTypeInfo.a(this.a);
    }
  }
  
  protected List<QCircleFeedBaseScroller> b()
  {
    return null;
  }
  
  public void b(int paramInt)
  {
    QCircleFeedScrollManager localQCircleFeedScrollManager = this.b;
    if (localQCircleFeedScrollManager != null) {
      localQCircleFeedScrollManager.a(paramInt);
    }
  }
  
  public void c()
  {
    QCircleFeedScrollManager localQCircleFeedScrollManager = this.b;
    if (localQCircleFeedScrollManager != null) {
      localQCircleFeedScrollManager.a();
    }
  }
  
  public List<FeedCloudMeta.StFeed> d()
  {
    return null;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.e();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.d();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.c();
    }
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    a(paramRecyclerView);
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.b;
    if (paramRecyclerView != null)
    {
      removeOnScrollListener(paramRecyclerView);
      this.b.e();
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    Object localObject = this.b;
    if (localObject != null) {
      ((QCircleFeedScrollManager)localObject).a(paramViewHolder);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onViewAttachedToWindow:");
    ((StringBuilder)localObject).append(paramViewHolder.getAdapterPosition());
    ((StringBuilder)localObject).append("  ");
    ((StringBuilder)localObject).append(paramViewHolder);
    ((StringBuilder)localObject).append("  ");
    ((StringBuilder)localObject).append(this);
    QLog.d("QCircleBaseFeedBlock", 4, ((StringBuilder)localObject).toString());
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    Object localObject = this.b;
    if (localObject != null) {
      ((QCircleFeedScrollManager)localObject).b(paramViewHolder);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onViewDetachedFromWindow:");
    ((StringBuilder)localObject).append(paramViewHolder.getAdapterPosition());
    ((StringBuilder)localObject).append("  ");
    ((StringBuilder)localObject).append(paramViewHolder);
    ((StringBuilder)localObject).append("  ");
    ((StringBuilder)localObject).append(this);
    QLog.d("QCircleBaseFeedBlock", 4, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock
 * JD-Core Version:    0.7.0.1
 */