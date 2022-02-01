package com.tencent.mobileqq.app.soso;

import com.tencent.TMG.utils.QLog;
import java.util.Map;

final class LbsManagerService$1
  extends SosoInterface.OnLocationListener
{
  LbsManagerService$1(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, LbsManagerService.OnLocationChangeListener paramOnLocationChangeListener)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (LbsManagerService.access$000())
      {
        if (LbsManagerService.access$100().containsKey(this))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SOSO.LBS.LbsManagerService", 0, "onConsecutiveFailure reverseListenerMap contains. business id: " + this.tag + " fail count: " + paramInt2);
          }
          if (paramInt2 > 5)
          {
            localOnLocationChangeListener = (LbsManagerService.OnLocationChangeListener)LbsManagerService.access$100().remove(this);
            LbsManagerService.access$000().remove(localOnLocationChangeListener);
            if (paramInt2 > 5) {
              SosoInterface.removeOnLocationListener(this);
            }
            return;
          }
          LbsManagerService.OnLocationChangeListener localOnLocationChangeListener = (LbsManagerService.OnLocationChangeListener)LbsManagerService.access$100().get(this);
          if (paramInt2 == 5) {
            bool = true;
          }
          localOnLocationChangeListener.onConsecutiveFailure(paramInt1, paramInt2, bool);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "onConsecutiveFailure reverseListenerMap not contains. business id: " + this.tag + " fail count: " + paramInt2);
      }
    }
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    for (;;)
    {
      synchronized ()
      {
        if (LbsManagerService.access$100().containsKey(this))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SOSO.LBS.LbsManagerService", 0, "onLocationFinish reverseListenerMap contains. business id: " + this.tag);
          }
          if (this.goonListener)
          {
            localOnLocationChangeListener = (LbsManagerService.OnLocationChangeListener)LbsManagerService.access$100().get(this);
            if (localOnLocationChangeListener != null) {
              localOnLocationChangeListener.onLocationFinish(paramInt, LbsManagerService.access$200(paramSosoLbsInfo, this.val$listener.businessId));
            }
            return;
          }
          LbsManagerService.OnLocationChangeListener localOnLocationChangeListener = (LbsManagerService.OnLocationChangeListener)LbsManagerService.access$100().remove(this);
          LbsManagerService.access$000().remove(localOnLocationChangeListener);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "onLocationFinish reverseListenerMap not contains. business id: " + this.tag + " this is: " + this);
      }
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    synchronized ()
    {
      if (LbsManagerService.access$100().containsKey(this)) {
        ((LbsManagerService.OnLocationChangeListener)LbsManagerService.access$100().get(this)).onStatusUpdate(paramString1, paramInt, paramString2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsManagerService.1
 * JD-Core Version:    0.7.0.1
 */