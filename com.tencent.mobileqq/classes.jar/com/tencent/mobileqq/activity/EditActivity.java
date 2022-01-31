package com.tencent.mobileqq.activity;

import acqp;
import acqq;
import acqr;
import acqs;
import acqt;
import acqu;
import acqv;
import alnn;
import alpo;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import appt;
import appw;
import baiq;
import baiy;
import bcwh;
import bdcd;
import bdcq;
import bepp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import java.io.UnsupportedEncodingException;

public class EditActivity
  extends IphoneTitleBarActivity
  implements appt
{
  float jdField_a_of_type_Float = 1.5F;
  public int a;
  private alnn jdField_a_of_type_Alnn = new acqp(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new acqt(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private bepp jdField_a_of_type_Bepp;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  public ClearableEditText a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  
  private boolean a(String paramString)
  {
    return paramString.replaceAll("[一-龥]*[a-z]*[A-Z]*\\d*-*,*，*。*、*？*\\?*!*！*_*\\s*", "").length() != 0;
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Bepp == null)
    {
      this.jdField_a_of_type_Bepp = new bepp(this, getTitleBarHeight());
      this.jdField_a_of_type_Bepp.c(2131692118);
    }
    this.jdField_a_of_type_Bepp.show();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377267));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new acqq(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365712));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(new acqr(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367322));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367321));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367323));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setEditableFactory(baiq.a);
    if (getIntent().getBooleanExtra("key_null_bg", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setBackgroundResource(2130839253);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding((int)bdcq.a(this, 10.0F), (int)bdcq.a(this, 10.0F), (int)bdcq.a(this, 10.0F), (int)bdcq.a(this, 30.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
    if (getIntent().getBooleanExtra("key_hide_clear_btn", false)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonStyle(1);
    }
    setTitle(this.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    if (getIntent().getIntExtra("key_title_style", 0) == 0)
    {
      setRightHighlightButton(2131692680, new acqs(this));
      enableRightHighlight(true);
      localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getLayoutParams();
      if (this.jdField_b_of_type_Boolean) {
        break label399;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.jdField_a_of_type_JavaLangString);
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i, i);
      if (localLayoutParams != null)
      {
        if ((this.jdField_a_of_type_Int == 102) || (this.jdField_a_of_type_Int == 105)) {
          break label383;
        }
        localLayoutParams.height = ((int)(74.0F * this.jdField_a_of_type_Float));
      }
    }
    for (;;)
    {
      if (localLayoutParams != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLayoutParams(localLayoutParams);
      }
      new Handler().postDelayed(new EditActivity.5(this), 500L);
      return;
      if (getIntent().getIntExtra("key_title_style", 0) != 1) {
        break;
      }
      this.leftView.setText(2131690382);
      break;
      label383:
      localLayoutParams.height = ((int)(48.0F * this.jdField_a_of_type_Float));
      continue;
      label399:
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.jdField_a_of_type_JavaLangString);
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i, i);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setGravity(48);
      if (localLayoutParams != null) {
        localLayoutParams.height = ((int)(150.0F * this.jdField_a_of_type_Float));
      }
    }
  }
  
  private void k()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    Intent localIntent = getIntent();
    localIntent.putExtra("result", str);
    if (this.jdField_a_of_type_Int == 103) {
      localIntent.putExtra("hasChange", this.jdField_d_of_type_Boolean);
    }
    setResult(-1, localIntent);
    finish();
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_Int == 102) || (this.jdField_a_of_type_Int == 105))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getPaddingRight(), bcwh.a(this, 30.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setMinHeight(bcwh.a(this, 74.0F));
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = bdcd.a(this, alpo.a(2131703998), 2131693165, 2131693544, new acqu(this), new acqv(this));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
  }
  
  public void a(appw paramappw)
  {
    paramappw.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, null);
  }
  
  public void a(appw paramappw1, appw paramappw2, Drawable paramDrawable) {}
  
  public boolean a(appw paramappw)
  {
    return false;
  }
  
  public void b()
  {
    baiy.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
  }
  
  public void b(appw paramappw) {}
  
  public void c() {}
  
  public void d() {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.e = paramBundle.getIntExtra("support_emotion", 0);
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("action", 0);
    super.setContentView(2131559165);
    setContentBackgroundResource(2130838591);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131367320));
    if (this.e == 1) {
      i();
    }
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("title", 0);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("limit", 0);
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("key_emo_id", -1);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("multiLine", false);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("canPostNull", true);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("current");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("key_input_tip");
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    j();
    l();
    if (this.jdField_a_of_type_Int == 103) {
      paramBundle = alpo.a(2131703995);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(paramBundle);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(paramBundle);
      }
      if (this.jdField_a_of_type_Int == 105) {
        addObserver(this.jdField_a_of_type_Alnn);
      }
      return true;
      if (this.jdField_a_of_type_Int == 102) {
        paramBundle = "";
      } else if (this.jdField_a_of_type_Int == 105) {
        paramBundle = getString(2131692110);
      } else {
        paramBundle = alpo.a(2131703997) + getString(this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.a();
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
    }
    if (this.jdField_a_of_type_Int == 105) {
      removeObserver(this.jdField_a_of_type_Alnn);
    }
    super.doOnDestroy();
  }
  
  public void e()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void enableRightHighlight(boolean paramBoolean)
  {
    super.enableRightHighlight(paramBoolean);
    int i = this.rightViewText.getCurrentTextColor();
    if ((!paramBoolean) && (i == -1))
    {
      this.rightViewText.setAlpha(0.6F);
      return;
    }
    this.rightViewText.setAlpha(1.0F);
  }
  
  public void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject1 = new byte[0];
      try
      {
        localObject2 = str.getBytes("utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2;
          localUnsupportedEncodingException.printStackTrace();
          continue;
          ColorStateList localColorStateList = getResources().getColorStateList(2131166981);
          continue;
          localObject1 = String.valueOf((this.jdField_c_of_type_Int - i) / 3);
          continue;
          if (i > this.jdField_c_of_type_Int) {
            localObject1 = getString(2131691148) + "！ " + i + "/" + this.jdField_c_of_type_Int;
          } else {
            localObject1 = i + "/" + this.jdField_c_of_type_Int;
          }
        }
        if ((i > 0) && (i <= this.jdField_c_of_type_Int))
        {
          enableRightHighlight(true);
          return;
        }
        if ((i == 0) && (this.jdField_c_of_type_Boolean))
        {
          enableRightHighlight(true);
          return;
        }
        enableRightHighlight(false);
        return;
      }
    }
    for (int i = localObject1.length;; i = 0) {
      if (i > this.jdField_c_of_type_Int)
      {
        localObject2 = getResources().getColorStateList(2131167035);
        if (!getIntent().getBooleanExtra("key_simple_count_style", false)) {
          continue;
        }
        if (i <= this.jdField_c_of_type_Int) {
          continue;
        }
        localObject1 = String.valueOf((this.jdField_c_of_type_Int - i - 2) / 3);
        if (localObject2 != null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        if ((this.jdField_a_of_type_Int != 101) || (!TextUtils.isEmpty(str.trim()))) {
          continue;
        }
        enableRightHighlight(false);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject;
    if (getIntent().getIntExtra("key_title_style", 0) == 1)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if (TextUtils.isEmpty(str)) {
        break label163;
      }
      localObject = new byte[0];
      try
      {
        byte[] arrayOfByte = str.getBytes("utf-8");
        localObject = arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        e();
        localObject = getIntent();
        ((Intent)localObject).putExtra("result", str);
        setResult(-1, (Intent)localObject);
        finish();
        return false;
      }
    }
    label163:
    for (int i = localObject.length;; i = 0)
    {
      if (i > this.jdField_c_of_type_Int)
      {
        QQToast.a(this, 2131719765, 0).b(getTitleBarHeight());
        return true;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if ((this.jdField_a_of_type_Int == 104) && (!TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString)))
      {
        m();
        return true;
      }
      e();
      return super.onBackEvent();
    }
  }
  
  public void onPause()
  {
    e();
    super.onPause();
  }
  
  public void onResume()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    super.onResume();
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity
 * JD-Core Version:    0.7.0.1
 */