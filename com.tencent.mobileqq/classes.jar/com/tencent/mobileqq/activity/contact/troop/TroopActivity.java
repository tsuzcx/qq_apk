package com.tencent.mobileqq.activity.contact.troop;

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
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.stranger.data.Stranger;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

public class TroopActivity
  extends BaseForwardSelectionActivity
  implements Handler.Callback, Observer
{
  protected static final int[] a;
  protected static final int[] b;
  public int a;
  protected View.OnClickListener a;
  protected FrameLayout a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected BaseTroopView.ITroopContext a;
  protected BaseTroopView a;
  protected ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack a;
  StrangerObserver jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver = new TroopActivity.6(this);
  protected TabBarView.OnTabChangeListener a;
  protected TabBarView a;
  protected MqqWeakReferenceHandler a;
  protected PopupMenuDialog a;
  protected String a;
  ArrayList<BaseTroopView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected HashMap<String, Boolean> a;
  protected List<Stranger> a;
  public int b;
  public int c;
  public boolean c;
  public int d;
  protected boolean d;
  protected boolean e = false;
  boolean f;
  boolean g;
  protected boolean h = false;
  boolean i;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131720052, 2131689690, 2131720053, 2131691274 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130842574, 2130842580, 2130842575, 2130839527 };
  }
  
  public TroopActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 2;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "DEFAULT";
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new TroopActivity.5(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopActivity.8(this);
  }
  
  private int a()
  {
    Object localObject;
    if (this.jdField_b_of_type_Int == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("noti_and_rec_last_tab_mode_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last_tab_mode_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0);
    }
    return ((SharedPreferences)localObject).getInt("last_tab_mode", 0);
  }
  
  private BaseTroopView a(int paramInt)
  {
    if (paramInt >= 4) {
      return null;
    }
    Object localObject = (BaseTroopView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localObject != null) {
      return localObject;
    }
    if (this.jdField_b_of_type_Int != 2) {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          localObject = new TroopView(this, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack);
        } else {
          localObject = new DiscussionView(this);
        }
      }
      else {
        localObject = new TroopView(this, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
    ((BaseTroopView)localObject).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext);
    return localObject;
  }
  
  private void a(int paramInt, String paramString)
  {
    ITroopCreateService localITroopCreateService = (ITroopCreateService)this.app.getRuntimeService(ITroopCreateService.class, "");
    if (localITroopCreateService != null) {
      localITroopCreateService.startCreateTroopSession(this, paramInt, paramString);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.h) {
      return;
    }
    this.h = true;
    Object localObject;
    if (this.jdField_b_of_type_Int == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("noti_and_rec_last_tab_mode_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last_tab_mode_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0);
    }
    ((SharedPreferences)localObject).edit().putInt("last_tab_mode", paramInt).commit();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext = new TroopActivity.2(this);
  }
  
  private void c(int paramInt)
  {
    if (AppSetting.jdField_d_of_type_Boolean)
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
    Object localObject1 = findViewById(2131376809);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      ((View)localObject1).setFitsSystemWindows(true);
      ((View)localObject1).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    TextView localTextView = (TextView)findViewById(2131369202);
    localObject1 = getIntent();
    int j;
    Object localObject3;
    if (((Intent)localObject1).getIntExtra("forward_type", 2147483647) == 23)
    {
      localObject1 = HardCodeUtil.a(2131714925);
      localTextView.setMaxWidth(AIOUtils.b(120.0F, getResources()));
    }
    else
    {
      localObject2 = ((Intent)localObject1).getExtras().getString("leftViewText");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getString(2131690706);
      }
      if (this.g)
      {
        this.app.getMessageFacade().addObserver(this);
        j = this.app.getMessageFacade().b();
        localTextView.setVisibility(8);
        localObject3 = (TextView)findViewById(2131379476);
        localObject2 = (ImageView)findViewById(2131369563);
        ((TextView)localObject3).setVisibility(0);
        ((ImageView)localObject2).setVisibility(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(j);
        ((TextView)localObject3).setText(localStringBuilder.toString());
        if (j <= 0) {
          ((TextView)localObject3).setVisibility(4);
        }
        a((View)localObject3, 0, 0, 0, AIOUtils.b(30.5F, getResources()));
        ((TextView)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ImageView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131714929));
          localStringBuilder.append(j);
          localStringBuilder.append(HardCodeUtil.a(2131714923));
          ((TextView)localObject3).setContentDescription(localStringBuilder.toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(HardCodeUtil.a(2131714928));
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append(HardCodeUtil.a(2131714927));
          ((ImageView)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
        }
        findViewById(2131376752).setBackgroundResource(2130850434);
        ((TextView)findViewById(2131369249)).setTextColor(-1);
        this.f = true;
      }
    }
    localTextView.setText("");
    localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369233));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369216));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131376517));
    if (this.jdField_b_of_type_Int != 2)
    {
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130851075);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localObject2 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localObject3 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
        ((ViewGroup.LayoutParams)localObject2).width = (((DisplayMetrics)localObject3).densityDpi * 36 / 160);
        ((ViewGroup.LayoutParams)localObject2).height = -2;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        j = ((DisplayMetrics)localObject3).densityDpi * 100 / 160;
        this.jdField_a_of_type_AndroidWidgetImageView.setMaxWidth(j);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699378);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    Object localObject2 = (TextView)findViewById(2131369249);
    if (getIntent().getBooleanExtra("onlyOneSegement", false))
    {
      findViewById(2131376745).setVisibility(8);
      if (this.jdField_d_of_type_Int == 3)
      {
        ((TextView)localObject2).setText(2131691100);
      }
      else
      {
        j = this.jdField_a_of_type_Int;
        if (j == 0) {
          ((TextView)localObject2).setText(2131691099);
        } else if (1 == j) {
          ((TextView)localObject2).setText(2131691098);
        }
      }
    }
    if (this.jdField_b_of_type_Int != 2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840334);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131691099));
      findViewById(2131376745).setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
      if (this.f) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843861);
      }
      if (this.jdField_c_of_type_Int == 2) {
        ((TextView)localObject2).setText(2131691101);
      } else {
        ((TextView)localObject2).setText(HardCodeUtil.a(2131714926));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131691103));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((TextView)localObject2).setText(2131696212);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368866));
    f();
    e();
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((TextView)localObject2).getText());
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131714922));
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131714924));
        localTextView.setContentDescription(((StringBuilder)localObject3).toString());
        localTextView.postDelayed(new TroopActivity.4(this, localTextView), 1000L);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131714920));
        localTextView.setContentDescription(((StringBuilder)localObject2).toString());
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131714921));
      }
    }
    localObject1 = (IStrangerService)this.app.getRuntimeService(IStrangerService.class, "all");
    if (localObject1 != null)
    {
      ((IStrangerService)localObject1).getLocalList();
      ((IStrangerService)localObject1).getRemoteList(false);
    }
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Int != 2)
    {
      j = this.jdField_a_of_type_Int;
      if (j != 0)
      {
        if (j != 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    }
    int j = this.jdField_a_of_type_Int;
    if (j != 0)
    {
      if (j != 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
        return;
      }
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
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = j;
      localMenuItem.title = getString(jdField_a_of_type_ArrayOfInt[j]);
      localMenuItem.contentDescription = localMenuItem.title;
      localMenuItem.iconId = jdField_b_of_type_ArrayOfInt[j];
      localArrayList.add(localMenuItem);
      j += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.build(this, localArrayList, new TroopActivity.7(this));
  }
  
  private void g()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_title", getString(2131691274));
    localIntent.putExtra("param_done_button_wording", getString(2131718709));
    localIntent.putExtra("param_done_button_highlight_wording", getString(2131718710));
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 99);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, localIntent, 1300);
    ReportController.b(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b(), this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b().getWidth() - getResources().getDimensionPixelSize(2131298902) - getResources().getDimensionPixelSize(2131298898), getResources().getDimensionPixelSize(2131298899));
  }
  
  void a(int paramInt)
  {
    BaseTroopView localBaseTroopView1 = a(paramInt);
    if (localBaseTroopView1 == null) {
      return;
    }
    BaseTroopView localBaseTroopView2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
    if (localBaseTroopView2 != localBaseTroopView1)
    {
      if (localBaseTroopView2 != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView = localBaseTroopView1;
      localBaseTroopView1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
      if (localBaseTroopView1 != null)
      {
        localBaseTroopView1.c();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView);
      }
    }
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
    PopupMenuDialog localPopupMenuDialog = this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
    return (localPopupMenuDialog != null) && (localPopupMenuDialog.isShowing());
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    BaseTroopView localBaseTroopView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
    if (localBaseTroopView != null) {
      localBaseTroopView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559872);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("key_from", 0);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("is_from_show_ext_troop_list", false);
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack = new TroopActivity.1(this);
    }
    this.e = getIntent().getBooleanExtra("fromH5", false);
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
      if (GroupSystemMsgController.a().a(this.app) > 0) {
        this.jdField_a_of_type_Int = 1;
      } else if (RecommendTroopUtils.b(this.app) > 0) {
        this.jdField_a_of_type_Int = 0;
      }
      int j = this.jdField_a_of_type_Int;
      if (j == 0) {
        ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
      } else if (j == 1) {
        ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
    this.jdField_b_of_type_Int = getIntent().getIntExtra("key_tab_mode", 0);
    c();
    d();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
    return true;
  }
  
  protected void doOnDestroy()
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
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("isDataChanged", this.jdField_a_of_type_JavaUtilHashMap.isEmpty() ^ true);
      setResult(-1, localIntent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
    if (localObject != null) {
      ((BaseTroopView)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
    if (localObject != null) {
      ((PopupMenuDialog)localObject).onPause();
    }
    this.i = false;
    if (!this.jdField_b_of_type_Boolean) {
      b(this.jdField_a_of_type_Int);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    BaseTroopView localBaseTroopView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
    if (localBaseTroopView != null) {
      localBaseTroopView.d();
    }
    this.i = true;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    BaseTroopView localBaseTroopView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
    if (localBaseTroopView != null) {
      localBaseTroopView.c();
    }
    if (this.e)
    {
      a(4, this.jdField_a_of_type_JavaLangString);
      this.e = false;
      this.jdField_a_of_type_JavaLangString = "DEFAULT";
    }
  }
  
  protected void doOnStop()
  {
    BaseTroopView localBaseTroopView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
    if (localBaseTroopView != null) {
      localBaseTroopView.f();
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772002, 2130772003);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1234)
    {
      runOnUiThread(new TroopActivity.9(this));
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
      if (localBaseTroopView != null) {
        localBaseTroopView.a(paramMessage);
      }
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 1300))
    {
      this.jdField_a_of_type_Int = 1;
      e();
      if (paramIntent != null) {
        TroopUtils.a(this, paramIntent.getStringExtra("roomId"), true);
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (this.g))
      {
        paramObject = (TextView)findViewById(2131379476);
        ImageView localImageView = (ImageView)findViewById(2131369563);
        if ((paramObject != null) && (localImageView != null)) {
          ThreadManager.postImmediately(new TroopActivity.GetUnReadNumRunnable(this.app, new WeakReference(this), paramObject, localImageView), null, false);
        }
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity
 * JD-Core Version:    0.7.0.1
 */