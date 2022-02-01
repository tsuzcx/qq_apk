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
  private View a;
  private EditText b;
  private CheckBox c;
  private Button d;
  private boolean e;
  private boolean f;
  
  private void a()
  {
    this.b.clearFocus();
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 2);
  }
  
  private void a(int paramInt)
  {
    this.a.setVisibility(8);
    String str = this.b.getText().toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("comment", str);
    localIntent.putExtra("anonymous", this.e);
    setResult(paramInt, localIntent);
    finish();
  }
  
  private void a(String paramString)
  {
    boolean bool = b(paramString);
    this.d.setEnabled(bool);
    if (bool)
    {
      this.d.setTextColor(Color.parseColor("#FFFFFF"));
      return;
    }
    this.d.setTextColor(Color.parseColor("#9D9D9D"));
  }
  
  private boolean b(String paramString)
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
    super.setContentView(2131625635);
    this.a = findViewById(2131431044);
    this.b = ((EditText)this.a.findViewById(2131431041));
    this.b.requestFocus();
    this.b.addTextChangedListener(new PublicAccountImageCollectionCommentActivity.1(this));
    this.b.setOnEditorActionListener(new PublicAccountImageCollectionCommentActivity.2(this));
    this.a.findViewById(2131431035).setOnClickListener(new PublicAccountImageCollectionCommentActivity.3(this));
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(new PublicAccountImageCollectionCommentActivity.4(this));
    this.d = ((Button)findViewById(2131445573));
    this.d.setOnClickListener(new PublicAccountImageCollectionCommentActivity.5(this));
    this.e = getIntent().getBooleanExtra("anonymous", false);
    this.c = ((CheckBox)findViewById(2131428382));
    this.c.setChecked(this.e);
    this.c.setOnCheckedChangeListener(new PublicAccountImageCollectionCommentActivity.6(this));
    paramBundle = getIntent().getStringExtra("comment");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.b.setText(paramBundle);
      this.b.setSelection(paramBundle.length());
      a(paramBundle);
    }
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionCommentActivity
 * JD-Core Version:    0.7.0.1
 */