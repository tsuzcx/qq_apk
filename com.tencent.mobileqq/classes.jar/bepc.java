import android.os.Bundle;

class bepc
  implements besr
{
  bepc(bepb parambepb, bepd parambepd, String paramString) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bepd == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1)) {
      try
      {
        this.jdField_a_of_type_Bepd.a(true, new Bundle());
        return;
      }
      catch (Exception localException)
      {
        besl.d("MiniAppCmdServlet", "cmd response exception. cmd=" + this.jdField_a_of_type_JavaLangString, localException);
        return;
      }
    }
    this.jdField_a_of_type_Bepd.a(false, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepc
 * JD-Core Version:    0.7.0.1
 */