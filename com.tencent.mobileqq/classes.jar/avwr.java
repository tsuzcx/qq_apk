import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class avwr
  implements View.OnClickListener
{
  avwr(avwn paramavwn, avxc paramavxc) {}
  
  public void onClick(View paramView)
  {
    avwn.a(this.jdField_a_of_type_Avwn).removeMessages(101);
    avwn.a(this.jdField_a_of_type_Avwn).obtainMessage(101).sendToTarget();
    this.jdField_a_of_type_Avxc.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avwr
 * JD-Core Version:    0.7.0.1
 */