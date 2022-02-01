import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class anzy
  extends BroadcastReceiver
{
  anzy(anzx paramanzx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      int i;
      int j;
      do
      {
        do
        {
          return;
        } while ((!"tencent.businessnotify.qq.to.subprocess".equals(paramIntent.getAction())) || (paramIntent.getIntExtra("bussinessType", 0) != 2));
        switch (paramIntent.getIntExtra("event", 0))
        {
        default: 
          return;
        case 1: 
          paramContext = paramIntent.getStringExtra("bussinessSubName");
          i = paramIntent.getIntExtra("download_Index", 0);
          j = paramIntent.getIntExtra("download_Progress", 0);
          if (AudioHelper.f()) {
            QLog.w(this.a.c, 1, "receive notify, index[" + i + "], progress[" + j + "]");
          }
          break;
        }
      } while (this.a.a == null);
      this.a.a.b(paramContext, i, j);
      return;
      paramContext = paramIntent.getStringExtra("config_Content");
      this.a.b(paramContext);
    } while (this.a.a == null);
    this.a.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzy
 * JD-Core Version:    0.7.0.1
 */