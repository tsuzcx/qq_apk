import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class aszt
  extends BroadcastReceiver
{
  aszt(aszr paramaszr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("command_type", 0);
    QLog.i("GroupVideoManager|Communicate", 2, "get message from plugin: " + paramIntent.getExtras());
    switch (i)
    {
    case 4: 
    default: 
      return;
    case 1: 
      aszr.a(this.a, paramIntent, aszr.a(this.a));
      return;
    case 2: 
      aszr.a(this.a, paramIntent, aszr.b(this.a));
      return;
    case 3: 
      aszr.a(this.a, paramIntent);
      return;
    }
    aszr.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszt
 * JD-Core Version:    0.7.0.1
 */