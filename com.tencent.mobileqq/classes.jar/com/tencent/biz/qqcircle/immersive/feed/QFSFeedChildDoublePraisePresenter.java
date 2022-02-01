package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.utils.QFSSafeListUtils;
import com.tencent.biz.qqcircle.immersive.utils.QFSShareInfoUtils;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;

public class QFSFeedChildDoublePraisePresenter
  extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
{
  private QCircleDoublePraiseView i;
  private QCircleDoubleClickLayout j;
  private int k = 0;
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setExt1(paramString).setPageId(f()).setfpageid(Integer.parseInt(h())));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QFSFeedChildDoublePraisePresenter", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.d("QFSFeedChildDoublePraisePresenter", 1, "[resizeDoublePraiseView] feed should not be null.");
      return;
    }
    int m = paramStFeed.type.get();
    int n;
    if (m == 3)
    {
      m = paramStFeed.cover.width.get();
      n = paramStFeed.cover.height.get();
    }
    else
    {
      if (m == 2)
      {
        paramStFeed = (FeedCloudMeta.StImage)QFSSafeListUtils.a(paramStFeed.images.get(), this.k);
        if (paramStFeed != null)
        {
          m = paramStFeed.width.get();
          n = paramStFeed.height.get();
          break label101;
        }
      }
      n = 0;
      m = 0;
    }
    label101:
    if ((n > 0) && (m > 0))
    {
      int i1 = ImmersiveUtils.b();
      m = (int)(i1 / m * n);
      paramStFeed = (FrameLayout.LayoutParams)this.i.getLayoutParams();
      paramStFeed.width = i1;
      paramStFeed.height = m;
      paramStFeed.gravity = 17;
      this.i.setLayoutParams(paramStFeed);
      return;
    }
    QLog.d("QFSFeedChildDoublePraisePresenter", 1, new Object[] { "[resizeDoublePraiseView] coverH: ", Integer.valueOf(n), " | coverW: ", Integer.valueOf(m), ", param illegality." });
  }
  
  private void k()
  {
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.putAll(QCirclePluginReportUtil.a(this.h));
    localMap.put("xsj_feed_index", Integer.valueOf(this.d + 1));
    localMap.put("xsj_target_qq", ((FeedCloudMeta.StFeed)this.c).poster.id.get());
    localMap.put("xsj_action_type", "like");
    localMap.put("xsj_clck_type", "double_clck");
    VideoReport.reportEvent("ev_xsj_like_work", this.f, localMap);
  }
  
  private void l()
  {
    if (this.a == null)
    {
      QLog.d("QFSFeedChildDoublePraisePresenter", 1, "[handleLongClick] feed ioc should not be null.");
      return;
    }
    QCircleShareInfo localQCircleShareInfo = QFSShareInfoUtils.a((FeedCloudMeta.StFeed)this.c);
    localQCircleShareInfo.a = this.h;
    localQCircleShareInfo.c.mDataPosition = this.d;
    localQCircleShareInfo.r = i();
    if ((i() != null) && ("pg_ks_explore_page".equals(String.valueOf(i().getPageId())))) {
      localQCircleShareInfo.l = true;
    }
    this.a.a("event_open_share", new Object[] { localQCircleShareInfo });
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.j = ((QCircleDoubleClickLayout)paramView.findViewById(2131433364));
    this.i = ((QCircleDoublePraiseView)paramView.findViewById(2131433351));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    this.i.setFeed(paramStFeed, paramInt);
    a(paramStFeed);
    this.j.setOnDoubleClickListener(new QFSFeedChildDoublePraisePresenter.1(this));
    this.j.setOnTapClickListener(new QFSFeedChildDoublePraisePresenter.2(this));
    this.j.setOnLongClickListener(new QFSFeedChildDoublePraisePresenter.3(this));
  }
  
  public void c()
  {
    super.c();
    QCircleDoublePraiseView localQCircleDoublePraiseView = this.i;
    if (localQCircleDoublePraiseView != null)
    {
      localQCircleDoublePraiseView.setReportBean(i());
      this.i.setPageType(f());
    }
  }
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.d(paramQFSFeedSelectInfo);
  }
  
  public void e(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.e(paramQFSFeedSelectInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildDoublePraisePresenter
 * JD-Core Version:    0.7.0.1
 */