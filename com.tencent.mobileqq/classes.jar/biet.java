import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class biet
  implements bifb
{
  biet(biep parambiep, bifc parambifc, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    bien localbien = new bien();
    localbien.c = paramString;
    localbien.jdField_a_of_type_Int = 2;
    localbien.jdField_b_of_type_Long = (paramFloat);
    localbien.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bifc.a(paramString, this.jdField_a_of_type_Int, localbien, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    bien localbien;
    for (int i = 1;; i = 0)
    {
      localbien = new bien();
      localbien.jdField_b_of_type_JavaLangString = paramString2;
      localbien.c = paramString1;
      localbien.jdField_b_of_type_Int = paramInt;
      localbien.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localbien.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_Bifc.a(paramString1, this.jdField_a_of_type_Int, localbien, true);
      return;
    }
    localbien.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bifc.a(paramString1, this.jdField_a_of_type_Int, localbien, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biet
 * JD-Core Version:    0.7.0.1
 */