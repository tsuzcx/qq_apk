import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayks
  implements View.OnClickListener
{
  ayks(ayko paramayko, ayld paramayld) {}
  
  public void onClick(View paramView)
  {
    ayko.a(this.jdField_a_of_type_Ayko).removeMessages(101);
    ayko.a(this.jdField_a_of_type_Ayko).obtainMessage(101).sendToTarget();
    this.jdField_a_of_type_Ayld.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayks
 * JD-Core Version:    0.7.0.1
 */