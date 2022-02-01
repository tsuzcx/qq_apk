import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class bobh
  implements boay
{
  bobh(bobg parambobg, String paramString, long paramLong, boak paramboak, int paramInt) {}
  
  public void a(boag paramboag, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramboag == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramboag.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (paramboag.jdField_a_of_type_Boai == null)
      {
        bobg.a(this.jdField_a_of_type_Bobg).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      bobg.a(this.jdField_a_of_type_Bobg).a(this.jdField_a_of_type_Long, paramboag.jdField_a_of_type_Boai);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_Boak.a()))
    {
      this.jdField_a_of_type_Boak.d(true);
      paramboag = Message.obtain();
      paramboag.what = 21;
      paramboag.obj = this.jdField_a_of_type_Boak;
      paramboag.arg1 = this.jdField_a_of_type_Int;
      bobg.a(this.jdField_a_of_type_Bobg).sendMessageDelayed(paramboag, 1000L);
      return;
    }
    bobg.a(this.jdField_a_of_type_Bobg).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobh
 * JD-Core Version:    0.7.0.1
 */