import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;

final class azmm
  implements TextUtils.EllipsizeCallback
{
  azmm(azmn paramazmn, String paramString) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_Azmn.c.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString.substring(0, paramInt1);
    this.jdField_a_of_type_Azmn.c.setText(new ayki(nam.b(nam.c(str + "...")), 3, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmm
 * JD-Core Version:    0.7.0.1
 */