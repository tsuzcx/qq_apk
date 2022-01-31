import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class bgvq
  implements bgvh
{
  bgvq(bgvp parambgvp, String paramString, long paramLong, bgut parambgut, int paramInt) {}
  
  public void a(bgup parambgup, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((parambgup == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambgup.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (parambgup.jdField_a_of_type_Bgur == null)
      {
        bgvp.a(this.jdField_a_of_type_Bgvp).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      bgvp.a(this.jdField_a_of_type_Bgvp).a(this.jdField_a_of_type_Long, parambgup.jdField_a_of_type_Bgur);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_Bgut.a()))
    {
      this.jdField_a_of_type_Bgut.d(true);
      parambgup = Message.obtain();
      parambgup.what = 21;
      parambgup.obj = this.jdField_a_of_type_Bgut;
      parambgup.arg1 = this.jdField_a_of_type_Int;
      bgvp.a(this.jdField_a_of_type_Bgvp).sendMessageDelayed(parambgup, 1000L);
      return;
    }
    bgvp.a(this.jdField_a_of_type_Bgvp).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvq
 * JD-Core Version:    0.7.0.1
 */