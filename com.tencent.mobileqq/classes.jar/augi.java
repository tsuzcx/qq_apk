import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class augi
  implements View.OnClickListener
{
  augi(aufz paramaufz, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aufz.a != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label86;
      }
      bdll.b(null, "dc00898", "", "", "0X800A745", "0X800A745", auoo.c(this.jdField_a_of_type_Aufz.e()), 0, "", "", "", "");
      if (this.jdField_a_of_type_Aufz.a.d()) {
        this.jdField_a_of_type_Aufz.a.b();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label86:
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_Aufz.a.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augi
 * JD-Core Version:    0.7.0.1
 */