import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ayxv
  implements baxe
{
  ayxv(ayxu paramayxu) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!ayxu.a(this.a)) {
      return;
    }
    if (!ayxu.b(this.a))
    {
      ayxu.a(this.a, paramLong);
      ayxu.a(this.a, paramDouble);
      ayxu.b(this.a, akde.a.a);
      if (ayxu.a(this.a) > ayxu.b(this.a))
      {
        if (!ayxu.c(this.a))
        {
          ayxu.a(this.a);
          if (ayxu.b(this.a) >= ayxu.c(this.a))
          {
            ayxu.a(this.a, true);
            ayxu.b(this.a, 0L);
          }
        }
        if (ayxu.c(this.a) >= ayxu.d(this.a)) {
          break label502;
        }
        if (!ayxu.d(this.a))
        {
          ayxu.d(this.a);
          if (ayxu.e(this.a) >= ayxu.c(this.a))
          {
            ayxu.b(this.a, true);
            ayxu.c(this.a, 0L);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (((!ayxu.d(this.a)) || (!ayxu.c(this.a))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(ayxu.f(this.a));
        ((StringBuilder)localObject).append(",mCurFPS=").append(ayxu.a(this.a));
        ((StringBuilder)localObject).append(",mCurCPU=").append(ayxu.c(this.a));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(ayxu.b(this.a));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(ayxu.e(this.a));
        ((StringBuilder)localObject).append(",mFPSReady=").append(ayxu.c(this.a));
        ((StringBuilder)localObject).append(",mCPUReady=").append(ayxu.d(this.a));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      ayxu.a(this.a).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
      if ((ayxu.d(this.a)) && (ayxu.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", ayxu.a(this.a));
        localBundle.putDouble("CPU", ayxu.c(this.a));
        ((Message)localObject).obj = localBundle;
        ayxu.a(this.a).sendMessage((Message)localObject);
      }
      ayxu.a(this.a, false);
      ayxu.b(this.a, 0L);
      break;
      label502:
      if ((ayxu.d(this.a)) && (ayxu.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", ayxu.a(this.a));
        localBundle.putDouble("CPU", ayxu.c(this.a));
        ((Message)localObject).obj = localBundle;
        ayxu.a(this.a).sendMessage((Message)localObject);
      }
      ayxu.b(this.a, false);
      ayxu.c(this.a, 0L);
      continue;
      ayxu.b(this.a, true);
      ayxu.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxv
 * JD-Core Version:    0.7.0.1
 */