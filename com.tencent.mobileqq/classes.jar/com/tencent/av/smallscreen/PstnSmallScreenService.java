package com.tencent.av.smallscreen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.ui.SysCallTransparentActivity;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.qphone.base.util.QLog;
import jol;
import jom;
import mqq.app.MobileQQ;

public class PstnSmallScreenService
  extends BaseSmallScreenService
  implements SmallScreenRelativeLayout.FloatListener
{
  PstnSessionInfo jdField_a_of_type_ComTencentAvAppPstnSessionInfo;
  public QQAppInterface a;
  PstnObserver jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = new jol(this);
  public Runnable c;
  boolean g;
  
  public PstnSmallScreenService()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRunnable = new jom(this);
  }
  
  public SmallScreenRelativeLayout a()
  {
    return this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout;
  }
  
  void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("PstnSmallScreenService", 2, "onCallStateChanged state = " + paramInt);
      QLog.d("PstnSmallScreenService", 2, "onCallStateChanged incomingNumber = " + paramString);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      f();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (paramString != null) {
          if (paramString.jdField_e_of_type_Boolean)
          {
            PstnSessionInfo localPstnSessionInfo = paramString.a();
            localPstnSessionInfo.jdField_b_of_type_Int = -1;
            paramString.jdField_e_of_type_Boolean = false;
            paramString.jdField_f_of_type_Boolean = false;
            PSTNNotification.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).d();
            paramString.a(1, localPstnSessionInfo.jdField_a_of_type_JavaLangString, 0);
            stopSelf();
          }
          else if ((paramString.a().jdField_b_of_type_Int == -1) || (paramString.a().jdField_b_of_type_Int == 2))
          {
            stopSelf();
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              if (paramString != null)
              {
                paramString.jdField_e_of_type_Boolean = true;
                a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 8000L);
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                {
                  paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                  if (paramString != null) {
                    paramString.jdField_e_of_type_Boolean = true;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (this.jdField_g_of_type_Boolean) {
      stopSelf();
    }
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = new Intent(getApplicationContext(), CallbackWaitingActivityExt.class);
    paramSmallScreenRelativeLayout.addFlags(262144);
    paramSmallScreenRelativeLayout.addFlags(268435456);
    paramSmallScreenRelativeLayout.addFlags(4194304);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_Int = a().a();
    paramSmallScreenRelativeLayout.putExtra("pstn_session_info", this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo);
    paramSmallScreenRelativeLayout.putExtra("ActivityStartFrom", "ActivityStartFromBall");
    startActivity(paramSmallScreenRelativeLayout);
    return true;
  }
  
  void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramInt);
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(0, paramString, paramString, true);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_e_of_type_Boolean) {
          break label82;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, paramString, 5);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString);
      this.o = paramInt;
      return;
      label82:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, paramString, 0);
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "OnOpChanged mIsOpEnable = " + this.jdField_e_of_type_Boolean);
    }
    f();
  }
  
  void f()
  {
    boolean bool1;
    boolean bool3;
    boolean bool2;
    if (!this.jdField_d_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label362;
      }
      bool1 = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null)) {
        break label514;
      }
      bool3 = SmallScreenUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      bool2 = SmallScreenUtils.d();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnSmallScreenService", 2, "showHideToast isOpEnable = " + bool3 + ", isAudioVisible = " + bool1 + ", mIsLock = " + this.jdField_c_of_type_Boolean + ", mIsInit = " + this.jdField_a_of_type_Boolean + ", isAudioToastCanShow = " + bool2);
      }
      int i;
      label157:
      label167:
      RelativeLayout.LayoutParams localLayoutParams1;
      RelativeLayout.LayoutParams localLayoutParams2;
      if ((bool3) && (!this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
      {
        i = 1;
        if ((i == 0) || (!bool2)) {
          break label372;
        }
        i = 1;
        localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (!this.jdField_f_of_type_Boolean) {
          break label377;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130840317);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localLayoutParams1.leftMargin = this.jdField_g_of_type_Int;
        localLayoutParams1.rightMargin = this.h;
        localLayoutParams2.bottomMargin = this.k;
        label258:
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams2);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
        if ((i == 0) || (this.jdField_a_of_type_Boolean)) {
          break label441;
        }
        if (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b()) {
          b();
        }
        if (!bool1)
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
        }
        label330:
        if (i == 0) {
          break label466;
        }
        if (this.o != 3)
        {
          this.o = 3;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.o);
        }
      }
      label362:
      label372:
      label377:
      while ((this.jdField_c_of_type_Boolean) || (!this.jdField_f_of_type_Boolean) || (this.o == 2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
      {
        return;
        bool1 = false;
        break;
        i = 0;
        break label157;
        i = 0;
        break label167;
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130840319);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        localLayoutParams1.leftMargin = this.i;
        localLayoutParams1.rightMargin = this.j;
        localLayoutParams2.bottomMargin = this.l;
        break label258;
        if (!bool1) {
          break label330;
        }
        this.n = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
        break label330;
      }
      label441:
      label466:
      b(2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString);
      return;
      label514:
      bool2 = false;
      bool3 = false;
    }
  }
  
  void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "InitRunnable.run start");
    }
    this.jdField_a_of_type_Boolean = false;
    f();
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "InitRunnable.run end");
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "onCreate start");
    }
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
    if (i == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131429558);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnSmallScreenService", 2, "onCreate end");
      }
      return;
      if (i == 2) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131429559);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "onDestroy start");
    }
    super.onDestroy();
    Object localObject4 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    Object localObject1 = ((PstnManager)localObject4).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Object localObject2;
    Object localObject3;
    String str2;
    String str1;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int == -1) && (((PstnCardInfo)localObject1).pstn_c2c_call_time == 0) && (((PstnManager)localObject4).b() == 1) && (((PstnCardInfo)localObject1).pstn_c2c_try_status == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_g_of_type_Boolean))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131438384);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131438385);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131438386);
      str2 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_title");
      str1 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_content");
      localObject4 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_confirm_text");
      if (!TextUtils.isEmpty(str2)) {
        break label333;
      }
      if (!TextUtils.isEmpty(str1)) {
        break label339;
      }
      label201:
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        break label345;
      }
    }
    for (;;)
    {
      localObject4 = new Intent(getApplicationContext(), SysCallTransparentActivity.class);
      ((Intent)localObject4).putExtra("pstn_dialog_type", 2);
      ((Intent)localObject4).putExtra("pstn_guide_title", (String)localObject1);
      ((Intent)localObject4).putExtra("pstn_guide_content", (String)localObject2);
      ((Intent)localObject4).putExtra("pstn_guide_confirm", (String)localObject3);
      ((Intent)localObject4).addFlags(268435456);
      startActivity((Intent)localObject4);
      b(0, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      if (QLog.isColorLevel()) {
        QLog.d("PstnSmallScreenService", 2, "onDestroy end");
      }
      return;
      label333:
      localObject1 = str2;
      break;
      label339:
      localObject2 = str1;
      break label201;
      label345:
      localObject3 = localObject4;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = ((PstnSessionInfo)paramIntent.getParcelableExtra("pstn_session_info"));
    }
    if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnSmallScreenService", 2, "PstnSmallScreenService mSession is null");
      }
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().d;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
    f();
    this.n = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.PstnSmallScreenService
 * JD-Core Version:    0.7.0.1
 */