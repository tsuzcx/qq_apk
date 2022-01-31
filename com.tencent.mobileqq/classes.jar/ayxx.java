import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ayxx
  implements baxs
{
  ayxx(ayxw paramayxw) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!ayxw.a(this.a)) {
      return;
    }
    if (!ayxw.b(this.a))
    {
      ayxw.a(this.a, paramLong);
      ayxw.a(this.a, paramDouble);
      ayxw.b(this.a, akdd.a.a);
      if (ayxw.a(this.a) > ayxw.b(this.a))
      {
        if (!ayxw.c(this.a))
        {
          ayxw.a(this.a);
          if (ayxw.b(this.a) >= ayxw.c(this.a))
          {
            ayxw.a(this.a, true);
            ayxw.b(this.a, 0L);
          }
        }
        if (ayxw.c(this.a) >= ayxw.d(this.a)) {
          break label502;
        }
        if (!ayxw.d(this.a))
        {
          ayxw.d(this.a);
          if (ayxw.e(this.a) >= ayxw.c(this.a))
          {
            ayxw.b(this.a, true);
            ayxw.c(this.a, 0L);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (((!ayxw.d(this.a)) || (!ayxw.c(this.a))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(ayxw.f(this.a));
        ((StringBuilder)localObject).append(",mCurFPS=").append(ayxw.a(this.a));
        ((StringBuilder)localObject).append(",mCurCPU=").append(ayxw.c(this.a));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(ayxw.b(this.a));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(ayxw.e(this.a));
        ((StringBuilder)localObject).append(",mFPSReady=").append(ayxw.c(this.a));
        ((StringBuilder)localObject).append(",mCPUReady=").append(ayxw.d(this.a));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      ayxw.a(this.a).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
      if ((ayxw.d(this.a)) && (ayxw.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", ayxw.a(this.a));
        localBundle.putDouble("CPU", ayxw.c(this.a));
        ((Message)localObject).obj = localBundle;
        ayxw.a(this.a).sendMessage((Message)localObject);
      }
      ayxw.a(this.a, false);
      ayxw.b(this.a, 0L);
      break;
      label502:
      if ((ayxw.d(this.a)) && (ayxw.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", ayxw.a(this.a));
        localBundle.putDouble("CPU", ayxw.c(this.a));
        ((Message)localObject).obj = localBundle;
        ayxw.a(this.a).sendMessage((Message)localObject);
      }
      ayxw.b(this.a, false);
      ayxw.c(this.a, 0L);
      continue;
      ayxw.b(this.a, true);
      ayxw.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxx
 * JD-Core Version:    0.7.0.1
 */