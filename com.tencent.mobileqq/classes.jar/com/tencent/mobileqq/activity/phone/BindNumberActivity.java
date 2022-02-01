package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.OnSizeChangeListener;
import com.tencent.widget.ThemeImageView;
import java.util.List;

public class BindNumberActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, OnSizeChangeListener
{
  protected EditText a;
  protected CheckBox b;
  protected Button c;
  protected String d = "+86";
  protected String e = HardCodeUtil.a(2131899355);
  protected ContactBindObserver f;
  protected ContactBindObserver g;
  protected FriendListObserver h;
  protected String i;
  protected TextView j;
  protected ViewGroup k;
  protected boolean l = false;
  protected boolean m = false;
  protected boolean n = false;
  protected boolean o;
  protected boolean p = false;
  protected boolean q = false;
  public QQCustomDialog r;
  public QQCustomDialog s;
  public QQCustomDialog t;
  private final Handler u = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private int v = -1;
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("finish2 [%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    super.finish();
    if (b()) {
      overridePendingTransition(2130772007, 2130772436);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString2);
    paramString1 = ((StringBuilder)localObject).toString();
    localObject = new Rect();
    this.j.getPaint().getTextBounds(paramString1, 0, paramString1.length(), (Rect)localObject);
    int i1 = getResources().getDimensionPixelSize(2131298182);
    int i2 = getResources().getDimensionPixelSize(2131298181);
    if (((Rect)localObject).right > i1 - i2 * 2) {
      this.j.setText(paramString2);
    } else {
      this.j.setText(paramString1);
    }
    if (AppSetting.e)
    {
      paramString1 = this.j;
      paramString2 = new StringBuilder();
      paramString2.append(this.j.getText());
      paramString2.append(HardCodeUtil.a(2131899357));
      paramString1.setContentDescription(paramString2.toString());
    }
  }
  
  private void h()
  {
    this.a.postDelayed(new BindNumberActivity.1(this), 300L);
  }
  
