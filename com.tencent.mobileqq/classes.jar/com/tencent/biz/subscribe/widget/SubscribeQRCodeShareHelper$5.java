package com.tencent.biz.subscribe.widget;

import aljq;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import bdcs;
import java.io.File;
import mqq.app.MobileQQ;
import yjk;

public class SubscribeQRCodeShareHelper$5
  implements Runnable
{
  public SubscribeQRCodeShareHelper$5(yjk paramyjk) {}
  
  public void run()
  {
    String str;
    if ((yjk.a(this.this$0)) && (!yjk.a(this.this$0).isFinishing()))
    {
      localObject = yjk.a(this.this$0, yjk.a(this.this$0));
      str = yjk.a(this.this$0, aljq.bd);
      if (!bdcs.d((String)localObject, str))
      {
        bdcs.a(str, true);
        Toast.makeText(yjk.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    yjk.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(yjk.a(this.this$0), (Intent)localObject);
    Toast.makeText(yjk.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */