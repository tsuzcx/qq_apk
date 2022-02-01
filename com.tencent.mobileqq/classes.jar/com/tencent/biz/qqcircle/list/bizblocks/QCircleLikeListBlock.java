package com.tencent.biz.qqcircle.list.bizblocks;

import aabe;
import aabj;
import aabu;
import aacv;
import aacw;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import anzj;
import com.tencent.biz.qqcircle.launchbean.QCircleLikeBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget;
import com.tencent.biz.qqcircle.widgets.QCircleSimpleTextView;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;
import java.util.ArrayList;
import java.util.List;
import vqm;
import vtq;
import vtt;

public class QCircleLikeListBlock
  extends vqm<FeedCloudMeta.StLightInteractInfo, FeedCloudRead.StGetLightInteractListRsp>
{
  private static final String TAG = "QCircleLikeListBlock";
  public static final int TYPE_CONTENT1 = 3;
  public static final int TYPE_CONTENT2 = 4;
  public static final int TYPE_CONTENT3 = 5;
  public static final int TYPE_TITLE1 = 1;
  public static final int TYPE_TITLE2 = 2;
  private View mBottomLine;
  private int mCount;
  private FeedCloudMeta.StFeed mCurrentFeed = new FeedCloudMeta.StFeed();
  private String mId;
  private int mLightInteractType;
  private long mTime;
  private TextView mTvTitle;
  private TextView mTvUnReadNum;
  
  public QCircleLikeListBlock(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = (QCircleLikeBean)paramBundle.getSerializable("key_bundle_common_init_bean");
      try
      {
        this.mCurrentFeed = paramBundle.getFeed();
        this.mId = paramBundle.getLikeId();
        this.mLightInteractType = paramBundle.getRequestType();
        this.mCount = paramBundle.getCount();
        this.mTime = paramBundle.getTime();
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("QCircleLikeListBlock", 1, paramBundle, new Object[0]);
        return;
      }
    }
    QLog.e("QCircleLikeListBlock", 1, "initParams == null");
  }
  
  public String getAttachInfoFromItemData(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    return paramStGetLightInteractListRsp.attachInfo.get();
  }
  
  public List<aabe> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_like_page";
  }
  
  public String getEmptyHint()
  {
    return anzj.a(2131697260);
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    return paramStGetLightInteractListRsp.isFinish.get() == 1;
  }
  
  public int getItemCount()
  {
    if (this.mCount == 0) {
      return this.mDataList.size();
    }
    if (this.mDataList.size() > this.mCount) {
      return this.mDataList.size() + 2;
    }
    return this.mDataList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.mCount == 0) {
      return 3;
    }
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt < this.mCount + 1) {
      return 4;
    }
    if (paramInt == this.mCount + 1) {
      return 2;
    }
    return 5;
  }
  
  public void getListDataAsync(aacw<FeedCloudMeta.StLightInteractInfo> paramaacw, String paramString) {}
  
  public List<FeedCloudMeta.StLightInteractInfo> getListDataFromRsp(FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    return paramStGetLightInteractListRsp.listInfo.get();
  }
  
  public String getLogTag()
  {
    return "QCircleLikeListBlock";
  }
  
  public int getPageCount()
  {
    return 0;
  }
  
  public String getPageIdStr()
  {
    return "like_page";
  }
  
  public VSBaseRequest getRequest(String paramString)
  {
    return new QCircleGetLightInteractRequest(this.mCurrentFeed, paramString, this.mLightInteractType, this.mId, this.mTime, 2);
  }
  
  public String getTitle()
  {
    return anzj.a(2131697249);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560758, paramViewGroup, false);
    this.mTvTitle = ((TextView)paramViewGroup.findViewById(2131380117));
    this.mBottomLine = paramViewGroup.findViewById(2131380615);
    this.mTvUnReadNum = ((TextView)paramViewGroup.findViewById(2131380040));
    this.mTvTitle.setText(getTitle());
    this.mBottomLine.setVisibility(8);
    this.mTvUnReadNum.setVisibility(8);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  protected void handleResponse(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    super.handleResponse(paramBoolean1, paramBoolean2, paramLong, paramString1, paramString2, paramStGetLightInteractListRsp);
  }
  
  public void initTitleBar(View paramView)
  {
    if (paramView != null)
    {
      this.mTvTitle = ((TextView)paramView.findViewById(2131380141));
      if (this.mTvTitle != null) {
        this.mTvTitle.setTypeface(Typeface.DEFAULT_BOLD);
      }
    }
  }
  
  public void loadData(aabu paramaabu)
  {
    super.loadData(paramaabu);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (vtt.a().d()) {
      vtt.a().a(59, getActivity().getIntent());
    }
    vtq.a("", 17, 13, 1);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    vtt.a().d(59);
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
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    try
    {
      switch (getItemViewType(paramInt))
      {
      case 1: 
        for (;;)
        {
          QLog.d("QCircleLikeListBlock", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
          EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
          return;
          ((aacv)paramViewHolder).a(this.mCount + anzj.a(2131697251), paramInt, this.mExtraTypeInfo);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QCircleLikeListBlock", 1, "onBindViewHolder error", localException);
        continue;
        ((aacv)paramViewHolder).a(anzj.a(2131697250), paramInt, this.mExtraTypeInfo);
        continue;
        ((QCircleBaseLightInteractWidget)paramViewHolder.itemView).a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mCurrentFeed, new ReportExtraTypeInfo(), 0);
        if (this.mDataList != null)
        {
          ((aacv)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
          continue;
          ((QCircleBaseLightInteractWidget)paramViewHolder.itemView).a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mCurrentFeed, new ReportExtraTypeInfo(), 0);
          if (this.mDataList != null)
          {
            ((aacv)paramViewHolder).a(this.mDataList.get(paramInt - 1), paramInt, this.mExtraTypeInfo);
            continue;
            ((QCircleBaseLightInteractWidget)paramViewHolder.itemView).a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mCurrentFeed, new ReportExtraTypeInfo(), 0);
            if (this.mDataList != null) {
              ((aacv)paramViewHolder).a(this.mDataList.get(paramInt - 2), paramInt, this.mExtraTypeInfo);
            }
          }
        }
      }
    }
  }
  
  public aacv onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {
      return new aacv(new QCircleSimpleTextView(getContext()));
    }
    paramViewGroup = new QCircleLightInteractPolyLikeWidget(getContext(), paramInt);
    paramViewGroup.setReportBeanAgent(this);
    return new aacv(paramViewGroup);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleLikeListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
    getBlockMerger().a("");
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
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleLikeListBlock
 * JD-Core Version:    0.7.0.1
 */