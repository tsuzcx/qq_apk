import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class bmwq
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private bmwq(bmwo parambmwo) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
        break label40;
      }
      bmwo.a(this.jdField_a_of_type_Bmwo, true);
    }
    label40:
    while (!this.jdField_a_of_type_JavaLangString.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      return;
    }
    bmwo.b(this.jdField_a_of_type_Bmwo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwq
 * JD-Core Version:    0.7.0.1
 */