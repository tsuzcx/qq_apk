package com.tencent.mobileqq.activity.photo;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

class PhotoListActivity$21
  implements Runnable
{
  PhotoListActivity$21(PhotoListActivity paramPhotoListActivity, List paramList) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.a);
    if (localObject != null)
    {
      int i = 0;
      if (i < ((List)localObject).size())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((List)localObject).get(i);
        if ((localLocalMediaInfo.mediaWidth <= 0) || (localLocalMediaInfo.mediaHeight <= 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localLocalMediaInfo.mediaWidth / localLocalMediaInfo.mediaHeight == 2.0F) || (localLocalMediaInfo.mediaWidth / localLocalMediaInfo.mediaHeight >= 4.0F) || (localLocalMediaInfo.mediaHeight / localLocalMediaInfo.mediaWidth >= 4.0F)) {
            PhotoListActivity.b(this.this$0, localLocalMediaInfo);
          } else {
            localLocalMediaInfo.panoramaPhotoType = 3;
          }
        }
      }
    }
    if (this.this$0.a != null)
    {
      localObject = this.this$0.a.obtainMessage();
      ((Message)localObject).what = 4;
      this.this$0.a.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity.21
 * JD-Core Version:    0.7.0.1
 */