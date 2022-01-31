import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

class auxx
  extends BroadcastReceiver
{
  auxx(auxs paramauxs) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("SmallScreenState", 0);
    if (i == 3) {
      this.a.a.setVisibility(4);
    }
    while ((i != 2) && (i != 0)) {
      return;
    }
    this.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auxx
 * JD-Core Version:    0.7.0.1
 */