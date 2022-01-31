package com.tencent.mobileqq.ark.browser;

import abyx;
import acab;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anpm;
import anpq;
import beho;
import beir;
import bejk;
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
    if (TextUtils.isEmpty(acab.a(str))) {}
    do
    {
      do
      {
        return;
        localObject = ((WebViewPluginEngine)localObject).a(str);
      } while (localObject == null);
      localObject = (anpq)((abyx)localObject).a(anpq.class, false);
    } while (localObject == null);
    ((anpq)localObject).a(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void c()
  {
    beir localbeir = (beir)this.jdField_a_of_type_Beho.a(4);
    if (localbeir != null)
    {
      localbeir.a(new anpm(this));
      localbeir.a(b(), this.jdField_a_of_type_Bejk.a);
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