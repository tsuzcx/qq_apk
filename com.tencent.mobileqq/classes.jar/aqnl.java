import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqnl
  implements View.OnClickListener
{
  public aqnl(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    aqno localaqno = (aqno)paramView.getTag();
    this.a.a(localaqno.jdField_a_of_type_JavaLangString, localaqno.b, localaqno.jdField_a_of_type_Boolean);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnl
 * JD-Core Version:    0.7.0.1
 */