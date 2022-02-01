import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class bmdc
  extends BroadcastReceiver
{
  bmdc(bmdb parambmdb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginRedTouchManager", 2, "Received red touch push");
    }
    bmdb.a(this.a);
    bmdb.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdc
 * JD-Core Version:    0.7.0.1
 */