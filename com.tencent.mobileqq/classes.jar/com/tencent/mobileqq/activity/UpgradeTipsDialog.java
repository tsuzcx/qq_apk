package com.tencent.mobileqq.activity;

import aegj;
import aegk;
import aekt;
import allq;
import amlo;
import amlp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import atck;
import azmj;
import bcyu;
import bizm;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeTipsDialog
  extends Dialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private aegk jdField_a_of_type_Aegk;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private atck jdField_a_of_type_Atck;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  public WebView a;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean;
  
  public UpgradeTipsDialog(Activity paramActivity, QQAppInterface paramQQAppInterface, UpgradeDetailWrapper paramUpgradeDetailWrapper, aegk paramaegk)
  {
    super(paramActivity, 2131755801);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = paramUpgradeDetailWrapper;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b(paramaegk);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)paramView.findViewById(2131379295));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setFadingEdgeLength(0);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setHorizontalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setHorizontalScrollBarEnabled(false);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibility");
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibilityTraversal");
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(new aegj(this));
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + bizm.a());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(2);
    this.jdField_a_of_type_Atck = new atck();
    this.jdField_a_of_type_Atck.a(new UpgradeTipsDialog.JsCover(this), "qqupgrade");
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131379291));
    boolean bool = allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131379292));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131379293));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (amlp.a().a() == 4) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693693);
    }
  }
  
  private void b(aegk paramaegk)
  {
    requestWindowFeature(1);
    this.jdField_a_of_type_Aegk = paramaegk;
    paramaegk = getLayoutInflater().inflate(2131561372, null);
    a(paramaegk);
    paramaegk.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramaegk);
    paramaegk = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramaegk.getAttributes();
    paramaegk.setGravity(17);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = getContext().getResources().getDisplayMetrics().heightPixels;
    localLayoutParams.width = aekt.a(260.0F, getContext().getResources());
    if (i <= j) {}
    for (localLayoutParams.height = aekt.a(368.0F, getContext().getResources());; localLayoutParams.height = aekt.a(300.0F, getContext().getResources()))
    {
      paramaegk.setAttributes(localLayoutParams);
      setCancelable(false);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(amlp.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL));
      return;
    }
  }
  
  public void a(aegk paramaegk)
  {
    this.jdField_a_of_type_Aegk = paramaegk;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void dismiss()
  {
    bcyu.b(this.jdField_a_of_type_AndroidAppActivity);
    super.dismiss();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      try
      {
        dismiss();
        boolean bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
        allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
        if (bool) {
          allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
        }
        if (this.jdField_b_of_type_Boolean) {
          ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).f(bool);
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str1 = amlo.b();
        String str2 = amlp.a();
        if (bool) {}
        for (paramView = "1";; paramView = "0")
        {
          azmj.b(localQQAppInterface, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, str1, String.valueOf(1), str2, paramView);
          if (amlp.a().a() != 4) {
            break label189;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
          if (paramView == null) {
            break;
          }
          paramView.obtainMessage(1134018).sendToTarget();
          return;
        }
        label189:
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Clk_upd_hold", 0, 0, "", "", "", "");
        if (bool)
        {
          amlp.a().a();
          return;
        }
        amlp.a().b();
        return;
      }
      catch (Exception paramView)
      {
        try
        {
          dismiss();
          label247:
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, amlo.b(), String.valueOf(1), amlp.a(), "");
          allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
          if (amlp.a().a() == 4)
          {
            amlp.a().a(getContext());
            return;
          }
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Clk_upd_now", 0, 0, "", "", "", "");
          allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
          UpgradeDetailActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper, true, true, true);
          return;
          paramView = paramView;
        }
        catch (Exception paramView)
        {
          break label247;
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Atck.a("qqupgrade");
    this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    bcyu.a(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeTipsDialog
 * JD-Core Version:    0.7.0.1
 */