import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class bkkw
  implements bkle
{
  bkkw(bkks parambkks, bklf parambklf, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    bkkq localbkkq = new bkkq();
    localbkkq.c = paramString;
    localbkkq.jdField_a_of_type_Int = 2;
    localbkkq.jdField_b_of_type_Long = (paramFloat);
    localbkkq.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bklf.a(paramString, this.jdField_a_of_type_Int, localbkkq, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    bkkq localbkkq;
    for (int i = 1;; i = 0)
    {
      localbkkq = new bkkq();
      localbkkq.jdField_b_of_type_JavaLangString = paramString2;
      localbkkq.c = paramString1;
      localbkkq.jdField_b_of_type_Int = paramInt;
      localbkkq.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localbkkq.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_Bklf.a(paramString1, this.jdField_a_of_type_Int, localbkkq, true);
      return;
    }
    localbkkq.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bklf.a(paramString1, this.jdField_a_of_type_Int, localbkkq, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkw
 * JD-Core Version:    0.7.0.1
 */