package com.tencent.biz.qqcircle.list.bizblocks;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper._Constants;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleGetCircleUnCareListRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.BaseListVH;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBlackListItemView;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleRight.GetCircleUnCareListRsp;

public class QCircleBlackListBlock
  extends QCircleBaseListBlock<FeedCloudMeta.StUser, QQCircleRight.GetCircleUnCareListRsp>
{
  private static final int LOAD_COUNT_PER_PAGE = 20;
  private static final String TAG = "QCircleBlackListBlock";
  
  public QCircleBlackListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected QCircleStatusView createStatusView()
  {
    QCircleFullScreenStatusView localQCircleFullScreenStatusView = new QCircleFullScreenStatusView(getContext());
    localQCircleFullScreenStatusView.setEmptyImageAndText(QCircleSkinHelper.getInstance().getUrl("img_emptystate_relationship"), HardCodeUtil.a(2131895638), QCircleConfigHelper.Q());
    localQCircleFullScreenStatusView.setOnRetryClickListener(new QCircleBlackListBlock.1(this, localQCircleFullScreenStatusView));
    return localQCircleFullScreenStatusView;
  }
  
  public String getAttachInfoFromItemData(FeedCloudMeta.StUser paramStUser)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(QQCircleRight.GetCircleUnCareListRsp paramGetCircleUnCareListRsp)
  {
    return null;
  }
  
  public List<Part> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return QCircleHostDropFrameMonitorHelper._Constants.QCIRLE_BLACK_LIST_PAGE();
  }
  
  public String getEmptyHint()
  {
    return null;
  }
  
  public boolean getIsFinishFromRsp(QQCircleRight.GetCircleUnCareListRsp paramGetCircleUnCareListRsp)
  {
    return true;
  }
  
  public void getListDataAsync(IDataCallBack<FeedCloudMeta.StUser> paramIDataCallBack, String paramString) {}
  
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
  
  public BaseRequest getRequest(String paramString)
  {
    return new QCircleGetCircleUnCareListRequest(1);
  }
  
  public String getTitle()
  {
    return HardCodeUtil.a(2131895639);
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
    QLog.d("QCircleBlackListBlock", 4, localStringBuilder.toString());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new BaseListBlock.BaseListVH(new QCircleBlackListItemView(getParentFragment().getActivity()));
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    super.onInitBlock(paramBundle);
    getBlockMerger().b("");
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(40).setThrActionType(1));
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleBlackListBlock
 * JD-Core Version:    0.7.0.1
 */