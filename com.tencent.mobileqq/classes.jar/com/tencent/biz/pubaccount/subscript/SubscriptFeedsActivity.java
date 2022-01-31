package com.tencent.biz.pubaccount.subscript;

import adpm;
import aepi;
import ajlb;
import ajlm;
import alud;
import alwx;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import awgg;
import azqs;
import bhuf;
import bhus;
import bibb;
import bicq;
import bkbq;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.CustomGuideView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import nbv;
import nrt;
import stf;
import stg;
import sth;
import sti;
import stj;
import stk;
import stl;
import stm;
import stn;
import stv;
import stw;
import stx;
import sty;
import suk;
import sut;
import suv;
import swy;
import syb;
import syp;

public class SubscriptFeedsActivity
  extends IphoneTitleBarActivity
  implements ajlm, View.OnClickListener, bibb, Observer
{
  private float jdField_a_of_type_Float;
  protected int a;
  public long a;
  alwx jdField_a_of_type_Alwx = new sth(this);
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private bicq jdField_a_of_type_Bicq = new stf(this);
  private CustomGuideView jdField_a_of_type_ComTencentBizUiCustomGuideView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  protected DragFrameLayout a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private ArrayList<ReadInJoyArticle> jdField_a_of_type_JavaUtilArrayList;
  private List<sut> jdField_a_of_type_JavaUtilList;
  public MqqHandler a;
  private stn jdField_a_of_type_Stn;
  private stx jdField_a_of_type_Stx = new stj(this);
  private sty jdField_a_of_type_Sty;
  public suk a;
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
    this.jdField_a_of_type_MqqOsMqqHandler = new sti(this, ThreadManager.getSubThreadLooper());
  }
  
  private void a(List<sut> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {}
    while ((this.jdField_a_of_type_Stn == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_Stn.a(this.jdField_a_of_type_JavaUtilList);
    if (((this.jdField_a_of_type_Stn.g == -1) || (this.jdField_a_of_type_Stn.f == -1)) && (((!this.g) && (suk.a(this.app))) || (syb.a(this.app))))
    {
      this.jdField_a_of_type_Stn.g = 0;
      this.jdField_a_of_type_Stn.f = 0;
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
      this.jdField_a_of_type_Stn.b();
      this.jdField_a_of_type_Stn.notifyDataSetChanged();
      g();
    }
    if ((this.jdField_a_of_type_Suk != null) && (this.jdField_a_of_type_Stn != null) && (!this.i) && (this.jdField_a_of_type_Suk.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Stn.g == 0) && (this.jdField_a_of_type_Stn.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Stn.f == 0))
    {
      this.i = true;
      this.jdField_a_of_type_Suk.a();
    }
  }
  
  private boolean a(ArrayList<ReadInJoyArticle> paramArrayList)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    Object localObject;
    if (paramArrayList != null) {
      localObject = bkbq.a(this.app, 1);
    }
    for (;;)
    {
      try
      {
        paramArrayList = stv.a(paramArrayList);
        if (!TextUtils.isEmpty(paramArrayList))
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putString("subscript_feeds_readinjoy_articles", paramArrayList);
          bkbq.a((SharedPreferences.Editor)localObject, true);
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
    Object localObject = "8.3.5" + this.app.c() + "subscript_guid";
    if ((this.app.getPreferences().getBoolean((String)localObject, true)) && (suk.f(this.app))) {
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
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.g = ((Resources)localObject).getColor(2131167081);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.f = ((Resources)localObject).getColor(2131167082);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Float = aepi.a(2, 14, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.e = aepi.a(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Int = aepi.a(30.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_b_of_type_Int = aepi.a(7.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.h = aepi.a(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_c_of_type_Int = aepi.a(3.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_JavaLangString = alud.a(2131715065);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setId(2131377243);
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
    if (suv.a().a(this.app)) {
      suv.a().a(this.app.getEntityManagerFactory().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_Alwx);
    addObserver(this.jdField_a_of_type_Stx);
    this.app.a().addObserver(this);
    if ((bkbq.b(this.app)) && ((stw)this.app.a(64) != null)) {}
    nbv.b("2278", this.app, true, new stm(this));
  }
  
  private void g()
  {
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (this.jdField_a_of_type_Stn.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378345)).setText(2131698243);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!bool) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166014);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130850072);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(false);
        if (this.jdField_a_of_type_Suk != null) {
          this.jdField_a_of_type_Suk.d();
        }
        return;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166015);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!bool) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166014);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(true);
      return;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166015);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Suk.g();
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Stn.a(this.jdField_a_of_type_Suk);
      return;
      this.jdField_a_of_type_Suk.h();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_Int = ((Integer)paramView.getTag(2131377248)).intValue();
    a(false);
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131379325))
    {
      paramDragFrameLayout = (sut)paramDragFrameLayout.a().getTag(2131377245);
      if (paramDragFrameLayout != null)
      {
        azqs.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.jdField_a_of_type_JavaLangString, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.jdField_b_of_type_Int, "", "", "");
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
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (this.jdField_a_of_type_Stn == null)) {
      return super.dispatchTouchEvent(paramMotionEvent);
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
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.h = false;
      int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getHeight();
      if (f2 >= this.jdField_c_of_type_Int) {
        if ((this.jdField_a_of_type_Suk != null) && (this.jdField_a_of_type_Suk.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Suk.jdField_a_of_type_AndroidViewView != null))
        {
          localObject = this.jdField_a_of_type_Suk.jdField_a_of_type_AndroidViewView.findViewById(2131376191);
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
            if ((j >= 0) && (j < this.jdField_a_of_type_Stn.getCount()))
            {
              if (j == this.jdField_b_of_type_Int) {
                this.h = true;
              }
              if (this.jdField_a_of_type_Stn.getItem(j).equals("SubscriptRecommendController"))
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
    syp.a(null, "SUBSCRIPT_FEEDS_COST");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      new MqqHandler().postDelayed(new SubscriptFeedsActivity.2(this), 1000L);
    }
    setContentView(2131560208);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("come_from", 0);
    this.jdField_c_of_type_Long = super.getIntent().getLongExtra("start_time", 0L);
    this.f = super.getIntent().getBooleanExtra("has_red_hot", false);
    this.jdField_a_of_type_Sty = new sty();
    setTitle(swy.a(this.app, getApplicationContext()));
    c();
    boolean bool = suk.f(this.app);
    this.rightViewText.setText(2131692013);
    if (bool)
    {
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365761);
      this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131366281));
      SwipListView localSwipListView = this.jdField_a_of_type_ComTencentWidgetSwipListView;
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label644;
      }
      paramBundle = getResources().getDrawable(2131167080);
      label281:
      localSwipListView.setDivider(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131296787));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(new stk(this));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_Bicq);
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562583, null);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
      ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131363522)).setVisibility(8);
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378988)).setText(String.format(getResources().getString(2131696970), new Object[] { swy.a(this.app, getApplicationContext()) }));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131365851));
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new stl(this));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      d();
      this.jdField_a_of_type_Stn = new stn(this, this.app, this.jdField_a_of_type_ComTencentWidgetSwipListView, getLayoutInflater());
      this.jdField_a_of_type_Stn.a(this);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Stn);
      this.jdField_a_of_type_Stn.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_Stn.a(this.jdField_a_of_type_Sty);
      if (ThemeUtil.isInNightMode(this.app)) {
        break label658;
      }
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166014);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
      ThreadManager.executeOnSubThread(new SubscriptFeedsActivity.5(this));
      f();
      if (this.jdField_a_of_type_Suk == null) {
        this.jdField_a_of_type_Suk = new suk(this, this.app, this.jdField_a_of_type_Sty);
      }
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      return true;
      this.rightViewText.setVisibility(8);
      break;
      label644:
      paramBundle = getResources().getDrawable(2131166274);
      break label281;
      label658:
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166015);
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
    removeObserver(this.jdField_a_of_type_Alwx);
    removeObserver(this.jdField_a_of_type_Stx);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(null);
    }
    if (this.jdField_a_of_type_Stn != null)
    {
      this.jdField_a_of_type_Stn.a();
      this.jdField_a_of_type_Stn = null;
    }
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (this.jdField_a_of_type_Suk != null) {
      this.jdField_a_of_type_Suk.f();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    this.jdField_a_of_type_Sty.a();
    this.jdField_a_of_type_Sty = null;
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
      azqs.b(this.app, "dc00899", "Pb_account_lifeservice", "0", "0X80064CC", "0X80064CC", 0, 0, "" + j, "" + this.jdField_c_of_type_Long, "", "");
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
    boolean bool = suk.c(this.app);
    Object localObject = super.findViewById(2131368657);
    if (bool) {}
    for (int j = 0;; j = 8)
    {
      ((View)localObject).setVisibility(j);
      if (this.jdField_b_of_type_Boolean)
      {
        if ((bkbq.b(this.app)) && ((stw)this.app.a(64) != null)) {}
        this.jdField_b_of_type_Boolean = false;
      }
      if (this.g)
      {
        String str = suk.a(this.app);
        Intent localIntent = new Intent(this, PublicAccountBrowser.class);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "http://sqimg.qq.com/qq_product_operations/dyzx_folder/index.html?_bid=2312";
        }
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", this.app.c());
        localIntent.putExtra("fromLocalUrl", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("assignBackText", alud.a(2131715053));
        localIntent.putExtra("hideRightButton", true);
        localIntent.putExtra("assignBackText", swy.a(this.app, this));
        localIntent.putExtra("call_from", 1001);
        startActivity(localIntent);
        overridePendingTransition(2130772186, 2130771980);
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscript full recommend need show !");
        }
        this.g = false;
        azqs.b(this.app, "CliOper", "", "", "0X8006505", "0X8006505", 0, 0, "", "", "", "");
      }
      a();
      b();
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    suv.a().d(this.app);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    label306:
    label356:
    int k;
    switch (paramView.getId())
    {
    default: 
    case 2131377243: 
    case 2131368655: 
    case 2131377242: 
      do
      {
        return;
        azqs.b(this.app, "CliOper", "", "", "0X8006572", "0X8006572", 0, 0, "", "", "", "");
        adpm.a(this, swy.a(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
        suk.b(this.app, false);
        e();
        return;
        azqs.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005734", "0X8005734", 0, 0, "", "", "", "");
        adpm.a(this, swy.a(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
        suk.b(this.app, false);
        e();
        return;
      } while (((Integer)paramView.getTag(2131377246)).intValue() != stn.d);
      localObject2 = paramView.getTag(2131377245);
      Object localObject3 = paramView.getTag(2131377254);
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label536;
        }
        j = ((Integer)localObject2).intValue();
        localObject2 = Integer.valueOf(j);
        if (((Integer)localObject2).intValue() <= 0) {
          break label541;
        }
        azqs.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        azqs.b(this.app, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(suv.a().a((String)localObject1)))
        {
          localObject3 = (PublicAccountHandler)this.app.a(11);
          if (localObject3 != null) {
            ((PublicAccountHandler)localObject3).a();
          }
        }
        paramView = paramView.getTag(2131377247);
        if (paramView == null) {
          break label580;
        }
      }
      for (paramView = (String)paramView;; paramView = "")
      {
        localObject3 = new Intent(this, ChatActivity.class);
        ((Intent)localObject3).putExtra("uintype", 1008);
        ((Intent)localObject3).putExtra("uin", (String)localObject1);
        ((Intent)localObject3).putExtra("uinname", paramView);
        ((Intent)localObject3).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("red_hot_count", (Serializable)localObject2);
        startActivity((Intent)localObject3);
        e();
        return;
        localObject1 = "";
        break;
        j = 0;
        break label306;
        azqs.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
        break label356;
      }
    case 2131369019: 
    case 2131369020: 
    case 2131369021: 
    case 2131369022: 
    case 2131369035: 
      azqs.b(null, "CliOper", "", "", "0X8006155", "0X8006155", 0, 0, "", "", "", "");
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
        if ((paramView.getId() == 2131369019) || (paramView.getId() == 2131369020) || (paramView.getId() == 2131369021) || (paramView.getId() == 2131369022))
        {
          j = ((Integer)paramView.getTag()).intValue();
          paramView = (ReadInJoyArticle)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (paramView != null)
          {
            l = paramView.mArticleID;
            ((Intent)localObject1).putExtra("subscription_click_article_id", Long.valueOf(l));
          }
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Boolean = true;
        bkbq.a(this.app, this, (Intent)localObject1);
        e();
        return;
        l = -1L;
        break;
        ((Intent)localObject1).putExtra("subscription_click_article_id", 0L);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscription folder jump to readinjoy with ReadInJoyArticles wrong param");
        }
      }
    case 2131370215: 
    case 2131370221: 
      label536:
      label541:
      label580:
      paramView = paramView.getTag(2131377254);
      if (paramView != null)
      {
        paramView = (String)paramView;
        if (suv.a().a(paramView, this.app)) {
          break label1092;
        }
        suv.a().b(paramView, this.app);
        nrt.a(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
        k = suv.a().a();
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (sut)((Iterator)localObject1).next();
        } while ((((sut)localObject2).jdField_a_of_type_JavaLangString == null) || (!((sut)localObject2).jdField_a_of_type_JavaLangString.equals(paramView)));
      }
      break;
    }
    for (int j = ((sut)localObject2).jdField_b_of_type_Int;; j = 0)
    {
      azqs.b(null, "dc00899", "Pb_account_lifeservice", paramView, "0X80064CD", "0X80064CD", 0, 0, "" + j, "" + k, "", "");
      b();
      return;
      paramView = "";
      break;
      label1092:
      suv.a().c(paramView, this.app);
      k = suv.a().a();
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (sut)((Iterator)localObject1).next();
      } while ((((sut)localObject2).jdField_a_of_type_JavaLangString == null) || (!((sut)localObject2).jdField_a_of_type_JavaLangString.equals(paramView)));
      for (j = ((sut)localObject2).jdField_b_of_type_Int;; j = 0)
      {
        azqs.b(null, "dc00899", "Pb_account_lifeservice", paramView, "0X80064CE", "0X80064CE", 0, 0, "" + j, "" + k, "", "");
        break;
        localObject1 = paramView.getTag(2131377254);
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          paramView = paramView.getTag(2131377247);
          if (paramView == null) {
            break label1359;
          }
        }
        label1359:
        for (paramView = (String)paramView;; paramView = "")
        {
          localObject2 = (bhuf)bhus.a(this, null);
          ((bhuf)localObject2).a(String.format(getResources().getString(2131696974), new Object[] { paramView }));
          ((bhuf)localObject2).a(2131696919, 3);
          ((bhuf)localObject2).c(2131690648);
          ((bhuf)localObject2).a(new stg(this, (String)localObject1, (bhuf)localObject2));
          ((bhuf)localObject2).show();
          return;
          localObject1 = "";
          break;
        }
        paramView = paramView.getTag(2131377254);
        if (paramView != null)
        {
          paramView = (String)paramView;
          azqs.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005730", "0X8005730", 0, 0, "", "", "", "");
          azqs.b(this.app, "CliOper", "", "", "0X8006241", "0X8006241", 0, 0, "", "", "", "");
          suv.a().a(paramView, this.app);
          b();
          j = syb.b(this.app, paramView);
          ajlb.b(this.app, paramView, j);
          this.app.a().c(paramView, 1008);
          localObject1 = this.app.getHandler(Conversation.class);
          if (localObject1 != null) {
            ((MqqHandler)localObject1).sendEmptyMessage(1014);
          }
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (sut)((Iterator)localObject1).next();
          } while ((((sut)localObject2).jdField_a_of_type_JavaLangString == null) || (!((sut)localObject2).jdField_a_of_type_JavaLangString.equals(paramView)));
        }
        for (j = ((sut)localObject2).jdField_b_of_type_Int;; j = 0)
        {
          azqs.b(null, "dc00899", "Pb_account_lifeservice", paramView, "0X80064D0", "0X80064D0", 0, 0, "" + j, "", "", "");
          return;
          paramView = "";
          break;
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity
 * JD-Core Version:    0.7.0.1
 */