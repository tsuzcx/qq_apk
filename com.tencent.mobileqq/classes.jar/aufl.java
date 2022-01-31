import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class aufl
  implements View.OnClickListener
{
  aufl(aufh paramaufh, aufw paramaufw) {}
  
  public void onClick(View paramView)
  {
    aufh.a(this.jdField_a_of_type_Aufh).removeMessages(101);
    aufh.a(this.jdField_a_of_type_Aufh).obtainMessage(101).sendToTarget();
    this.jdField_a_of_type_Aufw.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufl
 * JD-Core Version:    0.7.0.1
 */