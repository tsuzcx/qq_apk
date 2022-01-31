package com.tencent.biz.qqcircle.component;

import alpo;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.SubScribeSwipeRefreshLayout;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import tvh;
import tvk;
import tvl;
import yds;
import yea;

public class ComponentPageView
  extends com.tencent.biz.subscribe.component.base.ComponentPageView
{
  private QCircleStatusView a;
  
  public ComponentPageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentPageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentPageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    return 2131560524;
  }
  
  public QCircleStatusView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  }
  
  public void a()
  {
    ((tvh)this.jdField_a_of_type_Yds).R_();
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)findViewById(2131364666));
    this.jdField_a_of_type_Yds.a(alpo.a(2131698344));
  }
  
  public void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131364070));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setNestedScrollingEnabled(false);
    this.jdField_a_of_type_Yds = new tvh(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setAdapter(this.jdField_a_of_type_Yds);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.addItemDecoration(new yea(this, this.jdField_a_of_type_Yds));
    setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.addOnScrollListener(new tvk(this));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout = ((SubScribeSwipeRefreshLayout)findViewById(2131376915));
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.setOnRefreshListener(new tvl(this));
    }
    a(paramFrameLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.component.ComponentPageView
 * JD-Core Version:    0.7.0.1
 */