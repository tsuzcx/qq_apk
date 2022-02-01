package com.tencent.mobileqq.activity.contact.troop;

import Override;
import ajdx;
import ajfa;
import ajfd;
import ajfe;
import ajff;
import ajfg;
import ajfh;
import ajfi;
import ajfj;
import ajgr;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import anvx;
import aoce;
import aoeb;
import aoec;
import bdla;
import bdzy;
import bfgz;
import biuc;
import bkyc;
import bleh;
import blek;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  protected ajdx a;
  protected ajfa a;
  protected View.OnClickListener a;
  protected FrameLayout a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aoec jdField_a_of_type_Aoec = new ajfi(this);
  protected biuc a;
  public bkyc a;
  protected bleh a;
  public BaseTroopView a;
  public TabBarView a;
  protected String a;
  ArrayList<BaseTroopView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, Boolean> a;
  public List<Stranger> a;
  public int b;
  public int c;
  public boolean c;
  public int d;
  protected boolean d;
  protected boolean e;
  boolean f;
  boolean g;
  protected boolean h;
  boolean i;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131719735, 2131689651, 2131719736, 2131691245 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130842529, 2130842535, 2130842530, 2130839590 };
  }
  
  public TroopActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "DEFAULT";
    this.jdField_a_of_type_Biuc = new ajfh(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ajfe(this);
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
        localObject = new TroopView(this, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_Ajfa);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
      ((BaseTroopView)localObject).a(null, this.jdField_a_of_type_Ajdx);
      return localObject;
      localObject = new TroopView(this, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_Ajfa);
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
    bfgz localbfgz = (bfgz)this.app.getManager(QQManagerFactory.MGR_TROOP_CREATE);
    if (localbfgz != null) {
      localbfgz.a(this, paramInt, paramString);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.h) {
      return;
    }
    this.h = true;
    if (this.jdField_b_of_type_Int == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.getCurrentAccountUin(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.getCurrentAccountUin(), 0))
    {
      localSharedPreferences.edit().putInt("last_tab_mode", paramInt).commit();
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajdx = new ajff(this);
  }
  
  private void c(int paramInt)
  {
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
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
    this.g = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = findViewById(2131376947);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      ((View)localObject1).setFitsSystemWindows(true);
      ((View)localObject1).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    TextView localTextView = (TextView)findViewById(2131369231);
    localObject1 = getIntent();
    Object localObject2;
    if (((Intent)localObject1).getIntExtra("forward_type", 2147483647) == 23)
    {
      localObject2 = anvx.a(2131714507);
      localTextView.setMaxWidth(AIOUtils.dp2px(120.0F, getResources()));
      localTextView.setText("");
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369262));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369245));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131376642));
      if (this.jdField_b_of_type_Int == 2) {
        break label870;
      }
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        label189:
        localObject1 = (TextView)findViewById(2131369278);
        if (getIntent().getBooleanExtra("onlyOneSegement", false))
        {
          findViewById(2131376882).setVisibility(8);
          if (this.jdField_d_of_type_Int != 3) {
            break label941;
          }
          ((TextView)localObject1).setText(2131691073);
        }
        label241:
        if (this.jdField_b_of_type_Int == 2) {
          break label976;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840352);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131691072));
        findViewById(2131376882).setVisibility(8);
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          ((TextView)localObject1).setText(2131695945);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_Biuc);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368901));
        f();
        e();
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label1059;
          }
          localTextView.setContentDescription(((TextView)localObject1).getText() + anvx.a(2131714504) + (String)localObject2 + anvx.a(2131714506));
          localTextView.postDelayed(new TroopActivity.5(this, localTextView), 1000L);
          label419:
          if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131714503));
          }
        }
        localObject1 = (aoeb)this.app.getBusinessHandler(BusinessHandlerFactory.STRANGER_HANDLER);
        ((aoeb)localObject1).a();
        ((aoeb)localObject1).a(false);
      }
    }
    else
    {
      localObject1 = ((Intent)localObject1).getExtras().getString("leftViewText");
      if (localObject1 != null) {
        break label1090;
      }
      localObject1 = getString(2131690676);
    }
    label941:
    label1090:
    for (;;)
    {
      localObject2 = localObject1;
      if (!this.g) {
        break;
      }
      this.app.getMessageFacade().addObserver(this);
      int j = this.app.getMessageFacade().getUnreadMsgsNum();
      localTextView.setVisibility(8);
      localObject2 = (TextView)findViewById(2131379722);
      Object localObject3 = (ImageView)findViewById(2131369605);
      ((TextView)localObject2).setVisibility(0);
      ((ImageView)localObject3).setVisibility(0);
      ((TextView)localObject2).setText("" + j);
      if (j <= 0) {
        ((TextView)localObject2).setVisibility(4);
      }
      a((View)localObject2, 0, 0, 0, AIOUtils.dp2px(30.5F, getResources()));
      ((TextView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ImageView)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        ((TextView)localObject2).setContentDescription(anvx.a(2131714511) + j + anvx.a(2131714505));
        ((ImageView)localObject3).setContentDescription(anvx.a(2131714510) + j + anvx.a(2131714509));
      }
      findViewById(2131376890).setBackgroundResource(2130850110);
      ((TextView)findViewById(2131369278)).setTextColor(-1);
      this.f = true;
      localObject2 = localObject1;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850733);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localObject3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
      ((ViewGroup.LayoutParams)localObject1).width = (((DisplayMetrics)localObject3).densityDpi * 36 / 160);
      ((ViewGroup.LayoutParams)localObject1).height = -2;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      j = ((DisplayMetrics)localObject3).densityDpi * 100 / 160;
      this.jdField_a_of_type_AndroidWidgetImageView.setMaxWidth(j);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label189;
      label870:
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label189;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698931);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ajfg(this));
      break label189;
      if (this.jdField_a_of_type_Int == 0)
      {
        ((TextView)localObject1).setText(2131691072);
        break label241;
      }
      if (1 != this.jdField_a_of_type_Int) {
        break label241;
      }
      ((TextView)localObject1).setText(2131691071);
      break label241;
      label976:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840365);
      if (this.f) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843770);
      }
      if (this.jdField_c_of_type_Int == 2) {
        ((TextView)localObject1).setText(2131691074);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131691075));
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
        break;
        ((TextView)localObject1).setText(anvx.a(2131714508));
      }
      localTextView.setContentDescription((String)localObject2 + anvx.a(2131714502));
      break label419;
    }
  }
  
  private void e()
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
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < jdField_a_of_type_ArrayOfInt.length)
    {
      blek localblek = new blek();
      localblek.jdField_a_of_type_Int = j;
      localblek.jdField_a_of_type_JavaLangString = getString(jdField_a_of_type_ArrayOfInt[j]);
      localblek.c = localblek.jdField_a_of_type_JavaLangString;
      localblek.jdField_b_of_type_Int = jdField_b_of_type_ArrayOfInt[j];
      localArrayList.add(localblek);
      j += 1;
    }
    this.jdField_a_of_type_Bleh = bleh.a(this, localArrayList, new ajfj(this));
  }
  
  private void g()
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_title", getString(2131691245));
    localIntent.putExtra("param_done_button_wording", getString(2131718470));
    localIntent.putExtra("param_done_button_highlight_wording", getString(2131718471));
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 99);
    startActivityForResult(localIntent, 1300);
    bdla.b(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    bdla.b(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bleh.showAsDropDown(this.jdField_a_of_type_Ajdx.b(), this.jdField_a_of_type_Ajdx.b().getWidth() - getResources().getDimensionPixelSize(2131298811) - getResources().getDimensionPixelSize(2131298807), getResources().getDimensionPixelSize(2131298808));
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
    return (this.jdField_a_of_type_Bleh != null) && (this.jdField_a_of_type_Bleh.isShowing());
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_Bleh.dismiss();
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
    super.setContentView(2131559925);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Bkyc = new bkyc(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("key_from", 0);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("is_from_show_ext_troop_list", false);
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_Ajfa = new ajfd(this);
    }
    this.e = getIntent().getBooleanExtra("fromH5", false);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopType");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("key_tab_mode", 0);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("_key_mode", a());
    this.jdField_c_of_type_Int = getIntent().getIntExtra("show_mode", 2);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("is_select_troop", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("show_type", false);
    if (this.jdField_c_of_type_Boolean)
    {
      ajgr.b(true);
      if (this.jdField_a_of_type_Int == 4) {
        this.jdField_a_of_type_Int = a();
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        if (bdzy.a().a(this.app) <= 0) {
          break label375;
        }
        this.jdField_a_of_type_Int = 1;
        label289:
        if (this.jdField_a_of_type_Int != 0) {
          break label393;
        }
        bdla.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = getIntent().getIntExtra("key_tab_mode", 0);
      c();
      d();
      this.app.addObserver(this.jdField_a_of_type_Aoec);
      return true;
      ajgr.b(false);
      break;
      label375:
      if (aoce.b(this.app) <= 0) {
        break label289;
      }
      this.jdField_a_of_type_Int = 0;
      break label289;
      label393:
      if (this.jdField_a_of_type_Int == 1) {
        bdla.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.app.getMessageFacade().deleteObserver(this);
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
    this.jdField_a_of_type_Aupt = null;
    this.app.removeObserver(this.jdField_a_of_type_Aoec);
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
    if (this.jdField_a_of_type_Bleh != null) {
      this.jdField_a_of_type_Bleh.a();
    }
    this.i = false;
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
    this.i = true;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c();
    }
    if (this.e)
    {
      a(4, this.jdField_a_of_type_JavaLangString);
      this.e = false;
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
      e();
      if (paramIntent != null) {
        TroopUtils.enterTroopAio(this, paramIntent.getStringExtra("roomId"), true);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity
 * JD-Core Version:    0.7.0.1
 */