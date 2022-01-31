package com.tencent.biz.lebasearch;

import alpg;
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
import bdjz;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.smtt.sdk.WebView;
import nfk;
import nfl;
import yqz;

public class LebaSearchMoreInfoActivity
  extends AbsBaseWebViewActivity
{
  long jdField_a_of_type_Long;
  public alpg a;
  Handler jdField_a_of_type_AndroidOsHandler = new nfk(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bdjz jdField_a_of_type_Bdjz = null;
  String jdField_a_of_type_JavaLangString;
  public yqz a;
  public boolean a;
  public String b;
  public String c = null;
  
  public LebaSearchMoreInfoActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Alpg = new nfl(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Yqz = yqz.a();
    this.jdField_a_of_type_Yqz.a();
    this.jdField_a_of_type_Yqz.a(this.jdField_a_of_type_Alpg);
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
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372120);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371184));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371182);
    ((ImageView)localObject).setImageResource(2130846981);
    ((ImageView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131380165));
    this.jdField_a_of_type_AndroidOsHandler.post(new LebaSearchMoreInfoActivity.2(this));
    if (this.jdField_a_of_type_Long != -1L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("uiResId", this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Yqz.a(18, (Bundle)localObject, this.jdField_a_of_type_Alpg);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.b + ";" + getString(2131696521));
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
    setContentView(2131559668);
    b();
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Yqz != null)
    {
      this.jdField_a_of_type_Yqz.b();
      this.jdField_a_of_type_Yqz.b(this.jdField_a_of_type_Alpg);
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
    case 2131364842: 
    case 2131372120: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_Bdjz == null) {
        this.jdField_a_of_type_Bdjz = Utils.createPluginSetDialogForWeb(this, this.jdField_a_of_type_Yqz, this.jdField_a_of_type_Alpg, 1, this.jdField_a_of_type_Long, this.c, null);
      }
      if (this.jdField_a_of_type_Bdjz.isShowing()) {
        this.jdField_a_of_type_Bdjz.dismiss();
      }
      this.jdField_a_of_type_Bdjz.show();
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */