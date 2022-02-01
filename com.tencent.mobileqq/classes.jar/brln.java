import android.graphics.Canvas;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class brln
{
  public boolean d = true;
  public boolean e = true;
  public int f;
  public boolean f;
  public int g;
  
  brln(TCProgressBar paramTCProgressBar)
  {
    this.jdField_f_of_type_Boolean = false;
  }
  
  void a(Canvas paramCanvas)
  {
    this.jdField_f_of_type_Boolean = false;
  }
  
  boolean a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "checkBounds,x = " + paramFloat + ",x_coord = " + this.jdField_f_of_type_Int + ",x_coord + length = " + (this.jdField_f_of_type_Int + this.g));
    }
    return (paramFloat > this.jdField_f_of_type_Int) && (paramFloat < this.jdField_f_of_type_Int + this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brln
 * JD-Core Version:    0.7.0.1
 */