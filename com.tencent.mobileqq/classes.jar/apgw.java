import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apgw
  implements View.OnClickListener
{
  public apgw(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    apgz localapgz = (apgz)paramView.getTag();
    this.a.a(localapgz.jdField_a_of_type_JavaLangString, localapgz.b, localapgz.jdField_a_of_type_Boolean);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgw
 * JD-Core Version:    0.7.0.1
 */