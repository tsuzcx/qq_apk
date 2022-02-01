import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class bmsp
  implements bmsx
{
  bmsp(bmsl parambmsl, bmsy parambmsy, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    bmsj localbmsj = new bmsj();
    localbmsj.c = paramString;
    localbmsj.jdField_a_of_type_Int = 2;
    localbmsj.jdField_b_of_type_Long = (paramFloat);
    localbmsj.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bmsy.a(paramString, this.jdField_a_of_type_Int, localbmsj, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    bmsj localbmsj;
    for (int i = 1;; i = 0)
    {
      localbmsj = new bmsj();
      localbmsj.jdField_b_of_type_JavaLangString = paramString2;
      localbmsj.c = paramString1;
      localbmsj.jdField_b_of_type_Int = paramInt;
      localbmsj.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localbmsj.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_Bmsy.a(paramString1, this.jdField_a_of_type_Int, localbmsj, true);
      return;
    }
    localbmsj.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bmsy.a(paramString1, this.jdField_a_of_type_Int, localbmsj, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsp
 * JD-Core Version:    0.7.0.1
 */