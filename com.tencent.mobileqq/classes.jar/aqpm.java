import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqpm
  implements View.OnClickListener
{
  aqpm(aqpl paramaqpl, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (aqph.a(this.jdField_a_of_type_Aqpl.a) != null) {
      aqph.a(this.jdField_a_of_type_Aqpl.a).a(this.jdField_a_of_type_Int, (aqon)aqph.a(this.jdField_a_of_type_Aqpl.a).get(this.jdField_a_of_type_Int));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpm
 * JD-Core Version:    0.7.0.1
 */