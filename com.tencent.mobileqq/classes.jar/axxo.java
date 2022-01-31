import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class axxo
  implements azwa
{
  axxo(axxn paramaxxn) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!axxn.a(this.a)) {
      return;
    }
    if (!axxn.b(this.a))
    {
      axxn.a(this.a, paramLong);
      axxn.a(this.a, paramDouble);
      axxn.b(this.a, ajou.a.a);
      if (axxn.a(this.a) > axxn.b(this.a))
      {
        if (!axxn.c(this.a))
        {
          axxn.a(this.a);
          if (axxn.b(this.a) >= axxn.c(this.a))
          {
            axxn.a(this.a, true);
            axxn.b(this.a, 0L);
          }
        }
        if (axxn.c(this.a) >= axxn.d(this.a)) {
          break label502;
        }
        if (!axxn.d(this.a))
        {
          axxn.d(this.a);
          if (axxn.e(this.a) >= axxn.c(this.a))
          {
            axxn.b(this.a, true);
            axxn.c(this.a, 0L);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (((!axxn.d(this.a)) || (!axxn.c(this.a))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(axxn.f(this.a));
        ((StringBuilder)localObject).append(",mCurFPS=").append(axxn.a(this.a));
        ((StringBuilder)localObject).append(",mCurCPU=").append(axxn.c(this.a));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(axxn.b(this.a));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(axxn.e(this.a));
        ((StringBuilder)localObject).append(",mFPSReady=").append(axxn.c(this.a));
        ((StringBuilder)localObject).append(",mCPUReady=").append(axxn.d(this.a));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      axxn.a(this.a).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
      if ((axxn.d(this.a)) && (axxn.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", axxn.a(this.a));
        localBundle.putDouble("CPU", axxn.c(this.a));
        ((Message)localObject).obj = localBundle;
        axxn.a(this.a).sendMessage((Message)localObject);
      }
      axxn.a(this.a, false);
      axxn.b(this.a, 0L);
      break;
      label502:
      if ((axxn.d(this.a)) && (axxn.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", axxn.a(this.a));
        localBundle.putDouble("CPU", axxn.c(this.a));
        ((Message)localObject).obj = localBundle;
        axxn.a(this.a).sendMessage((Message)localObject);
      }
      axxn.b(this.a, false);
      axxn.c(this.a, 0L);
      continue;
      axxn.b(this.a, true);
      axxn.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxo
 * JD-Core Version:    0.7.0.1
 */