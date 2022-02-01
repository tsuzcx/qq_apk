import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bltz
  implements View.OnClickListener
{
  bltz(bltv parambltv, blud paramblud, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    bltv.a(this.jdField_a_of_type_Bltv, this.jdField_a_of_type_Blud.a, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltz
 * JD-Core Version:    0.7.0.1
 */