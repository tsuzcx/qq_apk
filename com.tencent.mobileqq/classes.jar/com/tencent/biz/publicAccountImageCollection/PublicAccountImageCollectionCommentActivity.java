package com.tencent.biz.publicAccountImageCollection;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vfa;
import vfb;
import vfc;
import vfd;
import vfe;
import vff;

public class PublicAccountImageCollectionCommentActivity
  extends BaseActivity
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 2);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("comment", str);
    localIntent.putExtra("anonymous", this.jdField_a_of_type_Boolean);
    setResult(paramInt, localIntent);
    finish();
  }
  
  private void a(String paramString)
  {
    boolean bool = a(paramString);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFF"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#9D9D9D"));
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.trim().length() == 0) || (paramString.length() > 100)) {
      return false;
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559619);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364814);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131364811));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new vfa(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new vfb(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131364805).setOnClickListener(new vfc(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new vfd(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377070));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new vfe(this));
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("anonymous", false);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131362704));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new vff(this));
    paramBundle = getIntent().getStringExtra("comment");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramBundle);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramBundle.length());
      a(paramBundle);
    }
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionCommentActivity
 * JD-Core Version:    0.7.0.1
 */