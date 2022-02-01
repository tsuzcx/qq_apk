import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bjoe
  implements View.OnClickListener
{
  bjoe(bjod parambjod, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((bjod.a(this.jdField_a_of_type_Bjod) == null) || (this.jdField_a_of_type_Int >= bjod.a(this.jdField_a_of_type_Bjod).size()) || (this.jdField_a_of_type_Int < 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Bjod.a.a != null) && (bjod.a(this.jdField_a_of_type_Bjod).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_Bjod.a) != null)) {
        OpenCardContainer.a(this.jdField_a_of_type_Bjod.a).a(((bjog)bjod.a(this.jdField_a_of_type_Bjod).get(this.jdField_a_of_type_Int)).a);
      }
      bjod.a(this.jdField_a_of_type_Bjod).remove(bjod.a(this.jdField_a_of_type_Bjod).get(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bjod.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjoe
 * JD-Core Version:    0.7.0.1
 */