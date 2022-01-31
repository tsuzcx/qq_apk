package com.tencent.biz.subscribe.widget;

import android.content.Intent;
import aqbe;
import java.io.File;
import java.net.URI;
import wur;

public class SubscribeQRCodeShareHelper$6
  implements Runnable
{
  public SubscribeQRCodeShareHelper$6(wur paramwur) {}
  
  public void run()
  {
    if (wur.a(this.this$0))
    {
      String str = wur.a(this.this$0, wur.a(this.this$0));
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
      aqbe.a(wur.a(this.this$0), localIntent, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.6
 * JD-Core Version:    0.7.0.1
 */