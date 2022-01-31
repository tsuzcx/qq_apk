import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class bisn
  implements anxw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public bisn(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    anyc localanyc = new anyc();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689642);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692400);
    localanyc.a(17104896);
    localanyc.a("" + this.jdField_a_of_type_JavaLangLong + "-4");
    localanyc.b(str1);
    localanyc.c(str2);
    localanyc.d("resdrawable://2130843731");
    return localanyc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bisn
 * JD-Core Version:    0.7.0.1
 */