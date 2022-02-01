import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.nearby.NearbyJsInterface;

public class axcq
  extends BroadcastReceiver
{
  public axcq(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a.tribePersonalDataModify();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axcq
 * JD-Core Version:    0.7.0.1
 */