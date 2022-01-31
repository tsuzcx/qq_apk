import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bgwa
  extends BroadcastReceiver
{
  final String jdField_a_of_type_JavaLangString = "reason";
  final String b = "globalactions";
  final String c = "recentapps";
  final String d = "homekey";
  
  bgwa(bgvz parambgvz) {}
  
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
        bgvz.a(this.jdField_a_of_type_Bgvz).a(bool);
      }
      if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext))
      {
        paramIntent = paramIntent.getStringExtra("reason");
        if ((paramIntent != null) && (bgvz.a(this.jdField_a_of_type_Bgvz) != null))
        {
          if (!paramIntent.equals("homekey")) {
            break label113;
          }
          bgvz.a(this.jdField_a_of_type_Bgvz).a();
        }
      }
      while ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        bgvz.a(this.jdField_a_of_type_Bgvz).c();
        return;
        label113:
        if (paramIntent.equals("recentapps")) {
          bgvz.a(this.jdField_a_of_type_Bgvz).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwa
 * JD-Core Version:    0.7.0.1
 */