import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;

final class bbkx
  implements TextUtils.EllipsizeCallback
{
  bbkx(bbky parambbky, String paramString) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_Bbky.c.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString.substring(0, paramInt1);
    this.jdField_a_of_type_Bbky.c.setText(new baig(ndd.b(ndd.c(str + "...")), 3, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkx
 * JD-Core Version:    0.7.0.1
 */