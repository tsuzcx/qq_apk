import android.text.TextUtils;
import java.util.HashMap;

class apjd
  implements aplk
{
  apjd(apix paramapix, long paramLong) {}
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString1 = this.jdField_a_of_type_Apix.a + "_" + paramLong + "_" + paramString1;
      apix.a(this.jdField_a_of_type_Apix).put(paramString1, paramString2);
      apix.b(this.jdField_a_of_type_Apix).put(paramString1, paramString3);
      apix.c(this.jdField_a_of_type_Apix).put(this.jdField_a_of_type_Apix.a, String.valueOf(paramLong));
    }
    apix.a(this.jdField_a_of_type_Apix, paramString2, paramString3, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjd
 * JD-Core Version:    0.7.0.1
 */