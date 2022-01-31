package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.smallscreen.PstnSmallScreenService;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnHandler;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kak;
import kal;
import kam;
import kan;
import kao;
import kap;
import kaq;
import kar;
import kas;
import kax;
import mqq.os.MqqHandler;

public class PSTNC2CActivity
  extends BaseActivity
{
  public static String b;
  public static String c;
  public BroadcastReceiver a;
  protected Handler.Callback a;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener = new kax(this);
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public PstnSessionInfo a;
  public PSTNNotification a;
  public QQAppInterface a;
  PstnObserver jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = new kas(this);
  public Runnable a;
  public final String a;
  public MqqHandler a;
  public Button b;
  TextView b;
  public TextView c;
  
  public PSTNC2CActivity()
  {
    this.jdField_a_of_type_JavaLangString = "PSTNC2CActivity";
    this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification = null;
    this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new kak(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_JavaLangRunnable = new kal(this);
  }
  
  private void a(Button paramButton, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramButton == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PSTNC2CActivity", 2, "changButtonStyle button is null");
      }
      return;
    }
    Drawable localDrawable = getResources().getDrawable(paramInt1);
    TintStateDrawable localTintStateDrawable = TintStateDrawable.a(getResources(), paramInt1, paramInt2);
    localTintStateDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localTintStateDrawable, null, null);
    paramButton.setTextColor(getResources().getColorStateList(paramInt3));
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int != -1;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365831));
    }
    LayoutInflater.from(this).inflate(2130969337, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365380));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365381));
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365400));
    if ((i == -1) || (i == 0))
    {
      a(this.jdField_a_of_type_AndroidWidgetButton, 2130840151, 2131493519, 2131493519);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365396));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365384));
      if (i != 2) {
        break label273;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131429562);
      a(this.jdField_b_of_type_AndroidWidgetButton, false, 2130840140);
      this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() != 1))
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366272);
        if (localRelativeLayout != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
          localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131559743);
          localRelativeLayout.setLayoutParams(localLayoutParams);
        }
      }
      return;
      a(this.jdField_a_of_type_AndroidWidgetButton, false, 2130840151);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      break;
      label273:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131429555);
      a(this.jdField_b_of_type_AndroidWidgetButton, 2130840140, 2131493519, 2131493519);
      this.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
    }
  }
  
  private void c()
  {
    Object localObject = (TelephonyManager)getSystemService("phone");
    try
    {
      Method localMethod = TelephonyManager.class.getDeclaredMethod("getITelephony", (Class[])null);
      localMethod.setAccessible(true);
      localObject = localMethod.invoke(localObject, (Object[])null);
      localMethod = localObject.getClass().getDeclaredMethod("endCall", (Class[])null);
      localMethod.setAccessible(true);
      localMethod.invoke(localObject, (Object[])null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      finish();
    }
  }
  
  private void d()
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PSTNC2CActivity", 2, "PstnSession is null. Getting data from AVCenter");
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().d;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, (String)localObject2, (byte)2, false, (byte)1, 0);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification != null)
      {
        if (i != 0) {
          break label175;
        }
        this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification.a((String)localObject1, (Bitmap)localObject2, null, 0, null);
      }
    }
    for (;;)
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PstnSmallScreenService.class);
      ((Intent)localObject1).putExtra("pstn_session_info", this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().stopService((Intent)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().startService((Intent)localObject1);
      return;
      localObject2 = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString;
      localObject1 = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.d;
      break;
      label175:
      if (i == 2) {
        this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification.a((String)localObject1, (Bitmap)localObject2, null, 1, null);
      }
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PSTNC2CActivity", 2, "onClick view.getId = " + paramView.getId());
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131365393: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int = -1;
      c();
      finish();
      return;
    case 2131365400: 
      QLog.d("PSTNC2CActivity", 1, "avideo onClick QavPanel.VIEW_ENUM.HIDE");
      d();
      finish();
      return;
    }
    if (PstnUtils.a(this.app, 2))
    {
      localObject2 = new ResultRecord();
      if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int == 56938)
      {
        ((ResultRecord)localObject2).jdField_a_of_type_Int = 5;
        ((ResultRecord)localObject2).jdField_a_of_type_JavaLangString = ("pstn" + this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        ((ResultRecord)localObject2).d = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString;
        ((ResultRecord)localObject2).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.d;
        ((ResultRecord)localObject2).jdField_c_of_type_JavaLangString = "-1";
        paramView = new ArrayList();
        paramView.add(localObject2);
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(((ResultRecord)localObject2).jdField_a_of_type_JavaLangString);
        localObject2 = new Intent(this, PhoneContactSelectActivity.class);
        ((Intent)localObject2).putExtra("param_type", 3000);
        ((Intent)localObject2).putExtra("param_subtype", 0);
        ((Intent)localObject2).putExtra("param_ui_flag", 0);
        ((Intent)localObject2).putExtra("param_from", 1005);
        ((Intent)localObject2).putExtra("param_title", getString(2131438372));
        ((Intent)localObject2).putParcelableArrayListExtra("param_uin_create_list", paramView);
        ((Intent)localObject2).putExtra("param_uins_selected_default", (Serializable)localObject1);
        ((Intent)localObject2).putExtra("param_entrance", 20);
        ((Intent)localObject2).putExtra("param_ip_pstn_enter_type", 1);
        ((Intent)localObject2).putExtra("param_max", 99);
        ((Intent)localObject2).putExtra("param_show_none_friends_in_contact", true);
        ((Intent)localObject2).putExtra("param_exit_animation", 1);
        ((Intent)localObject2).putExtra("param_back_button_side", 0);
        ((Intent)localObject2).putExtra("NEED_CLOSE_WHEN_PSTN_CLOSE", true);
        ((Intent)localObject2).setFlags(603979776);
        startActivityForResult((Intent)localObject2, 113);
        return;
        if ((this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int == 2016))
        {
          ((ResultRecord)localObject2).jdField_a_of_type_Int = 5;
          if ((this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString.startsWith("+")))
          {
            ((ResultRecord)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString;
            ((ResultRecord)localObject2).jdField_a_of_type_Int = 4;
          }
          else
          {
            ((ResultRecord)localObject2).jdField_a_of_type_JavaLangString = ("pstn" + this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString);
            ((ResultRecord)localObject2).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int;
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int == 1006)
          {
            if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString.startsWith("+")) {}
            for (((ResultRecord)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString;; ((ResultRecord)localObject2).jdField_a_of_type_JavaLangString = ("pstn" + this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString))
            {
              ((ResultRecord)localObject2).jdField_a_of_type_Int = 4;
              break;
            }
          }
          ((ResultRecord)localObject2).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int;
          ((ResultRecord)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
    }
    paramView = PstnUtils.b(this.app, 2);
    Object localObject1 = PstnUtils.c(this.app, 2);
    Object localObject2 = PstnUtils.d(this.app, 2);
    DialogUtil.a(this, 230, paramView, (String)localObject1, getString(2131428675), (String)localObject2, new kaq(this), new kar(this)).show();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PSTNC2CActivity", 2, "refreshUI");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365380));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365381));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366167));
    }
    int i;
    if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PSTNC2CActivity", 2, "PstnSession is null. Getting data from AVCenter");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().d;
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int;
    }
    for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      switch (i)
      {
      default: 
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840204);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.c((String)localObject2));
        return;
        localObject1 = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString;
        localObject2 = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.d;
        i = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int;
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject1, (byte)3, true);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
    return;
    if ((localObject1 != null) && (((String)localObject1).startsWith("+"))) {}
    for (localObject1 = FaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, (byte)3);; localObject1 = FaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (byte)3))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      return;
    }
    Object localObject2 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if ((localObject2 != null) && (str != null)) {}
    for (localObject2 = ((PhoneContactManager)localObject2).c(str);; localObject2 = null)
    {
      if (localObject2 != null)
      {
        localObject1 = FaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (byte)3);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16, (String)localObject1, (byte)3, true, 16);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PSTNC2CActivity", 2, "parseExtraData()");
    }
    this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = ((PstnSessionInfo)paramIntent.getParcelableExtra("pstn_session_info"));
    if (paramIntent.getBooleanExtra("needStopService", false)) {
      PstnUtils.a(this);
    }
    a(this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo);
    this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification = PSTNNotification.a(this);
  }
  
  public void a(Button paramButton, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramButton, paramInt, 2131494073, 2131494074);
      return;
    }
    a(paramButton, paramInt, 2131494065, 2131494066);
  }
  
  protected void a(PstnSessionInfo paramPstnSessionInfo)
  {
    if ((paramPstnSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString = paramPstnSessionInfo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().d = paramPstnSessionInfo.d;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_JavaLangString = paramPstnSessionInfo.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_JavaLangString = paramPstnSessionInfo.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int = paramPstnSessionInfo.jdField_a_of_type_Int;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    setContentView(2130969336);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    if (QLog.isColorLevel()) {
      QLog.d("PSTNC2CActivity", 2, "onCreate");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppInterface());
    }
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)getSystemService("phone"));
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 32);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      super.getWindow().addFlags(67108864);
    }
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(getWindow(), true);
    }
    ThreadManager.post(new kam(this), 5, null, false);
    b();
    a(getIntent());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject4 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    Object localObject1 = ((PstnManager)localObject4).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Object localObject2;
    Object localObject3;
    String str2;
    String str1;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int == -1) && (((PstnCardInfo)localObject1).pstn_c2c_call_time == 0) && (((PstnManager)localObject4).b() == 1) && (((PstnCardInfo)localObject1).pstn_c2c_try_status == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g))
    {
      localObject1 = getString(2131438422);
      localObject2 = getString(2131438423);
      localObject3 = getString(2131438424);
      str2 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_title");
      str1 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_content");
      localObject4 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_confirm_text");
      if (!TextUtils.isEmpty(str2)) {
        break label346;
      }
      if (!TextUtils.isEmpty(str1)) {
        break label352;
      }
      label159:
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        break label358;
      }
    }
    for (;;)
    {
      localObject4 = new Intent(this, SysCallTransparentActivity.class);
      ((Intent)localObject4).putExtra("pstn_dialog_type", 2);
      ((Intent)localObject4).putExtra("pstn_guide_title", (String)localObject1);
      ((Intent)localObject4).putExtra("pstn_guide_content", (String)localObject2);
      ((Intent)localObject4).putExtra("pstn_guide_confirm", (String)localObject3);
      startActivity((Intent)localObject4);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PSTNC2CActivity", 2, "onDestroy");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = null;
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.jdField_b_of_type_AndroidWidgetButton = null;
      this.jdField_a_of_type_AndroidWidgetButton = null;
      this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification = null;
      jdField_c_of_type_JavaLangString = null;
      jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
      label346:
      localObject1 = str2;
      break;
      label352:
      localObject2 = str1;
      break label159;
      label358:
      localObject3 = localObject4;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("PSTNC2CActivity", 2, "onResume, mPstnStatus=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int == -1)
    {
      ((PstnHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(82)).a(this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString, 5);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(28, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification.d();
      }
      a();
      return;
      PstnUtils.a(this);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 113) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (PstnUtils.a(this.app, 2))
      {
        str = paramIntent.getStringExtra("roomId");
        paramIntent = paramIntent.getStringArrayListExtra("qqPhoneUserList");
        localObject = new kan(this);
        ChatActivityUtils.a(this.app, this, 3000, str, true, false, true, (ChatActivityUtils.StartVideoListener)localObject, paramIntent, 2, 9);
        ReportController.b(this.app, "CliOper", "", "", "0X8006407", "0X8006407", 4, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    paramIntent = PstnUtils.b(this.app, 2);
    String str = PstnUtils.c(this.app, 2);
    Object localObject = PstnUtils.d(this.app, 2);
    DialogUtil.a(this, 230, paramIntent, str, getString(2131428675), (String)localObject, new kao(this), new kap(this)).show();
  }
  
  protected boolean onBackEvent()
  {
    d();
    finish();
    return super.onBackEvent();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.PSTNC2CActivity
 * JD-Core Version:    0.7.0.1
 */