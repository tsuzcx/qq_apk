package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.utils.RouteUtils;

class SecSvcHandler$1
  implements Runnable
{
  SecSvcHandler$1(SecSvcHandler paramSecSvcHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("type", 11);
      Bundle localBundle = new Bundle();
      localBundle.putString("dlg_title", this.a);
      localBundle.putString("dlg_content", this.b);
      localBundle.putString("dlg_lbutton", this.c);
      localBundle.putString("dlg_rbutton", this.d);
      localBundle.putString("dlg_url", this.e);
      localBundle.putInt("dlg_lbtnid", this.f);
      localBundle.putInt("dlg_rbtnid", this.g);
      localBundle.putInt("dlg_seccmd", this.h);
      localIntent.putExtras(localBundle);
      localIntent.setFlags(872415232);
      if (!SecSvcHandler.a(this.this$0).isBackgroundStop)
      {
        RouteUtils.a(SecSvcHandler.a(this.this$0).getApp(), localIntent, "/base/notification");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcHandler.1
 * JD-Core Version:    0.7.0.1
 */