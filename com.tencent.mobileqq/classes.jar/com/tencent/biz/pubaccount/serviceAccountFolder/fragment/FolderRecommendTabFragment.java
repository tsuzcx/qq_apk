package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import aknm;
import amxz;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bcef;
import bjmp;
import bkkf;
import blbv;
import blbw;
import blbx;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import common.config.service.QzoneConfig;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import uaq;
import uaw;
import ube;
import ubi;
import ugf;
import ugt;
import zbi;
import zds;
import zxp;

public class FolderRecommendTabFragment
  extends FolderBaseTabFragment
  implements aknm, Handler.Callback
{
  private static DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private blbv jdField_a_of_type_Blbv = new ube(this);
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  protected ExtraTypeInfo a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this, true);
  private ubi jdField_a_of_type_Ubi;
  private zds jdField_a_of_type_Zds;
  private boolean b;
  private int jdField_c_of_type_Int = QzoneConfig.getInstance().getConfig("qqsubscribe", "RecommendBannerCheckDisplayInterval", 3);
  protected String c;
  private boolean jdField_c_of_type_Boolean;
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    blbx localblbx = new blbx();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localblbx.b = (str + "_" + l);
    localblbx.jdField_a_of_type_Int = paramInt2;
    localblbx.jdField_e_of_type_JavaLangString = paramString1;
    localblbx.f = paramString2;
    localblbx.g = paramString3;
    localblbx.d = paramInt1;
    localblbx.jdField_e_of_type_Int = 1;
    localblbx.jdField_a_of_type_Long = l;
    blbw.a().a(localblbx);
  }
  
  private void a(List<uaq> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderRecommendTabFragment.4(this, paramList));
  }
  
  private boolean a()
  {
    long l = a();
    return System.currentTimeMillis() / 1000L - l > this.jdField_c_of_type_Int * 24 * 60 * 60;
  }
  
  private boolean a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    localObject = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      paramString = ((amxz)localObject).b(paramString);
      if ((paramString == null) || (ugf.a(paramString.accountFlag2) != -10L)) {}
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void c()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
    }
    localObject = uaw.a();
    List localList = ((uaw)localObject).b();
    if ((localList != null) && (localList.size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localList;
      localMessage.what = 101;
      localMessage.arg1 = FolderFollowTabFragment.jdField_c_of_type_Int;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderRecommendTabFragment.5(this, (uaw)localObject));
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ((uaw)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
      ugt.a("SERVICE_FOLDER_COST", null);
    }
  }
  
  public int a()
  {
    return jdField_b_of_type_Int;
  }
  
  public long a()
  {
    try
    {
      long l = Long.valueOf(SharePreferenceUtils.get(BaseApplicationImpl.getContext(), "subscribe_recommend_banner_unlike_timestamp_" + this.jdField_c_of_type_JavaLangString)).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0L;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558778, null);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(FolderRecommendTabFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
    jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_c_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.jdField_b_of_type_Boolean = zbi.a();
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      ExtraTypeInfo localExtraTypeInfo = (ExtraTypeInfo)getActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      localObject = localExtraTypeInfo;
      if (localExtraTypeInfo == null) {
        localObject = new ExtraTypeInfo();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo(7004, ((ExtraTypeInfo)localObject).sourceType);
    }
    b();
    QLog.d(FolderBaseTabFragment.a, 4, "initViewData:" + a());
    ThreadManager.postDownLoadTask(new FolderRecommendTabFragment.2(this), 5, null, true);
  }
  
  public void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt)
  {
    if (paramInt == a())
    {
      paramServiceAccountFolderActivityNew.a(false);
      if (paramServiceAccountFolderActivityNew.b()) {
        c();
      }
      if ((a()) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = true;
        zxp.a("auth_discover", "reco_exp", 0, 0, new String[0]);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    uaq localuaq;
    long l;
    QQAppInterface localQQAppInterface;
    if ((jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131377156))
    {
      localuaq = (uaq)paramDragFrameLayout.a().getTag(2131377150);
      paramInt = ((Integer)paramDragFrameLayout.a().getTag(2131377148)).intValue();
      if (localuaq != null)
      {
        l = uaw.a().a(localuaq);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localuaq.a()) {
          break label258;
        }
      }
    }
    label258:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      bcef.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localuaq.jdField_b_of_type_Int, "" + (paramInt + 1), "" + l);
      uaw.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localuaq, true);
      zxp.a(localuaq.a, "auth_page", "ignore", 0, 0, new String[0]);
      if (QLog.isColorLevel()) {
        QLog.d("FolderRecommendTabFragment", 2, "onChange->drag red dot:" + localuaq.a);
      }
      return;
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131376386));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_Ubi = new ubi(this, null);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Ubi);
    this.jdField_a_of_type_Zds = new zds(null);
    this.jdField_a_of_type_Zds.e(0);
    this.jdField_a_of_type_Zds.d(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_Zds.c(false);
    this.jdField_a_of_type_Zds.d(1);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Zds);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableRefresh(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      int i = paramMessage.arg1;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      ThreadManager.executeOnSubThread(new FolderRecommendTabFragment.3(this, i));
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
      } while ((this.jdField_a_of_type_Ubi == null) || (this.jdField_a_of_type_Ubi.a == null));
      this.jdField_a_of_type_Ubi.a.setTopBannerVisibility(false);
      return true;
    } while ((this.jdField_a_of_type_Ubi == null) || (this.jdField_a_of_type_Ubi.a == null));
    this.jdField_a_of_type_Ubi.a.setTopBannerVisibility(true);
    this.jdField_a_of_type_Ubi.a.setAdapterData(paramMessage);
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558778, null);
    }
    this.jdField_b_of_type_Boolean = zbi.a();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      QLog.d(FolderBaseTabFragment.a, 4, "onCreateView:" + a());
      bkkf.a(getActivity(), 2);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-657670);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)
    {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.b();
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = null;
    }
    if ((this.jdField_a_of_type_Ubi != null) && (this.jdField_a_of_type_Ubi.a != null))
    {
      this.jdField_a_of_type_Ubi.a.a();
      this.jdField_a_of_type_Ubi.a = null;
      this.jdField_a_of_type_Ubi = null;
    }
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null)
    {
      jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
      jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((getActivity() instanceof ServiceAccountFolderActivityNew)) {
      ((ServiceAccountFolderActivityNew)getActivity()).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment
 * JD-Core Version:    0.7.0.1
 */