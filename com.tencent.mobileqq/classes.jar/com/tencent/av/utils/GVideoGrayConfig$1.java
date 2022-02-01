package com.tencent.av.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.app.GVideoObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.util.Map;

class GVideoGrayConfig$1
  extends GVideoObserver
{
  GVideoGrayConfig$1(GVideoGrayConfig paramGVideoGrayConfig) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong)
  {
    GVideoGrayConfig.GVideoGrayConfigListener localGVideoGrayConfigListener = (GVideoGrayConfig.GVideoGrayConfigListener)GVideoGrayConfig.a(this.a).a(paramLong);
    if (paramBoolean)
    {
      GVideoGrayConfig.a(this.a, SystemClock.elapsedRealtime());
      paramString2 = new GVideoGrayConfig.Record(SystemClock.elapsedRealtime(), paramInt3, paramString2, paramString3, paramString4);
      GVideoGrayConfig.a(this.a).put(paramString1, paramString2);
      if (localGVideoGrayConfigListener != null)
      {
        localGVideoGrayConfigListener.a(paramInt3, paramString2, paramInt5);
        GVideoGrayConfig.a(this.a).a(paramLong);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoGrayConfigListener is null");
      }
    }
    else
    {
      paramString1 = (GVideoGrayConfig.GVideoGrayConfigListener)GVideoGrayConfig.a(this.a).a(paramLong);
      if (paramString1 != null)
      {
        paramString1.a(-1, null, paramInt5);
        GVideoGrayConfig.a(this.a).a(paramLong);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoGrayConfigListener is null");
      }
    }
    paramString1 = this.a;
    paramString1.a = paramInt4;
    if (GVideoGrayConfig.a(paramString1) != null)
    {
      GVideoGrayConfig.a(this.a).a(paramInt4);
      GVideoGrayConfig.a(this.a, null);
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoPreDownloadListener is null");
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGetTroopHideWebConfig record gVideoStrategy:");
      paramString1.append(paramInt3);
      paramString1.append(" isSucc:");
      paramString1.append(paramBoolean);
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GVideoGrayConfig.1
 * JD-Core Version:    0.7.0.1
 */