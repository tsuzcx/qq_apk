import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class bikd
  extends BroadcastReceiver
{
  bikd(bikc parambikc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginRedTouchManager", 2, "Received red touch push");
    }
    bikc.a(this.a);
    bikc.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bikd
 * JD-Core Version:    0.7.0.1
 */