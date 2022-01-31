package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
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
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
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
import ldm;
import ldn;
import ldo;
import ldp;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyMessagesActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, KandianMergeManager.OnTabRedNumsChangeListenner, DragFrameLayout.OnDragModeChangedListener, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener
{
  public static int a;
  public static int b;
  public View a;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ldm(this);
  private SubscriptFeedsNewAdapter jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter;
  protected DragFrameLayout a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new ldn(this);
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  public boolean b;
  private int c = 0;
  
  static
  {
    jdField_b_of_type_Int = 1;
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
    setContentView(2130969649);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = a(getActivity());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    setTitle("私信");
    this.leftView.setText("返回");
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363098);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131367292));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDivider(getResources().getDrawable(2131493231));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131560405));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter = new SubscriptFeedsNewAdapter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, getActivity().getLayoutInflater());
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131493588);
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b() > 0) {
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
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368250)).setText(2131428459);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131493588);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130846277);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131493588);
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
      this.leftView.setBackgroundResource(2130845305);
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
  
  public void a(View paramView) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
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
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(List paramList)
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
      ThreadManager.getUIHandler().postDelayed(new ldo(this, paramList), 1500L);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131366789))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.a().getTag(2131362114);
      if (paramDragFrameLayout != null)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.a, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.jdField_b_of_type_Int, "", "", "");
        paramDragFrameLayout.a();
      }
    }
  }
  
  public void b()
  {
    ((ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a().e();
    ReadInJoyWebDataManager localReadInJoyWebDataManager;
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localReadInJoyWebDataManager = ReadInJoyWebDataManager.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b() > 0) {
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
  
  public void b(View paramView) {}
  
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
    ((ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a().e();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_private_letter_count", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d());
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
    case 2131367437: 
      do
      {
        return;
      } while (((Integer)paramView.getTag(2131362113)).intValue() != SubscriptFeedsAdapter.d);
      localObject2 = paramView.getTag(2131362114);
      Object localObject3 = paramView.getTag(2131362115);
      Integer localInteger;
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label490;
        }
        i = ((Integer)localObject2).intValue();
        localInteger = Integer.valueOf(i);
        if (localInteger.intValue() <= 0) {
          break label495;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject2 = "";
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("folder_status", ReadInJoyUtils.d);
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
            paramView = "";
          }
        }
        PublicAccountReportUtils.a(null, (String)localObject1, "0X8007DB3", "0X8007DB3", 0, 0, "", "", "", (String)localObject2, false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80081C8", "0X80081C8", 0, 0, "", "", "", ReadInJoyUtils.b(localInteger.intValue()), false);
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject1)))
        {
          localObject2 = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
          if (localObject2 != null) {
            ((PublicAccountHandler)localObject2).a();
          }
        }
        paramView = paramView.getTag(2131362116);
        if (paramView == null) {
          break label544;
        }
        paramView = (String)paramView;
        localObject2 = new Intent(getActivity(), ChatActivity.class);
        ((Intent)localObject2).putExtra("uintype", 1008);
        ((Intent)localObject2).putExtra("uin", (String)localObject1);
        ((Intent)localObject2).putExtra("uinname", paramView);
        ((Intent)localObject2).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject2).putExtra("red_hot_count", localInteger);
        ((Intent)localObject2).putExtra("is_come_from_readinjoy", true);
        getActivity().startActivity((Intent)localObject2);
        PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
        return;
        localObject1 = "";
        break;
        i = 0;
        break label128;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
      }
    case 2131367443: 
      paramView = paramView.getTag(2131362115);
      if (paramView != null) {}
      for (paramView = (String)paramView;; paramView = "")
      {
        ReadInJoyLogicEngine.a().a(paramView);
        return;
      }
    case 2131367444: 
      paramView = paramView.getTag(2131362115);
      if (paramView != null) {}
      for (paramView = (String)paramView;; paramView = "")
      {
        ReadInJoyLogicEngine.a().b(paramView);
        return;
      }
    case 2131365662: 
      localObject1 = paramView.getTag(2131362115);
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        paramView = paramView.getTag(2131362116);
        if (paramView == null) {
          break label740;
        }
      }
      for (paramView = (String)paramView;; paramView = "")
      {
        localObject2 = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
        ((ActionSheet)localObject2).a(String.format(getResources().getString(2131430077), new Object[] { paramView }));
        ((ActionSheet)localObject2).a(2131430037, 3);
        ((ActionSheet)localObject2).c(2131432998);
        ((ActionSheet)localObject2).a(new ldp(this, (String)localObject1, (ActionSheet)localObject2));
        ((ActionSheet)localObject2).show();
        return;
        localObject1 = "";
        break;
      }
    case 2131365663: 
      label128:
      label490:
      label495:
      paramView = paramView.getTag(2131362115);
      label544:
      label740:
      if (paramView != null) {}
      for (paramView = (String)paramView;; paramView = "")
      {
        ReadInJoyLogicEngine.a().c(paramView);
        return;
      }
    }
    int j = ((Integer)paramView.getTag(2131362113)).intValue();
    int i = ((Integer)paramView.getTag(2131362409)).intValue();
    if (j == SubscriptFeedsAdapter.e) {
      ReadInJoyUtils.a(this, (String)paramView.getTag(2131362360));
    }
    j = ((Integer)paramView.getTag(2131362411)).intValue();
    if (j == jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", ReadInJoyUtils.b(i), false);
    }
    for (;;)
    {
      paramView.findViewById(2131366789).setVisibility(8);
      paramView.findViewById(2131366791).setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.k();
      return;
      if (j == jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.e();
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080F2", "0X80080F2", 0, 0, "", "", "", ReadInJoyUtils.b(i), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity
 * JD-Core Version:    0.7.0.1
 */