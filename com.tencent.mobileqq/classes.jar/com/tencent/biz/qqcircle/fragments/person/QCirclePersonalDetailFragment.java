package com.tencent.biz.qqcircle.fragments.person;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uxh;
import uyp;
import uyr;
import uzb;
import vab;
import vbt;
import vcb;
import vcw;
import vdc;
import vde;
import vec;
import veh;
import vno;
import vnp;
import vnq;
import vnr;
import vns;
import vol;
import vrf;
import vri;
import vrr;
import vrt;
import vuf;
import zlx;
import zxi;
import zxj;
import zxu;
import zzk;

public class QCirclePersonalDetailFragment
  extends QCircleBaseFragment
{
  private static int c;
  private int jdField_a_of_type_Int;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private String jdField_a_of_type_JavaLangString;
  private uyp jdField_a_of_type_Uyp;
  public uyr a;
  private vab jdField_a_of_type_Vab;
  private vbt jdField_a_of_type_Vbt;
  private vcb jdField_a_of_type_Vcb;
  public vde a;
  private vns jdField_a_of_type_Vns;
  private final vol jdField_a_of_type_Vol = vol.a();
  private vuf jdField_a_of_type_Vuf;
  protected zxi a;
  private int b;
  
  private uzb a()
  {
    return new vnr(this);
  }
  
  private void a(int paramInt)
  {
    int i = 255;
    this.jdField_a_of_type_Int += paramInt;
    float f = this.jdField_a_of_type_Int * 1.0F / this.b;
    QLog.d("QCirclePersonalDetailFragment", 1, "computeShowTitleBarAnimation  dy:" + paramInt + "  mDistance:" + this.jdField_a_of_type_Int + "  percent:" + f);
    paramInt = (int)(f * 255.0F);
    if (paramInt > 255) {
      paramInt = i;
    }
    for (;;)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      this.jdField_a_of_type_Vcb.a("personal_page_action_title_bar_animation", localMessage);
      return;
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vuf != null) {
      this.jdField_a_of_type_Vuf.a(this.jdField_a_of_type_JavaLangString, paramBoolean);
    }
  }
  
  private List<zxu> b()
  {
    ArrayList localArrayList = new ArrayList();
    uzb localuzb = a();
    this.jdField_a_of_type_Uyr = new uyr(new Bundle());
    this.jdField_a_of_type_Uyr.a(a());
    this.jdField_a_of_type_Uyr.setInteractor(localuzb);
    this.jdField_a_of_type_Uyr.setOnLoadDataDelegate(new vnq(this));
    this.jdField_a_of_type_Uyp = new uyp(getActivity().getIntent().getExtras());
    this.jdField_a_of_type_Uyp.a(a());
    this.jdField_a_of_type_Uyp.setInteractor(localuzb);
    this.jdField_a_of_type_Uyp.a(a());
    localArrayList.add(this.jdField_a_of_type_Uyr);
    localArrayList.add(this.jdField_a_of_type_Uyp);
    return localArrayList;
  }
  
  private void b(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    this.jdField_a_of_type_Vcb.a("personal_page_action_title_bar_follow_animation", localMessage);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vuf != null) {
      this.jdField_a_of_type_Vuf.b(this.jdField_a_of_type_JavaLangString, paramBoolean);
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_Uyr != null)) {
      this.jdField_a_of_type_Uyr.setDatas(new ArrayList(Arrays.asList(new FeedCloudMeta.StUser[] { this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser })));
    }
    if ((zzk.a("2001" + this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Vuf != null))
    {
      this.jdField_a_of_type_Vuf.d("2001" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    a(true);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Int = 0;
    a(0);
  }
  
  private void f()
  {
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Vns = new vns(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Vns, localIntentFilter);
    }
  }
  
  public int a()
  {
    return 2131560744;
  }
  
  public List<zxj> a()
  {
    a();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Zxi = new zxi(2131365145, b(), 3, 1);
    this.jdField_a_of_type_Vcb = new vcb(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean);
    this.jdField_a_of_type_Vcb.a(a());
    this.jdField_a_of_type_Vde = new vde();
    this.jdField_a_of_type_Vde.a(this);
    Object localObject = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject).id.set(this.jdField_a_of_type_JavaLangString);
    localArrayList.add(this.jdField_a_of_type_Zxi);
    localArrayList.add(this.jdField_a_of_type_Vcb);
    localArrayList.add(this.jdField_a_of_type_Vde);
    localObject = new vcw((FeedCloudMeta.StUser)localObject);
    ((vcw)localObject).a(this);
    localArrayList.add(localObject);
    localArrayList.add(new vec());
    vec localvec = new vec();
    localvec.a(a());
    localArrayList.add(localvec);
    ((vcw)localObject).a(4);
    this.jdField_a_of_type_Vbt = new vbt();
    this.jdField_a_of_type_Vbt.a(this);
    localArrayList.add(this.jdField_a_of_type_Vbt);
    this.jdField_a_of_type_Vab = new vab();
    this.jdField_a_of_type_Vab.a(this);
    localArrayList.add(this.jdField_a_of_type_Vab);
    localArrayList.add(new veh());
    localArrayList.add(new vdc());
    return localArrayList;
  }
  
  public zxi a()
  {
    return this.jdField_a_of_type_Zxi;
  }
  
  protected void a()
  {
    if (getActivity() == null) {}
    do
    {
      Intent localIntent;
      do
      {
        return;
        localIntent = getActivity().getIntent();
      } while ((localIntent == null) || (!localIntent.hasExtra("key_bundle_common_init_bean")));
      this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
    } while ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean == null) || (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser().id.get())));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser().id.get();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser();
    vrf.a(this.jdField_a_of_type_JavaLangString, 11, 1, 0, c());
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    c();
    d();
    c(true);
    f();
    vrr.a().a(new vrt().a("main").b("impression").a(a()));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Vuf = ((vuf)a(vuf.class));
    this.jdField_a_of_type_Vuf.a().observe(this, new vno(this));
  }
  
  public int c()
  {
    return 32;
  }
  
  public String c()
  {
    return "QCirclePersonalDetailFragment";
  }
  
  protected void c()
  {
    this.b = zlx.a(getActivity(), 200.0F);
    this.jdField_a_of_type_Zxi.a().setEnableRefresh(true);
    this.jdField_a_of_type_Zxi.a().setEnableLoadMore(false);
    this.jdField_a_of_type_Zxi.a().setParentFragment(this);
    this.jdField_a_of_type_Zxi.a().a().setBackgroundColor(getResources().getColor(2131166233));
    this.jdField_a_of_type_Zxi.a().a().addOnScrollListener(new vnp(this));
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Uyp != null)
    {
      if (this.jdField_a_of_type_Uyp.a() == 0) {
        return "profile_page";
      }
      if (this.jdField_a_of_type_Uyp.a() == 1) {
        return "profile_moment";
      }
      if (this.jdField_a_of_type_Uyp.a() == 2) {
        return "profile_pushed";
      }
    }
    return "profile_page";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (vri.a().d()) {
      vri.a().a(c(), getActivity().getIntent());
    }
    vri.a().a(c());
    this.jdField_a_of_type_Vol.a();
    int i = c;
    c = i + 1;
    if (i == 0) {
      this.jdField_a_of_type_Vol.b();
    }
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_Vns != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Vns);
    }
    c -= 1;
    uxh.a();
  }
  
  public void onDetach()
  {
    super.onDetach();
    vri.a().b(c());
  }
  
  public void onPause()
  {
    super.onPause();
    vri.a().d(c());
  }
  
  public void onResume()
  {
    super.onResume();
    vri.a().c(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */