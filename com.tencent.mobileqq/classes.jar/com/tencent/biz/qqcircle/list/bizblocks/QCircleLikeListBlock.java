package com.tencent.biz.qqcircle.list.bizblocks;

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
import anni;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget;
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
import voe;
import vrf;
import vri;
import zxj;
import zxz;
import zyz;
import zza;

public class QCircleLikeListBlock
  extends voe<FeedCloudMeta.StLightInteractInfo, FeedCloudRead.StGetLightInteractListRsp>
{
  public static final String FEED = "StFeed";
  public static final String LIKE_KEY = "likeKey";
  private static final String TAG = "QCircleLikeListBlock";
  public static final String TYPE = "requestType";
  private View mBottomLine;
  private FeedCloudMeta.StFeed mCurrentFeed = new FeedCloudMeta.StFeed();
  private String mId;
  private int mLightInteractType;
  private TextView mTvTitle;
  private TextView mTvUnReadNum;
  
  public QCircleLikeListBlock(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle != null) {
      try
      {
        this.mCurrentFeed = ((FeedCloudMeta.StFeed)this.mCurrentFeed.mergeFrom(paramBundle.getByteArray("StFeed")));
        this.mId = paramBundle.getString("likeKey");
        this.mLightInteractType = paramBundle.getInt("requestType");
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
  
  public List<zxj> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_like_page";
  }
  
  public String getEmptyHint()
  {
    return anni.a(2131697192);
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    return paramStGetLightInteractListRsp.isFinish.get() == 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 2;
  }
  
  public void getListDataAsync(zza<FeedCloudMeta.StLightInteractInfo> paramzza, String paramString) {}
  
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
    return new QCircleGetLightInteractRequest(this.mCurrentFeed, paramString, this.mLightInteractType, this.mId);
  }
  
  public String getTitle()
  {
    if (this.mLightInteractType == 2) {
      return anni.a(2131697184);
    }
    return anni.a(2131697185);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560737, paramViewGroup, false);
    this.mTvTitle = ((TextView)paramViewGroup.findViewById(2131379933));
    this.mBottomLine = paramViewGroup.findViewById(2131380429);
    this.mTvUnReadNum = ((TextView)paramViewGroup.findViewById(2131379860));
    this.mTvTitle.setText(getTitle());
    this.mBottomLine.setVisibility(8);
    this.mTvUnReadNum.setVisibility(8);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  protected void handleResponse(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    super.handleResponse(paramBoolean1, paramBoolean2, paramLong, paramString1, paramString2, paramStGetLightInteractListRsp);
  }
  
  public void initTitleBar(View paramView) {}
  
  public void loadData(zxz paramzxz)
  {
    super.loadData(paramzxz);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (vri.a().d()) {
      vri.a().a(59, getActivity().getIntent());
    }
    vrf.a("", 17, 13, 1);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    vri.a().d(59);
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
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    try
    {
      ((QCircleBaseLightInteractWidget)paramViewHolder.itemView).a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mCurrentFeed, new ReportExtraTypeInfo(), 0);
      if (this.mDataList != null) {
        ((zyz)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
      }
      QLog.d("QCircleLikeListBlock", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QCircleLikeListBlock", 1, "onBindViewHolder error", localException);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public zyz onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleLightInteractPolyLikeWidget(getContext(), paramInt);
    paramViewGroup.setReportBeanAgent(this);
    return new zyz(paramViewGroup);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleLikeListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
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
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleLikeListBlock
 * JD-Core Version:    0.7.0.1
 */