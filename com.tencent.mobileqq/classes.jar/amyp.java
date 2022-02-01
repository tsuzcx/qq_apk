import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class amyp
  extends BroadcastReceiver
{
  amyp(amyo paramamyo) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (amyo.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (amyo.a(this.a))
          {
            amyo.a(this.a).runRenderTask(amyo.a(this.a));
            return;
          }
          amyo.a(this.a);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!amyo.a(this.a)) {
        break;
      }
    } while (amyo.a(this.a) == null);
    amyo.a(this.a).runRenderTask(amyo.b(this.a));
    return;
    amyo.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyp
 * JD-Core Version:    0.7.0.1
 */