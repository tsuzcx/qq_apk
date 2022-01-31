package com.tencent.mobileqq.activity;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.OrientationUtil;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.QZoneHelper;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;
import ugn;

public class UpgradeTipsDialog
  extends Dialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private UpgradeTipsDialog.OnPreparedListener jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog$OnPreparedListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private JsBridge jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge;
  public WebView a;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean;
  
  public UpgradeTipsDialog(Activity paramActivity, QQAppInterface paramQQAppInterface, UpgradeDetailWrapper paramUpgradeDetailWrapper, UpgradeTipsDialog.OnPreparedListener paramOnPreparedListener)
  {
    super(paramActivity, 2131624516);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = paramUpgradeDetailWrapper;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b(paramOnPreparedListener);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)paramView.findViewById(2131371607));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setFadingEdgeLength(0);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setHorizontalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setHorizontalScrollBarEnabled(false);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(new ugn(this));
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + QZoneHelper.a());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(2);
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge = new JsBridge();
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge.a(new UpgradeTipsDialog.JsCover(this), "qqupgrade");
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131371603));
    boolean bool = ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371606));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371605));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (UpgradeController.a().a() == 4) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131433797);
    }
  }
  
  private void b(UpgradeTipsDialog.OnPreparedListener paramOnPreparedListener)
  {
    requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog$OnPreparedListener = paramOnPreparedListener;
    paramOnPreparedListener = getLayoutInflater().inflate(2130970675, null);
    a(paramOnPreparedListener);
    paramOnPreparedListener.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramOnPreparedListener);
    paramOnPreparedListener = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramOnPreparedListener.getAttributes();
    paramOnPreparedListener.setGravity(17);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = getContext().getResources().getDisplayMetrics().heightPixels;
    localLayoutParams.width = AIOUtils.a(260.0F, getContext().getResources());
    if (i <= j) {}
    for (localLayoutParams.height = AIOUtils.a(368.0F, getContext().getResources());; localLayoutParams.height = AIOUtils.a(300.0F, getContext().getResources()))
    {
      paramOnPreparedListener.setAttributes(localLayoutParams);
      setCancelable(false);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL));
      return;
    }
  }
  
  public void a(UpgradeTipsDialog.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog$OnPreparedListener = paramOnPreparedListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void dismiss()
  {
    OrientationUtil.b(this.jdField_a_of_type_AndroidAppActivity);
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
        ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
        if (bool) {
          ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
        }
        if (this.jdField_b_of_type_Boolean) {
          ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).g(bool);
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str1 = UpgradeConstants.b();
        String str2 = UpgradeController.a();
        if (bool) {}
        for (paramView = "1";; paramView = "0")
        {
          ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, str1, String.valueOf(1), str2, paramView);
          if (UpgradeController.a().a() != 4) {
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
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Clk_upd_hold", 0, 0, "", "", "", "");
        if (bool)
        {
          UpgradeController.a().a();
          return;
        }
        UpgradeController.a().b();
        return;
      }
      catch (Exception paramView)
      {
        try
        {
          dismiss();
          label247:
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, UpgradeConstants.b(), String.valueOf(1), UpgradeController.a(), "");
          ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
          if (UpgradeController.a().a() == 4)
          {
            UpgradeController.a().a(getContext());
            return;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Clk_upd_now", 0, 0, "", "", "", "");
          ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
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
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge.a("qqupgrade");
    this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    OrientationUtil.a(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeTipsDialog
 * JD-Core Version:    0.7.0.1
 */