import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class bmzj
  implements bmzr
{
  bmzj(bmzf parambmzf, bmzs parambmzs, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    bmzd localbmzd = new bmzd();
    localbmzd.c = paramString;
    localbmzd.jdField_a_of_type_Int = 2;
    localbmzd.jdField_b_of_type_Long = (paramFloat);
    localbmzd.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bmzs.a(paramString, this.jdField_a_of_type_Int, localbmzd, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    bmzd localbmzd;
    for (int i = 1;; i = 0)
    {
      localbmzd = new bmzd();
      localbmzd.jdField_b_of_type_JavaLangString = paramString2;
      localbmzd.c = paramString1;
      localbmzd.jdField_b_of_type_Int = paramInt;
      localbmzd.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localbmzd.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_Bmzs.a(paramString1, this.jdField_a_of_type_Int, localbmzd, true);
      return;
    }
    localbmzd.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bmzs.a(paramString1, this.jdField_a_of_type_Int, localbmzd, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzj
 * JD-Core Version:    0.7.0.1
 */