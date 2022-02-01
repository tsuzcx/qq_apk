package com.tencent.biz.pubaccount.subscript;

import Override;
import aeou;
import alik;
import alje;
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
import anvx;
import anyz;
import bdla;
import bkzi;
import bkzz;
import blfe;
import bmhv;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.CustomGuideView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView.DrawFinishedListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import nuz;
import olh;
import uph;
import upi;
import upj;
import upk;
import upl;
import upm;
import upn;
import upo;
import upp;
import upx;
import upy;
import upz;
import uqa;
import uqm;
import uqv;
import uqx;
import usu;
import uuc;
import uuq;

public class SubscriptFeedsActivity
  extends IphoneTitleBarActivity
  implements alje, View.OnClickListener, blfe, Observer
{
  private float jdField_a_of_type_Float;
  protected int a;
  public long a;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  anyz jdField_a_of_type_Anyz = new upj(this);
  private CustomGuideView jdField_a_of_type_ComTencentBizUiCustomGuideView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  protected DragFrameLayout a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new uph(this);
  private ArrayList<ReadInJoyArticle> jdField_a_of_type_JavaUtilArrayList;
  private List<uqv> jdField_a_of_type_JavaUtilList;
  public MqqHandler a;
  private upp jdField_a_of_type_Upp;
  private upz jdField_a_of_type_Upz = new upl(this);
  private uqa jdField_a_of_type_Uqa;
  public uqm a;
  protected boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  public boolean c;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public SubscriptFeedsActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_MqqOsMqqHandler = new upk(this, ThreadManager.getSubThreadLooper());
  }
  
  private void a(List<uqv> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {}
    while ((this.jdField_a_of_type_Upp == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_Upp.a(this.jdField_a_of_type_JavaUtilList);
    if (((this.jdField_a_of_type_Upp.g == -1) || (this.jdField_a_of_type_Upp.f == -1)) && (((!this.g) && (uqm.a(this.app))) || (uuc.a(this.app))))
    {
      this.jdField_a_of_type_Upp.g = 0;
      this.jdField_a_of_type_Upp.f = 0;
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
      this.d = true;
      this.jdField_a_of_type_Upp.b();
      this.jdField_a_of_type_Upp.notifyDataSetChanged();
      g();
    }
    if ((this.jdField_a_of_type_Uqm != null) && (this.jdField_a_of_type_Upp != null) && (!this.i) && (this.jdField_a_of_type_Uqm.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp.g == 0) && (this.jdField_a_of_type_Upp.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Upp.f == 0))
    {
      this.i = true;
      this.jdField_a_of_type_Uqm.a();
    }
  }
  
  private boolean a(ArrayList<ReadInJoyArticle> paramArrayList)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    Object localObject;
    if (paramArrayList != null) {
      localObject = bmhv.a(this.app, 1);
    }
    for (;;)
    {
      try
      {
        paramArrayList = upx.a(paramArrayList);
        if (!TextUtils.isEmpty(paramArrayList))
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putString("subscript_feeds_readinjoy_articles", paramArrayList);
          bmhv.a((SharedPreferences.Editor)localObject, true);
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
    Object localObject = "8.4.10" + this.app.getCurrentUin() + "subscript_guid";
    if ((this.app.getPreferences().getBoolean((String)localObject, true)) && (uqm.f(this.app))) {
      if (j != 0) {
        break label71;
      }
    }
    label71:
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
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.g = ((Resources)localObject).getColor(2131167220);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.f = ((Resources)localObject).getColor(2131167221);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Float = AIOUtils.sp2TextSize(2, 14, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.e = AIOUtils.dp2px(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Int = AIOUtils.dp2px(30.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_b_of_type_Int = AIOUtils.dp2px(7.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.h = AIOUtils.dp2px(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_c_of_type_Int = AIOUtils.dp2px(3.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_JavaLangString = anvx.a(2131714054);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setId(2131378269);
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
    if (uqx.a().a(this.app)) {
      uqx.a().a(this.app.getEntityManagerFactory().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_Anyz);
    addObserver(this.jdField_a_of_type_Upz);
    this.app.getMessageFacade().addObserver(this);
    if ((bmhv.b(this.app)) && ((upy)this.app.getBusinessHandler(BusinessHandlerFactory.SUBSCRIPT_HANDLER) != null)) {}
    nuz.b("2278", this.app, true, new upo(this));
  }
  
  private void g()
  {
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (this.jdField_a_of_type_Upp.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379426)).setText(2131697562);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!bool) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166098);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130850736);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(false);
        if (this.jdField_a_of_type_Uqm != null) {
          this.jdField_a_of_type_Uqm.d();
        }
        return;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166099);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!bool) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166098);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(true);
      return;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166099);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Uqm.g();
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Upp.a(this.jdField_a_of_type_Uqm);
      return;
      this.jdField_a_of_type_Uqm.h();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_Int = ((Integer)paramView.getTag(2131378274)).intValue();
    a(false);
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380498))
    {
      paramDragFrameLayout = (uqv)paramDragFrameLayout.a().getTag(2131378271);
      if (paramDragFrameLayout != null)
      {
        bdla.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.jdField_a_of_type_JavaLangString, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.jdField_b_of_type_Int, "", "", "");
        paramDragFrameLayout.a();
        c();
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1002);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1002);
      }
    }
  }
  
  public void b()
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
  
  public void b(View paramView)
  {
    this.jdField_b_of_type_Int = -1;
    a(true);
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
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (this.jdField_a_of_type_Upp == null))
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
        if ((this.jdField_a_of_type_Uqm != null) && (this.jdField_a_of_type_Uqm.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Uqm.jdField_a_of_type_AndroidViewView != null))
        {
          localObject = this.jdField_a_of_type_Uqm.jdField_a_of_type_AndroidViewView.findViewById(2131377125);
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
            if ((j >= 0) && (j < this.jdField_a_of_type_Upp.getCount()))
            {
              if (j == this.jdField_b_of_type_Int) {
                this.h = true;
              }
              if (this.jdField_a_of_type_Upp.getItem(j).equals("SubscriptRecommendController"))
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
    uuq.a(null, "SUBSCRIPT_FEEDS_COST");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      new MqqHandler().postDelayed(new SubscriptFeedsActivity.2(this), 1000L);
    }
    setContentView(2131560431);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("come_from", 0);
    this.jdField_c_of_type_Long = super.getIntent().getLongExtra("start_time", 0L);
    this.f = super.getIntent().getBooleanExtra("has_red_hot", false);
    this.jdField_a_of_type_Uqa = new uqa();
    setTitle(usu.a(this.app, getApplicationContext()));
    c();
    boolean bool = uqm.f(this.app);
    this.rightViewText.setText(2131691808);
    if (bool)
    {
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131366179);
      this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131366722));
      SwipListView localSwipListView = this.jdField_a_of_type_ComTencentWidgetSwipListView;
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label644;
      }
      paramBundle = getResources().getDrawable(2131167219);
      label281:
      localSwipListView.setDivider(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131296905));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(new upm(this));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562805, null);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
      ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131363845)).setVisibility(8);
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380145)).setText(String.format(getResources().getString(2131696234), new Object[] { usu.a(this.app, getApplicationContext()) }));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131366280));
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new upn(this));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      d();
      this.jdField_a_of_type_Upp = new upp(this, this.app, this.jdField_a_of_type_ComTencentWidgetSwipListView, getLayoutInflater());
      this.jdField_a_of_type_Upp.a(this);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Upp);
      this.jdField_a_of_type_Upp.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_Upp.a(this.jdField_a_of_type_Uqa);
      if (ThemeUtil.isInNightMode(this.app)) {
        break label658;
      }
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166098);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
      ThreadManager.executeOnSubThread(new SubscriptFeedsActivity.5(this));
      f();
      if (this.jdField_a_of_type_Uqm == null) {
        this.jdField_a_of_type_Uqm = new uqm(this, this.app, this.jdField_a_of_type_Uqa);
      }
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      return true;
      this.rightViewText.setVisibility(8);
      break;
      label644:
      paramBundle = getResources().getDrawable(2131166377);
      break label281;
      label658:
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166099);
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
    removeObserver(this.jdField_a_of_type_Anyz);
    removeObserver(this.jdField_a_of_type_Upz);
    if ((this.app != null) && (this.app.getMessageFacade() != null)) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(null);
    }
    if (this.jdField_a_of_type_Upp != null)
    {
      this.jdField_a_of_type_Upp.a();
      this.jdField_a_of_type_Upp = null;
    }
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (this.jdField_a_of_type_Uqm != null) {
      this.jdField_a_of_type_Uqm.f();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    this.jdField_a_of_type_Uqa.a();
    this.jdField_a_of_type_Uqa = null;
    if (this.jdField_c_of_type_Long != 0L)
    {
      this.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      if (!this.f) {
        break label286;
      }
    }
    label286:
    for (int j = 1;; j = 0)
    {
      bdla.b(this.app, "dc00899", "Pb_account_lifeservice", "0", "0X80064CC", "0X80064CC", 0, 0, "" + j, "" + this.jdField_c_of_type_Long, "", "");
      this.jdField_c_of_type_Long = 0L;
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
    boolean bool = uqm.c(this.app);
    Object localObject = super.findViewById(2131369264);
    if (bool) {}
    for (int j = 0;; j = 8)
    {
      ((View)localObject).setVisibility(j);
      if (this.jdField_b_of_type_Boolean)
      {
        if ((bmhv.b(this.app)) && ((upy)this.app.getBusinessHandler(BusinessHandlerFactory.SUBSCRIPT_HANDLER) != null)) {}
        this.jdField_b_of_type_Boolean = false;
      }
      if (this.g)
      {
        String str = uqm.a(this.app);
        Intent localIntent = new Intent(this, PublicAccountBrowser.class);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "http://sqimg.qq.com/qq_product_operations/dyzx_folder/index.html?_bid=2312";
        }
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", this.app.getCurrentUin());
        localIntent.putExtra("fromLocalUrl", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("assignBackText", anvx.a(2131714042));
        localIntent.putExtra("hideRightButton", true);
        localIntent.putExtra("assignBackText", usu.a(this.app, this));
        localIntent.putExtra("call_from", 1001);
        startActivity(localIntent);
        overridePendingTransition(2130772198, 2130771980);
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscript full recommend need show !");
        }
        this.g = false;
        bdla.b(this.app, "CliOper", "", "", "0X8006505", "0X8006505", 0, 0, "", "", "", "");
      }
      a();
      b();
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    uqx.a().d(this.app);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label303:
    label317:
    label367:
    int k;
    switch (paramView.getId())
    {
    default: 
    case 2131378269: 
    case 2131369262: 
    case 2131378268: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          bdla.b(this.app, "CliOper", "", "", "0X8006572", "0X8006572", 0, 0, "", "", "", "");
          aeou.a(this, usu.a(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
          uqm.b(this.app, false);
          e();
          continue;
          bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005734", "0X8005734", 0, 0, "", "", "", "");
          aeou.a(this, usu.a(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
          uqm.b(this.app, false);
          e();
        }
      } while (((Integer)paramView.getTag(2131378272)).intValue() != upp.d);
      localObject2 = paramView.getTag(2131378271);
      localObject3 = paramView.getTag(2131378280);
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label555;
        }
        j = ((Integer)localObject2).intValue();
        localObject3 = Integer.valueOf(j);
        if (((Integer)localObject3).intValue() <= 0) {
          break label560;
        }
        bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        bdla.b(this.app, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(uqx.a().a((String)localObject1)))
        {
          localObject2 = (PublicAccountHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
          if (localObject2 != null) {
            ((PublicAccountHandler)localObject2).a();
          }
        }
        localObject2 = paramView.getTag(2131378273);
        if (localObject2 == null) {
          break label599;
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
        break label303;
        j = 0;
        break label317;
        bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
        break label367;
      }
    case 2131369648: 
    case 2131369649: 
    case 2131369650: 
    case 2131369651: 
    case 2131369665: 
      bdla.b(null, "CliOper", "", "", "0X8006155", "0X8006155", 0, 0, "", "", "", "");
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
        if ((paramView.getId() == 2131369648) || (paramView.getId() == 2131369649) || (paramView.getId() == 2131369650) || (paramView.getId() == 2131369651))
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
        bmhv.a(this.app, this, (Intent)localObject1);
        e();
        break;
        l = -1L;
        break label824;
        ((Intent)localObject1).putExtra("subscription_click_article_id", 0L);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscription folder jump to readinjoy with ReadInJoyArticles wrong param");
        }
      }
    case 2131370912: 
    case 2131370918: 
      label555:
      label560:
      label599:
      localObject1 = paramView.getTag(2131378280);
      label824:
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        if (uqx.a().a((String)localObject1, this.app)) {
          break label1128;
        }
        uqx.a().b((String)localObject1, this.app);
        olh.a(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
        k = uqx.a().a();
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (uqv)((Iterator)localObject2).next();
        } while ((((uqv)localObject3).jdField_a_of_type_JavaLangString == null) || (!((uqv)localObject3).jdField_a_of_type_JavaLangString.equals(localObject1)));
      }
      label920:
      break;
    }
    for (int j = ((uqv)localObject3).jdField_b_of_type_Int;; j = 0)
    {
      bdla.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CD", "0X80064CD", 0, 0, "" + j, "" + k, "", "");
      label1113:
      b();
      break;
      localObject1 = "";
      break label920;
      label1128:
      uqx.a().c((String)localObject1, this.app);
      k = uqx.a().a();
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (uqv)((Iterator)localObject2).next();
      } while ((((uqv)localObject3).jdField_a_of_type_JavaLangString == null) || (!((uqv)localObject3).jdField_a_of_type_JavaLangString.equals(localObject1)));
      for (j = ((uqv)localObject3).jdField_b_of_type_Int;; j = 0)
      {
        bdla.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CE", "0X80064CE", 0, 0, "" + j, "" + k, "", "");
        break label1113;
        localObject1 = paramView.getTag(2131378280);
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          label1297:
          localObject2 = paramView.getTag(2131378273);
          if (localObject2 == null) {
            break label1405;
          }
        }
        label1405:
        for (localObject2 = (String)localObject2;; localObject2 = "")
        {
          localObject3 = (bkzi)bkzz.a(this, null);
          ((bkzi)localObject3).a(String.format(getResources().getString(2131696238), new Object[] { localObject2 }));
          ((bkzi)localObject3).a(2131696176, 3);
          ((bkzi)localObject3).c(2131690697);
          ((bkzi)localObject3).a(new upi(this, (String)localObject1, (bkzi)localObject3));
          ((bkzi)localObject3).show();
          break;
          localObject1 = "";
          break label1297;
        }
        localObject1 = paramView.getTag(2131378280);
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          label1434:
          bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005730", "0X8005730", 0, 0, "", "", "", "");
          bdla.b(this.app, "CliOper", "", "", "0X8006241", "0X8006241", 0, 0, "", "", "", "");
          uqx.a().a((String)localObject1, this.app);
          b();
          j = uuc.b(this.app, (String)localObject1);
          alik.b(this.app, (String)localObject1, j);
          this.app.getMessageFacade().setReaded((String)localObject1, 1008);
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
            localObject3 = (uqv)((Iterator)localObject2).next();
          } while ((((uqv)localObject3).jdField_a_of_type_JavaLangString == null) || (!((uqv)localObject3).jdField_a_of_type_JavaLangString.equals(localObject1)));
        }
        for (j = ((uqv)localObject3).jdField_b_of_type_Int;; j = 0)
        {
          bdla.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064D0", "0X80064D0", 0, 0, "" + j, "", "", "");
          break;
          localObject1 = "";
          break label1434;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity
 * JD-Core Version:    0.7.0.1
 */