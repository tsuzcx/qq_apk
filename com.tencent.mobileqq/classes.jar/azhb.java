import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azhb
  implements View.OnClickListener
{
  azhb(azgy paramazgy) {}
  
  public void onClick(View paramView)
  {
    bcef.b(null, "dc00898", "", "", "0X800B44C", "0X800B44C", 0, 0, "", "", "", "");
    try
    {
      azge.a(azeu.a(), false);
      azhh.a().a(false);
      this.a.a = -1;
      this.a.dismiss();
      QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131694842), 1).a();
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
 * Qualified Name:     azhb
 * JD-Core Version:    0.7.0.1
 */