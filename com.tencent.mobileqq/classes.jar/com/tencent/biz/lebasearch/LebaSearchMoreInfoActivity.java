package com.tencent.biz.lebasearch;

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
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.smtt.sdk.WebView;
import kne;
import knf;
import kng;

public class LebaSearchMoreInfoActivity
  extends AbsBaseWebViewActivity
{
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new kne(this);
  View jdField_a_of_type_AndroidViewView;
  public FrameLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public TroopMemberApiClient a;
  public BusinessObserver a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  public String a;
  public boolean a;
  public String b;
  public String c = null;
  
  public LebaSearchMoreInfoActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new kng(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
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
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366357);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369970));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369971);
    ((ImageView)localObject).setImageResource(2130844218);
    ((ImageView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366358));
    this.jdField_a_of_type_AndroidOsHandler.post(new knf(this));
    if (this.jdField_a_of_type_Long != -1L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("uiResId", this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(18, (Bundle)localObject, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.b + ";" + getString(2131430531));
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
  
  protected void a(WebView paramWebView, String paramString)
  {
    setTitle(paramString);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130969392);
    a();
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
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
    case 2131363983: 
    case 2131366357: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = Utils.createPluginSetDialogForWeb(this, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, 1, this.jdField_a_of_type_Long, this.c, null);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */