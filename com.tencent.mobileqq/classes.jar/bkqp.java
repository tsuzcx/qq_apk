import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class bkqp
  implements apkw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public bkqp(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    aple localaple = new aple();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689564);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692036);
    localaple.a(17104896);
    localaple.a("" + this.jdField_a_of_type_JavaLangLong + "-4");
    localaple.b(str1);
    localaple.c(str2);
    localaple.d("resdrawable://2130844076");
    return localaple.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqp
 * JD-Core Version:    0.7.0.1
 */