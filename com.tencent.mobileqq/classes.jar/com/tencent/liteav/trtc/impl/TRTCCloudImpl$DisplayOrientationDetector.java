package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

class TRTCCloudImpl$DisplayOrientationDetector
  extends OrientationEventListener
{
  public int mCurOrientation = -1;
  private int mCurrentDisplayRotation = 0;
  private WeakReference<TRTCCloudImpl> mTRTCEngine;
  
  TRTCCloudImpl$DisplayOrientationDetector(Context paramContext, TRTCCloudImpl paramTRTCCloudImpl)
  {
    super(paramContext);
    this.mTRTCEngine = new WeakReference(paramTRTCCloudImpl);
  }
  
  public void checkOrientation()
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mTRTCEngine.get();
    if (localTRTCCloudImpl != null)
    {
      int i = TRTCCloudImpl.access$9600(localTRTCCloudImpl);
      if (this.mCurrentDisplayRotation != i)
      {
        this.mCurrentDisplayRotation = i;
        TRTCCloudImpl.access$9700(localTRTCCloudImpl, this.mCurOrientation);
      }
    }
  }
  
  public void onOrientationChanged(int paramInt)
  {
    Object localObject;
    if (paramInt == -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("rotation-change invalid ");
      ((StringBuilder)localObject).append(paramInt);
      TXCLog.i("DisplayOrientationDetector", ((StringBuilder)localObject).toString());
      return;
    }
    int i = 1;
    if (paramInt > 45) {
      if (paramInt <= 135) {
        i = 2;
      } else if (paramInt <= 225) {
        i = 3;
      } else if (paramInt <= 315) {
        i = 0;
      }
    }
    if (this.mCurOrientation != i)
    {
      this.mCurOrientation = i;
      localObject = (TRTCCloudImpl)this.mTRTCEngine.get();
      if (localObject != null)
      {
        this.mCurrentDisplayRotation = TRTCCloudImpl.access$9600((TRTCCloudImpl)localObject);
        TRTCCloudImpl.access$9700((TRTCCloudImpl)localObject, this.mCurOrientation);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rotation-change onOrientationChanged ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", orientation ");
      localStringBuilder.append(this.mCurOrientation);
      localStringBuilder.append(" self:");
      if (localObject != null) {
        localObject = Integer.valueOf(localObject.hashCode());
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      TXCLog.d("DisplayOrientationDetector", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.DisplayOrientationDetector
 * JD-Core Version:    0.7.0.1
 */