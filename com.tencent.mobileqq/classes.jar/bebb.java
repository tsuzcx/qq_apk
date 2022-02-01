import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bebb
  implements bggu
{
  bebb(beba parambeba) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!beba.a(this.a)) {
      return;
    }
    if (!beba.b(this.a))
    {
      beba.a(this.a, paramLong);
      beba.a(this.a, paramDouble);
      beba.b(this.a, anro.a.a);
      if (beba.a(this.a) > beba.b(this.a))
      {
        if (!beba.c(this.a))
        {
          beba.a(this.a);
          if (beba.b(this.a) >= beba.c(this.a))
          {
            beba.a(this.a, true);
            beba.b(this.a, 0L);
          }
        }
        if (beba.c(this.a) >= beba.d(this.a)) {
          break label502;
        }
        if (!beba.d(this.a))
        {
          beba.d(this.a);
          if (beba.e(this.a) >= beba.c(this.a))
          {
            beba.b(this.a, true);
            beba.c(this.a, 0L);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (((!beba.d(this.a)) || (!beba.c(this.a))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(beba.f(this.a));
        ((StringBuilder)localObject).append(",mCurFPS=").append(beba.a(this.a));
        ((StringBuilder)localObject).append(",mCurCPU=").append(beba.c(this.a));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(beba.b(this.a));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(beba.e(this.a));
        ((StringBuilder)localObject).append(",mFPSReady=").append(beba.c(this.a));
        ((StringBuilder)localObject).append(",mCPUReady=").append(beba.d(this.a));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      beba.a(this.a).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
      if ((beba.d(this.a)) && (beba.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", beba.a(this.a));
        localBundle.putDouble("CPU", beba.c(this.a));
        ((Message)localObject).obj = localBundle;
        beba.a(this.a).sendMessage((Message)localObject);
      }
      beba.a(this.a, false);
      beba.b(this.a, 0L);
      break;
      label502:
      if ((beba.d(this.a)) && (beba.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", beba.a(this.a));
        localBundle.putDouble("CPU", beba.c(this.a));
        ((Message)localObject).obj = localBundle;
        beba.a(this.a).sendMessage((Message)localObject);
      }
      beba.b(this.a, false);
      beba.c(this.a, 0L);
      continue;
      beba.b(this.a, true);
      beba.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebb
 * JD-Core Version:    0.7.0.1
 */