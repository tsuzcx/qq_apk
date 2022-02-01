package com.tencent.biz.qqcircle.list.bizblocks;

import aabe;
import aabj;
import aacv;
import aacw;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import anzj;
import com.tencent.biz.qqcircle.requests.QCircleGetCircleUnCareListRequest;
import com.tencent.biz.qqcircle.widgets.QCircleBlackListItemView;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleRight.GetCircleUnCareListRsp;
import vqm;
import vtq;

public class QCircleBlackListBlock
  extends vqm<FeedCloudMeta.StUser, QQCircleRight.GetCircleUnCareListRsp>
{
  private static final int LOAD_COUNT_PER_PAGE = 20;
  private static final String TAG = "QCircleBlackListBlock";
  
  public QCircleBlackListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getAttachInfoFromItemData(FeedCloudMeta.StUser paramStUser)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(QQCircleRight.GetCircleUnCareListRsp paramGetCircleUnCareListRsp)
  {
    return null;
  }
  
  public List<aabe> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_black_list";
  }
  
  public String getEmptyHint()
  {
    return null;
  }
  
  public boolean getIsFinishFromRsp(QQCircleRight.GetCircleUnCareListRsp paramGetCircleUnCareListRsp)
  {
    return true;
  }
  
  public void getListDataAsync(aacw<FeedCloudMeta.StUser> paramaacw, String paramString) {}
  
  public List<FeedCloudMeta.StUser> getListDataFromRsp(QQCircleRight.GetCircleUnCareListRsp paramGetCircleUnCareListRsp)
  {
    return paramGetCircleUnCareListRsp.userlist.get();
  }
  
  public String getLogTag()
  {
    return "QCircleBlackListBlock";
  }
  
  public int getPageCount()
  {
    return 20;
  }
  
  public String getPageIdStr()
  {
    return null;
  }
  
  public VSBaseRequest getRequest(String paramString)
  {
    return new QCircleGetCircleUnCareListRequest(1);
  }
  
  public String getTitle()
  {
    return anzj.a(2131697179);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void initTitleBar(View paramView) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null) {
      ((aacv)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    QLog.d("QCircleBlackListBlock", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new aacv(new QCircleBlackListItemView(getParentFragment().getActivity()));
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    super.onInitBlock(paramBundle);
    getBlockMerger().a("");
    vtq.a("", 11, 40, 1);
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleBlackListBlock
 * JD-Core Version:    0.7.0.1
 */