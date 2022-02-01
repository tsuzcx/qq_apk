package com.tencent.biz.qqcircle.fragments.person;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;

public class QCirclePersonalDynamicFragment
  extends QCirclePersonalBaseBottomFragment
{
  private void H()
  {
    VideoReport.setElementId(this.D, "em_xsj_profile_dynamics_tab");
  }
  
  public boolean E()
  {
    return QCirclePluginUtil.d(this.f);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((QCirclePluginUtil.d(this.f)) && (this.e != null) && (!this.e.f()) && (this.e.getDataList() != null) && (this.e.getDataList().size() == 0)) {
      D().p().a("personal_page_show_publish_guide", Boolean.valueOf(true));
    }
  }
  
  public String b()
  {
    return "QCirclePersonalDynamicFragment";
  }
  
  protected void u()
  {
    this.g = getString(2131895819);
    Object localObject = new QCirclePersonalBottomStatusView(getActivity());
    ((QCirclePersonalBottomStatusView)localObject).setDescAndActionText(QCircleConfigHelper.D(), QCircleConfigHelper.E(), QCircleConfigHelper.J(), QCircleConfigHelper.K());
    ((QCirclePersonalBottomStatusView)localObject).setReportBean(n());
    this.c.i().setStatusViewInterface((IStatusViewProvider)localObject);
    if ((this.e instanceof QCircleInsFeedAdapter))
    {
      localObject = new QCircleExtraTypeInfo();
      ((QCircleExtraTypeInfo)localObject).pageType = 8;
      ((QCircleExtraTypeInfo)localObject).mCurrentPersonalUin = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(8);
      localStringBuilder.append(this.f);
      ((QCircleExtraTypeInfo)localObject).mGlobalViewModelKey = localStringBuilder.toString();
      ((QCircleInsFeedAdapter)this.e).a((QCircleExtraTypeInfo)localObject);
      ((QCircleInsFeedAdapter)this.e).a(1);
    }
    if (D() != null)
    {
      this.d = ((QCirclePersonalDetailViewModel)getViewModel(D(), null, QCirclePersonalDetailViewModel.class));
      this.d.d().observe(D(), new QCirclePersonalDynamicFragment.1(this));
      this.d.e().observe(D(), new QCirclePersonalDynamicFragment.2(this));
    }
    this.c.i().getRecyclerView().setNestedScrollingEnabled(true);
    H();
  }
  
  protected void w()
  {
    if (this.d != null) {
      this.d.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDynamicFragment
 * JD-Core Version:    0.7.0.1
 */