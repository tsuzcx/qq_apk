package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanelUtils;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;

public class EditActivity
  extends IphoneTitleBarActivity
  implements EmoticonCallback
{
  ClearableEditText a;
  TextView b;
  TextView c;
  int d;
  float e = 1.5F;
  private boolean f = false;
  private int g = 0;
  private int h = 0;
  private String i;
  private String j;
  private int k;
  private TextView l;
  private ImageView m;
  private IEmoticonMainPanel n;
  private LinearLayout o;
  private int p = 0;
  private boolean q = false;
  private boolean r = true;
  private boolean s = false;
  private QQProgressDialog t;
  private Dialog u;
  private FavEmoRoamingObserver v = new EditActivity.1(this);
  private TextWatcher w = new EditActivity.6(this);
  
  private boolean a(String paramString)
  {
    return paramString.replaceAll("[一-龥]*[a-z]*[A-Z]*\\d*-*,*，*。*、*？*\\?*!*！*_*\\s*", "").length() != 0;
  }
  
  private void d()
  {
    QQProgressDialog localQQProgressDialog = this.t;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.t.dismiss();
    }
  }
  
  private void e()
  {
    if (this.t == null)
    {
      this.t = new QQProgressDialog(this, getTitleBarHeight());
      this.t.c(2131888908);
    }
    this.t.show();
  }
  
  private void f()
  {
    this.m = ((ImageView)findViewById(2131446680));
    this.m.setVisibility(0);
    this.m.setOnClickListener(new EditActivity.2(this));
    this.n = EmoticonMainPanelUtils.initEmojiPanel(this.app, this, this.a, this);
    this.n.getView().setVisibility(0);
    this.o = ((LinearLayout)findViewById(2131432476));
    this.o.addView(this.n.getView());
    this.a.setOnClickListener(new EditActivity.3(this));
  }
  
  private void g()
  {
    this.e = getResources().getDisplayMetrics().density;
    this.l = ((TextView)findViewById(2131434416));
    this.b = ((TextView)findViewById(2131434415));
    this.c = ((TextView)findViewById(2131434417));
    this.a.addTextChangedListener(this.w);
    this.a.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    if (getIntent().getBooleanExtra("key_null_bg", false))
    {
      this.a.setBackgroundResource(2130839622);
      this.a.setPadding((int)DisplayUtils.a(this, 10.0F), (int)DisplayUtils.a(this, 10.0F), (int)DisplayUtils.a(this, 10.0F), (int)DisplayUtils.a(this, 30.0F));
    }
    this.a.requestFocus();
    if (getIntent().getBooleanExtra("key_hide_clear_btn", false)) {
      this.a.setClearButtonStyle(1);
    }
    setTitle(this.g);
    if (!android.text.TextUtils.isEmpty(this.j))
    {
      this.b.setText(this.j);
      this.b.setVisibility(0);
    }
    if (getIntent().getIntExtra("key_title_style", 0) == 0)
    {
      setRightHighlightButton(2131889474, new EditActivity.4(this));
      enableRightHighlight(true);
    }
    else if (getIntent().getIntExtra("key_title_style", 0) == 1)
    {
      this.leftView.setText(2131887440);
    }
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    int i1;
    if (!this.q)
    {
      this.a.setSingleLine(true);
      this.a.setText(this.i);
      i1 = this.a.getText().length();
      this.a.setSelection(i1, i1);
      if (localLayoutParams != null)
      {
        i1 = this.d;
        if ((i1 != 102) && (i1 != 105)) {
          localLayoutParams.height = ((int)(this.e * 74.0F));
        } else {
          localLayoutParams.height = ((int)(this.e * 48.0F));
        }
      }
    }
    else
    {
      this.a.setSingleLine(false);
      this.a.setText(this.i);
      i1 = this.a.getText().length();
      this.a.setSelection(i1, i1);
      this.a.setGravity(48);
      if (localLayoutParams != null) {
        localLayoutParams.height = ((int)(this.e * 150.0F));
      }
    }
    if (localLayoutParams != null) {
      this.a.setLayoutParams(localLayoutParams);
    }
    new Handler().postDelayed(new EditActivity.5(this), 500L);
  }
  
  private void h()
  {
    String str = this.a.getText().toString();
    Intent localIntent = getIntent();
    localIntent.putExtra("result", str);
    if (this.d == 103) {
      localIntent.putExtra("hasChange", this.s);
    }
    setResult(-1, localIntent);
    finish();
  }
  
  private void i()
  {
    int i1 = this.d;
    if ((i1 != 102) && (i1 != 105))
    {
      this.c.setVisibility(8);
      this.l.setVisibility(0);
      ClearableEditText localClearableEditText = this.a;
      localClearableEditText.setPadding(localClearableEditText.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), DisplayUtil.a(this, 30.0F));
      this.a.setMinHeight(DisplayUtil.a(this, 74.0F));
      return;
    }
    this.c.setVisibility(0);
    this.l.setVisibility(8);
  }
  
  private void j()
  {
    if (this.u == null) {
      this.u = DialogUtil.a(this, HardCodeUtil.a(2131901724), 2131890045, 2131890834, new EditActivity.7(this), new EditActivity.8(this));
    }
    this.u.show();
  }
  
  void a()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.a, 2);
  }
  
  void b()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  void c()
  {
    String str = this.a.getText().toString();
    Object localObject;
    int i1;
    if (!android.text.TextUtils.isEmpty(str))
    {
      localObject = new byte[0];
      try
      {
        byte[] arrayOfByte = str.getBytes("utf-8");
        localObject = arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      i1 = localObject.length;
    }
    else
    {
      i1 = 0;
    }
    ColorStateList localColorStateList;
    if (i1 > this.h) {
      localColorStateList = getResources().getColorStateList(2131168185);
    } else {
      localColorStateList = getResources().getColorStateList(2131168125);
    }
    if (getIntent().getBooleanExtra("key_simple_count_style", false))
    {
      int i2 = this.h;
      if (i1 > i2) {
        localObject = String.valueOf((i2 - i1 - 2) / 3);
      } else {
        localObject = String.valueOf((i2 - i1) / 3);
      }
    }
    else if (i1 > this.h)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getString(2131888051));
      ((StringBuilder)localObject).append("！ ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.h);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.h);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (localColorStateList != null)
    {
      this.l.setTextColor(localColorStateList);
      this.c.setTextColor(localColorStateList);
    }
    this.l.setText((CharSequence)localObject);
    this.c.setText((CharSequence)localObject);
    if ((this.d == 101) && (android.text.TextUtils.isEmpty(str.trim())))
    {
      enableRightHighlight(false);
      return;
    }
    if ((i1 > 0) && (i1 <= this.h))
    {
      enableRightHighlight(true);
      return;
    }
    if ((i1 == 0) && (this.r))
    {
      enableRightHighlight(true);
      return;
    }
    enableRightHighlight(false);
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.a);
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
    paramBundle = getIntent();
    this.p = paramBundle.getIntExtra("support_emotion", 0);
    this.d = paramBundle.getIntExtra("action", 0);
    super.setContentView(2131624964);
    setContentBackgroundResource(2130838958);
    this.a = ((ClearableEditText)findViewById(2131434414));
    if (this.p == 1) {
      f();
    }
    this.g = paramBundle.getIntExtra("title", 0);
    this.h = paramBundle.getIntExtra("limit", 0);
    this.k = paramBundle.getIntExtra("key_emo_id", -1);
    this.q = paramBundle.getBooleanExtra("multiLine", false);
    this.r = paramBundle.getBooleanExtra("canPostNull", true);
    this.i = paramBundle.getStringExtra("current");
    this.j = paramBundle.getStringExtra("key_input_tip");
    String str = this.i;
    paramBundle = "";
    if (str == null) {
      this.i = "";
    }
    g();
    i();
    int i1 = this.d;
    if (i1 == 103) {
      paramBundle = HardCodeUtil.a(2131901721);
    } else if (i1 != 102) {
      if (i1 == 105)
      {
        paramBundle = getString(2131888901);
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append(HardCodeUtil.a(2131901723));
        paramBundle.append(getString(this.g));
        paramBundle = paramBundle.toString();
      }
    }
    this.a.setHint(paramBundle);
    if (AppSetting.e) {
      this.a.setContentDescription(paramBundle);
    }
    if (this.d == 105) {
      addObserver(this.v);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.n;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    localObject = (ViewGroup)this.a.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.a);
    }
    if (this.d == 105) {
      removeObserver(this.v);
    }
    super.doOnDestroy();
  }
  
  public void emoticonMall() {}
  
  protected void enableRightHighlight(boolean paramBoolean)
  {
    super.enableRightHighlight(paramBoolean);
    int i1 = this.rightViewText.getCurrentTextColor();
    if ((!paramBoolean) && (i1 == -1))
    {
      this.rightViewText.setAlpha(0.6F);
      return;
    }
    this.rightViewText.setAlpha(1.0F);
  }
  
  protected boolean onBackEvent()
  {
    if (getIntent().getIntExtra("key_title_style", 0) == 1)
    {
      String str = this.a.getText().toString();
      int i1;
      if (!android.text.TextUtils.isEmpty(str))
      {
        localObject = new byte[0];
        try
        {
          byte[] arrayOfByte = str.getBytes("utf-8");
          localObject = arrayOfByte;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        i1 = localObject.length;
      }
      else
      {
        i1 = 0;
      }
      if (i1 > this.h)
      {
        QQToast.makeText(this, 2131916265, 0).show(getTitleBarHeight());
        return true;
      }
      b();
      localObject = getIntent();
      ((Intent)localObject).putExtra("result", str);
      setResult(-1, (Intent)localObject);
      finish();
      return false;
    }
    Object localObject = this.a.getText().toString();
    if ((this.d == 104) && (!android.text.TextUtils.equals((CharSequence)localObject, this.i)))
    {
      j();
      return true;
    }
    b();
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  protected void onPause()
  {
    b();
    super.onPause();
  }
  
  protected void onResume()
  {
    if (!this.f) {
      a();
    }
    super.onResume();
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.send(this.app, this, this.a, null);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity
 * JD-Core Version:    0.7.0.1
 */