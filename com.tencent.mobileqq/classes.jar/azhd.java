import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;

class azhd
  implements View.OnClickListener
{
  azhd(azgy paramazgy, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(View paramView)
  {
    bcef.b(null, "dc00898", "", "", "0X800B44D", "0X800B44D", 0, 0, "", "", "", "");
    try
    {
      azge.a(azeu.a(), true);
      azhh.a().a(true);
      if (!this.jdField_a_of_type_Boolean)
      {
        bcef.b(null, "dc00898", "", "", "0X800B44E", "0X800B44E", 1, 0, "", "", "", "");
        this.jdField_a_of_type_Azgy.jdField_a_of_type_MqqAppAppActivity.requestPermissions(new azhe(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
      }
      if (!this.b)
      {
        bcef.b(null, "dc00898", "", "", "0X800B44E", "0X800B44E", 2, 0, "", "", "", "");
        FloatingScreenPermission.requestPermission(this.jdField_a_of_type_Azgy.jdField_a_of_type_MqqAppAppActivity);
      }
      this.jdField_a_of_type_Azgy.jdField_a_of_type_Int = -1;
      if ((!this.b) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Azgy.c = true;
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        azeu.a("HelloQQWake", "QQAssistantGuider cardHandler.setQQAssistantSwitch:" + localException.getMessage());
        continue;
        this.jdField_a_of_type_Azgy.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhd
 * JD-Core Version:    0.7.0.1
 */