import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.qphone.base.util.QLog;

public class amit
  extends alrl
{
  private amit(UpdateDiscuss paramUpdateDiscuss) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "updateDiscussionList: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(6);
      return;
    }
    this.a.a.a.edit().putBoolean("isDiscussionlistok", true).commit();
    this.a.a.notifyUI(3, true, Integer.valueOf(3));
    this.a.a(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amit
 * JD-Core Version:    0.7.0.1
 */