package com.tencent.aelight.camera.ae.album.logic;

import android.os.Handler;
import android.os.Message;
import com.tencent.aelight.camera.ae.album.fragment.AENewPhotoListFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper.VideoCompositeCallBack;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

class AEPhotoListLogicDefault$7
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      QZLog.d("QQAlbum", 2, new Object[] { "encode video cost time = ", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
      ThreadManager.postImmediately(new AEPhotoListLogicDefault.7.1(this), null, true);
      return;
    }
    paramString1 = Message.obtain();
    paramString1.what = 2;
    paramString1.obj = Integer.valueOf(paramInt);
    ((AENewPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicDefault.a.get()).a.sendMessage(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault.7
 * JD-Core Version:    0.7.0.1
 */