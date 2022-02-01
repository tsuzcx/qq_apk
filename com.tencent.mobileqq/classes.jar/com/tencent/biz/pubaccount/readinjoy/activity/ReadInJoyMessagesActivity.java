package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewAdapter;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyMessagesActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, KandianMergeManager.OnTabRedNumsChangeListenner, DragFrameLayout.OnDragModeChangedListener, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener
{
  public static int a;
  public static final String a;
  public static int b;
  public long a;
  public View a;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyMessagesActivity.1(this);
  private SubscriptFeedsNewAdapter jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter;
  protected DragFrameLayout a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new ReadInJoyMessagesActivity.2(this);
  private List<SubscriptionFeed> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private long b;
  public boolean b;
  private int c = 0;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713082);
  }
  
  public ReadInJoyMessagesActivity()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static DragFrameLayout a(Activity paramActivity)
  {
    DragFrameLayout localDragFrameLayout = null;
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    int i = 0;
    View localView = null;
    for (;;)
    {
      if (i < localViewGroup.getChildCount())
      {
        localView = localViewGroup.getChildAt(i);
        if ((localView instanceof DragFrameLayout)) {
          return (DragFrameLayout)localView;
        }
        if (!(localView instanceof TopGestureLayout)) {}
      }
      else
      {
        if (localView != null)
        {
          localDragFrameLayout = new DragFrameLayout(paramActivity.getApplication());
          localViewGroup.addView(localDragFrameLayout, 0);
          localViewGroup.removeView(localView);
          if (localView.getParent() != null) {
            ((ViewGroup)localView.getParent()).removeView(localView);
          }
          localDragFrameLayout.addView(localView);
        }
        return localDragFrameLayout;
      }
      i += 1;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    setContentView(2131560405);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = a(getActivity());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    setTitle(jdField_a_of_type_JavaLangString);
    this.leftView.setText(HardCodeUtil.a(2131712901));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366350);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131366898));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDivider(getResources().getDrawable(2131166380));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131296926));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter = new SubscriptFeedsNewAdapter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, getActivity().getLayoutInflater());
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166104);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
  }
  
  private void d()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyWebDataManager localReadInJoyWebDataManager;
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localReadInJoyWebDataManager = ReadInJoyWebDataManager.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        break label48;
      }
    }
    label48:
    for (int i = 0;; i = 1)
    {
      localReadInJoyWebDataManager.a(str, i);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379849)).setText(HardCodeUtil.a(2131712888));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373647)).setImageResource(2130843020);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166104);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130851162);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166104);
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label161;
      }
      if ((SystemUtil.b()) || (SystemUtil.d())) {
        break label140;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849916);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label140:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label161:
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if ((!SystemUtil.b()) && (!SystemUtil.d()))
      {
        this.mSystemBarComp.setStatusBarColor(-4210753);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void a(List<SubscriptionFeed> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    if (this.c != 0)
    {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyMessagesActivity.3(this, paramList), 1500L);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.b();
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.c();
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.notifyDataSetChanged();
    e();
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380941))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.a().getTag(2131378697);
      if (paramDragFrameLayout != null)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.jdField_a_of_type_JavaLangString, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.jdField_b_of_type_Int, "", "", "");
        paramDragFrameLayout.a();
      }
    }
  }
  
  public void ai_()
  {
    ((ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().e();
    ReadInJoyWebDataManager localReadInJoyWebDataManager;
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localReadInJoyWebDataManager = ReadInJoyWebDataManager.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        break label57;
      }
    }
    label57:
    for (int i = 0;; i = 1)
    {
      localReadInJoyWebDataManager.a(str, i);
      return;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    c();
    a();
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(null);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().e();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_private_letter_count", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c());
    setResult(-1, localIntent);
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (getIntent().getBooleanExtra("shouldBackSelfAct", false))
    {
      Intent localIntent = new Intent(this, ReadInJoySelfActivity.class);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
    case 2131378694: 
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      } while (((Integer)paramView.getTag(2131378698)).intValue() != SubscriptFeedsAdapter.d);
      localObject2 = paramView.getTag(2131378697);
      Object localObject3 = paramView.getTag(2131378706);
      Integer localInteger;
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label527;
        }
        i = ((Integer)localObject2).intValue();
        localInteger = Integer.valueOf(i);
        if (localInteger.intValue() <= 0) {
          break label532;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject2 = "";
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
          ((JSONObject)localObject3).put("reddot_num", localInteger);
          localObject3 = ((JSONObject)localObject3).toString();
          localObject2 = localObject3;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            localObject2 = "";
          }
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, (String)localObject1, "0X8007DB3", "0X8007DB3", 0, 0, "", "", "", (String)localObject2, false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80081C8", "0X80081C8", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(localInteger.intValue()), false);
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject1)))
        {
          localObject2 = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
          if (localObject2 != null) {
            ((PublicAccountHandler)localObject2).a();
          }
        }
        localObject2 = paramView.getTag(2131378699);
        if (localObject2 == null) {
          break label581;
        }
        localObject2 = (String)localObject2;
        localObject3 = new Intent(getActivity(), ChatActivity.class);
        ((Intent)localObject3).putExtra("uintype", 1008);
        ((Intent)localObject3).putExtra("uin", (String)localObject1);
        ((Intent)localObject3).putExtra("uinname", (String)localObject2);
        ((Intent)localObject3).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("red_hot_count", localInteger);
        ((Intent)localObject3).putExtra("is_come_from_readinjoy", true);
        getActivity().startActivity((Intent)localObject3);
        PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
        break;
        localObject1 = "";
        break label121;
        i = 0;
        break label135;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
      }
    case 2131371190: 
      localObject1 = paramView.getTag(2131378706);
      if (localObject1 != null) {}
      for (localObject1 = (String)localObject1;; localObject1 = "")
      {
        ReadInJoyLogicEngine.a().a((String)localObject1);
        break;
      }
    case 2131371196: 
      localObject1 = paramView.getTag(2131378706);
      if (localObject1 != null) {}
      for (localObject1 = (String)localObject1;; localObject1 = "")
      {
        ReadInJoyLogicEngine.a().b((String)localObject1);
        break;
      }
    case 2131371195: 
      localObject1 = paramView.getTag(2131378706);
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        localObject2 = paramView.getTag(2131378699);
        if (localObject2 == null) {
          break label801;
        }
      }
      label801:
      for (localObject2 = (String)localObject2;; localObject2 = "")
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
        localActionSheet.setMainTitle(String.format(getResources().getString(2131696491), new Object[] { localObject2 }));
        localActionSheet.addButton(2131696427, 3);
        localActionSheet.addCancelButton(2131690800);
        localActionSheet.setOnButtonClickListener(new ReadInJoyMessagesActivity.4(this, (String)localObject1, localActionSheet));
        localActionSheet.show();
        break;
        localObject1 = "";
        break label690;
      }
    case 2131371178: 
      label121:
      localObject1 = paramView.getTag(2131378706);
      label135:
      label527:
      label532:
      label581:
      if (localObject1 != null) {}
      label690:
      for (localObject1 = (String)localObject1;; localObject1 = "")
      {
        ReadInJoyLogicEngine.a().c((String)localObject1);
        break;
      }
    }
    int j = ((Integer)paramView.getTag(2131378698)).intValue();
    int i = ((Integer)paramView.getTag(2131376509)).intValue();
    if (j == SubscriptFeedsAdapter.e) {
      ReadInJoyUtils.a(this, (String)paramView.getTag(2131378926));
    }
    j = ((Integer)paramView.getTag(2131376508)).intValue();
    if (j == jdField_a_of_type_Int) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(i), false);
    }
    for (;;)
    {
      paramView.findViewById(2131380941).setVisibility(8);
      paramView.findViewById(2131363042).setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.l();
      break;
      if (j == jdField_b_of_type_Int) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80080F2", "0X80080F2", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(i), false);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onRightIconMenuHide(View paramView) {}
  
  public void onRightIconMenuShow(View paramView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.c = paramInt;
    switch (paramInt)
    {
    default: 
      DropFrameMonitor.a().a("list_subscript");
      return;
    }
    DropFrameMonitor.a().a("list_subscript", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity
 * JD-Core Version:    0.7.0.1
 */