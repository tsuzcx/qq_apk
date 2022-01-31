import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bbaf
  implements bdav
{
  bbaf(bbae parambbae) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!bbae.a(this.a)) {
      return;
    }
    if (!bbae.b(this.a))
    {
      bbae.a(this.a, paramLong);
      bbae.a(this.a, paramDouble);
      bbae.b(this.a, alzh.a.a);
      if (bbae.a(this.a) > bbae.b(this.a))
      {
        if (!bbae.c(this.a))
        {
          bbae.a(this.a);
          if (bbae.b(this.a) >= bbae.c(this.a))
          {
            bbae.a(this.a, true);
            bbae.b(this.a, 0L);
          }
        }
        if (bbae.c(this.a) >= bbae.d(this.a)) {
          break label502;
        }
        if (!bbae.d(this.a))
        {
          bbae.d(this.a);
          if (bbae.e(this.a) >= bbae.c(this.a))
          {
            bbae.b(this.a, true);
            bbae.c(this.a, 0L);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (((!bbae.d(this.a)) || (!bbae.c(this.a))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(bbae.f(this.a));
        ((StringBuilder)localObject).append(",mCurFPS=").append(bbae.a(this.a));
        ((StringBuilder)localObject).append(",mCurCPU=").append(bbae.c(this.a));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(bbae.b(this.a));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(bbae.e(this.a));
        ((StringBuilder)localObject).append(",mFPSReady=").append(bbae.c(this.a));
        ((StringBuilder)localObject).append(",mCPUReady=").append(bbae.d(this.a));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      bbae.a(this.a).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
      if ((bbae.d(this.a)) && (bbae.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", bbae.a(this.a));
        localBundle.putDouble("CPU", bbae.c(this.a));
        ((Message)localObject).obj = localBundle;
        bbae.a(this.a).sendMessage((Message)localObject);
      }
      bbae.a(this.a, false);
      bbae.b(this.a, 0L);
      break;
      label502:
      if ((bbae.d(this.a)) && (bbae.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", bbae.a(this.a));
        localBundle.putDouble("CPU", bbae.c(this.a));
        ((Message)localObject).obj = localBundle;
        bbae.a(this.a).sendMessage((Message)localObject);
      }
      bbae.b(this.a, false);
      bbae.c(this.a, 0L);
      continue;
      bbae.b(this.a, true);
      bbae.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaf
 * JD-Core Version:    0.7.0.1
 */