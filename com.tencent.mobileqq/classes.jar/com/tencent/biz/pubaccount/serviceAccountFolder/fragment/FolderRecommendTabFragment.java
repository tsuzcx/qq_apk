package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = (IPublicAccountDataManager)((QQAppInterface)localObject).getRuntimeService(IPublicAccountDataManager.class, "all");
    boolean bool1 = bool2;
    if (localObject != null)
    {
      paramString = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramString.accountFlag2) == -10L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c()
  {
    jdField_a_of_type_AndroidWidgetLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364147);
    jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378459);
    jdField_b_of_type_AndroidWidgetLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364148);
    jdField_a_of_type_AndroidWidgetTextView.setText("发现更多精彩内容");
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, jdField_a_of_type_AndroidWidgetTextView.getPaint().getTextSize() * jdField_a_of_type_AndroidWidgetTextView.getText().length(), 0.0F, Color.parseColor("#FFC235"), Color.parseColor("#FF00CE"), Shader.TileMode.CLAMP);
    jdField_a_of_type_AndroidWidgetTextView.getPaint().setShader(localLinearGradient);
    jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new FolderRecommendTabFragment.3(this));
  }
  
  private void d()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject1);
    }
    localObject1 = ServiceAccountFolderManager.a();
    Object localObject2 = ((ServiceAccountFolderManager)localObject1).b();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localObject2;
      localMessage.what = 101;
      localMessage.arg1 = FolderFollowTabFragment.jdField_c_of_type_Int;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderRecommendTabFragment.6(this, (ServiceAccountFolderManager)localObject1));
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject2 != null)
      {
        ((ServiceAccountFolderManager)localObject1).a((QQAppInterface)localObject2, NetConnInfoCenter.getServerTime());
        PublicTracker.a("SERVICE_FOLDER_COST", null);
      }
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
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("subscribe_recommend_banner_unlike_timestamp_");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      long l = Long.valueOf(SharePreferenceUtils.a(localBaseApplication, localStringBuilder.toString())).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label50:
      break label50;
    }
    return 0L;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getBaseActivity()).inflate(2131558741, null);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject1);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 != null) {
      ((QQAppInterface)localObject1).setHandler(FolderRecommendTabFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getBaseActivity());
    jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_c_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.jdField_b_of_type_Boolean = SubscribeUtils.a();
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null))
    {
      localObject2 = (ExtraTypeInfo)getBaseActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ExtraTypeInfo();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo(7004, ((ExtraTypeInfo)localObject1).sourceType);
    }
    b();
    localObject1 = FolderBaseTabFragment.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initViewData:");
    ((StringBuilder)localObject2).append(a());
    QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
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
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131376516));
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
    jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366303);
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
      return true;
    }
    if (paramMessage.what == 101)
    {
      paramMessage = (List)paramMessage.obj;
      if (paramMessage.isEmpty())
      {
        paramMessage = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock;
        if ((paramMessage != null) && (paramMessage.a != null))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a.setTopBannerVisibility(false);
          return true;
        }
      }
      else
      {
        FolderRecommendTabFragment.RecommendHeaderBlock localRecommendHeaderBlock = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock;
        if ((localRecommendHeaderBlock != null) && (localRecommendHeaderBlock.a != null))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a.setTopBannerVisibility(true);
          this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a.setAdapterData(paramMessage);
        }
      }
    }
    return true;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    Object localObject1 = jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if ((localObject1 != null) && (((DragFrameLayout)localObject1).a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131377279))
    {
      localObject1 = (ServiceAccountFolderFeed)paramDragFrameLayout.a().getTag(2131377273);
      paramInt = ((Integer)paramDragFrameLayout.a().getTag(2131377271)).intValue();
      if (localObject1 != null)
      {
        long l = ServiceAccountFolderManager.a().a((ServiceAccountFolderFeed)localObject1);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (((ServiceAccountFolderFeed)localObject1).a()) {
          paramDragFrameLayout = "0";
        } else {
          paramDragFrameLayout = "1";
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((ServiceAccountFolderFeed)localObject1).jdField_b_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramInt + 1);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l);
        ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, (String)localObject2, (String)localObject3, localStringBuilder.toString());
        ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ServiceAccountFolderFeed)localObject1, true);
        VSReporter.a(((ServiceAccountFolderFeed)localObject1).a, "auth_page", "ignore", 0, 0, new String[0]);
        if (QLog.isColorLevel())
        {
          paramDragFrameLayout = new StringBuilder();
          paramDragFrameLayout.append("onChange->drag red dot:");
          paramDragFrameLayout.append(((ServiceAccountFolderFeed)localObject1).a);
          QLog.d("FolderRecommendTabFragment", 2, paramDragFrameLayout.toString());
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getBaseActivity()).inflate(2131558741, null);
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
    IlivePreloadHelper.a(getBaseActivity(), 2);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
    if (localObject != null)
    {
      ((BlockContainer)localObject).b();
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock;
    if ((localObject != null) && (((FolderRecommendTabFragment.RecommendHeaderBlock)localObject).a != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock.a = null;
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$RecommendHeaderBlock = null;
    }
    localObject = jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null)
    {
      ((DragFrameLayout)localObject).a(this);
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
    DragFrameLayout localDragFrameLayout = jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((getBaseActivity() instanceof ServiceAccountFolderActivityNew)) {
      ((ServiceAccountFolderActivityNew)getBaseActivity()).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment
 * JD-Core Version:    0.7.0.1
 */