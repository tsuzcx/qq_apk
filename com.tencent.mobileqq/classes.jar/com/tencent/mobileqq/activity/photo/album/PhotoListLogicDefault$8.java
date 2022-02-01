package com.tencent.mobileqq.activity.photo.album;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.util.QZLog;

class PhotoListLogicDefault$8
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  PhotoListLogicDefault$8(PhotoListLogicDefault paramPhotoListLogicDefault, long paramLong, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      QZLog.d("PhotoListActivity", 2, new Object[] { "encode video cost time = ", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
      ThreadManager.postImmediately(new PhotoListLogicDefault.8.1(this), null, true);
      return;
    }
    paramString1 = Message.obtain();
    paramString1.what = 2;
    paramString1.obj = Integer.valueOf(paramInt);
    ((NewPhotoListActivity)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListLogicDefault.mActivity).a.sendMessage(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.8
 * JD-Core Version:    0.7.0.1
 */