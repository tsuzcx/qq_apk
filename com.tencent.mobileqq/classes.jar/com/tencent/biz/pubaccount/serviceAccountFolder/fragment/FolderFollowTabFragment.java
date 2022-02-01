package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import aanb;
import alje;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aoan;
import bdla;
import bkyc;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;
import mqq.os.MqqHandler;
import uon;
import uot;
import uow;
import uox;
import uoy;
import uoz;
import upa;
import uuc;
import uuq;
import zoz;
import zqn;
import zsg;
import zsx;

public class FolderFollowTabFragment
  extends FolderBaseTabFragment
  implements alje, Handler.Callback
{
  public static int c;
  public static String c;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private ServiceFolderFollowPBHeadView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this, true);
  private upa jdField_a_of_type_Upa;
  private zsg jdField_a_of_type_Zsg;
  private zsx jdField_a_of_type_Zsx;
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
  
  private void a(List<uon> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderFollowTabFragment.7(this, paramList));
  }
  
  private void a(zsx paramzsx)
  {
    SubscribeGetFollowFeedsRequest localSubscribeGetFollowFeedsRequest = new SubscribeGetFollowFeedsRequest(null);
    localSubscribeGetFollowFeedsRequest.setEnableCache(true);
    this.jdField_c_of_type_Boolean = true;
    VSNetworkHelper.getInstance().sendRequest(localSubscribeGetFollowFeedsRequest, new uoy(this, paramzsx));
  }
  
  private boolean a(String paramString)
  {
    aoan localaoan = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localaoan != null)
    {
      paramString = localaoan.b(paramString);
      if ((paramString != null) && (uuc.a(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    uot localuot = uot.a();
    List localList = localuot.b();
    if ((localList != null) && (localList.size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localList;
      localMessage.what = 101;
      localMessage.arg1 = jdField_c_of_type_Int;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderFollowTabFragment.1(this, localuot));
    localuot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
    uuq.a("SERVICE_FOLDER_COST", null);
  }
  
  private void b(zsx paramzsx)
  {
    SubscribeGetFollowFeedsRequest localSubscribeGetFollowFeedsRequest = new SubscribeGetFollowFeedsRequest(paramzsx.a().b(), paramzsx.a().b());
    VSNetworkHelper.getInstance().sendRequest(localSubscribeGetFollowFeedsRequest, new uoz(this, paramzsx));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    d();
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Upa = new upa(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_refresh_return_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Upa, localIntentFilter);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131377434));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView = new ServiceFolderFollowPBHeadView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setmFolderViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_Zsx = new zsx(null);
    this.jdField_a_of_type_Zsx.d(this.b);
    this.jdField_a_of_type_Zsx.c(false);
    this.jdField_a_of_type_Zsx.a(new uow(this));
    this.jdField_a_of_type_Zsx.d(0);
    this.jdField_a_of_type_Zsg = new zsg(null);
    this.jdField_a_of_type_Zsg.b(this.b);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(new uox(this, null));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Zsx);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableRefresh(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558833, null, false);
    }
    this.b = zqn.a();
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
  
  public void a(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt)
  {
    if (paramInt == a())
    {
      paramServiceAccountFolderActivityNew.a(true);
      if (paramServiceAccountFolderActivityNew.b())
      {
        paramServiceAccountFolderActivityNew.a(8);
        b();
        if (this.jdField_a_of_type_Zsx != null) {
          a(this.jdField_a_of_type_Zsx);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    uon localuon;
    long l;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131377431))
    {
      localuon = (uon)paramDragFrameLayout.a().getTag(2131377425);
      paramInt = ((Integer)paramDragFrameLayout.a().getTag(2131377423)).intValue();
      if (localuon != null)
      {
        l = uot.a().a(localuon);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localuon.a()) {
          break label257;
        }
      }
    }
    label257:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      bdla.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localuon.b, "" + (paramInt + 1), "" + l);
      uot.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localuon, true);
      aanb.a(localuon.a, "auth_page", "ignore", 0, 0, new String[0]);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "onChange->drag red dot:" + localuon.a);
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
      ThreadManager.executeOnSubThread(new FolderFollowTabFragment.6(this, i));
    }
    do
    {
      do
      {
        do
        {
          return true;
        } while (paramMessage.what != 101);
        paramMessage = (List)paramMessage.obj;
        if (!paramMessage.isEmpty()) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView == null);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setTopBannerVisibility(false);
      return true;
    } while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView == null);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setTopBannerVisibility(true);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setData(paramMessage);
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558833, null, false);
    }
    this.b = zqn.a();
    if (this.b) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      QLog.d(FolderBaseTabFragment.a, 4, "onCreateView:" + a());
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-657670);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.a();
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_Upa != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Upa);
    }
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(FolderFollowTabFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */