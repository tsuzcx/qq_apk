package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class Avatar2DJsModule$5
  implements Runnable
{
  Avatar2DJsModule$5(Avatar2DJsModule paramAvatar2DJsModule, String paramString1, String paramString2, int paramInt, ArrayList paramArrayList, Activity paramActivity) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      String str = this.this$0.f();
      if (!this.a.equals(str))
      {
        this.this$0.a(this.b, "WebView已经切换url");
        QLog.e("Avatar2DJsModule", 1, new Object[] { "reqUrl:", this.a, " absoluteUrl:", str });
        return;
      }
    }
    Avatar2DJsModule.a(this.this$0, this.c, this.b, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Avatar2DJsModule.5
 * JD-Core Version:    0.7.0.1
 */