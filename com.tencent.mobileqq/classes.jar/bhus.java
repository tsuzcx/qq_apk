import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;

public class bhus
  extends bhwt
{
  public Drawable a;
  
  public void a(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[ImageStyle] start:" + this.b + " end:" + this.c);
    }
    paramSpannableString.setSpan(new bhur(this.a, 1), this.b, this.c, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhus
 * JD-Core Version:    0.7.0.1
 */