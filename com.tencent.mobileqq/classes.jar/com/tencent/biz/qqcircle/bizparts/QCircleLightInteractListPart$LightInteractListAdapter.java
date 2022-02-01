package com.tencent.biz.qqcircle.bizparts;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractDividerWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.LightInteractionBusiData;

class QCircleLightInteractListPart$LightInteractListAdapter
  extends QCircleBaseMultiViewBlock<FeedCloudMeta.StLightInteractInfo>
{
  private FeedCloudMeta.StFeed b;
  private int c;
  private RecyclerView d;
  
  public QCircleLightInteractListPart$LightInteractListAdapter(QCircleLightInteractListPart paramQCircleLightInteractListPart, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    RecyclerView localRecyclerView = this.d;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.d.post(new QCircleLightInteractListPart.LightInteractListAdapter.1(this));
        return;
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.d = paramRecyclerView;
  }
  
  public void a(List<FeedCloudMeta.StLightInteractInfo> paramList)
  {
    this.mDataList.addAll(this.mDataList.size(), paramList);
    a();
  }
  
  public void a(List<FeedCloudMeta.StLightInteractInfo> paramList, FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.b = paramStFeed;
    this.c = paramInt;
    if (paramList != null)
    {
      this.mDataList.clear();
      a();
      this.mDataList.addAll(paramList);
      a();
    }
  }
  
  public void clearData()
  {
    this.mDataList.clear();
    a();
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    FeedCloudMeta.StLightInteractInfo localStLightInteractInfo = (FeedCloudMeta.StLightInteractInfo)this.mDataList.get(paramInt);
    QQCircleFeedBase.LightInteractionBusiData localLightInteractionBusiData = new QQCircleFeedBase.LightInteractionBusiData();
    try
    {
      localLightInteractionBusiData.mergeFrom(localStLightInteractInfo.busiData.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    if (!TextUtils.isEmpty(localLightInteractionBusiData.splitItemText.get())) {
      return -1;
    }
    return QCircleLightInteractListPart.e(this.a);
  }
  
  protected String getLogTag()
  {
    return "LightInteractListAdapter";
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList.size() > paramInt) && ((paramViewHolder instanceof QCircleLightInteractListPart.QCircleLightInteractVH))) {
      ((QCircleLightInteractListPart.QCircleLightInteractVH)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.c, this.b, QCircleLightInteractListPart.d(this.a));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 4))
    {
      if (paramInt == -1)
      {
        paramViewGroup = new QCircleLightInteractDividerWidget(getContext(), paramInt);
        paramViewGroup.setReportBeanAgent(this.a);
        return new QCircleLightInteractListPart.QCircleLightInteractVH(this.a, paramViewGroup);
      }
      paramViewGroup = new QCircleLightInteractPushWidget(getContext(), paramInt);
      paramViewGroup.setReportBeanAgent(this.a);
      return new QCircleLightInteractListPart.QCircleLightInteractVH(this.a, paramViewGroup);
    }
    paramViewGroup = new QCircleLightInteractPolyLikeWidget(getContext(), paramInt);
    paramViewGroup.setReportBeanAgent(this.a);
    return new QCircleLightInteractListPart.QCircleLightInteractVH(this.a, paramViewGroup);
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.LightInteractListAdapter
 * JD-Core Version:    0.7.0.1
 */