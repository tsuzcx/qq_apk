import android.text.TextUtils;
import java.util.HashMap;

class aoqg
  implements aosn
{
  aoqg(aoqa paramaoqa, long paramLong) {}
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString1 = this.jdField_a_of_type_Aoqa.a + "_" + paramLong + "_" + paramString1;
      aoqa.a(this.jdField_a_of_type_Aoqa).put(paramString1, paramString2);
      aoqa.b(this.jdField_a_of_type_Aoqa).put(paramString1, paramString3);
      aoqa.c(this.jdField_a_of_type_Aoqa).put(this.jdField_a_of_type_Aoqa.a, String.valueOf(paramLong));
    }
    aoqa.a(this.jdField_a_of_type_Aoqa, paramString2, paramString3, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqg
 * JD-Core Version:    0.7.0.1
 */