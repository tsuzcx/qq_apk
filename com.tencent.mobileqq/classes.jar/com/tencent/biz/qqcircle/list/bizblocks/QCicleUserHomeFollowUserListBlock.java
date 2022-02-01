package com.tencent.biz.qqcircle.list.bizblocks;

import aacv;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import anzj;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetRecomUserListRequest;
import com.tencent.biz.qqcircle.widgets.QCircleFollowUserListItemView;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetRecomUserListRsp;
import vtq;

public class QCicleUserHomeFollowUserListBlock
  extends QCircleFollowUserListBlock
{
  public QCicleUserHomeFollowUserListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getAttachInfoFromRsp(FeedCloudRead.StGetRecomUserListRsp paramStGetRecomUserListRsp)
  {
    return null;
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetRecomUserListRsp paramStGetRecomUserListRsp)
  {
    return true;
  }
  
  public VSBaseRequest getRequest(String paramString)
  {
    return new QCircleGetRecomUserListRequest(paramString, 2, this.mUin);
  }
  
  public String getTitle()
  {
    if ((this.mUser == null) && (this.mInitBean != null) && ((this.mInitBean instanceof QCircleInitBean))) {
      this.mUser = ((QCircleInitBean)this.mInitBean).getUser();
    }
    if (this.mUser != null)
    {
      if (this.mUser.sex.get() == 1) {
        return anzj.a(2131697231);
      }
      return anzj.a(2131697232);
    }
    return anzj.a(2131697231);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new aacv(new QCircleFollowUserListItemView(getParentFragment().getActivity(), this.mUin, 0));
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    super.onInitBlock(paramBundle);
    vtq.a("", 11, 28, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCicleUserHomeFollowUserListBlock
 * JD-Core Version:    0.7.0.1
 */