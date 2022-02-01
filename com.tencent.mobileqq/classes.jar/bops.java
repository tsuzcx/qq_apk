import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bops
  implements View.OnClickListener
{
  bops(bopo parambopo, bopw parambopw, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    bopo.a(this.jdField_a_of_type_Bopo, this.jdField_a_of_type_Bopw.a, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bops
 * JD-Core Version:    0.7.0.1
 */