  private void i()
  {
    if (this.m) {
      a("dc00898", "0X8009EC3", 0);
    }
    a("dc00898", "0X8009F12", 0);
    if (this.o)
    {
      if (this.r == null) {
        this.r = DialogUtil.a(this, 230, null, HardCodeUtil.a(2131899364), getString(2131887648), getString(2131892267), new BindNumberActivity.2(this), new BindNumberActivity.3(this));
      }
      QQCustomDialog localQQCustomDialog = this.r;
      if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()) && (!isFinishing())) {
        this.r.show();
      }
    }
    else
    {
      j();
    }
  }
  
  private void j()
  {
    this.i = this.a.getText().toString().trim();
    if (TextUtils.isEmpty(this.i))
    {
      showToast(HardCodeUtil.a(2131899365));
      return;
    }
    if ((this.d.equalsIgnoreCase("+86")) && (this.i.length() != 11))
    {
      showToast(2131892523);
      return;
    }
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    if (this.o)
    {
      this.u.sendEmptyMessage(0);
      return;
    }
    this.u.sendEmptyMessage(2);
  }
  
  protected void a()
  {
    Button localButton = this.c;
    if (localButton != null)
    {
      EditText localEditText = this.a;
      if (localEditText == null) {
        return;
      }
      boolean bool1 = this.q;
      boolean bool2 = false;
      if (bool1)
      {
        localButton.setEnabled(false);
        return;
      }
      bool1 = bool2;
      if (localEditText.getText().toString().trim().length() > 0)
      {
        bool1 = bool2;
        if (this.b.isChecked()) {
          bool1 = true;
        }
      }
      this.c.setEnabled(bool1);
    }
  }
  
  protected void a(int paramInt, List<String> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (paramList == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramList.size());
      }
      QLog.i("BindNumberActivity", 2, String.format("updateFrdInPhoneContact [%s, %s]", new Object[] { Integer.valueOf(paramInt), localObject }));
    }
    View localView = this.k.findViewById(2131433677);
    int[] arrayOfInt;
    if ((paramInt >= 10) && (paramList != null) && (paramList.size() >= 3))
    {
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131439224)).setText(String.format(getString(2131892496), new Object[] { Integer.valueOf(paramInt) }));
      arrayOfInt = new int[3];
      int[] tmp137_135 = arrayOfInt;
      tmp137_135[0] = 2131434879;
      int[] tmp143_137 = tmp137_135;
      tmp143_137[1] = 2131434880;
      int[] tmp149_143 = tmp143_137;
      tmp149_143[2] = 2131434881;
      tmp149_143;
      paramInt = 0;
    }
    while (paramInt < arrayOfInt.length)
    {
      ImageView localImageView = (ImageView)localView.findViewById(arrayOfInt[paramInt]);
      if (localImageView != null)
      {
        if (paramInt < paramList.size()) {
          localObject = (String)paramList.get(paramInt);
        } else {
          localObject = null;
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localImageView.setVisibility(8);
        }
        else
        {
          localImageView.setVisibility(0);
          localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject));
          if ((localImageView instanceof ThemeImageView)) {
            ((ThemeImageView)localImageView).setSupportMaskView(true);
          }
        }
      }
      paramInt += 1;
      continue;
      localView.setVisibility(8);
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramIntent == null) {
      paramIntent = null;
    } else {
      paramIntent = paramIntent.getStringExtra("check_permission_result");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindSuc src: ");
      localStringBuilder.append(this.v);
      localStringBuilder.append(", per: ");
      localStringBuilder.append(paramIntent);
      QLog.i("BindMsgConstant", 2, localStringBuilder.toString());
    }
    int i1 = this.v;
    if (i1 == 10)
    {
      paramIntent = new Intent(this, SplashActivity.class);
      paramIntent.putExtra("main_tab_id", 1);
      paramIntent.setFlags(603979776);
      startActivity(paramIntent);
    }
    else if (i1 != 21)
    {
      if (i1 == 22)
      {
        QQToast.makeText(this, 2131892522, 1).show();
      }
      else if (this.n)
      {
        paramIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
        paramIntent.putExtra("kSrouce", this.v);
        paramIntent.putExtra("kBindNew", true);
        startActivity(paramIntent);
      }
      else if ((!"permission_denied".equals(paramIntent)) && (!"permission_denied_by_user".equals(paramIntent)))
      {
        if ("permission_granted".equals(paramIntent))
        {
          ContactBindedActivity.a(this.app, this.v, 1, localIntent);
          localIntent.putExtra("check_permission_result", paramIntent);
        }
      }
      else
      {
        localIntent.putExtra("check_permission_result", paramIntent);
        paramIntent = new Intent(this, GuideBindPhoneActivity.class);
        paramIntent.putExtra("kSrouce", this.v);
        paramIntent.putExtra("fromKeyForContactBind", 1);
        startActivity(paramIntent);
      }
    }
    setResult(-1, localIntent);
    a(paramInt);
    if (this.m) {
      ReportController.b(this.app, "dc00898", "", "", "0X8009EC4", "0X8009EC4", 0, 0, "", "", "", "");
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    a("dc00898", "0X8009F14", 0);
    Object localObject = paramBundle.getString("k_uin");
    if (TextUtils.isEmpty(this.d))
    {
      paramBundle = this.i;
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append(this.d);
      paramBundle.append(" ");
      paramBundle.append(this.i);
      paramBundle = paramBundle.toString();
    }
    localObject = getResources().getString(2131892529, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
    int i1 = ((String)localObject).indexOf(paramBundle);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i1, paramBundle.length() + i1, 17);
    paramBundle = DialogUtil.a(this, 230, null, (CharSequence)localObject, getString(2131887648), getString(2131892267), new BindNumberActivity.6(this), new BindNumberActivity.7(this));
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
    a();
  }
  
  protected boolean b()
  {
    if (!this.p)
    {
      int i1 = this.v;
      if ((i1 != 9) && (i1 != 11) && (i1 != 10)) {
        return false;
      }
    }
    return true;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    Intent localIntent = new Intent(this, BindVerifyActivity.class);
    localIntent.putExtra("kSrouce", this.v);
    localIntent.putExtra("kBindType", 0);
    localIntent.putExtra("keyReqBindMode", 0);
    localIntent.putExtra("k_number", this.i);
    localIntent.putExtra("k_country_code", this.d);
    localIntent.putExtra("k_is_block", getIntent().getBooleanExtra("k_is_block", false));
    localIntent.putExtra("key_is_from_qqhotspot", getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
    localIntent.putExtra("cmd_param_is_from_uni", this.l);
    localIntent.putExtra("key_is_from_qav_multi_call", getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
    localIntent.putExtra("cmd_param_is_from_change_bind", this.m);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    if (!isFinishing()) {
      startActivityForResult(localIntent, 2);
    }
  }
  
  protected void d()
  {
    Object localObject;
    if (this.v == 10)
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("main_tab_id", 1);
      ((Intent)localObject).setFlags(603979776);
      startActivity((Intent)localObject);
    }
    else
    {
      localObject = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((IPhoneContactService)localObject).getSelfBindInfo();
      if ((!((IPhoneContactService)localObject).isAutoUploadContacts()) && (localRespondQueryQQBindingStat != null) && (!localRespondQueryQQBindingStat.isStopFindMatch))
      {
        localObject = new Intent(this, PhoneMatchActivity.class);
        ((Intent)localObject).putExtra("key_from_contact_first", true);
        startActivity((Intent)localObject);
      }
    }
    setResult(-1);
    a(3);
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
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.e = paramIntent.getStringExtra("k_name");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("+");
        localStringBuilder.append(paramIntent.getStringExtra("k_code"));
        this.d = localStringBuilder.toString();
        a(this.e, this.d);
      }
    }
    else if ((paramInt1 == 2) && (paramInt2 != 0))
    {
      setResult(paramInt2, paramIntent);
      if (paramInt2 == -1)
      {
        a(paramIntent, 3);
        paramInt1 = this.v;
        if (paramInt1 == 7) {
          ReportController.b(this.app, "CliOper", "", "", "0X80053E2", "0X80053E2", 0, 0, "", "", "", "");
        } else if (paramInt1 == 12) {
          ReportController.b(this.app, "CliOper", "", "", "0X80053DC", "0X80053DC", 0, 0, "", "", "", "");
        }
        if (this.v == 11) {
          ReportController.b(this.app, "CliOper", "", "", "0X8006EFA", "0X8006EFA", 0, 0, "", "", "", "");
        }
      }
      else
      {
        a(3);
      }
    }
  }
  
  public void doOnBackPressed()
  {
    int i1 = this.v;
    boolean bool = false;
    if ((i1 != 10) && (i1 != 11))
    {
      if (getIntent().getBooleanExtra("k_is_block", false)) {
        ReportController.b(this.app, "CliOper", "", "", "0X80053D4", "0X80053D4", 0, 0, "", "", "", "");
      }
      super.doOnBackPressed();
      return;
    }
    if (this.v == 10) {
      bool = true;
    }
    showConfirmSkipDialog(bool);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.v = getIntent().getIntExtra("kSrouce", -1);
    paramBundle = getIntent();
    int i1 = 0;
    this.o = paramBundle.getBooleanExtra("kNeedUnbind", false);
    this.p = getIntent().getBooleanExtra("key_is_modal_pop", false);
    this.l = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.m = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.n = getIntent().getBooleanExtra("kUnityWebBind", false);
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.l), Boolean.valueOf(this.m), Integer.valueOf(this.v) }));
    }
    getWindow().setSoftInputMode(18);
    setContentView(2131625561);
    if ((!Build.MANUFACTURER.equalsIgnoreCase("Letv")) || (!Build.MODEL.equalsIgnoreCase("X900+")))
    {
      paramBundle = (BounceScrollView)findViewById(2131429719);
      if (paramBundle != null) {
        paramBundle.setOnSizeChangeListener(this);
      }
    }
    this.k = ((ViewGroup)findViewById(2131439221));
    this.k.getRootView().setBackgroundDrawable(getResources().getDrawable(2130838958));
    Object localObject = getResources();
    if (this.m)
    {
      paramBundle = ((Resources)localObject).getString(2131892499);
    }
    else
    {
      i2 = this.v;
      if ((i2 != 12) && (i2 != 14)) {
        paramBundle = ((Resources)localObject).getString(2131892498);
      } else {
        paramBundle = ((Resources)localObject).getString(2131892497);
      }
    }
    setTitle("", "");
    if (b())
    {
      setLeftButton(2131887812, null);
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
      setRightButton(2131887812, this);
    }
    else
    {
      setLeftViewName(2131887440);
    }
    ((TextView)findViewById(2131439225)).setText(paramBundle);
    paramBundle = ((Resources)localObject).getString(2131892494);
    if (this.m) {
      paramBundle = ((Resources)localObject).getString(2131892495);
    }
    ((TextView)findViewById(2131439223)).setText(paramBundle);
    g();
    paramBundle = PhoneCodeUtils.b(this);
    if (!"86".equals(paramBundle))
    {
      this.e = "";
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('+');
      ((StringBuilder)localObject).append(paramBundle);
      this.d = ((StringBuilder)localObject).toString();
    }
    this.j = ((TextView)findViewById(2131431448));
    this.j.setOnClickListener(this);
    a(this.e, this.d);
    this.b = ((CheckBox)findViewById(2131447782));
    this.b.setOnCheckedChangeListener(this);
    this.b.setContentDescription(HardCodeUtil.a(2131899366));
    this.a = ((EditText)findViewById(2131439507));
    this.a.addTextChangedListener(this);
    this.a.setSingleLine();
    this.a.setText(this.i);
    if (!TextUtils.isEmpty(this.i)) {
      this.a.setSelection(this.i.length());
    }
    this.a.requestFocus();
    this.a.setOnKeyListener(this);
    this.c = ((Button)findViewById(2131431129));
    this.c.setOnClickListener(this);
    a();
    findViewById(2131447783).setOnClickListener(this);
    findViewById(2131447785).setOnClickListener(this);
    int i2 = this.v;
    if (i2 != -1)
    {
      if (i2 != 1)
      {
        if (i2 != 9)
        {
          if (i2 != 17)
          {
            if (i2 == 11) {
              break label752;
            }
            if (i2 != 12)
            {
              if (i2 != 14)
              {
                if (i2 != 15) {
                  break label765;
                }
              }
              else
              {
                i1 = 2;
                break label765;
              }
            }
            else
            {
              i1 = 3;
              break label765;
            }
          }
          i1 = 4;
          break label765;
        }
        label752:
        i1 = 5;
      }
      else
      {
        i1 = 1;
      }
    }
    else {
      i1 = 6;
    }
    label765:
    a("dc00898", "0X8009F11", i1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.f != null)
    {
      this.app.unRegistObserver(this.f);
      this.f = null;
    }
    if (this.g != null)
    {
      this.app.unRegistObserver(this.g);
      this.g = null;
    }
    if (this.h != null)
    {
      this.app.removeObserver(this.h);
      this.h = null;
    }
    QQCustomDialog localQQCustomDialog = this.r;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.r = null;
    }
    localQQCustomDialog = this.s;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.s = null;
    }
    localQQCustomDialog = this.t;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.t = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (TextUtils.isEmpty(this.i)) {
      h();
    }
  }
  
  protected void e()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8005B78", "0X8005B78", 0, 0, "", "", "", "");
    if (this.s == null) {
      this.s = DialogUtil.a(this, 230, null, "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, HardCodeUtil.a(2131899356), new BindNumberActivity.8(this), null);
    }
    QQCustomDialog localQQCustomDialog = this.s;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.s.show();
    }
  }
  
  protected void f()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8005B77", "0X8005B77", 0, 0, "", "", "", "");
    if (this.t == null) {
      this.t = DialogUtil.a(this, 230, null, HardCodeUtil.a(2131899362), null, HardCodeUtil.a(2131899360), new BindNumberActivity.9(this), null);
    }
    QQCustomDialog localQQCustomDialog = this.t;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.t.show();
    }
  }
  
  public void finish()
  {
    a(0);
  }
  
  protected void g()
  {
    int i1 = this.v;
    int i2 = 0;
    if ((i1 != 10) && (i1 != 11) && (i1 != 15) && (i1 != 17) && (i1 != 1) && (i1 != 12) && (i1 != 14)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject = null;
    if (i1 == 0)
    {
      a(0, null);
      return;
    }
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
    i1 = i2;
    if (localIPhoneContactService != null)
    {
      localObject = localIPhoneContactService.getFriendHasBindPhone();
      i1 = ((Integer)localObject[0]).intValue();
      localObject = (List)localObject[1];
    }
    a(i1, (List)localObject);
    if (this.h == null)
    {
      this.h = new BindNumberActivity.10(this);
      this.app.addObserver(this.h);
    }
    localObject = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localObject != null) {
      ((FriendListHandler)localObject).getFriendsHasBindPhone(3);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if ((i1 != 2) && (i1 != 3))
      {
        if (i1 == 4)
        {
          this.u.removeMessages(4);
          paramMessage = (BounceScrollView)findViewById(2131429719);
          if (paramMessage != null)
          {
            paramMessage.fullScroll(130);
            return true;
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown message: ");
          localStringBuilder.append(paramMessage.what);
          throw new RuntimeException(localStringBuilder.toString());
        }
      }
      else
      {
        if (this.f == null)
        {
          this.f = new BindNumberActivity.5(this);
          this.app.registObserver(this.f);
        }
        this.q = true;
        a();
        this.mPhoneContactService.sendBindMobile(this.d, this.i, 0, this.l, this.m);
        if (3 != paramMessage.what)
        {
          showProgressDialog(2131916272, 1000L, true);
          return true;
        }
      }
    }
    else
    {
      if (this.g == null)
      {
        this.g = new BindNumberActivity.4(this);
        this.app.registObserver(this.g);
      }
      paramMessage = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
      showProgressDialog(2131916272, 1000L, true);
      paramMessage.unbindMobile(this.l, this.m);
    }
    return true;
  }
  
  protected boolean onBackEvent()
  {
    int i1 = this.v;
    boolean bool = false;
    if ((i1 != 10) && (i1 != 11))
    {
      a("dc00898", "0X8009F13", 0);
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_user_cancel", 1);
      setResult(0, (Intent)localObject);
      if (this.a != null)
      {
        localObject = (InputMethodManager)getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
        }
      }
      finish();
      return true;
    }
    if (this.v == 10) {
      bool = true;
    }
    showConfirmSkipDialog(bool);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.b.isChecked()) {
      this.b.setContentDescription(HardCodeUtil.a(2131899367));
    } else {
      this.b.setContentDescription(HardCodeUtil.a(2131899363));
    }
    a();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    boolean bool = false;
    Object localObject;
    switch (i1)
    {
    default: 
      this.app.logout(true);
      RouteUtils.a(this, new Intent(), "/base/login");
      a(1);
      a("CliOper", "0X80053D3", 0);
      break;
    case 2131447785: 
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://qq-web.cdn-go.cn/agreement/latest/mqq/bindphone.html");
      startActivity((Intent)localObject);
      break;
    case 2131447783: 
      localObject = this.b;
      ((CheckBox)localObject).setChecked(((CheckBox)localObject).isChecked() ^ true);
      break;
    case 2131436180: 
    case 2131436182: 
    case 2131436211: 
      i1 = this.v;
      if ((i1 != 10) && (i1 != 11))
      {
        setResult(0);
        finish();
      }
      else
      {
        if (this.v == 10) {
          bool = true;
        }
        showConfirmSkipDialog(bool);
      }
      break;
    case 2131431448: 
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      break;
    case 2131431129: 
      i();
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
    if ((paramView == this.a) && (66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      j();
      return true;
    }
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.u.sendEmptyMessageDelayed(4, 100L);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity
 * JD-Core Version:    0.7.0.1
 */