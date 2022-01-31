package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg;
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
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;
import lqp;
import lqq;
import lqr;
import lqs;
import lqt;
import lqu;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoySubscribeFragement
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, DragFrameLayout.OnDragModeChangedListener, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  public View a;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lqs(this);
  private SubscriptFeedsNewAdapter jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  protected DragFrameLayout a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new lqp(this);
  private List jdField_a_of_type_JavaUtilList;
  private lqu jdField_a_of_type_Lqu;
  private View jdField_b_of_type_AndroidViewView;
  private QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  protected boolean b;
  public boolean c;
  public boolean d;
  private boolean e;
  
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
          localDragFrameLayout.addView(localView);
        }
        return localDragFrameLayout;
      }
      i += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      localObject = null;
      i = 0;
      if (i >= localViewGroup.getChildCount()) {
        break label113;
      }
      View localView = localViewGroup.getChildAt(i);
      localObject = localView;
      if ((localView instanceof DragFrameLayout)) {
        localObject = ((DragFrameLayout)localView).getChildAt(0);
      }
      if (!(localObject instanceof TopGestureLayout)) {
        break label106;
      }
    }
    label106:
    label113:
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewView = getActivity().getLayoutInflater().inflate(2130969653, null);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = a(getActivity());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131363120);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367349));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDivider(getResources().getDrawable(2131493232));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131560424));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    if (ReadInJoyHelper.k(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface) == 1)
    {
      this.jdField_a_of_type_Lqu = new lqu(this, getActivity(), this.jdField_a_of_type_ComTencentWidgetSwipListView);
      this.jdField_a_of_type_Lqu.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter = new SubscriptFeedsNewAdapter(getActivity(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, getActivity().getLayoutInflater());
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131493596);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
  }
  
  private void h()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368319)).setText(2131428465);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131493596);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130846489);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131493596);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentWidgetSwipListView.isStackFromBottom()) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setStackFromBottom(true);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setStackFromBottom(false);
  }
  
  public void a(View paramView)
  {
    a(false);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (paramInt == KandianOx210MsgInfo.l)
    {
      KandianOx210MsgInfo.Biu0x210Msg localBiu0x210Msg = ((KandianMergeManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a();
      if (localBiu0x210Msg != null)
      {
        localBiu0x210Msg.a();
        ThreadManager.getUIHandler().post(new lqt(this, localBiu0x210Msg));
      }
    }
    super.a(paramMessageRecord, paramInt, paramBundle);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      ThreadManager.getUIHandler().postDelayed(new lqq(this, paramList), 1500L);
      return;
    }
    this.d = true;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.c();
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.notifyDataSetChanged();
    i();
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131366830))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.a().getTag(2131362114);
      if (paramDragFrameLayout != null)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.a, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.b, "", "", "");
        paramDragFrameLayout.a();
      }
    }
  }
  
  public void b(View paramView)
  {
    a(true);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    ReadInJoyLogicEngine.a().f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
    super.b(paramMessageRecord);
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_a_of_type_ComTencentWidgetSwipListView.isStackFromBottom()) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setStackFromBottom(true);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setStackFromBottom(false);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
    case 2131367512: 
      do
      {
        return;
      } while (((Integer)paramView.getTag(2131362113)).intValue() != SubscriptFeedsAdapter.d);
      localObject2 = paramView.getTag(2131362114);
      Object localObject3 = paramView.getTag(2131362115);
      int i;
      Integer localInteger;
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label428;
        }
        i = ((Integer)localObject2).intValue();
        localInteger = Integer.valueOf(i);
        if (localInteger.intValue() <= 0) {
          break label433;
        }
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
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
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject1)))
        {
          localObject2 = (PublicAccountHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
          if (localObject2 != null) {
            ((PublicAccountHandler)localObject2).a();
          }
        }
        paramView = paramView.getTag(2131362116);
        if (paramView == null) {
          break label482;
        }
        paramView = (String)paramView;
        localObject2 = new Intent(getActivity(), ChatActivity.class);
        ((Intent)localObject2).putExtra("uintype", 1008);
        ((Intent)localObject2).putExtra("uin", (String)localObject1);
        ((Intent)localObject2).putExtra("uinname", paramView);
        ((Intent)localObject2).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject2).putExtra("red_hot_count", localInteger);
        getActivity().startActivity((Intent)localObject2);
        PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
        return;
        localObject1 = "";
        break;
        i = 0;
        break label119;
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
      }
    case 2131367518: 
      paramView = paramView.getTag(2131362115);
      if (paramView != null) {}
      for (paramView = (String)paramView;; paramView = "")
      {
        ReadInJoyLogicEngine.a().a(paramView);
        return;
      }
    case 2131367519: 
      paramView = paramView.getTag(2131362115);
      if (paramView != null) {}
      for (paramView = (String)paramView;; paramView = "")
      {
        ReadInJoyLogicEngine.a().b(paramView);
        return;
      }
    case 2131365694: 
      label119:
      localObject1 = paramView.getTag(2131362115);
      label428:
      label433:
      label482:
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        paramView = paramView.getTag(2131362116);
        if (paramView == null) {
          break label672;
        }
      }
      label672:
      for (paramView = (String)paramView;; paramView = "")
      {
        localObject2 = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
        ((ActionSheet)localObject2).a(String.format(getResources().getString(2131430096), new Object[] { paramView }));
        ((ActionSheet)localObject2).a(2131430056, 3);
        ((ActionSheet)localObject2).c(2131433029);
        ((ActionSheet)localObject2).a(new lqr(this, (String)localObject1, (ActionSheet)localObject2));
        ((ActionSheet)localObject2).show();
        return;
        localObject1 = "";
        break;
      }
    }
    paramView = paramView.getTag(2131362115);
    if (paramView != null) {}
    for (paramView = (String)paramView;; paramView = "")
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005730", "0X8005730", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006241", "0X8006241", 0, 0, "", "", "", "");
      ReadInJoyLogicEngine.a().c(paramView);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    h();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
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
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if (this.jdField_a_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if (!this.e) {
        break label208;
      }
    }
    label208:
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "0", "0X80064CC", "0X80064CC", 0, 0, "" + i, "" + this.jdField_a_of_type_Long, "", "");
      this.jdField_a_of_type_Long = 0L;
      this.e = false;
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ((ReadInJoyLogicManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a().e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubscribeFragement
 * JD-Core Version:    0.7.0.1
 */