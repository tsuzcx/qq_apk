package com.tencent.device.msg.activities;

import aigj;
import aigp;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.Utils;
import ydu;

public class DevLittleVideoItemBuilder$1
  implements Runnable
{
  public DevLittleVideoItemBuilder$1(ydu paramydu, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    Object localObject = ydu.a(this.this$0, this.a);
    ydu.a(this.this$0, this.a);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      aigp localaigp = new aigp(this.a.mThumbFilePath, this.a.thumbMD5, null, this.a.thumbWidth, this.a.thumbHeight);
      localObject = new aigj(this.this$0.a, (String)localObject, this.a.mediacodecEncode, localaigp);
      ((aigj)localObject).a(ydu.a(this.this$0));
      ((aigj)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */