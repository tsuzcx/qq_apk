import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class bies
  implements biej
{
  bies(bier parambier, String paramString, long paramLong, bidv parambidv, int paramInt) {}
  
  public void a(bidr parambidr, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((parambidr == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambidr.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (parambidr.jdField_a_of_type_Bidt == null)
      {
        bier.a(this.jdField_a_of_type_Bier).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      bier.a(this.jdField_a_of_type_Bier).a(this.jdField_a_of_type_Long, parambidr.jdField_a_of_type_Bidt);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_Bidv.a()))
    {
      this.jdField_a_of_type_Bidv.d(true);
      parambidr = Message.obtain();
      parambidr.what = 21;
      parambidr.obj = this.jdField_a_of_type_Bidv;
      parambidr.arg1 = this.jdField_a_of_type_Int;
      bier.a(this.jdField_a_of_type_Bier).sendMessageDelayed(parambidr, 1000L);
      return;
    }
    bier.a(this.jdField_a_of_type_Bier).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bies
 * JD-Core Version:    0.7.0.1
 */