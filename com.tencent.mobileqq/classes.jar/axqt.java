import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axqt
  implements View.OnClickListener
{
  axqt(axqp paramaxqp, axre paramaxre) {}
  
  public void onClick(View paramView)
  {
    axqp.a(this.jdField_a_of_type_Axqp).removeMessages(101);
    axqp.a(this.jdField_a_of_type_Axqp).obtainMessage(101).sendToTarget();
    this.jdField_a_of_type_Axre.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqt
 * JD-Core Version:    0.7.0.1
 */