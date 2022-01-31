import android.os.Bundle;

class bdky
  implements bdoe
{
  bdky(bdkx parambdkx, bdkz parambdkz, String paramString) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bdkz == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1)) {
      try
      {
        this.jdField_a_of_type_Bdkz.a(true, new Bundle());
        return;
      }
      catch (Exception localException)
      {
        bdnw.d("MiniAppCmdServlet", "cmd response exception. cmd=" + this.jdField_a_of_type_JavaLangString, localException);
        return;
      }
    }
    this.jdField_a_of_type_Bdkz.a(false, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdky
 * JD-Core Version:    0.7.0.1
 */