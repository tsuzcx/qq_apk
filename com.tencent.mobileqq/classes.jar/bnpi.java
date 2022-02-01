import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bnpi
  extends BroadcastReceiver
{
  bnpi(bnpe parambnpe) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bnpe.a(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpi
 * JD-Core Version:    0.7.0.1
 */