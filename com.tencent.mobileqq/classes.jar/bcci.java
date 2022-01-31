import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class bcci
  extends BroadcastReceiver
{
  bcci(bcch parambcch) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("callback");
    QLog.d("TroopReceiver", 4, paramContext);
    this.a.e(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcci
 * JD-Core Version:    0.7.0.1
 */