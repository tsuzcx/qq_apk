package com.tencent.biz.troop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class EditUniqueTitleActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected final int a;
  protected TextWatcher a;
  protected View a;
  protected EditText a;
  protected ImageButton a;
  protected TextView a;
  protected QQProgressDialog a;
  protected String a;
  boolean a;
  protected int b;
  protected TextView b;
  protected String b;
  protected int c;
  protected String c;
  protected String d;
  
  public EditUniqueTitleActivity()
  {
    this.jdField_a_of_type_Int = 6;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTextTextWatcher = new EditUniqueTitleActivity.2(this);
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    paramContext = new Intent(paramContext, EditUniqueTitleActivity.class);
    paramContext.putExtra("from", String.valueOf(paramInt1));
    paramContext.putExtra("memberUin", paramString2);
    paramContext.putExtra("troopUin", paramString1);
    paramContext.putExtra("memberRole", paramInt2);
    paramContext.putExtra("uniqueTitle", paramString3);
    return paramContext;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_Int != 2) {
      c();
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetUniqueTitle, errCode=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EditUniqueTitleActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      ((TroopManager)localObject).a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, false);
      ((TroopManager)localObject).b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d, -1);
      if (this.jdField_b_of_type_Int == 2) {
        QQToast.a(this, getResources().getString(2131696309), 1).a();
      }
      localObject = getIntent();
      ((Intent)localObject).putExtra("newUniqueTitle", this.d);
      setResult(-1, (Intent)localObject);
      finish();
      this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER).notifyUI(TroopSettingObserver.f, true, new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d });
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      setResult(0, getIntent());
      finish();
      QQToast.a(this, getResources().getString(2131696310), 1).a();
      return;
    }
    if (paramInt == 1281)
    {
      QQToast.a(this, getResources().getString(2131696307), 1).a();
      return;
    }
    QQToast.a(this, getResources().getString(2131696311), 1).a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, BusinessObserver paramBusinessObserver)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Oidb_0x8fc.ReqBody localReqBody = new Oidb_0x8fc.ReqBody();
      Oidb_0x8fc.MemberInfo localMemberInfo = new Oidb_0x8fc.MemberInfo();
      try
      {
        String str = ((IBizTroopMemberInfoService)paramQQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberNickNoEmpty(paramString1, paramString2);
        localReqBody.uint64_group_code.set(Long.parseLong(paramString1));
        localMemberInfo.uint64_uin.set(Long.parseLong(paramString2));
        localMemberInfo.bytes_uin_name.set(ByteStringMicro.copyFromUtf8(str));
        if (paramString3 != null) {
          localMemberInfo.bytes_special_title.set(ByteStringMicro.copyFromUtf8(paramString3));
        }
        localMemberInfo.uint32_special_title_expire_time.set(-1);
        localReqBody.rpt_mem_level_info.add(localMemberInfo);
        paramString1 = new oidb_sso.OIDBSSOPkg();
        paramString1.uint32_command.set(2300);
        paramString1.uint32_service_type.set(2);
        paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
        paramString2 = new NewIntent(paramQQAppInterface.getApp(), ProtoServlet.class);
        paramString2.putExtra("cmd", "OidbSvc.0x8fc_2");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(paramBusinessObserver);
        paramQQAppInterface.startServlet(paramString2);
        return;
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EditUniqueTitleActivity", 2, "setUniqueTitle exp", paramQQAppInterface);
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUniqueTitle, gc=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", memberUin=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", from=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("EditUniqueTitleActivity", 2, localStringBuilder.toString());
    }
    if (paramString3.equals(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, equals and return");
      }
      finish();
      return;
    }
    if (this.jdField_b_of_type_Int != 2) {
      b();
    }
    a(this.app, paramString1, paramString2, paramString3, new EditUniqueTitleActivity.5(this));
  }
  
  private boolean a()
  {
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      return false;
    }
    try
    {
      this.jdField_b_of_type_Int = Integer.parseInt(localIntent.getStringExtra("from"));
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("memberUin");
      this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("troopUin");
      this.jdField_c_of_type_Int = localIntent.getIntExtra("memberRole", 1);
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("uniqueTitle");
      if (this.jdField_b_of_type_Int == 2)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "grp_aio", "Clk_expire", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
        return false;
      }
      return true;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167144));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0/6");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      int i = this.jdField_c_of_type_Int;
      if (i == 2) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(getString(2131693882));
      } else if (i == 3) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(getString(2131719998));
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
    }
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    localEditText.setSelection(localEditText.length());
  }
  
  private void e()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    this.d = str1;
    int i = this.jdField_c_of_type_Int;
    if (i != 1)
    {
      String str2;
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if ((!TextUtils.isEmpty(str1)) && (!str1.equals(getString(2131719998))))
        {
          a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
          return;
        }
        if (TextUtils.isEmpty(str1))
        {
          str2 = this.jdField_c_of_type_JavaLangString;
          if ((str2 != null) && (str2.equals(getString(2131719998)))) {}
        }
        else
        {
          if (((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (str1 == null) || (!str1.equals(getString(2131719998)))) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!str1.equals(getString(2131719998))) || (!this.jdField_c_of_type_JavaLangString.equals(str1))) && ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))) {
            break label197;
          }
        }
        finish();
        return;
        label197:
        this.d = "";
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
        return;
      }
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals(getString(2131693882))))
      {
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
        return;
      }
      if (TextUtils.isEmpty(str1))
      {
        str2 = this.jdField_c_of_type_JavaLangString;
        if ((str2 != null) && (str2.equals(getString(2131693882)))) {}
      }
      else
      {
        if (((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (str1 == null) || (!str1.equals(getString(2131693882)))) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!str1.equals(getString(2131693882))) || (!this.jdField_c_of_type_JavaLangString.equals(str1))) && ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))) {
          break label380;
        }
      }
      finish();
      return;
      label380:
      this.d = "";
      a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
      return;
    }
    if (!TextUtils.isEmpty(str1))
    {
      a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      finish();
      return;
    }
    this.d = "";
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
  }
  
  protected void a()
  {
    ReportController.b(this.app, "dc00899", "Grp_title", "", "grp_data", "clk_finish", 0, 0, "", "", "", "");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(str)))
    {
      DialogUtil.a(this, getString(2131696145), 2131690728, 2131696144, new EditUniqueTitleActivity.3(this), new EditUniqueTitleActivity.4(this)).show();
      return;
    }
    e();
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditUniqueTitleActivity", 2, localException.toString());
      }
    }
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditUniqueTitleActivity", 2, localException.toString());
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!a())
    {
      finish();
      return false;
    }
    super.setContentView(2131560639);
    setTitle(2131696196);
    setLeftButton(2131690728, new EditUniqueTitleActivity.1(this));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366045));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364679));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366064));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380375));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_Boolean = "1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    setRightHighlightButton(2131692486, this);
    if (!this.jdField_a_of_type_Boolean) {
      this.rightViewText.setAlpha(0.5F);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376473);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    int i = this.jdField_c_of_type_Int;
    if (i == 2)
    {
      paramBundle = getString(2131693882);
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!paramBundle.equals(this.jdField_c_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
    }
    else if (i == 3)
    {
      paramBundle = getString(2131719998);
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!paramBundle.equals(this.jdField_c_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
    }
    ReportController.b(this.app, "dc00899", "Grp_title", "", "grp_data", "edit_exp", 0, 0, "", "", "", "");
    d();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364679)
    {
      if (i != 2131369233)
      {
        if (i == 2131376473)
        {
          this.d = "";
          a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
          ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, this.jdField_b_of_type_JavaLangString, "0", "0", "0");
          ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_default", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
        }
      }
      else {
        a();
      }
    }
    else {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity
 * JD-Core Version:    0.7.0.1
 */