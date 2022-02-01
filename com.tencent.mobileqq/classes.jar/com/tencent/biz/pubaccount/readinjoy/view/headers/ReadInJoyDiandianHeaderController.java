package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.SubscribedListHeaderController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.widget.ListView;
import dov.com.qq.im.capture.view.ViewPagerScroller;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDiandianHeaderController
  extends HeaderViewController
{
  protected int a;
  protected Context a;
  public ColorDrawable a;
  protected Handler a;
  protected View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private SubscribedListHeaderController jdField_a_of_type_ComTencentBizPubaccountReadinjoySubscribedListHeaderController;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyDiandianHeaderController.2(this);
  private ReadInJoyDiandianHeaderController.ViewPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter;
  private RollViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager;
  private List<DiandianTopConfig> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private View jdField_b_of_type_AndroidViewView;
  private List<MeasureGridView> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private View c;
  
  public ReadInJoyDiandianHeaderController(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidOsHandler = new ReadInJoyDiandianHeaderController.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560290, null);
    this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131379702);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager = ((RollViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131381619));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter = new ReadInJoyDiandianHeaderController.ViewPagerAdapter(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnPageChangeListener(new ReadInJoyDiandianHeaderController.RollerChangeListener(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnTouchStateChangeListener(new ReadInJoyDiandianHeaderController.3(this));
    ViewPagerScroller localViewPagerScroller = new ViewPagerScroller(this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator());
    localViewPagerScroller.a(600);
    localViewPagerScroller.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131368359);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378686));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySubscribedListHeaderController = new SubscribedListHeaderController((Activity)paramContext, this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  private View a(int paramInt)
  {
    MeasureGridView localMeasureGridView = new MeasureGridView(this.jdField_a_of_type_AndroidContentContext);
    localMeasureGridView.setSelector(new ColorDrawable(0));
    ReadInJoyDiandianHeaderController.HeaderListAdapter localHeaderListAdapter = new ReadInJoyDiandianHeaderController.HeaderListAdapter(this, this.jdField_a_of_type_JavaUtilList, paramInt);
    localMeasureGridView.setNumColumns(2);
    localMeasureGridView.setAdapter(localHeaderListAdapter);
    return localMeasureGridView;
  }
  
  private void h()
  {
    DiandianTopConfigManager.a().a();
  }
  
  protected void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_b_of_type_AndroidViewView, 2);
    h();
  }
  
  public void b()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
    g();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 3000L);
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController
 * JD-Core Version:    0.7.0.1
 */