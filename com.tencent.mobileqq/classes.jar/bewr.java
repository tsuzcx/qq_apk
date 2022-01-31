import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bewr
  extends BroadcastReceiver
{
  final String jdField_a_of_type_JavaLangString = "reason";
  final String b = "globalactions";
  final String c = "recentapps";
  final String d = "homekey";
  
  bewr(bewq parambewq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getAction();
      if ("action.qq.miniapp.show.monitorview".equals(paramContext))
      {
        boolean bool = paramIntent.getBooleanExtra("show", true);
        bewq.a(this.jdField_a_of_type_Bewq).a(bool);
      }
      if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext))
      {
        paramIntent = paramIntent.getStringExtra("reason");
        if ((paramIntent != null) && (bewq.a(this.jdField_a_of_type_Bewq) != null))
        {
          if (!paramIntent.equals("homekey")) {
            break label113;
          }
          bewq.a(this.jdField_a_of_type_Bewq).a();
        }
      }
      while ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        bewq.a(this.jdField_a_of_type_Bewq).c();
        return;
        label113:
        if (paramIntent.equals("recentapps")) {
          bewq.a(this.jdField_a_of_type_Bewq).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewr
 * JD-Core Version:    0.7.0.1
 */