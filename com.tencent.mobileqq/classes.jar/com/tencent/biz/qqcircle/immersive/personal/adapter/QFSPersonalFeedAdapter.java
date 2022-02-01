package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalFeedItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalJustSeeFeedItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemView;
import com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class QFSPersonalFeedAdapter
  extends QCircleBaseMultiViewBlock<QFSPersonalFeedInfo>
{
  private String a = "";
  private QFSPersonalFeedAdapter.OnItemClickListener b;
  
  public QFSPersonalFeedAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a(View paramView, QFSPersonalFeedInfo paramQFSPersonalFeedInfo)
  {
    switch (paramQFSPersonalFeedInfo.h())
    {
    default: 
      return;
    case 100103: 
      a(paramView, paramQFSPersonalFeedInfo.b(), paramQFSPersonalFeedInfo.f());
      return;
    case 100102: 
      b(paramView, paramQFSPersonalFeedInfo.b());
      return;
    }
    a(paramView, paramQFSPersonalFeedInfo.b());
  }
  
  private void a(View paramView, String paramString)
  {
    VideoReport.setElementId(paramView, "em_xsj_product");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.put("xsj_product_look_finished", "no");
    localMap.put("xsj_feed_id", paramString);
    VideoReport.setElementParams(paramView, localMap);
    VideoReport.setElementReuseIdentifier(paramView, paramString);
  }
  
  private void a(View paramView, String paramString, int paramInt)
  {
    VideoReport.setElementId(paramView, "em_xsj_drafts");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.put("xsj_drafts_feeds_num", Integer.valueOf(paramInt));
    localMap.put("xsj_feed_id", paramString);
    VideoReport.setElementParams(paramView, localMap);
    VideoReport.setElementReuseIdentifier(paramView, paramString);
  }
  
  private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool3 = paramRecyclerView.getLayoutManager() instanceof GridLayoutManager;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramInt1 % paramInt2 == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(View paramView, String paramString)
  {
    VideoReport.setElementId(paramView, "em_xsj_product");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.put("xsj_product_look_finished", "yes");
    localMap.put("xsj_feed_id", paramString);
    VideoReport.setElementParams(paramView, localMap);
    VideoReport.setElementReuseIdentifier(paramView, paramString);
  }
  
  private boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.getLayoutManager() instanceof GridLayoutManager)) {
      return (paramInt1 + 1) % paramInt2 == 0;
    }
    return false;
  }
  
  public void a()
  {
    if ((this.mDataList.size() > 0) && (((QFSPersonalFeedInfo)this.mDataList.get(0)).h() == 100103)) {
      this.mDataList.remove(0);
    }
    notifyDataSetChanged();
  }
  
  public void a(QFSPersonalFeedAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.b = paramOnItemClickListener;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(ArrayList<QFSPersonalFeedInfo> paramArrayList)
  {
    if ((this.mDataList.size() > 0) && (this.mDataList.get(0) != null) && (((QFSPersonalFeedInfo)this.mDataList.get(0)).h() == 100103))
    {
      this.mDataList.set(0, paramArrayList.get(0));
      return;
    }
    this.mDataList.add(0, paramArrayList.get(0));
  }
  
  public void b(ArrayList<QFSPersonalFeedInfo> paramArrayList)
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      if (((QFSPersonalFeedInfo)localIterator.next()).h() != 100103) {
        localIterator.remove();
      }
    }
    if (paramArrayList != null) {
      this.mDataList.addAll(paramArrayList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (paramRecyclerView != null)
    {
      if (paramRecyclerView.getAdapter() == null) {
        return;
      }
      int i = paramRecyclerView.getChildLayoutPosition(paramView);
      boolean bool1 = a(paramRecyclerView, i, 3);
      boolean bool2 = b(paramRecyclerView, i, 3);
      int k = ViewUtils.dip2px(0.5F);
      if (bool1) {
        i = 0;
      } else if (bool2) {
        i = k * 2;
      } else {
        i = k;
      }
      int j;
      if (bool2) {
        j = 0;
      } else if (bool1) {
        j = k * 2;
      } else {
        j = k;
      }
      paramRect.set(i, 0, j, k * 3);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    QFSPersonalFeedInfo localQFSPersonalFeedInfo = (QFSPersonalFeedInfo)this.mDataList.get(paramInt);
    if ((localQFSPersonalFeedInfo.h() == 100101) && (!QFSCommonUtil.a(localQFSPersonalFeedInfo.e())) && (localQFSPersonalFeedInfo.g() == 20101) && (TextUtils.equals(localQFSPersonalFeedInfo.b(), this.a))) {
      return 100102;
    }
    return localQFSPersonalFeedInfo.h();
  }
  
  protected String getLogTag()
  {
    return "FSPersonalFeedAdapter";
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QFSPersonalFeedInfo localQFSPersonalFeedInfo = (QFSPersonalFeedInfo)this.mDataList.get(paramInt);
    QFSPersonalFeedAdapter.FeedViewHolder localFeedViewHolder = (QFSPersonalFeedAdapter.FeedViewHolder)paramViewHolder;
    localFeedViewHolder.a.setData(localQFSPersonalFeedInfo, paramInt);
    localFeedViewHolder.a.setOnClickListener(new QFSPersonalFeedAdapter.1(this, paramInt, localQFSPersonalFeedInfo));
    a(paramViewHolder.itemView, localQFSPersonalFeedInfo);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100103: 
      return new QFSPersonalFeedAdapter.FeedViewHolder(new QFSPersonalOutBoxFeedItemView(paramViewGroup.getContext()));
    case 100102: 
      return new QFSPersonalFeedAdapter.FeedViewHolder(new QFSPersonalJustSeeFeedItemView(paramViewGroup.getContext()));
    }
    return new QFSPersonalFeedAdapter.FeedViewHolder(new QFSPersonalFeedItemView(paramViewGroup.getContext()));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter
 * JD-Core Version:    0.7.0.1
 */