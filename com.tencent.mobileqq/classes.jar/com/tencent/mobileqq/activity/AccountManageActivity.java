package com.tencent.mobileqq.activity;

import aaex;
import aaey;
import aaez;
import aafb;
import aafc;
import aafd;
import aafe;
import aaff;
import aafg;
import aafh;
import aafi;
import aafj;
import aafk;
import aafl;
import aafn;
import aafo;
import aafp;
import aafq;
import aafr;
import aafs;
import aaft;
import aafu;
import aafv;
import aafw;
import aafx;
import aafy;
import aafz;
import actj;
import ajxj;
import ajya;
import akat;
import akhb;
import akpb;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import atav;
import aujc;
import axqy;
import ayap;
import ayaq;
import ayax;
import baww;
import bbak;
import bbcz;
import bbdd;
import bbdj;
import bbeb;
import bbgu;
import bcqf;
import bcsl;
import bfpc;
import bfpp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import naz;

public class AccountManageActivity
  extends IphoneTitleBarActivity
{
  public float a;
  private aafz jdField_a_of_type_Aafz = new aafz(this);
  ajxj jdField_a_of_type_Ajxj = new aafj(this);
  private akat jdField_a_of_type_Akat = new aafl(this);
  private akhb jdField_a_of_type_Akhb = new aafk(this);
  public Dialog a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aafb(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aaez(this);
  private View jdField_a_of_type_AndroidViewView;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public LinearLayout a;
  public TextView a;
  bbgu jdField_a_of_type_Bbgu;
  private bcqf jdField_a_of_type_Bcqf;
  public bfpc a;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private RotateSwitchImageView jdField_a_of_type_ComTencentMobileqqWidgetRotateSwitchImageView;
  public SimpleAccount a;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List<SimpleAccount> a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aaff(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aafg(this);
  public boolean a;
  private float jdField_b_of_type_Float;
  public Dialog b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aafc(this);
  private View jdField_b_of_type_AndroidViewView;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private AccountObserver jdField_b_of_type_MqqObserverAccountObserver = new aafr(this);
  public boolean b;
  private float jdField_c_of_type_Float;
  public Dialog c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new aafw(this);
  public boolean c;
  private View.OnClickListener d;
  public boolean d;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new aafe(this);
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  
  public AccountManageActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new aafd(this);
    this.jdField_a_of_type_Bfpc = null;
    this.jdField_d_of_type_Boolean = true;
  }
  
  private View a(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131375998);
    }
    return null;
  }
  
  private CharSequence a()
  {
    Object localObject2 = this.app.getOnlineStatus();
    long l = aujc.a().a(this.app);
    Object localObject1 = aujc.a().a(l, (AppRuntime.Status)localObject2);
    localObject2 = aujc.a().a(l, (AppRuntime.Status)localObject2, 1);
    if (localObject2 == null) {
      return localObject1;
    }
    Rect localRect = ((Drawable)localObject2).getBounds();
    if ((localRect.left == 0) && (localRect.right == 0) && (localRect.top == 0) && (localRect.bottom == 0))
    {
      int i = actj.a(16.0F, getResources());
      ((Drawable)localObject2).setBounds(0, 0, i, i);
    }
    localObject2 = new bcsl((Drawable)localObject2);
    ((bcsl)localObject2).a(actj.a(8.0F, getResources()));
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
    int i = bbak.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    bbak.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i + 1);
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
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.jdField_a_of_type_JavaLangString, this.app.b(this.jdField_a_of_type_JavaLangString), new aafy(this, paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "am.deleteAccount " + this.jdField_a_of_type_JavaLangString);
    }
    if (paramBoolean) {
      atav.a(paramString);
    }
  }
  
  private View b(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131370650);
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject3 = (ayax)this.app.getManager(61);
    int m = ((ayax)localObject3).a();
    Object localObject1 = (TipsBar)findViewById(2131376643);
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
          if (!bbdd.a().a()) {
            break label584;
          }
          if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5000)) {
            break label559;
          }
          i = k;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("AccountManagerActivity.refreshSubAccount() isAccount2Bind=");
        if (m <= 0) {
          break label589;
        }
        bool = true;
        label114:
        QLog.d("AccountManageActivity", 2, bool);
      }
      j = i;
      if (m == 0)
      {
        ThreadManager.post(new AccountManageActivity.8(this), 8, null, false);
        j = i;
      }
    }
    if ((j == 0) && (m == 1)) {
      if (bbdd.a().a(this.app.getCurrentAccountUin())) {
        i = j;
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        label183:
        if (((TipsBar)localObject1).getVisibility() != 8) {
          ((TipsBar)localObject1).setVisibility(8);
        }
        label229:
        if (((TipsBar)localObject1).getVisibility() == 0) {
          ((TipsBar)localObject1).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        }
        localObject2 = null;
        localObject1 = null;
        if (m == 1)
        {
          SubAccountInfo localSubAccountInfo = ((ayax)localObject3).a("sub.uin.default");
          localObject2 = localObject1;
          if (localSubAccountInfo != null)
          {
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(localSubAccountInfo.subuin))
            {
              localObject1 = localSubAccountInfo.subname;
              localObject3 = bbcz.c(this.app, localSubAccountInfo.subuin, true);
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if (!TextUtils.isEmpty(localSubAccountInfo.subname))
                {
                  localObject2 = localObject1;
                  if (((String)localObject3).equals(localSubAccountInfo.subname)) {}
                }
                else
                {
                  localSubAccountInfo.subname = ((String)localObject3);
                  localObject2 = localObject3;
                }
              }
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (localSubAccountInfo != null) {
              localObject1 = localSubAccountInfo.subuin;
            }
          }
          label390:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("refreshSubAccount() uin=").append(this.app.getCurrentAccountUin()).append(" isAccountChanged=").append(paramBoolean).append(" isAccount1Bind=").append(this.g).append(" account2BindedNum=").append(m).append(" final action=").append(i).append(" sAccountName=");
            if (((String)localObject2).length() != 0) {
              break label892;
            }
            localObject1 = "_empty_";
          }
        }
        break;
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject2);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号" + (String)localObject2);
        }
        return;
        label559:
        if (this.jdField_a_of_type_Bbgu != null)
        {
          i = k;
          if (this.jdField_a_of_type_Bbgu.isShowing()) {
            break;
          }
        }
        i = 2;
        break;
        label584:
        i = 1;
        break;
        label589:
        bool = false;
        break label114;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 4)) {
          break label972;
        }
        i = 3;
        break label183;
        bbdd.a().a(true);
        d();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5000, 1000L);
        if (((TipsBar)localObject1).getVisibility() == 8) {
          break label229;
        }
        ((TipsBar)localObject1).setVisibility(8);
        break label229;
        axqy.b(this.app, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
        ((TipsBar)localObject1).setTag("0X8004001");
        localObject2 = getString(2131719838);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.jdField_d_of_type_Boolean) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0) {
          ((TipsBar)localObject1).setVisibility(0);
        }
        d();
        break label229;
        ((TipsBar)localObject1).setTag("0X8004456");
        localObject2 = getString(2131719888);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.jdField_d_of_type_Boolean) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0)
        {
          axqy.b(this.app, "CliOper", "", "", "0X8004456", "0X8004456", 0, 0, "", "", "", "");
          ((TipsBar)localObject1).setVisibility(0);
        }
        d();
        break label229;
        localObject1 = localObject2;
        if (m <= 1) {
          break label390;
        }
        localObject1 = m + ajya.a(2131699753);
        break label390;
        label892:
        if ((((String)localObject2).length() == 1) || (((String)localObject2).length() == 2)) {
          localObject1 = localObject2;
        } else if (((String)localObject2).length() > 2) {
          localObject1 = ((String)localObject2).substring(0, 2) + "|" + ((String)localObject2).length();
        } else {
          localObject1 = localObject2;
        }
      }
      label972:
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
        localObject = String.format(getString(2131694054), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.a - this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidAppDialog == null) {
        break label255;
      }
      localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365146);
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
        localObject = String.format(getString(2131694055), new Object[] { Integer.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
      else
      {
        localObject = String.format(getString(2131694056), new Object[0]);
        continue;
        localObject = String.format(getString(2131694056), new Object[0]);
      }
    }
    label255:
    this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131755791);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131558883);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365150);
    if (localTextView != null) {
      localTextView.setText(getString(2131694051));
    }
    localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365146);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    Object localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365135);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131690596);
      ((TextView)localObject).setOnClickListener(new aaex(this));
    }
    localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365141);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131694053);
      ((TextView)localObject).setOnClickListener(new aaey(this));
    }
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131755791);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558428);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365146)).setText(getString(2131691535));
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
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370733));
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
        ((ImageView)localView.findViewById(2131367679)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        if ((localView instanceof FormItemRelativeLayout))
        {
          ((FormItemRelativeLayout)localView).setNeedFocusBg(true);
          ((FormItemRelativeLayout)localView).setBGType(2);
        }
        ((Button)localView.findViewById(2131364970)).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        ((RotateSwitchImageView)localView.findViewById(2131364997)).setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
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
    ImageView localImageView1 = (ImageView)localView.findViewById(2131367679);
    String str1 = localSimpleAccount.getUin();
    ImageView localImageView2 = (ImageView)localView.findViewById(2131364175);
    localImageView2.clearAnimation();
    if ((str1 != null) && (str1.length() > 0) && (str1.equals(this.app.getCurrentAccountUin())) && (!this.jdField_a_of_type_Boolean))
    {
      localImageView2.setVisibility(0);
      label262:
      ((TextView)localView.findViewById(2131361822)).setText(str1);
      TextView localTextView = (TextView)localView.findViewById(2131370647);
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
      ThreadManager.postImmediately(new AccountManageActivity.13(this, localQQAppInterface, str1, localSimpleAccount, (String)localObject, localTextView, localImageView1), null, true);
      if (AppSetting.jdField_d_of_type_Boolean)
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
        localView.setContentDescription((String)localObject + ajya.a(2131699756));
        break;
      }
      label506:
      localView.setContentDescription((String)localObject + ajya.a(2131699752));
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
    Dialog localDialog = new Dialog(getActivity(), 2131755791);
    localDialog.setContentView(2131559037);
    TextView localTextView = (TextView)localDialog.findViewById(2131365150);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localDialog.findViewById(2131365146);
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
      paramString1 = (TextView)localDialog.findViewById(2131365135);
      if (paramString1 != null) {
        paramString1.setText(2131690596);
      }
      paramString1 = (TextView)localDialog.findViewById(2131365141);
      if (paramString1 != null) {
        paramString1.setText(2131694794);
      }
      localDialog.setOnDismissListener(paramOnDismissListener);
      return localDialog;
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
    localTextView.setText(2131691961);
    localTextView.setOnClickListener(new aafq(this));
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2131558880, null));
    setLayerType(this.rightHighLView);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(8.0F * this.mDensity));
    this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
    this.rightHighLView.setVisibility(8);
    this.rightHighLView.setText(2131692601);
    this.rightHighLView.setOnClickListener(new aafs(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131361825));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371044));
    p();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aaft(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369583);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aafu(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131373495);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new aafv(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131376638));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    k();
    localObject = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Float = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float - 110.0F * this.mDensity);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localTextView.setContentDescription(ajya.a(2131699755));
      this.rightHighLView.setContentDescription(ajya.a(2131699754));
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131694051));
      this.jdField_b_of_type_AndroidViewView.setContentDescription("退出QQ");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号");
      baww.a(findViewById(2131361863), false);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2130968576);
      int i = 0;
      while (i < arrayOfString.length)
      {
        this.jdField_a_of_type_Bfpc.a(arrayOfString[i], 1);
        i += 1;
      }
      this.jdField_a_of_type_Bfpc.c(2131690596);
      this.jdField_a_of_type_Aafz.a(paramInt);
      this.jdField_a_of_type_Bfpc.a(this.jdField_a_of_type_Aafz);
      localObject = getString(2131690814).replace("${account}", ((SimpleAccount)localObject).getUin());
      this.jdField_a_of_type_Bfpc.a((CharSequence)localObject);
    } while (this.jdField_a_of_type_Bfpc.isShowing());
    this.jdField_a_of_type_Bfpc.show();
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
    bbeb.a(str1);
    naz.a(getBaseContext(), str2);
    this.jdField_a_of_type_JavaUtilList.remove(localObject);
    ayax localayax = (ayax)this.app.getManager(61);
    if ((localayax != null) && (localayax.a(str1)))
    {
      ayaq.a(this.app, (byte)0, str1);
      localayax.e(str1);
      localayax.a(str1, null, true);
      localayax.a(str1, 2);
      ayaq.a(this.app, str1, 7);
      int i = 1 - this.app.a().a(str1, 7000);
      if (i != 0) {
        this.app.a().c(str1, 7000, i);
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
    ThreadManager.post(new AccountManageActivity.18(this, str1, paramBoolean, paramInt), 8, null, true);
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
        ((Animation)localObject).setAnimationListener(new aafx(this, paramView, paramInt2));
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
      localView.setBackgroundResource(2130849253);
      localView.setEnabled(false);
    }
    for (;;)
    {
      i += 1;
      break label28;
      break;
      label82:
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setBackgroundResource(2130839176);
      localView.setEnabled(true);
      continue;
      label108:
      ImageView localImageView = (ImageView)localView.findViewById(2131364175);
      Object localObject = (TextView)localView.findViewById(2131370647);
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
        localImageView.setImageResource(2130843904);
        break;
      }
      label203:
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localImageView.setImageResource(2130843904);
      continue;
      label223:
      if (paramBoolean)
      {
        localView.setOnClickListener(null);
        localImageView.setImageResource(2130843904);
      }
      else
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localImageView.setImageResource(2130843904);
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
      localImageView1 = (ImageView)((View)localObject2).findViewById(2131364175);
      localImageView2 = (ImageView)((View)localObject2).findViewById(2131367679);
      localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131370650);
      localRotateSwitchImageView = (RotateSwitchImageView)((View)localObject2).findViewById(2131364997);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131375999);
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
      localRotateSwitchImageView.setImageResource(2130848619);
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
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131364175);
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
    if ((this.jdField_a_of_type_Bbgu == null) || (this.jdField_a_of_type_Bbgu.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      label34:
      this.jdField_a_of_type_Bbgu = null;
      return;
    }
    catch (Exception localException)
    {
      break label34;
    }
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
    setTitle(2131699383);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    setContentBackgroundResource(2130838514);
    a();
    l();
    addObserver(this.jdField_a_of_type_Ajxj);
    addObserver(this.jdField_a_of_type_Akhb);
    addObserver(this.jdField_a_of_type_Akat);
    this.app.registObserver(this.jdField_b_of_type_MqqObserverAccountObserver);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    ThreadManager.post(new AccountManageActivity.1(this), 5, null, true);
    sendBroadcast(new Intent("before_account_change"));
    axqy.b(this.app, "dc00898", "", "", "0X800735C", "0X800735C", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeHandler(getClass());
    this.app.unRegistObserver(this.jdField_b_of_type_MqqObserverAccountObserver);
    removeObserver(this.jdField_a_of_type_Ajxj);
    removeObserver(this.jdField_a_of_type_Akhb);
    removeObserver(this.jdField_a_of_type_Akat);
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    d();
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
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
    this.jdField_a_of_type_Bbgu = bbdj.a(this, 230).setTitle(getString(2131719856)).setMessage(getString(2131719817));
    this.jdField_a_of_type_Bbgu.setPositiveButton(getString(2131719907), new aafh(this));
    this.jdField_a_of_type_Bbgu.setNegativeButton(getString(2131690596), new aafi(this));
    try
    {
      this.jdField_a_of_type_Bbgu.show();
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
      if (this.jdField_a_of_type_Bcqf == null)
      {
        this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bcqf.c(2131694918);
        this.jdField_a_of_type_Bcqf.c(false);
      }
      this.jdField_a_of_type_Bcqf.show();
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
      if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
        this.jdField_a_of_type_Bcqf.dismiss();
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
    Dialog localDialog = a("你确定退出QQ？", null, new aafn(this));
    Object localObject = (TextView)localDialog.findViewById(2131365141);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new aafo(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131365135);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new aafp(this));
    }
    localObject = getString(2131718636);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_d_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountManageActivity", 4, "init CheckBox:receiveMsgWhenExitPerfExist:" + bool + ", bReceiveMsgOnExit:" + this.jdField_d_of_type_Boolean);
    }
    localObject = (CheckBox)localDialog.findViewById(2131364180);
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
    axbt.a = 0;
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      n();
    }
    for (;;)
    {
      addObserver(this.jdField_a_of_type_Ajxj);
      addObserver(this.jdField_a_of_type_Akhb);
      addObserver(this.jdField_a_of_type_Akat);
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "onAccountChanged2");
      }
      ThreadManager.postImmediately(new AccountManageActivity.22(this), null, true);
      ayap.b(this.app, this);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AccountManageActivity.23(this), 500L);
      return;
      l();
    }
  }
  
  public void onAccoutChangeFailed()
  {
    g();
    this.jdField_e_of_type_Boolean = false;
    o();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */