package com.tencent.biz.webviewbase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class WebAIOController
{
  static volatile boolean jdField_b_of_type_Boolean = false;
  static volatile boolean jdField_c_of_type_Boolean = false;
  int jdField_a_of_type_Int = 2130851320;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new WebAIOController.2(this);
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  Client.OnRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver = new WebAIOController.3(this);
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  String jdField_b_of_type_JavaLangString = "";
  int jdField_c_of_type_Int = 360000;
  String jdField_c_of_type_JavaLangString = "";
  int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString = "";
  
  void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (!this.jdField_a_of_type_Boolean) || (!(this.jdField_a_of_type_AndroidViewView instanceof RelativeLayout))) {
      return;
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850830));
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Int));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new WebAIOController.1(this));
    RelativeLayout localRelativeLayout2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    localRelativeLayout2.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.setMargins(0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), 0);
    localRelativeLayout2.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 36.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 36.0F));
    localLayoutParams.addRule(0, 2131377301);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.setMargins(0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), 0);
    localRelativeLayout1.addView(localRelativeLayout2, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1134041: 
    case 1134042: 
      paramVarArgs = DataFactory.a("ipc_jump_to_conversation", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver.key, null);
      paramVarArgs.putInt("banner_msg", paramInt);
      paramVarArgs.putCharSequence("banner_tips", this.jdField_a_of_type_JavaLangString);
      paramVarArgs.putInt("banner_icon", this.jdField_b_of_type_Int);
      paramVarArgs.putInt("banner_timeout", this.jdField_c_of_type_Int);
      paramVarArgs.putCharSequence("activity", this.jdField_b_of_type_JavaLangString);
      paramVarArgs.putInt("flags", this.jdField_d_of_type_Int);
      paramVarArgs.putCharSequence("action", this.jdField_c_of_type_JavaLangString);
      paramVarArgs.putCharSequence("category", this.jdField_d_of_type_JavaLangString);
      a(paramVarArgs);
      return;
    case 1135042: 
      a(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    }
    b(paramInt, paramVarArgs);
  }
  
  void a(Context paramContext)
  {
    a(1134041, new Object[0]);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, SplashActivity.class);
    localIntent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
    localIntent.setFlags(335544320);
    localIntent.putExtra("tab_index", 0);
    paramContext.startActivity(localIntent);
  }
  
  void a(Bundle paramBundle)
  {
    if (!WebIPCOperator.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOBanner", 2, "messenger service is not connected!");
      }
      return;
    }
    WebIPCOperator.a().a(paramBundle);
  }
  
  void a(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  void b()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      c();
      a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "init for switch aio cost " + (System.currentTimeMillis() - l) + "ms");
    }
  }
  
  void b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (jdField_b_of_type_Boolean)
            {
              a(false);
              return;
            }
          } while ((!jdField_c_of_type_Boolean) || (jdField_b_of_type_Boolean));
          a(true);
          return;
        } while ((paramVarArgs.length < 1) || (!(paramVarArgs[0] instanceof String)));
        paramVarArgs = (String)paramVarArgs[0];
      } while (TextUtils.isEmpty(paramVarArgs));
      this.jdField_a_of_type_JavaLangString = paramVarArgs;
      return;
    } while (paramVarArgs.length < 1);
    this.jdField_b_of_type_Int = ((Integer)paramVarArgs[0]).intValue();
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.msg.newmessage"));
  }
  
  void d()
  {
    try
    {
      WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver);
      if (!WebIPCOperator.a().a()) {
        WebIPCOperator.a().a().doBindService(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOBanner", 2, "bind messenger service error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewbase.WebAIOController
 * JD-Core Version:    0.7.0.1
 */