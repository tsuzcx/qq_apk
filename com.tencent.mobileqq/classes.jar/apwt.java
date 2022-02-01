import android.text.TextUtils;
import java.util.HashMap;

class apwt
  implements apza
{
  apwt(apwn paramapwn, long paramLong) {}
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString1 = this.jdField_a_of_type_Apwn.a + "_" + paramLong + "_" + paramString1;
      apwn.a(this.jdField_a_of_type_Apwn).put(paramString1, paramString2);
      apwn.b(this.jdField_a_of_type_Apwn).put(paramString1, paramString3);
      apwn.c(this.jdField_a_of_type_Apwn).put(this.jdField_a_of_type_Apwn.a, String.valueOf(paramLong));
    }
    apwn.a(this.jdField_a_of_type_Apwn, paramString2, paramString3, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwt
 * JD-Core Version:    0.7.0.1
 */