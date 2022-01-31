package com.tencent.biz.subscribe.widget;

import android.content.Intent;
import aryv;
import java.io.File;
import java.net.URI;
import ynx;

public class SubscribeQRCodeShareHelper$6
  implements Runnable
{
  public SubscribeQRCodeShareHelper$6(ynx paramynx) {}
  
  public void run()
  {
    if (ynx.a(this.this$0))
    {
      String str = ynx.a(this.this$0, ynx.a(this.this$0));
      File localFile = new File(str);
      Intent localIntent = new Intent();
      localIntent.putExtra("forward_type", 1);
      localIntent.putExtra("forward_filepath", str);
      localIntent.putExtra("forward_thumb", str);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_big_url", localFile.toURI().toString());
      localIntent.putExtra("forward_urldrawable_thumb_url", localFile.toURI().toString());
      localIntent.putExtra("key_help_forward_pic", true);
      localIntent.putExtra("selection_mode", 1);
      localIntent.putExtra("forward_ability_entrence_show_in_share", false);
      localIntent.putExtra("filePath", str);
      localIntent.putExtra("shareQQType", 13);
      localIntent.putExtra("reqType", 1);
      aryv.a(ynx.a(this.this$0), localIntent, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.6
 * JD-Core Version:    0.7.0.1
 */