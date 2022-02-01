import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdjs
  implements View.OnClickListener
{
  bdjs(bdjr parambdjr, bdjv parambdjv) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bdjv.getAdapterPosition();
    if (i != bdjr.a(this.jdField_a_of_type_Bdjr))
    {
      if (!this.jdField_a_of_type_Bdjr.a()) {
        break label89;
      }
      this.jdField_a_of_type_Bdjr.a(paramView, i);
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800B355", "0X800B355", bdjr.a(this.jdField_a_of_type_Bdjr)[i].a, 0, String.valueOf(bdjr.a(this.jdField_a_of_type_Bdjr)), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label89:
      bdjr.a(this.jdField_a_of_type_Bdjr).a(bdjr.a(this.jdField_a_of_type_Bdjr)[i].b);
      bdjr.a(this.jdField_a_of_type_Bdjr, i);
      this.jdField_a_of_type_Bdjr.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjs
 * JD-Core Version:    0.7.0.1
 */