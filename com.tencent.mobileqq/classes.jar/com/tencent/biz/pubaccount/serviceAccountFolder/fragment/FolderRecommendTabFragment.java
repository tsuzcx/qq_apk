package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
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
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import common.config.service.QzoneConfig;
import cooperation.ilive.util.IlivePreloadHelper;
import cooperation.vip.tianshu.TianShuManager;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FolderRecommendTabFragment
  extends FolderBaseTabFragment
  implements Handler.Callback, DragFrameLayout.OnDragModeChangedListener
{
  public static LinearLayout a;
  public static TextView a;
  private static DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  public static View b;
  public static LinearLayout b;
  public static String d = "";
  private FolderRecommendTabFragment.RecommendHeaderBlock jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock;
  protected ExtraTypeInfo a;
  private RelativeLiveFeedsAdapter jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter;
  private BlockContainer jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TianShuGetAdvCallback jdField_a_of_type_ComTencentMobileqqTianshuDataTianShuGetAdvCallback = new FolderRecommendTabFragment.1(this);
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private boolean b;
  private int jdField_c_of_type_Int = QzoneConfig.getInstance().getConfig("qqsubscribe", "RecommendBannerCheckDisplayInterval", 3);
  protected String c;
  private boolean jdField_c_of_type_Boolean;
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.b = (str + "_" + l);
    localTianShuReportData.jdField_a_of_type_Int = paramInt2;
    localTianShuReportData.jdField_e_of_type_JavaLangString = paramString1;
    localTianShuReportData.f = paramString2;
    localTianShuReportData.g = paramString3;
    localTianShuReportData.d = paramInt1;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.jdField_a_of_type_Long = l;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  private void a(List<ServiceAccountFolderFeed> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderRecommendTabFragment.5(this, paramList));
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
    localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      paramString = ((PublicAccountDataManager)localObject).b(paramString);
      if ((paramString == null) || (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramString.accountFlag2) != -10L)) {}
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void c()
  {
    jdField_a_of_type_AndroidWidgetLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364230);
    jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379090);
    jdField_b_of_type_AndroidWidgetLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364231);
    jdField_a_of_type_AndroidWidgetTextView.setText("发现更多精彩内容");
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, jdField_a_of_type_AndroidWidgetTextView.getPaint().getTextSize() * jdField_a_of_type_AndroidWidgetTextView.getText().length(), 0.0F, Color.parseColor("#FFC235"), Color.parseColor("#FF00CE"), Shader.TileMode.CLAMP);
    jdField_a_of_type_AndroidWidgetTextView.getPaint().setShader(localLinearGradient);
    jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new FolderRecommendTabFragment.3(this));
  }
  
  private void d()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
    }
    localObject = ServiceAccountFolderManager.a();
    List localList = ((ServiceAccountFolderManager)localObject).b();
    if ((localList != null) && (localList.size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localList;
      localMessage.what = 101;
      localMessage.arg1 = FolderFollowTabFragment.jdField_c_of_type_Int;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderRecommendTabFragment.6(this, (ServiceAccountFolderManager)localObject));
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ((ServiceAccountFolderManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
      PublicTracker.a("SERVICE_FOLDER_COST", null);
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
      long l = Long.valueOf(SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "subscribe_recommend_banner_unlike_timestamp_" + this.jdField_c_of_type_JavaLangString)).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0L;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558843, null);
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
    this.jdField_b_of_type_Boolean = SubscribeUtils.a();
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
        d();
      }
      if ((a()) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = true;
        VSReporter.a("auth_discover", "reco_exp", 0, 0, new String[0]);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    ServiceAccountFolderFeed localServiceAccountFolderFeed;
    long l;
    QQAppInterface localQQAppInterface;
    if ((jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131377853))
    {
      localServiceAccountFolderFeed = (ServiceAccountFolderFeed)paramDragFrameLayout.a().getTag(2131377847);
      paramInt = ((Integer)paramDragFrameLayout.a().getTag(2131377845)).intValue();
      if (localServiceAccountFolderFeed != null)
      {
        l = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localServiceAccountFolderFeed.a()) {
          break label258;
        }
      }
    }
    label258:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localServiceAccountFolderFeed.jdField_b_of_type_Int, "" + (paramInt + 1), "" + l);
      ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localServiceAccountFolderFeed, true);
      VSReporter.a(localServiceAccountFolderFeed.a, "auth_page", "ignore", 0, 0, new String[0]);
      if (QLog.isColorLevel()) {
        QLog.d("FolderRecommendTabFragment", 2, "onChange->drag red dot:" + localServiceAccountFolderFeed.a);
      }
      return;
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131377036));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock = new FolderRecommendTabFragment.RecommendHeaderBlock(this, null);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter = new RelativeLiveFeedsAdapter(null);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter.b(0);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter.b(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter.a(false);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter.a(1);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableRefresh(true);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.c();
    jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366422);
    d();
    c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      int i = paramMessage.arg1;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      ThreadManager.executeOnSubThread(new FolderRecommendTabFragment.4(this, i));
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
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock == null) || (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a == null));
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a.setTopBannerVisibility(false);
      return true;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock == null) || (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a == null));
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a.setTopBannerVisibility(true);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a.setAdapterData(paramMessage);
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558843, null);
    }
    this.jdField_b_of_type_Boolean = SubscribeUtils.a();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      QLog.d(FolderBaseTabFragment.a, 4, "onCreateView:" + a());
      IlivePreloadHelper.a(getActivity(), 2);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-657670);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.b();
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = null;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a = null;
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock = null;
    }
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null)
    {
      jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
      jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    }
    if (jdField_b_of_type_AndroidViewView != null) {
      jdField_b_of_type_AndroidViewView = null;
    }
    if (jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    if (jdField_a_of_type_AndroidWidgetTextView != null) {
      jdField_a_of_type_AndroidWidgetTextView = null;
    }
    if (jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      jdField_b_of_type_AndroidWidgetLinearLayout = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment
 * JD-Core Version:    0.7.0.1
 */