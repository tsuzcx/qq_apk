package com.tencent.mobileqq.activity.photo.album;

import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import cooperation.qzone.util.QZLog;

class PhotoListCustomizationDefault$3
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  PhotoListCustomizationDefault$3(PhotoListCustomizationDefault paramPhotoListCustomizationDefault, long paramLong, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      QZLog.d("QQAlbum", 2, new Object[] { "encode video cost time = ", Long.valueOf(System.currentTimeMillis() - this.a) });
      ThreadManager.postImmediately(new PhotoListCustomizationDefault.3.1(this), null, true);
      return;
    }
    paramString1 = Message.obtain();
    paramString1.what = 2;
    paramString1.obj = Integer.valueOf(paramInt);
    this.e.b.u.sendMessage(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.3
 * JD-Core Version:    0.7.0.1
 */