import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqnd
  implements View.OnClickListener
{
  public aqnd(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.isShowing()))
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnd
 * JD-Core Version:    0.7.0.1
 */