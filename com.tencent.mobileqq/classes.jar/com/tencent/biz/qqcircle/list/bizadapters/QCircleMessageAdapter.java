package com.tencent.biz.qqcircle.list.bizadapters;

import alud;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleMessageNoticeRequest;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleCommentOrReplyMessageItemView;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleDefaultMessageWidget;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleFollowMessageItemView;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleUnsupportedMessageItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudRead.StGetNoticeListRsp;
import java.util.ArrayList;
import tqs;
import tys;
import tyu;
import tyw;
import tzv;
import tzy;
import uax;
import xin;
import yii;

public class QCircleMessageAdapter
  extends tys<FeedCloudMeta.StNotice, FeedCloudRead.StGetNoticeListRsp>
{
  private static final int MESSAGE_TYPE_UNSUPPORTED = SUPPORT_MESSAGE_TYPES.length;
  private static final int[] SUPPORT_MESSAGE_TYPES = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
  private static final String TAG = "QCircleMessageAdapter";
  private boolean mFromPush;
  
  public QCircleMessageAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_message_notice_page";
  }
  
  public String getEmptyHint()
  {
    return alud.a(2131698348);
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt))
    {
      paramInt = ((FeedCloudMeta.StNotice)this.mDataList.get(paramInt)).noticeType.get();
      if ((paramInt >= 0) && (paramInt < MESSAGE_TYPE_UNSUPPORTED)) {
        return paramInt;
      }
    }
    QLog.e("QCircleMessageAdapter", 2, "getItemViewType()  return MESSAGE_TYPE_UNSUPPORTED" + MESSAGE_TYPE_UNSUPPORTED);
    return MESSAGE_TYPE_UNSUPPORTED;
  }
  
  public QCircleBaseRequest getRequest(yii paramyii)
  {
    if (paramyii.c())
    {
      paramyii = new QCircleMessageNoticeRequest(null, false);
      paramyii.setEnableCache(true);
      return paramyii;
    }
    if (paramyii.d()) {
      return new QCircleMessageNoticeRequest(null, false);
    }
    if (paramyii.e()) {
      return new QCircleMessageNoticeRequest(this.mLastRspInfo.a(), false);
    }
    return null;
  }
  
  public String getTitle()
  {
    return alud.a(2131698349);
  }
  
  public int getViewTypeCount()
  {
    return SUPPORT_MESSAGE_TYPES.length + 1;
  }
  
  public tyw<FeedCloudMeta.StNotice> handleResponse(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    boolean bool = true;
    tyw localtyw = new tyw();
    localtyw.a(paramStGetNoticeListRsp.feedAttchInfo.get());
    localtyw.a(paramStGetNoticeListRsp.vecNotice.get());
    if (paramStGetNoticeListRsp.isFinish.get() == 1) {}
    for (;;)
    {
      localtyw.a(bool);
      return localtyw;
      bool = false;
    }
  }
  
  public void initTitleBar(View paramView) {}
  
  public void loadData(yii paramyii)
  {
    super.loadData(paramyii);
    if (paramyii.c())
    {
      uax.a().a();
      QCircleGlobalBroadcastHelper.a().c();
    }
    while (!paramyii.d()) {
      return;
    }
    uax.a().a();
    QCircleGlobalBroadcastHelper.a().c();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (tzy.a().b(59)) {
      tzy.a().a(getActivity().getIntent());
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    tzy.a().a(59);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    tzv.a("", 17, 1L);
  }
  
  public boolean onBackEvent()
  {
    if (this.mFromPush)
    {
      QLog.d("QCircleMessageAdapter", 1, "mFromPush back launchFolderPage");
      if (tzy.a().c() <= 1) {
        tqs.a(getContext(), null);
      }
      getActivity().finish();
      return true;
    }
    QLog.d("QCircleMessageAdapter", 1, "not mFromPush back finish");
    return false;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null) {
      ((tyu)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    QLog.d("QCircleMessageAdapter", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
  }
  
  public tyu onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("QCircleMessageAdapter", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new tyu(new QCircleUnsupportedMessageItemView(getParentFragment().getActivity()));
    case 0: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      return new tyu(new QCircleDefaultMessageWidget(getParentFragment().getActivity(), paramInt));
    case 1: 
    case 2: 
      return new tyu(new QCircleCommentOrReplyMessageItemView(getParentFragment().getActivity(), paramInt));
    }
    return new tyu(new QCircleFollowMessageItemView(getParentFragment().getActivity(), paramInt));
  }
  
  public void onDrawItemDecoration(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState)
  {
    paramState = getContext().getResources().getDrawable(2130843639);
    int i = paramRecyclerView.getPaddingLeft();
    int j = xin.b(getContext(), 60.0F);
    int k = paramRecyclerView.getWidth();
    int m = paramRecyclerView.getPaddingRight();
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0)) {
      return;
    }
    paramRecyclerView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int n = paramView.getBottom();
    n = paramRecyclerView.bottomMargin + n;
    paramState.setBounds(j + i, n, k - m, paramState.getIntrinsicHeight() + n);
    paramState.draw(paramCanvas);
  }
  
  public void onPrepareParams(Bundle paramBundle)
  {
    QLog.d("QCircleMessageAdapter", 1, "onPrepareParams");
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_jump_from");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.mFromPush = paramBundle.equals(String.valueOf(7));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizadapters.QCircleMessageAdapter
 * JD-Core Version:    0.7.0.1
 */