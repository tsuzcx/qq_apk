package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class RelativePersonalDetailHeadItemView$FansGroupAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<CertifiedAccountMeta.StQQGroup> jdField_a_of_type_JavaUtilList;
  
  public RelativePersonalDetailHeadItemView$FansGroupAdapter(List<CertifiedAccountMeta.StQQGroup> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > paramInt))
    {
      localObject = (RelativePersonalDetailHeadItemView.FansGroupHolder)paramViewHolder;
      if (localObject != null) {
        ((RelativePersonalDetailHeadItemView.FansGroupHolder)localObject).a((CertifiedAccountMeta.StQQGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558753, paramViewGroup, false);
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() == 1)) {
      paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
    return new RelativePersonalDetailHeadItemView.FansGroupHolder(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView.FansGroupAdapter
 * JD-Core Version:    0.7.0.1
 */