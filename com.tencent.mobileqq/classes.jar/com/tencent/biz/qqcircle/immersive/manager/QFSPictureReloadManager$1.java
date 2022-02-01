package com.tencent.biz.qqcircle.immersive.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import java.util.concurrent.ConcurrentHashMap;

class QFSPictureReloadManager$1
  extends QCirclePicStateListener
{
  QFSPictureReloadManager$1(QFSPictureReloadManager paramQFSPictureReloadManager) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    if ((paramInt != 6) && (paramInt != 3)) {
      return;
    }
    if ((QFSPictureReloadManager.a(this.a) != null) && (paramOption != null) && (!TextUtils.isEmpty(paramOption.getCacheKey()))) {
      QFSPictureReloadManager.a(this.a).put(paramOption.getCacheKey(), Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.manager.QFSPictureReloadManager.1
 * JD-Core Version:    0.7.0.1
 */