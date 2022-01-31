package com.tencent.mobileqq.activity.photo.album;

import aggg;
import aggm;
import android.os.Handler;
import android.os.Message;
import baaf;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.Map;
import mqq.util.WeakReference;

public class PhotoListLogicDefault$7
  implements Runnable
{
  public PhotoListLogicDefault$7(aggm paramaggm, String paramString) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    String str = ((NewPhotoListActivity)this.this$0.a.get()).a(this.a);
    localMessage.obj = str;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    baaf.a(localLocalMediaInfo, str);
    aggg.a.put(str, localLocalMediaInfo);
    ((NewPhotoListActivity)this.this$0.a.get()).a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.7
 * JD-Core Version:    0.7.0.1
 */