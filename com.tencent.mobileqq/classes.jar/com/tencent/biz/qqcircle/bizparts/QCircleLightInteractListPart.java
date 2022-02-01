package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.IStatusListener;
import com.tencent.biz.qqcircle.viewmodels.QCircleLightInteractViewModel;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QCircleLightInteractListPart
  extends QCircleBasePart
{
  private QCircleSlidBottomView a;
  private QCircleBlockContainer c;
  private FrameLayout d;
  private ImageView e;
  private QCircleLightInteractListPart.LightInteractListAdapter f;
  private FeedBlockData g;
  private FeedCloudMeta.StFeed h;
  private int i;
  private QCircleLightInteractViewModel j;
  private QCircleStatusView k;
  private QCirclePanelLoadingView l;
  private QCircleExtraTypeInfo m = new QCircleExtraTypeInfo();
  private int n;
  private String o;
  private ReportBean<QCircleReportBean> p;
  private ViewStub q;
  
  private void a(UIStateData<List<FeedCloudMeta.StLightInteractInfo>> paramUIStateData)
  {
    QCirclePanelLoadingView localQCirclePanelLoadingView = this.l;
    if (localQCirclePanelLoadingView != null) {
      localQCirclePanelLoadingView.b();
    }
    int i1 = paramUIStateData.c();
    if (i1 != 0) {
      if ((i1 != 2) && (i1 != 3))
      {
        if (i1 == 4) {}
      }
      else
      {
        c(paramUIStateData);
        return;
      }
    }
    b(paramUIStateData);
  }
  
  private void b(UIStateData<List<FeedCloudMeta.StLightInteractInfo>> paramUIStateData)
  {
    String str;
    if (paramUIStateData.c() == 4) {
      str = HardCodeUtil.a(2131895889);
    } else {
      str = HardCodeUtil.a(2131895701);
    }
    if ((!paramUIStateData.i()) && (this.f.getItemCount() <= 0))
    {
      this.f.clearData();
      this.k.setVisibility(0);
      a(false, false, false);
      this.k.b(str);
      return;
    }
    this.k.setVisibility(8);
    a(false, true, false);
  }
  
  private void c(UIStateData<List<FeedCloudMeta.StLightInteractInfo>> paramUIStateData)
  {
    if (paramUIStateData.e() != null)
    {
      if (!paramUIStateData.i())
      {
        this.k.setVisibility(8);
        if (this.a.g()) {
          this.f.a((List)paramUIStateData.e(), this.h, this.i);
        }
      }
      else if (this.a.g())
      {
        this.k.setVisibility(8);
        this.f.a((List)paramUIStateData.e());
      }
      a(true, paramUIStateData.i(), paramUIStateData.h());
    }
  }
  
  private void i()
  {
    if (F() != null)
    {
      if (this.q != null) {
        return;
      }
      QCircleLightInteractListPart.1 local1 = new QCircleLightInteractListPart.1(this);
      this.q = ((ViewStub)F().findViewById(2131441721));
      this.a = ((QCircleSlidBottomView)this.q.inflate().findViewById(2131441721));
      this.e = ((ImageView)this.a.findViewById(2131441725));
      this.a.setOnClickListener(local1);
      this.a.setStatusListener(l());
      if ((QCirclePluginUtil.d(f())) && (QCircleHostGlobalInfo.isCurrentTabActive())) {
        this.a.a(HostUIHelper.getInstance().getHostTabHeight());
      }
      this.c = ((QCircleBlockContainer)this.a.findViewById(2131441724));
      this.e.setOnClickListener(local1);
      this.d = ((FrameLayout)this.a.findViewById(2131441606));
      this.k = ((QCircleStatusView)this.a.findViewById(2131441722));
      this.l = ((QCirclePanelLoadingView)this.a.findViewById(2131441723));
      m();
    }
  }
  
  @NonNull
  private QCircleSlidBottomView.IStatusListener l()
  {
    return new QCircleLightInteractListPart.2(this);
  }
  
  private void m()
  {
    new LinearLayoutManager(F().getContext()).setOrientation(1);
    this.c.setLayoutManagerType(1, 1);
    this.c.getBlockMerger().b(2);
    this.c.setEnableLoadMore(true);
    this.c.setEnableRefresh(false);
    this.c.setParentFragment(j());
    this.c.getRecyclerView().setNestedScrollingEnabled(true);
    ArrayList localArrayList = new ArrayList();
    this.f = new QCircleLightInteractListPart.LightInteractListAdapter(this, null);
    localArrayList.add(this.f);
    this.f.setOnLoadDataDelegate(new QCircleLightInteractListPart.3(this));
    this.c.a(localArrayList);
    this.c.getRecyclerView().addOnScrollListener(new QCircleLightInteractListPart.4(this));
    this.f.a(this.c.getRecyclerView());
    this.c.g();
  }
  
  private void n()
  {
    FrameLayout localFrameLayout = this.d;
    if (localFrameLayout == null) {
      return;
    }
    if (this.n == 1) {
      localObject = "em_xsj_rockets_list";
    } else {
      localObject = "em_xsj_likes_list";
    }
    VideoReport.setElementId(localFrameLayout, (String)localObject);
    Object localObject = new QCircleDTParamBuilder().buildElementParams();
    ((Map)localObject).putAll(QCirclePluginReportUtil.a(this.g));
    ((Map)localObject).put("xsj_parent_emid", "em_xsj_feed");
    ((Map)localObject).put("xsj_feed_index", Integer.valueOf(this.i + 1));
    VideoReport.setElementParams(this.d, (Map)localObject);
    VideoReport.traverseExposure();
  }
  
  private void o()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.h.id.get());
    ((StringBuilder)localObject).append(this.n);
    this.j = ((QCircleLightInteractViewModel)a(((StringBuilder)localObject).toString(), QCircleLightInteractViewModel.class));
    localObject = this.j;
    if (localObject == null) {
      return;
    }
    ((QCircleLightInteractViewModel)localObject).b().removeObservers(j());
    this.j.b().observe(j(), new QCircleLightInteractListPart.5(this));
    this.j.a(this.h, false, false, this.n, this.o);
  }
  
  public String a()
  {
    return "QCircleLightInteractListPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(j(), paramView, E());
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.p = paramReportBean;
  }
  
  public void a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof QCircleLightInteractListPart.QCirclePolyListShowData))
    {
      i();
      paramObject = (QCircleLightInteractListPart.QCirclePolyListShowData)paramObject;
      this.h = paramObject.b;
      this.g = paramObject.a;
      this.i = paramObject.d;
      this.o = paramObject.c;
      this.n = paramObject.e;
    }
    if (paramString.equals("light_interact_list_show"))
    {
      paramString = this.m;
      paramString.mFeed = this.h;
      paramString.mPlayScene = 1;
      paramString.mDataPosition = (this.i + 1);
      this.c.getBlockMerger().l();
      this.f.clearData();
      if (!HostNetworkUtils.isNetworkAvailable())
      {
        this.k.b("");
      }
      else
      {
        o();
        paramString = this.l;
        if (paramString != null)
        {
          paramObject = this.a;
          if (paramObject != null)
          {
            paramString.a(paramObject.getPanelHeight());
            this.k.setVisibility(8);
          }
        }
      }
      if (this.a != null)
      {
        if (QCircleConfigHelper.bg()) {
          this.a.a();
        }
        this.a.a(this.d);
        paramString = this.m;
        if ((paramString != null) && (paramString.mFeed != null))
        {
          paramString = QCirclePluginReportUtil.b(this.m.mFeed);
          int i1;
          if (this.n == 1) {
            i1 = 87;
          } else {
            i1 = 70;
          }
          QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramString.setActionType(i1).setSubActionType(1).setToUin(this.m.mFeed.poster.id.get()).setIndex(this.m.mDataPosition).setPageId(f())));
        }
      }
      n();
      return;
    }
    if (paramString.equals("light_interact_list_dismiss"))
    {
      paramString = this.a;
      if (paramString != null) {
        paramString.f();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.c != null) && (this.f.getBlockMerger() != null))
    {
      this.f.getLoadInfo().a(4);
      this.f.getLoadInfo().a(paramBoolean3);
      this.c.setRefreshing(false);
      this.f.getBlockMerger().a(false);
      this.f.getBlockMerger().b("");
      this.f.getBlockMerger().a(paramBoolean1, paramBoolean3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("iscuccess:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isfinish:");
      localStringBuilder.append(paramBoolean3);
      QLog.d("QCircleLightInteractListPart", 4, localStringBuilder.toString());
    }
  }
  
  public boolean ah_()
  {
    QCircleSlidBottomView localQCircleSlidBottomView = this.a;
    if ((localQCircleSlidBottomView != null) && (localQCircleSlidBottomView.getVisibility() == 0))
    {
      this.a.f();
      return true;
    }
    return super.ah_();
  }
  
  public QCircleReportBean d()
  {
    if (this.b != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractListPart", this.b).clone();
    }
    ReportBean localReportBean = this.p;
    if (localReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractListPart", (QCircleReportBean)localReportBean.getReportBean()).clone();
    }
    return null;
  }
  
  protected int f()
  {
    if (this.b != null) {
      return QCircleReportBean.getPageId("QCircleLightInteractListPart", this.b);
    }
    ReportBean localReportBean = this.p;
    if (localReportBean != null) {
      return QCircleReportBean.getPageId("QCircleLightInteractListPart", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart
 * JD-Core Version:    0.7.0.1
 */