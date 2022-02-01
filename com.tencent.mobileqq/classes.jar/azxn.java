import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azxn
  implements View.OnClickListener
{
  azxn(azxh paramazxh, bkzi parambkzi) {}
  
  public void onClick(View paramView)
  {
    bdla.b(azxh.d(this.jdField_a_of_type_Azxh), "dc00898", "", "", "0X800A97D", "0X800A97D", 3, 0, "0", "0", "", "");
    this.jdField_a_of_type_Bkzi.a.onClick(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxn
 * JD-Core Version:    0.7.0.1
 */