package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomLstItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.TabItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionRsp.Bottom;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.BlankRecommendFeedsAdapter;
import com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter;
import com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vip.PbProtocol;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;
import mqq.os.MqqHandler;

public class FolderFollowTabFragment
  extends FolderBaseTabFragment
  implements Handler.Callback, DragFrameLayout.OnDragModeChangedListener
{
  public static int c;
  public static String c;
  public static String d = "";
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  private FolderFollowTabFragment.FollowTabBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$FollowTabBroadcastReceiver;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private BlankRecommendFeedsAdapter jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter;
  private RelativeLiveFeedsAdapter jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter;
  private BlockContainer jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
  private ServiceFolderFollowPBHeadView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
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
  
  private void a(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    CertifiedAccountRead.GetSubscriptionReq localGetSubscriptionReq = new CertifiedAccountRead.GetSubscriptionReq();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
      localGetSubscriptionReq.uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()).longValue());
    }
    if (!TextUtils.isEmpty(paramRelativeLiveFeedsAdapter.a().b())) {
      localGetSubscriptionReq.page_info.set("");
    }
    localGetSubscriptionReq.page_id.set(1);
    PbProtocol.a("QQLive.GetSubscriptionData", localGetSubscriptionReq, CertifiedAccountRead.GetSubscriptionRsp.class, new FolderFollowTabFragment.5(this, paramRelativeLiveFeedsAdapter));
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setJumpWebMessageListUrl(paramString);
    }
  }
  
  private void a(List<ServiceAccountFolderFeed> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderFollowTabFragment.10(this, paramList));
  }
  
  private void a(boolean paramBoolean, Object paramObject, RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView == null) {}
    while ((!paramBoolean) || (!(paramObject instanceof CertifiedAccountRead.GetSubscriptionRsp))) {
      return;
    }
    QLog.d(jdField_c_of_type_JavaLangString, 2, "isSuccess:" + paramBoolean + " setAddonRsp:");
    Object localObject1 = (CertifiedAccountRead.GetSubscriptionRsp)paramObject;
    paramObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject1).room_lst.get();
    CertifiedAccountRead.GetSubscriptionRsp.Bottom localBottom = (CertifiedAccountRead.GetSubscriptionRsp.Bottom)((CertifiedAccountRead.GetSubscriptionRsp)localObject1).bottom.get();
    localObject1 = ((CertifiedAccountRead.GetSubscriptionRsp)localObject1).page_info.get();
    paramRelativeLiveFeedsAdapter.a().b((String)localObject1);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((paramObject != null) && (paramObject.size() > 0))
    {
      Object localObject2 = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramObject.get(0)).room_lst.get();
      if ((localObject2 != null) && (((List)localObject2).size() == 0))
      {
        localObject2 = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramObject.get(0)).tab_info.name.get();
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.a(true, (String)localObject2);
        paramBoolean = paramRelativeLiveFeedsAdapter.a(false, paramObject);
        paramRelativeLiveFeedsAdapter.a(paramObject, localBottom, (String)localObject1);
      }
    }
    for (;;)
    {
      if ((localBottom == null) || (!paramBoolean)) {
        break label267;
      }
      a(paramBoolean, localBottom.desc.get(), localBottom.jump_url.get());
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.a(false, null);
      break;
      paramRelativeLiveFeedsAdapter.a();
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.a(true, null);
      paramBoolean = false;
    }
    label267:
    a(false, null, null);
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    d = paramString2;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      MobileReportManager.getInstance().reportActionLive("", "25", "qq_live", "tab_page", "bottom_button", 101, 1, System.currentTimeMillis(), "");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localPublicAccountDataManager != null)
    {
      paramString = localPublicAccountDataManager.b(paramString);
      if ((paramString != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    ServiceAccountFolderManager localServiceAccountFolderManager = ServiceAccountFolderManager.a();
    List localList = localServiceAccountFolderManager.b();
    if ((localList != null) && (localList.size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localList;
      localMessage.what = 101;
      localMessage.arg1 = jdField_c_of_type_Int;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderFollowTabFragment.1(this, localServiceAccountFolderManager));
    localServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
    PublicTracker.a("SERVICE_FOLDER_COST", null);
  }
  
  private void b(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    CertifiedAccountRead.GetSubscriptionReq localGetSubscriptionReq = new CertifiedAccountRead.GetSubscriptionReq();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
      localGetSubscriptionReq.uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()).longValue());
    }
    if (!TextUtils.isEmpty(paramRelativeLiveFeedsAdapter.a().b())) {
      localGetSubscriptionReq.page_info.set(paramRelativeLiveFeedsAdapter.a().b());
    }
    localGetSubscriptionReq.page_id.set(1);
    PbProtocol.a("QQLive.GetSubscriptionData", localGetSubscriptionReq, CertifiedAccountRead.GetSubscriptionRsp.class, new FolderFollowTabFragment.6(this, paramRelativeLiveFeedsAdapter));
  }
  
  private void b(boolean paramBoolean, Object paramObject, RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView == null) {}
    while ((!paramBoolean) || (!(paramObject instanceof CertifiedAccountRead.GetSubscriptionRsp))) {
      return;
    }
    QLog.d(jdField_c_of_type_JavaLangString, 2, "isSuccess:" + paramBoolean + " addFeedsData:");
    Object localObject = (CertifiedAccountRead.GetSubscriptionRsp)paramObject;
    paramObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject).room_lst.get();
    CertifiedAccountRead.GetSubscriptionRsp.Bottom localBottom = (CertifiedAccountRead.GetSubscriptionRsp.Bottom)((CertifiedAccountRead.GetSubscriptionRsp)localObject).bottom.get();
    localObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject).page_info.get();
    paramRelativeLiveFeedsAdapter.a().b((String)localObject);
    if ((paramObject != null) && (paramObject.size() > 0))
    {
      paramRelativeLiveFeedsAdapter.b(paramObject, localBottom, (String)localObject);
      return;
    }
    paramRelativeLiveFeedsAdapter.d(false);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    e();
    if (getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$FollowTabBroadcastReceiver = new FolderFollowTabFragment.FollowTabBroadcastReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_refresh_return_page");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$FollowTabBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366422));
    d();
  }
  
  private void c(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    paramRelativeLiveFeedsAdapter = new SubscribeGetFollowFeedsRequest(null);
    paramRelativeLiveFeedsAdapter.setEnableCache(true);
    this.jdField_c_of_type_Boolean = true;
    VSNetworkHelper.getInstance().sendRequest(paramRelativeLiveFeedsAdapter, new FolderFollowTabFragment.7(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364230));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379090));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364231));
    this.jdField_b_of_type_AndroidWidgetTextView.setText("发现更多精彩内容");
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetTextView.getPaint().getTextSize() * this.jdField_b_of_type_AndroidWidgetTextView.getText().length(), 0.0F, Color.parseColor("#FFC235"), Color.parseColor("#FF00CE"), Shader.TileMode.CLAMP);
    this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setShader(localLinearGradient);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new FolderFollowTabFragment.2(this));
  }
  
  private void d(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    paramRelativeLiveFeedsAdapter = new SubscribeGetFollowFeedsRequest(paramRelativeLiveFeedsAdapter.a().b(), paramRelativeLiveFeedsAdapter.a().b());
    VSNetworkHelper.getInstance().sendRequest(paramRelativeLiveFeedsAdapter, new FolderFollowTabFragment.8(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131377856));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView = new ServiceFolderFollowPBHeadView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setmFolderViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter = new RelativeLiveFeedsAdapter(null);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter.b(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter.a(false);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter.a(new FolderFollowTabFragment.3(this));
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter.a(0);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter = new BlankRecommendFeedsAdapter(null);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter.a(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(new FolderFollowTabFragment.4(this, null));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableRefresh(true);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.c();
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558873, null, false);
    }
    this.jdField_b_of_type_Boolean = SubscribeUtils.a();
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
        if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter != null)
        {
          c(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter);
          a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    ServiceAccountFolderFeed localServiceAccountFolderFeed;
    long l;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131377853))
    {
      localServiceAccountFolderFeed = (ServiceAccountFolderFeed)paramDragFrameLayout.a().getTag(2131377847);
      paramInt = ((Integer)paramDragFrameLayout.a().getTag(2131377845)).intValue();
      if (localServiceAccountFolderFeed != null)
      {
        l = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localServiceAccountFolderFeed.a()) {
          break label253;
        }
      }
    }
    label253:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localServiceAccountFolderFeed.b, "" + (paramInt + 1), "" + l);
      ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localServiceAccountFolderFeed, true);
      VSReporter.a(localServiceAccountFolderFeed.a, "auth_page", "ignore", 0, 0, new String[0]);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "onChange->drag red dot:" + localServiceAccountFolderFeed.a);
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
      ThreadManager.executeOnSubThread(new FolderFollowTabFragment.9(this, i));
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558873, null, false);
    }
    this.jdField_b_of_type_Boolean = SubscribeUtils.a();
    if (this.jdField_b_of_type_Boolean) {
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
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$FollowTabBroadcastReceiver != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$FollowTabBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(FolderFollowTabFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */