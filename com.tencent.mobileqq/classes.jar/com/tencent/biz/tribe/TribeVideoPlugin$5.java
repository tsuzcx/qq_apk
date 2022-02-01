package com.tencent.biz.tribe;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

class TribeVideoPlugin$5
  implements ISPlayerVideoView.IVideoViewCallBack
{
  TribeVideoPlugin$5(TribeVideoPlugin paramTribeVideoPlugin) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceDestory");
    }
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceDestory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin.5
 * JD-Core Version:    0.7.0.1
 */