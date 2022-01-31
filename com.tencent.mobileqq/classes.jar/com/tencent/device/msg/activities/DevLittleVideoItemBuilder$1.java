package com.tencent.device.msg.activities;

import akci;
import akco;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.Utils;
import zxc;

public class DevLittleVideoItemBuilder$1
  implements Runnable
{
  public DevLittleVideoItemBuilder$1(zxc paramzxc, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    Object localObject = zxc.a(this.this$0, this.a);
    zxc.a(this.this$0, this.a);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      akco localakco = new akco(this.a.mThumbFilePath, this.a.thumbMD5, null, this.a.thumbWidth, this.a.thumbHeight);
      localObject = new akci(this.this$0.a, (String)localObject, this.a.mediacodecEncode, localakco);
      ((akci)localObject).a(zxc.a(this.this$0));
      ((akci)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */