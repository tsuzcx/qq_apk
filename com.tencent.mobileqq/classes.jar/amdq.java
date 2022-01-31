import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cooperation.qzone.WatchActivityManager;

public class amdq
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private amdq(WatchActivityManager paramWatchActivityManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
        break label40;
      }
      WatchActivityManager.a(this.jdField_a_of_type_CooperationQzoneWatchActivityManager, true);
    }
    label40:
    while (!this.jdField_a_of_type_JavaLangString.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      return;
    }
    WatchActivityManager.b(this.jdField_a_of_type_CooperationQzoneWatchActivityManager, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdq
 * JD-Core Version:    0.7.0.1
 */