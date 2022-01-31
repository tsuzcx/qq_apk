import android.graphics.Canvas;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;
import com.tencent.qphone.base.util.QLog;

public class azmd
{
  public boolean d = true;
  public boolean e = true;
  public int f;
  public boolean f;
  public int g;
  
  azmd(TCProgressBar paramTCProgressBar)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmd
 * JD-Core Version:    0.7.0.1
 */