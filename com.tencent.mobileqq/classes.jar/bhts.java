import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bhts
  implements View.OnClickListener
{
  bhts(bhtr parambhtr, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((bhtr.a(this.jdField_a_of_type_Bhtr) == null) || (this.jdField_a_of_type_Int >= bhtr.a(this.jdField_a_of_type_Bhtr).size()) || (this.jdField_a_of_type_Int < 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Bhtr.a.a != null) && (bhtr.a(this.jdField_a_of_type_Bhtr).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_Bhtr.a) != null)) {
        OpenCardContainer.a(this.jdField_a_of_type_Bhtr.a).a(((bhtu)bhtr.a(this.jdField_a_of_type_Bhtr).get(this.jdField_a_of_type_Int)).a);
      }
      bhtr.a(this.jdField_a_of_type_Bhtr).remove(bhtr.a(this.jdField_a_of_type_Bhtr).get(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bhtr.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhts
 * JD-Core Version:    0.7.0.1
 */