import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class bkgp
  implements bkgx
{
  bkgp(bkgl parambkgl, bkgy parambkgy, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    bkgj localbkgj = new bkgj();
    localbkgj.c = paramString;
    localbkgj.jdField_a_of_type_Int = 2;
    localbkgj.jdField_b_of_type_Long = (paramFloat);
    localbkgj.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bkgy.a(paramString, this.jdField_a_of_type_Int, localbkgj, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    bkgj localbkgj;
    for (int i = 1;; i = 0)
    {
      localbkgj = new bkgj();
      localbkgj.jdField_b_of_type_JavaLangString = paramString2;
      localbkgj.c = paramString1;
      localbkgj.jdField_b_of_type_Int = paramInt;
      localbkgj.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localbkgj.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_Bkgy.a(paramString1, this.jdField_a_of_type_Int, localbkgj, true);
      return;
    }
    localbkgj.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bkgy.a(paramString1, this.jdField_a_of_type_Int, localbkgj, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgp
 * JD-Core Version:    0.7.0.1
 */