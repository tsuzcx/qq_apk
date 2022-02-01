package com.tencent.biz.qqcircle.list.bizblocks;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper._Constants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleGetRecomUserListRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.BaseListVH;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleFollowUserListItemView;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StUserRecomInfo;
import feedcloud.FeedCloudRead.StGetRecomUserListRsp;
import java.util.ArrayList;
import java.util.List;

public class QCircleFollowUserListBlock
  extends QCircleBaseListBlock<FeedCloudMeta.StUserRecomInfo, FeedCloudRead.StGetRecomUserListRsp>
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
  
  public List<Part> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_FOLLOW_USER_LIST();
  }
  
  public String getEmptyHint()
  {
    return null;
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetRecomUserListRsp paramStGetRecomUserListRsp)
  {
    return paramStGetRecomUserListRsp.isFinish.get() == 1;
  }
  
  public void getListDataAsync(IDataCallBack<FeedCloudMeta.StUserRecomInfo> paramIDataCallBack, String paramString) {}
  
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
  
  public BaseRequest getRequest(String paramString)
  {
    return new QCircleGetRecomUserListRequest(paramString, 3, this.mUin);
  }
  
  public String getTitle()
  {
    return HardCodeUtil.a(2131895736);
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
      ((BaseListBlock.BaseListVH)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBindViewHolder:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramViewHolder);
    localStringBuilder.append("  ");
    localStringBuilder.append(this);
    QLog.d("QCircleFollowUserListBlock", 4, localStringBuilder.toString());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new BaseListBlock.BaseListVH(new QCircleFollowUserListItemView(getParentFragment().getActivity(), this.mUin, 1));
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
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(30).setThrActionType(1));
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock
 * JD-Core Version:    0.7.0.1
 */