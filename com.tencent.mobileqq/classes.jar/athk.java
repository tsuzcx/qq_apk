import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class athk
  implements View.OnClickListener
{
  athk(athi paramathi, athx paramathx) {}
  
  public void onClick(View paramView)
  {
    athi.a(this.jdField_a_of_type_Athi).removeMessages(101);
    athi.a(this.jdField_a_of_type_Athi).obtainMessage(101).sendToTarget();
    if (this.jdField_a_of_type_Athx.a != null) {
      this.jdField_a_of_type_Athx.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     athk
 * JD-Core Version:    0.7.0.1
 */