import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bavw
  implements bcwm
{
  bavw(bavv parambavv) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!bavv.a(this.a)) {
      return;
    }
    if (!bavv.b(this.a))
    {
      bavv.a(this.a, paramLong);
      bavv.a(this.a, paramDouble);
      bavv.b(this.a, alus.a.a);
      if (bavv.a(this.a) > bavv.b(this.a))
      {
        if (!bavv.c(this.a))
        {
          bavv.a(this.a);
          if (bavv.b(this.a) >= bavv.c(this.a))
          {
            bavv.a(this.a, true);
            bavv.b(this.a, 0L);
          }
        }
        if (bavv.c(this.a) >= bavv.d(this.a)) {
          break label502;
        }
        if (!bavv.d(this.a))
        {
          bavv.d(this.a);
          if (bavv.e(this.a) >= bavv.c(this.a))
          {
            bavv.b(this.a, true);
            bavv.c(this.a, 0L);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (((!bavv.d(this.a)) || (!bavv.c(this.a))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(bavv.f(this.a));
        ((StringBuilder)localObject).append(",mCurFPS=").append(bavv.a(this.a));
        ((StringBuilder)localObject).append(",mCurCPU=").append(bavv.c(this.a));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(bavv.b(this.a));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(bavv.e(this.a));
        ((StringBuilder)localObject).append(",mFPSReady=").append(bavv.c(this.a));
        ((StringBuilder)localObject).append(",mCPUReady=").append(bavv.d(this.a));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      bavv.a(this.a).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
      if ((bavv.d(this.a)) && (bavv.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", bavv.a(this.a));
        localBundle.putDouble("CPU", bavv.c(this.a));
        ((Message)localObject).obj = localBundle;
        bavv.a(this.a).sendMessage((Message)localObject);
      }
      bavv.a(this.a, false);
      bavv.b(this.a, 0L);
      break;
      label502:
      if ((bavv.d(this.a)) && (bavv.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", bavv.a(this.a));
        localBundle.putDouble("CPU", bavv.c(this.a));
        ((Message)localObject).obj = localBundle;
        bavv.a(this.a).sendMessage((Message)localObject);
      }
      bavv.b(this.a, false);
      bavv.c(this.a, 0L);
      continue;
      bavv.b(this.a, true);
      bavv.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavw
 * JD-Core Version:    0.7.0.1
 */