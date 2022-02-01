import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmzx
  implements View.OnClickListener
{
  bmzx(bmzr parambmzr, int paramInt, bmyx parambmyx) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Bmzr.b()) {
      bmzr.a(this.jdField_a_of_type_Bmzr, this.jdField_a_of_type_Int, this.jdField_a_of_type_Bmyx);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzx
 * JD-Core Version:    0.7.0.1
 */