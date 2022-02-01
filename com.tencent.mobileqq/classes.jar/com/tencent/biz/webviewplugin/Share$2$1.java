package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.lang.ref.WeakReference;

class Share$2$1
  implements Runnable
{
  Share$2$1(Share.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    WebUiBaseInterface localWebUiBaseInterface = (WebUiBaseInterface)this.b.this$0.af.get();
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)) && (((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).isActivityResume()) && (!this.b.this$0.y.isFinishing()))
    {
      if ((this.b.this$0.B != null) && (this.b.this$0.B.isShowing())) {
        this.b.this$0.B.dismiss();
      }
      Share.a(this.b.this$0, this.b.b, this.b.this$0.e, this.b.this$0.h, this.b.this$0.b, this.b.this$0.i, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.2.1
 * JD-Core Version:    0.7.0.1
 */