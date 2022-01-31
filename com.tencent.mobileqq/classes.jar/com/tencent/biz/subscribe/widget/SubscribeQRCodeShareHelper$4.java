package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import ajed;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import bace;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.File;
import mqq.app.MobileQQ;
import vxn;
import wfw;

public class SubscribeQRCodeShareHelper$4
  implements Runnable
{
  public SubscribeQRCodeShareHelper$4(wfw paramwfw) {}
  
  public void run()
  {
    String str;
    if ((wfw.a(this.this$0)) && (!wfw.a(this.this$0).isFinishing()))
    {
      localObject = wfw.b(this.this$0);
      str = ajed.ba + ((CertifiedAccountMeta.StFeed)wfw.a(this.this$0).a().get()).createTime.get() + ".png";
      if (!bace.d((String)localObject, str))
      {
        bace.a(str, true);
        Toast.makeText(wfw.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    wfw.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(wfw.a(this.this$0), (Intent)localObject);
    Toast.makeText(wfw.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.4
 * JD-Core Version:    0.7.0.1
 */