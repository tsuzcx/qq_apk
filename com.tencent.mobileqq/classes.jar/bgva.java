import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class bgva
  implements bgvi
{
  bgva(bguw parambguw, bgvj parambgvj, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    bguu localbguu = new bguu();
    localbguu.c = paramString;
    localbguu.jdField_a_of_type_Int = 2;
    localbguu.jdField_b_of_type_Long = (paramFloat);
    localbguu.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bgvj.a(paramString, this.jdField_a_of_type_Int, localbguu, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    bguu localbguu;
    for (int i = 1;; i = 0)
    {
      localbguu = new bguu();
      localbguu.jdField_b_of_type_JavaLangString = paramString2;
      localbguu.c = paramString1;
      localbguu.jdField_b_of_type_Int = paramInt;
      localbguu.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localbguu.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_Bgvj.a(paramString1, this.jdField_a_of_type_Int, localbguu, true);
      return;
    }
    localbguu.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bgvj.a(paramString1, this.jdField_a_of_type_Int, localbguu, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgva
 * JD-Core Version:    0.7.0.1
 */