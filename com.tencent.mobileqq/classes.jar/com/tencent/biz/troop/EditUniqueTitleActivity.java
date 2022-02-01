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
  protected final int a = 6;
  protected int b = 0;
  protected String c;
  protected String d;
  protected int e;
  protected String f;
  protected String g;
  protected EditText h;
  protected ImageButton i;
  protected TextView j;
  protected TextView k;
  protected View l;
  boolean m = true;
  protected TextWatcher n = new EditUniqueTitleActivity.2(this);
  protected QQProgressDialog o;
  
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
    if (this.b != 2) {
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
      ((TroopManager)localObject).a(this.d, this.c, false);
      ((TroopManager)localObject).b(this.d, this.c, this.g, -1);
      if (this.b == 2) {
        QQToast.makeText(this, getResources().getString(2131894075), 1).show();
      }
      localObject = getIntent();
      ((Intent)localObject).putExtra("newUniqueTitle", this.g);
      setResult(-1, (Intent)localObject);
      finish();
      this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER).notifyUI(TroopSettingObserver.g, true, new Object[] { this.d, this.c, this.g });
      return;
    }
    if (this.b == 2)
    {
      setResult(0, getIntent());
      finish();
      QQToast.makeText(this, getResources().getString(2131894076), 1).show();
      return;
    }
    if (paramInt == 1281)
    {
      QQToast.makeText(this, getResources().getString(2131894073), 1).show();
      return;
    }
    QQToast.makeText(this, getResources().getString(2131894077), 1).show();
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
      localStringBuilder.append(this.b);
      QLog.d("EditUniqueTitleActivity", 2, localStringBuilder.toString());
    }
    if (paramString3.equals(this.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, equals and return");
      }
      finish();
      return;
    }
    if (this.b != 2) {
      b();
    }
    a(this.app, paramString1, paramString2, paramString3, new EditUniqueTitleActivity.5(this));
  }
  
  private boolean d()
  {
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      return false;
    }
    try
    {
      this.b = Integer.parseInt(localIntent.getStringExtra("from"));
      this.c = localIntent.getStringExtra("memberUin");
      this.d = localIntent.getStringExtra("troopUin");
      this.e = localIntent.getIntExtra("memberRole", 1);
      this.f = localIntent.getStringExtra("uniqueTitle");
      if (this.b == 2)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "grp_aio", "Clk_expire", 0, 0, this.d, "", "", "");
        return false;
      }
      return true;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return false;
  }
  
  private void e()
  {
    this.j.setTextColor(getResources().getColorStateList(2131168125));
    this.j.setText("0/6");
    if (TextUtils.isEmpty(this.f))
    {
      int i1 = this.e;
      if (i1 == 2) {
        this.h.setText(getString(2131891487));
      } else if (i1 == 3) {
        this.h.setText(getString(2131917603));
      }
    }
    else
    {
      this.h.setText(this.f);
    }
    EditText localEditText = this.h;
    localEditText.setSelection(localEditText.length());
  }
  
  private void f()
  {
    String str1 = this.h.getEditableText().toString();
    this.g = str1;
    int i1 = this.e;
    if (i1 != 1)
    {
      String str2;
      if (i1 != 2)
      {
        if (i1 != 3) {
          return;
        }
        if ((!TextUtils.isEmpty(str1)) && (!str1.equals(getString(2131917603))))
        {
          a(this.d, this.c, this.g);
          return;
        }
        if (TextUtils.isEmpty(str1))
        {
          str2 = this.f;
          if ((str2 != null) && (str2.equals(getString(2131917603)))) {}
        }
        else
        {
          if (((!TextUtils.isEmpty(this.f)) || (str1 == null) || (!str1.equals(getString(2131917603)))) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(this.f)) || (!str1.equals(getString(2131917603))) || (!this.f.equals(str1))) && ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(this.f)))) {
            break label197;
          }
        }
        finish();
        return;
        label197:
        this.g = "";
        a(this.d, this.c, this.g);
        return;
      }
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals(getString(2131891487))))
      {
        a(this.d, this.c, this.g);
        return;
      }
      if (TextUtils.isEmpty(str1))
      {
        str2 = this.f;
        if ((str2 != null) && (str2.equals(getString(2131891487)))) {}
      }
      else
      {
        if (((!TextUtils.isEmpty(this.f)) || (str1 == null) || (!str1.equals(getString(2131891487)))) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(this.f)) || (!str1.equals(getString(2131891487))) || (!this.f.equals(str1))) && ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(this.f)))) {
          break label380;
        }
      }
      finish();
      return;
      label380:
      this.g = "";
      a(this.d, this.c, this.g);
      return;
    }
    if (!TextUtils.isEmpty(str1))
    {
      a(this.d, this.c, this.g);
      return;
    }
    if (TextUtils.isEmpty(this.f))
    {
      finish();
      return;
    }
    this.g = "";
    a(this.d, this.c, this.g);
  }
  
  protected void a()
  {
    ReportController.b(this.app, "dc00899", "Grp_title", "", "grp_data", "clk_finish", 0, 0, "", "", "", "");
    String str = this.h.getEditableText().toString();
    if ((!TextUtils.isEmpty(this.f)) && (TextUtils.isEmpty(str)))
    {
      DialogUtil.a(this, getString(2131893910), 2131887648, 2131893909, new EditUniqueTitleActivity.3(this), new EditUniqueTitleActivity.4(this)).show();
      return;
    }
    f();
  }
  
  public void b()
  {
    try
    {
      if (this.o == null)
      {
        this.o = new QQProgressDialog(this, getTitleBarHeight());
        this.o.c(2131892360);
        this.o.c(false);
      }
      this.o.show();
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
      if ((this.o != null) && (this.o.isShowing()))
      {
        this.o.dismiss();
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
    if (!d())
    {
      finish();
      return false;
    }
    super.setContentView(2131626684);
    setTitle(2131893962);
    setLeftButton(2131887648, new EditUniqueTitleActivity.1(this));
    this.h = ((EditText)findViewById(2131432321));
    this.i = ((ImageButton)findViewById(2131430768));
    this.j = ((TextView)findViewById(2131432340));
    this.k = ((TextView)findViewById(2131449322));
    this.h.addTextChangedListener(this.n);
    this.i.setOnClickListener(this);
    this.m = "1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    setRightHighlightButton(2131889474, this);
    if (!this.m) {
      this.rightViewText.setAlpha(0.5F);
    }
    this.l = findViewById(2131444714);
    this.l.setOnClickListener(this);
    this.l.setVisibility(8);
    int i1 = this.e;
    if (i1 == 2)
    {
      paramBundle = getString(2131891487);
      if ((!TextUtils.isEmpty(this.f)) && (!paramBundle.equals(this.f)))
      {
        this.l.setVisibility(0);
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.d, "", "", "");
      }
    }
    else if (i1 == 3)
    {
      paramBundle = getString(2131917603);
      if ((!TextUtils.isEmpty(this.f)) && (!paramBundle.equals(this.f)))
      {
        this.l.setVisibility(0);
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.d, "", "", "");
      }
    }
    ReportController.b(this.app, "dc00899", "Grp_title", "", "grp_data", "edit_exp", 0, 0, "", "", "", "");
    e();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131430768)
    {
      if (i1 != 2131436211)
      {
        if (i1 == 2131444714)
        {
          this.g = "";
          a(this.d, this.c, this.g);
          ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, this.d, "0", "0", "0");
          ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_default", 0, 0, this.d, "", "", "");
        }
      }
      else {
        a();
      }
    }
    else {
      this.h.setText("");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity
 * JD-Core Version:    0.7.0.1
 */