import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class bfjf
  implements alsd
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public bfjf(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    alsl localalsl = new alsl();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624102);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131626722);
    localalsl.a(17104896);
    localalsl.a("" + this.jdField_a_of_type_JavaLangLong);
    localalsl.b(str1);
    localalsl.c(str2);
    localalsl.d("resdrawable://2130843296");
    return localalsl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfjf
 * JD-Core Version:    0.7.0.1
 */