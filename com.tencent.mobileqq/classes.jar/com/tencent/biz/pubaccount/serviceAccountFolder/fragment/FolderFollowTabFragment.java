package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import ajgx;
import aluw;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import azmj;
import bhoe;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.subscribe.account_folder.recommend_banner.SubScribeSwipeRefreshLayout;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import ssj;
import ssp;
import sss;
import sst;
import ssu;
import ssv;
import ssw;
import ssx;
import syb;
import syp;
import xxl;
import xzg;
import xzz;
import yeb;
import yvu;

public class FolderFollowTabFragment
  extends FolderBaseTabFragment
  implements ajgx, Handler.Callback
{
  public static int c;
  public static String c;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private ServiceFolderFollowPBHeadView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
  private ssx jdField_a_of_type_Ssx;
  private xzg jdField_a_of_type_Xzg;
  private xzz jdField_a_of_type_Xzz;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_c_of_type_Int = 1;
    jdField_c_of_type_JavaLangString = "FolderFollowTabFragment";
  }
  
  public FolderFollowTabFragment()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setJumpWebMessageListUrl(paramString);
    }
  }
  
  private void a(List<ssj> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderFollowTabFragment.8(this, paramList));
  }
  
  private void a(xzz paramxzz)
  {
    SubscribeGetFollowFeedsRequest localSubscribeGetFollowFeedsRequest = new SubscribeGetFollowFeedsRequest(null);
    localSubscribeGetFollowFeedsRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribeGetFollowFeedsRequest, new ssu(this, localSubscribeGetFollowFeedsRequest, paramxzz));
  }
  
  private boolean a(String paramString)
  {
    aluw localaluw = (aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localaluw != null)
    {
      paramString = localaluw.b(paramString);
      if ((paramString != null) && (syb.a(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    ssp localssp = ssp.a();
    List localList = localssp.b();
    if ((localList != null) && (localList.size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localList;
      localMessage.what = 101;
      localMessage.arg1 = jdField_c_of_type_Int;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderFollowTabFragment.1(this, localssp));
    localssp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
    syp.a("SERVICE_FOLDER_COST", null);
  }
  
  private void b(xzz paramxzz)
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()) && (paramxzz != null) && (this.jdField_a_of_type_Xzg != null))
    {
      paramxzz.a();
      paramxzz.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Xzg);
      this.jdField_a_of_type_Xzg.a(new ssv(this));
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    d();
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Ssx = new ssx(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_refresh_return_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Ssx, localIntentFilter);
    }
  }
  
  private void c(xzz paramxzz)
  {
    SubscribeGetFollowFeedsRequest localSubscribeGetFollowFeedsRequest = new SubscribeGetFollowFeedsRequest(paramxzz.a().b());
    VSNetworkHelper.a().a(localSubscribeGetFollowFeedsRequest, new ssw(this, paramxzz));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376414));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView = new ServiceFolderFollowPBHeadView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().setConflictView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView);
    this.jdField_a_of_type_Xzz = new xzz(null);
    this.jdField_a_of_type_Xzz.c(this.b);
    this.jdField_a_of_type_Xzz.b(false);
    this.jdField_a_of_type_Xzz.a(new sss(this));
    this.jdField_a_of_type_Xzg = new xzg(null);
    this.jdField_a_of_type_Xzg.a(this.b);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(new sst(this, null));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Xzz);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableRefresh(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.e();
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558737, null, false);
    }
    this.b = xxl.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(FolderFollowTabFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      ExtraTypeInfo localExtraTypeInfo2 = (ExtraTypeInfo)getActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      ExtraTypeInfo localExtraTypeInfo1 = localExtraTypeInfo2;
      if (localExtraTypeInfo2 == null) {
        localExtraTypeInfo1 = new ExtraTypeInfo();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo(7003, localExtraTypeInfo1.sourceType);
    }
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    c();
    b();
    QLog.d(FolderBaseTabFragment.a, 4, "initViewData:" + a());
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.a(paramInt);
    }
  }
  
  public void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt)
  {
    if (paramInt == a())
    {
      paramServiceAccountFolderActivityNew.a(true);
      if (paramServiceAccountFolderActivityNew.a())
      {
        paramServiceAccountFolderActivityNew.a(8);
        b();
        if (this.jdField_a_of_type_Xzz != null) {
          a(this.jdField_a_of_type_Xzz);
        }
        if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().setConflictView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    ssj localssj;
    long l;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131376410))
    {
      localssj = (ssj)paramDragFrameLayout.a().getTag(2131376404);
      paramInt = ((Integer)paramDragFrameLayout.a().getTag(2131376402)).intValue();
      if (localssj != null)
      {
        l = ssp.a().a(localssj);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localssj.a()) {
          break label257;
        }
      }
    }
    label257:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      azmj.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localssj.b, "" + (paramInt + 1), "" + l);
      ssp.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localssj, true);
      yvu.a(localssj.a, "auth_page", "ignore", 0, 0, new String[0]);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "onChange->drag red dot:" + localssj.a);
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      int i = paramMessage.arg1;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      ThreadManager.executeOnSubThread(new FolderFollowTabFragment.7(this, i));
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 101)
      {
        List localList = (List)paramMessage.obj;
        if (localList.isEmpty()) {
          if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setTopBannerVisibility(false);
          }
        }
        while (((this.jdField_a_of_type_AndroidAppActivity instanceof ServiceAccountFolderActivityNew)) && (paramMessage.arg1 != jdField_c_of_type_Int))
        {
          ((ServiceAccountFolderActivityNew)this.jdField_a_of_type_AndroidAppActivity).a(0);
          yvu.b("auth_follow", "tab_red", 0, 0, new String[0]);
          return true;
          if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null)
          {
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setTopBannerVisibility(true);
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setData(localList);
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558737, null, false);
    }
    this.b = xxl.a();
    if (this.b) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      QLog.d(FolderBaseTabFragment.a, 4, "onCreateView:" + a());
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.b();
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_Ssx != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Ssx);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(FolderFollowTabFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */