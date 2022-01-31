import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class biec
  implements biek
{
  biec(bidy parambidy, biel parambiel, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    bidw localbidw = new bidw();
    localbidw.c = paramString;
    localbidw.jdField_a_of_type_Int = 2;
    localbidw.jdField_b_of_type_Long = (paramFloat);
    localbidw.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Biel.a(paramString, this.jdField_a_of_type_Int, localbidw, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    bidw localbidw;
    for (int i = 1;; i = 0)
    {
      localbidw = new bidw();
      localbidw.jdField_b_of_type_JavaLangString = paramString2;
      localbidw.c = paramString1;
      localbidw.jdField_b_of_type_Int = paramInt;
      localbidw.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localbidw.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_Biel.a(paramString1, this.jdField_a_of_type_Int, localbidw, true);
      return;
    }
    localbidw.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Biel.a(paramString1, this.jdField_a_of_type_Int, localbidw, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biec
 * JD-Core Version:    0.7.0.1
 */