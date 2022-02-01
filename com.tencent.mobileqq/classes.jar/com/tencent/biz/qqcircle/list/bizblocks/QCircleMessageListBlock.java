package com.tencent.biz.qqcircle.list.bizblocks;

import aaak;
import aabe;
import aabj;
import aabu;
import aacv;
import aacw;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import anzj;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleCommentOrReplyMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleDefaultMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleFollowMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleUnsupportedMessageItemView;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.requests.QCircleMessageNoticeRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudRead.StGetNoticeListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StGetNoticeListRspData;
import uyx;
import vdj;
import vqm;
import vtd;
import vtq;
import vtt;
import vvz;

public class QCircleMessageListBlock
  extends vqm<FeedCloudMeta.StNotice, FeedCloudRead.StGetNoticeListRsp>
{
  private static final int MESSAGE_TYPE_UNSUPPORTED = SUPPORT_MESSAGE_TYPES.length;
  private static final int[] SUPPORT_MESSAGE_TYPES = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
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
    return 2131560751;
  }
  
  public List<aabe> getCustomParts()
  {
    ArrayList localArrayList = new ArrayList();
    vdj localvdj = new vdj();
    localvdj.a(getReportBean());
    localArrayList.add(localvdj);
    return localArrayList;
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_message_notice_page";
  }
  
  public String getEmptyHint()
  {
    return anzj.a(2131697260);
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.isFinish.get() == 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = -1;
    int i = j;
    if (this.mDataList != null)
    {
      i = j;
      if (this.mDataList.size() > paramInt)
      {
        paramInt = ((FeedCloudMeta.StNotice)this.mDataList.get(paramInt)).noticeType.get();
        i = paramInt;
        if (paramInt >= 0)
        {
          i = paramInt;
          if (paramInt < MESSAGE_TYPE_UNSUPPORTED) {
            return paramInt;
          }
        }
      }
    }
    QLog.e("QCircleMessageListBlock", 2, "getItemViewType()  return MESSAGE_TYPE_UNSUPPORTED" + i);
    return MESSAGE_TYPE_UNSUPPORTED;
  }
  
  public void getListDataAsync(aacw<FeedCloudMeta.StNotice> paramaacw, String paramString) {}
  
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
  
  public String getPageIdStr()
  {
    return "mynotice_page";
  }
  
  public VSBaseRequest getRequest(String paramString)
  {
    return new QCircleMessageNoticeRequest(paramString, false);
  }
  
  public String getTitle()
  {
    return anzj.a(2131697261);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560758, paramViewGroup, false);
    this.mTvTitle = ((TextView)paramViewGroup.findViewById(2131380117));
    this.mBottomLine = paramViewGroup.findViewById(2131380615);
    this.mTvUnReadNum = ((TextView)paramViewGroup.findViewById(2131380040));
    this.mTvTitle.setText(anzj.a(2131697261));
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
    if ((paramBoolean1) && (paramLong == 0L) && (!paramBoolean2) && (paramStGetNoticeListRsp != null) && (paramStGetNoticeListRsp.busiRspData.has())) {
      paramString1 = new QQCircleFeedBase.StGetNoticeListRspData();
    }
    try
    {
      paramString1.mergeFrom(paramStGetNoticeListRsp.busiRspData.get().toByteArray());
      if (paramString1.rspTimestamp.has()) {
        vtd.a(paramString1.rspTimestamp.get());
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("QCircleMessageListBlock", 1, "handleResponse parse StGetNoticeListRspData error!", paramString1);
    }
  }
  
  public void initTitleBar(View paramView) {}
  
  public void loadData(aabu paramaabu)
  {
    super.loadData(paramaabu);
    if (paramaabu.c())
    {
      vvz.a().a();
      QCircleGlobalBroadcastHelper.a().c();
    }
    while (!paramaabu.d()) {
      return;
    }
    vvz.a().a();
    QCircleGlobalBroadcastHelper.a().c();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (vtt.a().d()) {
      vtt.a().a(59, getActivity().getIntent());
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    vtt.a().d(59);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (37858 == paramInt1) {
      aaak.a().a(new QCircleAtUpdateEvent(paramIntent));
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    vtt.a().c(59);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    vtq.a("", 17, 1);
  }
  
  public boolean onBackEvent()
  {
    if (this.mFromPush)
    {
      QLog.d("QCircleMessageListBlock", 1, "mFromPush back launchFolderPage");
      if (vtt.a().b() <= 1) {
        uyx.a(getContext(), new QCircleFolderBean());
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
      ((aacv)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    QLog.d("QCircleMessageListBlock", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public aacv onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("QCircleMessageListBlock", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new aacv(new QCircleUnsupportedMessageItemView(getParentFragment().getActivity()));
    case 0: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      paramViewGroup = new QCircleDefaultMessageItemView(getParentFragment().getActivity(), paramInt, getBlockMerger().a());
      paramViewGroup.setReportBean(getReportBean());
      return new aacv(paramViewGroup);
    case 1: 
    case 2: 
      paramViewGroup = new QCircleCommentOrReplyMessageItemView(getParentFragment().getActivity(), paramInt);
      paramViewGroup.setRecyclerView(getParentRecyclerView());
      paramViewGroup.setReportBean(getReportBean());
      return new aacv(paramViewGroup);
    }
    paramViewGroup = new QCircleFollowMessageItemView(getParentFragment().getActivity(), paramInt);
    paramViewGroup.setReportBean(getReportBean());
    return new aacv(paramViewGroup);
  }
  
  public void onDrawItemDecoration(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState) {}
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleMessageListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = (QCircleInitBean)paramBundle.getSerializable("key_bundle_common_init_bean");
      if (paramBundle == null) {
        break label82;
      }
    }
    label82:
    for (paramBundle = paramBundle.getLaunchFrom();; paramBundle = null)
    {
      if (!TextUtils.isEmpty(paramBundle)) {
        this.mFromPush = paramBundle.equals(String.valueOf(7));
      }
      setReportBean(new QCircleReportBean().setPageId(59).setPageIdStr(getPageIdStr()));
      return;
    }
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = this.mBottomLine;
      if (!paramBoolean) {
        break label77;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      TextView localTextView = this.mTvTitle;
      if (!paramBoolean) {
        break label83;
      }
      localObject = Typeface.DEFAULT_BOLD;
      label37:
      localTextView.setTypeface((Typeface)localObject);
      localObject = this.mTvTitle;
      paramView = paramView.getContext().getResources();
      if (!paramBoolean) {
        break label91;
      }
    }
    label77:
    label83:
    label91:
    for (int i = 2131165343;; i = 2131166241)
    {
      ((TextView)localObject).setTextColor(paramView.getColor(i));
      return;
      i = 8;
      break;
      localObject = Typeface.DEFAULT;
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleMessageListBlock
 * JD-Core Version:    0.7.0.1
 */