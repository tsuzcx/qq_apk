import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class aufo
  implements View.OnClickListener
{
  aufo(aufj paramaufj, aufy paramaufy) {}
  
  public void onClick(View paramView)
  {
    aufj.a(this.jdField_a_of_type_Aufj).removeMessages(101);
    aufj.a(this.jdField_a_of_type_Aufj).obtainMessage(101).sendToTarget();
    this.jdField_a_of_type_Aufy.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufo
 * JD-Core Version:    0.7.0.1
 */