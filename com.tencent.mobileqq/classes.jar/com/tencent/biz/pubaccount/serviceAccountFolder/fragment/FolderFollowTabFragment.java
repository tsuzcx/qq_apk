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
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FolderFollowTabFragment
  extends FolderBaseTabFragment
  implements Handler.Callback, DragFrameLayout.OnDragModeChangedListener
{
  public static int c = 1;
  public static String c = "FolderFollowTabFragment";
  public static String d = "";
  private Activity jdField_a_of_type_AndroidAppActivity;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
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
  
  private void a(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter, List<CertifiedAccountRead.GetPortalRsp.RoomLstItem> paramList, CertifiedAccountRead.GetSubscriptionRsp.Bottom paramBottom, String paramString, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Object localObject = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(0)).room_lst.get();
      if ((localObject != null) && (((List)localObject).size() == 0))
      {
        localObject = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(0)).tab_info.name.get();
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.a(true, (String)localObject);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.a(false, null);
      }
      paramBoolean = paramRelativeLiveFeedsAdapter.a(paramBoolean, paramList);
      paramRelativeLiveFeedsAdapter.a(paramList, paramBottom, paramString);
    }
    else
    {
      paramRelativeLiveFeedsAdapter.a();
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.a(true, null);
    }
    if ((paramBottom != null) && (paramBoolean))
    {
      a(paramBoolean, paramBottom.desc.get(), paramBottom.jump_url.get());
      return;
    }
    a(false, null, null);
  }
  
  private void a(String paramString)
  {
    ServiceFolderFollowPBHeadView localServiceFolderFollowPBHeadView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
    if (localServiceFolderFollowPBHeadView != null) {
      localServiceFolderFollowPBHeadView.setJumpWebMessageListUrl(paramString);
    }
  }
  
  private void a(List<ServiceAccountFolderFeed> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderFollowTabFragment.10(this, paramList));
  }
  
  private void a(boolean paramBoolean, Object paramObject, RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView == null) {
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof CertifiedAccountRead.GetSubscriptionRsp)))
    {
      Object localObject1 = jdField_c_of_type_JavaLangString;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isSuccess:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" setAddonRsp:");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      localObject2 = (CertifiedAccountRead.GetSubscriptionRsp)paramObject;
      paramObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).room_lst.get();
      localObject1 = (CertifiedAccountRead.GetSubscriptionRsp.Bottom)((CertifiedAccountRead.GetSubscriptionRsp)localObject2).bottom.get();
      localObject2 = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).page_info.get();
      paramRelativeLiveFeedsAdapter.a().b((String)localObject2);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      a(paramRelativeLiveFeedsAdapter, paramObject, (CertifiedAccountRead.GetSubscriptionRsp.Bottom)localObject1, (String)localObject2, false);
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        return;
      }
      d = paramString2;
      if (paramBoolean)
      {
        localTextView.setText(paramString1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        MobileReportManager.getInstance().reportActionLive("", "25", "qq_live", "tab_page", "bottom_button", 101, 1, System.currentTimeMillis(), "");
        return;
      }
      localLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private boolean a(String paramString)
  {
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localIPublicAccountDataManager != null)
    {
      paramString = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfo(paramString);
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
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView == null) {
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof CertifiedAccountRead.GetSubscriptionRsp)))
    {
      Object localObject1 = jdField_c_of_type_JavaLangString;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isSuccess:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" addFeedsData:");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      localObject2 = (CertifiedAccountRead.GetSubscriptionRsp)paramObject;
      paramObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).room_lst.get();
      localObject1 = (CertifiedAccountRead.GetSubscriptionRsp.Bottom)((CertifiedAccountRead.GetSubscriptionRsp)localObject2).bottom.get();
      localObject2 = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).page_info.get();
      paramRelativeLiveFeedsAdapter.a().b((String)localObject2);
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        paramRelativeLiveFeedsAdapter.b(paramObject, (CertifiedAccountRead.GetSubscriptionRsp.Bottom)localObject1, (String)localObject2);
        return;
      }
      paramRelativeLiveFeedsAdapter.d(false);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    e();
    if (getBaseActivity() != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$FollowTabBroadcastReceiver = new FolderFollowTabFragment.FollowTabBroadcastReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_refresh_return_page");
      getBaseActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$FollowTabBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366303));
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364147));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378459));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364148));
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
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131377282));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView = new ServiceFolderFollowPBHeadView(getBaseActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setmFolderViewPager(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager);
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getBaseActivity()).inflate(2131558771, null, false);
    }
    this.jdField_b_of_type_Boolean = SubscribeUtils.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 != null) {
      ((QQAppInterface)localObject1).setHandler(FolderFollowTabFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null))
    {
      localObject2 = (ExtraTypeInfo)getBaseActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ExtraTypeInfo();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo(7003, ((ExtraTypeInfo)localObject1).sourceType);
    }
    this.jdField_a_of_type_AndroidAppActivity = getBaseActivity();
    c();
    b();
    localObject1 = FolderBaseTabFragment.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initViewData:");
    ((StringBuilder)localObject2).append(a());
    QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
  }
  
  public void a(int paramInt)
  {
    ServiceFolderFollowPBHeadView localServiceFolderFollowPBHeadView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
    if (localServiceFolderFollowPBHeadView != null) {
      localServiceFolderFollowPBHeadView.a(paramInt);
    }
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
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
        paramServiceAccountFolderActivityNew = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter;
        if (paramServiceAccountFolderActivityNew != null)
        {
          c(paramServiceAccountFolderActivityNew);
          a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      int i = paramMessage.arg1;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      ThreadManager.executeOnSubThread(new FolderFollowTabFragment.9(this, i));
      return true;
    }
    if (paramMessage.what == 101)
    {
      paramMessage = (List)paramMessage.obj;
      if (paramMessage.isEmpty())
      {
        paramMessage = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
        if (paramMessage != null)
        {
          paramMessage.setTopBannerVisibility(false);
          return true;
        }
      }
      else
      {
        ServiceFolderFollowPBHeadView localServiceFolderFollowPBHeadView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
        if (localServiceFolderFollowPBHeadView != null)
        {
          localServiceFolderFollowPBHeadView.setTopBannerVisibility(true);
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setData(paramMessage);
        }
      }
    }
    return true;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131377279))
    {
      ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)paramDragFrameLayout.a().getTag(2131377273);
      paramInt = ((Integer)paramDragFrameLayout.a().getTag(2131377271)).intValue();
      if (localServiceAccountFolderFeed != null)
      {
        long l = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localServiceAccountFolderFeed.a()) {
          paramDragFrameLayout = "0";
        } else {
          paramDragFrameLayout = "1";
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.b);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramInt + 1);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l);
        ReportController.b((AppRuntime)localObject1, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, (String)localObject2, (String)localObject3, localStringBuilder.toString());
        ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localServiceAccountFolderFeed, true);
        VSReporter.a(localServiceAccountFolderFeed.a, "auth_page", "ignore", 0, 0, new String[0]);
        if (QLog.isColorLevel())
        {
          paramDragFrameLayout = jdField_c_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onChange->drag red dot:");
          ((StringBuilder)localObject1).append(localServiceAccountFolderFeed.a);
          QLog.d(paramDragFrameLayout, 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getBaseActivity()).inflate(2131558771, null, false);
    }
    this.jdField_b_of_type_Boolean = SubscribeUtils.a();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    } else {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-657670);
    }
    paramLayoutInflater = FolderBaseTabFragment.a;
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("onCreateView:");
    paramViewGroup.append(a());
    QLog.d(paramLayoutInflater, 4, paramViewGroup.toString());
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
    if (localObject != null) {
      ((ServiceFolderFollowPBHeadView)localObject).a();
    }
    if ((getBaseActivity() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$FollowTabBroadcastReceiver != null)) {
      getBaseActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$FollowTabBroadcastReceiver);
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
    if (localObject != null) {
      ((BlockContainer)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeHandler(FolderFollowTabFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */