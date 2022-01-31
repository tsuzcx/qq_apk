import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bexi
  extends BroadcastReceiver
{
  final String jdField_a_of_type_JavaLangString = "reason";
  final String b = "globalactions";
  final String c = "recentapps";
  final String d = "homekey";
  
  bexi(bexh parambexh) {}
  
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
        bexh.a(this.jdField_a_of_type_Bexh).a(bool);
      }
      if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext))
      {
        paramIntent = paramIntent.getStringExtra("reason");
        if ((paramIntent != null) && (bexh.a(this.jdField_a_of_type_Bexh) != null))
        {
          if (!paramIntent.equals("homekey")) {
            break label113;
          }
          bexh.a(this.jdField_a_of_type_Bexh).a();
        }
      }
      while ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        bexh.a(this.jdField_a_of_type_Bexh).c();
        return;
        label113:
        if (paramIntent.equals("recentapps")) {
          bexh.a(this.jdField_a_of_type_Bexh).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexi
 * JD-Core Version:    0.7.0.1
 */