package com.tencent.mobileqq.activity.photo.album;

import agsb;
import agsh;
import android.os.Handler;
import android.os.Message;
import bbbx;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.Map;
import mqq.util.WeakReference;

public class PhotoListLogicBase$1
  implements Runnable
{
  public PhotoListLogicBase$1(agsh paramagsh, String paramString) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    String str = ((NewPhotoListActivity)this.this$0.a.get()).a(this.a);
    localMessage.obj = str;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    bbbx.a(localLocalMediaInfo, str);
    agsb.a.put(str, localLocalMediaInfo);
    ((NewPhotoListActivity)this.this$0.a.get()).a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase.1
 * JD-Core Version:    0.7.0.1
 */