package com.tencent.biz.lebasearch;

import ajte;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bbgu;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.smtt.sdk.WebView;
import nco;
import ncp;
import wxr;

public class LebaSearchMoreInfoActivity
  extends AbsBaseWebViewActivity
{
  long jdField_a_of_type_Long;
  public ajte a;
  Handler jdField_a_of_type_AndroidOsHandler = new nco(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bbgu jdField_a_of_type_Bbgu = null;
  String jdField_a_of_type_JavaLangString;
  public wxr a;
  public boolean a;
  public String b;
  public String c = null;
  
  public LebaSearchMoreInfoActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Ajte = new ncp(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Wxr = wxr.a();
    this.jdField_a_of_type_Wxr.a();
    this.jdField_a_of_type_Wxr.a(this.jdField_a_of_type_Ajte);
    Intent localIntent = getIntent();
    if (localIntent == null) {
      finish();
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("url");
      this.jdField_a_of_type_Long = localIntent.getLongExtra("id", -1L);
    } while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    finish();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371782);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370855));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370853);
    ((ImageView)localObject).setImageResource(2130846527);
    ((ImageView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131379392));
    this.jdField_a_of_type_AndroidOsHandler.post(new LebaSearchMoreInfoActivity.2(this));
    if (this.jdField_a_of_type_Long != -1L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("uiResId", this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Wxr.a(18, (Bundle)localObject, this.jdField_a_of_type_Ajte);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {}
    label104:
    label244:
    label247:
    for (;;)
    {
      return;
      if (this.b == null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      SharedPreferences localSharedPreferences = getSharedPreferences("leba_search_more_config", 0);
      String str;
      if (this.app == null)
      {
        str = "";
        if (TextUtils.isEmpty(this.b)) {
          break label232;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.b + ";" + getString(2131696347));
        long l = localSharedPreferences.getLong("time_" + str + "_" + this.jdField_a_of_type_Long, 0L);
        if (System.currentTimeMillis() - l <= 86400000L) {
          break label244;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label247;
        }
        localSharedPreferences.edit().putLong("time_" + str + "_" + this.jdField_a_of_type_Long, System.currentTimeMillis());
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
        str = this.app.getAccount();
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("");
        break label104;
      }
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    setTitle(paramString);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559616);
    b();
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Wxr != null)
    {
      this.jdField_a_of_type_Wxr.b();
      this.jdField_a_of_type_Wxr.b(this.jdField_a_of_type_Ajte);
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364759: 
    case 2131371782: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_Bbgu == null) {
        this.jdField_a_of_type_Bbgu = Utils.createPluginSetDialogForWeb(this, this.jdField_a_of_type_Wxr, this.jdField_a_of_type_Ajte, 1, this.jdField_a_of_type_Long, this.c, null);
      }
      if (this.jdField_a_of_type_Bbgu.isShowing()) {
        this.jdField_a_of_type_Bbgu.dismiss();
      }
      this.jdField_a_of_type_Bbgu.show();
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */