package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import mqq.app.MobileQQ;
import zlp;

public class SubscribeQRCodeShareHelper$5
  implements Runnable
{
  public SubscribeQRCodeShareHelper$5(zlp paramzlp) {}
  
  public void run()
  {
    String str;
    if ((zlp.a(this.this$0)) && (!zlp.a(this.this$0).isFinishing()))
    {
      localObject = zlp.a(this.this$0, zlp.a(this.this$0));
      str = zlp.a(this.this$0, AppConstants.SDCARD_IMG_SAVE);
      if (!FileUtils.copyFile((String)localObject, str)) {
        Toast.makeText(zlp.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    zlp.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(zlp.a(this.this$0), (Intent)localObject);
    Toast.makeText(zlp.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */