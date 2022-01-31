import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class awba
  implements View.OnClickListener
{
  awba(awaw paramawaw, awbl paramawbl) {}
  
  public void onClick(View paramView)
  {
    awaw.a(this.jdField_a_of_type_Awaw).removeMessages(101);
    awaw.a(this.jdField_a_of_type_Awaw).obtainMessage(101).sendToTarget();
    this.jdField_a_of_type_Awbl.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awba
 * JD-Core Version:    0.7.0.1
 */