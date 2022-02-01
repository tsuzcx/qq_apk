package com.tencent.mobileqq.activity;

import Override;
import adjo;
import adjp;
import adjq;
import adjr;
import adjs;
import adjt;
import adju;
import adjv;
import adjw;
import adjx;
import adjy;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anri;
import anvi;
import aoef;
import axpp;
import bdxj;
import bdxp;
import bdxs;
import bhec;
import bisl;
import bkzi;
import bkzz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;

public class AssociatedAccountManageActivity
  extends SubAccountBaseActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private adjw jdField_a_of_type_Adjw = new adjw(this);
  private adjy jdField_a_of_type_Adjy = new adjy(this);
  Dialog jdField_a_of_type_AndroidAppDialog;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adjr(this);
  public View a;
  public LinearLayout a;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  anvi jdField_a_of_type_Anvi = new adju(this);
  private aoef jdField_a_of_type_Aoef = new adjv(this);
  private bisl jdField_a_of_type_Bisl;
  public bkzi a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new adjp(this);
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private RotateSwitchImageView jdField_a_of_type_ComTencentMobileqqWidgetRotateSwitchImageView;
  private String jdField_a_of_type_JavaLangString;
  public List<SimpleAccount> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new adjo(this);
  public boolean a;
  private View.OnClickListener b;
  public View b;
  public LinearLayout b;
  public bkzi b;
  public List<SubAccountInfo> b;
  public boolean b;
  private View.OnClickListener c;
  public boolean c;
  
  public AssociatedAccountManageActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new adjs(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new adjt(this);
    this.jdField_a_of_type_Bkzi = null;
    this.jdField_b_of_type_Bkzi = null;
  }
  
  private View a(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131377517);
    }
    return null;
  }
  
  private View a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinearLayout localLinearLayout;
    if (paramInt == 0) {
      localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    }
    for (;;)
    {
      if (localLinearLayout == null)
      {
        return null;
        if (paramInt == 1) {
          localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        }
      }
      else
      {
        int j = localLinearLayout.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = localLinearLayout.getChildAt(i);
          Object localObject = localView.getTag();
          if (paramInt == 0)
          {
            if ((localObject != null) && ((localObject instanceof SubAccountInfo)) && (paramString.equals(((SubAccountInfo)localObject).subuin))) {
              return localView;
            }
          }
          else if ((paramInt == 1) && (localObject != null) && ((localObject instanceof SimpleAccount)) && (paramString.equals(((SimpleAccount)localObject).getUin()))) {
            return localView;
          }
          i += 1;
        }
        return null;
      }
      localLinearLayout = null;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.jdField_a_of_type_JavaLangString, this.app.getUinDisplayNameBeforeLogin(this.jdField_a_of_type_JavaLangString), new adjx(this, paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "am.deleteAccount " + this.jdField_a_of_type_JavaLangString);
    }
    if (paramBoolean) {
      axpp.a(paramString);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  private View b(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131371803);
    }
    return null;
  }
  
  private void c()
  {
    d();
    j();
    if (((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))) {
      onBackEvent();
    }
  }
  
  private void d()
  {
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      localObject = (bdxs)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      this.jdField_b_of_type_JavaUtilList.addAll(((bdxs)localObject).b());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("initSubAccountList subaccountList=").append(this.jdField_b_of_type_JavaUtilList).append(", size=");
        if (this.jdField_b_of_type_JavaUtilList == null) {
          break label130;
        }
      }
    }
    label130:
    for (Object localObject = Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size());; localObject = "null")
    {
      QLog.i("AssociatedAccountManage", 2, localObject);
      h();
      return;
      this.jdField_b_of_type_JavaUtilList.clear();
      break;
    }
  }
  
  private void h()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "bindSubAccountListView i=" + i + ", subaccount=" + this.jdField_b_of_type_JavaUtilList.get(i));
      }
      SubAccountInfo localSubAccountInfo = (SubAccountInfo)this.jdField_b_of_type_JavaUtilList.get(i);
      if (localSubAccountInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        View localView = getLayoutInflater().inflate(2131562908, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
        localView.setTag(localSubAccountInfo);
        localView.setBackgroundResource(2130839496);
        ((Button)localView.findViewById(2131380448)).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
    }
    i();
  }
  
  private void i()
  {
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "updateSubAccountListView mSubAccountListView is null or size is 0.");
      }
      return;
    }
    int j = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount();
    if (QLog.isColorLevel()) {
      QLog.i("AssociatedAccountManage", 2, "updateSubAccountListView subaccount size=" + j);
    }
    int i = 0;
    label75:
    View localView;
    SubAccountInfo localSubAccountInfo;
    if (i < j)
    {
      localView = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      localSubAccountInfo = (SubAccountInfo)this.jdField_b_of_type_JavaUtilList.get(i);
      if (localSubAccountInfo != null) {
        break label117;
      }
    }
    label187:
    label334:
    label343:
    for (;;)
    {
      i += 1;
      break label75;
      break;
      label117:
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "updateSubAccountListView i=" + i + ", view tag=" + localSubAccountInfo);
      }
      Object localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
      ImageView localImageView2;
      if (i > 0)
      {
        ((LinearLayout.LayoutParams)localObject1).topMargin = getResources().getDimensionPixelSize(2131296590);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ImageView localImageView1 = (ImageView)localView.findViewById(2131368381);
        localImageView2 = (ImageView)localView.findViewById(2131368396);
        SingleLineTextView localSingleLineTextView = (SingleLineTextView)localView.findViewById(2131371803);
        Object localObject2 = ContactUtils.getBuddyName(this.app, localSubAccountInfo.subuin, false);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localSubAccountInfo.subuin;
        }
        localSingleLineTextView.setText((CharSequence)localObject1);
        localObject2 = FaceDrawable.getUserFaceDrawable(this.app, localSubAccountInfo.subuin, (byte)3);
        if (localObject2 != null) {
          localImageView1.setImageDrawable((Drawable)localObject2);
        }
        if (localSubAccountInfo.status != 1) {
          break label334;
        }
        localImageView2.setBackgroundDrawable(null);
      }
      for (;;)
      {
        if (!AppSetting.jdField_c_of_type_Boolean) {
          break label343;
        }
        localView.setContentDescription((CharSequence)localObject1);
        break;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        break label187;
        localImageView2.setBackgroundResource(2130850402);
      }
    }
  }
  
  private void j()
  {
    Object localObject2;
    Object localObject1;
    label81:
    SimpleAccount localSimpleAccount;
    int i;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
        break label237;
      }
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(getAppRuntime().getApplication().getAllAccounts());
      if (localObject2 == null) {
        break label237;
      }
      localObject1 = this.app.getAccount();
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
          if ((localSimpleAccount != null) && (!((String)localObject1).equals(localSimpleAccount.getUin())))
          {
            int j = 0;
            i = j;
            if (this.jdField_b_of_type_JavaUtilList != null)
            {
              i = j;
              if (this.jdField_b_of_type_JavaUtilList.size() > 0)
              {
                Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
                i = 0;
                label158:
                if (localIterator.hasNext())
                {
                  SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
                  if ((localSubAccountInfo == null) || (!localSimpleAccount.getUin().equals(localSubAccountInfo.subuin))) {
                    break label322;
                  }
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    label315:
    label322:
    for (;;)
    {
      break label158;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      if (i != 0) {
        break label81;
      }
      this.jdField_a_of_type_JavaUtilList.add(localSimpleAccount);
      break label81;
      label237:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("initAccountList mAccountList=").append(this.jdField_a_of_type_JavaUtilList).append(", size=");
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label315;
        }
      }
      for (localObject1 = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size());; localObject1 = "null")
      {
        QLog.i("AssociatedAccountManage", 2, localObject1);
        l();
        k();
        return;
      }
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      findViewById(2131365746).setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    findViewById(2131365746).setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "bindAccountListView i=" + i + ", account=" + this.jdField_a_of_type_JavaUtilList.get(i));
      }
      SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localSimpleAccount == null)
      {
        i += 1;
      }
      else
      {
        View localView = getLayoutInflater().inflate(2131562907, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        if ((localView instanceof FormItemRelativeLayout))
        {
          ((FormItemRelativeLayout)localView).setNeedFocusBg(false);
          if (i != j - 1) {
            break label267;
          }
          ((FormItemRelativeLayout)localView).setBGType(3);
        }
        for (;;)
        {
          ((FormItemRelativeLayout)localView).setNeedFocusBg(true);
          localView.setTag(localSimpleAccount);
          ((ImageView)localView.findViewById(2131368381)).setScaleType(ImageView.ScaleType.FIT_CENTER);
          ((RotateSwitchImageView)localView.findViewById(2131365491)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((Button)localView.findViewById(2131365461)).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          label267:
          ((FormItemRelativeLayout)localView).setBGType(2);
        }
      }
    }
    m();
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "updateAccountListView mAccountListView is null or size is 0.");
      }
      return;
    }
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    if (QLog.isColorLevel()) {
      QLog.i("AssociatedAccountManage", 2, "updateAccountListView account size=" + j);
    }
    int i = 0;
    label75:
    View localView;
    Object localObject;
    if (i < j)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      localObject = (SimpleAccount)localView.getTag();
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "updateAccountListView i=" + i + ", view tag=" + localObject);
      }
      if (localObject != null) {
        break label153;
      }
    }
    for (;;)
    {
      i += 1;
      break label75;
      break;
      label153:
      ImageView localImageView = (ImageView)localView.findViewById(2131368381);
      SingleLineTextView localSingleLineTextView = (SingleLineTextView)localView.findViewById(2131371803);
      String str = bdxj.a(this.app, (SimpleAccount)localObject);
      localSingleLineTextView.setText(str);
      localObject = FaceDrawable.getUserFaceDrawable(this.app, ((SimpleAccount)localObject).getUin(), (byte)3);
      if ((localObject != null) && (localImageView != null)) {
        localImageView.setImageDrawable((Drawable)localObject);
      }
      if (AppSetting.jdField_c_of_type_Boolean) {
        localView.setContentDescription(str);
      }
    }
  }
  
  private void n()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755829);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558435);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644)).setText(getString(2131691473));
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AssociatedAccountManage", 2, localException.toString());
    }
  }
  
  public void a()
  {
    setTitle(2131690204);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131692403);
    this.rightViewText.setOnClickListener(new adjq(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131361925);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131378232);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131361861));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378199));
    this.leftView.setText(2131690676);
    this.leftView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131365745));
    a(bdxj.d(this.app));
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719054));
      this.leftView.setContentDescription(getString(2131690676));
      this.rightViewText.setContentDescription(getString(2131692403));
    }
  }
  
  public void a(SubAccountInfo paramSubAccountInfo)
  {
    if (paramSubAccountInfo == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2130968670);
      int i = 0;
      while (i < arrayOfString.length)
      {
        this.jdField_a_of_type_Bkzi.a(arrayOfString[i], 3);
        i += 1;
      }
      this.jdField_a_of_type_Bkzi.c(2131690697);
      this.jdField_a_of_type_Bkzi.a(this.jdField_a_of_type_Adjy);
      this.jdField_a_of_type_Adjy.a(paramSubAccountInfo);
      this.jdField_a_of_type_Bkzi.a(getString(2131719780));
    } while (this.jdField_a_of_type_Bkzi.isShowing());
    this.jdField_a_of_type_Bkzi.show();
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    if (paramSimpleAccount == null) {}
    do
    {
      return;
      this.jdField_b_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2130968576);
      int i = 0;
      while (i < arrayOfString.length)
      {
        this.jdField_b_of_type_Bkzi.a(arrayOfString[i], 1);
        i += 1;
      }
      this.jdField_b_of_type_Bkzi.c(2131690697);
      this.jdField_b_of_type_Bkzi.a(this.jdField_a_of_type_Adjw);
      this.jdField_a_of_type_Adjw.a(paramSimpleAccount);
      paramSimpleAccount = getString(2131690831).replace("${account}", paramSimpleAccount.getUin());
      this.jdField_b_of_type_Bkzi.a(paramSimpleAccount);
    } while (this.jdField_b_of_type_Bkzi.isShowing());
    this.jdField_b_of_type_Bkzi.show();
  }
  
  public void a(SimpleAccount paramSimpleAccount, boolean paramBoolean)
  {
    if (paramSimpleAccount == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountManage", 2, "deleteAccount account == null");
      }
    }
    String str;
    do
    {
      return;
      n();
      str = paramSimpleAccount.getUin();
      this.jdField_a_of_type_JavaLangString = str;
      if (!TextUtils.equals(str, this.app.getCurrentUin())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AssociatedAccountManage", 2, "deleteAccount error delete current uin");
    return;
    this.jdField_c_of_type_Boolean = true;
    a(this.jdField_a_of_type_JavaLangString, paramBoolean);
    bhec.a(str);
    this.jdField_a_of_type_JavaUtilList.remove(paramSimpleAccount);
    GesturePWDUtils.clearGestureData(this, paramSimpleAccount.getUin());
    ThreadManager.post(new AssociatedAccountManageActivity.7(this, paramBoolean, str), 8, null, true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.getApp().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AssociatedAccountManage", 2, localException.toString());
    }
  }
  
  public void b(SubAccountInfo paramSubAccountInfo)
  {
    if ((paramSubAccountInfo == null) || (TextUtils.isEmpty(paramSubAccountInfo.subuin))) {}
    bdxp localbdxp;
    do
    {
      do
      {
        return;
      } while (!c());
      this.jdField_c_of_type_Boolean = true;
      a(2131719092);
      localbdxp = (bdxp)this.app.getManager(QQManagerFactory.MGR_SUB_ACNT);
    } while (localbdxp == null);
    localbdxp.a(paramSubAccountInfo.subuin);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562906);
    setContentBackgroundResource(2130838911);
    this.jdField_a_of_type_Boolean = bdxj.b(this.app, false);
    if ((getIntent() != null) && (TextUtils.equals(getIntent().getStringExtra("fromWhere"), AccountManageActivity.class.getSimpleName()))) {
      this.jdField_b_of_type_Boolean = true;
    }
    a();
    d();
    j();
    addObserver(this.jdField_a_of_type_Anvi);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_Aoef);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "doOnDestroy");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
    removeObserver(this.jdField_a_of_type_Anvi);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_Aoef);
    b();
    e();
    super.doOnDestroy();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_c_of_type_Boolean) {
      setResult(-1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountManage", 2, "onBackEvent, finish mChanged = " + this.jdField_c_of_type_Boolean);
      }
      boolean bool = super.onBackEvent();
      overridePendingTransition(2130771990, 2130772001);
      return bool;
      setResult(0);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      if (!NetworkUtil.isNetworkAvailable(this)) {
        break label60;
      }
      ((anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).n(paramBoolean);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8193, 800L);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label60:
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(8195);
      localMessage.arg1 = 0;
      localMessage.arg2 = 2131692125;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      if (!paramBoolean) {
        bool = true;
      }
      a(bool);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity
 * JD-Core Version:    0.7.0.1
 */