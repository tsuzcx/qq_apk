import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bmof
  extends BroadcastReceiver
{
  bmof(bmob parambmob) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bmob.a(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmof
 * JD-Core Version:    0.7.0.1
 */