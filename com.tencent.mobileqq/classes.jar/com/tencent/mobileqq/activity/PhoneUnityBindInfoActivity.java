package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.PhoneUnityData;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class PhoneUnityBindInfoActivity
  extends DialogBaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public int a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new PhoneUnityBindInfoActivity.1(this);
  public Bundle a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private PhoneUnityManager.PhoneUnityData jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData = new PhoneUnityManager.PhoneUnityData();
  public PhoneUnityManager a;
  SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new PhoneUnityBindInfoActivity.2(this);
  public ContactBindObserver a;
  public QQCustomDialog a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  public ActionSheet a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public ContactBindObserver b;
  public QQCustomDialog b;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public boolean b;
  public ContactBindObserver c;
  private QQCustomDialog jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private boolean jdField_c_of_type_Boolean = false;
  private QQCustomDialog jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private boolean jdField_d_of_type_Boolean = false;
  private QQCustomDialog jdField_e_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private boolean jdField_e_of_type_Boolean = false;
  
  public PhoneUnityBindInfoActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
  }
  
  public static SpannableStringBuilder a(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramString.length(), 18);
    return localSpannableStringBuilder;
  }
  
  private String a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Button localButton = (Button)findViewById(2131364547);
      paramBundle = paramBundle.getString("phone");
      if (!TextUtils.isEmpty(paramBundle))
      {
        String str = getResources().getString(2131694790) + paramBundle;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_Int == 3)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          localButton.setText(2131694795);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_Boolean) {
            break label218;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
          label125:
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_b_of_type_Boolean)) {
            break label229;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        return paramBundle;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localButton.setText(2131694754);
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694764);
        localButton.setText(2131694743);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(true, false, 17);
        break;
        label218:
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        break label125;
        label229:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      }
    }
    return "";
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    this.jdField_c_of_type_Boolean = false;
    if (paramDevlockInfo == null)
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "onGetDevlockInfo, fail");
      return;
    }
    QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, success");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = paramDevlockInfo;
    DevlockPhoneStatus.a().a(paramDevlockInfo.TransferInfo);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((!paramBoolean) || (paramBundle == null))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      a(paramBundle);
      if (paramBundle.getInt("need_unify", 0) == 1) {}
      for (int i = 1; (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_Int == 3) && (i != 0); i = 0)
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800B313", "0X800B313", 0, 0, "", "", "", "");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.d)) {
          PhoneUnityManager.a(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.d, 1010);
        }
        o();
        finish();
        return;
      }
      if (paramBundle.getInt("check_result") == 1)
      {
        paramBundle = paramBundle.getString("mibao_set_url");
        if (!TextUtils.isEmpty(paramBundle)) {
          PhoneUnityManager.a(this, this.app, paramBundle, 1009);
        }
        for (;;)
        {
          o();
          finish();
          return;
          QLog.e("PhoneUnityBindInfoActivity", 4, "mb set url is null.");
        }
      }
      a(paramBundle);
      if (i != 0)
      {
        b(paramBundle);
        ReportController.b(this.app, "dc00898", "", "", "0X800B322", "0X800B322", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800B314", "0X800B314", 0, 0, "", "", "", "");
    } while (!((Boolean)SharedPreUtils.a(BaseApplicationImpl.getContext(), this.app.getAccount(), "phone_unity_banner_tips_need_show", Boolean.valueOf(false))).booleanValue());
    QQToast.a(this, 2, getResources().getString(2131694793), 0).a();
    o();
  }
  
  private void b(Bundle paramBundle)
  {
    String str = "";
    Object localObject1 = "";
    Object localObject3 = "";
    Object localObject2 = paramBundle.getString("phone");
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("phone_info");
    Object localObject4 = localObject2;
    Object localObject6 = localObject3;
    Object localObject5 = localObject1;
    Object localObject7 = str;
    if (arrayOfParcelable != null)
    {
      int i = 0;
      paramBundle = str;
      localObject4 = localObject2;
      localObject6 = localObject3;
      localObject5 = localObject1;
      localObject7 = paramBundle;
      if (i < arrayOfParcelable.length)
      {
        localObject4 = (Bundle)arrayOfParcelable[i];
        if (localObject4 == null)
        {
          localObject4 = localObject2;
          localObject5 = localObject3;
          localObject3 = paramBundle;
          localObject2 = localObject1;
          localObject1 = localObject5;
          paramBundle = (Bundle)localObject4;
        }
        for (;;)
        {
          i += 1;
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject2 = paramBundle;
          localObject3 = localObject1;
          localObject1 = localObject5;
          paramBundle = (Bundle)localObject4;
          break;
          switch (((Bundle)localObject4).getInt("phone_type", 0))
          {
          default: 
            localObject4 = localObject1;
            localObject5 = paramBundle;
            paramBundle = (Bundle)localObject2;
            localObject1 = localObject3;
            localObject2 = localObject4;
            localObject3 = localObject5;
            break;
          case 2: 
            localObject5 = ((Bundle)localObject4).getString("phone");
            localObject4 = localObject1;
            paramBundle = (Bundle)localObject2;
            localObject1 = localObject3;
            localObject2 = localObject4;
            localObject3 = localObject5;
            break;
          case 1: 
            localObject5 = ((Bundle)localObject4).getString("phone");
            localObject2 = localObject5;
            localObject3 = localObject1;
            localObject4 = paramBundle;
            paramBundle = (Bundle)localObject5;
            localObject1 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject4;
            break;
          case 3: 
            localObject5 = ((Bundle)localObject4).getString("phone");
            localObject4 = paramBundle;
            paramBundle = (Bundle)localObject2;
            localObject1 = localObject3;
            localObject2 = localObject5;
            localObject3 = localObject4;
          }
        }
      }
    }
    paramBundle = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (paramBundle != null) {
      paramBundle.dismiss();
    }
    this.jdField_a_of_type_Boolean = true;
    localObject2 = (ActionSheet)ActionSheetHelper.a(this, null);
    ((ActionSheet)localObject2).setSupportBottomRadius(true);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject2);
    paramBundle = LayoutInflater.from(this).inflate(2131559673, null);
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener(new PhoneUnityBindInfoActivity.5(this));
      localObject1 = (LinearLayout)paramBundle.findViewById(2131372929);
      if (localObject1 != null)
      {
        localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131372931);
        if ((localObject3 != null) && (!TextUtils.isEmpty((CharSequence)localObject7)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((TextView)localObject3).setText((CharSequence)localObject7);
        }
      }
      localObject1 = (LinearLayout)paramBundle.findViewById(2131372919);
      if (localObject1 != null)
      {
        localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131372921);
        if ((localObject3 != null) && (!TextUtils.isEmpty(localObject6)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((TextView)localObject3).setText(localObject6);
        }
      }
      localObject1 = (LinearLayout)paramBundle.findViewById(2131372952);
      if (localObject1 != null)
      {
        localObject3 = (TextView)paramBundle.findViewById(2131372960);
        if ((localObject3 != null) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((TextView)localObject3).setText((CharSequence)localObject5);
        }
      }
      paramBundle.setBackgroundResource(2130851147);
      ((ActionSheet)localObject2).addViewCustomeTitle(paramBundle);
    }
    ((ActionSheet)localObject2).addButton(a(String.format(super.getString(2131694746), new Object[] { localObject4 })), 9, "#03081A");
    ((ActionSheet)localObject2).addButton(a(getString(2131694745)), 9, "#03081A");
    ((ActionSheet)localObject2).addButton(a(getString(2131690800)), 9, "#03081A");
    ((ActionSheet)localObject2).setOnCancelListener(new PhoneUnityBindInfoActivity.6(this));
    ((ActionSheet)localObject2).setOnDismissListener(new PhoneUnityBindInfoActivity.7(this));
    ((ActionSheet)localObject2).setOnButtonClickListener(new PhoneUnityBindInfoActivity.8(this, (ActionSheet)localObject2));
    localObject3 = ((ActionSheet)localObject2).getActionContentView();
    localObject1 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    }
    paramBundle.addRule(12, 0);
    paramBundle.addRule(13, -1);
    paramBundle.setMargins(80, 0, 80, 0);
    ((RelativeLayout)localObject3).setLayoutParams(paramBundle);
    ((ActionSheet)localObject2).setCanceledOnTouchOutside(false);
    ((ActionSheet)localObject2).show();
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("PhoneUnityBindInfoActivity", 2, "mibaoChangeUrl is null.");
      return;
    }
    PhoneUnityManager.a(this, this.app, paramString, 1011);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, getString(2131694784), 0, new PhoneUnityBindInfoActivity.3(this));
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
  }
  
  private void n()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, in progress");
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, start");
    WeakReference localWeakReference = new WeakReference(this);
    EquipmentLockImpl.a().a(this.app, this.app.getCurrentAccountUin(), new PhoneUnityBindInfoActivity.4(this, localWeakReference));
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    sendBroadcast(localIntent);
  }
  
  private void p()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_d_of_type_Boolean = false;
      b();
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
      {
        QQToast.a(this, 1, getResources().getString(2131694781), 0).b(getTitleBarHeight());
        finish();
      }
    }
    else
    {
      return;
    }
    o();
    QQToast.a(this, 2, getResources().getString(2131694793), 0).b(getTitleBarHeight());
    a(1, null);
    ReportController.b(this.app, "dc00898", "", "", "0X800B324", "0X800B324", 0, 0, "", "", "", "");
  }
  
  private void q()
  {
    QLog.i("PhoneUnityBindInfoActivity", 1, "showUnityUnderReviewDialog");
    if (this.jdField_e_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setCancelable(true);
      localQQCustomDialog.setTitle(2131694785);
      localQQCustomDialog.adjustMessageTopBottomMargin(8.0F, 40.0F);
      localQQCustomDialog.setMessage(2131694789);
      localQQCustomDialog.setPositiveButton(2131694844, new PhoneUnityBindInfoActivity.13(this));
      this.jdField_e_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog;
    }
    if ((!this.jdField_e_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.jdField_e_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  private void r()
  {
    QLog.i("PhoneUnityBindInfoActivity", 1, "showUnityUnderReviewDialog");
    if (this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setCancelable(true);
      localQQCustomDialog.adjustMessageTopBottomMargin(8.0F, 40.0F);
      localQQCustomDialog.setMessage(2131694796);
      localQQCustomDialog.setPositiveButton(2131694844, new PhoneUnityBindInfoActivity.14(this));
      this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog;
    }
    if ((!this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing()))
    {
      this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      ReportController.b(this.app, "dc00898", "", "", "0X800B318", "0X800B318", 0, 0, "", "", "", "");
    }
  }
  
  private void s()
  {
    QLog.i("PhoneUnityBindInfoActivity", 1, "showBindContactPhoneDialog");
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    do
    {
      return;
      if (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
        localQQCustomDialog.setCancelable(true);
        localQQCustomDialog.adjustMessageTopBottomMargin(8.0F, 40.0F);
        localQQCustomDialog.setTitle(2131694752);
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("phone");
        localQQCustomDialog.setMessage(Html.fromHtml(String.format(getString(2131694750), new Object[] { "<font color=\"#FF8343\">" + str + "</font>" })));
        localQQCustomDialog.setPositiveButton(2131694751, new PhoneUnityBindInfoActivity.15(this));
        localQQCustomDialog.setNegativeButton(2131694749, new PhoneUnityBindInfoActivity.16(this));
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog;
      }
    } while ((this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) || (isFinishing()));
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    ReportController.b(this.app, "dc00898", "", "", "0X800B31C", "0X800B31C", 0, 0, "", "", "", "");
  }
  
  private void t()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int > -1))
    {
      this.jdField_a_of_type_Int -= 1;
      QLog.d("PhoneUnityBindInfoActivity", 1, "phone_unity_info, mUnBindedNum: " + this.jdField_a_of_type_Int);
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_c_of_type_Boolean = true;
    b();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    n();
    if (paramBundle == null)
    {
      a(false, null);
      paramBundle = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      if (paramBundle != null)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "refreshServerData, getPhoneUnityInfo");
        paramBundle.a(paramInt);
        l();
      }
      return;
    }
    QLog.i("PhoneUnityBindInfoActivity", 1, "init with prefetched bind phone data");
    a(true, paramBundle);
  }
  
  protected void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.a();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_c_of_type_JavaLangString = paramBundle.getString("mibao_change_url");
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_b_of_type_JavaLangString = paramBundle.getString("mibao_set_url");
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.d = paramBundle.getString("mibao_verify_url");
      paramBundle = paramBundle.getParcelableArray("phone_info");
      if (paramBundle != null)
      {
        int i = 0;
        if (i < paramBundle.length)
        {
          Bundle localBundle = (Bundle)paramBundle[i];
          if (localBundle == null) {}
          int j;
          for (;;)
          {
            i += 1;
            break;
            j = localBundle.getInt("phone_type");
            switch (j)
            {
            default: 
              break;
            case 1: 
              this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_JavaLangString = localBundle.getString("phone");
              this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_Int = localBundle.getInt("status");
              this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_AndroidUtilSparseArray.put(j, localBundle.getByteArray("vaskey"));
            }
          }
          Object localObject = localBundle.getString("phone");
          PhoneUnityManager.PhoneUnityData localPhoneUnityData = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData;
          if ((localBundle.getInt("status") == 1) && (!TextUtils.isEmpty((CharSequence)localObject))) {}
          for (boolean bool = true;; bool = false)
          {
            localPhoneUnityData.jdField_a_of_type_Boolean = bool;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_AndroidUtilSparseArray.put(j, localBundle.getByteArray("vaskey"));
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData;
          if (!TextUtils.isEmpty(localBundle.getString("phone")))
          {
            bool = true;
            label277:
            ((PhoneUnityManager.PhoneUnityData)localObject).jdField_c_of_type_Boolean = bool;
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData;
            if ((!this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_c_of_type_Boolean) || (localBundle.getInt("status") != 1)) {
              break label350;
            }
          }
          label350:
          for (bool = true;; bool = false)
          {
            ((PhoneUnityManager.PhoneUnityData)localObject).jdField_b_of_type_Boolean = bool;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_AndroidUtilSparseArray.put(j, localBundle.getByteArray("vaskey"));
            break;
            bool = false;
            break label277;
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  protected byte[] a(int paramInt)
  {
    return (byte[])this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void b()
  {
    if (!NetworkUtil.d(this)) {
      a(2131694510);
    }
    SecSvcHandler localSecSvcHandler;
    do
    {
      return;
      localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    } while (localSecSvcHandler == null);
    localSecSvcHandler.d();
  }
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void c()
  {
    if (!NetworkUtil.d(this)) {
      a(2131694510);
    }
    SecSvcHandler localSecSvcHandler;
    do
    {
      return;
      localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    } while (localSecSvcHandler == null);
    localSecSvcHandler.e();
  }
  
  public void d()
  {
    if (!NetworkUtil.d(this)) {
      a(2131694510);
    }
    SecSvcHandler localSecSvcHandler;
    do
    {
      return;
      localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    } while (localSecSvcHandler == null);
    if (QLog.isColorLevel()) {
      QLog.e("PhoneUnityBindInfoActivity", 2, "unbindPhoneNumLoginOnPhoneUnity contact.");
    }
    localSecSvcHandler.c();
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneUnityBindInfoActivity", 2, "doOnActivityResult requestCode = " + paramInt1 + " resultCode = " + paramInt2);
    }
    switch (paramInt1)
    {
    case 1010: 
    default: 
      return;
    case 1008: 
      if ((paramInt2 != 0) && (paramInt2 == -1))
      {
        a();
        return;
      }
      a(false);
      QQToast.a(this, 1, getResources().getString(2131694781), 0).b(getTitleBarHeight());
      return;
    }
    a(1, null);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getBundleExtra("kBindPhoneData");
    super.setContentView(2131561436);
    super.setTitle(getString(2131699149));
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager = ((PhoneUnityManager)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371207));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372949));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364547));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363666));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363668));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    paramBundle = super.findViewById(2131372918);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      paramBundle.setBackgroundColor(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager.jdField_a_of_type_Boolean = true;
      }
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
      a(1, this.jdField_a_of_type_AndroidOsBundle);
      if ("from_schema".equals(getIntent().getStringExtra("from"))) {
        ReportController.b(this.app, "dc00898", "", "", "0X800B6BF", "0X800B6BF", 0, 0, "", "", "", "");
      }
      return true;
      paramBundle.setBackgroundColor(-1);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    m();
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_c_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_c_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_e_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_e_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_e_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void e()
  {
    if (!NetworkUtil.d(this)) {
      a(2131694510);
    }
    do
    {
      SecSvcHandler localSecSvcHandler;
      do
      {
        return;
        localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      } while ((localSecSvcHandler == null) || (this.jdField_a_of_type_AndroidOsBundle == null));
      QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info_login, unbindPhoneNumLogin");
      byte[] arrayOfByte = a(2);
      if (arrayOfByte != null)
      {
        localSecSvcHandler.b(arrayOfByte);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PhoneUnityBindInfoActivity", 2, "unbindPhoneNumLogin contact vaskey is null.");
  }
  
  public void f()
  {
    if (!NetworkUtil.d(this)) {
      a(2131694510);
    }
    do
    {
      SecSvcHandler localSecSvcHandler;
      do
      {
        return;
        localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      } while ((localSecSvcHandler == null) || (this.jdField_a_of_type_AndroidOsBundle == null));
      QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info_login, bindPhoneNumLogin");
      byte[] arrayOfByte = a(2);
      if (arrayOfByte != null)
      {
        localSecSvcHandler.a(arrayOfByte);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PhoneUnityBindInfoActivity", 2, "bindPhoneNumLogin contact vaskey is null.");
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PhoneUnityBindInfoActivity", 2, "InfoBundle is null.");
      }
    }
    do
    {
      return;
      if (!NetworkUtil.d(this))
      {
        a(2131694510);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new PhoneUnityBindInfoActivity.9(this);
        this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      byte[] arrayOfByte = a(3);
      if (arrayOfByte != null)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unbindMobileEncrypt");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(arrayOfByte, true, false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PhoneUnityBindInfoActivity", 2, "unbindMobileEncrypt contact vaskey is null.");
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    do
    {
      return;
      if (!NetworkUtil.d(this))
      {
        a(2131694510);
        return;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new PhoneUnityBindInfoActivity.10(this);
        this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("country_code");
      byte[] arrayOfByte = a(3);
      if (arrayOfByte != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(str, arrayOfByte, 0, true, false);
        return;
      }
      a(false);
      QQToast.a(this, 1, getResources().getString(2131694781), 0).b(getTitleBarHeight());
    } while (!QLog.isColorLevel());
    QLog.e("PhoneUnityBindInfoActivity", 2, "sendBindMobileEncrypt contact vaskey is null.");
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    Intent localIntent;
    do
    {
      return;
      byte[] arrayOfByte = a(3);
      if (arrayOfByte == null)
      {
        QLog.e("PhoneUnityBindInfoActivity", 2, "gotoBindVerify contact phoneVasKey is null.");
        return;
      }
      a(false);
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("country_code");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("phone");
      localIntent = new Intent(this, BindVerifyActivity.class);
      localIntent.putExtra("kSrouce", 23);
      localIntent.putExtra("kBindType", 0);
      localIntent.putExtra("keyReqBindMode", 0);
      localIntent.putExtra("cmd_param_is_encrypt", true);
      localIntent.putExtra("cmd_param_encrypt_mobile", arrayOfByte);
      localIntent.putExtra("k_mask_number_forshow", str2);
      localIntent.putExtra("k_country_code", str1);
      localIntent.putExtra("k_is_block", getIntent().getBooleanExtra("k_is_block", false));
      localIntent.putExtra("key_is_from_qqhotspot", getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
      localIntent.putExtra("cmd_param_is_from_uni", true);
      localIntent.putExtra("key_is_from_qav_multi_call", getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
      localIntent.putExtra("cmd_param_is_from_change_bind", false);
      localIntent.addFlags(536870912);
      localIntent.addFlags(67108864);
    } while (isFinishing());
    startActivityForResult(localIntent, 1008);
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      String str = getString(2131694786);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, getString(2131694785), str, null, HardCodeUtil.a(2131701205), new PhoneUnityBindInfoActivity.11(this), null);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  protected void k()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, null, getString(2131694787), null, HardCodeUtil.a(2131701209), new PhoneUnityBindInfoActivity.12(this), null);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    ViewParent localViewParent = paramCompoundButton.getParent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_Int == 3)
    {
      r();
      if (localViewParent == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem)
      {
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
        a(bool1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (localViewParent == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem)
      {
        if (!paramBoolean) {}
        for (;;)
        {
          b(bool1);
          break;
          bool1 = false;
        }
        if (localViewParent == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem)
        {
          if (!NetworkUtil.d(this))
          {
            QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
            if (!paramBoolean) {}
            for (bool1 = bool3;; bool1 = false)
            {
              a(bool1);
              break;
            }
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_c_of_type_Boolean)
          {
            ReportController.b(this.app, "dc00898", "", "", "0X800B319", "0X800B319", 0, 0, "2", "", "", "");
            s();
          }
          else if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_b_of_type_Boolean)
          {
            b();
            ReportController.b(this.app, "dc00898", "", "", "0X800B319", "0X800B319", 0, 0, "1", "", "", "");
          }
          else
          {
            c();
          }
        }
        else if (localViewParent == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem)
        {
          if (!NetworkUtil.d(this))
          {
            QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
            if (!paramBoolean) {}
            for (bool1 = bool4;; bool1 = false)
            {
              b(bool1);
              break;
            }
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_Boolean)
          {
            f();
          }
          else
          {
            e();
            this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.d)))
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800B317", "0X800B317", 0, 0, "", "", "", "");
        PhoneUnityManager.a(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.d, 1010);
      }
      else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_c_of_type_JavaLangString))
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800B315", "0X800B315", 0, 0, "", "", "", "");
        this.jdField_b_of_type_Int = 1;
        b(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityManager$PhoneUnityData.jdField_c_of_type_JavaLangString);
      }
      else
      {
        QLog.e("PhoneUnityBindInfoActivity", 2, "change bind phone error.");
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity
 * JD-Core Version:    0.7.0.1
 */