import android.os.Handler;
import dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class aozn
  implements Runnable
{
  public aozn(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    aozj localaozj;
    if (this.a.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new aozn(this.a), this.a.d);
      localaozj = this.a.jdField_a_of_type_Aozj;
      if (this.a.jdField_a_of_type_Aozj.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localaozj.e = bool;
      this.a.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aozn
 * JD-Core Version:    0.7.0.1
 */