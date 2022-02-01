import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bank
  implements View.OnClickListener
{
  bank(bang parambang) {}
  
  public void onClick(View paramView)
  {
    bdla.b(null, "dc00898", "", "", "0X800B44D", "0X800B44D", 1, 0, "", "", "", "");
    this.a.a = -1;
    this.a.dismiss();
    try
    {
      balv.a(bakl.a(), true);
      banp.a().a(true);
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
 * Qualified Name:     bank
 * JD-Core Version:    0.7.0.1
 */