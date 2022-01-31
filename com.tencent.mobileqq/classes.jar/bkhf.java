import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class bkhf
  implements bkgw
{
  bkhf(bkhe parambkhe, String paramString, long paramLong, bkgi parambkgi, int paramInt) {}
  
  public void a(bkge parambkge, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((parambkge == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambkge.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (parambkge.jdField_a_of_type_Bkgg == null)
      {
        bkhe.a(this.jdField_a_of_type_Bkhe).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      bkhe.a(this.jdField_a_of_type_Bkhe).a(this.jdField_a_of_type_Long, parambkge.jdField_a_of_type_Bkgg);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_Bkgi.a()))
    {
      this.jdField_a_of_type_Bkgi.d(true);
      parambkge = Message.obtain();
      parambkge.what = 21;
      parambkge.obj = this.jdField_a_of_type_Bkgi;
      parambkge.arg1 = this.jdField_a_of_type_Int;
      bkhe.a(this.jdField_a_of_type_Bkhe).sendMessageDelayed(parambkge, 1000L);
      return;
    }
    bkhe.a(this.jdField_a_of_type_Bkhe).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhf
 * JD-Core Version:    0.7.0.1
 */