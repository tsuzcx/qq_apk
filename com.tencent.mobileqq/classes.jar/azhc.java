import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azhc
  implements View.OnClickListener
{
  azhc(azgy paramazgy) {}
  
  public void onClick(View paramView)
  {
    bcef.b(null, "dc00898", "", "", "0X800B44D", "0X800B44D", 0, 0, "", "", "", "");
    this.a.a = -1;
    this.a.dismiss();
    try
    {
      azge.a(azeu.a(), true);
      azhh.a().a(true);
      azhh.a().a("QQAssistantGuider");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        azeu.a("HelloQQWake", "QQAssistantGuider cardHandler.setQQAssistantSwitch:" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhc
 * JD-Core Version:    0.7.0.1
 */