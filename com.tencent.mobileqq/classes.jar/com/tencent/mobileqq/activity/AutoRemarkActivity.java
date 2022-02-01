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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
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
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new AutoRemarkActivity.5(this);
  EditText jdField_a_of_type_AndroidWidgetEditText = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private AutoRemarkActivity.InternalFriendListObserver jdField_a_of_type_ComTencentMobileqqActivityAutoRemarkActivity$InternalFriendListObserver = new AutoRemarkActivity.InternalFriendListObserver(this, null);
  FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new AutoRemarkActivity.3(this);
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
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 0) {
      localObject1 = getString(2131694196);
    } else {
      localObject1 = HardCodeUtil.a(2131701075);
    }
    setTitle((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376728);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376688);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366329));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379709));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.jdField_c_of_type_Int));
    Object localObject1 = this.jdField_b_of_type_AndroidViewView;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701071));
    ((StringBuilder)localObject2).append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.jdField_c_of_type_Int));
    ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    if (Utils.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(this.jdField_b_of_type_Int))
    {
      localObject2 = getIntent().getStringExtra("nick_name");
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initUI remark = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(", source id=");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
        QLog.d("AutoRemarkActivity", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle;
      if ((localObject1 != null) && (this.jdField_a_of_type_Boolean)) {
        localObject1 = ((Bundle)localObject1).getString("base_nick");
      } else {
        localObject1 = "";
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
    }
    if ((!EAddFriendSourceID.a(this.jdField_b_of_type_Int)) && (this.jdField_b_of_type_Int != 3016)) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if (paramInt == 0)
    {
      this.jdField_c_of_type_AndroidViewView = findViewById(2131375610);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      findViewById(2131375612).setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131375611));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      setRightHighlightButton(2131718755, this);
      enableRightHighlight(true);
      setLeftViewName(getIntent());
    }
    else
    {
      setRightHighlightButton(2131692486, this);
      enableRightHighlight(true);
      setLeftButton(2131690728, this);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_d_of_type_AndroidViewView = findViewById(2131377294);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (TextView)findViewById(2131375612);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(2131718770);
        ((TextView)localObject1).setContentDescription(getString(2131718770));
        this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131377319));
        if (AppSetting.d)
        {
          this.jdField_d_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131701074));
          this.jdField_d_of_type_AndroidViewView.setFocusable(true);
        }
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        this.leftView.setVisibility(8);
      }
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376655));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372959));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371877));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380416));
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(0.0F, getResources());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("base_uin");
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("base_nick");
      this.jdField_a_of_type_AndroidOsBundle.getInt("verfy_type");
      Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("verfy_msg");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(15.0F, getResources());
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      else
      {
        TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131689702));
        localStringBuilder.append(": ");
        localStringBuilder.append((String)localObject3);
        localTextView.setText(localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject1));
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(10.0F, getResources());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363786));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new AutoRemarkActivity.1(this));
    if (AppSetting.d)
    {
      localObject1 = this.leftView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701070));
      ((StringBuilder)localObject2).append(this.leftView.getText().toString());
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701073));
      ((TextView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getResources().getString(2131693375));
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(null);
      if (paramInt == 0)
      {
        this.jdField_c_of_type_AndroidViewView.setFocusable(true);
        this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717421));
        findViewById(2131375612).setFocusable(true);
      }
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAutoRemarkActivity, ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AutoRemarkActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(paramActivity, AutoRemarkActivity.class);
    ((Intent)localObject).putExtra("param_mode", 1);
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("k_msg_key", paramLong);
    if (paramBundle != null) {
      ((Intent)localObject).putExtras(paramBundle);
    }
    paramActivity.startActivityForResult((Intent)localObject, paramInt);
    paramActivity.overridePendingTransition(2130772342, 2130772004);
  }
  
  private void a(String paramString)
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label33:
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 0, 2131694583, null, new AutoRemarkActivity.2(this));
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label33;
    }
  }
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new AutoRemarkActivity.4(this));
  }
  
  void a()
  {
    Object localObject2 = getIntent().getStringExtra("param_return_addr");
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("goBack | retAddr = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("AutoRemarkActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (localObject2 != null) {
      try
      {
        localObject1 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
        localObject2 = Class.forName((String)localObject2);
        Intent localIntent2 = new Intent();
        localIntent2.setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject2).getName()));
        if ((!localObject2.equals(localObject1)) && (!localObject2.equals(QidianProfileCardActivity.class)))
        {
          if (localObject2.equals(QQNearbyManager.b()))
          {
            localIntent2.putExtra("AllInOne", new AllInOne(this.jdField_a_of_type_JavaLangString, 41));
            localIntent2.putExtra("param_mode", 3);
          }
        }
        else {
          ProfileActivity.a(this, this.jdField_a_of_type_JavaLangString, localIntent2);
        }
        localIntent2.setFlags(67108864);
        localIntent2.putExtra("key_back_from_add_friend", true);
        if (localObject2.equals(QQNearbyManager.b()))
        {
          RouteUtils.a(BaseApplicationImpl.getContext(), localIntent2, "/nearby/people/profile");
          return;
        }
        startActivity(localIntent2);
        return;
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
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("has_operation", true);
      localIntent1.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      setResult(-1, localIntent1);
    }
    else
    {
      setResult(-1);
    }
    finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).countByByte(paramEditable) > 32)
    {
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getRemark(paramEditable);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (i >= paramEditable.length()) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.d)
    {
      paramEditable = this.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131693375));
      localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      paramEditable.setContentDescription(localStringBuilder.toString());
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    if (paramInt1 != 1001) {
      return;
    }
    paramInt1 = paramIntent.getByteExtra("result", (byte)0);
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, paramInt1));
    if (AppSetting.d)
    {
      paramIntent = this.jdField_b_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131701072));
      localStringBuilder.append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, paramInt1));
      paramIntent.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558650);
    setContentBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("param_mode", 0);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("source_id", 3999);
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromWzry", false);
    a(this.jdField_b_of_type_Int);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAutoRemarkActivity$InternalFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    if ((paramBundle == null) || (this.jdField_a_of_type_Int == 1))
    {
      if ((NetworkUtil.isNetSupport(this)) && (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldReqAutoInfo(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString))) {
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAutoInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, getIntent().getIntExtra("sub_source_id", 0));
      }
      getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    catch (Throwable localThrowable)
    {
      label36:
      break label36;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    } else {
      getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAutoRemarkActivity$InternalFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
  }
  
  protected boolean onBackEvent()
  {
    setResult(-1);
    finish();
    overridePendingTransition(2130772004, 2130772344);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this.app.getApp(), 1, getString(2131694475), 0).b(getTitleBarHeight());
      paramCompoundButton.setOnCheckedChangeListener(null);
      paramCompoundButton.setChecked(paramBoolean ^ true);
      paramCompoundButton.setOnCheckedChangeListener(this);
    }
    else
    {
      Object localObject;
      if (paramCompoundButton == this.jdField_b_of_type_ComTencentWidgetSwitch)
      {
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.gatherContacts((short)1, (List)localObject, paramBoolean);
        if (this.jdField_b_of_type_ComTencentWidgetSwitch.isChecked()) {
          ReportController.b(this.app, "CliOper", "", "", "0X8004C59", "0X8004C59", 0, 0, "", "", "", "");
        }
        if ((this.app.getNotAllowedSeeMyDongtai(true)) && (paramBoolean))
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
          if (localObject != null) {
            ((Switch)localObject).setChecked(true);
          }
        }
      }
      else if (paramCompoundButton == this.jdField_a_of_type_ComTencentWidgetSwitch)
      {
        if (AppSetting.d) {
          this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717421));
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
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131369233)
    {
      if (i != 2131375610)
      {
        if (i != 2131376688)
        {
          setResult(-1);
          finish();
          overridePendingTransition(2130772004, 2130772344);
        }
        else
        {
          localObject = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_c_of_type_Int);
          ((Intent)localObject).putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
          startActivityForResult((Intent)localObject, 1001);
        }
      }
      else
      {
        localObject = QZoneHelper.UserInfo.getInstance();
        ((QZoneHelper.UserInfo)localObject).qzone_uin = this.app.getCurrentAccountUin();
        ((QZoneHelper.UserInfo)localObject).nickname = this.app.getCurrentNickname();
        QZoneHelper.forwardToSinglePermissionSetting(this, (QZoneHelper.UserInfo)localObject, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), -1);
      }
    }
    else if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this.app.getApp(), 1, getString(2131694475), 0).b(getTitleBarHeight());
    }
    else
    {
      showProgressDialog(2131718766, 1000L, true);
      i = this.jdField_a_of_type_Int;
      if (i == 0)
      {
        localObject = getIntent();
        int k = ((Intent)localObject).getIntExtra("sub_source_id", 0);
        int j = ((Intent)localObject).getIntExtra("friend_setting", 0);
        i = j;
        if (j == 3) {
          i = 100;
        }
        boolean bool = ((Intent)localObject).getBooleanExtra("contact_bothway", false);
        String str = ((Intent)localObject).getStringExtra("src_name");
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriendWithMyCard(this.jdField_a_of_type_JavaLangString, ((Intent)localObject).getStringExtra("extra"), i, (byte)this.jdField_c_of_type_Int, ((Intent)localObject).getStringExtra("msg"), this.jdField_b_of_type_Int, k, true, ((Intent)localObject).getByteArrayExtra("sig"), bool, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), str, ((Intent)localObject).getByteExtra("show_my_card", (byte)0), "", ((Intent)localObject).getBundleExtra("flc_extra_param"), false);
        if (!((IAddFriendApi)QRoute.api(IAddFriendApi.class)).couldAddFriendSuccessDirectly(i, this.jdField_b_of_type_Int, bool)) {
          ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_JavaLangString, true);
        }
      }
      else if (i == 1)
      {
        showProgressDialog(2131718766, 1000L, true);
        this.jdField_d_of_type_Int = 0;
        localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
        if (((String)localObject).length() != 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setFriendComment(this.jdField_a_of_type_JavaLangString, (String)localObject, false);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.moveFriendToGroup(this.jdField_a_of_type_JavaLangString, (byte)this.jdField_c_of_type_Int, (byte)0);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity
 * JD-Core Version:    0.7.0.1
 */