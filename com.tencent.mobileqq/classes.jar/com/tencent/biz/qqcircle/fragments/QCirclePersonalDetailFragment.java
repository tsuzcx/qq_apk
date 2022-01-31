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
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tql;
import trm;
import trn;
import trw;
import tss;
import tsw;
import ttg;
import ttl;
import tua;
import tuz;
import tvv;
import tvw;
import twz;
import txa;
import txb;
import txc;
import txd;
import tzv;
import tzy;
import ubq;
import xsm;
import yhy;
import ykb;

public class QCirclePersonalDetailFragment
  extends QCircleBaseFragment
{
  private int jdField_a_of_type_Int;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private trm jdField_a_of_type_Trm;
  public trn a;
  private tss jdField_a_of_type_Tss;
  private tsw jdField_a_of_type_Tsw;
  public ttl a;
  private tuz jdField_a_of_type_Tuz;
  protected tvw a;
  private txd jdField_a_of_type_Txd;
  private ubq jdField_a_of_type_Ubq;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  private trw a()
  {
    return new txc(this);
  }
  
  private void a(int paramInt)
  {
    int i = 255;
    this.jdField_a_of_type_Int += paramInt;
    float f = this.jdField_a_of_type_Int * 1.0F / this.jdField_b_of_type_Int;
    QLog.d("QCirclePersonalDetailFragment", 1, "computeShowTitleBarAnimation  dy:" + paramInt + "  mDistance:" + this.jdField_a_of_type_Int + "  percent:" + f);
    paramInt = (int)(f * 255.0F);
    if (paramInt > 255) {
      paramInt = i;
    }
    for (;;)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      this.jdField_a_of_type_Tss.a("personal_page_action_title_bar_animation", localMessage);
      return;
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  private List<yhy> b()
  {
    ArrayList localArrayList = new ArrayList();
    trw localtrw = a();
    this.jdField_a_of_type_Trn = new trn(new Bundle());
    this.jdField_a_of_type_Trn.setInteractor(localtrw);
    this.jdField_a_of_type_Trn.setOnLoadDataDelegate(new txb(this));
    this.jdField_a_of_type_Trm = new trm(null);
    this.jdField_a_of_type_Trm.setInteractor(localtrw);
    localArrayList.add(this.jdField_a_of_type_Trn);
    localArrayList.add(this.jdField_a_of_type_Trm);
    return localArrayList;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ubq != null) {
      this.jdField_a_of_type_Ubq.a(this.jdField_b_of_type_JavaLangString, paramBoolean);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ubq != null) {
      this.jdField_a_of_type_Ubq.b(this.jdField_b_of_type_JavaLangString, paramBoolean);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_Trn != null)) {
      this.jdField_a_of_type_Trn.setDatas(new ArrayList(Arrays.asList(new FeedCloudMeta.StUser[] { this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser })));
    }
    if ((ykb.a("2001" + this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Ubq != null))
    {
      this.jdField_a_of_type_Ubq.a("2001" + this.jdField_b_of_type_JavaLangString);
      return;
    }
    b(true);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Int = 0;
    a(0);
  }
  
  private void g()
  {
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Txd = new txd(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Txd, localIntentFilter);
    }
  }
  
  public int a()
  {
    return 2131560570;
  }
  
  public String a()
  {
    return "QCirclePersonalDetailFragment";
  }
  
  public List<tvv> a()
  {
    b();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Tvw = new tvw(2131364910, b(), 3, 1);
    this.jdField_a_of_type_Tss = new tss(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean);
    this.jdField_a_of_type_Ttl = new ttl();
    Object localObject = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject).id.set(this.jdField_b_of_type_JavaLangString);
    localArrayList.add(this.jdField_a_of_type_Tvw);
    localArrayList.add(this.jdField_a_of_type_Tss);
    localArrayList.add(this.jdField_a_of_type_Ttl);
    localObject = new ttg((FeedCloudMeta.StUser)localObject);
    localArrayList.add(localObject);
    localArrayList.add(new tua());
    ((ttg)localObject).a(4);
    this.jdField_a_of_type_Tsw = new tsw();
    localArrayList.add(this.jdField_a_of_type_Tsw);
    return localArrayList;
  }
  
  public tvw a()
  {
    return this.jdField_a_of_type_Tvw;
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    d();
    e();
    c(true);
    g();
  }
  
  protected void b()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean")))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
      if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser().id.get())))
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser().id.get();
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser();
        tzv.a(this.jdField_b_of_type_JavaLangString, 11, 1L, 0L);
      }
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Ubq = ((ubq)a(ubq.class));
    this.jdField_a_of_type_Ubq.a().observe(this, new twz(this));
  }
  
  protected void d()
  {
    this.jdField_b_of_type_Int = xsm.a(getActivity(), 200.0F);
    this.jdField_a_of_type_Tvw.a().setEnableRefresh(true);
    this.jdField_a_of_type_Tvw.a().setEnableLoadMore(false);
    this.jdField_a_of_type_Tvw.a().setParentFragment(this);
    this.jdField_a_of_type_Tvw.a().a().setBackgroundColor(getResources().getColor(2131166178));
    this.jdField_a_of_type_Tvw.a().a().addOnScrollListener(new txa(this));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (tzy.a().b(32)) {
      tzy.a().a(getActivity().getIntent());
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Tuz != null) && (this.jdField_a_of_type_Tuz.a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_Txd != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Txd);
    }
    tql.a();
  }
  
  public void onDetach()
  {
    super.onDetach();
    tzy.a().a(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */