package com.tencent.biz.qqcircle.fragments;

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
import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tql;
import trh;
import tri;
import trr;
import tsl;
import tsp;
import tsv;
import ttl;
import tuk;
import tvg;
import tvm;
import twi;
import twj;
import twk;
import twl;
import twm;
import tyj;
import tym;
import tzf;
import xod;
import ydp;
import yfo;

public class QCirclePersonalDetailFragment
  extends QCircleBaseFragment
{
  public static final String c = QCirclePersonalDetailFragment.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private trh jdField_a_of_type_Trh;
  public tri a;
  private tsl jdField_a_of_type_Tsl;
  public tsv a;
  private tuk jdField_a_of_type_Tuk;
  protected tvm a;
  private twm jdField_a_of_type_Twm;
  private tzf jdField_a_of_type_Tzf;
  private int b;
  private String d;
  
  private trr a()
  {
    return new twl(this);
  }
  
  private void a(int paramInt)
  {
    int i = 255;
    this.jdField_a_of_type_Int += paramInt;
    paramInt = (int)(this.jdField_a_of_type_Int * 1.0F / this.b * 255.0F);
    if (paramInt > 255) {
      paramInt = i;
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      this.jdField_a_of_type_Tsl.a("personal_page_action_title_bar_animation", localMessage);
      return;
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tzf != null) {
      this.jdField_a_of_type_Tzf.a(this.d, paramBoolean);
    }
  }
  
  private List<ydp> b()
  {
    ArrayList localArrayList = new ArrayList();
    trr localtrr = a();
    this.jdField_a_of_type_Tri = new tri(new Bundle());
    this.jdField_a_of_type_Tri.a(localtrr);
    this.jdField_a_of_type_Tri.a(new twk(this));
    this.jdField_a_of_type_Trh = new trh(null);
    this.jdField_a_of_type_Trh.a(localtrr);
    localArrayList.add(this.jdField_a_of_type_Tri);
    localArrayList.add(this.jdField_a_of_type_Trh);
    return localArrayList;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tzf != null) {
      this.jdField_a_of_type_Tzf.b(this.d, paramBoolean);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_Tri != null)) {
      this.jdField_a_of_type_Tri.a(new ArrayList(Arrays.asList(new FeedCloudMeta.StUser[] { this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser })));
    }
    if ((yfo.a("2001" + this.d)) && (this.jdField_a_of_type_Tzf != null))
    {
      this.jdField_a_of_type_Tzf.c("2001" + this.d);
      return;
    }
    a(true);
  }
  
  private void f()
  {
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Twm = new twm(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Twm, localIntentFilter);
    }
  }
  
  public int a()
  {
    return 2131560557;
  }
  
  public List<tvg> a()
  {
    b();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Tvm = new tvm(2131364908, b(), 3, 1);
    this.jdField_a_of_type_Tsl = new tsl(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean);
    this.jdField_a_of_type_Tsv = new tsv();
    Object localObject = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject).id.set(this.d);
    localArrayList.add(this.jdField_a_of_type_Tvm);
    localArrayList.add(this.jdField_a_of_type_Tsl);
    localArrayList.add(this.jdField_a_of_type_Tsv);
    localObject = new tsp((FeedCloudMeta.StUser)localObject);
    localArrayList.add(localObject);
    localArrayList.add(new ttl());
    ((tsp)localObject).a(4);
    return localArrayList;
  }
  
  public tvm a()
  {
    return this.jdField_a_of_type_Tvm;
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    d();
    e();
    b(true);
    f();
  }
  
  protected void b()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean")))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
      if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser().id.get())))
      {
        this.d = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser().id.get();
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser();
        tyj.a(this.d, 11, 1L, 0L);
      }
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Tzf = ((tzf)a(tzf.class));
    this.jdField_a_of_type_Tzf.a().observe(this, new twi(this));
  }
  
  protected void d()
  {
    this.b = xod.a(getActivity(), 200.0F);
    this.jdField_a_of_type_Tvm.a().a().setEnableNestScrollingParent(true);
    this.jdField_a_of_type_Tvm.a().setEnableRefresh(true);
    this.jdField_a_of_type_Tvm.a().setEnableLoadMore(false);
    this.jdField_a_of_type_Tvm.a().setParentFragment(this);
    this.jdField_a_of_type_Tvm.a().a().setBackgroundColor(getResources().getColor(2131166178));
    this.jdField_a_of_type_Tvm.a().a().addOnScrollListener(new twj(this));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (tym.a().b(32)) {
      tym.a().a(getActivity().getIntent());
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Tuk != null) && (this.jdField_a_of_type_Tuk.a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_Twm != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Twm);
    }
    tql.a();
  }
  
  public void onDetach()
  {
    super.onDetach();
    tym.a().a(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */