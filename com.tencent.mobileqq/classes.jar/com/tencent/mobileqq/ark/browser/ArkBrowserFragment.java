package com.tencent.mobileqq.ark.browser;

import abui;
import abvm;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anld;
import anlh;
import bedf;
import beei;
import befb;
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
    if (TextUtils.isEmpty(abvm.a(str))) {}
    do
    {
      do
      {
        return;
        localObject = ((WebViewPluginEngine)localObject).a(str);
      } while (localObject == null);
      localObject = (anlh)((abui)localObject).a(anlh.class, false);
    } while (localObject == null);
    ((anlh)localObject).a(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void c()
  {
    beei localbeei = (beei)this.jdField_a_of_type_Bedf.a(4);
    if (localbeei != null)
    {
      localbeei.a(new anld(this));
      localbeei.a(b(), this.jdField_a_of_type_Befb.a);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(a() & 0xFFFFFFFB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkBrowserFragment
 * JD-Core Version:    0.7.0.1
 */