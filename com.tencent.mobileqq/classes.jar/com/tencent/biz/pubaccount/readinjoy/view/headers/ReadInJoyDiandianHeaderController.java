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
import bops;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import osb;
import pvm;
import pvq;
import qdx;
import tkq;
import tkr;
import tks;
import tkt;
import tku;

public class ReadInJoyDiandianHeaderController
  extends tkq
{
  public int a;
  public Context a;
  public ColorDrawable a;
  public Handler a;
  protected View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ReadInJoyDiandianHeaderController.ViewPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter;
  private RollViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager;
  private List<DiandianTopConfig> jdField_a_of_type_JavaUtilList = new ArrayList();
  private osb jdField_a_of_type_Osb;
  private pvq jdField_a_of_type_Pvq = new tks(this);
  private boolean jdField_a_of_type_Boolean = true;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private View jdField_b_of_type_AndroidViewView;
  private List<MeasureGridView> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private View c;
  
  public ReadInJoyDiandianHeaderController(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidOsHandler = new tkr(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560213, null);
    this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131379267);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager = ((RollViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131381152));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter = new ReadInJoyDiandianHeaderController.ViewPagerAdapter(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnPageChangeListener(new ReadInJoyDiandianHeaderController.RollerChangeListener(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnTouchStateChangeListener(new tkt(this));
    bops localbops = new bops(this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator());
    localbops.a(600);
    localbops.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131368138);
    pvm.a().a(this.jdField_a_of_type_Pvq);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378260));
    this.jdField_a_of_type_Osb = new osb((Activity)paramContext, this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  private View a(int paramInt)
  {
    MeasureGridView localMeasureGridView = new MeasureGridView(this.jdField_a_of_type_AndroidContentContext);
    localMeasureGridView.setSelector(new ColorDrawable(0));
    tku localtku = new tku(this, this.jdField_a_of_type_JavaUtilList, paramInt);
    localMeasureGridView.setNumColumns(2);
    localMeasureGridView.setAdapter(localtku);
    return localMeasureGridView;
  }
  
  private void h()
  {
    qdx.a().a();
  }
  
  public void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_b_of_type_AndroidViewView, 2);
    h();
  }
  
  public void b()
  {
    pvm.a().b(this.jdField_a_of_type_Pvq);
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
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 3000L);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController
 * JD-Core Version:    0.7.0.1
 */