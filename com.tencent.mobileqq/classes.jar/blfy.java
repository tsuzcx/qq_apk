import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class blfy
  implements blgg
{
  blfy(blfu paramblfu, blgh paramblgh, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    blfs localblfs = new blfs();
    localblfs.c = paramString;
    localblfs.jdField_a_of_type_Int = 2;
    localblfs.jdField_b_of_type_Long = (paramFloat);
    localblfs.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Blgh.a(paramString, this.jdField_a_of_type_Int, localblfs, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    blfs localblfs;
    for (int i = 1;; i = 0)
    {
      localblfs = new blfs();
      localblfs.jdField_b_of_type_JavaLangString = paramString2;
      localblfs.c = paramString1;
      localblfs.jdField_b_of_type_Int = paramInt;
      localblfs.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localblfs.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_Blgh.a(paramString1, this.jdField_a_of_type_Int, localblfs, true);
      return;
    }
    localblfs.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Blgh.a(paramString1, this.jdField_a_of_type_Int, localblfs, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfy
 * JD-Core Version:    0.7.0.1
 */