import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bnid
  implements View.OnClickListener
{
  bnid(bnhy parambnhy, bnih parambnih, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    bnhy.a(this.jdField_a_of_type_Bnhy, this.jdField_a_of_type_Bnih.a, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnid
 * JD-Core Version:    0.7.0.1
 */