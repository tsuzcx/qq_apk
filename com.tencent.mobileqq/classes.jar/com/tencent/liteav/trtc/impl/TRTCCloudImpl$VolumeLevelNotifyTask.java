package com.tencent.liteav.trtc.impl;

import android.os.Handler;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class TRTCCloudImpl$VolumeLevelNotifyTask
  implements Runnable
{
  private WeakReference<TRTCCloudImpl> mWeakTRTCEngine;
  
  TRTCCloudImpl$VolumeLevelNotifyTask(TRTCCloudImpl paramTRTCCloudImpl)
  {
    this.mWeakTRTCEngine = new WeakReference(paramTRTCCloudImpl);
  }
  
  public void run()
  {
    Object localObject = this.mWeakTRTCEngine;
    if (localObject != null) {
      localObject = (TRTCCloudImpl)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (((TRTCCloudImpl)localObject).mCaptureAndEnc != null) {
        i = TXCAudioEngine.getInstance().getSoftwareCaptureVolumeLevel();
      }
      if (i > 0)
      {
        TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
        localTRTCVolumeInfo.userId = ((TRTCCloudImpl)localObject).mRoomInfo.userId;
        localTRTCVolumeInfo.volume = i;
        localArrayList.add(localTRTCVolumeInfo);
      }
      ((TRTCCloudImpl)localObject).mRoomInfo.forEachUser(new TRTCCloudImpl.VolumeLevelNotifyTask.1(this, localArrayList));
      i = TXCAudioEngine.getMixingPlayoutVolumeLevel();
      ((TRTCCloudImpl)localObject).runOnListenerThread(new TRTCCloudImpl.VolumeLevelNotifyTask.2(this, ((TRTCCloudImpl)localObject).mTRTCListener, localArrayList, i));
      if (((TRTCCloudImpl)localObject).mAudioVolumeEvalInterval > 0) {
        ((TRTCCloudImpl)localObject).mSDKHandler.postDelayed(TRTCCloudImpl.access$4800((TRTCCloudImpl)localObject), ((TRTCCloudImpl)localObject).mAudioVolumeEvalInterval);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.VolumeLevelNotifyTask
 * JD-Core Version:    0.7.0.1
 */