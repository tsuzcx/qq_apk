package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.utils.AlbumUtil;
import java.util.Map;

class PhotoListLogicQzone$4
  implements Runnable
{
  PhotoListLogicQzone$4(PhotoListLogicQzone paramPhotoListLogicQzone, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.mActivity != null) && (((NewPhotoListActivity)this.this$0.mActivity).a != null) && (!((NewPhotoListActivity)this.this$0.mActivity).isFinishing()))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      String str = NewPhotoListActivity.a(this.a);
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("SRC_SAVE_PATH", this.a);
      ((Bundle)localObject).putString("DES_SAVE_PATH", str);
      localMessage.setData((Bundle)localObject);
      localObject = new LocalMediaInfo();
      AlbumUtil.a((LocalMediaInfo)localObject, str);
      PhotoListBaseData.newCaptureMediaInfo.put(str, localObject);
      ((NewPhotoListActivity)this.this$0.mActivity).a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicQzone.4
 * JD-Core Version:    0.7.0.1
 */