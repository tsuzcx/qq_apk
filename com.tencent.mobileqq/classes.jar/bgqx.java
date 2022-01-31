import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class bgqx
  implements amgw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public bgqx(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    amhc localamhc = new amhc();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689642);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692324);
    localamhc.a(17104896);
    localamhc.a("" + this.jdField_a_of_type_JavaLangLong + "-4");
    localamhc.b(str1);
    localamhc.c(str2);
    localamhc.d("resdrawable://2130843377");
    return localamhc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqx
 * JD-Core Version:    0.7.0.1
 */