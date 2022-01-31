package com.tencent.biz.subscribe.widget;

import alof;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import bdhb;
import java.io.File;
import mqq.app.MobileQQ;
import ynx;

public class SubscribeQRCodeShareHelper$5
  implements Runnable
{
  public SubscribeQRCodeShareHelper$5(ynx paramynx) {}
  
  public void run()
  {
    String str;
    if ((ynx.a(this.this$0)) && (!ynx.a(this.this$0).isFinishing()))
    {
      localObject = ynx.a(this.this$0, ynx.a(this.this$0));
      str = ynx.a(this.this$0, alof.bd);
      if (!bdhb.d((String)localObject, str))
      {
        bdhb.a(str, true);
        Toast.makeText(ynx.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    ynx.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(ynx.a(this.this$0), (Intent)localObject);
    Toast.makeText(ynx.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */