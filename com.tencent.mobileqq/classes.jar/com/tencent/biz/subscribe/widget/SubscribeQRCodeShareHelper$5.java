package com.tencent.biz.subscribe.widget;

import ajsf;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import bbdj;
import java.io.File;
import mqq.app.MobileQQ;
import wuu;

public class SubscribeQRCodeShareHelper$5
  implements Runnable
{
  public SubscribeQRCodeShareHelper$5(wuu paramwuu) {}
  
  public void run()
  {
    String str;
    if ((wuu.a(this.this$0)) && (!wuu.a(this.this$0).isFinishing()))
    {
      localObject = wuu.a(this.this$0, wuu.a(this.this$0));
      str = wuu.a(this.this$0, ajsf.bc);
      if (!bbdj.d((String)localObject, str))
      {
        bbdj.a(str, true);
        Toast.makeText(wuu.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    wuu.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(wuu.a(this.this$0), (Intent)localObject);
    Toast.makeText(wuu.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */