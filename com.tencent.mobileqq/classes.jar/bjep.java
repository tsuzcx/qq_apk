import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bjep
  implements View.OnClickListener
{
  bjep(bjeo parambjeo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((bjeo.a(this.jdField_a_of_type_Bjeo) == null) || (this.jdField_a_of_type_Int >= bjeo.a(this.jdField_a_of_type_Bjeo).size()) || (this.jdField_a_of_type_Int < 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Bjeo.a.a != null) && (bjeo.a(this.jdField_a_of_type_Bjeo).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_Bjeo.a) != null)) {
        OpenCardContainer.a(this.jdField_a_of_type_Bjeo.a).a(((bjer)bjeo.a(this.jdField_a_of_type_Bjeo).get(this.jdField_a_of_type_Int)).a);
      }
      bjeo.a(this.jdField_a_of_type_Bjeo).remove(bjeo.a(this.jdField_a_of_type_Bjeo).get(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bjeo.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjep
 * JD-Core Version:    0.7.0.1
 */