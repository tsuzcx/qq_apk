package com.tencent.biz.qqcircle.list.bizblocks;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetRecomUserListRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.BaseListVH;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleFollowUserListItemView;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetRecomUserListRsp;

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
  
  public BaseRequest getRequest(String paramString)
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
        return HardCodeUtil.a(2131895737);
      }
      return HardCodeUtil.a(2131895738);
    }
    return HardCodeUtil.a(2131895737);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new BaseListBlock.BaseListVH(new QCircleFollowUserListItemView(getParentFragment().getActivity(), this.mUin, 0));
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    super.onInitBlock(paramBundle);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(28).setThrActionType(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCicleUserHomeFollowUserListBlock
 * JD-Core Version:    0.7.0.1
 */