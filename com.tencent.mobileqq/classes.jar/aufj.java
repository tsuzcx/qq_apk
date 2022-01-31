import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class aufj
  implements View.OnClickListener
{
  aufj(aufh paramaufh, aufw paramaufw) {}
  
  public void onClick(View paramView)
  {
    aufh.a(this.jdField_a_of_type_Aufh).removeMessages(101);
    aufh.a(this.jdField_a_of_type_Aufh).obtainMessage(101).sendToTarget();
    if (this.jdField_a_of_type_Aufw.a != null) {
      this.jdField_a_of_type_Aufw.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufj
 * JD-Core Version:    0.7.0.1
 */