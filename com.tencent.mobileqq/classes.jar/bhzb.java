import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;

public class bhzb
  extends biba
{
  public int a;
  
  public void a(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[MarginStyle] start:" + this.b + " end:" + this.c + " marginPix:" + this.a);
    }
    paramSpannableString.setSpan(new bhza(this.a), this.b, this.c, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhzb
 * JD-Core Version:    0.7.0.1
 */