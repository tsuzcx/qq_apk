import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmzz
  implements View.OnClickListener
{
  bmzz(bmzr parambmzr, bmyx parambmyx, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bmzr.a(this.jdField_a_of_type_Bmyx.itemView, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzz
 * JD-Core Version:    0.7.0.1
 */