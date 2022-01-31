import android.os.Handler;
import dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class aorb
  implements Runnable
{
  public aorb(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    aoqx localaoqx;
    if (this.a.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new aorb(this.a), this.a.d);
      localaoqx = this.a.jdField_a_of_type_Aoqx;
      if (this.a.jdField_a_of_type_Aoqx.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localaoqx.e = bool;
      this.a.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aorb
 * JD-Core Version:    0.7.0.1
 */