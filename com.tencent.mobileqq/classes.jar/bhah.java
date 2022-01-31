import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bhah
  extends BroadcastReceiver
{
  final String jdField_a_of_type_JavaLangString = "reason";
  final String b = "globalactions";
  final String c = "recentapps";
  final String d = "homekey";
  
  bhah(bhag parambhag) {}
  
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
        bhag.a(this.jdField_a_of_type_Bhag).a(bool);
      }
      if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext))
      {
        paramIntent = paramIntent.getStringExtra("reason");
        if ((paramIntent != null) && (bhag.a(this.jdField_a_of_type_Bhag) != null))
        {
          if (!paramIntent.equals("homekey")) {
            break label113;
          }
          bhag.a(this.jdField_a_of_type_Bhag).a();
        }
      }
      while ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        bhag.a(this.jdField_a_of_type_Bhag).c();
        return;
        label113:
        if (paramIntent.equals("recentapps")) {
          bhag.a(this.jdField_a_of_type_Bhag).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhah
 * JD-Core Version:    0.7.0.1
 */