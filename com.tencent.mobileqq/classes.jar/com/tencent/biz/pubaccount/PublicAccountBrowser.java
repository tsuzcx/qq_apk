package com.tencent.biz.pubaccount;

import ajya;
import amgn;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import bhvy;
import com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import sgg;

public class PublicAccountBrowser
  extends QQBrowserActivity
{
  private static final String a;
  public final Pattern a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131708784);
  }
  
  public PublicAccountBrowser()
  {
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<meta.*itemprop=\"name\"\\s.*content=\"(.*)\">");
    this.jdField_a_of_type_JavaLangClass = PublicAccountBrowser.PublicAccountBrowserFragment.class;
  }
  
  private void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = BaseApplicationImpl.getApplication();
    if (paramString != null)
    {
      paramString = bhvy.a(paramString.getRuntime(), false, true);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    a(str);
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
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
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
    if (sgg.c(getIntent().getStringExtra("url"))) {}
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */