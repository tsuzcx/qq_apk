import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asto
  implements View.OnClickListener
{
  asto(astk paramastk, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Astk.a != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label86;
      }
      bcef.b(null, "dc00898", "", "", "0X800A745", "0X800A745", ataw.c(this.jdField_a_of_type_Astk.e()), 0, "", "", "", "");
      if (this.jdField_a_of_type_Astk.a.d()) {
        this.jdField_a_of_type_Astk.a.b();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label86:
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_Astk.a.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asto
 * JD-Core Version:    0.7.0.1
 */