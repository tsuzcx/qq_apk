package com.tencent.biz.pubaccount;

import ajjy;
import alrv;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import bgmq;
import com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.regex.Pattern;

public class PublicAccountBrowser
  extends QQBrowserActivity
{
  private static final String a;
  public final Pattern a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131642988);
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
      paramString = bgmq.a(paramString.getRuntime(), false, true);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */