package com.tencent.biz.subscribe.widget;

import ajsd;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import bbdx;
import java.io.File;
import mqq.app.MobileQQ;
import wur;

public class SubscribeQRCodeShareHelper$5
  implements Runnable
{
  public SubscribeQRCodeShareHelper$5(wur paramwur) {}
  
  public void run()
  {
    String str;
    if ((wur.a(this.this$0)) && (!wur.a(this.this$0).isFinishing()))
    {
      localObject = wur.a(this.this$0, wur.a(this.this$0));
      str = wur.a(this.this$0, ajsd.bc);
      if (!bbdx.d((String)localObject, str))
      {
        bbdx.a(str, true);
        Toast.makeText(wur.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    wur.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(wur.a(this.this$0), (Intent)localObject);
    Toast.makeText(wur.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */