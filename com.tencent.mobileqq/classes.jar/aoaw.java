import android.os.Handler;
import dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class aoaw
  implements Runnable
{
  public aoaw(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    aoas localaoas;
    if (this.a.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new aoaw(this.a), this.a.d);
      localaoas = this.a.jdField_a_of_type_Aoas;
      if (this.a.jdField_a_of_type_Aoas.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localaoas.e = bool;
      this.a.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoaw
 * JD-Core Version:    0.7.0.1
 */