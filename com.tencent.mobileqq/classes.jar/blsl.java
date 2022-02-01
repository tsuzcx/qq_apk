import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class blsl
  extends BroadcastReceiver
{
  blsl(blsk paramblsk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginRedTouchManager", 2, "Received red touch push");
    }
    blsk.a(this.a);
    blsk.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsl
 * JD-Core Version:    0.7.0.1
 */