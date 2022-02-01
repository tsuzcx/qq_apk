package com.tencent.biz.qqcircle.fragments.troop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleAggregationBean;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;

public class QCircleTroopAggregationBodyPart
  extends QCircleBaseBlockPart
{
  private QCircleTroopAggregationFeedViewModel b;
  private QCircleAggregationBean e;
  private QCircleInsFeedAdapter f;
  private QCirclePolyLikeAniView g;
  private View h;
  private QCircleFullScreenStatusView i;
  private boolean j;
  private RefreshHeaderView k;
  
  public QCircleTroopAggregationBodyPart(int paramInt)
  {
    super(paramInt, null, 1, 1);
  }
  
  private void a(ResponseBean paramResponseBean)
  {
    if ((paramResponseBean.c instanceof FeedCloudRead.StGetFeedListRsp))
    {
      if (d(paramResponseBean))
      {
        c(paramResponseBean);
        this.j = true;
        return;
      }
      paramResponseBean = this.i;
      if (paramResponseBean != null) {
        paramResponseBean.c();
      }
      this.j = false;
    }
  }
  
  private void b(View paramView)
  {
    this.g = ((QCirclePolyLikeAniView)paramView.findViewById(2131441777));
    this.h = paramView.findViewById(2131440940);
    this.h.setOnClickListener(new QCircleTroopAggregationBodyPart.1(this));
    if (bd_() != null) {
      bd_().a(this.h);
    }
  }
  
  private void b(ResponseBean paramResponseBean)
  {
    if ((paramResponseBean.c instanceof FeedCloudRead.StGetFeedListRsp))
    {
      FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = (FeedCloudRead.StGetFeedListRsp)paramResponseBean.c;
      long l = paramResponseBean.a;
      boolean bool = false;
      int m;
      if (l == 0L) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0) {
        if (paramResponseBean.d) {
          this.f.addAll(QCircleTransFormHelper.a(localStGetFeedListRsp.vecFeed.get()));
        } else {
          this.f.setDatas(QCircleTransFormHelper.a(localStGetFeedListRsp.vecFeed.get()));
        }
      }
      paramResponseBean = this.f;
      if ((paramResponseBean.getLoadInfo().a()) || (m == 0)) {
        bool = true;
      }
      paramResponseBean.notifyLoadingComplete(true, bool);
    }
  }
  
  private void c(ResponseBean paramResponseBean)
  {
    QCircleFullScreenStatusView localQCircleFullScreenStatusView = this.i;
    if (localQCircleFullScreenStatusView != null)
    {
      localQCircleFullScreenStatusView.b(paramResponseBean.b);
      QLog.w("BlockPart", 1, String.format("retCode:%s; msg:%s", new Object[] { Long.valueOf(paramResponseBean.a), paramResponseBean.b }));
      this.f.clearData();
      this.f.notifyDataSetChanged();
    }
  }
  
  private boolean d(ResponseBean paramResponseBean)
  {
    return (!paramResponseBean.d) && (paramResponseBean.a != 0L);
  }
  
  private void l()
  {
    this.i = new QCircleFullScreenStatusView(g());
    this.i.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    this.i.setEmptyImageAndText(QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed"), QCircleConfigHelper.T(), QCircleConfigHelper.Q());
    this.i.setOnRetryClickListener(new QCircleTroopAggregationBodyPart.2(this));
    be_().setStatusViewInterface(this.i);
  }
  
  private void m()
  {
    this.f = new QCircleInsFeedAdapter(new Bundle());
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    localQCircleExtraTypeInfo.pageType = 70;
    this.f.a(localQCircleExtraTypeInfo);
    this.f.setInteractor(q());
    this.f.b(true);
    QCircleAggregationBean localQCircleAggregationBean = this.e;
    if (localQCircleAggregationBean != null) {
      localQCircleAggregationBean.setExtraTypeInfo(localQCircleExtraTypeInfo);
    }
    this.f.setOnLoadDataDelegate(new QCircleTroopAggregationBodyPart.3(this));
    this.f.setReportBean(d());
    this.c.add(this.f);
  }
  
  private void n()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      QLog.d("BlockPart", 2, "showRefreshHeaderView feed adapter is null.");
      return;
    }
    if (((QCircleInsFeedAdapter)localObject).getItemCount() > 0) {
      return;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((RefreshHeaderView)localObject).setState(4);
      this.k.setVisibility(0);
    }
  }
  
  private void o()
  {
    RefreshHeaderView localRefreshHeaderView = this.k;
    if ((localRefreshHeaderView != null) && (localRefreshHeaderView.getVisibility() == 0))
    {
      this.k.setState(0);
      this.k.setVisibility(8);
    }
  }
  
  private void p()
  {
    this.b.b().observe(bd_(), new QCircleTroopAggregationBodyPart.4(this));
  }
  
  private QCircleInteractor q()
  {
    return new QCircleTroopAggregationBodyPart.5(this);
  }
  
  public void a(View paramView)
  {
    this.b = ((QCircleTroopAggregationFeedViewModel)a(QCircleTroopAggregationFeedViewModel.class));
    if ((c() != null) && (c().getIntent() != null)) {
      this.e = ((QCircleAggregationBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    }
    this.k = ((RefreshHeaderView)paramView.findViewById(2131444556));
    m();
    super.a(paramView);
    b(paramView);
    l();
    p();
    be_().setEnableRefresh(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.troop.QCircleTroopAggregationBodyPart
 * JD-Core Version:    0.7.0.1
 */