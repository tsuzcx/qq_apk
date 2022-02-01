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
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.XListView.DrawFinishedListener;
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
    DragFrameLayout localDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if ((localDragFrameLayout != null) && (localDragFrameLayout.a() != -1)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      if (paramList != null) {
        this.jdField_a_of_type_JavaUtilList = paramList;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_JavaUtilList);
      if (((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.g == -1) || (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.f == -1)) && (((!this.g) && (SubscriptRecommendController.a(this.app))) || (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).showPubAccUin(this.app))))
      {
        paramList = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter;
        paramList.g = 0;
        paramList.f = 0;
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscript inner recommend need show !");
        }
      }
      a(true, false, false);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
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
    SubscriptRecommendController localSubscriptRecommendController = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController;
    if ((localSubscriptRecommendController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter != null) && (!this.i) && (localSubscriptRecommendController.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.g == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.f == 0))
    {
      this.i = true;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.a();
    }
  }
  
  private boolean a(ArrayList<ReadInJoyArticle> paramArrayList)
  {
    if (paramArrayList != null)
    {
      Object localObject = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySharedPreferences(1);
      try
      {
        paramArrayList = SubscriptFeedsUtils.a(paramArrayList);
        if (!TextUtils.isEmpty(paramArrayList))
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putString("subscript_feeds_readinjoy_articles", paramArrayList);
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).applySharedPreferences((SharedPreferences.Editor)localObject, true);
          return true;
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
      catch (IOException paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
    }
    return false;
  }
  
  private void d()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("8.7.0");
    ((StringBuilder)localObject1).append(this.app.getCurrentUin());
    ((StringBuilder)localObject1).append("subscript_guid");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.app.getPreferences();
    int j = 1;
    if ((!((SharedPreferences)localObject2).getBoolean((String)localObject1, true)) || (!SubscriptRecommendController.f(this.app))) {
      j = 0;
    }
    if (j == 0) {
      return;
    }
    this.app.getPreferences().edit().putBoolean((String)localObject1, false).commit();
    try
    {
      localObject1 = getResources();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow();
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView = new CustomGuideView(this);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.g = ((Resources)localObject1).getColor(2131167252);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.f = ((Resources)localObject1).getColor(2131167253);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Float = AIOUtils.a(2, 14, (Resources)localObject1);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.e = AIOUtils.b(12.0F, (Resources)localObject1);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Int = AIOUtils.b(30.0F, (Resources)localObject1);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_b_of_type_Int = AIOUtils.b(7.0F, (Resources)localObject1);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.h = AIOUtils.b(12.0F, (Resources)localObject1);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_c_of_type_Int = AIOUtils.b(3.0F, (Resources)localObject1);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714471);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setId(2131378090);
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
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showSubscriptCenterGuideWindow, ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("SubscriptFeedsActivity", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void e()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(null);
      try
      {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("closeSubscriptCenterGuideWindow, ");
          localStringBuilder.append(localException);
          QLog.e("SubscriptFeedsActivity", 2, localStringBuilder.toString());
        }
      }
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
    HtmlOffline.b("2278", this.app, true, new SubscriptFeedsActivity.8(this));
  }
  
  private void g()
  {
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379178)).setText(2131697822);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!bool) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166115);
      } else {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166116);
      }
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130851078);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(false);
      SubscriptRecommendController localSubscriptRecommendController = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController;
      if (localSubscriptRecommendController != null) {
        localSubscriptRecommendController.d();
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (!bool) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166115);
      } else {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166116);
      }
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(true);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.g();
      this.jdField_a_of_type_Boolean = false;
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.h();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController);
  }
  
  void b()
  {
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1002);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1002);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubscriptFeedsActivity", 2, "refreshTroopBarAccountList, error: ", localException);
      }
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
    Object localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView;
    label447:
    boolean bool;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter != null))
    {
      int[] arrayOfInt;
      if (this.jdField_c_of_type_Int == 0)
      {
        arrayOfInt = new int[2];
        ((SwipListView)localObject).getLocationOnScreen(arrayOfInt);
        this.jdField_c_of_type_Int = arrayOfInt[1];
      }
      int j = paramMotionEvent.getAction();
      if (j != 0)
      {
        if (j != 1) {
          if (j != 2)
          {
            if (j != 3) {
              break label447;
            }
          }
          else
          {
            if (Math.abs(f1 - this.jdField_a_of_type_Float) > Math.abs(f2 - this.jdField_b_of_type_Float))
            {
              f2 = this.jdField_a_of_type_Float;
              if (f1 - f2 > 20.0F)
              {
                if (!this.h) {
                  break label447;
                }
                ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
                break label447;
              }
              if (f1 - f2 >= -20.0F) {
                break label447;
              }
              ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
              break label447;
            }
            Math.abs(f2 - this.jdField_b_of_type_Float);
            break label447;
          }
        }
        ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(false);
        this.h = false;
      }
      else
      {
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        this.h = false;
        j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getHeight();
        if (f2 >= this.jdField_c_of_type_Int)
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController;
          if ((localObject != null) && (((SubscriptRecommendController)localObject).jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_AndroidViewView != null))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_AndroidViewView.findViewById(2131376987);
            arrayOfInt = new int[2];
            ((View)localObject).getLocationOnScreen(arrayOfInt);
            if ((f2 >= arrayOfInt[1]) && (f2 < arrayOfInt[1] + ((View)localObject).getHeight())) {
              this.h = true;
            }
          }
          else
          {
            int k = this.jdField_c_of_type_Int;
            if (f2 < j + k)
            {
              j = this.jdField_a_of_type_ComTencentWidgetSwipListView.pointToPosition((int)f1, (int)f2 - k);
              if (j != -1)
              {
                j -= this.jdField_a_of_type_ComTencentWidgetSwipListView.getHeaderViewsCount();
                if ((j >= 0) && (j < this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.getCount()))
                {
                  if (j == this.jdField_b_of_type_Int) {
                    this.h = true;
                  }
                  if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.getItem(j).equals("SubscriptRecommendController")) {
                    this.h = true;
                  }
                }
              }
            }
          }
        }
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    else
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
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
    setContentView(2131560396);
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
    this.rightViewText.setText(2131691854);
    if (bool) {
      this.rightViewText.setVisibility(0);
    } else {
      this.rightViewText.setVisibility(8);
    }
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366238);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131366760));
    SwipListView localSwipListView = this.jdField_a_of_type_ComTencentWidgetSwipListView;
    if (ThemeUtil.isInNightMode(this.app)) {
      paramBundle = getResources().getDrawable(2131167251);
    } else {
      paramBundle = getResources().getDrawable(2131166391);
    }
    localSwipListView.setDivider(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131296908));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(new SubscriptFeedsActivity.3(this));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562771, null);
    this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
    ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131363868)).setVisibility(8);
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379866)).setText(String.format(getResources().getString(2131696506), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()) }));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new SubscriptFeedsActivity.4(this));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    d();
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter = new SubscriptFeedsAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetSwipListView, getLayoutInflater());
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager);
    if (!ThemeUtil.isInNightMode(this.app)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166115);
    } else {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166116);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
    ThreadManager.executeOnSubThread(new SubscriptFeedsActivity.5(this));
    f();
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController = new SubscriptRecommendController(this, this.app, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager);
    }
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    return true;
  }
  
  protected void doOnDestroy()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    DragFrameLayout localDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    boolean bool = SubscriptRecommendController.c(this.app);
    Object localObject = super.findViewById(2131369235);
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.g)
    {
      String str = SubscriptRecommendController.a(this.app);
      Intent localIntent = new Intent(this, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "http://sqimg.qq.com/qq_product_operations/dyzx_folder/index.html?_bid=2312";
      }
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("uin", this.app.getCurrentUin());
      localIntent.putExtra("fromLocalUrl", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("assignBackText", HardCodeUtil.a(2131714459));
      localIntent.putExtra("hideRightButton", true);
      localIntent.putExtra("assignBackText", ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this));
      localIntent.putExtra("call_from", 1001);
      startActivity(localIntent);
      overridePendingTransition(2130772242, 2130771994);
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptFeedsActivity", 2, "subscript full recommend need show !");
      }
      this.g = false;
      ReportController.b(this.app, "CliOper", "", "", "0X8006505", "0X8006505", 0, 0, "", "", "", "");
    }
    a();
    b();
  }
  
  public void finish()
  {
    super.finish();
    TroopBarAssistantManager.a().d(this.app);
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380207))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.a().getTag(2131378092);
      if (paramDragFrameLayout != null)
      {
        String str = paramDragFrameLayout.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramDragFrameLayout.jdField_b_of_type_Int);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", str, "0X80064D1", "0X80064D1", 0, 0, localStringBuilder.toString(), "", "", "");
        paramDragFrameLayout.a();
        c();
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1002);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1002);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int j = 0;
    Object localObject1 = "";
    Object localObject3;
    Object localObject2;
    switch (i2)
    {
    default: 
      break;
    case 2131378090: 
      ReportController.b(this.app, "CliOper", "", "", "0X8006572", "0X8006572", 0, 0, "", "", "", "");
      PublicAccountSearchActivity.a(this, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
      SubscriptRecommendController.b(this.app, false);
      e();
      break;
    case 2131378089: 
      if (((Integer)paramView.getTag(2131378093)).intValue() == SubscriptFeedsAdapter.d)
      {
        localObject3 = paramView.getTag(2131378092);
        Object localObject4 = paramView.getTag(2131378101);
        if (localObject4 != null) {
          localObject2 = (String)localObject4;
        } else {
          localObject2 = "";
        }
        if (localObject4 != null) {
          j = ((Integer)localObject3).intValue();
        }
        localObject3 = Integer.valueOf(j);
        if (((Integer)localObject3).intValue() > 0) {
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject2)))
        {
          localObject4 = (IPublicAccountHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
          if (localObject4 != null) {
            ((IPublicAccountHandler)localObject4).getUserFollowList();
          }
        }
        localObject4 = paramView.getTag(2131378094);
        if (localObject4 != null) {
          localObject1 = (String)localObject4;
        }
        localObject4 = new Intent(this, ChatActivity.class);
        ((Intent)localObject4).putExtra("uintype", 1008);
        ((Intent)localObject4).putExtra("uin", (String)localObject2);
        ((Intent)localObject4).putExtra("uinname", (String)localObject1);
        ((Intent)localObject4).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject4).putExtra("red_hot_count", (Serializable)localObject3);
        startActivity((Intent)localObject4);
        e();
      }
      break;
    case 2131370820: 
      localObject2 = paramView.getTag(2131378101);
      if (localObject2 != null) {
        localObject2 = (String)localObject2;
      } else {
        localObject2 = "";
      }
      localObject3 = paramView.getTag(2131378094);
      if (localObject3 != null) {
        localObject1 = (String)localObject3;
      }
      localObject3 = (ActionSheet)ActionSheetHelper.a(this, null);
      ((ActionSheet)localObject3).setMainTitle(String.format(getResources().getString(2131696510), new Object[] { localObject1 }));
      ((ActionSheet)localObject3).addButton(2131696446, 3);
      ((ActionSheet)localObject3).addCancelButton(2131690728);
      ((ActionSheet)localObject3).setOnButtonClickListener(new SubscriptFeedsActivity.11(this, (String)localObject2, (ActionSheet)localObject3));
      ((ActionSheet)localObject3).show();
      break;
    case 2131370815: 
    case 2131370821: 
      localObject1 = paramView.getTag(2131378101);
      if (localObject1 != null) {
        localObject1 = (String)localObject1;
      } else {
        localObject1 = "";
      }
      if (!TroopBarAssistantManager.a().a((String)localObject1, this.app))
      {
        TroopBarAssistantManager.a().b((String)localObject1, this.app);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
        m = TroopBarAssistantManager.a().a();
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          j = k;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (SubscriptionFeed)((Iterator)localObject2).next();
        } while ((((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString.equals(localObject1)));
        j = ((SubscriptionFeed)localObject3).jdField_b_of_type_Int;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(j);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(m);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CD", "0X80064CD", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
      }
      else
      {
        TroopBarAssistantManager.a().c((String)localObject1, this.app);
        k = TroopBarAssistantManager.a().a();
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          j = m;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (SubscriptionFeed)((Iterator)localObject2).next();
        } while ((((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString.equals(localObject1)));
        j = ((SubscriptionFeed)localObject3).jdField_b_of_type_Int;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(j);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(k);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CE", "0X80064CE", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
      }
      b();
      break;
    case 2131370802: 
      localObject1 = paramView.getTag(2131378101);
      if (localObject1 != null) {
        localObject1 = (String)localObject1;
      } else {
        localObject1 = "";
      }
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005730", "0X8005730", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8006241", "0X8006241", 0, 0, "", "", "", "");
      TroopBarAssistantManager.a().a((String)localObject1, this.app);
      b();
      j = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, (String)localObject1);
      RecentUtil.b(this.app, (String)localObject1, j);
      this.app.getMessageFacade().a((String)localObject1, 1008);
      localObject2 = this.app.getHandler(Conversation.class);
      if (localObject2 != null) {
        ((MqqHandler)localObject2).sendEmptyMessage(1014);
      }
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        j = n;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (SubscriptionFeed)((Iterator)localObject2).next();
      } while ((((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString.equals(localObject1)));
      j = ((SubscriptionFeed)localObject3).jdField_b_of_type_Int;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(j);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064D0", "0X80064D0", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
      break;
    case 2131369608: 
    case 2131369609: 
    case 2131369610: 
    case 2131369611: 
    case 2131369622: 
      ReportController.b(null, "CliOper", "", "", "0X8006155", "0X8006155", 0, 0, "", "", "", "");
      localObject1 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject1).putExtra("channel_id", 0);
      ((Intent)localObject1).putExtra("readinjoy_launch_source", 9);
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject3 != null) && (((ArrayList)localObject3).size() == 4))
      {
        j = i1;
        while (j < 4)
        {
          ((ArrayList)localObject2).add(Long.valueOf(((ReadInJoyArticle)this.jdField_a_of_type_JavaUtilArrayList.get(j)).mArticleID));
          j += 1;
        }
        ((Intent)localObject1).putExtra("subscription_all_article_id", (Serializable)localObject2);
        if ((paramView.getId() != 2131369608) && (paramView.getId() != 2131369609) && (paramView.getId() != 2131369610) && (paramView.getId() != 2131369611))
        {
          ((Intent)localObject1).putExtra("subscription_click_article_id", 0L);
        }
        else
        {
          j = ((Integer)paramView.getTag()).intValue();
          localObject2 = (ReadInJoyArticle)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          long l;
          if (localObject2 != null) {
            l = ((ReadInJoyArticle)localObject2).mArticleID;
          } else {
            l = -1L;
          }
          ((Intent)localObject1).putExtra("subscription_click_article_id", Long.valueOf(l));
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("SubscriptFeedsActivity", 2, "subscription folder jump to readinjoy with ReadInJoyArticles wrong param");
      }
      this.jdField_b_of_type_Boolean = true;
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).launchReadInJoyPlugin(this, (Intent)localObject1);
      e();
      break;
    case 2131369233: 
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005734", "0X8005734", 0, 0, "", "", "", "");
      PublicAccountSearchActivity.a(this, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
      SubscriptRecommendController.b(this.app, false);
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    this.jdField_b_of_type_Int = ((Integer)paramView.getTag(2131378095)).intValue();
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
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity
 * JD-Core Version:    0.7.0.1
 */