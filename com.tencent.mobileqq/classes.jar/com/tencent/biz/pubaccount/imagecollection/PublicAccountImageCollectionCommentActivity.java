package com.tencent.biz.pubaccount.imagecollection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;

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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.trim().length() == 0) {
      return false;
    }
    return paramString.length() <= 100;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559606);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364921);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131364918));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new PublicAccountImageCollectionCommentActivity.1(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new PublicAccountImageCollectionCommentActivity.2(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131364912).setOnClickListener(new PublicAccountImageCollectionCommentActivity.3(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new PublicAccountImageCollectionCommentActivity.4(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377192));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new PublicAccountImageCollectionCommentActivity.5(this));
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("anonymous", false);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131362701));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new PublicAccountImageCollectionCommentActivity.6(this));
    paramBundle = getIntent().getStringExtra("comment");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramBundle);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramBundle.length());
      a(paramBundle);
    }
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionCommentActivity
 * JD-Core Version:    0.7.0.1
 */