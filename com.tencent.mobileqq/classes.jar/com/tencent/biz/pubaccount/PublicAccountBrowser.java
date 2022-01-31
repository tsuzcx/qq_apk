package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.regex.Pattern;

public class PublicAccountBrowser
  extends QQBrowserActivity
{
  public final Pattern a;
  
  public PublicAccountBrowser()
  {
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<meta.*itemprop=\"name\"\\s.*content=\"(.*)\">");
    this.jdField_a_of_type_JavaLangClass = PublicAccountBrowser.PublicAccountBrowserFragment.class;
  }
  
  public String a()
  {
    return getIntent().getExtras().getString("puin");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    if ((str != null) && (str.contains("iyouxi.vip.qq.com/vipcenter")))
    {
      super.doOnCreate(paramBundle);
      VasWebviewUtil.openQQBrowserActivity(this, str, 16L, localIntent, false, -1);
      super.finish();
      return false;
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout = new SwipeBackLayout(this);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a();
    }
  }
  
  public void finish()
  {
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */