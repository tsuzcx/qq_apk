import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class biwu
  implements aocf
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public biwu(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    aocl localaocl = new aocl();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689642);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692401);
    localaocl.a(17104896);
    localaocl.a("" + this.jdField_a_of_type_JavaLangLong + "-4");
    localaocl.b(str1);
    localaocl.c(str2);
    localaocl.d("resdrawable://2130843803");
    return localaocl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwu
 * JD-Core Version:    0.7.0.1
 */