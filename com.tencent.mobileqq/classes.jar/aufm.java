import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class aufm
  implements View.OnClickListener
{
  aufm(aufh paramaufh, aufw paramaufw) {}
  
  public void onClick(View paramView)
  {
    aufh.a(this.jdField_a_of_type_Aufh).removeMessages(101);
    aufh.a(this.jdField_a_of_type_Aufh).obtainMessage(101).sendToTarget();
    this.jdField_a_of_type_Aufw.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufm
 * JD-Core Version:    0.7.0.1
 */