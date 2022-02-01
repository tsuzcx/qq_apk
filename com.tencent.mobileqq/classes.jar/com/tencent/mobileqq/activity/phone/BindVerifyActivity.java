package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.OnSizeChangeListener;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, SMSBodyObserver, OnSizeChangeListener
{
  private EditText a;
  private TextView b;
  private Button c;
  private ContactBindObserver d;
  private ContactBindObserver e;
  private final Handler f = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private SmsContent g;
  private String h;
  private byte[] i;
  private String j;
  private String k;
  private int l = 0;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private int p = -1;
  private int q;
  private boolean r = false;
  
  private void a(Intent paramIntent)
  {
    this.l = paramIntent.getIntExtra("kBindType", 0);
    this.h = paramIntent.getStringExtra("k_number");
    this.i = paramIntent.getByteArrayExtra("cmd_param_encrypt_mobile");
    this.j = paramIntent.getStringExtra("k_mask_number_forshow");
    this.k = paramIntent.getStringExtra("k_country_code");
    setLeftViewName(2131887440);
    setTitle("");
    TextView localTextView = (TextView)findViewById(2131439225);
    Object localObject = (TextView)findViewById(2131449356);
    this.c = ((Button)findViewById(2131445580));
    String str = a();
    if (this.p == 23)
    {
      paramIntent = getString(2131892535, new Object[] { str });
      localTextView.setText(2131892536);
      ((TextView)localObject).setVisibility(0);
      this.c.setText(getResources().getString(2131892527));
    }
    else
    {
      localTextView.setText(2131892500);
      paramIntent = getString(2131892538, new Object[] { str });
      ((TextView)localObject).setVisibility(8);
    }
    localObject = new SpannableString(paramIntent);
    int i1 = paramIntent.indexOf(str);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i1, str.length() + i1, 17);
    ((TextView)findViewById(2131439223)).setText((CharSequence)localObject);
    this.a = ((EditText)findViewById(2131449350));
    this.a.addTextChangedListener(this);
    this.a.setOnKeyListener(this);
    this.c.setOnClickListener(this);
    this.b = ((TextView)findViewById(2131444699));
    this.b.setOnClickListener(this);
    c();
  }
  
  private void a(String paramString)
  {
    g();
    a("dc00898", "0X8009F18", 0);
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCommit cur: ");
      localStringBuilder.append(this.r);
      QLog.i("BindVerifyActivity", 2, localStringBuilder.toString());
    }
    if (this.r) {
      return;
    }
    this.r = true;
    if (this.d == null)
    {
      this.d = new BindVerifyActivity.2(this);
      this.app.registObserver(this.d);
    }
    this.mPhoneContactService.sendVerifySmsCode(paramString, this.l, this.m, this.n);
    showProgressDialog(2131916272, 1000L, true);
    this.f.sendEmptyMessageDelayed(4, 30000L);
  }
  
  private void e()
  {
    if (this.q == 1)
    {
      f();
      return;
    }
    if (this.o)
    {
      this.mPhoneContactService.sendBindMobileEncrypt(this.k, this.i, this.l, this.m, this.n);
      return;
    }
    this.mPhoneContactService.sendBindMobile(this.k, this.h, this.l, this.m, this.n);
  }
  
  private void f()
  {
    if (this.o)
    {
      this.mPhoneContactService.sendRebindMobileEncrypt(this.k, this.i, this.l, this.m, this.n);
      return;
    }
    this.mPhoneContactService.sendRebindMobile(this.k, this.h, this.l, this.m, this.n);
  }
  
  private void g()
  {
    this.a.postDelayed(new BindVerifyActivity.7(this), 300L);
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder;
    String str;
    if (this.o)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.k);
      localStringBuilder.append(" ");
      str = this.j;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.k);
      localStringBuilder.append(" ");
      str = this.h;
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  protected void a(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("k_uin");
    paramBundle = a();
    localObject = getResources().getString(2131892529, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
    int i1 = ((String)localObject).indexOf(paramBundle);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i1, paramBundle.length() + i1, 17);
    paramBundle = DialogUtil.a(this, 230, null, (CharSequence)localObject, getString(2131887648), getString(2131892267), new BindVerifyActivity.5(this), new BindVerifyActivity.6(this));
    if ((paramBundle != null) && (!paramBundle.isShowing()) && (!isFinishing())) {
      paramBundle.show();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ReportController.b(this.app, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() > 0)
    {
      this.c.setEnabled(true);
      return;
    }
    this.c.setEnabled(false);
  }
  
  protected void b()
  {
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 0, 0, "", "", "", "");
    }
    Intent localIntent;
    if (getIntent().getBooleanExtra("key_is_from_qqhotspot", false))
    {
      localIntent = new Intent();
      localIntent.putExtra("bind_mobile", a());
      localIntent.putExtra("check_permission_result", "");
      setResult(-1, localIntent);
      finish();
      return;
    }
    int i1 = this.p;
    if (i1 == 10)
    {
      setResult(-1, null);
      finish();
      return;
    }
    if (i1 == 21)
    {
      localIntent = new Intent();
      localIntent.putExtra("bind_mobile", a());
      setResult(-1, localIntent);
      finish();
      return;
    }
    PermissionChecker.a(this, new BindVerifyActivity.3(this), new DenyRunnable(this, new BindVerifyActivity.4(this)));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    this.r = false;
    this.c.setEnabled(false);
    this.a.setText("");
    this.a.setHint(HardCodeUtil.a(2131899372));
    this.b.setText(HardCodeUtil.a(2131899376));
    this.b.setEnabled(false);
    this.b.setTextColor(getResources().getColor(2131168118));
    this.f.removeMessages(1);
    Handler localHandler = this.f;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(1, 60, 0), 1000L);
  }
  
  public String d()
  {
    Object localObject1 = this.a.getText();
    if (localObject1 != null) {
      localObject1 = localObject1.toString();
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return localObject2;
  }
  
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.p == 10) {
      ReportController.b(this.app, "dc00898", "", "", "0X8006AA8", "0X8006AA8", 0, 0, "", "", "", "");
    }
    if (getIntent().getBooleanExtra("k_is_block", false))
    {
      QQAppInterface localQQAppInterface = this.app;
      int i1;
      if (d().length() >= 4) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80056B6", "0X80056B6", i1, 0, "", "", "", "");
    }
    setResult(0);
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.m = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.n = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.o = getIntent().getBooleanExtra("cmd_param_is_encrypt", false);
    this.p = getIntent().getIntExtra("kSrouce", -1);
    this.q = getIntent().getIntExtra("keyReqBindMode", 0);
    getWindow().setSoftInputMode(18);
    setContentView(2131625563);
    if ((!Build.MANUFACTURER.equalsIgnoreCase("Letv")) || (!Build.MODEL.equalsIgnoreCase("X900+")))
    {
      paramBundle = (BounceScrollView)findViewById(2131429719);
      if (paramBundle != null) {
        paramBundle.setOnSizeChangeListener(this);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.m), Boolean.valueOf(this.n), Integer.valueOf(this.p) }));
    }
    a(getIntent());
    this.g = new SmsContent(null, System.currentTimeMillis());
    this.g.a(this, this);
    a("dc00898", "0X8009F17", 0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.d != null)
    {
      this.app.unRegistObserver(this.d);
      this.d = null;
    }
    if (this.e != null)
    {
      this.app.unRegistObserver(this.e);
      this.e = null;
    }
    SmsContent localSmsContent = this.g;
    if (localSmsContent != null) {
      localSmsContent.a();
    }
    this.f.removeCallbacksAndMessages(null);
    this.a.removeTextChangedListener(this);
    this.a.setKeyListener(null);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "doOnPause");
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "doOnResume");
    }
    if (d().length() == 0) {
      g();
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    paramString1 = Utils.d(paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      this.f.obtainMessage(2, paramString1).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return true;
          }
          this.r = false;
          this.f.removeMessages(4);
          dismissProgressDialog();
          showToast(1, getString(2131915700));
          if (QLog.isColorLevel())
          {
            QLog.i("BindVerifyActivity", 2, "MSG_REQUEST_TIMEOUT");
            return true;
          }
        }
        else
        {
          this.f.removeMessages(3);
          paramMessage = (BounceScrollView)findViewById(2131429719);
          if (paramMessage != null)
          {
            paramMessage.fullScroll(130);
            return true;
          }
        }
      }
      else
      {
        this.a.setText((String)paramMessage.obj);
        return true;
      }
    }
    else
    {
      i1 = paramMessage.arg1 - 1;
      paramMessage.arg1 = i1;
      if (i1 <= 0)
      {
        this.b.setEnabled(true);
        this.b.setTextColor(getResources().getColor(2131166618));
        this.b.setText(HardCodeUtil.a(2131899373));
        this.a.setText("");
        return true;
      }
      this.b.setEnabled(false);
      this.b.setTextColor(getResources().getColor(2131168118));
      this.b.setText(String.format(HardCodeUtil.a(2131899370), new Object[] { Integer.valueOf(i1) }));
      paramMessage = this.f;
      paramMessage.sendMessageDelayed(paramMessage.obtainMessage(1, i1, 0), 1000L);
    }
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (d().length() > 0) {
        this.c.setEnabled(true);
      } else {
        this.c.setEnabled(false);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436180)
    {
      if (i1 != 2131444699)
      {
        if (i1 == 2131445580) {
          a(d());
        }
      }
      else
      {
        if (this.e == null)
        {
          this.e = new BindVerifyActivity.1(this);
          this.app.registObserver(this.e);
        }
        e();
        showProgressDialog(2131916272, 1000L, true);
        a("dc00898", "0X8009F1A", 0);
      }
    }
    else {
      doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (d().length() >= 4)) {
      a(d());
    }
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.f.sendEmptyMessageDelayed(3, 100L);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity
 * JD-Core Version:    0.7.0.1
 */