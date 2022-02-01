import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class amrl
  extends BroadcastReceiver
{
  amrl(amrk paramamrk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (amrk.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (amrk.a(this.a))
          {
            amrk.a(this.a).runRenderTask(amrk.a(this.a));
            return;
          }
          amrk.a(this.a);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!amrk.a(this.a)) {
        break;
      }
    } while (amrk.a(this.a) == null);
    amrk.a(this.a).runRenderTask(amrk.b(this.a));
    return;
    amrk.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrl
 * JD-Core Version:    0.7.0.1
 */