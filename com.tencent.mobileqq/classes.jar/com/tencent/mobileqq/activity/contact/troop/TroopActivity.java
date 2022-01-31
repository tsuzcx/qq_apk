package com.tencent.mobileqq.activity.contact.troop;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import wia;
import wib;
import wic;
import wid;
import wie;
import wif;
import wig;
import wih;
import wii;
import wij;
import wik;
import wim;
import win;

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
  protected BaseTroopView.ITroopContext a;
  public BaseTroopView a;
  protected ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack a;
  StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new win(this);
  protected TabBarView.OnTabChangeListener a;
  public TabBarView a;
  public MqqWeakReferenceHandler a;
  protected PopupMenuDialog a;
  protected String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap a;
  public List a;
  public int b;
  protected boolean b;
  protected boolean c;
  boolean d;
  public boolean e;
  protected boolean f;
  boolean g;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131429682, 2131435480, 2131429684, 2131436210 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130840526, 2130840532, 2130840527, 2130838693 };
  }
  
  public TroopActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "DEFAULT";
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new wim(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new wic(this);
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
        localObject = new TroopView(this, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
      ((BaseTroopView)localObject).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext);
      return localObject;
      localObject = new TroopView(this, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack);
      continue;
      localObject = new DiscussionView(this);
      continue;
      switch (paramInt)
      {
      default: 
        localObject = new NotificationView(this);
        break;
      case 1: 
        localObject = new RecommendTroopView(this);
        break;
      case 0: 
        localObject = new NotificationView(this);
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.app.getManager(31);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a(this, paramInt, paramString);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.f) {
      return;
    }
    this.f = true;
    if (this.jdField_b_of_type_Int == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.getCurrentAccountUin(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.getCurrentAccountUin(), 0))
    {
      localSharedPreferences.edit().putInt("last_tab_mode", paramInt).commit();
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext = new wif(this);
  }
  
  private void c(int paramInt)
  {
    if (AppSetting.jdField_b_of_type_Boolean)
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
    this.e = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = findViewById(2131362822);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      ((View)localObject1).setFitsSystemWindows(true);
      ((View)localObject1).setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    TextView localTextView = (TextView)findViewById(2131363227);
    localObject1 = getIntent();
    Object localObject2;
    if (((Intent)localObject1).getIntExtra("forward_type", 2147483647) == 23)
    {
      localObject2 = "推荐联系人";
      localTextView.setMaxWidth(AIOUtils.a(120.0F, getResources()));
      localTextView.setText((CharSequence)localObject2);
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363456));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131366460));
      if (this.jdField_b_of_type_Int == 2) {
        break label825;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        label163:
        localObject1 = (TextView)findViewById(2131363363);
        if (getIntent().getBooleanExtra("onlyOneSegement", false))
        {
          findViewById(2131366459).setVisibility(8);
          if (this.jdField_a_of_type_Int != 0) {
            break label880;
          }
          ((TextView)localObject1).setText(2131433258);
        }
        label214:
        if (this.jdField_b_of_type_Int == 2) {
          break label898;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839130);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131433258));
        findViewById(2131366459).setVisibility(8);
        label260:
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          ((TextView)localObject1).setText(2131430379);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366461));
        h();
        f();
        g();
        if (AppSetting.jdField_b_of_type_Boolean)
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label967;
          }
          localTextView.setContentDescription(((TextView)localObject1).getText() + "页面，已选中" + (String)localObject2 + "按钮");
          localTextView.postDelayed(new wii(this, localTextView), 1000L);
          label390:
          if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("更多选项");
          }
        }
        localObject1 = (StrangerHandler)this.app.a(26);
        ((StrangerHandler)localObject1).b();
        ((StrangerHandler)localObject1).a(false);
      }
    }
    else
    {
      localObject1 = ((Intent)localObject1).getExtras().getString("leftViewText");
      if (localObject1 != null) {
        break label999;
      }
      localObject1 = getString(2131433681);
    }
    label825:
    label967:
    label999:
    for (;;)
    {
      localObject2 = localObject1;
      if (!this.e) {
        break;
      }
      this.app.a().addObserver(this);
      int i = this.app.a().b();
      localTextView.setVisibility(8);
      localObject2 = (TextView)findViewById(2131363971);
      Object localObject3 = (ImageView)findViewById(2131363970);
      ((TextView)localObject2).setVisibility(0);
      ((ImageView)localObject3).setVisibility(0);
      ((TextView)localObject2).setText("" + i);
      if (i <= 0) {
        ((TextView)localObject2).setVisibility(4);
      }
      a((View)localObject2, 0, 0, 0, AIOUtils.a(30.5F, getResources()));
      ((TextView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ImageView)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        ((TextView)localObject2).setContentDescription("返回消息界面，" + i + "条未读");
        ((ImageView)localObject3).setContentDescription("返回消息界面，" + i + "条未读");
      }
      findViewById(2131362844).setBackgroundResource(2130845744);
      ((TextView)findViewById(2131363363)).setTextColor(-1);
      this.d = true;
      localObject2 = localObject1;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130846141);
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
      break label163;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label163;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839130);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new wih(this));
      break label163;
      label880:
      if (1 != this.jdField_a_of_type_Int) {
        break label214;
      }
      ((TextView)localObject1).setText(2131433261);
      break label214;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839143);
      if (this.d) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841265);
      }
      ((TextView)localObject1).setText(2131433259);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131433045));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131433260));
      break label260;
      localTextView.setContentDescription(localTextView.getText() + "返回按钮");
      break label390;
    }
  }
  
  private void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131430344, 5);
    localActionSheet.a(2131430345, 5);
    localActionSheet.c(2131432998);
    localActionSheet.a(new wij(this, localActionSheet));
    if ((!localActionSheet.isShowing()) && (this != null) && (!isFinishing())) {}
    try
    {
      localActionSheet.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (isFinishing()) {}
    BaseTroopView localBaseTroopView1;
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_Int != 2);
      localBaseTroopView1 = a(1);
      BaseTroopView localBaseTroopView2 = a(0);
      if (this.jdField_a_of_type_Int == 1)
      {
        int i = GroupSystemMsgController.a().a(this.app);
        if ((!localBaseTroopView2.a()) && (i > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(true);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(false);
        return;
      }
    } while (this.jdField_a_of_type_Int != 0);
    ThreadManager.post(new wik(this, localBaseTroopView1), 8, null, true);
  }
  
  private void g()
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
  }
  
  private void h()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = i;
      localMenuItem.jdField_a_of_type_JavaLangString = getString(jdField_a_of_type_ArrayOfInt[i]);
      localMenuItem.c = localMenuItem.jdField_a_of_type_JavaLangString;
      localMenuItem.jdField_b_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this, localArrayList, new wib(this));
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_title", getString(2131436210));
    localIntent.putExtra("param_done_button_wording", getString(2131435947));
    localIntent.putExtra("param_done_button_highlight_wording", getString(2131435948));
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 99);
    startActivityForResult(localIntent, 1300);
    ReportController.b(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b(), this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b().getWidth() - getResources().getDimensionPixelSize(2131558947) - getResources().getDimensionPixelSize(2131558951), getResources().getDimensionPixelSize(2131558952));
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
    ((View)paramView.getParent()).post(new wig(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing());
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969436);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("is_from_show_ext_troop_list", false);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack = new wia(this);
    }
    this.c = getIntent().getBooleanExtra("fromH5", false);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopType");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("key_tab_mode", 0);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("_key_mode", a());
    if (this.jdField_a_of_type_Int == 4) {
      this.jdField_a_of_type_Int = a();
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      if (GroupSystemMsgController.a().a(this.app) <= 0) {
        break label298;
      }
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_Int != 1) {
        break label316;
      }
      ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = getIntent().getIntExtra("key_tab_mode", 0);
      c();
      d();
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
      return true;
      label298:
      if (RecommendTroopManagerImp.b(this.app) <= 0) {
        break;
      }
      this.jdField_a_of_type_Int = 1;
      break;
      label316:
      if (this.jdField_a_of_type_Int == 0) {
        ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void doOnDestroy()
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
    if (!this.jdField_a_of_type_Boolean) {
      b(this.jdField_a_of_type_Int);
    }
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
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
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.a();
    }
    this.g = false;
    if (!this.jdField_a_of_type_Boolean) {
      b(this.jdField_a_of_type_Int);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    }
    this.g = true;
    f();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c();
    }
    if (this.c)
    {
      a(4, this.jdField_a_of_type_JavaLangString);
      this.c = false;
      this.jdField_a_of_type_JavaLangString = "DEFAULT";
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2131034129, 2131034130);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1234) {
      runOnUiThread(new wid(this));
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 1300))
    {
      this.jdField_a_of_type_Int = 1;
      g();
      if (paramIntent != null) {
        TroopUtils.a(this, paramIntent.getStringExtra("roomId"));
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
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
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new wie(this));
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity
 * JD-Core Version:    0.7.0.1
 */