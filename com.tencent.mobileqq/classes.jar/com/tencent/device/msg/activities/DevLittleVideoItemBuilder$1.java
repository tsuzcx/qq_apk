package com.tencent.device.msg.activities;

import abye;
import amgx;
import amhd;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.Utils;

public class DevLittleVideoItemBuilder$1
  implements Runnable
{
  public DevLittleVideoItemBuilder$1(abye paramabye, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    Object localObject = abye.a(this.this$0, this.a);
    abye.a(this.this$0, this.a);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      amhd localamhd = new amhd(this.a.mThumbFilePath, this.a.thumbMD5, null, this.a.thumbWidth, this.a.thumbHeight);
      localObject = new amgx(this.this$0.a, (String)localObject, this.a.mediacodecEncode, localamhd);
      ((amgx)localObject).a(abye.a(this.this$0));
      ((amgx)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */