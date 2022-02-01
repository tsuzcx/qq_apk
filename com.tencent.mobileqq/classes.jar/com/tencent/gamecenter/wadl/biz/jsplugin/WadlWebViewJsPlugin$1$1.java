package com.tencent.gamecenter.wadl.biz.jsplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;

class WadlWebViewJsPlugin$1$1
  implements DialogInterface.OnClickListener
{
  WadlWebViewJsPlugin$1$1(WadlWebViewJsPlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.C = 1;
    WadlProxyServiceUtil.a().b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.jsplugin.WadlWebViewJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */