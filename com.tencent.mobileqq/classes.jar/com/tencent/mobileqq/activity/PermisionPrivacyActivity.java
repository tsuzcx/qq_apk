package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contacts.base.CardConfigManager.CardConfigs;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.LightalkSwitchObserver;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;
import tbt;
import tbu;
import tbv;
import tbw;
import tbx;
import tbz;
import tcb;
import tcc;
import tcd;
import tce;
import tch;
import tci;
import tcj;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, PhoneContactManager.IPhoneContactListener
{
  private int jdField_a_of_type_Int = -1;
  View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  public TextView a;
  private CardConfigManager.CardConfigs jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new tce(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tcc(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new tcd(this);
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public TroopHandler a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new tcb(this);
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  private LightalkSwitchManager jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager;
  private LightalkSwitchObserver jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver = new tbu(this);
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new tcj(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  protected BounceScrollView a;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public QQProgressNotifier a;
  View jdField_b_of_type_AndroidViewView;
  private CompoundButton jdField_b_of_type_AndroidWidgetCompoundButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  View jdField_c_of_type_AndroidViewView;
  private CompoundButton jdField_c_of_type_AndroidWidgetCompoundButton;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem c;
  private FormSimpleItem d;
  public FormSwitchItem d;
  private FormSimpleItem e;
  public FormSwitchItem e;
  public FormSwitchItem f;
  public FormSwitchItem g;
  public FormSwitchItem h;
  public FormSwitchItem i;
  
  public PermisionPrivacyActivity()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton = null;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new tci(this);
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void c()
  {
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371220));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371221));
    boolean bool = SharedPreUtils.i(this, this.app.getCurrentAccountUin());
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setChecked(bool);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    int j;
    label212:
    Object localObject2;
    if (bool)
    {
      j = 2131435375;
      ((TextView)localObject1).setText(j);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.d();
      this.jdField_b_of_type_AndroidViewView = findViewById(2131371217);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131371218);
      if (!QQStoryManager.j())
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        ((FormSimpleItem)this.jdField_b_of_type_AndroidViewView).setBgType(3);
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131371216);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371219));
      e();
      this.f = ((FormSwitchItem)findViewById(2131371225));
      localObject1 = (ContactSyncManager)this.app.getManager(40);
      if (!((ContactSyncManager)localObject1).d()) {
        break label1068;
      }
      this.f.setChecked(((ContactSyncManager)localObject1).c());
      this.f.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131371227));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131371229));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371231));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.c(false));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371232));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371233));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371230));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371234));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371235));
      localObject1 = (FriendsManager)this.app.getManager(50);
      localObject2 = ((FriendsManager)localObject1).b(this.app.getCurrentAccountUin());
      if (!((Card)localObject2).allowClick) {
        break label1080;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label381:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject2).allowPeopleSee);
      if (((Card)localObject2).allowCalInteractive) {
        break label1101;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已启用");
      label411:
      localObject2 = (CardHandler)this.app.a(2);
      ((CardHandler)localObject2).o();
      ((CardHandler)localObject2).p();
      this.h = ((FormSwitchItem)findViewById(2131371236));
      this.h.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true));
      this.i = ((FormSwitchItem)findViewById(2131371237));
      this.i.setChecked(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager.b());
      localObject2 = (TextView)findViewById(2131371238);
      ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
      String str = getString(2131436984);
      tbt localtbt = new tbt(this, this, "http://laidian.qq.com");
      SpannableString localSpannableString = new SpannableString(((TextView)localObject2).getText());
      localSpannableString.setSpan(localtbt, str.indexOf("了解详情"), str.length(), 17);
      ((TextView)localObject2).setText(localSpannableString);
      if (this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager.a()) {
        break label1114;
      }
      this.i.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      label603:
      this.g = ((FormSwitchItem)findViewById(2131371224));
      localObject2 = this.g;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b())) {
        break label1131;
      }
      bool = true;
      label642:
      ((FormSwitchItem)localObject2).setChecked(bool);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      a(this.app.n());
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.app.q());
      bool = this.app.p();
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool);
      b(this.app.o());
      this.jdField_b_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.g.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.h.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371222));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      localObject1 = ((FriendsManager)localObject1).b();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label1136;
      }
    }
    label1068:
    label1080:
    label1101:
    label1114:
    label1131:
    label1136:
    for (localObject1 = "暂无";; localObject1 = ((List)localObject1).size() + "人")
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371223));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      ThreadManager.getSubThreadHandler().post(new tbz(this));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371215));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      d();
      if (AppSetting.b)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription("动态权限设置");
        this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131436794));
        this.jdField_a_of_type_AndroidViewView.setContentDescription("加好友设置");
        this.f.setContentDescription("可通过系统通讯录发起QQ聊天");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("向好友展示网络状态");
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("在联系人展示可能认识的人");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("允许附近的人赞我");
        this.g.setContentDescription("个性签名同步到说说");
        this.i.setContentDescription("接收来电消息");
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("连续登录天数对他人可见");
      }
      return;
      j = 2131435376;
      break;
      this.f.setVisibility(8);
      break label212;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label381;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("未启用");
      break label411;
      this.i.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      break label603;
      bool = false;
      break label642;
    }
  }
  
  private void d()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "bindState = " + j);
    }
    String str2 = "";
    String str1;
    if ((j == 1) || (j == 5)) {
      str1 = "未启用";
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(str1);
      return;
      if (((j == 7) && (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e())) || (j == 6))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().isStopFindMatch) {
          str1 = "未启用";
        } else {
          str1 = "未匹配";
        }
      }
      else if (j != 9)
      {
        str1 = str2;
        if (j == 7)
        {
          str1 = str2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e()) {}
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b() == 1)
      {
        str1 = "未匹配";
      }
      else
      {
        str1 = "已匹配";
      }
    }
  }
  
  private void d(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  private void e()
  {
    Object localObject2 = ((FriendsManager)this.app.getManager(50)).a(this.app.c());
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = VipGrayConfigHelper.a().a(this.app.c(), ((Card)localObject2).namePlateOfKingGameId, ((Card)localObject2).namePlateOfKingDan, ((Card)localObject2).namePlateOfKingDanDisplatSwitch, true);
    }
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1);
    localObject2 = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0);
    boolean bool2 = ((SharedPreferences)localObject2).getBoolean("plate_of_king_red_dot_" + this.app.c(), false);
    if (!bool1)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject1).getStatus() == 1)
      {
        ((URLDrawable)localObject1).setBounds(0, 0, UIUtils.a(this.app.getApp(), 47.0F), UIUtils.a(this.app.getApp(), 14.0F));
        ((URLDrawable)localObject1).setURLDrawableListener(new tbv(this));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject1, UIUtils.a(this.app.getApp(), 47.0F), UIUtils.a(this.app.getApp(), 14.0F));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new tbw(this, bool2, (SharedPreferences)localObject2, bool1));
      return;
      ((URLDrawable)localObject1).restartDownload();
      ((URLDrawable)localObject1).setBounds(0, 0, 1, 1);
      break;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131438831));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (!bool2) {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(this.app.getApp().getResources().getDrawable(2130845923));
      }
    }
  }
  
  void a()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("title", getString(2131436795));
    startActivity(localIntent.putExtra("url", "http://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  public void a(int paramInt)
  {
    d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    Locale localLocale;
    if (QLog.isColorLevel())
    {
      localLocale = Locale.getDefault();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs != null) {
        break label103;
      }
    }
    label103:
    for (Object localObject = "config is null";; localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs.a))
    {
      QLog.i("CommonSwitchTag", 2, String.format(localLocale, "updateMayKnowInContactLayout isChecked: %s, config: %s", new Object[] { Boolean.valueOf(paramBoolean), localObject }));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs == null)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        ThreadManager.post(new tbx(this), 5, null, true);
      }
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0) {
        a(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean);
      }
      return;
    }
  }
  
  public void c(int paramInt) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    super.setContentView(2130970570);
    setTitle(2131436781);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager = ((LightalkSwitchManager)this.app.getManager(85));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(84));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(20));
    c();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.s();
    this.app.t();
    this.app.c(true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    e();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    int j;
    BounceScrollView localBounceScrollView;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131371214));
      if (!TextUtils.isEmpty(getIntent().getStringExtra("scrollflag")))
      {
        j = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.getTop() - UIUtils.b(this) / 2;
        localBounceScrollView = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (j <= 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      localBounceScrollView.scrollTo(0, j);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130845870);
      ThreadManager.getUIHandler().postDelayed(new tch(this), 1000L);
      return;
      label98:
      j = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131371219: 
    case 2131371220: 
    case 2131371221: 
    case 2131371224: 
    case 2131371225: 
    case 2131371226: 
    case 2131371227: 
    case 2131371228: 
    case 2131371229: 
    default: 
      return;
    case 2131371216: 
      a();
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      return;
    case 2131371217: 
      paramView = QZoneHelper.UserInfo.a();
      paramView.a = this.app.getCurrentAccountUin();
      paramView.b = this.app.getCurrentNickname();
      QZoneHelper.b(this, paramView, -1);
      return;
    case 2131371218: 
      paramView = new Intent(this, QQStoryFriendSettings.class);
      paramView.putExtra("from", 1);
      startActivity(paramView);
      StoryReportor.a("friend_story_settings", "clk_set", 0, 0, new String[] { "", "", "", "" });
      return;
    case 2131371222: 
      startActivity(new Intent(this, SpecailCareListActivity.class));
      return;
    case 2131371223: 
      ReportController.b(this.app, "CliOper", "", "", "0X8004C47", "0X8004C47", 3, 0, "", "", "", "");
      paramView = new Intent(this, UncommonlyUsedContactsActivity.class);
      paramView.putExtra("isBack2Root", true);
      paramView.addFlags(67108864);
      startActivity(paramView);
      return;
    case 2131371215: 
      int j = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "bindState = " + j);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800689F", "0X800689F", 0, 0, "", "", "", "");
      Object localObject = null;
      paramView = localObject;
      switch (j)
      {
      default: 
        paramView = new Intent(this, SettingActivity2.class);
        paramView.putExtra("kSrouce", 7);
      }
      while (paramView != null)
      {
        paramView.addFlags(67108864);
        startActivity(paramView);
        return;
        ContactUtils.a(4);
        paramView = new Intent(this, BindNumberActivity.class);
        paramView.putExtra("kSrouce", 7);
        ReportController.b(this.app, "CliOper", "", "", "0X80053E1", "0X80053E1", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X80068A0", "0X80068A0", 0, 0, "", "", "", "");
        continue;
        RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
        paramView = localObject;
        if (localRespondQueryQQBindingStat != null)
        {
          paramView = localObject;
          if (localRespondQueryQQBindingStat.lastUsedFlag == 3L)
          {
            paramView = new Intent(this.app.getApp().getApplicationContext(), PhoneMatchActivity.class);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().isStopFindMatch)
            {
              paramView = new Intent(this, PhoneLaunchActivity.class);
              paramView.putExtra("needAlert", true);
              paramView.putExtra("fromStopAndMatch", true);
              paramView.putExtra("fromPermiPriv", true);
              paramView.putExtra("leftViewText", "返回");
            }
            else
            {
              paramView = new Intent(this, SettingActivity2.class);
              paramView.putExtra("kSrouce", 7);
            }
          }
        }
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
    startActivity(new Intent(this, ShowReactiveActivity.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */