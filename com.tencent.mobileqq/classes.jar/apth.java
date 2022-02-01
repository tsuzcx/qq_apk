import android.text.TextUtils;
import java.util.HashMap;

class apth
  implements apvq
{
  apth(aptb paramaptb, long paramLong) {}
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString1 = this.jdField_a_of_type_Aptb.a + "_" + paramLong + "_" + paramString1;
      aptb.a(this.jdField_a_of_type_Aptb).put(paramString1, paramString2);
      aptb.b(this.jdField_a_of_type_Aptb).put(paramString1, paramString3);
      aptb.c(this.jdField_a_of_type_Aptb).put(this.jdField_a_of_type_Aptb.a, String.valueOf(paramLong));
    }
    aptb.a(this.jdField_a_of_type_Aptb, paramString2, paramString3, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apth
 * JD-Core Version:    0.7.0.1
 */