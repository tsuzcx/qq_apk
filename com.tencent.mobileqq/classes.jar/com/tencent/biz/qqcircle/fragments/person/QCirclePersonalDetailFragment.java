package com.tencent.biz.qqcircle.fragments.person;

import aabd;
import aabe;
import aabp;
import aadg;
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
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uys;
import uyx;
import vaa;
import vad;
import var;
import vbr;
import vdj;
import vdr;
import vfa;
import vfg;
import vfi;
import vgg;
import vgl;
import vpt;
import vpu;
import vpv;
import vpw;
import vpx;
import vqu;
import vtq;
import vtt;
import vud;
import vuf;
import vwf;
import vxe;
import zps;

public class QCirclePersonalDetailFragment
  extends QCircleBaseFragment
{
  private static int c;
  private int jdField_a_of_type_Int;
  protected aabd a;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private String jdField_a_of_type_JavaLangString;
  private vaa jdField_a_of_type_Vaa;
  public vad a;
  private vbr jdField_a_of_type_Vbr;
  private vdj jdField_a_of_type_Vdj;
  private vdr jdField_a_of_type_Vdr;
  public vfi a;
  private vpx jdField_a_of_type_Vpx;
  private final vqu jdField_a_of_type_Vqu = vqu.a();
  private vxe jdField_a_of_type_Vxe;
  private int b;
  
  private var a()
  {
    return new vpw(this);
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
      this.jdField_a_of_type_Vdr.a("personal_page_action_title_bar_animation", localMessage);
      return;
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vxe != null) {
      this.jdField_a_of_type_Vxe.a(this.jdField_a_of_type_JavaLangString, paramBoolean);
    }
  }
  
  private List<aabp> b()
  {
    ArrayList localArrayList = new ArrayList();
    var localvar = a();
    this.jdField_a_of_type_Vad = new vad(new Bundle());
    this.jdField_a_of_type_Vad.a(a());
    this.jdField_a_of_type_Vad.setInteractor(localvar);
    this.jdField_a_of_type_Vad.setOnLoadDataDelegate(new vpv(this));
    this.jdField_a_of_type_Vaa = new vaa(getActivity().getIntent().getExtras());
    this.jdField_a_of_type_Vaa.a(a());
    this.jdField_a_of_type_Vaa.setInteractor(localvar);
    this.jdField_a_of_type_Vaa.a(a());
    localArrayList.add(this.jdField_a_of_type_Vad);
    localArrayList.add(this.jdField_a_of_type_Vaa);
    return localArrayList;
  }
  
  private void b(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    this.jdField_a_of_type_Vdr.a("personal_page_action_title_bar_follow_animation", localMessage);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vxe != null) {
      this.jdField_a_of_type_Vxe.b(this.jdField_a_of_type_JavaLangString, paramBoolean);
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_Vad != null)) {
      this.jdField_a_of_type_Vad.setDatas(new ArrayList(Arrays.asList(new FeedCloudMeta.StUser[] { this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser })));
    }
    if ((aadg.a("2001" + this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Vxe != null))
    {
      this.jdField_a_of_type_Vxe.d("2001" + this.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_Vpx = new vpx(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Vpx, localIntentFilter);
    }
  }
  
  public int a()
  {
    return 2131560767;
  }
  
  public aabd a()
  {
    return this.jdField_a_of_type_Aabd;
  }
  
  public List<aabe> a()
  {
    a();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Aabd = new aabd(2131365189, b(), 3, 1);
    this.jdField_a_of_type_Vdr = new vdr(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean);
    this.jdField_a_of_type_Vdr.a(a());
    this.jdField_a_of_type_Vfi = new vfi();
    this.jdField_a_of_type_Vfi.a(this);
    Object localObject = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject).id.set(this.jdField_a_of_type_JavaLangString);
    localArrayList.add(this.jdField_a_of_type_Aabd);
    localArrayList.add(this.jdField_a_of_type_Vdr);
    localArrayList.add(this.jdField_a_of_type_Vfi);
    localObject = new vfa((FeedCloudMeta.StUser)localObject);
    ((vfa)localObject).a(this);
    localArrayList.add(localObject);
    localArrayList.add(new vgg());
    vgg localvgg = new vgg();
    localvgg.a(a());
    localArrayList.add(localvgg);
    ((vfa)localObject).a(4);
    this.jdField_a_of_type_Vdj = new vdj();
    this.jdField_a_of_type_Vdj.a(this);
    localArrayList.add(this.jdField_a_of_type_Vdj);
    this.jdField_a_of_type_Vbr = new vbr();
    this.jdField_a_of_type_Vbr.a(this);
    localArrayList.add(this.jdField_a_of_type_Vbr);
    localArrayList.add(new vgl());
    localArrayList.add(new vfg());
    return localArrayList;
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
      this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
    } while ((this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean == null) || (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getUser() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getUser().id.get())));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getUser().id.get();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getUser();
    vtq.a(this.jdField_a_of_type_JavaLangString, 11, 1, 0, c());
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    c();
    d();
    b(true);
    f();
    vud.a().a(new vuf().a("main").b("impression").a(a()));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Vxe = ((vxe)a(vxe.class));
    this.jdField_a_of_type_Vxe.a().observe(this, new vpt(this));
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
    this.b = zps.a(getActivity(), 200.0F);
    this.jdField_a_of_type_Aabd.a().setEnableRefresh(true);
    this.jdField_a_of_type_Aabd.a().setEnableLoadMore(false);
    this.jdField_a_of_type_Aabd.a().setParentFragment(this);
    this.jdField_a_of_type_Aabd.a().a().setBackgroundColor(getResources().getColor(2131166234));
    this.jdField_a_of_type_Aabd.a().a().setTransDispatchDelegate(vwf.a());
    this.jdField_a_of_type_Aabd.a().a().addOnScrollListener(new vpu(this));
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Vaa != null)
    {
      if (this.jdField_a_of_type_Vaa.a() == 0) {
        return "profile_page";
      }
      if (this.jdField_a_of_type_Vaa.a() == 1) {
        return "profile_moment";
      }
      if (this.jdField_a_of_type_Vaa.a() == 2) {
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
    if (vtt.a().d()) {
      vtt.a().a(c(), getActivity().getIntent());
    }
    vtt.a().a(c());
    this.jdField_a_of_type_Vqu.a();
    int i = c;
    c = i + 1;
    if (i == 0) {
      this.jdField_a_of_type_Vqu.b();
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean;
    if ((localObject != null) && (String.valueOf(10).equals(((QCircleInitBean)localObject).getLaunchFrom())))
    {
      localObject = new QCircleFolderBean();
      ((QCircleFolderBean)localObject).setAssignShowTabType(1);
      uyx.a(getActivity(), (QCircleFolderBean)localObject);
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_Vpx != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Vpx);
    }
    c -= 1;
    uys.a();
  }
  
  public void onDetach()
  {
    super.onDetach();
    vtt.a().b(c());
  }
  
  public void onPause()
  {
    super.onPause();
    vtt.a().d(c());
  }
  
  public void onResume()
  {
    super.onResume();
    vtt.a().c(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */