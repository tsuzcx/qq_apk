import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class avpf
  extends BroadcastReceiver
{
  private final String jdField_a_of_type_JavaLangString = "reason";
  private final String b = "homekey";
  
  avpf(avpd paramavpd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoItemEventManager", 2, "onReceive ===>" + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      paramContext = avpd.a(this.jdField_a_of_type_Avpd).iterator();
      while (paramContext.hasNext()) {
        ((avpg)paramContext.next()).b(false);
      }
    }
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      paramContext = avpd.a(this.jdField_a_of_type_Avpd).iterator();
      while (paramContext.hasNext()) {
        ((avpg)paramContext.next()).b(true);
      }
    }
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      paramContext = avpd.a(this.jdField_a_of_type_Avpd).iterator();
      while (paramContext.hasNext()) {
        ((avpg)paramContext.next()).c(true);
      }
    }
    if ("tencent.av.v2q.StopVideoChat".equals(paramContext))
    {
      paramContext = avpd.a(this.jdField_a_of_type_Avpd).iterator();
      while (paramContext.hasNext()) {
        ((avpg)paramContext.next()).c(false);
      }
    }
    if ("VolumeBtnDown".equals(paramIntent.getAction()))
    {
      paramContext = avpd.a(this.jdField_a_of_type_Avpd).iterator();
      while (paramContext.hasNext()) {
        ((avpg)paramContext.next()).i();
      }
    }
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null) {
        break label294;
      }
    }
    for (;;)
    {
      return;
      label294:
      if (paramContext.equals("homekey"))
      {
        paramContext = avpd.a(this.jdField_a_of_type_Avpd).iterator();
        while (paramContext.hasNext())
        {
          ((avpg)paramContext.next()).h();
          QLog.d("VideoItemEventManager", 2, "onReceive ===>homekey press");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpf
 * JD-Core Version:    0.7.0.1
 */