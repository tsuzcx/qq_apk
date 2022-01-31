package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.SubscriptionViewController;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
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
import lda;
import lde;
import ldf;
import ldg;
import ldi;
import ldj;
import ldk;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyFeedsActivity
  extends ReadInJoyBaseActivity
  implements View.OnClickListener, View.OnTouchListener, Observer
{
  private long jdField_a_of_type_Long;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected AccountDetailTopGestureLayout a;
  protected ReadInJoyObserver a;
  public Map a;
  private ldk jdField_a_of_type_Ldk;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  public boolean a;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  
  public ReadInJoyFeedsActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ldi(this);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = (KandianMergeManager)this.app.getManager(161);
    int i;
    Object localObject3;
    ArrayList localArrayList;
    if (((KandianMergeManager)localObject2).c())
    {
      localObject1 = getString(2131436480);
      i = 2130840529;
      localObject3 = getString(2131437153);
      localArrayList = new ArrayList();
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 0;
      localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localMenuItem.c = localMenuItem.jdField_a_of_type_JavaLangString;
      localMenuItem.jdField_b_of_type_Int = i;
      localArrayList.add(localMenuItem);
      localObject1 = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_Int = 1;
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
      ((PopupMenuDialog.MenuItem)localObject1).c = ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString;
      ((PopupMenuDialog.MenuItem)localObject1).jdField_b_of_type_Int = 2130840527;
      localArrayList.add(localObject1);
      if (paramBoolean)
      {
        localObject3 = new PopupMenuDialog.MenuItem();
        ((PopupMenuDialog.MenuItem)localObject3).jdField_a_of_type_Int = 2;
        if (!ReadInJoyHelper.d(getAppRuntime())) {
          break label355;
        }
      }
    }
    label355:
    for (Object localObject1 = "关推荐原因";; localObject1 = "开推荐原因")
    {
      ((PopupMenuDialog.MenuItem)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((PopupMenuDialog.MenuItem)localObject3).jdField_b_of_type_Int = 2130845279;
      ((PopupMenuDialog.MenuItem)localObject3).c = ((PopupMenuDialog.MenuItem)localObject3).jdField_a_of_type_JavaLangString;
      localArrayList.add(localObject3);
      localObject1 = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_Int = 7;
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString = "个人主页";
      ((PopupMenuDialog.MenuItem)localObject1).jdField_b_of_type_Int = 2130840531;
      localArrayList.add(localObject1);
      localObject1 = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_Int = 8;
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString = "我的消息";
      ((PopupMenuDialog.MenuItem)localObject1).jdField_b_of_type_Int = 2130840528;
      localArrayList.add(localObject1);
      if (paramBoolean) {}
      localObject1 = PopupMenuDialog.a(this, localArrayList, new ldg(this, (KandianMergeManager)localObject2));
      localObject2 = this.jdField_b_of_type_AndroidViewViewGroup;
      ((PopupMenuDialog)localObject1).showAsDropDown((View)localObject2, ((View)localObject2).getWidth() - getResources().getDimensionPixelSize(2131558947) - getResources().getDimensionPixelSize(2131558951), getResources().getDimensionPixelSize(2131558966));
      return;
      localObject1 = getString(2131428472);
      i = 2130840530;
      break;
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367043));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131367167));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839143);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("设置");
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_Int != 5)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131433681));
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
      c();
    }
  }
  
  private void c()
  {
    KanDianViewController localKanDianViewController = new KanDianViewController(this);
    localKanDianViewController.a(this.jdField_c_of_type_AndroidViewViewGroup);
    localKanDianViewController.a();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_e_of_type_Int), localKanDianViewController);
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
      ReadInJoyLogicEngine.a().h();
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
    ReadInJoyLogicEngine.a().g();
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
  
  private void d(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a(false);
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
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ThreadManager.post(new lde(this), 5, null, true);
    }
  }
  
  public void a(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.jdField_c_of_type_Int != 5) || (6 == this.jdField_c_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ldf(this, paramInt));
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int |= paramInt;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
      if (ReadInJoyUtils.f())
      {
        i = j;
        if (TextUtils.isEmpty(PublicAccountConfigUtil.j)) {}
      }
    }
    try
    {
      i = new JSONObject(PublicAccountConfigUtil.j).optInt("releaseServiceMinMem", 80);
      long l = DeviceInfoUtil.f();
      if (l >>> 20 <= i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "back from article detail, release web core service");
        }
        WebProcessManager.g();
      }
      try
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        ((HashMap)localObject).put("param_totalMem", String.valueOf(DeviceInfoUtil.e()));
        ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
        ((HashMap)localObject).put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
        ((HashMap)localObject).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.a()));
        ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
        }
        StatisticCollector.a(this).a(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
      }
      catch (Exception localException1)
      {
        Object localObject;
        label287:
        break label287;
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    VideoVolumeControl.a().a(this);
    super.doOnCreate(paramBundle);
    ReadInJoyHelper.c(this.app);
    ReadInJoyHelper.d(this.app);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(161)).e();
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
      ThreadManager.post(new lda(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new ldj(this, this));
    setContentView(2130969616);
    getWindow().setBackgroundDrawable(null);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(162);
    ReadInJoyLogicEngine.a().i();
    ReadInJoyLogicEngine.a().d();
    setTitle(PublicAccountConfigUtil.b(this.app, this.app.getApp()));
    b();
    this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_Ldk = new ldk((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int)));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, this.jdField_a_of_type_Ldk);
    if (this.app.a() != null) {
      this.app.a().addObserver(this);
    }
    if (ReadInJoyHelper.a(this.app)) {
      TroopBarAssistantManager.a().c(this.app);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyHelper.a(this.app);
    this.jdField_b_of_type_Int = ReadInJoyUtils.jdField_d_of_type_Int;
    ReadinjoyReportUtils.a(1, true, 0L, this.jdField_b_of_type_Int, 0);
    ReadInJoyUtils.g(this.app);
    return true;
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.doOnDestroy();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L) {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", ReadInJoyUtils.d(), false);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).d();
    }
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    localObject = (ReadInJoyLogicManager)this.app.getManager(162);
    ReadInJoyLogicEngine.a().j();
    VideoVolumeControl.a().b(this);
    PreloadManager.a().b();
    PreloadManager.a().e();
    ReadinjoyReportUtils.a(1, false, l, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    ReadInJoyArkViewController.a().a();
    PublicAccountImageCollectionPreloadManager.a().d();
    PublicAccountImageCollectionPreloadManager.a().c();
    WebProcessManager.g();
    WebProcessManager.h();
    ReadInJoyWebDataManager.a();
    ReadInJoyWebDataManager.a().b();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
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
  
  protected void doOnPause()
  {
    super.doOnPause();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
  
  protected void doOnResume()
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
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ReadInJoyLogicEngine.a().k();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).e();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    ReadInJoyLogicEngine.a().l();
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
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).o();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363456: 
      do
      {
        return;
      } while (!ReadInJoyHelper.a(this.app));
      a(false);
      return;
    case 2131367177: 
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a()) {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D0", "0X80067D0", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
      }
      while (this.jdField_e_of_type_Int == 0)
      {
        ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
        return;
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067CF", "0X80067CF", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
      }
      this.jdField_e_of_type_Int = 0;
      c(this.jdField_e_of_type_Int);
      ((KandianMergeManager)this.app.getManager(161)).b(0);
      return;
    }
    PublicTracker.a(null, "KANDIAN_TO_SUBSCRIPT_COST");
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D2", "0X80067D2", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
    }
    while (this.jdField_e_of_type_Int == 1)
    {
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
      return;
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D1", "0X80067D1", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
    }
    this.jdField_e_of_type_Int = 1;
    c(this.jdField_e_of_type_Int);
    ((KandianMergeManager)this.app.getManager(161)).b(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity
 * JD-Core Version:    0.7.0.1
 */