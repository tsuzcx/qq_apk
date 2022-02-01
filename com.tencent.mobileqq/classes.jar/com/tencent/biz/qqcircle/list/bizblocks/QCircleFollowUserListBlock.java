package com.tencent.biz.qqcircle.list.bizblocks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import anni;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetRecomUserListRequest;
import com.tencent.biz.qqcircle.widgets.QCircleFollowUserListItemView;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StUserRecomInfo;
import feedcloud.FeedCloudRead.StGetRecomUserListRsp;
import java.util.ArrayList;
import java.util.List;
import voe;
import vrf;
import zxj;
import zyz;
import zza;

public class QCircleFollowUserListBlock
  extends voe<FeedCloudMeta.StUserRecomInfo, FeedCloudRead.StGetRecomUserListRsp>
{
  private static final int LOAD_COUNT_PER_PAGE = 20;
  private static final String TAG = "QCircleFollowUserListBlock";
  protected String mUin;
  protected FeedCloudMeta.StUser mUser;
  
  public QCircleFollowUserListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getAttachInfoFromItemData(FeedCloudMeta.StUserRecomInfo paramStUserRecomInfo)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(FeedCloudRead.StGetRecomUserListRsp paramStGetRecomUserListRsp)
  {
    return paramStGetRecomUserListRsp.attachInfo.get();
  }
  
  public List<zxj> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_follow_user_list";
  }
  
  public String getEmptyHint()
  {
    return null;
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetRecomUserListRsp paramStGetRecomUserListRsp)
  {
    return paramStGetRecomUserListRsp.isFinish.get() == 1;
  }
  
  public void getListDataAsync(zza<FeedCloudMeta.StUserRecomInfo> paramzza, String paramString) {}
  
  public List<FeedCloudMeta.StUserRecomInfo> getListDataFromRsp(FeedCloudRead.StGetRecomUserListRsp paramStGetRecomUserListRsp)
  {
    return paramStGetRecomUserListRsp.userRecoms.get();
  }
  
  public String getLogTag()
  {
    return "QCircleFollowUserListBlock";
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
    return new QCircleGetRecomUserListRequest(paramString, 3, this.mUin);
  }
  
  public String getTitle()
  {
    return anni.a(2131697167);
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
      ((zyz)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    QLog.d("QCircleFollowUserListBlock", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new zyz(new QCircleFollowUserListItemView(getParentFragment().getActivity(), this.mUin, 1));
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    super.onInitBlock(paramBundle);
    if ((this.mInitBean instanceof QCircleInitBean))
    {
      paramBundle = (QCircleInitBean)this.mInitBean;
      if ((paramBundle.getUser() != null) && (!TextUtils.isEmpty(paramBundle.getUser().id.get())))
      {
        this.mUser = paramBundle.getUser();
        this.mUin = paramBundle.getUser().id.get();
      }
    }
    vrf.a("", 11, 30, 1);
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock
 * JD-Core Version:    0.7.0.1
 */