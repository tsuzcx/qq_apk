import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;

class banl
  implements View.OnClickListener
{
  banl(bang parambang, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(View paramView)
  {
    bdla.b(null, "dc00898", "", "", "0X800B44D", "0X800B44D", 2, 0, "", "", "", "");
    try
    {
      balv.a(bakl.a(), true);
      banp.a().a(true);
      if (!this.jdField_a_of_type_Boolean)
      {
        bdla.b(null, "dc00898", "", "", "0X800B44E", "0X800B44E", 1, 0, "", "", "", "");
        this.jdField_a_of_type_Bang.jdField_a_of_type_MqqAppAppActivity.requestPermissions(new banm(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
      }
      if (!this.b)
      {
        bdla.b(null, "dc00898", "", "", "0X800B44E", "0X800B44E", 2, 0, "", "", "", "");
        FloatingScreenPermission.requestPermission(this.jdField_a_of_type_Bang.jdField_a_of_type_MqqAppAppActivity);
      }
      this.jdField_a_of_type_Bang.jdField_a_of_type_Int = -1;
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bang.dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bakl.a("HelloQQWake", "QQAssistantGuider cardHandler.setQQAssistantSwitch:" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banl
 * JD-Core Version:    0.7.0.1
 */