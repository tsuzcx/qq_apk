import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aton
  implements View.OnClickListener
{
  aton(atoe paramatoe, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Atoe.a != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label86;
      }
      bcst.b(null, "dc00898", "", "", "0X800A745", "0X800A745", atwt.c(this.jdField_a_of_type_Atoe.e()), 0, "", "", "", "");
      if (this.jdField_a_of_type_Atoe.a.d()) {
        this.jdField_a_of_type_Atoe.a.b();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label86:
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_Atoe.a.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aton
 * JD-Core Version:    0.7.0.1
 */