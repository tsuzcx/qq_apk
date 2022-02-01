import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayxc
  implements View.OnClickListener
{
  ayxc(ayxa paramayxa, ayxp paramayxp) {}
  
  public void onClick(View paramView)
  {
    ayxa.a(this.jdField_a_of_type_Ayxa).removeMessages(101);
    ayxa.a(this.jdField_a_of_type_Ayxa).obtainMessage(101).sendToTarget();
    if (this.jdField_a_of_type_Ayxp.a != null) {
      this.jdField_a_of_type_Ayxp.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxc
 * JD-Core Version:    0.7.0.1
 */