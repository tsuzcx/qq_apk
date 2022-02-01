package com.tencent.mobileqq.activity;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import friendlist.EAddFriendSourceID;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AutoRemarkActivity
  extends DialogBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int;
  Dialog jdField_a_of_type_AndroidAppDialog;
  Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView = null;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new AutoRemarkActivity.4(this);
  EditText jdField_a_of_type_AndroidWidgetEditText = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private AutoRemarkActivity.InternalFriendListObserver jdField_a_of_type_ComTencentMobileqqActivityAutoRemarkActivity$InternalFriendListObserver = new AutoRemarkActivity.InternalFriendListObserver(this, null);
  FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  
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
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramInt + "");
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
    paramActivity.overridePendingTransition(2130772314, 2130771992);
  }
  
  public static boolean a(int paramInt)
  {
    return (EAddFriendSourceID.a(paramInt)) || (paramInt == 3016) || (paramInt == 3003) || (paramInt == 3093);
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
    return (!EAddFriendSourceID.a(paramInt)) && (paramInt != 3016) && (paramInt != 3024) && (!TextUtils.isEmpty(paramString)) && (paramInt != 3093) && (!paramString.equals(String.valueOf(0L)));
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
      localObject1 = getString(2131694231);
      setTitle((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131377269);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131377228);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366449));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380395));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.app, this.jdField_c_of_type_Int));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131700928) + a(this.app, this.jdField_c_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      if (!Utils.b(this.jdField_a_of_type_JavaLangString)) {
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
      if ((!EAddFriendSourceID.a(this.jdField_b_of_type_Int)) && (this.jdField_b_of_type_Int != 3016)) {
        break label816;
      }
      paramInt = 1;
      label279:
      if (paramInt == 0)
      {
        this.jdField_c_of_type_AndroidViewView = findViewById(2131376097);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        findViewById(2131376099).setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131376098));
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      if (this.jdField_a_of_type_Int != 0) {
        break label821;
      }
      setRightHighlightButton(2131719039, this);
      enableRightHighlight(true);
      setLeftViewName(getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377193));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373379));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372288));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381159));
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label1005;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(0.0F, getResources());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("base_uin");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("base_nick");
      this.jdField_a_of_type_AndroidOsBundle.getInt("verfy_type");
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("verfy_msg");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label964;
      }
      localObject2 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(15.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      label554:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject1));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363858));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new AutoRemarkActivity.1(this));
      if (AppSetting.d)
      {
        this.leftView.setContentDescription(HardCodeUtil.a(2131700927) + this.leftView.getText().toString() + HardCodeUtil.a(2131700930));
        this.jdField_a_of_type_AndroidViewView.setFocusable(true);
        this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131693420) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(null);
        if (paramInt == 0)
        {
          this.jdField_c_of_type_AndroidViewView.setFocusable(true);
          this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717762));
          findViewById(2131376099).setFocusable(true);
        }
      }
      return;
      localObject1 = HardCodeUtil.a(2131700932);
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
      setRightHighlightButton(2131692534, this);
      enableRightHighlight(true);
      setLeftButton(2131690800, this);
      if (this.jdField_a_of_type_Int != 1) {
        break label363;
      }
      this.jdField_d_of_type_AndroidViewView = findViewById(2131377868);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      localObject1 = (TextView)findViewById(2131376099);
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(2131719054);
      ((TextView)localObject1).setContentDescription(getString(2131719054));
      this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131377893));
      if (AppSetting.d)
      {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131700931));
        this.jdField_d_of_type_AndroidViewView.setFocusable(true);
      }
      this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.leftView.setVisibility(8);
      break label363;
      label964:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131689670) + ": " + (String)localObject2);
      break label554;
      label1005:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(10.0F, getResources());
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
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 0, 2131694615, null, new AutoRemarkActivity.2(this));
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
  
  void a()
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
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131693420) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
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
    } while (!AppSetting.d);
    this.jdField_b_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131700929) + a(this.app, paramInt1));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558751);
    setContentBackgroundResource(2130838979);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("param_mode", 0);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("source_id", 3999);
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromWzry", false);
    b(this.jdField_b_of_type_Int);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAutoRemarkActivity$InternalFriendListObserver);
    if ((paramBundle == null) || (this.jdField_a_of_type_Int == 1))
    {
      if ((NetworkUtil.d(this)) && (a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getAutoInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, getIntent().getIntExtra("sub_source_id", 0));
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
        this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAutoRemarkActivity$InternalFriendListObserver);
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
    overridePendingTransition(2130771992, 2130772316);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this.app.getApp(), 1, getString(2131694510), 0).b(getTitleBarHeight());
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
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.gatherContacts((short)1, (List)localObject, paramBoolean);
        if (this.jdField_b_of_type_ComTencentWidgetSwitch.isChecked()) {
          ReportController.b(this.app, "CliOper", "", "", "0X8004C59", "0X8004C59", 0, 0, "", "", "", "");
        }
        if ((this.app.getNotAllowedSeeMyDongtai(true)) && (paramBoolean) && (this.jdField_a_of_type_ComTencentWidgetSwitch != null)) {
          this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
      }
      else if (paramCompoundButton == this.jdField_a_of_type_ComTencentWidgetSwitch)
      {
        if (AppSetting.d) {
          this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717762));
        }
        localObject = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("qzone_permission_uin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qzone_permission_operateType", 1);
        ((Intent)localObject).putExtra("qzone_permission_value", paramBoolean);
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.e = "QQ空间";
        localPluginParams.b = QzonePluginProxyActivity.getQZonePluginName();
        localPluginParams.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        localPluginParams.f = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        localPluginParams.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
        IPluginManager.b(this.app.getApp(), localPluginParams);
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
      overridePendingTransition(2130771992, 2130772316);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_c_of_type_Int);
      ((Intent)localObject).putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
      startActivityForResult((Intent)localObject, 1001);
      continue;
      localObject = QZoneHelper.UserInfo.getInstance();
      ((QZoneHelper.UserInfo)localObject).qzone_uin = this.app.getCurrentAccountUin();
      ((QZoneHelper.UserInfo)localObject).nickname = this.app.getCurrentNickname();
      QZoneHelper.forwardToSinglePermissionSetting(this, (QZoneHelper.UserInfo)localObject, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), -1);
      continue;
      if (!NetworkUtil.d(this))
      {
        QQToast.a(this.app.getApp(), 1, getString(2131694510), 0).b(getTitleBarHeight());
      }
      else
      {
        a(2131719050, 1000L, true);
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
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.addFriendWithMyCard(this.jdField_a_of_type_JavaLangString, ((Intent)localObject).getStringExtra("extra"), i, (byte)this.jdField_c_of_type_Int, ((Intent)localObject).getStringExtra("msg"), this.jdField_b_of_type_Int, k, true, ((Intent)localObject).getByteArrayExtra("sig"), bool, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), str, ((Intent)localObject).getByteExtra("show_my_card", (byte)0), "", ((Intent)localObject).getBundleExtra("flc_extra_param"), false);
          if (!a(i, this.jdField_b_of_type_Int, bool)) {
            ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_JavaLangString, true);
          }
        }
        else if (this.jdField_a_of_type_Int == 1)
        {
          a(2131719050, 1000L, true);
          this.jdField_d_of_type_Int = 0;
          localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
          if (((String)localObject).length() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setFriendComment(this.jdField_a_of_type_JavaLangString, (String)localObject, false);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.moveFriendToGroup(this.jdField_a_of_type_JavaLangString, (byte)this.jdField_c_of_type_Int, (byte)0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity
 * JD-Core Version:    0.7.0.1
 */