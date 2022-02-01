import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqlz
  implements View.OnClickListener
{
  aqlz(aqly paramaqly, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (aqlu.a(this.jdField_a_of_type_Aqly.a) != null) {
      aqlu.a(this.jdField_a_of_type_Aqly.a).a(this.jdField_a_of_type_Int, (aqla)aqlu.a(this.jdField_a_of_type_Aqly.a).get(this.jdField_a_of_type_Int));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlz
 * JD-Core Version:    0.7.0.1
 */