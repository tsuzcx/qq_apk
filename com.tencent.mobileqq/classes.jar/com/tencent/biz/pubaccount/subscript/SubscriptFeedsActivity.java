package com.tencent.biz.pubaccount.subscript;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.ui.CustomGuideView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class SubscriptFeedsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DragFrameLayout.OnDragModeChangedListener, SwipListView.RightIconMenuListener, Observer
{
  private float jdField_a_of_type_Float = 0.0F;
  protected int a;
  public long a;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private SubscriptFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter;
  private SubscriptObserver jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver = new SubscriptFeedsActivity.15(this);
  private SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  public SubscriptRecommendController a;
  private CustomGuideView jdField_a_of_type_ComTencentBizUiCustomGuideView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  protected DragFrameLayout a;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new SubscriptFeedsActivity.12(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new SubscriptFeedsActivity.1(this);
  private ArrayList<ReadInJoyArticle> jdField_a_of_type_JavaUtilArrayList = null;
  private List<SubscriptionFeed> jdField_a_of_type_JavaUtilList = null;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new SubscriptFeedsActivity.14(this, ThreadManager.getSubThreadLooper());
  protected boolean a;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = -1;
  public long b;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  public boolean c;
  private long d;
  public boolean d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  
  public SubscriptFeedsActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void a(List<SubscriptionFeed> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_JavaUtilList);
    if (((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.g == -1) || (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.f == -1)) && (((!this.g) && (SubscriptRecommendController.a(this.app))) || (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).showPubAccUin(this.app))))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.g = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.f = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptFeedsActivity", 2, "subscript inner recommend need show !");
      }
    }
    a(true, false, false);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) || (paramBoolean2) || (paramBoolean3))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.b();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.notifyDataSetChanged();
      g();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter != null) && (!this.i) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.g == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.f == 0))
    {
      this.i = true;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.a();
    }
  }
  
  private boolean a(ArrayList<ReadInJoyArticle> paramArrayList)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    Object localObject;
    if (paramArrayList != null) {
      localObject = ReadInJoyHelper.a(this.app, 1);
    }
    for (;;)
    {
      try
      {
        paramArrayList = SubscriptFeedsUtils.a(paramArrayList);
        if (!TextUtils.isEmpty(paramArrayList))
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putString("subscript_feeds_readinjoy_articles", paramArrayList);
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
          bool1 = bool2;
          return bool1;
        }
      }
      catch (IOException paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
      bool1 = false;
    }
  }
  
  private void d()
  {
    int j = 1;
    Object localObject = "8.5.5" + this.app.getCurrentUin() + "subscript_guid";
    if ((this.app.getPreferences().getBoolean((String)localObject, true)) && (SubscriptRecommendController.f(this.app))) {
      if (j != 0) {
        break label72;
      }
    }
    label72:
    do
    {
      return;
      j = 0;
      break;
      this.app.getPreferences().edit().putBoolean((String)localObject, false).commit();
      try
      {
        localObject = getResources();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow();
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView = new CustomGuideView(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.g = ((Resources)localObject).getColor(2131167227);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.f = ((Resources)localObject).getColor(2131167228);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Float = AIOUtils.a(2, 14, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.e = AIOUtils.a(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Int = AIOUtils.a(30.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_b_of_type_Int = AIOUtils.a(7.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.h = AIOUtils.a(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_c_of_type_Int = AIOUtils.a(3.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714550);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setId(2131378695);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_ComTencentBizUiCustomGuideView);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(false);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(this.jdField_a_of_type_ComTencentBizUiCustomGuideView.b());
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
        j = this.jdField_a_of_type_ComTencentBizUiCustomGuideView.b();
        int k = getResources().getDisplayMetrics().widthPixels;
        this.rightViewText.post(new SubscriptFeedsActivity.6(this, k, j));
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("SubscriptFeedsActivity", 2, "showSubscriptCenterGuideWindow, " + localException);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(null);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SubscriptFeedsActivity", 2, "closeSubscriptCenterGuideWindow, " + localException);
    }
  }
  
  private void f()
  {
    ThreadManager.executeOnSubThread(new SubscriptFeedsActivity.7(this));
    if (TroopBarAssistantManager.a().a(this.app)) {
      TroopBarAssistantManager.a().a(this.app.getEntityManagerFactory().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver);
    this.app.getMessageFacade().addObserver(this);
    if ((ReadInJoyHelper.b(this.app)) && ((SubscriptHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SUBSCRIPT_HANDLER) != null)) {}
    HtmlOffline.b("2278", this.app, true, new SubscriptFeedsActivity.8(this));
  }
  
  private void g()
  {
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379849)).setText(2131697816);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!bool) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166104);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130851162);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(false);
        if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.d();
        }
        return;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166105);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!bool) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166104);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(true);
      return;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166105);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.g();
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.h();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380941))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.a().getTag(2131378697);
      if (paramDragFrameLayout != null)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.jdField_a_of_type_JavaLangString, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.jdField_b_of_type_Int, "", "", "");
        paramDragFrameLayout.a();
        c();
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1002);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1002);
      }
    }
  }
  
  void b()
  {
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1002);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1002);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SubscriptFeedsActivity", 2, "refreshTroopBarAccountList, error: ", localException);
    }
  }
  
  void c()
  {
    if (this.leftView != null) {
      ThreadManager.post(new SubscriptFeedsActivity.9(this), 5, null, true);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter == null))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
    }
    Object localObject;
    if (this.jdField_c_of_type_Int == 0)
    {
      localObject = new int[2];
      this.jdField_a_of_type_ComTencentWidgetSwipListView.getLocationOnScreen((int[])localObject);
      this.jdField_c_of_type_Int = localObject[1];
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      break;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.h = false;
      int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getHeight();
      if (f2 >= this.jdField_c_of_type_Int) {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_AndroidViewView != null))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_AndroidViewView.findViewById(2131377545);
          int[] arrayOfInt = new int[2];
          ((View)localObject).getLocationOnScreen(arrayOfInt);
          if (f2 >= arrayOfInt[1])
          {
            j = arrayOfInt[1];
            if (f2 < ((View)localObject).getHeight() + j) {
              this.h = true;
            }
          }
        }
        else if (f2 < j + this.jdField_c_of_type_Int)
        {
          j = this.jdField_a_of_type_ComTencentWidgetSwipListView.pointToPosition((int)f1, (int)f2 - this.jdField_c_of_type_Int);
          if (j != -1)
          {
            j -= this.jdField_a_of_type_ComTencentWidgetSwipListView.getHeaderViewsCount();
            if ((j >= 0) && (j < this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.getCount()))
            {
              if (j == this.jdField_b_of_type_Int) {
                this.h = true;
              }
              if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.getItem(j).equals("SubscriptRecommendController"))
              {
                this.h = true;
                continue;
                if (Math.abs(f1 - this.jdField_a_of_type_Float) > Math.abs(f2 - this.jdField_b_of_type_Float))
                {
                  if (f1 - this.jdField_a_of_type_Float > 20.0F)
                  {
                    if (this.h) {
                      ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
                    }
                  }
                  else if (f1 - this.jdField_a_of_type_Float < -20.0F) {
                    ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
                  }
                }
                else if (Math.abs(f2 - this.jdField_b_of_type_Float) > 20.0F)
                {
                  continue;
                  ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(false);
                  this.h = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    PublicTracker.a(null, "SUBSCRIPT_FEEDS_COST");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      new MqqHandler().postDelayed(new SubscriptFeedsActivity.2(this), 1000L);
    }
    setContentView(2131560509);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("come_from", 0);
    this.jdField_d_of_type_Long = super.getIntent().getLongExtra("start_time", 0L);
    this.f = super.getIntent().getBooleanExtra("has_red_hot", false);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = new SubscriptPicManager();
    setTitle(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()));
    c();
    boolean bool = SubscriptRecommendController.f(this.app);
    this.rightViewText.setText(2131691926);
    if (bool)
    {
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131366350);
      this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131366898));
      SwipListView localSwipListView = this.jdField_a_of_type_ComTencentWidgetSwipListView;
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label666;
      }
      paramBundle = getResources().getDrawable(2131167226);
      label292:
      localSwipListView.setDivider(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131296926));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(new SubscriptFeedsActivity.3(this));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562952, null);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
      ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131363942)).setVisibility(8);
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380584)).setText(String.format(getResources().getString(2131696487), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()) }));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131366452));
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new SubscriptFeedsActivity.4(this));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter = new SubscriptFeedsAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetSwipListView, getLayoutInflater());
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager);
      if (ThemeUtil.isInNightMode(this.app)) {
        break label680;
      }
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166104);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
      ThreadManager.executeOnSubThread(new SubscriptFeedsActivity.5(this));
      f();
      if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController = new SubscriptRecommendController(this, this.app, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager);
      }
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      return true;
      this.rightViewText.setVisibility(8);
      break;
      label666:
      paramBundle = getResources().getDrawable(2131166380);
      break label292;
      label680:
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166105);
    }
  }
  
  public void doOnDestroy()
  {
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_MqqOsMqqHandler = null;
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver);
    if ((this.app != null) && (this.app.getMessageFacade() != null)) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(null);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter = null;
    }
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.f();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a();
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = null;
    if (this.jdField_d_of_type_Long != 0L)
    {
      this.jdField_d_of_type_Long = (System.currentTimeMillis() - this.jdField_d_of_type_Long);
      if (!this.f) {
        break label286;
      }
    }
    label286:
    for (int j = 1;; j = 0)
    {
      ReportController.b(this.app, "dc00899", "Pb_account_lifeservice", "0", "0X80064CC", "0X80064CC", 0, 0, "" + j, "" + this.jdField_d_of_type_Long, "", "");
      this.jdField_d_of_type_Long = 0L;
      this.f = false;
      super.doOnDestroy();
      return;
    }
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
    boolean bool = SubscriptRecommendController.c(this.app);
    Object localObject = super.findViewById(2131369520);
    if (bool) {}
    for (int j = 0;; j = 8)
    {
      ((View)localObject).setVisibility(j);
      if (this.jdField_b_of_type_Boolean)
      {
        if ((ReadInJoyHelper.b(this.app)) && ((SubscriptHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SUBSCRIPT_HANDLER) != null)) {}
        this.jdField_b_of_type_Boolean = false;
      }
      if (this.g)
      {
        String str = SubscriptRecommendController.a(this.app);
        Intent localIntent = new Intent(this, PublicAccountBrowserImpl.class);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "http://sqimg.qq.com/qq_product_operations/dyzx_folder/index.html?_bid=2312";
        }
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", this.app.getCurrentUin());
        localIntent.putExtra("fromLocalUrl", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("assignBackText", HardCodeUtil.a(2131714538));
        localIntent.putExtra("hideRightButton", true);
        localIntent.putExtra("assignBackText", ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this));
        localIntent.putExtra("call_from", 1001);
        startActivity(localIntent);
        overridePendingTransition(2130772213, 2130771982);
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscript full recommend need show !");
        }
        this.g = false;
        ReportController.b(this.app, "CliOper", "", "", "0X8006505", "0X8006505", 0, 0, "", "", "", "");
      }
      a();
      b();
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    TroopBarAssistantManager.a().d(this.app);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label325:
    label339:
    label621:
    int k;
    switch (paramView.getId())
    {
    default: 
    case 2131378695: 
    case 2131369518: 
    case 2131378694: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          ReportController.b(this.app, "CliOper", "", "", "0X8006572", "0X8006572", 0, 0, "", "", "", "");
          PublicAccountSearchActivity.a(this, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
          SubscriptRecommendController.b(this.app, false);
          e();
          continue;
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005734", "0X8005734", 0, 0, "", "", "", "");
          PublicAccountSearchActivity.a(this, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
          SubscriptRecommendController.b(this.app, false);
          e();
        }
      } while (((Integer)paramView.getTag(2131378698)).intValue() != SubscriptFeedsAdapter.d);
      localObject2 = paramView.getTag(2131378697);
      localObject3 = paramView.getTag(2131378706);
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label577;
        }
        j = ((Integer)localObject2).intValue();
        localObject3 = Integer.valueOf(j);
        if (((Integer)localObject3).intValue() <= 0) {
          break label582;
        }
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject1)))
        {
          localObject2 = (PublicAccountHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
          if (localObject2 != null) {
            ((PublicAccountHandler)localObject2).a();
          }
        }
        localObject2 = paramView.getTag(2131378699);
        if (localObject2 == null) {
          break label621;
        }
      }
      for (localObject2 = (String)localObject2;; localObject2 = "")
      {
        Intent localIntent = new Intent(this, ChatActivity.class);
        localIntent.putExtra("uintype", 1008);
        localIntent.putExtra("uin", (String)localObject1);
        localIntent.putExtra("uinname", (String)localObject2);
        localIntent.putExtra("start_time", System.currentTimeMillis());
        localIntent.putExtra("red_hot_count", (Serializable)localObject3);
        startActivity(localIntent);
        e();
        break;
        localObject1 = "";
        break label325;
        j = 0;
        break label339;
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
        break label389;
      }
    case 2131369923: 
    case 2131369924: 
    case 2131369925: 
    case 2131369926: 
    case 2131369937: 
      ReportController.b(null, "CliOper", "", "", "0X8006155", "0X8006155", 0, 0, "", "", "", "");
      localObject1 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject1).putExtra("channel_id", 0);
      ((Intent)localObject1).putExtra("readinjoy_launch_source", 9);
      localObject2 = new ArrayList();
      long l;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 4))
      {
        j = 0;
        while (j < 4)
        {
          ((ArrayList)localObject2).add(Long.valueOf(((ReadInJoyArticle)this.jdField_a_of_type_JavaUtilArrayList.get(j)).mArticleID));
          j += 1;
        }
        ((Intent)localObject1).putExtra("subscription_all_article_id", (Serializable)localObject2);
        if ((paramView.getId() == 2131369923) || (paramView.getId() == 2131369924) || (paramView.getId() == 2131369925) || (paramView.getId() == 2131369926))
        {
          j = ((Integer)paramView.getTag()).intValue();
          localObject2 = (ReadInJoyArticle)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (localObject2 != null)
          {
            l = ((ReadInJoyArticle)localObject2).mArticleID;
            ((Intent)localObject1).putExtra("subscription_click_article_id", Long.valueOf(l));
          }
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Boolean = true;
        ReadInJoyHelper.a(this.app, this, (Intent)localObject1);
        e();
        break;
        l = -1L;
        break label846;
        ((Intent)localObject1).putExtra("subscription_click_article_id", 0L);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscription folder jump to readinjoy with ReadInJoyArticles wrong param");
        }
      }
    case 2131371190: 
    case 2131371196: 
      label389:
      label577:
      label582:
      label846:
      localObject1 = paramView.getTag(2131378706);
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        label942:
        if (TroopBarAssistantManager.a().a((String)localObject1, this.app)) {
          break label1161;
        }
        TroopBarAssistantManager.a().b((String)localObject1, this.app);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
        k = TroopBarAssistantManager.a().a();
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (SubscriptionFeed)((Iterator)localObject2).next();
        } while ((((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString.equals(localObject1)));
      }
      break;
    }
    for (int j = ((SubscriptionFeed)localObject3).jdField_b_of_type_Int;; j = 0)
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CD", "0X80064CD", 0, 0, "" + j, "" + k, "", "");
      label1146:
      b();
      break;
      localObject1 = "";
      break label942;
      label1161:
      TroopBarAssistantManager.a().c((String)localObject1, this.app);
      k = TroopBarAssistantManager.a().a();
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (SubscriptionFeed)((Iterator)localObject2).next();
      } while ((((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString.equals(localObject1)));
      for (j = ((SubscriptionFeed)localObject3).jdField_b_of_type_Int;; j = 0)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CE", "0X80064CE", 0, 0, "" + j, "" + k, "", "");
        break label1146;
        localObject1 = paramView.getTag(2131378706);
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          label1330:
          localObject2 = paramView.getTag(2131378699);
          if (localObject2 == null) {
            break label1438;
          }
        }
        label1438:
        for (localObject2 = (String)localObject2;; localObject2 = "")
        {
          localObject3 = (ActionSheet)ActionSheetHelper.a(this, null);
          ((ActionSheet)localObject3).setMainTitle(String.format(getResources().getString(2131696491), new Object[] { localObject2 }));
          ((ActionSheet)localObject3).addButton(2131696427, 3);
          ((ActionSheet)localObject3).addCancelButton(2131690800);
          ((ActionSheet)localObject3).setOnButtonClickListener(new SubscriptFeedsActivity.11(this, (String)localObject1, (ActionSheet)localObject3));
          ((ActionSheet)localObject3).show();
          break;
          localObject1 = "";
          break label1330;
        }
        localObject1 = paramView.getTag(2131378706);
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          label1467:
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005730", "0X8005730", 0, 0, "", "", "", "");
          ReportController.b(this.app, "CliOper", "", "", "0X8006241", "0X8006241", 0, 0, "", "", "", "");
          TroopBarAssistantManager.a().a((String)localObject1, this.app);
          b();
          j = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, (String)localObject1);
          RecentUtil.b(this.app, (String)localObject1, j);
          this.app.getMessageFacade().c((String)localObject1, 1008);
          localObject2 = this.app.getHandler(Conversation.class);
          if (localObject2 != null) {
            ((MqqHandler)localObject2).sendEmptyMessage(1014);
          }
          localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (SubscriptionFeed)((Iterator)localObject2).next();
          } while ((((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString.equals(localObject1)));
        }
        for (j = ((SubscriptionFeed)localObject3).jdField_b_of_type_Int;; j = 0)
        {
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064D0", "0X80064D0", 0, 0, "" + j, "", "", "");
          break;
          localObject1 = "";
          break label1467;
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    this.jdField_b_of_type_Int = -1;
    a(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    this.jdField_b_of_type_Int = ((Integer)paramView.getTag(2131378700)).intValue();
    a(false);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new SubscriptFeedsActivity.13(this));
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
    else
    {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity
 * JD-Core Version:    0.7.0.1
 */