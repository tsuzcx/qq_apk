package com.tencent.device.msg.activities;

import ahtt;
import ahtz;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.Utils;
import xuu;

public class DevLittleVideoItemBuilder$1
  implements Runnable
{
  public DevLittleVideoItemBuilder$1(xuu paramxuu, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    Object localObject = xuu.a(this.this$0, this.a);
    xuu.a(this.this$0, this.a);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ahtz localahtz = new ahtz(this.a.mThumbFilePath, this.a.thumbMD5, null, this.a.thumbWidth, this.a.thumbHeight);
      localObject = new ahtt(this.this$0.a, (String)localObject, this.a.mediacodecEncode, localahtz);
      ((ahtt)localObject).a(xuu.a(this.this$0));
      ((ahtt)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */