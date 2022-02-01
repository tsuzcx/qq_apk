import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class blhl
  extends BroadcastReceiver
{
  blhl(blhj paramblhj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (blhj.a(this.a) != null))
    {
      blhj.a(this.a).dismiss();
      blhj.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     blhl
 * JD-Core Version:    0.7.0.1
 */