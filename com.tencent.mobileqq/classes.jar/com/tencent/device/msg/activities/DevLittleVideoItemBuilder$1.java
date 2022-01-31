package com.tencent.device.msg.activities;

import ajxt;
import ajxz;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.Utils;
import zsn;

public class DevLittleVideoItemBuilder$1
  implements Runnable
{
  public DevLittleVideoItemBuilder$1(zsn paramzsn, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    Object localObject = zsn.a(this.this$0, this.a);
    zsn.a(this.this$0, this.a);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ajxz localajxz = new ajxz(this.a.mThumbFilePath, this.a.thumbMD5, null, this.a.thumbWidth, this.a.thumbHeight);
      localObject = new ajxt(this.this$0.a, (String)localObject, this.a.mediacodecEncode, localajxz);
      ((ajxt)localObject).a(zsn.a(this.this$0));
      ((ajxt)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */