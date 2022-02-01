package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import mqq.app.MobileQQ;

class SubscribeQRCodeShareHelper$5
  implements Runnable
{
  SubscribeQRCodeShareHelper$5(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper) {}
  
  public void run()
  {
    String str;
    if ((SubscribeQRCodeShareHelper.a(this.this$0)) && (!SubscribeQRCodeShareHelper.a(this.this$0).isFinishing()))
    {
      localObject = SubscribeQRCodeShareHelper.a(this.this$0, SubscribeQRCodeShareHelper.a(this.this$0));
      str = SubscribeQRCodeShareHelper.a(this.this$0, AppConstants.SDCARD_IMG_SAVE);
      if (!FileUtils.d((String)localObject, str)) {
        Toast.makeText(SubscribeQRCodeShareHelper.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    SubscribeQRCodeShareHelper.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(SubscribeQRCodeShareHelper.a(this.this$0), (Intent)localObject);
    Toast.makeText(SubscribeQRCodeShareHelper.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */