package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
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
import com.tencent.mobileqq.utils.AudioUtil;
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
import jrn;
import jro;
import jrp;
import jrq;
import jrr;
import jrs;
import jrt;
import jrz;
import jsa;
import jsb;
import jsc;
import jse;
import mqq.os.MqqHandler;

public class CallbackWaitingActivityExt
  extends BaseActivity
{
  public static String f;
  public static String g;
  private static String h = "CallbackWaitingActivity";
  int jdField_a_of_type_Int = 1001;
  public BroadcastReceiver a;
  public Intent a;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler.Callback a;
  private Handler jdField_a_of_type_AndroidOsHandler = new jrn(this, Looper.getMainLooper());
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public PstnSessionInfo a;
  public BaseCallbackUI a;
  public PSTNNotification a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PstnObserver jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = new jrt(this);
  public Runnable a;
  public String a;
  jse jdField_a_of_type_Jse = null;
  public MqqHandler a;
  public int b;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new jrz(this);
  public Button b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public String b;
  int c;
  public TextView c;
  public String c;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  public String e;
  
  public CallbackWaitingActivityExt()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentIntent = null;
    this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification = null;
    this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new jrr(this);
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_JavaLangRunnable = new jrs(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.trim().length() > 0) && (paramString1 != null) && (!paramString2.trim().equals(paramString1.trim())))
    {
      if (paramString2.length() <= 5) {
        return paramString2;
      }
      return paramString2.substring(0, 5) + "...";
    }
    if ((paramString1 != null) && (paramString1.trim().length() > 0))
    {
      if (paramString1.length() >= 5) {
        return "(..." + paramString1.substring(paramString1.length() - 4, paramString1.length()) + ")";
      }
      return "(" + paramString1 + ")";
    }
    return paramString1;
  }
  
  private void a(Button paramButton, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramButton == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "changButtonStyle button is null");
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
  
  private void b(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("type", 1001);
    if (this.jdField_a_of_type_Int == 1001)
    {
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("toPhone");
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("fromPhone");
    }
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("callbackId");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("toUin");
    this.e = paramIntent.getStringExtra("fromUin");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uinType", 0);
  }
  
  private void d()
  {
    Object localObject;
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "PstnSession is null. Getting data from AVCenter");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_d_of_type_JavaLangString;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, (String)localObject, (byte)2, false, (byte)1, 0);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification != null)
      {
        if (i != 0) {
          break label173;
        }
        this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification.a(str, (Bitmap)localObject, null, 0, null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PstnSmallScreenService.class);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("pstn_session_info", this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().startService(this.jdField_a_of_type_AndroidContentIntent);
      return;
      localObject = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString;
      str = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString;
      break;
      label173:
      if (i == 2) {
        this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification.a(str, (Bitmap)localObject, null, 1, null);
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      super.setContentView(2130969337);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365799));
      LayoutInflater.from(this).inflate(2130969338, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365353));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365354));
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365373));
    if ((i == -1) || (i == 0))
    {
      a(this.jdField_a_of_type_AndroidWidgetButton, 2130840130, 2131493511, 2131493511);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365369));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365357));
      if (i != 2) {
        break label295;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131429556);
      a(this.jdField_b_of_type_AndroidWidgetButton, false, 2130840119);
      this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() != 1))
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366240);
        if (localRelativeLayout != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
          localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131559725);
          localRelativeLayout.setLayoutParams(localLayoutParams);
        }
      }
      return;
      a(this.jdField_a_of_type_AndroidWidgetButton, false, 2130840130);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      break;
      label295:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131429549);
      a(this.jdField_b_of_type_AndroidWidgetButton, 2130840119, 2131493511, 2131493511);
      this.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e)
    {
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "user close! 0");
      }
      if (this.jdField_a_of_type_Int == 1001)
      {
        if (QLog.isColorLevel()) {
          QLog.d(h, 2, "user close! 1");
        }
        finish();
        c();
        return;
      }
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(h, 2, "user close! 2");
        }
        finish();
        return;
      }
      finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "user close! 3");
    }
    c();
    g();
    finish();
  }
  
  private void g()
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
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131365823: 
      f();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int = -1;
      return;
    case 2131365366: 
      c();
      g();
      finish();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int = -1;
      return;
    case 2131365373: 
      QLog.d(h, 1, "avideo onClick QavPanel.VIEW_ENUM.HIDE");
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
        ((ResultRecord)localObject2).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString;
        ((ResultRecord)localObject2).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString;
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
        ((Intent)localObject2).putExtra("param_title", getString(2131438334));
        ((Intent)localObject2).putParcelableArrayListExtra("param_uin_create_list", paramView);
        ((Intent)localObject2).putExtra("param_uins_selected_default", (Serializable)localObject1);
        ((Intent)localObject2).putExtra("param_entrance", 20);
        ((Intent)localObject2).putExtra("param_ip_pstn_enter_type", 1);
        ((Intent)localObject2).putExtra("param_max", 99);
        ((Intent)localObject2).putExtra("param_show_none_friends_in_contact", true);
        ((Intent)localObject2).putExtra("param_exit_animation", 3);
        ((Intent)localObject2).putExtra("param_back_button_side", 0);
        ((Intent)localObject2).setFlags(603979776);
        startActivityForResult((Intent)localObject2, 113);
        return;
        if ((this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int == 2016))
        {
          ((ResultRecord)localObject2).jdField_a_of_type_Int = 5;
          if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString.startsWith("+"))
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
    DialogUtil.a(this, 230, paramView, (String)localObject1, getString(2131428669), (String)localObject2, new jsa(this), new jsb(this)).show();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "refreshUI");
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365353));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365354));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366135));
    }
    int i;
    if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "PstnSession is null. Getting data from AVCenter");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_d_of_type_JavaLangString;
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int;
    }
    for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      switch (i)
      {
      default: 
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840183);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.c((String)localObject2));
        return;
        localObject1 = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString;
        localObject2 = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString;
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
        ((FaceDrawable)localObject1).a();
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
      QLog.d(h, 2, "parseExtraData()");
    }
    this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = ((PstnSessionInfo)paramIntent.getParcelableExtra("pstn_session_info"));
    if (paramIntent.getBooleanExtra("needStopService", false)) {
      PstnUtils.a(this);
    }
    a(this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo);
    this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification = PSTNNotification.a(this);
    paramIntent = paramIntent.getStringExtra("ActivityStartFrom");
    if ((paramIntent != null) && (paramIntent.equals("ActivityStartFromBall")) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int == -1)) {
      finish();
    }
  }
  
  public void a(Button paramButton, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramButton, paramInt, 2131494061, 2131494062);
      return;
    }
    a(paramButton, paramInt, 2131494053, 2131494054);
  }
  
  protected void a(PstnSessionInfo paramPstnSessionInfo)
  {
    if ((paramPstnSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString = paramPstnSessionInfo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_d_of_type_JavaLangString = paramPstnSessionInfo.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_JavaLangString = paramPstnSessionInfo.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_JavaLangString = paramPstnSessionInfo.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int = paramPstnSessionInfo.jdField_a_of_type_Int;
    }
  }
  
  protected void b()
  {
    Object localObject4 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    Object localObject1 = ((PstnManager)localObject4).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Object localObject2;
    Object localObject3;
    String str2;
    String str1;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int == -1) && (((PstnCardInfo)localObject1).pstn_c2c_call_time == 0) && (((PstnManager)localObject4).b() == 1) && (((PstnCardInfo)localObject1).pstn_c2c_try_status == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g))
    {
      localObject1 = getString(2131438384);
      localObject2 = getString(2131438385);
      localObject3 = getString(2131438386);
      str2 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_title");
      str1 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_content");
      localObject4 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_confirm_text");
      if (!TextUtils.isEmpty(str2)) {
        break label362;
      }
      if (!TextUtils.isEmpty(str1)) {
        break label368;
      }
      label155:
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        break label374;
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
        QLog.d(h, 2, "onDestroy");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
      if (this.jdField_a_of_type_Jse != null)
      {
        localObject1 = (TelephonyManager)getSystemService("phone");
        if (localObject1 != null) {
          ((TelephonyManager)localObject1).listen(this.jdField_a_of_type_Jse, 0);
        }
        this.jdField_a_of_type_Jse = null;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = null;
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.jdField_b_of_type_AndroidWidgetButton = null;
      this.jdField_a_of_type_AndroidWidgetButton = null;
      this.jdField_a_of_type_ComTencentAvUtilsPSTNNotification = null;
      f = null;
      g = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
      label362:
      localObject1 = str2;
      break;
      label368:
      localObject2 = str1;
      break label155;
      label374:
      localObject3 = localObject4;
    }
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "sendCloseBroadCast");
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
    localIntent.setAction("tencent.av.v2q.CancelCallBack");
    localIntent.putExtra("fromPhone", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("toPhone", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("fromUin", this.e);
    localIntent.putExtra("uinType", this.jdField_b_of_type_Int);
    localIntent.putExtra("toUin", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("callBackId", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    this.mActNeedImmersive = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e)
    {
      e();
      this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI = new BaseCallbackUI();
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        super.getWindow().addFlags(67108864);
      }
      if (ImmersiveUtils.a()) {
        ImmersiveUtils.a(getWindow(), true);
      }
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("android.intent.action.PHONE_STATE"));
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getMode();
      if (this.jdField_a_of_type_Jse == null) {
        this.jdField_a_of_type_Jse = new jse(this);
      }
      ((TelephonyManager)getSystemService("phone")).listen(this.jdField_a_of_type_Jse, 32);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
      ThreadManager.post(new jrq(this), 5, null, false);
      a(getIntent());
      if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo != null)
      {
        paramBundle = getString(2131438336) + a(this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString);
        if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (paramBundle != null)) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramBundle);
        }
      }
      return true;
      super.setContentView(2130969264);
      this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI = new BaseCallbackUI(this, 1001);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365820));
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "onDestroy");
    }
    b();
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_c_of_type_Int);
    unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "onPause");
    }
    AudioUtil.a();
    if (this.jdField_a_of_type_Int == 1001) {}
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "onResume");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int == -1)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(2);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e) {
        AudioUtil.a(2131230733, 1, null, null);
      }
      ((PstnHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(82)).a(this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString, 5);
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
  
  public void finish()
  {
    super.finish();
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
        localObject = new jsc(this);
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
    DialogUtil.a(this, 230, paramIntent, str, getString(2131428669), (String)localObject, new jro(this), new jrp(this)).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      d();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.CallbackWaitingActivityExt
 * JD-Core Version:    0.7.0.1
 */