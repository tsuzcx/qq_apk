package com.tencent.mobileqq.ark.browser;

import aadl;
import aaep;
import aluk;
import aluo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bcee;
import bcfh;
import bcga;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

public class ArkBrowserFragment
  extends WebViewFragment
{
  public String a;
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
    String str = b();
    if (TextUtils.isEmpty(aaep.a(str))) {}
    do
    {
      do
      {
        return;
        localObject = ((WebViewPluginEngine)localObject).a(str);
      } while (localObject == null);
      localObject = (aluo)((aadl)localObject).a(aluo.class, false);
    } while (localObject == null);
    ((aluo)localObject).a(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void c()
  {
    bcfh localbcfh = (bcfh)this.jdField_a_of_type_Bcee.a(4);
    if (localbcfh != null)
    {
      localbcfh.a(new aluk(this));
      localbcfh.a(b(), this.jdField_a_of_type_Bcga.a);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(a() & 0xFFFFFFFB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkBrowserFragment
 * JD-Core Version:    0.7.0.1
 */