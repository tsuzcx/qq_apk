package com.tencent.mobileqq.activity.photo.album.logicImp;

import ajsn;
import android.os.Handler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;
import java.util.List;

public class PhotoListLogicQzone$2
  implements Runnable
{
  public PhotoListLogicQzone$2(ajsn paramajsn, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a);
    if (localArrayList != null)
    {
      int i = 0;
      if (i < localArrayList.size())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localArrayList.get(i);
        if ((localLocalMediaInfo.mediaWidth <= 0) || (localLocalMediaInfo.mediaHeight <= 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localLocalMediaInfo.mediaWidth / localLocalMediaInfo.mediaHeight == 2.0F) || (localLocalMediaInfo.mediaWidth / localLocalMediaInfo.mediaHeight >= 4.0F) || (localLocalMediaInfo.mediaHeight / localLocalMediaInfo.mediaWidth >= 4.0F)) {
            ajsn.a(this.this$0, localLocalMediaInfo);
          } else {
            localLocalMediaInfo.panoramaPhotoType = 3;
          }
        }
      }
    }
    if ((this.this$0.mActivity != null) && (((NewPhotoListActivity)this.this$0.mActivity).a != null)) {
      ((NewPhotoListActivity)this.this$0.mActivity).a.post(new PhotoListLogicQzone.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicQzone.2
 * JD-Core Version:    0.7.0.1
 */