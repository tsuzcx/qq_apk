import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bfaa
  implements bhgv
{
  bfaa(bezz parambezz) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!bezz.a(this.a)) {
      return;
    }
    if (!bezz.b(this.a))
    {
      bezz.a(this.a, paramLong);
      bezz.a(this.a, paramDouble);
      bezz.b(this.a, aodu.a.a);
      if (bezz.a(this.a) > bezz.b(this.a))
      {
        if (!bezz.c(this.a))
        {
          bezz.a(this.a);
          if (bezz.b(this.a) >= bezz.c(this.a))
          {
            bezz.a(this.a, true);
            bezz.b(this.a, 0L);
          }
        }
        if (bezz.c(this.a) >= bezz.d(this.a)) {
          break label502;
        }
        if (!bezz.d(this.a))
        {
          bezz.d(this.a);
          if (bezz.e(this.a) >= bezz.c(this.a))
          {
            bezz.b(this.a, true);
            bezz.c(this.a, 0L);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (((!bezz.d(this.a)) || (!bezz.c(this.a))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(bezz.f(this.a));
        ((StringBuilder)localObject).append(",mCurFPS=").append(bezz.a(this.a));
        ((StringBuilder)localObject).append(",mCurCPU=").append(bezz.c(this.a));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(bezz.b(this.a));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(bezz.e(this.a));
        ((StringBuilder)localObject).append(",mFPSReady=").append(bezz.c(this.a));
        ((StringBuilder)localObject).append(",mCPUReady=").append(bezz.d(this.a));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      bezz.a(this.a).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
      if ((bezz.d(this.a)) && (bezz.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", bezz.a(this.a));
        localBundle.putDouble("CPU", bezz.c(this.a));
        ((Message)localObject).obj = localBundle;
        bezz.a(this.a).sendMessage((Message)localObject);
      }
      bezz.a(this.a, false);
      bezz.b(this.a, 0L);
      break;
      label502:
      if ((bezz.d(this.a)) && (bezz.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", bezz.a(this.a));
        localBundle.putDouble("CPU", bezz.c(this.a));
        ((Message)localObject).obj = localBundle;
        bezz.a(this.a).sendMessage((Message)localObject);
      }
      bezz.b(this.a, false);
      bezz.c(this.a, 0L);
      continue;
      bezz.b(this.a, true);
      bezz.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfaa
 * JD-Core Version:    0.7.0.1
 */