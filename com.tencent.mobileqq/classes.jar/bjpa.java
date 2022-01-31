import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;

class bjpa
  extends BroadcastReceiver
{
  bjpa(bjoz parambjoz) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.a.a();
    if ((paramContext == null) || (paramContext.isFinishing())) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LightWeightCameraCaptureUnit", 2, "receive ACTION_START_VIDEO_CHAT.");
          }
          this.a.h();
          return;
        }
      } while (!"tencent.qq.ipc.event".equals(paramContext));
      paramContext = paramIntent.getExtras();
      if (paramContext != null)
      {
        AIOLongCaptureCtrl.a(paramContext);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LightWeightCameraCaptureUnit", 2, "receive ACTION_START_IPC_EVENT. extras=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjpa
 * JD-Core Version:    0.7.0.1
 */