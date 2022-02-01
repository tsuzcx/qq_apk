import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class beqv
  implements View.OnClickListener
{
  beqv(bequ parambequ, beqy parambeqy) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Beqy.getAdapterPosition();
    if (i != bequ.a(this.jdField_a_of_type_Bequ))
    {
      if (!this.jdField_a_of_type_Bequ.a()) {
        break label89;
      }
      this.jdField_a_of_type_Bequ.a(paramView, i);
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800B355", "0X800B355", bequ.a(this.jdField_a_of_type_Bequ)[i].a, 0, String.valueOf(bequ.a(this.jdField_a_of_type_Bequ)), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label89:
      bequ.a(this.jdField_a_of_type_Bequ).a(bequ.a(this.jdField_a_of_type_Bequ)[i].b);
      bequ.a(this.jdField_a_of_type_Bequ, i);
      this.jdField_a_of_type_Bequ.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqv
 * JD-Core Version:    0.7.0.1
 */