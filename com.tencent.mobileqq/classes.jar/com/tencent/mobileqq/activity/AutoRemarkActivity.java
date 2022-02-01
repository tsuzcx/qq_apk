package com.tencent.mobileqq.activity;

import Override;
import adxu;
import adxv;
import adxw;
import adxx;
import agej;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anyw;
import anzj;
import aoot;
import bdll;
import bhjx;
import bhlq;
import bhnv;
import bmgk;
import bmgt;
import bmtd;
import bmtk;
import brlp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AutoRemarkActivity
  extends DialogBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public int a;
  private adxx jdField_a_of_type_Adxx = new adxx(this, null);
  public Dialog a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new adxw(this);
  public EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public FriendListHandler a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  public String a;
  public boolean a;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  public int c;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public int d;
  private View d;
  
  public AutoRemarkActivity()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      if (paramString.length % 3 == 0) {
        return paramString.length / 3;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
    return paramString.length / 3 + 1;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = ((anyw)paramQQAppInterface.getManager(51)).a(paramInt + "");
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.group_name;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    while (a(paramString) > 32)
    {
      int i = paramString.length();
      if ((i >= 2) && (Character.isHighSurrogate(paramString.charAt(i - 2)))) {
        paramString = paramString.substring(0, i - 2);
      } else {
        paramString = paramString.substring(0, i - 1);
      }
    }
    return paramString;
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "startAutoRemarkActivity, " + paramString);
    }
    Intent localIntent = new Intent(paramActivity, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 1);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("k_msg_key", paramLong);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
    paramActivity.overridePendingTransition(2130772302, 2130771990);
  }
  
  public static boolean a(int paramInt)
  {
    return (brlp.a(paramInt)) || (paramInt == 3016) || (paramInt == 3003) || (paramInt == 3093);
  }
  
  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 0) {}
    while ((paramInt1 == 100) && (!paramBoolean)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return (!brlp.a(paramInt)) && (paramInt != 3016) && (paramInt != 3024) && (!TextUtils.isEmpty(paramString)) && (paramInt != 3093) && (!paramString.equals(String.valueOf(0L)));
  }
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new AutoRemarkActivity.3(this));
  }
  
  private void b(int paramInt)
  {
    Object localObject1;
    label158:
    String str;
    label231:
    label363:
    Object localObject2;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject1 = getString(2131693740);
      setTitle((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131376837);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131376794);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366148));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379883));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.app, this.jdField_c_of_type_Int));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(anzj.a(2131699764) + a(this.app, this.jdField_c_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      if (!bhjx.b(this.jdField_a_of_type_JavaLangString)) {
        break label773;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      str = "";
      if (!a(this.jdField_b_of_type_Int)) {
        break label784;
      }
      str = getIntent().getStringExtra("nick_name");
      localObject1 = str;
      if (QLog.isColorLevel())
      {
        QLog.d("AutoRemarkActivity", 2, "initUI remark = " + str + ", source id=" + this.jdField_b_of_type_Int);
        localObject1 = str;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
      }
      if ((!brlp.a(this.jdField_b_of_type_Int)) && (this.jdField_b_of_type_Int != 3016)) {
        break label816;
      }
      paramInt = 1;
      label279:
      if (paramInt == 0)
      {
        this.jdField_c_of_type_AndroidViewView = findViewById(2131375707);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        findViewById(2131375709).setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131375708));
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      if (this.jdField_a_of_type_Int != 0) {
        break label821;
      }
      setRightHighlightButton(2131717891, this);
      enableRightHighlight(true);
      setLeftViewName(getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376760));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372891));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371827));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380650));
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label1005;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = agej.a(0.0F, getResources());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("base_uin");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("base_nick");
      this.jdField_a_of_type_AndroidOsBundle.getInt("verfy_type");
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("verfy_msg");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label964;
      }
      localObject2 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).topMargin = agej.a(15.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      label554:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(aoot.a(this.app, 1, (String)localObject1));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363660));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new adxu(this));
      if (AppSetting.c)
      {
        this.leftView.setContentDescription(anzj.a(2131699763) + this.leftView.getText().toString() + anzj.a(2131699766));
        this.jdField_a_of_type_AndroidViewView.setFocusable(true);
        this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131693046) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(null);
        if (paramInt == 0)
        {
          this.jdField_c_of_type_AndroidViewView.setFocusable(true);
          this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131716670));
          findViewById(2131375709).setFocusable(true);
        }
      }
      return;
      localObject1 = anzj.a(2131699768);
      break;
      label773:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break label158;
      label784:
      localObject1 = str;
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label231;
      }
      localObject1 = str;
      if (!this.jdField_a_of_type_Boolean) {
        break label231;
      }
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("base_nick");
      break label231;
      label816:
      paramInt = 0;
      break label279;
      label821:
      setRightHighlightButton(2131692262, this);
      enableRightHighlight(true);
      setLeftButton(2131690580, this);
      if (this.jdField_a_of_type_Int != 1) {
        break label363;
      }
      this.jdField_d_of_type_AndroidViewView = findViewById(2131377414);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      localObject1 = (TextView)findViewById(2131375709);
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(2131717906);
      ((TextView)localObject1).setContentDescription(getString(2131717906));
      this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131377439));
      if (AppSetting.c)
      {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(anzj.a(2131699767));
        this.jdField_d_of_type_AndroidViewView.setFocusable(true);
      }
      this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.leftView.setVisibility(8);
      break label363;
      label964:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131689664) + ": " + (String)localObject2);
      break label554;
      label1005:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = agej.a(10.0F, getResources());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label34:
      this.jdField_a_of_type_AndroidAppDialog = bhlq.a(this, paramString, 0, 2131694098, null, new adxv(this));
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Throwable paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AutoRemarkActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  public void a()
  {
    Object localObject = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "goBack | retAddr = " + (String)localObject);
    }
    if (localObject != null)
    {
      try
      {
        localObject = Class.forName((String)localObject);
        Intent localIntent2 = new Intent();
        localIntent2.setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject).getName()));
        if ((localObject.equals(FriendProfileCardActivity.class)) || (localObject.equals(QidianProfileCardActivity.class))) {
          ProfileActivity.a(this, this.jdField_a_of_type_JavaLangString, localIntent2);
        }
        for (;;)
        {
          localIntent2.setFlags(67108864);
          localIntent2.putExtra("key_back_from_add_friend", true);
          startActivity(localIntent2);
          return;
          if (localObject.equals(NearbyPeopleProfileActivity.class))
          {
            localIntent2.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 41));
            localIntent2.putExtra("param_mode", 3);
          }
        }
        if (!getIntent().getBooleanExtra("from_newer_guide", false)) {
          break label257;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "goBack | exception = ", localClassNotFoundException);
        }
        localClassNotFoundException.printStackTrace();
        setResult(-1);
        finish();
        return;
      }
    }
    else
    {
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("has_operation", true);
      localIntent1.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      setResult(-1, localIntent1);
    }
    for (;;)
    {
      finish();
      return;
      label257:
      setResult(-1);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (a(paramEditable) > 32)
    {
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = a(paramEditable);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (i >= paramEditable.length()) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.c) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131693046) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.app, paramInt1));
    } while (!AppSetting.c);
    this.jdField_b_of_type_AndroidViewView.setContentDescription(anzj.a(2131699765) + a(this.app, paramInt1));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558704);
    setContentBackgroundResource(2130838778);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("param_mode", 0);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("source_id", 3999);
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromWzry", false);
    b(this.jdField_b_of_type_Int);
    this.app.addObserver(this.jdField_a_of_type_Adxx);
    if ((paramBundle == null) || (this.jdField_a_of_type_Int == 1))
    {
      if ((bhnv.d(this)) && (a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, getIntent().getIntExtra("sub_source_id", 0));
      }
      getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label34:
      if (Build.VERSION.SDK_INT >= 16) {
        getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      for (;;)
      {
        super.doOnDestroy();
        this.app.removeObserver(this.jdField_a_of_type_Adxx);
        return;
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  public boolean onBackEvent()
  {
    setResult(-1);
    finish();
    overridePendingTransition(2130771990, 2130772304);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!bhnv.d(this))
    {
      QQToast.a(this.app.getApp(), 1, getString(2131694008), 0).b(getTitleBarHeight());
      paramCompoundButton.setOnCheckedChangeListener(null);
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      paramCompoundButton.setOnCheckedChangeListener(this);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      Object localObject;
      if (paramCompoundButton == this.jdField_b_of_type_ComTencentWidgetSwitch)
      {
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((short)1, (List)localObject, paramBoolean);
        if (this.jdField_b_of_type_ComTencentWidgetSwitch.isChecked()) {
          bdll.b(this.app, "CliOper", "", "", "0X8004C59", "0X8004C59", 0, 0, "", "", "", "");
        }
        if ((this.app.e(true)) && (paramBoolean) && (this.jdField_a_of_type_ComTencentWidgetSwitch != null)) {
          this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
      }
      else if (paramCompoundButton == this.jdField_a_of_type_ComTencentWidgetSwitch)
      {
        if (AppSetting.c) {
          this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131716670));
        }
        localObject = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("qzone_permission_uin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qzone_permission_operateType", 1);
        ((Intent)localObject).putExtra("qzone_permission_value", paramBoolean);
        bmgt localbmgt = new bmgt(0);
        localbmgt.d = "QQ空间";
        localbmgt.b = QzonePluginProxyActivity.a();
        localbmgt.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        localbmgt.e = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        localbmgt.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
        bmgk.b(this.app.getApp(), localbmgt);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      setResult(-1);
      finish();
      overridePendingTransition(2130771990, 2130772304);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_c_of_type_Int);
      ((Intent)localObject).putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
      startActivityForResult((Intent)localObject, 1001);
      continue;
      localObject = bmtk.a();
      ((bmtk)localObject).jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
      ((bmtk)localObject).b = this.app.getCurrentNickname();
      bmtd.a(this, (bmtk)localObject, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), -1);
      continue;
      if (!bhnv.d(this))
      {
        QQToast.a(this.app.getApp(), 1, getString(2131694008), 0).b(getTitleBarHeight());
      }
      else
      {
        a(2131717902, 1000L, true);
        if (this.jdField_a_of_type_Int == 0)
        {
          localObject = getIntent();
          int k = ((Intent)localObject).getIntExtra("sub_source_id", 0);
          int j = ((Intent)localObject).getIntExtra("friend_setting", 0);
          int i = j;
          if (j == 3) {
            i = 100;
          }
          boolean bool = ((Intent)localObject).getBooleanExtra("contact_bothway", false);
          String str = ((Intent)localObject).getStringExtra("src_name");
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_JavaLangString, ((Intent)localObject).getStringExtra("extra"), i, (byte)this.jdField_c_of_type_Int, ((Intent)localObject).getStringExtra("msg"), this.jdField_b_of_type_Int, k, true, ((Intent)localObject).getByteArrayExtra("sig"), bool, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), str, ((Intent)localObject).getByteExtra("show_my_card", (byte)0), "", ((Intent)localObject).getBundleExtra("flc_extra_param"));
          if (!a(i, this.jdField_b_of_type_Int, bool)) {
            ((anyw)this.app.getManager(51)).a(this.jdField_a_of_type_JavaLangString, true);
          }
        }
        else if (this.jdField_a_of_type_Int == 1)
        {
          a(2131717902, 1000L, true);
          this.jdField_d_of_type_Int = 0;
          localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
          if (((String)localObject).length() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_JavaLangString, (String)localObject, false);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_a_of_type_JavaLangString, (byte)this.jdField_c_of_type_Int, (byte)0);
          }
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
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity
 * JD-Core Version:    0.7.0.1
 */