import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qzone.util.QZLog;

class bmwb
  extends BroadcastReceiver
{
  bmwb(bmwa parambmwa) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = paramIntent.getAction();
      QZLog.i("BaseTranslucentControll", 4, "reveiver action = " + paramContext);
      this.a.a(paramIntent);
      return;
    }
    catch (Exception paramContext)
    {
      QZLog.e("BaseTranslucentControll", "onReceive error", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwb
 * JD-Core Version:    0.7.0.1
 */