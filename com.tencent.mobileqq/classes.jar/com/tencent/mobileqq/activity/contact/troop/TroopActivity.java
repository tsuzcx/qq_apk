package com.tencent.mobileqq.activity.contact.troop;

import actj;
import afmk;
import afni;
import afnk;
import afnl;
import afnm;
import afnn;
import afno;
import afnp;
import afnq;
import afnr;
import ajya;
import akfc;
import akgx;
import akgy;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import axqy;
import aydd;
import azoc;
import banb;
import bcsc;
import bfnk;
import bfpc;
import bfpp;
import bfut;
import bfuw;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TroopActivity
  extends BaseForwardSelectionActivity
  implements Handler.Callback, Observer
{
  protected static final int[] a;
  protected static final int[] b;
  public int a;
  protected afmk a;
  protected afni a;
  akgy jdField_a_of_type_Akgy = new afnq(this);
  protected View.OnClickListener a;
  protected FrameLayout a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected bcsc a;
  public bfnk a;
  protected bfut a;
  public BaseTroopView a;
  public TabBarView a;
  protected String a;
  ArrayList<BaseTroopView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, Boolean> a;
  public List<Stranger> a;
  public int b;
  public int c;
  protected boolean c;
  protected boolean d;
  boolean e;
  boolean f;
  protected boolean g;
  boolean h;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131720586, 2131689757, 2131720587, 2131691276 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130841965, 2130841971, 2130841966, 2130839257 };
  }
  
  public TroopActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "DEFAULT";
    this.jdField_a_of_type_Bcsc = new afnp(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afnl(this);
  }
  
  private int a()
  {
    if (this.jdField_b_of_type_Int == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.getCurrentAccountUin(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.getCurrentAccountUin(), 0)) {
      return localSharedPreferences.getInt("last_tab_mode", 0);
    }
  }
  
  private BaseTroopView a(int paramInt)
  {
    Object localObject;
    if (paramInt >= 4) {
      localObject = null;
    }
    BaseTroopView localBaseTroopView;
    do
    {
      return localObject;
      localBaseTroopView = (BaseTroopView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject = localBaseTroopView;
    } while (localBaseTroopView != null);
    if (this.jdField_b_of_type_Int != 2) {
      switch (paramInt)
      {
      default: 
        localObject = new TroopView(this, this.jdField_c_of_type_Boolean, this.jdField_a_of_type_Afni);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
      ((BaseTroopView)localObject).a(null, this.jdField_a_of_type_Afmk);
      return localObject;
      localObject = new TroopView(this, this.jdField_c_of_type_Boolean, this.jdField_a_of_type_Afni);
      continue;
      localObject = new DiscussionView(this);
      continue;
      switch (paramInt)
      {
      default: 
        localObject = new NotificationView(this);
        break;
      case 0: 
        if (this.jdField_c_of_type_Int == 2) {
          localObject = new TroopNotifyAndRecommendView(this);
        } else {
          localObject = new NotificationView(this);
        }
        break;
      case 1: 
        localObject = new NotificationView(this);
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    azoc localazoc = (azoc)this.app.getManager(32);
    if (localazoc != null) {
      localazoc.a(this, paramInt, paramString);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.g) {
      return;
    }
    this.g = true;
    if (this.jdField_b_of_type_Int == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.getCurrentAccountUin(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.getCurrentAccountUin(), 0))
    {
      localSharedPreferences.edit().putInt("last_tab_mode", paramInt).commit();
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Afmk = new afnm(this);
  }
  
  private void c(int paramInt)
  {
    if (AppSetting.d)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(paramInt);
        StringBuilder localStringBuilder = new StringBuilder(24);
        localStringBuilder.append(localRedDotTextView.getText());
        localRedDotTextView.setContentDescription(localStringBuilder);
        paramInt += 1;
      }
    }
  }
  
  @TargetApi(14)
  private void d()
  {
    this.f = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = findViewById(2131375493);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      ((View)localObject1).setFitsSystemWindows(true);
      ((View)localObject1).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    TextView localTextView = (TextView)findViewById(2131368429);
    localObject1 = getIntent();
    Object localObject2;
    if (((Intent)localObject1).getIntExtra("forward_type", 2147483647) == 23)
    {
      localObject2 = ajya.a(2131715154);
      localTextView.setMaxWidth(actj.a(120.0F, getResources()));
      localTextView.setText("");
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368441));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131375229));
      if (this.jdField_b_of_type_Int == 2) {
        break label854;
      }
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        label175:
        localObject1 = (TextView)findViewById(2131368472);
        if (getIntent().getBooleanExtra("onlyOneSegement", false))
        {
          findViewById(2131375439).setVisibility(8);
          if (this.jdField_a_of_type_Int != 0) {
            break label916;
          }
          ((TextView)localObject1).setText(2131691087);
        }
        label226:
        if (this.jdField_b_of_type_Int == 2) {
          break label934;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839740);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131691087));
        findViewById(2131375439).setVisibility(8);
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          ((TextView)localObject1).setText(2131696509);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_Bcsc);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368179));
        g();
        f();
        if (AppSetting.d)
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label1017;
          }
          localTextView.setContentDescription(((TextView)localObject1).getText() + ajya.a(2131715151) + (String)localObject2 + ajya.a(2131715153));
          localTextView.postDelayed(new TroopActivity.5(this, localTextView), 1000L);
          label404:
          if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131715150));
          }
        }
        localObject1 = (akgx)this.app.a(26);
        ((akgx)localObject1).a();
        ((akgx)localObject1).a(false);
      }
    }
    else
    {
      localObject1 = ((Intent)localObject1).getExtras().getString("leftViewText");
      if (localObject1 != null) {
        break label1048;
      }
      localObject1 = getString(2131690572);
    }
    label916:
    label1048:
    for (;;)
    {
      localObject2 = localObject1;
      if (!this.f) {
        break;
      }
      this.app.a().addObserver(this);
      int i = this.app.a().b();
      localTextView.setVisibility(8);
      localObject2 = (TextView)findViewById(2131378015);
      Object localObject3 = (ImageView)findViewById(2131368742);
      ((TextView)localObject2).setVisibility(0);
      ((ImageView)localObject3).setVisibility(0);
      ((TextView)localObject2).setText("" + i);
      if (i <= 0) {
        ((TextView)localObject2).setVisibility(4);
      }
      a((View)localObject2, 0, 0, 0, actj.a(30.5F, getResources()));
      ((TextView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ImageView)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.d)
      {
        ((TextView)localObject2).setContentDescription(ajya.a(2131715158) + i + ajya.a(2131715152));
        ((ImageView)localObject3).setContentDescription(ajya.a(2131715157) + i + ajya.a(2131715156));
      }
      findViewById(2131375447).setBackgroundResource(2130849033);
      ((TextView)findViewById(2131368472)).setTextColor(-1);
      this.e = true;
      localObject2 = localObject1;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849555);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localObject3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
      ((ViewGroup.LayoutParams)localObject1).width = (((DisplayMetrics)localObject3).densityDpi * 36 / 160);
      ((ViewGroup.LayoutParams)localObject1).height = -2;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = ((DisplayMetrics)localObject3).densityDpi * 100 / 160;
      this.jdField_a_of_type_AndroidWidgetImageView.setMaxWidth(i);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label175;
      label854:
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label175;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839740);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new afnn(this));
      break label175;
      if (1 != this.jdField_a_of_type_Int) {
        break label226;
      }
      ((TextView)localObject1).setText(2131691084);
      break label226;
      label934:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839753);
      if (this.e) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843094);
      }
      if (this.jdField_c_of_type_Int == 2) {
        ((TextView)localObject1).setText(2131691088);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131691089));
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
        break;
        ((TextView)localObject1).setText(ajya.a(2131715155));
      }
      label1017:
      localTextView.setContentDescription((String)localObject2 + ajya.a(2131715149));
      break label404;
    }
  }
  
  private void e()
  {
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    localbfpc.a(2131696583, 5);
    localbfpc.c(2131690596);
    localbfpc.a(new afno(this, localbfpc));
    if ((!localbfpc.isShowing()) && (this != null) && (!isFinishing())) {}
    try
    {
      localbfpc.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_Int != 2)
    {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        return;
      case 0: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
  }
  
  private void g()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      bfuw localbfuw = new bfuw();
      localbfuw.jdField_a_of_type_Int = i;
      localbfuw.jdField_a_of_type_JavaLangString = getString(jdField_a_of_type_ArrayOfInt[i]);
      localbfuw.c = localbfuw.jdField_a_of_type_JavaLangString;
      localbfuw.jdField_b_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localbfuw);
      i += 1;
    }
    this.jdField_a_of_type_Bfut = bfut.a(this, localArrayList, new afnr(this));
  }
  
  private void h()
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_title", getString(2131691276));
    localIntent.putExtra("param_done_button_wording", getString(2131719221));
    localIntent.putExtra("param_done_button_highlight_wording", getString(2131719222));
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 99);
    startActivityForResult(localIntent, 1300);
    axqy.b(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    axqy.b(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfut.showAsDropDown(this.jdField_a_of_type_Afmk.b(), this.jdField_a_of_type_Afmk.b().getWidth() - getResources().getDimensionPixelSize(2131298619) - getResources().getDimensionPixelSize(2131298615), getResources().getDimensionPixelSize(2131298616));
  }
  
  public void a(int paramInt)
  {
    BaseTroopView localBaseTroopView = a(paramInt);
    if (localBaseTroopView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView == localBaseTroopView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView = localBaseTroopView;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c();
    if (isResume()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new TroopActivity.3(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bfut != null) && (this.jdField_a_of_type_Bfut.isShowing());
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_Bfut.dismiss();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559676);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Bfnk = new bfnk(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("is_from_show_ext_troop_list", false);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_Afni = new afnk(this);
    }
    this.d = getIntent().getBooleanExtra("fromH5", false);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopType");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("key_tab_mode", 0);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("_key_mode", a());
    this.jdField_c_of_type_Int = getIntent().getIntExtra("show_mode", 2);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("is_select_troop", false);
    if (this.jdField_a_of_type_Int == 4) {
      this.jdField_a_of_type_Int = a();
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      if (aydd.a().a(this.app) <= 0) {
        break label327;
      }
      this.jdField_a_of_type_Int = 1;
      if (this.jdField_a_of_type_Int != 0) {
        break label345;
      }
      axqy.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = getIntent().getIntExtra("key_tab_mode", 0);
      c();
      d();
      this.app.addObserver(this.jdField_a_of_type_Akgy);
      return true;
      label327:
      if (akfc.b(this.app) <= 0) {
        break;
      }
      this.jdField_a_of_type_Int = 0;
      break;
      label345:
      if (this.jdField_a_of_type_Int == 1) {
        axqy.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.app.a().deleteObserver(this);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
      if (localBaseTroopView != null) {
        localBaseTroopView.g();
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      b(this.jdField_a_of_type_Int);
    }
    super.doOnDestroy();
    this.jdField_a_of_type_Aqbe = null;
    this.app.removeObserver(this.jdField_a_of_type_Akgy);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Intent localIntent;
    if ((paramInt == 4) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      localIntent = new Intent();
      if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("isDataChanged", bool);
      setResult(-1, localIntent);
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
    }
    if (this.jdField_a_of_type_Bfut != null) {
      this.jdField_a_of_type_Bfut.a();
    }
    this.h = false;
    if (!this.jdField_b_of_type_Boolean) {
      b(this.jdField_a_of_type_Int);
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    }
    this.h = true;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c();
    }
    if (this.d)
    {
      a(4, this.jdField_a_of_type_JavaLangString);
      this.d = false;
      this.jdField_a_of_type_JavaLangString = "DEFAULT";
    }
  }
  
  public void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771988, 2130771989);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1234) {
      runOnUiThread(new TroopActivity.11(this));
    }
    for (;;)
    {
      return true;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
        if (localBaseTroopView != null) {
          localBaseTroopView.a(paramMessage);
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 1300))
    {
      this.jdField_a_of_type_Int = 1;
      f();
      if (paramIntent != null) {
        banb.a(this, paramIntent.getStringExtra("roomId"), true);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new TroopActivity.12(this));
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity
 * JD-Core Version:    0.7.0.1
 */