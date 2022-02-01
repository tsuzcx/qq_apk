import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class bmzz
  implements bmzq
{
  bmzz(bmzy parambmzy, String paramString, long paramLong, bmzc parambmzc, int paramInt) {}
  
  public void a(bmyy parambmyy, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((parambmyy == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambmyy.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (parambmyy.jdField_a_of_type_Bmza == null)
      {
        bmzy.a(this.jdField_a_of_type_Bmzy).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      bmzy.a(this.jdField_a_of_type_Bmzy).a(this.jdField_a_of_type_Long, parambmyy.jdField_a_of_type_Bmza);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_Bmzc.a()))
    {
      this.jdField_a_of_type_Bmzc.d(true);
      parambmyy = Message.obtain();
      parambmyy.what = 21;
      parambmyy.obj = this.jdField_a_of_type_Bmzc;
      parambmyy.arg1 = this.jdField_a_of_type_Int;
      bmzy.a(this.jdField_a_of_type_Bmzy).sendMessageDelayed(parambmyy, 1000L);
      return;
    }
    bmzy.a(this.jdField_a_of_type_Bmzy).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzz
 * JD-Core Version:    0.7.0.1
 */