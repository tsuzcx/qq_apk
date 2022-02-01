import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apzm
  implements View.OnClickListener
{
  public apzm(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    apzo localapzo = (apzo)paramView.getTag();
    this.a.a(localapzo.jdField_a_of_type_JavaLangString, localapzo.b, localapzo.jdField_a_of_type_Boolean);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzm
 * JD-Core Version:    0.7.0.1
 */