package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper._Constants;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleBusinessMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleCommentOrReplyMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleDefaultMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleFollowMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleUnsupportedMessageItemView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleMessageNoticeRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.BaseListVH;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReportHelper.LaunchParam;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudRead.StGetNoticeListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StGetNoticeListRspData;

public class QCircleMessageListBlock
  extends QCircleBaseListBlock<FeedCloudMeta.StNotice, FeedCloudRead.StGetNoticeListRsp>
{
  private static final int MESSAGE_TYPE_UNSUPPORTED = SUPPORT_MESSAGE_TYPES.length;
  private static final int[] SUPPORT_MESSAGE_TYPES = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
  private static final String TAG = "QCircleMessageListBlock";
  private View mBottomLine;
  private boolean mFromPush;
  private TextView mTvTitle;
  private TextView mTvUnReadNum;
  
  public QCircleMessageListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getAttachInfoFromItemData(FeedCloudMeta.StNotice paramStNotice)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.feedAttchInfo.get();
  }
  
  public int getContentLayoutId()
  {
    return 2131626876;
  }
  
  public List<Part> getCustomParts()
  {
    ArrayList localArrayList = new ArrayList();
    QCircleLightInteractListPart localQCircleLightInteractListPart = new QCircleLightInteractListPart();
    localQCircleLightInteractListPart.a(getReportBean());
    localArrayList.add(localQCircleLightInteractListPart);
    return localArrayList;
  }
  
  public String getDaTongPageId()
  {
    return "pg_xsj_my_message_page";
  }
  
  public String getDropFrameMonitorTag()
  {
    return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_MESSAGE_NOTICE();
  }
  
  public String getEmptyHint()
  {
    return HardCodeUtil.a(2131895792);
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.isFinish.get() == 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt))
    {
      int i = ((FeedCloudMeta.StNotice)this.mDataList.get(paramInt)).noticeType.get();
      paramInt = i;
      if (i >= 0)
      {
        paramInt = i;
        if (i < MESSAGE_TYPE_UNSUPPORTED) {
          return i;
        }
      }
    }
    else
    {
      paramInt = -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getItemViewType()  return MESSAGE_TYPE_UNSUPPORTED");
    localStringBuilder.append(paramInt);
    QLog.e("QCircleMessageListBlock", 2, localStringBuilder.toString());
    return MESSAGE_TYPE_UNSUPPORTED;
  }
  
  public void getListDataAsync(IDataCallBack<FeedCloudMeta.StNotice> paramIDataCallBack, String paramString) {}
  
  public List<FeedCloudMeta.StNotice> getListDataFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.vecNotice.get();
  }
  
  public String getLogTag()
  {
    return "QCircleMessageListBlock";
  }
  
  public int getPageCount()
  {
    return 0;
  }
  
  public BaseRequest getRequest(String paramString)
  {
    return new QCircleMessageNoticeRequest(paramString, false);
  }
  
  public String getTitle()
  {
    return HardCodeUtil.a(2131895793);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626884, paramViewGroup, false);
    this.mTvTitle = ((TextView)paramViewGroup.findViewById(2131448792));
    this.mBottomLine = paramViewGroup.findViewById(2131449321);
    this.mTvUnReadNum = ((TextView)paramViewGroup.findViewById(2131448696));
    this.mTvTitle.setText(HardCodeUtil.a(2131895793));
    this.mBottomLine.setVisibility(8);
    this.mTvUnReadNum.setVisibility(8);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return SUPPORT_MESSAGE_TYPES.length + 1;
  }
  
  protected void handleResponse(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    super.handleResponse(paramBoolean1, paramBoolean2, paramLong, paramString1, paramString2, paramStGetNoticeListRsp);
    if ((paramBoolean1) && (paramLong == 0L) && (!paramBoolean2) && (paramStGetNoticeListRsp != null) && (paramStGetNoticeListRsp.busiRspData.has()))
    {
      paramString1 = new QQCircleFeedBase.StGetNoticeListRspData();
      try
      {
        paramString1.mergeFrom(paramStGetNoticeListRsp.busiRspData.get().toByteArray());
        if (paramString1.rspTimestamp.has())
        {
          EeveeRedpointUtil.saveNoticeFeedListLastRspTimestamp(paramString1.rspTimestamp.get());
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("QCircleMessageListBlock", 1, "handleResponse parse StGetNoticeListRspData error!", paramString1);
      }
    }
  }
  
  public void initTitleBar(View paramView) {}
  
  public void loadData(LoadInfo paramLoadInfo)
  {
    super.loadData(paramLoadInfo);
    if (paramLoadInfo.c())
    {
      QCircleCommentHelper.a().c();
      QCircleGlobalBroadcastHelper.a().d();
      return;
    }
    if (paramLoadInfo.d())
    {
      QCircleCommentHelper.a().c();
      QCircleGlobalBroadcastHelper.a().d();
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (QCircleReportHelper.getInstance().isPageStackEmpty())
    {
      paramActivity = (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      QCircleReportHelper.getInstance().setLaunchParms(QCircleReportHelper.LaunchParam.wrap(paramActivity.getLaunchFrom(), paramActivity.getLaunchId(), paramActivity.getUin(), 59, paramActivity.getSchemeAttrs()));
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    paramActivity = QCircleReportHelper.getInstance();
    boolean bool;
    if ((getHostFragment() != null) && (getHostFragment().g())) {
      bool = true;
    } else {
      bool = false;
    }
    paramActivity.recordPageEndShow(59, bool);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (257 == paramInt1) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleAtUpdateEvent(getContext(), paramIntent));
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    QCircleReportHelper.getInstance().recordPageStartShow(59);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(17).setSubActionType(1));
  }
  
  public boolean onBackEvent()
  {
    if (this.mFromPush)
    {
      QLog.d("QCircleMessageListBlock", 1, "mFromPush back launchFolderPage");
      if (QCircleReportHelper.getInstance().getPageStackSize() <= 1) {
        QCircleLauncher.a(getContext(), new QCircleFolderBean());
      }
      getActivity().finish();
      return true;
    }
    QLog.d("QCircleMessageListBlock", 1, "not mFromPush back finish");
    return false;
  }
  
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
    QLog.d("QCircleMessageListBlock", 4, localStringBuilder.toString());
  }
  
  public BaseListBlock.BaseListVH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("QCircleMessageListBlock", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new BaseListBlock.BaseListVH(new QCircleUnsupportedMessageItemView(getParentFragment().getActivity()));
    case 15: 
      paramViewGroup = new QCircleBusinessMessageItemView(getParentFragment().getActivity());
      paramViewGroup.setReportBean(getReportBean());
      return new BaseListBlock.BaseListVH(paramViewGroup);
    case 4: 
      paramViewGroup = new QCircleFollowMessageItemView(getParentFragment().getActivity(), paramInt);
      paramViewGroup.setReportBean(getReportBean());
      return new BaseListBlock.BaseListVH(paramViewGroup);
    case 1: 
    case 2: 
      paramViewGroup = new QCircleCommentOrReplyMessageItemView(getParentFragment().getActivity(), paramInt);
      paramViewGroup.setRecyclerView(getParentRecyclerView());
      paramViewGroup.setReportBean(getReportBean());
      return new BaseListBlock.BaseListVH(paramViewGroup);
    }
    paramViewGroup = new QCircleDefaultMessageItemView(getParentFragment().getActivity(), paramInt, getBlockMerger().f());
    paramViewGroup.setReportBean(getReportBean());
    return new BaseListBlock.BaseListVH(paramViewGroup);
  }
  
  public void onDrawItemDecoration(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState) {}
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleMessageListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
    if (paramBundle != null)
    {
      QCircleInitBean localQCircleInitBean = (QCircleInitBean)paramBundle.getSerializable("key_bundle_common_init_bean");
      String str = null;
      if (localQCircleInitBean != null) {
        str = localQCircleInitBean.getLaunchFrom();
      }
      if (!TextUtils.isEmpty(str)) {
        this.mFromPush = str.equals(String.valueOf(7));
      }
      int i = paramBundle.getInt("key_from_page_id", 0);
      setReportBean(new QCircleReportBean().setPageId(59).setFromPageId(i));
    }
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = this.mBottomLine;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      paramView.setVisibility(i);
      Object localObject = this.mTvTitle;
      if (paramBoolean) {
        paramView = Typeface.DEFAULT_BOLD;
      } else {
        paramView = Typeface.DEFAULT;
      }
      ((TextView)localObject).setTypeface(paramView);
      paramView = this.mTvTitle;
      localObject = QCircleSkinHelper.getInstance();
      if (paramBoolean) {
        i = 2131167084;
      } else {
        i = 2131167085;
      }
      paramView.setTextColor(((QCircleSkinHelper)localObject).getColor(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleMessageListBlock
 * JD-Core Version:    0.7.0.1
 */