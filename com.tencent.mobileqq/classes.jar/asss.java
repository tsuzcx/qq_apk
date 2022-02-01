import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asss
  implements View.OnClickListener
{
  asss(assj paramassj, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Assj.a != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label86;
      }
      bcef.b(null, "dc00898", "", "", "0X800A745", "0X800A745", ataw.c(this.jdField_a_of_type_Assj.e()), 0, "", "", "", "");
      if (this.jdField_a_of_type_Assj.a.d()) {
        this.jdField_a_of_type_Assj.a.b();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label86:
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_Assj.a.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asss
 * JD-Core Version:    0.7.0.1
 */