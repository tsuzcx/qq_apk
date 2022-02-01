import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class binf
  implements View.OnClickListener
{
  binf(bine parambine, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((bine.a(this.jdField_a_of_type_Bine) == null) || (this.jdField_a_of_type_Int >= bine.a(this.jdField_a_of_type_Bine).size()) || (this.jdField_a_of_type_Int < 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Bine.a.a != null) && (bine.a(this.jdField_a_of_type_Bine).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_Bine.a) != null)) {
        OpenCardContainer.a(this.jdField_a_of_type_Bine.a).a(((binh)bine.a(this.jdField_a_of_type_Bine).get(this.jdField_a_of_type_Int)).a);
      }
      bine.a(this.jdField_a_of_type_Bine).remove(bine.a(this.jdField_a_of_type_Bine).get(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bine.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     binf
 * JD-Core Version:    0.7.0.1
 */