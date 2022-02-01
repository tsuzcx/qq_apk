package com.tencent.biz.subscribe.widget;

import android.content.Intent;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import java.io.File;
import java.net.URI;

class SubscribeQRCodeShareHelper$6
  implements Runnable
{
  SubscribeQRCodeShareHelper$6(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper) {}
  
  public void run()
  {
    if (SubscribeQRCodeShareHelper.k(this.this$0))
    {
      Object localObject = this.this$0;
      localObject = SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject, SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject));
      File localFile = new File((String)localObject);
      Intent localIntent = new Intent();
      localIntent.putExtra("forward_type", 1);
      localIntent.putExtra("forward_filepath", (String)localObject);
      localIntent.putExtra("forward_thumb", (String)localObject);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_big_url", localFile.toURI().toString());
      localIntent.putExtra("forward_urldrawable_thumb_url", localFile.toURI().toString());
      localIntent.putExtra("key_help_forward_pic", true);
      localIntent.putExtra("selection_mode", 1);
      localIntent.putExtra("forward_ability_entrence_show_in_share", false);
      localIntent.putExtra("filePath", (String)localObject);
      localIntent.putExtra("shareQQType", 13);
      localIntent.putExtra("reqType", 1);
      ForwardBaseOption.a(SubscribeQRCodeShareHelper.c(this.this$0), localIntent, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.6
 * JD-Core Version:    0.7.0.1
 */