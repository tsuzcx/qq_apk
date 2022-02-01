package com.tencent.mobileqq.activity.photo.album;

import akmj;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.AlbumUtil;
import java.util.Map;

public class PhotoListLogicDefault$7
  implements Runnable
{
  public PhotoListLogicDefault$7(akmj paramakmj, String paramString) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    String str = ((NewPhotoListActivity)this.this$0.mActivity).a(this.a);
    localMessage.obj = str;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    AlbumUtil.getMediaInfo(localLocalMediaInfo, str);
    PhotoListBaseData.newCaptureMediaInfo.put(str, localLocalMediaInfo);
    ((NewPhotoListActivity)this.this$0.mActivity).a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.7
 * JD-Core Version:    0.7.0.1
 */