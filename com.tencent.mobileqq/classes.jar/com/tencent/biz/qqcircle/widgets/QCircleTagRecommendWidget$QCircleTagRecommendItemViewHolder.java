package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter.QCircleRecommendItemBaseViewHolder;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.QCircleDrawableCacheUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

public class QCircleTagRecommendWidget$QCircleTagRecommendItemViewHolder
  extends QCircleRecommendBaseAdapter.QCircleRecommendItemBaseViewHolder
  implements View.OnClickListener
{
  public static final int h = ViewUtils.a(110.0F);
  public static final int i = ViewUtils.a(220.0F);
  public static final int j = ViewUtils.a(110.0F);
  private ImageView k;
  private TextView l;
  private TextView m;
  private ImageView n;
  private URLImageView o;
  private URLImageView p;
  private URLImageView q;
  
  public QCircleTagRecommendWidget$QCircleTagRecommendItemViewHolder(View paramView)
  {
    super(paramView);
    this.o = ((URLImageView)paramView.findViewById(2131440963));
    this.p = ((URLImageView)paramView.findViewById(2131440965));
    this.q = ((URLImageView)paramView.findViewById(2131440964));
    this.n = ((ImageView)paramView.findViewById(2131440958));
    this.m = ((TextView)paramView.findViewById(2131440966));
    this.l = ((TextView)paramView.findViewById(2131440967));
    this.k = ((ImageView)paramView.findViewById(2131440959));
    RoundCorneredRelativeLayout localRoundCorneredRelativeLayout = (RoundCorneredRelativeLayout)paramView.findViewById(2131440961);
    if (localRoundCorneredRelativeLayout != null)
    {
      float f = ViewUtils.a(10.0F);
      localRoundCorneredRelativeLayout.setRadius(f, f, f, f);
    }
    this.k.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.n.setOnClickListener(this);
    paramView.setOnClickListener(new QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder.1(this));
  }
  
  private void a(Context paramContext)
  {
    if ((this.a instanceof QQCircleDitto.StItemInfo))
    {
      QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)this.a;
      if (!TextUtils.isEmpty(localStItemInfo.id.get()))
      {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.c).setToUin(localStItemInfo.id.get()).setFeedType1(3).setFeedType2(3).setActionType(96).setSubActionType(2).setIndex(this.d).setContainerSeq(c()).setExt1(localStItemInfo.name.get()).setExt3((String)localStItemInfo.des.get().get(0)).setPageId(this.f)));
        QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
        localQCirclePolymerizationBean.setTagInfo((FeedCloudMeta.StTagInfo)localStItemInfo.tag.get());
        localQCirclePolymerizationBean.setPolymerizationType(7);
        localQCirclePolymerizationBean.setExt1From(4);
        localQCirclePolymerizationBean.setFromReportBean(a().clone());
        QCircleLauncher.a(paramContext, localQCirclePolymerizationBean);
      }
    }
  }
  
  private void d()
  {
    Object localObject = this.c;
    int i2 = 0;
    if (localObject != null)
    {
      localObject = this.c.opMask2.get();
      if ((localObject != null) && (((List)localObject).contains(Integer.valueOf(11))) && (!QCirclePluginUtil.b((FeedCloudMeta.StUser)this.c.poster.get())))
      {
        i1 = 1;
        break label66;
      }
    }
    int i1 = 0;
    label66:
    localObject = this.k;
    if (i1 != 0) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((ImageView)localObject).setVisibility(i1);
  }
  
  private void e()
  {
    Object localObject = this.c;
    if ((this.e != null) && ((this.a instanceof QQCircleDitto.StItemInfo)))
    {
      this.e.a(this.a, 6);
      if (this.e.getItemCount() <= 0) {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(((FeedCloudMeta.StFeed)localObject).id.get(), 3));
      }
      localObject = (QQCircleDitto.StItemInfo)this.a;
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.c).setToUin(((QQCircleDitto.StItemInfo)localObject).id.get()).setFeedType1(3).setFeedType2(3).setActionType(65).setSubActionType(1).setIndex(this.d).setContainerSeq(c()).setExt1(((QQCircleDitto.StItemInfo)localObject).name.get()).setExt4(((QQCircleDitto.StItemInfo)localObject).id.get()).setPageId(this.f)));
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.a = paramObject;
    this.b = paramInt;
    if ((this.a instanceof QQCircleDitto.StItemInfo))
    {
      paramObject = (QQCircleDitto.StItemInfo)this.a;
      this.m.setText(paramObject.name.get());
      if ((paramObject.des.get() != null) && (paramObject.des.get().size() > 0))
      {
        this.l.setText((CharSequence)paramObject.des.get().get(0));
        this.l.setVisibility(0);
      }
      else
      {
        this.l.setVisibility(4);
      }
      if ((paramObject.images.get() != null) && (paramObject.images.get().size() >= 3) && (this.o != null) && (this.p != null) && (this.q != null))
      {
        a(((FeedCloudMeta.StImage)paramObject.images.get().get(0)).picUrl.get(), QCircleDrawableCacheUtils.a(2130845231), this.o);
        a(((FeedCloudMeta.StImage)paramObject.images.get().get(1)).picUrl.get(), QCircleDrawableCacheUtils.a(2130845230), this.p);
        a(((FeedCloudMeta.StImage)paramObject.images.get().get(2)).picUrl.get(), QCircleDrawableCacheUtils.a(2130845230), this.q);
      }
      else
      {
        QLog.e("QCircleTagPageRecommendWidget", 4, "load error");
      }
      d();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131440959) {
      e();
    } else if ((i1 == 2131440963) || (i1 == 2131440965) || (i1 == 2131440964) || (i1 == 2131440958)) {
      a(paramView.getContext());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder
 * JD-Core Version:    0.7.0.1
 */