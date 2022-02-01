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
import android.widget.RelativeLayout;
import android.widget.TextView;
import bpxb;
import com.tencent.biz.pubaccount.readinjoy.model.CommunityConfigInfo;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ois;
import pfd;
import pfh;
import pns;
import stf;
import stg;
import sth;
import sti;
import stj;
import stl;

public class ReadInJoyDiandianHeaderController
  extends stf
{
  public int a;
  public Context a;
  public ColorDrawable a;
  public Handler a;
  protected View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected RelativeLayout a;
  protected TextView a;
  private ReadInJoyDiandianHeaderController.ViewPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter;
  public DisableSlideHorizontalListView a;
  private RollViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager;
  public String a;
  public List<CommunityConfigInfo> a;
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ois jdField_a_of_type_Ois;
  private pfh jdField_a_of_type_Pfh = new sth(this);
  private boolean jdField_a_of_type_Boolean;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private View jdField_b_of_type_AndroidViewView;
  protected TextView b;
  private List<DiandianTopConfig> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private View jdField_c_of_type_AndroidViewView;
  private List<MeasureGridView> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private List<Long> d = new ArrayList();
  
  public ReadInJoyDiandianHeaderController(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidOsHandler = new stg(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560160, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379204);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager = ((RollViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131381075));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter = new ReadInJoyDiandianHeaderController.ViewPagerAdapter(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnPageChangeListener(new ReadInJoyDiandianHeaderController.RollerChangeListener(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnTouchStateChangeListener(new sti(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131364909));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364912));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371398));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364910));
    bpxb localbpxb = new bpxb(this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator());
    localbpxb.a(600);
    localbpxb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131367969);
    pfd.a().a(this.jdField_a_of_type_Pfh);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378202));
    this.jdField_a_of_type_Ois = new ois((Activity)paramContext, this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  private View a(int paramInt)
  {
    MeasureGridView localMeasureGridView = new MeasureGridView(this.jdField_a_of_type_AndroidContentContext);
    localMeasureGridView.setSelector(new ColorDrawable(0));
    stl localstl = new stl(this, this.jdField_b_of_type_JavaUtilList, paramInt);
    localMeasureGridView.setNumColumns(2);
    localMeasureGridView.setAdapter(localstl);
    return localMeasureGridView;
  }
  
  private void h()
  {
    pns.a().a();
  }
  
  public void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_b_of_type_AndroidViewView, 2);
    h();
  }
  
  public void b()
  {
    pfd.a().b(this.jdField_a_of_type_Pfh);
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
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnScrollStateChangedListener(new stj(this));
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 3000L);
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController
 * JD-Core Version:    0.7.0.1
 */