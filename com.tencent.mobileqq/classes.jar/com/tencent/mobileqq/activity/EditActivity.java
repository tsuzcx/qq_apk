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
  float jdField_a_of_type_Float = 1.5F;
  int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new EditActivity.6(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private FavEmoRoamingObserver jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver = new EditActivity.1(this);
  private IEmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int e = 0;
  
  private boolean a(String paramString)
  {
    return paramString.replaceAll("[一-龥]*[a-z]*[A-Z]*\\d*-*,*，*。*、*？*\\?*!*！*_*\\s*", "").length() != 0;
  }
  
  private void d()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131691941);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378167));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new EditActivity.2(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = EmoticonMainPanelUtils.initEmojiPanel(this.app, this, this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366188));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(new EditActivity.3(this));
  }
  
  private void g()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367836));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367835));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367837));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    if (getIntent().getBooleanExtra("key_null_bg", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setBackgroundResource(2130839433);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding((int)DisplayUtils.a(this, 10.0F), (int)DisplayUtils.a(this, 10.0F), (int)DisplayUtils.a(this, 10.0F), (int)DisplayUtils.a(this, 30.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
    if (getIntent().getBooleanExtra("key_hide_clear_btn", false)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonStyle(1);
    }
    setTitle(this.jdField_b_of_type_Int);
    if (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (getIntent().getIntExtra("key_title_style", 0) == 0)
    {
      setRightHighlightButton(2131692486, new EditActivity.4(this));
      enableRightHighlight(true);
    }
    else if (getIntent().getIntExtra("key_title_style", 0) == 1)
    {
      this.leftView.setText(2131690529);
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getLayoutParams();
    int i;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.jdField_a_of_type_JavaLangString);
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i, i);
      if (localLayoutParams != null)
      {
        i = this.jdField_a_of_type_Int;
        if ((i != 102) && (i != 105)) {
          localLayoutParams.height = ((int)(this.jdField_a_of_type_Float * 74.0F));
        } else {
          localLayoutParams.height = ((int)(this.jdField_a_of_type_Float * 48.0F));
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.jdField_a_of_type_JavaLangString);
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i, i);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setGravity(48);
      if (localLayoutParams != null) {
        localLayoutParams.height = ((int)(this.jdField_a_of_type_Float * 150.0F));
      }
    }
    if (localLayoutParams != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLayoutParams(localLayoutParams);
    }
    new Handler().postDelayed(new EditActivity.5(this), 500L);
  }
  
  private void h()
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
  
  private void i()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i != 102) && (i != 105))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      ClearableEditText localClearableEditText = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
      localClearableEditText.setPadding(localClearableEditText.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getPaddingRight(), DisplayUtil.a(this, 30.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setMinHeight(DisplayUtil.a(this, 74.0F));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, HardCodeUtil.a(2131703778), 2131692932, 2131693286, new EditActivity.7(this), new EditActivity.8(this));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  void a()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
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
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    Object localObject;
    int i;
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
      i = localObject.length;
    }
    else
    {
      i = 0;
    }
    ColorStateList localColorStateList;
    if (i > this.jdField_c_of_type_Int) {
      localColorStateList = getResources().getColorStateList(2131167200);
    } else {
      localColorStateList = getResources().getColorStateList(2131167144);
    }
    if (getIntent().getBooleanExtra("key_simple_count_style", false))
    {
      int j = this.jdField_c_of_type_Int;
      if (i > j) {
        localObject = String.valueOf((j - i - 2) / 3);
      } else {
        localObject = String.valueOf((j - i) / 3);
      }
    }
    else if (i > this.jdField_c_of_type_Int)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getString(2131691105));
      ((StringBuilder)localObject).append("！ ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (localColorStateList != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    if ((this.jdField_a_of_type_Int == 101) && (android.text.TextUtils.isEmpty(str.trim())))
    {
      enableRightHighlight(false);
      return;
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
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
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
    this.e = paramBundle.getIntExtra("support_emotion", 0);
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("action", 0);
    super.setContentView(2131559207);
    setContentBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131367834));
    if (this.e == 1) {
      f();
    }
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("title", 0);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("limit", 0);
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("key_emo_id", -1);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("multiLine", false);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("canPostNull", true);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("current");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("key_input_tip");
    String str = this.jdField_a_of_type_JavaLangString;
    paramBundle = "";
    if (str == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    g();
    i();
    int i = this.jdField_a_of_type_Int;
    if (i == 103) {
      paramBundle = HardCodeUtil.a(2131703775);
    } else if (i != 102) {
      if (i == 105)
      {
        paramBundle = getString(2131691934);
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append(HardCodeUtil.a(2131703777));
        paramBundle.append(getString(this.jdField_b_of_type_Int));
        paramBundle = paramBundle.toString();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(paramBundle);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(paramBundle);
    }
    if (this.jdField_a_of_type_Int == 105) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
    }
    if (this.jdField_a_of_type_Int == 105) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    }
    super.doOnDestroy();
  }
  
  public void emoticonMall() {}
  
  protected void enableRightHighlight(boolean paramBoolean)
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
  
  protected boolean onBackEvent()
  {
    if (getIntent().getIntExtra("key_title_style", 0) == 1)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      int i;
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
        i = localObject.length;
      }
      else
      {
        i = 0;
      }
      if (i > this.jdField_c_of_type_Int)
      {
        QQToast.a(this, 2131718759, 0).b(getTitleBarHeight());
        return true;
      }
      b();
      localObject = getIntent();
      ((Intent)localObject).putExtra("result", str);
      setResult(-1, (Intent)localObject);
      finish();
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((this.jdField_a_of_type_Int == 104) && (!android.text.TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString)))
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
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    super.onResume();
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.send(this.app, this, this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, null);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity
 * JD-Core Version:    0.7.0.1
 */