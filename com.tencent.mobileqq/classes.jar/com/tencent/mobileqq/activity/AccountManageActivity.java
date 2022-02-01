package com.tencent.mobileqq.activity;

import Override;
import abwp;
import acni;
import acnj;
import acnk;
import acnl;
import acnn;
import acno;
import acnp;
import acnq;
import acnr;
import acns;
import acnt;
import acnu;
import acnv;
import acnw;
import acnx;
import acnz;
import acoa;
import acob;
import acoc;
import acod;
import acoe;
import acof;
import acog;
import acoh;
import acoi;
import acoj;
import acok;
import acol;
import acom;
import acon;
import amsu;
import amsw;
import amtj;
import amwl;
import anbq;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awjn;
import axuy;
import axvm;
import axvp;
import bcef;
import bcqj;
import bcqk;
import bcqt;
import bfpm;
import bfrr;
import bfun;
import bfur;
import bfvk;
import bhht;
import bhjv;
import bjnw;
import bjon;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import npt;

public class AccountManageActivity
  extends IphoneTitleBarActivity
{
  public float a;
  private acon jdField_a_of_type_Acon = new acon(this);
  amsu jdField_a_of_type_Amsu = new acnv(this);
  private amwl jdField_a_of_type_Amwl = new acnx(this);
  private anbq jdField_a_of_type_Anbq = new acnw(this);
  public Dialog a;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new acnn(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new acnl(this);
  private View jdField_a_of_type_AndroidViewView;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  private axvm jdField_a_of_type_Axvm = new acoe(this);
  private bhht jdField_a_of_type_Bhht;
  public bjnw a;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = new acof(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private RotateSwitchImageView jdField_a_of_type_ComTencentMobileqqWidgetRotateSwitchImageView;
  public SimpleAccount a;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List<SimpleAccount> a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new acns(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new acnr(this);
  public boolean a;
  private float jdField_b_of_type_Float;
  public Dialog b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new acno(this);
  private View jdField_b_of_type_AndroidViewView;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private AccountObserver jdField_b_of_type_MqqObserverAccountObserver = new acod(this);
  public boolean b;
  private float jdField_c_of_type_Float;
  public Dialog c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new acni(this);
  public boolean c;
  private View.OnClickListener d;
  public boolean d;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new acnq(this);
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  
  public AccountManageActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new acnp(this);
    this.jdField_a_of_type_Bjnw = null;
    this.jdField_d_of_type_Boolean = true;
  }
  
  private View a(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131377244);
    }
    return null;
  }
  
  private CharSequence a()
  {
    Object localObject2 = this.app.getOnlineStatus();
    long l = axuy.a().a(this.app);
    Object localObject1 = axuy.a().b(l, (AppRuntime.Status)localObject2);
    Object localObject3 = ((amsw)this.app.getManager(51)).d(this.app.getCurrentUin());
    localObject2 = axuy.a().a(l, (AppRuntime.Status)localObject2, 1, (Friends)localObject3);
    if (localObject2 == null) {
      return localObject1;
    }
    localObject3 = ((Drawable)localObject2).getBounds();
    if ((((Rect)localObject3).left == 0) && (((Rect)localObject3).right == 0) && (((Rect)localObject3).top == 0) && (((Rect)localObject3).bottom == 0))
    {
      int i = AIOUtils.dp2px(16.0F, getResources());
      ((Drawable)localObject2).setBounds(0, 0, i, i);
    }
    localObject2 = new bhjv((Drawable)localObject2);
    ((bhjv)localObject2).a(AIOUtils.dp2px(8.0F, getResources()));
    localObject1 = new SpannableString("[online]" + (String)localObject1);
    ((SpannableString)localObject1).setSpan(localObject2, 0, "[online]".length(), 17);
    return localObject1;
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.b);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int i = bfrr.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    bfrr.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i + 1);
    paramActivity.startActivity(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.jdField_a_of_type_JavaLangString, this.app.getUinDisplayNameBeforeLogin(this.jdField_a_of_type_JavaLangString), new acom(this, paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "am.deleteAccount " + this.jdField_a_of_type_JavaLangString);
    }
    if (paramBoolean) {
      awjn.a(paramString);
    }
  }
  
  private View b(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131371618);
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject3 = (bcqt)this.app.getManager(61);
    int m = ((bcqt)localObject3).a();
    Object localObject1 = (TipsBar)findViewById(2131377943);
    ((TipsBar)localObject1).setBackgroundColor(getResources().getColor(2131166984));
    ((TipsBar)localObject1).setTipsIcon(getResources().getDrawable(2130850404));
    ((TipsBar)localObject1).a().setTextColor(getResources().getColorStateList(2131167019));
    if (((TipsBar)localObject1).a() != null) {
      ((TipsBar)localObject1).a().setVisibility(8);
    }
    int j = 0;
    int k = 0;
    int i;
    Object localObject2;
    boolean bool;
    if (paramBoolean)
    {
      i = k;
      if (!this.g)
      {
        i = k;
        if (m == 0)
        {
          if (!bfun.a().a()) {
            break label674;
          }
          if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5000)) {
            break label649;
          }
          i = k;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("AccountManagerActivity.refreshSubAccount() isAccount2Bind=");
        if (m <= 0) {
          break label679;
        }
        bool = true;
        label180:
        QLog.d("AccountManageActivity", 2, bool);
      }
      j = i;
      if (m == 0)
      {
        ThreadManager.post(new AccountManageActivity.9(this), 8, null, false);
        j = i;
      }
    }
    if ((j == 0) && (m == 1)) {
      if (bfun.a().a(this.app.getCurrentAccountUin())) {
        i = j;
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        label249:
        if (((TipsBar)localObject1).getVisibility() != 8) {
          ((TipsBar)localObject1).setVisibility(8);
        }
        label293:
        if (((TipsBar)localObject1).getVisibility() == 0) {
          ((TipsBar)localObject1).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        }
        localObject1 = null;
        localObject2 = null;
        if (m == 1)
        {
          SubAccountInfo localSubAccountInfo = ((bcqt)localObject3).a("sub.uin.default");
          localObject1 = localObject2;
          if (localSubAccountInfo != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localSubAccountInfo.subuin))
            {
              localObject2 = localSubAccountInfo.subname;
              localObject3 = ContactUtils.getBuddyNickName(this.app, localSubAccountInfo.subuin, true);
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if (!TextUtils.isEmpty(localSubAccountInfo.subname))
                {
                  localObject1 = localObject2;
                  if (((String)localObject3).equals(localSubAccountInfo.subname)) {}
                }
                else
                {
                  localSubAccountInfo.subname = ((String)localObject3);
                  localObject1 = localObject3;
                }
              }
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (localSubAccountInfo != null) {
              localObject2 = localSubAccountInfo.subuin;
            }
          }
          if (localSubAccountInfo != null) {
            a(this.jdField_b_of_type_AndroidWidgetImageView, localSubAccountInfo.subuin);
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          label489:
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("refreshSubAccount() uin=").append(this.app.getCurrentAccountUin()).append(" isAccountChanged=").append(paramBoolean).append(" isAccount1Bind=").append(this.g).append(" account2BindedNum=").append(m).append(" final action=").append(i).append(" sAccountName=");
            if (((String)localObject1).length() != 0) {
              break label1069;
            }
            localObject2 = "_empty_";
          }
        }
        break;
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, (String)localObject2);
        if (AppSetting.c) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号" + (String)localObject1);
        }
        return;
        label649:
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
        {
          i = k;
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
            break;
          }
        }
        i = 2;
        break;
        label674:
        i = 1;
        break;
        label679:
        bool = false;
        break label180;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 4)) {
          break label1149;
        }
        i = 3;
        break label249;
        bfun.a().a(true);
        d();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5000, 1000L);
        if (((TipsBar)localObject1).getVisibility() == 8) {
          break label293;
        }
        ((TipsBar)localObject1).setVisibility(8);
        break label293;
        bcef.b(this.app, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
        ((TipsBar)localObject1).setTag("0X8004001");
        localObject2 = getString(2131718645);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.c) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0) {
          ((TipsBar)localObject1).setVisibility(0);
        }
        d();
        break label293;
        ((TipsBar)localObject1).setTag("0X8004456");
        localObject2 = getString(2131718677);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.c) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0)
        {
          bcef.b(this.app, "CliOper", "", "", "0X8004456", "0X8004456", 0, 0, "", "", "", "");
          ((TipsBar)localObject1).setVisibility(0);
        }
        d();
        break label293;
        if (m > 1)
        {
          localObject2 = m + amtj.a(2131698902);
          localObject1 = ((bcqt)localObject3).a();
          if (((ArrayList)localObject1).size() == 2)
          {
            a(this.jdField_b_of_type_AndroidWidgetImageView, (String)((ArrayList)localObject1).get(0));
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            a(this.jdField_a_of_type_AndroidWidgetImageView, (String)((ArrayList)localObject1).get(1));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          break label489;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject2 = localObject1;
        break label489;
        label1069:
        if ((((String)localObject1).length() == 1) || (((String)localObject1).length() == 2)) {
          localObject2 = localObject1;
        } else if (((String)localObject1).length() > 2) {
          localObject2 = ((String)localObject1).substring(0, 2) + "|" + ((String)localObject1).length();
        } else {
          localObject2 = localObject1;
        }
      }
      label1149:
      i = j;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays > 0L)
      {
        FriendProfileCardActivity.a = this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays != 1L) && ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays <= 1L) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a))) {
          break label173;
        }
        localObject = String.format(getString(2131693555), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.a - this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidAppDialog == null) {
        break label255;
      }
      localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365552);
      if (localTextView != null)
      {
        localTextView.requestFocus();
        localTextView.setText((CharSequence)localObject);
        localTextView.setContentDescription((CharSequence)localObject);
      }
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
      FriendProfileCardActivity.a = 30L;
      break;
      label173:
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a)
      {
        localObject = String.format(getString(2131693556), new Object[] { Integer.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
      else
      {
        localObject = String.format(getString(2131693557), new Object[0]);
        continue;
        localObject = String.format(getString(2131693557), new Object[0]);
      }
    }
    label255:
    this.jdField_b_of_type_AndroidAppDialog = new ReportDialog(this, 2131755826);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131558992);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365556);
    if (localTextView != null) {
      localTextView.setText(getString(2131693553));
    }
    localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365552);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    Object localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365541);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131690620);
      ((TextView)localObject).setOnClickListener(new acnj(this));
    }
    localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365547);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131693554);
      ((TextView)localObject).setOnClickListener(new acnk(this));
    }
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755826);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558434);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365552)).setText(getString(2131691388));
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
  }
  
  private void l()
  {
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      getAppRuntime().getApplication().refreAccountList();
      localObject2 = getAppRuntime().getApplication().getAllAccounts();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initAccountList list=").append(localObject2).append(", size=");
        if (localObject2 == null) {
          break label217;
        }
        localObject1 = Integer.valueOf(((List)localObject2).size());
        label84:
        QLog.i("AccountManageActivity", 2, localObject1);
      }
      if (localObject2 != null) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.add(null);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("initAccountList accountList=").append(this.jdField_a_of_type_JavaUtilList).append(", size=");
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label224;
        }
      }
    }
    label217:
    label224:
    for (Object localObject1 = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size());; localObject1 = "null")
    {
      QLog.i("AccountManageActivity", 2, localObject1);
      m();
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      localObject1 = "null";
      break label84;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, "bindAccountListView i=" + i + ", account=" + this.jdField_a_of_type_JavaUtilList.get(i));
      }
      View localView;
      if (this.jdField_a_of_type_JavaUtilList.get(i) == null)
      {
        localView = getLayoutInflater().inflate(2131558413, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371700));
        localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        localView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
      for (;;)
      {
        i += 1;
        break;
        localView = getLayoutInflater().inflate(2131558414, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        localView.setTag(Integer.valueOf(i));
        ((ImageView)localView.findViewById(2131368236)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        if ((localView instanceof FormItemRelativeLayout))
        {
          ((FormItemRelativeLayout)localView).setNeedFocusBg(true);
          ((FormItemRelativeLayout)localView).setBGType(2);
        }
        ((Button)localView.findViewById(2131365368)).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        ((RotateSwitchImageView)localView.findViewById(2131365398)).setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
    }
    n();
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, "updateAccountListView accountListLinearLayout is null or size is 0.");
      }
    }
    QQAppInterface localQQAppInterface;
    int i;
    label83:
    View localView;
    Object localObject;
    int j;
    SimpleAccount localSimpleAccount;
    do
    {
      do
      {
        return;
        int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        if (QLog.isColorLevel()) {
          QLog.i("AccountManageActivity", 2, "updateAccountListView account size=" + k);
        }
        localQQAppInterface = this.app;
        i = 0;
        if (i >= k) {
          break;
        }
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject = localView.getTag();
        if (QLog.isColorLevel()) {
          QLog.i("AccountManageActivity", 2, "updateAccountListView i=" + i + ", view tag=" + localObject);
        }
      } while (localObject == null);
      j = ((Integer)localObject).intValue();
      localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(j);
    } while (localSimpleAccount == null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131368236);
    String str1 = localSimpleAccount.getUin();
    ImageView localImageView2 = (ImageView)localView.findViewById(2131364509);
    localImageView2.clearAnimation();
    if ((str1 != null) && (str1.length() > 0) && (str1.equals(this.app.getCurrentAccountUin())) && (!this.jdField_a_of_type_Boolean))
    {
      localImageView2.setVisibility(0);
      label262:
      ((TextView)localView.findViewById(2131361856)).setText(str1);
      TextView localTextView = (TextView)localView.findViewById(2131371615);
      if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey(str1)) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilHashMap.get(str1)))) {
        break label438;
      }
      String str2 = BaseApplicationImpl.sApplication.getProperty(Constants.PropertiesKey.nickName.toString() + str1);
      localObject = str2;
      if (TextUtils.isEmpty(str2)) {
        localObject = str1;
      }
      label369:
      localTextView.setText((CharSequence)localObject);
      ThreadManager.postImmediately(new AccountManageActivity.14(this, localQQAppInterface, str1, localSimpleAccount, (String)localObject, localTextView, localImageView1), null, true);
      if (AppSetting.c)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label455;
        }
        localView.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      i += 1;
      break label83;
      break;
      localImageView2.setVisibility(8);
      break label262;
      label438:
      localObject = (String)this.jdField_b_of_type_JavaUtilHashMap.get(str1);
      break label369;
      label455:
      if (localImageView2.getVisibility() == 0) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label506;
        }
        localView.setContentDescription((String)localObject + amtj.a(2131698905));
        break;
      }
      label506:
      localView.setContentDescription((String)localObject + amtj.a(2131698901));
    }
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("login_from_account_change", true);
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    }
    localIntent.putExtra("befault_uin", this.app.getCurrentAccountUin());
    startActivityForResult(localIntent, 9876);
  }
  
  private void p()
  {
    AppRuntime.Status localStatus = this.app.getOnlineStatus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(localStatus);
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, String.format("updateOnlineStatus: %s", new Object[] { localStatus }));
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130771973);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130771974);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755826);
    localReportDialog.setContentView(2131559153);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365556);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365552);
      if (paramString1 != null)
      {
        if (paramString2 != null) {
          break label149;
        }
        paramString1.setVisibility(8);
      }
    }
    for (;;)
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365541);
      if (paramString1 != null) {
        paramString1.setText(2131690620);
      }
      paramString1 = (TextView)localReportDialog.findViewById(2131365547);
      if (paramString1 != null) {
        paramString1.setText(2131694201);
      }
      localReportDialog.setOnDismissListener(paramOnDismissListener);
      return localReportDialog;
      localTextView.setVisibility(0);
      localTextView.setText(paramString1);
      break;
      label149:
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
    }
  }
  
  public void a()
  {
    q();
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131691727);
    localTextView.setOnClickListener(new acob(this));
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2131558989, null));
    setLayerType(this.rightHighLView);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(8.0F * this.mDensity));
    this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
    this.rightHighLView.setVisibility(8);
    this.rightHighLView.setText(2131692310);
    this.rightHighLView.setOnClickListener(new acog(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131361859));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372024));
    p();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new acoh(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370375);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new acoi(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131374622);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new acoj(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377938));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377923));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850406);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377924));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850406);
    k();
    localObject = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Float = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float - 110.0F * this.mDensity);
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363981));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acok(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    if (AppSetting.c)
    {
      localTextView.setContentDescription(amtj.a(2131698904));
      this.rightHighLView.setContentDescription(amtj.a(2131698903));
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131693553));
      this.jdField_b_of_type_AndroidViewView.setContentDescription("退出QQ");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号");
      bfpm.a(findViewById(2131361899), false);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bjnw = ((bjnw)bjon.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2130968576);
      int i = 0;
      while (i < arrayOfString.length)
      {
        this.jdField_a_of_type_Bjnw.a(arrayOfString[i], 1);
        i += 1;
      }
      this.jdField_a_of_type_Bjnw.c(2131690620);
      this.jdField_a_of_type_Acon.a(paramInt);
      this.jdField_a_of_type_Bjnw.a(this.jdField_a_of_type_Acon);
      localObject = getString(2131690754).replace("${account}", ((SimpleAccount)localObject).getUin());
      this.jdField_a_of_type_Bjnw.a((CharSequence)localObject);
    } while (this.jdField_a_of_type_Bjnw.isShowing());
    this.jdField_a_of_type_Bjnw.show();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.w("Switch_Account", 2, "onItemLongClick simple account = null");
      }
      return;
    }
    String str1 = ((SimpleAccount)localObject).getUin();
    String str2 = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_JavaLangString = str1;
    if (str1.equals(str2)) {
      a(this, this.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("hunter", 2, "++++++++++");
    }
    a(this.jdField_a_of_type_JavaLangString, paramBoolean);
    bfvk.a(str1);
    npt.a(getBaseContext(), str2);
    this.jdField_a_of_type_JavaUtilList.remove(localObject);
    bcqt localbcqt = (bcqt)this.app.getManager(61);
    if ((localbcqt != null) && (localbcqt.a(str1)))
    {
      bcqk.a(this.app, (byte)0, str1);
      localbcqt.f(str1);
      localbcqt.a(str1, null, true);
      localbcqt.a(str1, 2);
      bcqk.a(this.app, str1, 7);
      int i = 1 - this.app.getConversationFacade().a(str1, 7000);
      if (i != 0) {
        this.app.getConversationFacade().d(str1, 7000, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "deleteAccount() hint need to verify,msg num=1, subUin=" + str1);
      }
    }
    GesturePWDUtils.clearGestureData(getActivity(), ((SimpleAccount)localObject).getUin());
    if (str1.equals(str2))
    {
      this.app.getApplication().refreAccountList();
      localObject = getAppRuntime().getApplication().getAllAccounts();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (((SimpleAccount)localObject).isLogined()) {
          getAppRuntime().startPCActivePolling(((SimpleAccount)localObject).getUin(), "delAccount");
        }
      }
    }
    ThreadManager.post(new AccountManageActivity.19(this, str1, paramBoolean, paramInt), 8, null, true);
  }
  
  void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, 34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new acol(this, paramView, paramInt2));
        paramView.clearAnimation();
        paramView.startAnimation((Animation)localObject);
      }
      return;
      if (paramInt2 == 1)
      {
        localObject = new TranslateAnimation(0.0F, -34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(this, paramInt1);
      }
    }
  }
  
  public void a(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString);
    if (localBitmap == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 1, false);
    }
    for (;;)
    {
      paramImageView.setTag(paramString);
      return;
      QQAppInterface localQQAppInterface = this.app;
      paramImageView.setImageBitmap(QQAppInterface.getRoundFaceBitmap(localBitmap));
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.getApp().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    label28:
    View localView;
    if (i < j)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (localView.getTag() != null) {
        break label108;
      }
      if (!paramBoolean) {
        break label82;
      }
      localView.setOnClickListener(null);
      localView.setBackgroundResource(2130850276);
      localView.setEnabled(false);
    }
    for (;;)
    {
      i += 1;
      break label28;
      break;
      label82:
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setBackgroundResource(2130839482);
      localView.setEnabled(true);
      continue;
      label108:
      ImageView localImageView = (ImageView)localView.findViewById(2131364509);
      Object localObject = (TextView)localView.findViewById(2131371615);
      if ((localView instanceof FormItemRelativeLayout))
      {
        localObject = (FormItemRelativeLayout)localView;
        if (paramBoolean) {
          break label197;
        }
      }
      label197:
      for (boolean bool = true;; bool = false)
      {
        ((FormItemRelativeLayout)localObject).setNeedFocusBg(bool);
        ((FormItemRelativeLayout)localView).setBGType(2);
        if (i != 0) {
          break label223;
        }
        if (!paramBoolean) {
          break label203;
        }
        localView.setOnClickListener(null);
        localImageView.setImageResource(2130844603);
        break;
      }
      label203:
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localImageView.setImageResource(2130844603);
      continue;
      label223:
      if (paramBoolean)
      {
        localView.setOnClickListener(null);
        localImageView.setImageResource(2130844603);
      }
      else
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localImageView.setImageResource(2130844603);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    label28:
    Object localObject2;
    if (i < j)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      localObject1 = ((View)localObject2).getTag();
      if (localObject1 != null) {
        break label62;
      }
    }
    label62:
    ImageView localImageView1;
    ImageView localImageView2;
    RelativeLayout localRelativeLayout;
    RotateSwitchImageView localRotateSwitchImageView;
    for (;;)
    {
      i += 1;
      break label28;
      break;
      localImageView1 = (ImageView)((View)localObject2).findViewById(2131364509);
      localImageView2 = (ImageView)((View)localObject2).findViewById(2131368236);
      localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131371618);
      localRotateSwitchImageView = (RotateSwitchImageView)((View)localObject2).findViewById(2131365398);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131377245);
      if ((localImageView2.getTag() == null) || (localRelativeLayout.getTag() == null))
      {
        localImageView2.setTag("left");
        localRelativeLayout.setTag("left");
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label247;
      }
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2130771969, 5);
      }
      localRotateSwitchImageView.setVisibility(0);
      ((ImageView)localObject2).setVisibility(0);
      localRotateSwitchImageView.setImageResource(2130849590);
      a(localRotateSwitchImageView, 2130771970, 4);
      a((View)localObject2, 2130771970, 4);
      a(localImageView2, 2130771974, 0);
      a(localRelativeLayout, 2130771974, 0);
    }
    label247:
    localRotateSwitchImageView.setVisibility(8);
    ((ImageView)localObject2).setVisibility(8);
    int k = ((Integer)localObject1).intValue();
    Object localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
    if ((localObject1 != null) && (((SimpleAccount)localObject1).getUin() != null) && (((SimpleAccount)localObject1).getUin().length() > 0) && (((SimpleAccount)localObject1).getUin().equals(this.app.getCurrentAccountUin()))) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2130771970, 4);
      }
      a(localRotateSwitchImageView, 2130771969, 5);
      a((View)localObject2, 2130771969, 5);
      a(localImageView2, 2130771973, 1);
      a(localRelativeLayout, 2130771973, 1);
      break;
      localImageView1.setVisibility(8);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int i;
    label28:
    Object localObject2;
    do
    {
      do
      {
        return;
        int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        i = 0;
        if (i >= j) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((View)localObject1).getTag();
      } while (localObject2 == null);
      int k = ((Integer)localObject2).intValue();
      localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
    } while (localObject2 == null);
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131364509);
    if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.getCurrentAccountUin())) && (!this.jdField_a_of_type_Boolean)) {
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break label28;
      break;
      ((ImageView)localObject1).setVisibility(8);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5000);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label34:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label34;
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
    if (paramInt2 == -1)
    {
      if ((paramInt1 != 1000) && (paramInt1 != 9876)) {
        break label24;
      }
      l();
    }
    label24:
    while ((paramInt1 != 0) || (paramIntent == null)) {
      return;
    }
    p();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558415);
    setTitle(2131698496);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    setContentBackgroundResource(2130838891);
    a();
    l();
    addObserver(this.jdField_a_of_type_Amsu);
    addObserver(this.jdField_a_of_type_Anbq);
    addObserver(this.jdField_a_of_type_Amwl);
    this.app.registObserver(this.jdField_b_of_type_MqqObserverAccountObserver);
    this.app.addObserver(this.jdField_a_of_type_Axvm);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    ThreadManager.post(new AccountManageActivity.1(this), 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener);
    sendBroadcast(new Intent("before_account_change"));
    bcef.b(this.app, "dc00898", "", "", "0X800AC37", "0X800AC37", 0, 0, "", "", "", "");
    bcef.b(this.app, "dc00898", "", "", "0X800735C", "0X800735C", 0, 0, "", "", "", "");
    ((axvp)this.app.getManager(370)).a(40001L, false);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeHandler(getClass());
    this.app.unRegistObserver(this.jdField_b_of_type_MqqObserverAccountObserver);
    removeObserver(this.jdField_a_of_type_Amsu);
    removeObserver(this.jdField_a_of_type_Anbq);
    removeObserver(this.jdField_a_of_type_Amwl);
    this.app.removeObserver(this.jdField_a_of_type_Axvm);
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    d();
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = null;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    b(false);
    n();
    g();
  }
  
  public void e()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 230).setTitle(getString(2131718656)).setMessage(getString(2131718631));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131718692), new acnt(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(getString(2131690620), new acnu(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    try
    {
      if (this.jdField_a_of_type_Bhht == null)
      {
        this.jdField_a_of_type_Bhht = new bhht(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bhht.c(2131694271);
        this.jdField_a_of_type_Bhht.c(false);
      }
      this.jdField_a_of_type_Bhht.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  public void g()
  {
    try
    {
      if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
        this.jdField_a_of_type_Bhht.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  public void h()
  {
    i();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new acnz(this).a();
    }
    Dialog localDialog = a("你确定退出QQ？", null, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    Object localObject = (TextView)localDialog.findViewById(2131365547);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new acoa(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131365541);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new acoc(this));
    }
    localObject = getString(2131717612);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_d_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountManageActivity", 4, "init CheckBox:receiveMsgWhenExitPerfExist:" + bool + ", bReceiveMsgOnExit:" + this.jdField_d_of_type_Boolean);
    }
    localObject = (CheckBox)localDialog.findViewById(2131364514);
    if ((bool) && (this.jdField_d_of_type_Boolean)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.jdField_d_of_type_Boolean);
    this.jdField_c_of_type_AndroidAppDialog = localDialog;
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  public void i()
  {
    if ((this.jdField_c_of_type_AndroidAppDialog == null) || (this.jdField_c_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_c_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "onAccountChanged zsw");
    }
    super.onAccountChanged();
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      n();
    }
    for (;;)
    {
      addObserver(this.jdField_a_of_type_Amsu);
      addObserver(this.jdField_a_of_type_Anbq);
      addObserver(this.jdField_a_of_type_Amwl);
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "onAccountChanged2");
      }
      ThreadManager.postImmediately(new AccountManageActivity.23(this), null, true);
      bcqj.b(this.app, this);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AccountManageActivity.24(this), 500L);
      boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      return;
      l();
    }
    QLog.e("AccountManageActivity", 2, "subAccountNotifySwitch is null");
  }
  
  public void onAccoutChangeFailed()
  {
    g();
    this.jdField_e_of_type_Boolean = false;
    o();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "zsw onLogout");
      }
      this.f = false;
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */