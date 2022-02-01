import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class bllf
  implements aqck
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public bllf(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    aqcs localaqcs = new aqcs();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689563);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131691986);
    localaqcs.a(17104896);
    localaqcs.a("" + this.jdField_a_of_type_JavaLangLong + "-4");
    localaqcs.b(str1);
    localaqcs.c(str2);
    localaqcs.d("resdrawable://2130844178");
    return localaqcs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllf
 * JD-Core Version:    0.7.0.1
 */