package com.tencent.biz.qqcircle.widgets.pymk;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;
import qqcircle.QQCircleDitto.StItemContainer;

public class QCirclePYMKRecommendView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  protected TextView a;
  protected TextView b;
  protected ImageView c;
  protected RecyclerView d;
  protected QCirclePYMKRecommendAdapter e;
  protected RecyclerView.LayoutManager f;
  protected QQCircleDitto.StItemContainer g;
  protected QCircleExtraTypeInfo h = new QCircleExtraTypeInfo();
  protected View i;
  protected int j = -1;
  protected int k = 0;
  protected int l = -1;
  protected QCircleFeedReportScroller m;
  
  public QCirclePYMKRecommendView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePYMKRecommendView(@NonNull Context paramContext, Integer paramInteger)
  {
    super(paramContext, paramInteger.intValue());
  }
  
  private void a()
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      return;
    }
    if (this.k == 94)
    {
      localTextView.setVisibility(0);
      this.b.setText(this.g.title.get());
      return;
    }
    localTextView.setVisibility(8);
  }
  
  private void a(int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.e == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[setAdapterSource] recommend adapter should not be null.");
      return;
    }
    QQCircleDitto.StItemContainer localStItemContainer = this.g;
    if (localStItemContainer == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[setDataSource] container should not be null.");
      return;
    }
    QLog.d("PYMK-QCirclePYMKRecommendView", 1, new Object[] { "[setAdapterSource] dittoFeed pos: ", Integer.valueOf(paramInt), " | itemSize: ", Integer.valueOf(localStItemContainer.items.size()), " | styleType: ", Integer.valueOf(this.g.styleType.get()) });
    this.e.a(this.g);
    this.e.a(paramStFeed, paramInt, this.g.items.get(), this.g.styleType.get());
  }
  
  private void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (this.i == null) {
      return;
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      ((QCircleExtraTypeInfo)localObject).mFeed = paramFeedBlockData.b();
      localObject = this.h;
      ((QCircleExtraTypeInfo)localObject).mPlayScene = 1;
      ((QCircleExtraTypeInfo)localObject).mDataPosition = paramInt;
    }
    else
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updateReportInfo] current report info should not be null.");
    }
    VideoReport.setElementId(this.i, "em_xsj_pymk_box");
    localObject = new QCircleDTParamBuilder().buildElementParams();
    ((Map)localObject).putAll(QCirclePluginReportUtil.a(paramFeedBlockData));
    ((Map)localObject).put("xsj_feed_index", Integer.valueOf(paramInt + 1));
    paramFeedBlockData = this.g;
    if (paramFeedBlockData == null) {
      paramFeedBlockData = "";
    } else {
      paramFeedBlockData = paramFeedBlockData.title.get();
    }
    ((Map)localObject).put("xsj_recom_title", paramFeedBlockData);
    VideoReport.setElementParams(this.i, (Map)localObject);
  }
  
  private void a(FeedBlockData paramFeedBlockData, FeedCloudMeta.StDittoFeed paramStDittoFeed)
  {
    if (paramFeedBlockData == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[fillContainerSource] blockData should not be null.");
      return;
    }
    if (paramStDittoFeed == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[fillContainerSource] dittoFeed should not be null.");
      return;
    }
    try
    {
      this.g = new QQCircleDitto.StItemContainer();
      paramFeedBlockData = paramFeedBlockData.a("DITTO_MAY_INTEREST_PERSON");
      if ((paramFeedBlockData instanceof QQCircleDitto.StItemContainer))
      {
        this.g = ((QQCircleDitto.StItemContainer)paramFeedBlockData);
        QLog.d("PYMK-QCirclePYMKRecommendView", 4, "[bindData] get data from blockData");
        return;
      }
      this.g.mergeFrom(paramStDittoFeed.dittoData.get().toByteArray());
      QLog.d("PYMK-QCirclePYMKRecommendView", 4, "[bindData] get data from merger");
      return;
    }
    catch (Exception paramFeedBlockData)
    {
      QLog.e("PYMK-QCirclePYMKRecommendView", 1, "[bindData] Exception:", paramFeedBlockData);
    }
  }
  
  private void b()
  {
    QCirclePYMKRecommendAdapter localQCirclePYMKRecommendAdapter = this.e;
    if (localQCirclePYMKRecommendAdapter == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updateSplashFlag] update splash flag fail, adapter should not be null.");
      return;
    }
    localQCirclePYMKRecommendAdapter.a(true);
  }
  
  private void c()
  {
    QQCircleDitto.StItemContainer localStItemContainer = this.g;
    int n = 1;
    if (localStItemContainer == null)
    {
      QLog.w("PYMK-QCirclePYMKRecommendView", 1, "[checkChangeStyleType] container == null.");
      return;
    }
    if (this.l == localStItemContainer.styleType.get()) {
      n = 0;
    }
    if (n != 0) {
      this.d.removeAllViews();
    }
    this.l = this.g.styleType.get();
  }
  
  private void d()
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updateRecyclerMargin] recommend recycler should not be null.");
      return;
    }
    if (this.k == 94) {
      return;
    }
    localObject = ((RecyclerView)localObject).getLayoutParams();
    if ((localObject instanceof FrameLayout.LayoutParams)) {
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    }
  }
  
  private void e()
  {
    Object localObject = this.i.findViewById(2131440933);
    if (localObject == null)
    {
      QLog.w("PYMK-QCirclePYMKRecommendView", 1, "[updateMainRecommendParentBackground] main recommend layout should not be null.");
      return;
    }
    ((View)localObject).setVisibility(8);
    localObject = ((View)localObject).getParent();
    if ((localObject instanceof View))
    {
      ((View)localObject).setBackgroundColor(getResources().getColor(2131168381));
      return;
    }
    QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updateMainRecommendParentBackground] current recommend parent not a view.");
  }
  
  private void f()
  {
    QCirclePYMKRecommendAdapter localQCirclePYMKRecommendAdapter = this.e;
    if (localQCirclePYMKRecommendAdapter == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updatePYMKViewPageId] recommend adapter should not be null.");
      return;
    }
    localQCirclePYMKRecommendAdapter.b(this.k);
  }
  
  private void g()
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[onClick] container should not be null.");
      return;
    }
    localObject = QCircleJsUrlConfig.a(((QQCircleDitto.StItemContainer)localObject).urlInfo.get(), "personRecomListUrl");
    QCircleLauncher.a(getContext(), (String)localObject, null, -1);
    h();
  }
  
  private void h()
  {
    Object localObject1 = this.h;
    if (localObject1 != null) {
      localObject1 = ((QCircleExtraTypeInfo)localObject1).mFeed;
    } else {
      localObject1 = null;
    }
    Object localObject2 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject1).setActionType(29).setSubActionType(2);
    localObject1 = this.h;
    if ((localObject1 != null) && (((QCircleExtraTypeInfo)localObject1).mFeed != null)) {
      localObject1 = this.h.mFeed.poster.id.get();
    } else {
      localObject1 = "";
    }
    localObject1 = ((QCircleLpReportDc05501.DataBuilder)localObject2).setToUin((String)localObject1);
    localObject2 = this.h;
    int n;
    if (localObject2 != null) {
      n = ((QCircleExtraTypeInfo)localObject2).mDataPosition;
    } else {
      n = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject1).setIndex(n).setPageId(this.k)));
  }
  
  private void i()
  {
    Object localObject1 = new QCircleDTParamBuilder().buildElementParams();
    Object localObject2 = this.a;
    if (localObject2 != null)
    {
      VideoReport.setElementId(localObject2, "em_xsj_pymk_more");
      VideoReport.setElementParams(this.a, (Map)localObject1);
      localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("em_xsj_pymk_more_");
      localStringBuilder.append(this.a.hashCode());
      VideoReport.setElementReuseIdentifier(localObject2, localStringBuilder.toString());
    }
    localObject2 = this.c;
    if (localObject2 != null)
    {
      VideoReport.setElementId(localObject2, "em_xsj_pymk_more");
      VideoReport.setElementParams(this.c, (Map)localObject1);
      localObject1 = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("em_xsj_pymk_more_");
      ((StringBuilder)localObject2).append(this.c.hashCode());
      VideoReport.setElementReuseIdentifier(localObject1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    if (this.e == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[bindData] current adapter should not be null.");
      return;
    }
    if (!(paramObject instanceof FeedBlockData))
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[bindData] current obj data not is FeedBlockData type.");
      return;
    }
    FeedBlockData localFeedBlockData = (FeedBlockData)paramObject;
    FeedCloudMeta.StFeed localStFeed = localFeedBlockData.b();
    if (localStFeed == null) {
      paramObject = null;
    } else {
      paramObject = (FeedCloudMeta.StDittoFeed)localStFeed.dittoFeed.get();
    }
    a(localFeedBlockData, paramObject);
    a(localFeedBlockData, paramInt);
    c();
    a(paramInt, localStFeed);
    i();
    a();
  }
  
  public QQCircleDitto.StItemContainer getCurrentContainer()
  {
    return this.g;
  }
  
  public int getLayoutId()
  {
    return 2131626817;
  }
  
  protected String getLogTag()
  {
    return "PYMK-QCirclePYMKRecommendView";
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.d;
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n == 2131440952) {
      g();
    } else if (n == 2131440934) {
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[onInitView] root view should not be null.");
      return;
    }
    this.i = paramView;
    this.c = ((ImageView)paramView.findViewById(2131440952));
    this.c.setOnClickListener(this);
    this.a = ((TextView)paramView.findViewById(2131440934));
    this.a.setOnClickListener(this);
    int n = ImmersiveUtils.a(10.0F);
    QCirclePluginUtil.a(this.c, n, n, n, n);
    QCirclePluginUtil.a(this.a, n, n, n, n);
    this.d = ((RecyclerView)paramView.findViewById(2131440951));
    this.f = new SafeLinearLayoutManager(paramContext, 0, false);
    this.d.setLayoutManager(this.f);
    this.d.setItemAnimator(new DefaultItemAnimator());
    this.e = new QCirclePYMKRecommendAdapter();
    this.e.a(this);
    this.e.a(this.mReportBean);
    this.e.b(this.k);
    this.e.a(this.d);
    this.e.a(this.m);
    this.d.setAdapter(this.e);
    new QCirclePagerSnapHelper(1, 100.0F).a(this.d);
  }
  
  public void setPageId(int paramInt)
  {
    this.k = paramInt;
    QCirclePYMKRecommendAdapter localQCirclePYMKRecommendAdapter = this.e;
    if (localQCirclePYMKRecommendAdapter != null) {
      localQCirclePYMKRecommendAdapter.b(paramInt);
    }
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    QCirclePYMKRecommendAdapter localQCirclePYMKRecommendAdapter = this.e;
    if (localQCirclePYMKRecommendAdapter == null)
    {
      QLog.w("PYMK-QCirclePYMKRecommendView", 1, "[setReportBean] recommend adapter should not be null.");
      return;
    }
    this.mReportBean = paramQCircleReportBean;
    localQCirclePYMKRecommendAdapter.a(this.mReportBean);
  }
  
  public void setReportScroller(QCircleFeedReportScroller paramQCircleFeedReportScroller)
  {
    this.m = paramQCircleFeedReportScroller;
    QCirclePYMKRecommendAdapter localQCirclePYMKRecommendAdapter = this.e;
    if (localQCirclePYMKRecommendAdapter == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[setFeedReportScroller] recommend adapter should not be null.");
      return;
    }
    localQCirclePYMKRecommendAdapter.a(paramQCircleFeedReportScroller);
  }
  
  public void setSplashRecommendPageId(int paramInt)
  {
    this.k = paramInt;
    this.j = 50002;
    b();
    d();
    e();
    f();
  }
  
  public void setWidgetHideIntercept(QCirclePYMKRecommendAdapter.IWidgetHideIntercept paramIWidgetHideIntercept)
  {
    QCirclePYMKRecommendAdapter localQCirclePYMKRecommendAdapter = this.e;
    if (localQCirclePYMKRecommendAdapter == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[setWidgetHideIntercept] recommend adapter should not be null.");
      return;
    }
    localQCirclePYMKRecommendAdapter.a(paramIWidgetHideIntercept);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView
 * JD-Core Version:    0.7.0.1
 */