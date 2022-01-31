package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewAdapter;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mnb;
import mnc;

public class ReadInJoySubscriptionListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, View.OnFocusChangeListener, DragFrameLayout.OnDragModeChangedListener, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ReadInJoySubscriptionListViewGroup.OnSubscriptActionCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySubscriptionListViewGroup$OnSubscriptActionCallback;
  private SubscriptFeedsNewAdapter jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  protected DragFrameLayout a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new mnb(this);
  private List jdField_a_of_type_JavaUtilList;
  protected boolean a;
  private float jdField_b_of_type_Float;
  protected int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private int c;
  public boolean c;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  public ReadInJoySubscriptionListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    super(paramReadInJoyBaseViewController, paramInt, paramReadInJoyPageItemCache);
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    a().getLayoutInflater().inflate(2130969653, this);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)a()).app;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = a().getIntent().getIntExtra("come_from", 0);
    this.jdField_a_of_type_Long = a().getIntent().getLongExtra("start_time", 0L);
    this.jdField_d_of_type_Boolean = a().getIntent().getBooleanExtra("has_red_hot", false);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363120);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131367349));
    SwipListView localSwipListView = this.jdField_a_of_type_ComTencentWidgetSwipListView;
    Drawable localDrawable;
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localDrawable = getResources().getDrawable(2131493326);
      localSwipListView.setDivider(localDrawable);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131560424));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
      if (a().getIntent().getIntExtra("readinjoy_show_tab", -1) == -1)
      {
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2130971544, null);
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
        ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131368323)).setVisibility(8);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368738)).setText(String.format(getResources().getString(2131430101), new Object[] { PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().getApplicationContext()) }));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131368324));
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter = new SubscriptFeedsNewAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, a().getLayoutInflater());
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label438;
      }
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131493596);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
      return;
      localDrawable = getResources().getDrawable(2131493232);
      break;
      label438:
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131493597);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)a().getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void h()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.getCount() == 0)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368319);
      if (a().getIntent().getIntExtra("readinjoy_show_tab", -1) >= 0)
      {
        localTextView.setText(2131428465);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (bool) {
          break label105;
        }
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131493596);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130846489);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(false);
        return;
        localTextView.setText(2131430084);
        break;
        label105:
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131493597);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!bool) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131493596);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(true);
      return;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131493597);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.c();
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.notifyDataSetChanged();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(View paramView)
  {
    this.jdField_c_of_type_Int = ((Integer)paramView.getTag(2131362112)).intValue();
    b(false);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      DropFrameMonitor.a().a("list_subscript");
    }
    do
    {
      return;
      DropFrameMonitor.a().a("list_subscript", false);
    } while (!this.jdField_e_of_type_Boolean);
    a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    if (this.jdField_d_of_type_Int != 0) {
      return;
    }
    a();
  }
  
  public void a(Map paramMap) {}
  
  public void a(Map paramMap, boolean paramBoolean) {}
  
  public void a(Set paramSet, Map paramMap) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentWidgetSwipListView.isStackFromBottom()) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setStackFromBottom(true);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setStackFromBottom(false);
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131366830))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.a().getTag(2131362114);
      if (paramDragFrameLayout != null)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.a, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.jdField_b_of_type_Int, "", "", "");
        paramDragFrameLayout.a();
      }
    }
  }
  
  public void b(View paramView)
  {
    this.jdField_c_of_type_Int = -1;
    b(true);
  }
  
  public void b(Map paramMap) {}
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter == null)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.jdField_e_of_type_Int == 0)
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentWidgetSwipListView.getLocationOnScreen(arrayOfInt);
      this.jdField_e_of_type_Int = arrayOfInt[1];
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.f = false;
      if (f2 < this.jdField_a_of_type_ComTencentWidgetSwipListView.getHeight() + this.jdField_e_of_type_Int)
      {
        int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.pointToPosition((int)f1, (int)f2);
        if (i != -1)
        {
          i -= this.jdField_a_of_type_ComTencentWidgetSwipListView.getHeaderViewsCount();
          if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.getCount()) && (i == this.jdField_c_of_type_Int))
          {
            this.f = true;
            continue;
            if (Math.abs(f1 - this.jdField_a_of_type_Float) > Math.abs(f2 - this.jdField_b_of_type_Float))
            {
              if (f1 - this.jdField_a_of_type_Float > 20.0F)
              {
                if (this.f) {
                  this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().requestDisallowInterceptTouchEvent(true);
                }
              }
              else if (f1 - this.jdField_a_of_type_Float < -20.0F) {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().requestDisallowInterceptTouchEvent(true);
              }
            }
            else if (Math.abs(f2 - this.jdField_b_of_type_Float) > 20.0F)
            {
              continue;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().requestDisallowInterceptTouchEvent(false);
              this.f = false;
            }
          }
        }
      }
    }
  }
  
  public void e() {}
  
  public void g()
  {
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
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    if (this.jdField_a_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if (!this.jdField_d_of_type_Boolean) {
        break label187;
      }
    }
    label187:
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "0", "0X80064CC", "0X80064CC", 0, 0, "" + i, "" + this.jdField_a_of_type_Long, "", "");
      this.jdField_a_of_type_Long = 0L;
      this.jdField_d_of_type_Boolean = false;
      return;
    }
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
      } while (((Integer)paramView.getTag(2131362113)).intValue() != SubscriptFeedsAdapter.jdField_d_of_type_Int);
      localObject2 = paramView.getTag(2131362114);
      Object localObject3 = paramView.getTag(2131362115);
      int i;
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label370;
        }
        i = ((Integer)localObject2).intValue();
        localObject2 = Integer.valueOf(i);
        if (((Integer)localObject2).intValue() <= 0) {
          break label375;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject1)))
        {
          localObject3 = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
          if (localObject3 != null) {
            ((PublicAccountHandler)localObject3).a();
          }
        }
        paramView = paramView.getTag(2131362116);
        if (paramView == null) {
          break label414;
        }
      }
      for (paramView = (String)paramView;; paramView = "")
      {
        localObject3 = new Intent(a(), ChatActivity.class);
        ((Intent)localObject3).putExtra("uintype", 1008);
        ((Intent)localObject3).putExtra("uin", (String)localObject1);
        ((Intent)localObject3).putExtra("uinname", paramView);
        ((Intent)localObject3).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("red_hot_count", (Serializable)localObject2);
        a().startActivity((Intent)localObject3);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySubscriptionListViewGroup$OnSubscriptActionCallback != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySubscriptionListViewGroup$OnSubscriptActionCallback.a();
        }
        PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
        return;
        localObject1 = "";
        break;
        i = 0;
        break label119;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
        break label169;
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
      label169:
      label370:
      label375:
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        paramView = paramView.getTag(2131362116);
        if (paramView == null) {
          break label604;
        }
      }
      label414:
      label604:
      for (paramView = (String)paramView;; paramView = "")
      {
        localObject2 = (ActionSheet)ActionSheetHelper.a(a(), null);
        ((ActionSheet)localObject2).a(String.format(getResources().getString(2131430096), new Object[] { paramView }));
        ((ActionSheet)localObject2).a(2131430056, 3);
        ((ActionSheet)localObject2).c(2131433029);
        ((ActionSheet)localObject2).a(new mnc(this, (String)localObject1, (ActionSheet)localObject2));
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005730", "0X8005730", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006241", "0X8006241", 0, 0, "", "", "", "");
      ReadInJoyLogicEngine.a().c(paramView);
      return;
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySubscriptionListViewGroup$OnSubscriptActionCallback != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySubscriptionListViewGroup$OnSubscriptActionCallback.a();
      }
      long l = System.currentTimeMillis();
      if (l - this.jdField_b_of_type_Long > 1500L) {
        this.jdField_b_of_type_Long = l;
      }
    }
  }
  
  public void setOnSubscriptActionCallback(ReadInJoySubscriptionListViewGroup.OnSubscriptActionCallback paramOnSubscriptActionCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySubscriptionListViewGroup$OnSubscriptActionCallback = paramOnSubscriptActionCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySubscriptionListViewGroup
 * JD-Core Version:    0.7.0.1
 */