import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bnoh
  implements View.OnClickListener
{
  bnoh(bnod parambnod, bnol parambnol, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    bnod.a(this.jdField_a_of_type_Bnod, this.jdField_a_of_type_Bnol.a, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoh
 * JD-Core Version:    0.7.0.1
 */