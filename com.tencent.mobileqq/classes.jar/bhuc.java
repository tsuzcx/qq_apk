import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bhuc
  extends BroadcastReceiver
{
  bhuc(bhty parambhty) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bhty.a(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuc
 * JD-Core Version:    0.7.0.1
 */