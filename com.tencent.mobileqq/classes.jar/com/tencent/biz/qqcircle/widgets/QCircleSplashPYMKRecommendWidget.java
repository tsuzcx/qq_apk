package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.part.block.base.ScaleTransformer;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendAdapter;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView;
import com.tencent.biz.richframework.part.block.base.GalleryLayoutManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleDitto.StItemContainer;

public class QCircleSplashPYMKRecommendWidget
  extends QCirclePYMKRecommendView
  implements View.OnClickListener
{
  private GalleryLayoutManager n;
  
  public QCircleSplashPYMKRecommendWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (this.h != null) {
      localObject = this.h.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(29).setSubActionType(2);
    if ((this.h != null) && (this.h.mFeed != null)) {
      localObject = this.h.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    Object localObject = localDataBuilder.setToUin((String)localObject);
    int i;
    if (this.h != null) {
      i = this.h.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i).setPageId(getPageId())));
  }
  
  public void onClick(View paramView)
  {
    if (this.g == null)
    {
      QLog.d("QCircleSplashPYMKRecommendWidget", 1, "[onClick] container not is null.");
    }
    else
    {
      String str = QCircleJsUrlConfig.a(this.g.urlInfo.get(), "personRecomListUrl");
      QCircleLauncher.a(getContext(), str, null, -1);
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView == null)
    {
      QLog.d("QCircleSplashPYMKRecommendWidget", 1, "[onInitView] root view not is null.");
      return;
    }
    this.i = paramView;
    this.c = ((ImageView)paramView.findViewById(2131440952));
    this.c.setOnClickListener(this);
    this.a = ((TextView)paramView.findViewById(2131440934));
    this.a.setOnClickListener(this);
    this.b = ((TextView)paramView.findViewById(2131441901));
    int i = ImmersiveUtils.a(10.0F);
    QCirclePluginUtil.a(this.c, i, i, i, i);
    QCirclePluginUtil.a(this.a, i, i, i, i);
    this.d = ((RecyclerView)paramView.findViewById(2131440953));
    paramView.findViewById(2131440951).setVisibility(8);
    this.d.setVisibility(0);
    this.n = new GalleryLayoutManager(0);
    this.n.a(this.d, 0);
    this.n.a(true);
    this.n.a(new ScaleTransformer());
    this.e = new QCirclePYMKRecommendAdapter();
    this.d.getLayoutParams().height = ViewUtils.a(350.0F);
    this.e.a(this);
    this.d.setAdapter(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleSplashPYMKRecommendWidget
 * JD-Core Version:    0.7.0.1
 */