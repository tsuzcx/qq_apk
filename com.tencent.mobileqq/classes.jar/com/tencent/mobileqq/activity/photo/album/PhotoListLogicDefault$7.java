package com.tencent.mobileqq.activity.photo.album;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.AlbumUtil;
import java.util.Map;

class PhotoListLogicDefault$7
  implements Runnable
{
  PhotoListLogicDefault$7(PhotoListLogicDefault paramPhotoListLogicDefault, String paramString) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    Object localObject = (NewPhotoListActivity)this.this$0.mActivity;
    localObject = NewPhotoListActivity.a(this.a);
    localMessage.obj = localObject;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    AlbumUtil.a(localLocalMediaInfo, (String)localObject);
    PhotoListBaseData.newCaptureMediaInfo.put(localObject, localLocalMediaInfo);
    ((NewPhotoListActivity)this.this$0.mActivity).a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.7
 * JD-Core Version:    0.7.0.1
 */