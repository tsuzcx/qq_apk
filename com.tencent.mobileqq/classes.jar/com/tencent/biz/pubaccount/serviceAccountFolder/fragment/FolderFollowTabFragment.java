package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import ahpo;
import akdh;
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
import axqy;
import bfnk;
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
import sat;
import saz;
import sbc;
import sbd;
import sbe;
import sbf;
import sbg;
import sbh;
import sgg;
import sgu;
import wit;
import wkn;
import wlg;
import wpk;
import xhb;

public class FolderFollowTabFragment
  extends FolderBaseTabFragment
  implements ahpo, Handler.Callback
{
  public static int c;
  public static String c;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private ServiceFolderFollowPBHeadView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this, true);
  private sbh jdField_a_of_type_Sbh;
  private wkn jdField_a_of_type_Wkn;
  private wlg jdField_a_of_type_Wlg;
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
  
  private void a(List<sat> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderFollowTabFragment.8(this, paramList));
  }
  
  private void a(wlg paramwlg)
  {
    SubscribeGetFollowFeedsRequest localSubscribeGetFollowFeedsRequest = new SubscribeGetFollowFeedsRequest(null);
    localSubscribeGetFollowFeedsRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribeGetFollowFeedsRequest, new sbe(this, localSubscribeGetFollowFeedsRequest, paramwlg));
  }
  
  private boolean a(String paramString)
  {
    akdh localakdh = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localakdh != null)
    {
      paramString = localakdh.b(paramString);
      if ((paramString != null) && (sgg.a(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    saz localsaz = saz.a();
    List localList = localsaz.b();
    if ((localList != null) && (localList.size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localList;
      localMessage.what = 101;
      localMessage.arg1 = jdField_c_of_type_Int;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderFollowTabFragment.1(this, localsaz));
    localsaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
    sgu.a("SERVICE_FOLDER_COST", null);
  }
  
  private void b(wlg paramwlg)
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()) && (paramwlg != null) && (this.jdField_a_of_type_Wkn != null))
    {
      paramwlg.a();
      paramwlg.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Wkn);
      this.jdField_a_of_type_Wkn.a(new sbf(this));
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    d();
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Sbh = new sbh(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_refresh_return_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Sbh, localIntentFilter);
    }
  }
  
  private void c(wlg paramwlg)
  {
    SubscribeGetFollowFeedsRequest localSubscribeGetFollowFeedsRequest = new SubscribeGetFollowFeedsRequest(paramwlg.a().b());
    VSNetworkHelper.a().a(localSubscribeGetFollowFeedsRequest, new sbg(this, paramwlg));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375915));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView = new ServiceFolderFollowPBHeadView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().setConflictView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView);
    this.jdField_a_of_type_Wlg = new wlg(null);
    this.jdField_a_of_type_Wlg.c(this.b);
    this.jdField_a_of_type_Wlg.b(false);
    this.jdField_a_of_type_Wlg.a(new sbc(this));
    this.jdField_a_of_type_Wkn = new wkn(null);
    this.jdField_a_of_type_Wkn.a(this.b);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(new sbd(this, null));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Wlg);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableRefresh(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558701, null, false);
    }
    this.b = wit.a();
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
        if (this.jdField_a_of_type_Wlg != null) {
          a(this.jdField_a_of_type_Wlg);
        }
        if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().setConflictView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    sat localsat;
    long l;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131375911))
    {
      localsat = (sat)paramDragFrameLayout.a().getTag(2131375905);
      paramInt = ((Integer)paramDragFrameLayout.a().getTag(2131375903)).intValue();
      if (localsat != null)
      {
        l = saz.a().a(localsat);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localsat.a()) {
          break label257;
        }
      }
    }
    label257:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      axqy.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localsat.b, "" + (paramInt + 1), "" + l);
      saz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localsat, true);
      xhb.a(localsat.a, "auth_page", "ignore", 0, 0, new String[0]);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "onChange->drag red dot:" + localsat.a);
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
          xhb.b("auth_follow", "tab_red", 0, 0, new String[0]);
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558701, null, false);
    }
    this.b = wit.a();
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
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.a();
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_Sbh != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Sbh);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(FolderFollowTabFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */