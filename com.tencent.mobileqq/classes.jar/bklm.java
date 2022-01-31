import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class bklm
  implements bkld
{
  bklm(bkll parambkll, String paramString, long paramLong, bkkp parambkkp, int paramInt) {}
  
  public void a(bkkl parambkkl, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((parambkkl == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambkkl.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (parambkkl.jdField_a_of_type_Bkkn == null)
      {
        bkll.a(this.jdField_a_of_type_Bkll).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      bkll.a(this.jdField_a_of_type_Bkll).a(this.jdField_a_of_type_Long, parambkkl.jdField_a_of_type_Bkkn);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_Bkkp.a()))
    {
      this.jdField_a_of_type_Bkkp.d(true);
      parambkkl = Message.obtain();
      parambkkl.what = 21;
      parambkkl.obj = this.jdField_a_of_type_Bkkp;
      parambkkl.arg1 = this.jdField_a_of_type_Int;
      bkll.a(this.jdField_a_of_type_Bkll).sendMessageDelayed(parambkkl, 1000L);
      return;
    }
    bkll.a(this.jdField_a_of_type_Bkll).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklm
 * JD-Core Version:    0.7.0.1
 */