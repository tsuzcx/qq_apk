import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class bifj
  implements bifa
{
  bifj(bifi parambifi, String paramString, long paramLong, biem parambiem, int paramInt) {}
  
  public void a(biei parambiei, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((parambiei == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambiei.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (parambiei.jdField_a_of_type_Biek == null)
      {
        bifi.a(this.jdField_a_of_type_Bifi).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      bifi.a(this.jdField_a_of_type_Bifi).a(this.jdField_a_of_type_Long, parambiei.jdField_a_of_type_Biek);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_Biem.a()))
    {
      this.jdField_a_of_type_Biem.d(true);
      parambiei = Message.obtain();
      parambiei.what = 21;
      parambiei.obj = this.jdField_a_of_type_Biem;
      parambiei.arg1 = this.jdField_a_of_type_Int;
      bifi.a(this.jdField_a_of_type_Bifi).sendMessageDelayed(parambiei, 1000L);
      return;
    }
    bifi.a(this.jdField_a_of_type_Bifi).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifj
 * JD-Core Version:    0.7.0.1
 */