package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import friendlist.EAddFriendSourceID;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;
import mqq.os.MqqHandler;
import rte;
import rtf;
import rtg;
import rth;
import rti;

public class AutoRemarkActivity
  extends DialogBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public int a;
  public Dialog a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new rth(this);
  public EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public FriendListHandler a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  public String a;
  private rti jdField_a_of_type_Rti = new rti(this, null);
  public boolean a;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  String jdField_b_of_type_JavaLangString;
  public int c;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  public int e;
  
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
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramInt + "");
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
  
  private void a(int paramInt)
  {
    Object localObject1;
    label154:
    String str;
    label224:
    Object localObject2;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject1 = getString(2131435201);
      setTitle((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131362913);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131362915);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131362914));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362916));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.app, this.jdField_c_of_type_Int));
      this.jdField_b_of_type_AndroidViewView.setContentDescription("分组：" + a(this.app, this.jdField_c_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      if (!Utils.b(this.jdField_a_of_type_JavaLangString)) {
        break label752;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      str = "";
      if (!a(this.jdField_b_of_type_Int)) {
        break label763;
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
        break label795;
      }
      paramInt = 1;
      label272:
      if (paramInt == 0)
      {
        this.jdField_c_of_type_AndroidViewView = findViewById(2131362917);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        findViewById(2131363385).setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131362918));
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      if (this.jdField_a_of_type_Int != 0) {
        break label800;
      }
      setRightHighlightButton(2131434772, this);
      enableRightHighlight(true);
      setLeftViewName(getIntent());
      label352:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363381));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362898));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362899));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363382));
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label980;
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
        break label939;
      }
      localObject2 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(15.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      label543:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 1, (String)localObject1));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363470));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new rte(this));
      if (AppSetting.b)
      {
        this.leftView.setContentDescription("返回" + this.leftView.getText().toString() + "界面");
        this.jdField_a_of_type_AndroidViewView.setFocusable(true);
        this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131433507) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(null);
        if (paramInt == 0)
        {
          this.jdField_c_of_type_AndroidViewView.setFocusable(true);
          this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131435197));
          findViewById(2131363385).setFocusable(true);
        }
      }
      return;
      localObject1 = "好友设置";
      break;
      label752:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break label154;
      label763:
      localObject1 = str;
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label224;
      }
      localObject1 = str;
      if (!this.jdField_a_of_type_Boolean) {
        break label224;
      }
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("base_nick");
      break label224;
      label795:
      paramInt = 0;
      break label272;
      label800:
      setRightHighlightButton(2131434550, this);
      enableRightHighlight(true);
      setLeftButton(2131433029, this);
      if (this.jdField_a_of_type_Int != 1) {
        break label352;
      }
      this.jdField_d_of_type_AndroidViewView = findViewById(2131363383);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      localObject1 = (TextView)findViewById(2131363385);
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(2131437781);
      ((TextView)localObject1).setContentDescription(getString(2131437781));
      this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131363384));
      if (AppSetting.b)
      {
        this.jdField_d_of_type_AndroidViewView.setContentDescription("收起到不常联系好友 ");
        this.jdField_d_of_type_AndroidViewView.setFocusable(true);
      }
      this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.leftView.setVisibility(8);
      break label352;
      label939:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131436540) + ": " + (String)localObject2);
      break label543;
      label980:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(10.0F, getResources());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
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
    paramActivity.overridePendingTransition(2131034380, 2131034131);
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label34:
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 0, 2131433030, null, new rtf(this));
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
  
  public static boolean a(int paramInt)
  {
    return (EAddFriendSourceID.a(paramInt)) || (ProfileActivity.e(paramInt)) || (paramInt == 3016) || (paramInt == 3003) || (paramInt == 3093);
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
    return (!EAddFriendSourceID.a(paramInt)) && (paramInt != 3016) && (!TextUtils.isEmpty(paramString)) && (paramInt != 3093) && (!paramString.equals(String.valueOf(0L)));
  }
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new rtg(this));
  }
  
  public void a()
  {
    Object localObject1 = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "goBack | retAddr = " + (String)localObject1);
    }
    if (localObject1 != null)
    {
      try
      {
        Object localObject2 = Class.forName((String)localObject1);
        localObject1 = new Intent();
        ((Intent)localObject1).setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject2).getName()));
        if ((localObject2.equals(FriendProfileCardActivity.class)) || (localObject2.equals(QidianProfileCardActivity.class)))
        {
          localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_Int);
          if ((this.jdField_d_of_type_Int == 47) || (this.jdField_d_of_type_Int == 46))
          {
            ((ProfileActivity.AllInOne)localObject2).e = this.jdField_b_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AutoRemarkActivity  goBack  %s", new Object[] { this.jdField_b_of_type_JavaLangString }));
            }
          }
          ((Intent)localObject1).putExtra("AllInOne", (Parcelable)localObject2);
        }
        for (;;)
        {
          ((Intent)localObject1).setFlags(67108864);
          ((Intent)localObject1).putExtra("key_back_from_add_friend", true);
          startActivity((Intent)localObject1);
          return;
          if (localObject2.equals(NearbyPeopleProfileActivity.class))
          {
            ((Intent)localObject1).putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 41));
            ((Intent)localObject1).putExtra("param_mode", 3);
          }
        }
        if (!getIntent().getBooleanExtra("from_newer_guide", false)) {
          break label334;
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
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", true);
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      return;
      label334:
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
    if (AppSetting.b) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131433507) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    } while (!AppSetting.b);
    this.jdField_b_of_type_AndroidViewView.setContentDescription("分组：" + a(this.app, paramInt1));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130968713);
    setContentBackgroundResource(2130838219);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("param_mode", 0);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("source_id", 3999);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("param_return_profilecard_pa", 19);
    if ((this.jdField_d_of_type_Int == 47) || (this.jdField_d_of_type_Int == 46))
    {
      this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("param_return_profilecard_discuss_uin");
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AutoRemarkActivity  %s", new Object[] { this.jdField_b_of_type_JavaLangString }));
      }
    }
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromWzry", false);
    a(this.jdField_b_of_type_Int);
    this.app.addObserver(this.jdField_a_of_type_Rti);
    if ((paramBundle == null) || (this.jdField_a_of_type_Int == 1))
    {
      if ((NetworkUtil.d(this)) && (a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString))) {
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
        this.app.removeObserver(this.jdField_a_of_type_Rti);
        return;
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this.app.getApp(), 1, getString(2131434629), 0).b(getTitleBarHeight());
      paramCompoundButton.setOnCheckedChangeListener(null);
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      paramCompoundButton.setOnCheckedChangeListener(this);
    }
    do
    {
      do
      {
        return;
        if (paramCompoundButton != this.jdField_b_of_type_ComTencentWidgetSwitch) {
          break;
        }
        paramCompoundButton = new ArrayList(1);
        paramCompoundButton.add(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((short)1, paramCompoundButton, paramBoolean);
        if (this.jdField_b_of_type_ComTencentWidgetSwitch.isChecked()) {
          ReportController.b(this.app, "CliOper", "", "", "0X8004C59", "0X8004C59", 0, 0, "", "", "", "");
        }
      } while ((!this.app.d(true)) || (!paramBoolean) || (this.jdField_a_of_type_ComTencentWidgetSwitch == null));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      return;
    } while (paramCompoundButton != this.jdField_a_of_type_ComTencentWidgetSwitch);
    if (AppSetting.b) {
      this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131435197));
    }
    paramCompoundButton = new Intent("com.tencent.qzone.action.OperateQZonePermission");
    paramCompoundButton.putExtra("qzone_permission_uin", this.jdField_a_of_type_JavaLangString);
    paramCompoundButton.putExtra("qzone_permission_operateType", 1);
    paramCompoundButton.putExtra("qzone_permission_value", paramBoolean);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "QQ空间";
    localPluginParams.jdField_b_of_type_JavaLangString = QzonePluginProxyActivity.a();
    localPluginParams.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localPluginParams.e = "com.qzone.permissionsetting.business.QZonePermissionReciver";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramCompoundButton;
    IPluginManager.a(this.app.getApp(), localPluginParams);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      setResult(-1);
      finish();
      overridePendingTransition(2131034131, 2131034382);
    }
    do
    {
      int i;
      boolean bool;
      do
      {
        return;
        paramView = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_c_of_type_Int);
        paramView.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
        startActivityForResult(paramView, 1001);
        return;
        paramView = QZoneHelper.UserInfo.a();
        paramView.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        paramView.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
        QZoneHelper.a(this, paramView, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), -1);
        return;
        if (!NetworkUtil.d(this))
        {
          QQToast.a(this.app.getApp(), 1, getString(2131434629), 0).b(getTitleBarHeight());
          return;
        }
        a(2131434469, 1000L, true);
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
        paramView = getIntent();
        int k = paramView.getIntExtra("sub_source_id", 0);
        int j = paramView.getIntExtra("friend_setting", 0);
        i = j;
        if (j == 3) {
          i = 100;
        }
        bool = paramView.getBooleanExtra("contact_bothway", false);
        String str = paramView.getStringExtra("src_name");
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_JavaLangString, paramView.getStringExtra("extra"), i, (byte)this.jdField_c_of_type_Int, paramView.getStringExtra("msg"), this.jdField_b_of_type_Int, k, true, paramView.getByteArrayExtra("sig"), bool, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), str, paramView.getByteExtra("show_my_card", (byte)0));
      } while (a(i, this.jdField_b_of_type_Int, bool));
      ((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_JavaLangString, true);
      return;
    } while (this.jdField_a_of_type_Int != 1);
    a(2131434469, 1000L, true);
    this.e = 0;
    paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (paramView.length() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_JavaLangString, paramView, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_a_of_type_JavaLangString, (byte)this.jdField_c_of_type_Int, (byte)0);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity
 * JD-Core Version:    0.7.0.1
 */