import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class bmmi
  implements aqrn
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public bmmi(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    aqrv localaqrv = new aqrv();
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689565);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131691990);
    localaqrv.a(17104896);
    localaqrv.a("" + this.jdField_a_of_type_JavaLangLong + "-4");
    localaqrv.b(str1);
    localaqrv.c(str2);
    localaqrv.d("resdrawable://2130844192");
    return localaqrv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmi
 * JD-Core Version:    0.7.0.1
 */