import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avhw
  implements View.OnClickListener
{
  avhw(avhu paramavhu, avhy paramavhy) {}
  
  public void onClick(View paramView)
  {
    avhu.a(this.jdField_a_of_type_Avhu, this.jdField_a_of_type_Avhy.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhw
 * JD-Core Version:    0.7.0.1
 */