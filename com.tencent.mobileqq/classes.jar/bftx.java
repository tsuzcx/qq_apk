import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;

public class bftx
  extends bfvw
{
  public int a;
  
  public void a(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[MarginStyle] start:" + this.b + " end:" + this.c + " marginPix:" + this.a);
    }
    paramSpannableString.setSpan(new bftw(this.a), this.b, this.c, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bftx
 * JD-Core Version:    0.7.0.1
 */