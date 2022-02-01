import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.theme.TextHook;

class bhqn
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("isFont", false)) {
      TextHook.getInstance().checkTypeface(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqn
 * JD-Core Version:    0.7.0.1
 */