import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class bjhi
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private bjhi(bjhg parambjhg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
        break label40;
      }
      bjhg.a(this.jdField_a_of_type_Bjhg, true);
    }
    label40:
    while (!this.jdField_a_of_type_JavaLangString.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      return;
    }
    bjhg.b(this.jdField_a_of_type_Bjhg, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjhi
 * JD-Core Version:    0.7.0.1
 */