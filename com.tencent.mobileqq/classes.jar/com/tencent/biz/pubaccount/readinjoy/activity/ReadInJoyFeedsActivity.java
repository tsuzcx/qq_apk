package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.SubscriptionViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJWebSearchUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyFeedsActivity
  extends ReadInJoyBaseActivity
  implements View.OnClickListener, View.OnTouchListener, Observer
{
  private long jdField_a_of_type_Long = 0L;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected AccountDetailTopGestureLayout a;
  private ReadInJoyFeedsActivity.OnDoubleClick jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity$OnDoubleClick;
  protected ReadInJoyObserver a;
  protected Map<Integer, ReadInJoyBaseViewController> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  public boolean a;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  
  public ReadInJoyFeedsActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyFeedsActivity.7(this);
  }
  
  private void a(KandianMergeManager paramKandianMergeManager)
  {
    if (!paramKandianMergeManager.d()) {}
    for (boolean bool = true;; bool = false)
    {
      paramKandianMergeManager.b(bool);
      if (!bool) {
        break;
      }
      QQToast.a(this, getResources().getString(2131699736), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
  }
  
  private void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (paramMenuItem.jdField_a_of_type_Int == 3) {
      ReadInJoyUtils.jdField_a_of_type_Int = -2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyBaseActivity", 1, "readinjoy setting feeds type:" + ReadInJoyUtils.jdField_a_of_type_Int);
      return;
      if (paramMenuItem.jdField_a_of_type_Int == 4) {
        ReadInJoyUtils.jdField_a_of_type_Int = -1;
      } else if (paramMenuItem.jdField_a_of_type_Int == 5) {
        ReadInJoyUtils.jdField_a_of_type_Int = 1;
      } else if (paramMenuItem.jdField_a_of_type_Int == 6) {
        ReadInJoyUtils.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  private void a(PopupMenuDialog.MenuItem paramMenuItem, KandianMergeManager paramKandianMergeManager)
  {
    if (paramKandianMergeManager.d()) {
      paramKandianMergeManager = getString(2131720306);
    }
    for (int i = 2130842678;; i = 2130842679)
    {
      paramMenuItem.jdField_a_of_type_Int = 0;
      paramMenuItem.jdField_a_of_type_JavaLangString = paramKandianMergeManager;
      paramMenuItem.c = paramMenuItem.jdField_a_of_type_JavaLangString;
      paramMenuItem.jdField_b_of_type_Int = i;
      return;
      paramKandianMergeManager = getString(2131699737);
    }
  }
  
  private void a(List<PopupMenuDialog.MenuItem> paramList) {}
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = (KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    Object localObject1 = getString(2131694831);
    ArrayList localArrayList = new ArrayList();
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    a(localMenuItem, (KandianMergeManager)localObject2);
    localArrayList.add(localMenuItem);
    localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.jdField_a_of_type_Int = 1;
    localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject1);
    localMenuItem.c = localMenuItem.jdField_a_of_type_JavaLangString;
    localMenuItem.jdField_b_of_type_Int = 2130842676;
    localArrayList.add(localMenuItem);
    if (paramBoolean)
    {
      localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 2;
      if (!ReadInJoyHelper.d(getAppRuntime())) {
        break label318;
      }
    }
    label318:
    for (localObject1 = HardCodeUtil.a(2131712767);; localObject1 = HardCodeUtil.a(2131712973))
    {
      localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localMenuItem.jdField_b_of_type_Int = 2130849708;
      localMenuItem.c = localMenuItem.jdField_a_of_type_JavaLangString;
      localArrayList.add(localMenuItem);
      a(localArrayList);
      localObject1 = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_Int = 7;
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712963);
      ((PopupMenuDialog.MenuItem)localObject1).jdField_b_of_type_Int = 2130842680;
      localArrayList.add(localObject1);
      localObject1 = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_Int = 8;
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712861);
      ((PopupMenuDialog.MenuItem)localObject1).jdField_b_of_type_Int = 2130842677;
      localArrayList.add(localObject1);
      if (paramBoolean) {}
      localObject1 = PopupMenuDialog.a(this, localArrayList, new ReadInJoyFeedsActivity.5(this, (KandianMergeManager)localObject2));
      localObject2 = this.jdField_b_of_type_AndroidViewViewGroup;
      ((PopupMenuDialog)localObject1).showAsDropDown((View)localObject2, ((View)localObject2).getWidth() - getResources().getDimensionPixelSize(2131298898) - getResources().getDimensionPixelSize(2131298894), getResources().getDimensionPixelSize(2131298219));
      return;
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377161));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376619));
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      this.jdField_e_of_type_Int = j;
      c(j);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840478);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713008));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_Int != 5)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690778));
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
      f();
    }
  }
  
  private void b(PopupMenuDialog.MenuItem paramMenuItem, KandianMergeManager paramKandianMergeManager)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    switch (paramMenuItem.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramKandianMergeManager);
      return;
    case 1: 
      c();
      return;
    case 2: 
      paramMenuItem = getAppRuntime();
      if (!ReadInJoyHelper.d(getAppRuntime())) {}
      for (;;)
      {
        ReadInJoyHelper.b(paramMenuItem, bool1);
        ReadInJoyLogicEngineEventDispatcher.a().c();
        return;
        bool1 = false;
      }
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      a(paramMenuItem);
      return;
    case 7: 
      d();
      return;
    case 8: 
      e();
      return;
    case 9: 
      paramMenuItem = getAppRuntime();
      if (!ReadInJoyHelper.f(getAppRuntime())) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ReadInJoyHelper.e(paramMenuItem, bool1);
        return;
      }
    }
    paramMenuItem = getAppRuntime();
    if (!ReadInJoyHelper.i(getAppRuntime())) {}
    for (bool1 = bool3;; bool1 = false)
    {
      ReadInJoyHelper.h(paramMenuItem, bool1);
      return;
    }
  }
  
  private void c()
  {
    ThreadManager.postImmediately(new ReadInJoyFeedsActivity.6(this), null, true);
    startActivity(new Intent(this, ReadInJoySettingActivity.class));
    ReportController.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", RIJTransMergeKanDianReport.a());
  }
  
  private void c(int paramInt)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeAllViews();
    ReadInJoyBaseViewController localReadInJoyBaseViewController;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(false);
      d(0);
      ReadInJoyLogicEngine.a().g();
      localObject = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new KanDianViewController(this);
        ((ReadInJoyBaseViewController)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
        ((ReadInJoyBaseViewController)localObject).a();
        localReadInJoyBaseViewController = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
        if (localReadInJoyBaseViewController != null) {
          localReadInJoyBaseViewController.c();
        }
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        return;
        ((ReadInJoyBaseViewController)localObject).b();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(true);
    e(0);
    ReadInJoyLogicEngine.a().f();
    Object localObject = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new SubscriptionViewController(this);
      ((ReadInJoyBaseViewController)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
      ((ReadInJoyBaseViewController)localObject).a();
    }
    for (;;)
    {
      localReadInJoyBaseViewController = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(0));
      if (localReadInJoyBaseViewController != null) {
        localReadInJoyBaseViewController.c();
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      return;
      ((ReadInJoyBaseViewController)localObject).b();
    }
  }
  
  private void d()
  {
    String str = ReadInJoyUtils.a();
    if (TextUtils.isEmpty(str)) {
      QLog.e("ReadInJoyBaseActivity", 2, "click personal page , but uin is empty !");
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8007384", "0X8007384", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      return;
      ReadInJoyUtils.a(this, ReadInJoyConstants.g + Base64Util.encodeToString(str.getBytes(), 2));
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a(false);
  }
  
  private void e()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8007383", "0X8007383", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    if (Boolean.valueOf(ReadInJoyHelper.v(ReadInJoyUtils.a())).booleanValue())
    {
      ViolaAccessHelper.a(this, HardCodeUtil.a(2131712776), ViolaAccessHelper.a(ReadInJoyUtils.a()) + "&adtag=1&privateLetters=", null);
      return;
    }
    ReadInJoyUtils.a(this, ReadInJoyConstants.d);
  }
  
  private void e(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
  }
  
  private void f()
  {
    KanDianViewController localKanDianViewController = new KanDianViewController(this);
    localKanDianViewController.a(this.jdField_c_of_type_AndroidViewViewGroup);
    localKanDianViewController.a();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_e_of_type_Int), localKanDianViewController);
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ThreadManager.post(new ReadInJoyFeedsActivity.3(this), 5, null, true);
    }
  }
  
  void a(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.jdField_c_of_type_Int != 5) || (6 == this.jdField_c_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyFeedsActivity.4(this, paramInt));
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int |= paramInt;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 80;
    int i;
    if (paramInt1 == 9992)
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))) {
        finish();
      }
    }
    else if (paramInt1 == 9991)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseActivity", 2, "back from article detail");
      }
      if (RIJWebSearchUtils.a())
      {
        i = j;
        if (TextUtils.isEmpty(PublicAccountConfigUtilImpl.readInJoyReleaseWebServiceConfig)) {}
      }
    }
    try
    {
      i = new JSONObject(PublicAccountConfigUtilImpl.readInJoyReleaseWebServiceConfig).optInt("releaseServiceMinMem", 80);
      long l = DeviceInfoUtil.e();
      if (l >>> 20 <= i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "back from article detail, release web core service");
        }
        ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
      }
      try
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        ((HashMap)localObject).put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
        ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
        ((HashMap)localObject).put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
        ((HashMap)localObject).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.b()));
        ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
        }
        StatisticCollector.getInstance(this).collectPerformance(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
      }
      catch (Exception localException1)
      {
        Object localObject;
        label294:
        break label294;
      }
      localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2, paramIntent);
      }
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    VideoVolumeControl.a().a(this);
    super.doOnCreate(paramBundle);
    ReadInJoyHelper.c(this.app);
    ReadInJoyHelper.d(this.app);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).h();
    }
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    ReadInJoyLogicEngineEventDispatcher.a().a();
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    int i = NetworkUtil.a(getApplication());
    if ((i == 4) || (i == 1)) {
      ThreadManager.post(new ReadInJoyFeedsActivity.1(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyFeedsActivity.MyRunnable(this, this));
    setContentView(2131560312);
    getWindow().setBackgroundDrawable(null);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyLogicEngine.a().h();
    ReadInJoyLogicEngine.a().d();
    setTitle(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(this.app, this.app.getApp()));
    b();
    this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity$OnDoubleClick = new ReadInJoyFeedsActivity.OnDoubleClick((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int)));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity$OnDoubleClick);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().addObserver(this);
    }
    if (ReadInJoyHelper.a(this.app)) {
      TroopBarAssistantManager.a().c(this.app);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyHelper.a(this.app);
    this.jdField_b_of_type_Int = RIJKanDianFolderStatus.jdField_a_of_type_Int;
    ReadinjoyReportUtils.a(1, true, 0L, this.jdField_b_of_type_Int, 0);
    RIJThreadHandler.a(this.app);
    return true;
  }
  
  public void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.doOnDestroy();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", RIJTransMergeKanDianReport.b(), false);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).d();
    }
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    localObject = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyLogicEngine.a().i();
    VideoVolumeControl.a().b(this);
    PreloadManager.a().b();
    PreloadManager.a().e();
    ReadinjoyReportUtils.a(1, false, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    PublicAccountImageCollectionPreloadManager.a().d();
    PublicAccountImageCollectionPreloadManager.a().c();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).releaseLightWebProcess();
    ReadInJoyWebDataManager.a();
    ReadInJoyWebDataManager.a().b();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("from_search", false);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("from_javascript", false);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.jdField_e_of_type_Int = j;
      c(j);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      PublicTracker.a("KANDIAN_FEEDS_STAGE_1_COST", null);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ReadInJoyLogicEngine.a().j();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).e();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    ReadInJoyLogicEngine.a().k();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).f();
    }
  }
  
  public void finish()
  {
    super.finish();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).n();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ReadInJoyHelper.a(this.app))
      {
        a(false);
        continue;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a()) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D0", "0X80067D0", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
        }
        for (;;)
        {
          if (this.jdField_e_of_type_Int != 0) {
            break label188;
          }
          ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
          break;
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067CF", "0X80067CF", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
        }
        label188:
        this.jdField_e_of_type_Int = 0;
        c(this.jdField_e_of_type_Int);
        ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(0);
        continue;
        PublicTracker.a(null, "KANDIAN_TO_SUBSCRIPT_COST");
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D2", "0X80067D2", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
        }
        for (;;)
        {
          if (this.jdField_e_of_type_Int != 1) {
            break label351;
          }
          ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
          break;
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D1", "0X80067D1", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
        }
        label351:
        this.jdField_e_of_type_Int = 1;
        c(this.jdField_e_of_type_Int);
        ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(1);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && ((paramObject instanceof MessageRecord)) && (KandianMergeManager.a((MessageRecord)paramObject, this.app) == -1) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity
 * JD-Core Version:    0.7.0.1
 */