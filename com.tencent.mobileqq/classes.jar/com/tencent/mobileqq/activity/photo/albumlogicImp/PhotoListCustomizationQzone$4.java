package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import java.util.Map;

class PhotoListCustomizationQzone$4
  implements Runnable
{
  PhotoListCustomizationQzone$4(PhotoListCustomizationQzone paramPhotoListCustomizationQzone, String paramString) {}
  
  public void run()
  {
    if ((PhotoListCustomizationQzone.c(this.this$0) != null) && (PhotoListCustomizationQzone.c(this.this$0).a != null) && (!PhotoListCustomizationQzone.d(this.this$0).isFinishing()))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      String str = QQAlbumUtils.b(this.a);
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("SRC_SAVE_PATH", this.a);
      ((Bundle)localObject).putString("DES_SAVE_PATH", str);
      localMessage.setData((Bundle)localObject);
      localObject = new LocalMediaInfo();
      QQAlbumUtils.a((LocalMediaInfo)localObject, str);
      PhotoListBaseData.a.put(str, localObject);
      PhotoListCustomizationQzone.d(this.this$0).a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.4
 * JD-Core Version:    0.7.0.1
 */