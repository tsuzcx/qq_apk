import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class bgro
  implements amgv
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public bgro(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    amhb localamhb = new amhb();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689642);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692324);
    localamhb.a(17104896);
    localamhb.a("" + this.jdField_a_of_type_JavaLangLong + "-4");
    localamhb.b(str1);
    localamhb.c(str2);
    localamhb.d("resdrawable://2130843378");
    return localamhb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgro
 * JD-Core Version:    0.7.0.1
 */