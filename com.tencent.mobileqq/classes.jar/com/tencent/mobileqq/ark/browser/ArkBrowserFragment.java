package com.tencent.mobileqq.ark.browser;

import alfx;
import algb;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bbaq;
import bbbt;
import bbcm;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import ztw;
import zva;

public class ArkBrowserFragment
  extends WebViewFragment
{
  public String a;
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
    String str = b();
    if (TextUtils.isEmpty(zva.a(str))) {}
    do
    {
      do
      {
        return;
        localObject = ((WebViewPluginEngine)localObject).a(str);
      } while (localObject == null);
      localObject = (algb)((ztw)localObject).a(algb.class, false);
    } while (localObject == null);
    ((algb)localObject).a(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void c()
  {
    bbbt localbbbt = (bbbt)this.jdField_a_of_type_Bbaq.a(4);
    if (localbbbt != null)
    {
      localbbbt.a(new alfx(this));
      localbbbt.a(b(), this.jdField_a_of_type_Bbcm.a);
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