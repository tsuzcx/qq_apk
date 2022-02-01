import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avpa
  implements View.OnClickListener
{
  avpa(avoy paramavoy, avpc paramavpc) {}
  
  public void onClick(View paramView)
  {
    avoy.a(this.jdField_a_of_type_Avoy, this.jdField_a_of_type_Avpc.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpa
 * JD-Core Version:    0.7.0.1
 */