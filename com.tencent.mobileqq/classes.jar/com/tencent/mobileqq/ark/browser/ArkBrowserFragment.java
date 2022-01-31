package com.tencent.mobileqq.ark.browser;

import aadp;
import aaet;
import alul;
import alup;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bcdq;
import bcet;
import bcfm;
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
    if (TextUtils.isEmpty(aaet.a(str))) {}
    do
    {
      do
      {
        return;
        localObject = ((WebViewPluginEngine)localObject).a(str);
      } while (localObject == null);
      localObject = (alup)((aadp)localObject).a(alup.class, false);
    } while (localObject == null);
    ((alup)localObject).a(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void c()
  {
    bcet localbcet = (bcet)this.jdField_a_of_type_Bcdq.a(4);
    if (localbcet != null)
    {
      localbcet.a(new alul(this));
      localbcet.a(b(), this.jdField_a_of_type_Bcfm.a);
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