package com.tencent.biz.qqcircle.immersive.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.manager.IQFSLayerScrollerStatus;
import com.tencent.biz.qqcircle.immersive.manager.QFSLayerScrollStatusManager;
import com.tencent.biz.qqcircle.immersive.manager.scroller.QFSLayerPlayerScroller;
import com.tencent.biz.qqcircle.immersive.manager.scroller.QFSLayerReporterScroller;
import com.tencent.biz.qqcircle.immersive.manager.scroller.QFSLayerVideoPreloadScroller;
import com.tencent.biz.qqcircle.immersive.views.QFSLayerFeedItemView;
import com.tencent.biz.qqcircle.richframework.part.utils.ArrayUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;

public class QFSLayerPageAdapter
  extends QFSBaseListViewAdapter<FeedBlockData>
  implements IQFSLayerScrollerStatus
{
  private QFSLayerScrollStatusManager b;
  private QFSLayerPlayerScroller c;
  private QFSLayerReporterScroller d;
  private IQFSFeedIoc e;
  
  private void d()
  {
    this.c = new QFSLayerPlayerScroller();
    this.d = new QFSLayerReporterScroller();
    this.b = new QFSLayerScrollStatusManager();
    this.b.a(this.c);
    this.b.a(this.d);
    this.b.a(new QFSLayerVideoPreloadScroller(this));
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    QFSLayerScrollStatusManager localQFSLayerScrollStatusManager = this.b;
    if (localQFSLayerScrollStatusManager == null) {
      return;
    }
    localQFSLayerScrollStatusManager.a(paramInt1, paramFloat, paramInt2);
  }
  
  public void a(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    QFSLayerScrollStatusManager localQFSLayerScrollStatusManager = this.b;
    if (localQFSLayerScrollStatusManager == null) {
      return;
    }
    localQFSLayerScrollStatusManager.a(paramQFSFeedSelectInfo);
  }
  
  public void a(IQFSFeedIoc paramIQFSFeedIoc)
  {
    this.e = paramIQFSFeedIoc;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((FeedBlockData)localIterator.next()).b().id.get())) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    QFSLayerScrollStatusManager localQFSLayerScrollStatusManager = this.b;
    if (localQFSLayerScrollStatusManager == null) {
      return;
    }
    localQFSLayerScrollStatusManager.a();
  }
  
  public void b(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    QFSLayerScrollStatusManager localQFSLayerScrollStatusManager = this.b;
    if (localQFSLayerScrollStatusManager == null) {
      return;
    }
    localQFSLayerScrollStatusManager.b(paramQFSFeedSelectInfo);
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = getDataList().iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      i += 1;
      if (TextUtils.equals(paramString, ((FeedBlockData)localIterator.next()).b().id.get()))
      {
        localIterator.remove();
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, getItemCount() - i);
        return true;
      }
    }
    return false;
  }
  
  public void c(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    QFSLayerScrollStatusManager localQFSLayerScrollStatusManager = this.b;
    if (localQFSLayerScrollStatusManager == null) {
      return;
    }
    localQFSLayerScrollStatusManager.c(paramQFSFeedSelectInfo);
  }
  
  public boolean c()
  {
    return getItemCount() == 0;
  }
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((FeedBlockData)localIterator.next()).b().poster.id.get())) {
        return true;
      }
    }
    return false;
  }
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    QFSLayerScrollStatusManager localQFSLayerScrollStatusManager = this.b;
    if (localQFSLayerScrollStatusManager == null) {
      return;
    }
    localQFSLayerScrollStatusManager.d(paramQFSFeedSelectInfo);
  }
  
  public boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((FeedBlockData)localIterator.next()).b().poster.id.get())) {
        localIterator.remove();
      }
    }
    notifyDataSetChanged();
    return true;
  }
  
  public void e(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    QFSLayerScrollStatusManager localQFSLayerScrollStatusManager = this.b;
    if (localQFSLayerScrollStatusManager == null) {
      return;
    }
    localQFSLayerScrollStatusManager.e(paramQFSFeedSelectInfo);
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    d();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (ArrayUtils.a(paramInt, getDataList())) {
      return;
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((QFSLayerScrollStatusManager)localObject).a(paramViewHolder);
    }
    localObject = (FeedBlockData)getDataList().get(paramInt);
    ((QFSLayerPageAdapter.LayerPagerHolder)paramViewHolder).a((FeedBlockData)localObject, paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QFSLayerFeedItemView(paramViewGroup.getContext());
    paramViewGroup.setFeedIoc(this.e);
    paramViewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramViewGroup.setReportBean(a());
    return new QFSLayerPageAdapter.LayerPagerHolder(paramViewGroup);
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.b;
    if (paramRecyclerView != null) {
      paramRecyclerView.a();
    }
  }
  
  public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    Object localObject = this.b;
    if (localObject != null) {
      ((QFSLayerScrollStatusManager)localObject).a(paramViewHolder);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QFSLayerPageAdapter onViewAttachedToWindow  holder = ");
    ((StringBuilder)localObject).append(paramViewHolder);
    QLog.d("QFSLayerPageAdapter", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QFSLayerPageAdapter onViewDetachedFromWindow  holder = ");
    localStringBuilder.append(paramViewHolder);
    QLog.d("QFSLayerPageAdapter", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter
 * JD-Core Version:    0.7.0.1
 */