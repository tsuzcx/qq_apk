package com.tencent.biz.pubaccount;

import Override;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import anzj;
import aqre;
import blhn;
import bnrf;
import com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;
import java.util.Map;
import java.util.regex.Pattern;
import nqw;
import nqx;
import oan;
import org.json.JSONException;
import org.json.JSONObject;
import tzq;

public class PublicAccountBrowser
  extends QQBrowserActivity
{
  private static final String jdField_a_of_type_JavaLangString = anzj.a(2131707653);
  private FadeIconImageView jdField_a_of_type_ComTencentWidgetFadeIconImageView;
  public final Pattern a;
  public int b;
  public String b;
  public String c = "";
  
  public PublicAccountBrowser()
  {
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<meta.*itemprop=\"name\"\\s.*content=\"(.*)\">");
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangClass = PublicAccountBrowser.PublicAccountBrowserFragment.class;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView == null) {
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131369061));
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null) {
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = blhn.a(paramString);
      if ((paramString != null) && ("1".equals(paramString.get("showProfileBtn"))) && (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null))
      {
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageResource(2130850140);
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setOnClickListener(new oan(this));
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setContentDescription(super.getText(2131695763));
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
      }
    }
  }
  
  private void b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = BaseApplicationImpl.getApplication();
    if (paramString != null)
    {
      paramString = bnrf.a(paramString.getRuntime(), false, true);
      if (paramString != null)
      {
        paramString = paramString.edit();
        paramString.putString("mLoadingUrl", str);
        paramString.commit();
        Log.d("KandianVideoUpload", "正在添加url" + str);
      }
    }
  }
  
  public String a()
  {
    return getIntent().getExtras().getString("puin");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    b(str);
    if ((str != null) && (str.contains("iyouxi.vip.qq.com/vipcenter")))
    {
      super.doOnCreate(paramBundle);
      VasWebviewUtil.openQQBrowserActivity(this, str, 16L, localIntent, false, -1);
      super.finish();
      return false;
    }
    super.g();
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_SLIDE_RIGHT_BACK_ENABLE", true))
    {
      super.f();
      a(new PublicAccountCompactSwipeBackLayout(this));
      paramBundle = super.a();
      if (paramBundle != null) {
        paramBundle.g();
      }
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("puin");
      this.jdField_b_of_type_Int = paramBundle.getInt("puin_type");
      this.c = paramBundle.getString("puin_name");
    }
    return true;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    nqw.a.b(getIntent().getStringExtra("friend_uin"));
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    nqw.a.b();
    String str = getIntent().getStringExtra("url");
    a();
    new Handler().postDelayed(new PublicAccountBrowser.1(this, str), 200L);
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("public_account_finish_animation_out_to_bottom", false)) {
      overridePendingTransition(0, 2130771978);
    }
  }
  
  public ColorNote getColorNote()
  {
    ColorNote localColorNote = super.getColorNote();
    if (tzq.c(getIntent().getStringExtra("url"))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(new String(localColorNote.getReserve()));
      localJSONObject.put("h5_type_read_in_joy", true);
      localColorNote.mReserve = localJSONObject.toString().getBytes();
      return localColorNote;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PublicAccountBrowser", 1, localJSONException, new Object[0]);
    }
    return localColorNote;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */