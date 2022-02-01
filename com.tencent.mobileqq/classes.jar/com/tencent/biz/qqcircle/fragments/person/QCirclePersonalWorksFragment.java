package com.tencent.biz.qqcircle.fragments.person;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleTimeLineAndGridFeedAdapter;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.AddAnimationConfig;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;

public class QCirclePersonalWorksFragment
  extends QCirclePersonalBaseBottomFragment
{
  private void H()
  {
    VideoReport.setElementId(this.D, "em_xsj_profile_product_tab");
  }
  
  public boolean E()
  {
    return QCirclePluginUtil.d(this.f);
  }
  
  protected QCircleFakeAdapter F()
  {
    this.e = new QCircleTimeLineAndGridFeedAdapter(new Bundle(), c(2));
    this.e.setReportBean(n());
    return this.e;
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
    return "QCirclePersonalWorksFragment";
  }
  
  public void b(int paramInt)
  {
    if ((this.c != null) && (this.c.i() != null) && ((this.c.i().getLayoutManager() instanceof GridLayoutManager)))
    {
      ((GridLayoutManager)this.c.i().getLayoutManager()).setSpanCount(c(paramInt));
      Object localObject = new EnhanceItemAnimator();
      EnhanceItemAnimator.AddAnimationConfig localAddAnimationConfig = new EnhanceItemAnimator.AddAnimationConfig();
      localAddAnimationConfig.a = 2;
      localAddAnimationConfig.b = (ImmersiveUtils.b() - 180);
      localAddAnimationConfig.c = (ImmersiveUtils.c() + 360);
      ((EnhanceItemAnimator)localObject).a(localAddAnimationConfig);
      ((EnhanceItemAnimator)localObject).setAddDuration(200L);
      this.c.i().getRecyclerView().setItemAnimator((RecyclerView.ItemAnimator)localObject);
      if ((this.e instanceof QCircleTimeLineAndGridFeedAdapter))
      {
        localObject = (QCircleTimeLineAndGridFeedAdapter)this.e;
        ((QCircleTimeLineAndGridFeedAdapter)localObject).d(c(paramInt));
        int i = this.e.getItemCount();
        boolean bool = false;
        ((QCircleTimeLineAndGridFeedAdapter)localObject).notifyItemRangeChanged(0, i);
        if (paramInt == 2) {
          bool = true;
        }
        ((QCircleTimeLineAndGridFeedAdapter)localObject).b(bool);
      }
    }
  }
  
  public int c(int paramInt)
  {
    if (paramInt == 2) {
      return 1;
    }
    if (paramInt == 1) {
      return 3;
    }
    return 1;
  }
  
  protected List<Part> d()
  {
    x();
    ArrayList localArrayList = new ArrayList();
    this.c = new BlockPart(2131431490, y(), 2, 1);
    localArrayList.add(this.c);
    return localArrayList;
  }
  
  protected void u()
  {
    this.g = getString(2131895819);
    Object localObject = new QCirclePersonalBottomStatusView(getActivity());
    ((QCirclePersonalBottomStatusView)localObject).setDescAndActionText(QCircleConfigHelper.B(), QCircleConfigHelper.C(), QCircleConfigHelper.H(), QCircleConfigHelper.I());
    ((QCirclePersonalBottomStatusView)localObject).setReportBean(n());
    this.c.i().setStatusViewInterface((IStatusViewProvider)localObject);
    if ((this.e instanceof QCircleTimeLineAndGridFeedAdapter))
    {
      localObject = new QCircleExtraTypeInfo();
      ((QCircleExtraTypeInfo)localObject).pageType = 11;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(8);
      localStringBuilder.append(this.f);
      ((QCircleExtraTypeInfo)localObject).mGlobalViewModelKey = localStringBuilder.toString();
      ((QCircleTimeLineAndGridFeedAdapter)this.e).a((QCircleExtraTypeInfo)localObject);
    }
    if (D() != null)
    {
      this.d = ((QCirclePersonalDetailViewModel)getViewModel(D(), null, QCirclePersonalDetailViewModel.class));
      this.d.d().observe(D(), new QCirclePersonalWorksFragment.1(this));
      this.d.e().observe(D(), new QCirclePersonalWorksFragment.2(this));
    }
    this.c.i().getRecyclerView().setNestedScrollingEnabled(true);
    this.c.i().getBlockMerger().b(5);
    this.c.i().getRecyclerView().setItemAnimator(null);
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
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalWorksFragment
 * JD-Core Version:    0.7.0.1
 */