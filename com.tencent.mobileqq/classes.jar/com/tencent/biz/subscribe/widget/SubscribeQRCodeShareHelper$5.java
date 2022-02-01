package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.content.Context;
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
    if ((SubscribeQRCodeShareHelper.a(this.this$0)) && (!SubscribeQRCodeShareHelper.a(this.this$0).isFinishing()))
    {
      Object localObject1 = this.this$0;
      Object localObject2 = SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject1, SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject1));
      localObject1 = SubscribeQRCodeShareHelper.a(this.this$0, AppConstants.SDCARD_IMG_SAVE);
      if (!FileUtils.copyFile((String)localObject2, (String)localObject1))
      {
        Toast.makeText(SubscribeQRCodeShareHelper.a(this.this$0), "save failed", 0).show();
        return;
      }
      localObject2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      ((Intent)localObject2).setData(Uri.fromFile(new File((String)localObject1)));
      SubscribeQRCodeShareHelper.a(this.this$0).sendBroadcast((Intent)localObject2);
      MobileQQ.sMobileQQ.onSendBroadcast(SubscribeQRCodeShareHelper.a(this.this$0), (Intent)localObject2);
      localObject2 = SubscribeQRCodeShareHelper.a(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("save:");
      localStringBuilder.append((String)localObject1);
      Toast.makeText((Context)localObject2, localStringBuilder.toString(), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */