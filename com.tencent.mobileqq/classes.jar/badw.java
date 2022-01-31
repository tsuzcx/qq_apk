import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class badw
  extends BroadcastReceiver
{
  badw(badv parambadv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("callback");
    QLog.d("TroopReceiver", 4, paramContext);
    this.a.e(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badw
 * JD-Core Version:    0.7.0.1
 */