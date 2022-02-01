import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqkb
  implements View.OnClickListener
{
  public aqkb(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    aqkd localaqkd = (aqkd)paramView.getTag();
    this.a.a(localaqkd.jdField_a_of_type_JavaLangString, localaqkd.b, localaqkd.jdField_a_of_type_Boolean);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkb
 * JD-Core Version:    0.7.0.1
 */