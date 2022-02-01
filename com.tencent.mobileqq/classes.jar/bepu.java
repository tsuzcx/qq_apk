import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;

final class bepu
  implements TextUtils.EllipsizeCallback
{
  bepu(bepv parambepv, String paramString) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_Bepv.c.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString.substring(0, paramInt1);
    this.jdField_a_of_type_Bepv.c.setText(new bdnt(nlw.b(nlw.c(str + "...")), 3, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepu
 * JD-Core Version:    0.7.0.1
 */