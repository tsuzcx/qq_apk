package com.tencent.biz.subscribe.widget;

import aaou;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import antf;
import bhmi;
import java.io.File;
import mqq.app.MobileQQ;

public class SubscribeQRCodeShareHelper$5
  implements Runnable
{
  public SubscribeQRCodeShareHelper$5(aaou paramaaou) {}
  
  public void run()
  {
    String str;
    if ((aaou.a(this.this$0)) && (!aaou.a(this.this$0).isFinishing()))
    {
      localObject = aaou.a(this.this$0, aaou.a(this.this$0));
      str = aaou.a(this.this$0, antf.bg);
      if (!bhmi.d((String)localObject, str)) {
        Toast.makeText(aaou.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    aaou.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(aaou.a(this.this$0), (Intent)localObject);
    Toast.makeText(aaou.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */