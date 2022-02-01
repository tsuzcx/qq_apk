import android.content.Context;
import java.io.File;

final class bmtx
  implements bmsx
{
  bmtx(String paramString1, String paramString2, bmtz parambmtz, Context paramContext, File paramFile1, File paramFile2) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Bmtz != null) {
      this.jdField_a_of_type_Bmtz.a(paramLong, paramFloat);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if (paramBoolean) {
      bmsl.a().a(bmtw.a(), this.jdField_a_of_type_JavaLangString, "SoHelper", new bmty(this));
    }
    while (this.jdField_a_of_type_Bmtz == null) {
      return;
    }
    this.jdField_a_of_type_Bmtz.a(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtx
 * JD-Core Version:    0.7.0.1
 */