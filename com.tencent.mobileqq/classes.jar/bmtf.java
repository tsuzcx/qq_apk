import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class bmtf
  implements bmsw
{
  bmtf(bmte parambmte, String paramString, long paramLong, bmsi parambmsi, int paramInt) {}
  
  public void a(bmse parambmse, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((parambmse == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambmse.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (parambmse.jdField_a_of_type_Bmsg == null)
      {
        bmte.a(this.jdField_a_of_type_Bmte).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      bmte.a(this.jdField_a_of_type_Bmte).a(this.jdField_a_of_type_Long, parambmse.jdField_a_of_type_Bmsg);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_Bmsi.a()))
    {
      this.jdField_a_of_type_Bmsi.d(true);
      parambmse = Message.obtain();
      parambmse.what = 21;
      parambmse.obj = this.jdField_a_of_type_Bmsi;
      parambmse.arg1 = this.jdField_a_of_type_Int;
      bmte.a(this.jdField_a_of_type_Bmte).sendMessageDelayed(parambmse, 1000L);
      return;
    }
    bmte.a(this.jdField_a_of_type_Bmte).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtf
 * JD-Core Version:    0.7.0.1
 */