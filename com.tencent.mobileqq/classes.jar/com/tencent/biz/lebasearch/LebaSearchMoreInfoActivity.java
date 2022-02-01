package com.tencent.biz.lebasearch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;

public class LebaSearchMoreInfoActivity
  extends AbsBaseWebViewActivity
{
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new LebaSearchMoreInfoActivity.1(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  public BusinessObserver a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  String c = null;
  
  public LebaSearchMoreInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new LebaSearchMoreInfoActivity.3(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("url");
    this.jdField_a_of_type_Long = localIntent.getLongExtra("id", -1L);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      finish();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372877);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371900));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371899);
    ((ImageView)localObject).setImageResource(2130847676);
    ((ImageView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131381063));
    this.jdField_a_of_type_AndroidOsHandler.post(new LebaSearchMoreInfoActivity.2(this));
    if (this.jdField_a_of_type_Long != -1L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("uiResId", this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(18, (Bundle)localObject, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.b == null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    Object localObject1 = getSharedPreferences("leba_search_more_config", 0);
    String str;
    if (getAppRuntime() == null) {
      str = "";
    } else {
      str = getAppRuntime().getAccount();
    }
    if (!TextUtils.isEmpty(this.b))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(";");
      localStringBuilder.append(getString(2131696041));
      ((TextView)localObject2).setContentDescription(localStringBuilder.toString());
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("");
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("time_");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
    long l = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
    int i;
    if (System.currentTimeMillis() - l > 86400000L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("time_");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), System.currentTimeMillis());
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
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
    setContentView(2131559803);
    a();
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    TroopMemberApiClient localTroopMemberApiClient = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localTroopMemberApiClient != null)
    {
      localTroopMemberApiClient.b();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i != 2131365236) {
      if (i != 2131371899)
      {
        if (i != 2131372877) {
          break label110;
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label110;
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = Utils.createPluginSetDialogForWeb(this, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, 1, this.jdField_a_of_type_Long, this.c, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    label110:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onReceivedTitle(WebView paramWebView, String paramString)
  {
    setTitle(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */