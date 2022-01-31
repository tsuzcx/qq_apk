import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class asxa
  extends BroadcastReceiver
{
  private final String jdField_a_of_type_JavaLangString = "reason";
  private final String b = "homekey";
  
  asxa(aswy paramaswy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoItemEventManager", 2, "onReceive ===>" + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      paramContext = aswy.a(this.jdField_a_of_type_Aswy).iterator();
      while (paramContext.hasNext()) {
        ((asxb)paramContext.next()).b(false);
      }
    }
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      paramContext = aswy.a(this.jdField_a_of_type_Aswy).iterator();
      while (paramContext.hasNext()) {
        ((asxb)paramContext.next()).b(true);
      }
    }
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      paramContext = aswy.a(this.jdField_a_of_type_Aswy).iterator();
      while (paramContext.hasNext()) {
        ((asxb)paramContext.next()).c(true);
      }
    }
    if ("tencent.av.v2q.StopVideoChat".equals(paramContext))
    {
      paramContext = aswy.a(this.jdField_a_of_type_Aswy).iterator();
      while (paramContext.hasNext()) {
        ((asxb)paramContext.next()).c(false);
      }
    }
    if ("VolumeBtnDown".equals(paramIntent.getAction()))
    {
      paramContext = aswy.a(this.jdField_a_of_type_Aswy).iterator();
      while (paramContext.hasNext()) {
        ((asxb)paramContext.next()).i();
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
        paramContext = aswy.a(this.jdField_a_of_type_Aswy).iterator();
        while (paramContext.hasNext())
        {
          ((asxb)paramContext.next()).h();
          QLog.d("VideoItemEventManager", 2, "onReceive ===>homekey press");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxa
 * JD-Core Version:    0.7.0.1
 */