package com.tencent.biz.qqcircle.list.bizblocks;

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
import anni;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleCommentOrReplyMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleDefaultMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleFollowMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleUnsupportedMessageItemView;
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
import uxo;
import vbt;
import voe;
import vqs;
import vrf;
import vri;
import vtd;
import zwp;
import zxj;
import zxo;
import zxz;
import zyz;
import zza;

public class QCircleMessageListBlock
  extends voe<FeedCloudMeta.StNotice, FeedCloudRead.StGetNoticeListRsp>
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
    return 2131560730;
  }
  
  public List<zxj> getCustomParts()
  {
    ArrayList localArrayList = new ArrayList();
    vbt localvbt = new vbt();
    localvbt.a(getReportBean());
    localArrayList.add(localvbt);
    return localArrayList;
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_message_notice_page";
  }
  
  public String getEmptyHint()
  {
    return anni.a(2131697192);
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
  
  public void getListDataAsync(zza<FeedCloudMeta.StNotice> paramzza, String paramString) {}
  
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
    return anni.a(2131697193);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560737, paramViewGroup, false);
    this.mTvTitle = ((TextView)paramViewGroup.findViewById(2131379933));
    this.mBottomLine = paramViewGroup.findViewById(2131380429);
    this.mTvUnReadNum = ((TextView)paramViewGroup.findViewById(2131379860));
    this.mTvTitle.setText(anni.a(2131697193));
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
        vqs.a(paramString1.rspTimestamp.get());
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("QCircleMessageListBlock", 1, "handleResponse parse StGetNoticeListRspData error!", paramString1);
    }
  }
  
  public void initTitleBar(View paramView) {}
  
  public void loadData(zxz paramzxz)
  {
    super.loadData(paramzxz);
    if (paramzxz.c())
    {
      vtd.a().a();
      QCircleGlobalBroadcastHelper.a().c();
    }
    while (!paramzxz.d()) {
      return;
    }
    vtd.a().a();
    QCircleGlobalBroadcastHelper.a().c();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (vri.a().d()) {
      vri.a().a(59, getActivity().getIntent());
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    vri.a().d(59);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (37858 == paramInt1) {
      zwp.a().a(new QCircleAtUpdateEvent(paramIntent));
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    vri.a().c(59);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    vrf.a("", 17, 1);
  }
  
  public boolean onBackEvent()
  {
    if (this.mFromPush)
    {
      QLog.d("QCircleMessageListBlock", 1, "mFromPush back launchFolderPage");
      if (vri.a().b() <= 1) {
        uxo.a(getContext(), null);
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
      ((zyz)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    QLog.d("QCircleMessageListBlock", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public zyz onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("QCircleMessageListBlock", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new zyz(new QCircleUnsupportedMessageItemView(getParentFragment().getActivity()));
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
      return new zyz(paramViewGroup);
    case 1: 
    case 2: 
      paramViewGroup = new QCircleCommentOrReplyMessageItemView(getParentFragment().getActivity(), paramInt);
      paramViewGroup.setRecyclerView(getParentRecyclerView());
      paramViewGroup.setReportBean(getReportBean());
      return new zyz(paramViewGroup);
    }
    paramViewGroup = new QCircleFollowMessageItemView(getParentFragment().getActivity(), paramInt);
    paramViewGroup.setReportBean(getReportBean());
    return new zyz(paramViewGroup);
  }
  
  public void onDrawItemDecoration(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState) {}
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleMessageListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("key_jump_from");
      if (!TextUtils.isEmpty(str)) {
        this.mFromPush = str.equals(String.valueOf(7));
      }
      int i = paramBundle.getInt("key_page_id", 0);
      int j = paramBundle.getInt("key_from_page_id", 0);
      setReportBean(new QCircleReportBean().setPageId(i).setFromPageId(j).setPageIdStr(getPageIdStr()));
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
    for (int i = 2131165343;; i = 2131166240)
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