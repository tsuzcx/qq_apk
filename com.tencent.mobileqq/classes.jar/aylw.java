import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;

final class aylw
  implements TextUtils.EllipsizeCallback
{
  aylw(aylx paramaylx, String paramString) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_Aylx.c.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString.substring(0, paramInt1);
    this.jdField_a_of_type_Aylx.c.setText(new axkd(mpl.b(mpl.c(str + "...")), 3, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aylw
 * JD-Core Version:    0.7.0.1
 */