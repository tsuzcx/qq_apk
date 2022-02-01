package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.biz.qqcircle.utils.QCirclePoiUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleFeedLocationPresenter
  extends QCircleBaseFeedChildPresenter
  implements View.OnClickListener, LayoutPreLoader.RequestPreloadViewListener
{
  private static final String TAG = "QCircleFeedItemHeadPresenter";
  private TextView mLocationText;
  private View mLocationWrapper;
  
  static {}
  
  private void jumpNearbyPage()
  {
    if (!(this.mData instanceof FeedBlockData))
    {
      QLog.w("QCircleFeedItemHeadPresenter", 1, "[jumpLbsPage] invalid data");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
    QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.gpsInfo = localStFeed.poiInfo.gps;
    localQCirclePolymerizationBean.setFeedListBusiReqData(localStFeedListBusiReqData);
    localQCirclePolymerizationBean.setFromReportBean(getReportBean().clone());
    localQCirclePolymerizationBean.setPolymerizationType(16);
    localQCirclePolymerizationBean.setExt1From(1);
    localQCirclePolymerizationBean.setPoiInfo(localStFeed.poiInfo);
    QCircleLauncher.a(this.mContainer.getContext(), localQCirclePolymerizationBean);
  }
  
  private void reportClick(int paramInt)
  {
    if (this.mReportInfo != null) {
      localObject = this.mReportInfo.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(paramInt).setSubActionType(2);
    if ((this.mReportInfo != null) && (this.mReportInfo.mFeed != null)) {
      localObject = this.mReportInfo.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    Object localObject = localDataBuilder.setToUin((String)localObject);
    if (this.mReportInfo != null) {
      paramInt = this.mReportInfo.mDataPosition;
    } else {
      paramInt = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(paramInt).setPageId(getPageId())));
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData != null) && ((this.mData instanceof FeedBlockData)))
    {
      paramObject = QCirclePoiUtils.a(((FeedBlockData)this.mData).b());
      if (TextUtils.isEmpty(paramObject))
      {
        this.mLocationWrapper.setVisibility(8);
        return;
      }
      this.mLocationWrapper.setVisibility(0);
      this.mLocationText.setText(paramObject);
      if (this.mReportInfo != null) {
        paramObject = this.mReportInfo.mFeed;
      } else {
        paramObject = null;
      }
      QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b(paramObject).setActionType(92).setSubActionType(1);
      if ((this.mReportInfo != null) && (this.mReportInfo.mFeed != null)) {
        paramObject = this.mReportInfo.mFeed.poster.id.get();
      } else {
        paramObject = "";
      }
      paramObject = localDataBuilder.setToUin(paramObject);
      if (this.mReportInfo != null) {
        paramInt = this.mReportInfo.mDataPosition;
      } else {
        paramInt = -1;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramObject.setIndex(paramInt).setPageId(getPageId())));
    }
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedItemHeadPresenter";
  }
  
  public void initView(View paramView)
  {
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131441640), this);
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this, paramView);
    onClick_aroundBody1$advice(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPreloadResult(View paramView)
  {
    this.mContainer = paramView;
    this.mLocationWrapper = this.mContainer.findViewById(2131441743);
    this.mLocationText = ((TextView)this.mContainer.findViewById(2131441741));
    this.mLocationWrapper.setOnClickListener(this);
    if (this.mData != null) {
      bindData(this.mData, this.mPos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedLocationPresenter
 * JD-Core Version:    0.7.0.1
 */