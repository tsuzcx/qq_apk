package com.tencent.biz.subscribe.widget;

import aakt;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import anhk;
import bgmg;
import java.io.File;
import mqq.app.MobileQQ;

public class SubscribeQRCodeShareHelper$5
  implements Runnable
{
  public SubscribeQRCodeShareHelper$5(aakt paramaakt) {}
  
  public void run()
  {
    String str;
    if ((aakt.a(this.this$0)) && (!aakt.a(this.this$0).isFinishing()))
    {
      localObject = aakt.a(this.this$0, aakt.a(this.this$0));
      str = aakt.a(this.this$0, anhk.bg);
      if (!bgmg.d((String)localObject, str)) {
        Toast.makeText(aakt.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    aakt.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(aakt.a(this.this$0), (Intent)localObject);
    Toast.makeText(aakt.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */