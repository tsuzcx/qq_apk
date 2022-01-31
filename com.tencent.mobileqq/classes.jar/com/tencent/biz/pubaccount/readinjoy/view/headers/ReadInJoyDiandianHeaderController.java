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
import bjlp;
import com.tencent.biz.pubaccount.readinjoy.model.CommunityConfigInfo;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import noo;
import nuo;
import osm;
import osp;
import oyy;
import rny;
import rnz;
import roa;
import rob;
import roc;
import roe;
import rof;
import roi;

public class ReadInJoyDiandianHeaderController
  extends rny
{
  public int a;
  public Context a;
  public ColorDrawable a;
  public Handler a;
  protected View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public RelativeLayout a;
  public TextView a;
  private ReadInJoyDiandianHeaderController.ViewPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter;
  public DisableSlideHorizontalListView a;
  private RollViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager;
  public String a;
  public List<CommunityConfigInfo> a;
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nuo jdField_a_of_type_Nuo;
  private osp jdField_a_of_type_Osp = new roa(this);
  public rof a;
  private boolean jdField_a_of_type_Boolean;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private View jdField_b_of_type_AndroidViewView;
  public TextView b;
  public String b;
  private List<DiandianTopConfig> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private View jdField_c_of_type_AndroidViewView;
  public String c;
  private List<MeasureGridView> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  public String d;
  private List<Long> d = new ArrayList();
  
  public ReadInJoyDiandianHeaderController(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidOsHandler = new rnz(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559907, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131377597);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager = ((RollViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131379177));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter = new ReadInJoyDiandianHeaderController.ViewPagerAdapter(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnPageChangeListener(new ReadInJoyDiandianHeaderController.RollerChangeListener(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnTouchStateChangeListener(new rob(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131364568));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364571));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370411));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364569));
    bjlp localbjlp = new bjlp(this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator());
    localbjlp.a(600);
    localbjlp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131367451);
    osm.a().a(this.jdField_a_of_type_Osp);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131376668));
    this.jdField_a_of_type_Nuo = new nuo((Activity)paramContext, this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  private View a(int paramInt)
  {
    MeasureGridView localMeasureGridView = new MeasureGridView(this.jdField_a_of_type_AndroidContentContext);
    localMeasureGridView.setSelector(new ColorDrawable(0));
    roi localroi = new roi(this, this.jdField_b_of_type_JavaUtilList, paramInt);
    localMeasureGridView.setNumColumns(2);
    localMeasureGridView.setAdapter(localroi);
    return localMeasureGridView;
  }
  
  private void i()
  {
    oyy.a().a();
  }
  
  public void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_b_of_type_AndroidViewView, 2);
    i();
  }
  
  public void b()
  {
    osm.a().b(this.jdField_a_of_type_Osp);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
    h();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnScrollStateChangedListener(new roe(this));
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 3000L);
  }
  
  public void g()
  {
    oyy.a().a(this.d, new roc(this));
    if (this.jdField_a_of_type_JavaUtilSet.size() != 0)
    {
      noo.a(null, "", "0X8009B9E", "0X8009B9E", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", this.jdField_a_of_type_JavaUtilSet.size() + "", "", false);
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController
 * JD-Core Version:    0.7.0.1
 */