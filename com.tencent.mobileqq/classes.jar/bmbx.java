import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class bmbx
  implements aqoa
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public bmbx(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    aqoi localaqoi = new aqoi();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689564);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692126);
    localaqoi.a(17104896);
    localaqoi.a("" + this.jdField_a_of_type_JavaLangLong + "-4");
    localaqoi.b(str1);
    localaqoi.c(str2);
    localaqoi.d("resdrawable://2130844139");
    return localaqoi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbx
 * JD-Core Version:    0.7.0.1
 */