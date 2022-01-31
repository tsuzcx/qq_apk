import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.QQComicRedTouchManager;

public class amkn
  extends BroadcastReceiver
{
  public amkn(QQComicRedTouchManager paramQQComicRedTouchManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginRedTouchManager", 2, "Received red touch push");
    }
    QQComicRedTouchManager.a(this.a);
    QQComicRedTouchManager.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkn
 * JD-Core Version:    0.7.0.1
 */