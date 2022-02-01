package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCirclePolymerizeDetailClick;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

public class QCircleFeedItemDesPresenter
  extends QCircleBaseFeedChildPresenter
  implements LayoutPreLoader.RequestPreloadViewListener
{
  private static final String TAG = "QCircleFeedItemDesPresenter";
  private QCircleExpandableTextView mFeedDesEtx;
  View.OnClickListener mLaunchToFeedDetailListener = new QCircleFeedItemDesPresenter.5(this);
  private View.OnAttachStateChangeListener mListener;
  
  static {}
  
  private void handleDesCollapsed()
  {
    if (FastClickUtils.a("QCircleFeedItemDesPresenter_handleDesCollapsed", 500L)) {
      return;
    }
    Object localObject = this.mFeedDesEtx;
    if (localObject == null)
    {
      QLog.w("QCircleFeedItemDesPresenter", 1, "[handleDesCollapsed] feed des view not is null.");
      return;
    }
    localObject = ((QCircleExpandableTextView)localObject).getExpandTextView();
    if (localObject == null)
    {
      QLog.w("QCircleFeedItemDesPresenter", 1, "[handleDesCollapsed] expand action view not is null.");
      return;
    }
    if (((TextView)localObject).getVisibility() != 0) {
      return;
    }
    ((TextView)localObject).performClick();
  }
  
  @QCirclePolymerizeDetailClick
  private void handleLaunchFeedDetail()
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this);
    handleLaunchFeedDetail_aroundBody1$advice(this, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
  
  private void handleLongClickFeedDes(View paramView)
  {
    if (!(this.mData instanceof FeedBlockData)) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
    QCirclePopupWindowHelper.a().a(paramView, new QCircleFeedItemDesPresenter.6(this, localStFeed), new QCircleFeedItemDesPresenter.7(this));
  }
  
  private boolean isTextDefaultToExpand()
  {
    return QCircleReportBean.isFeedDetailPage(getReportBean().getPageId());
  }
  
  private void reportHashTagInfo(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, String paramString)
  {
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(paramStFeed).setActionType(paramInt1).setSubActionType(paramInt2).setExt1(paramString)).setPageId(getPageId()));
  }
  
  private void setFeedContent(FeedCloudMeta.StFeed paramStFeed)
  {
    if (TextUtils.isEmpty(paramStFeed.content.get()))
    {
      this.mFeedDesEtx.setVisibility(8);
      return;
    }
    boolean bool = isTextDefaultToExpand();
    this.mFeedDesEtx.setOnClickHashTagListener(new QCircleFeedItemDesPresenter.2(this, paramStFeed));
    if ((this.mFeedDesEtx.getSourceTextView() instanceof QCircleAsyncTextView)) {
      ((QCircleAsyncTextView)this.mFeedDesEtx.getSourceTextView()).setPreloadText("feed_des_", paramStFeed.content.get());
    }
    this.mFeedDesEtx.setText(paramStFeed.content.get(), bool, new QCircleFeedItemDesPresenter.3(this, paramStFeed));
    this.mFeedDesEtx.setVisibility(0);
    this.mFeedDesEtx.getSourceTextView().setOnClickListener(this.mLaunchToFeedDetailListener);
    this.mFeedDesEtx.setOnClickListener(this.mLaunchToFeedDetailListener);
    if (this.mListener == null)
    {
      this.mListener = new QCircleFeedItemDesPresenter.4(this, paramStFeed);
      this.mFeedDesEtx.addOnAttachStateChangeListener(this.mListener);
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if (!(this.mData instanceof FeedBlockData)) {
      return;
    }
    this.mReportInfo.mDataPosition = this.mPos;
    this.mReportInfo.mFeed = ((FeedBlockData)this.mData).b();
    this.mReportInfo.mPlayScene = 1;
    setFeedContent(((FeedBlockData)this.mData).b());
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedItemDesPresenter";
  }
  
  public void initView(View paramView)
  {
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440929), this);
  }
  
  public void onPreloadResult(View paramView)
  {
    this.mContainer = paramView;
    this.mFeedDesEtx = ((QCircleExpandableTextView)this.mContainer.findViewById(2131441630));
    paramView = (QCircleAsyncTextView)this.mFeedDesEtx.getSourceTextView();
    if (paramView != null) {
      paramView.setOnLongClickListener(new QCircleFeedItemDesPresenter.1(this));
    }
    if (this.mData != null) {
      bindData(this.mData, this.mPos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemDesPresenter
 * JD-Core Version:    0.7.0.1
 */