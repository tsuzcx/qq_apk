import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class amdl
  implements bdtn
{
  amdl(amdj paramamdj, baoo parambaoo, Context paramContext, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QLog.e("Theme.ThemeHandler", 1, "onQueryItemVer: " + paramInt + "," + paramString1 + "," + paramString2);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Baoo.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2);
      this.jdField_a_of_type_AndroidOsBundle.putString("themePath", this.jdField_a_of_type_Baoo.d());
      amdj.a(this.jdField_a_of_type_Amdj, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("themeId", "1000");
    this.jdField_a_of_type_AndroidOsBundle.remove("themePath");
    amdj.a(this.jdField_a_of_type_Amdj, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdl
 * JD-Core Version:    0.7.0.1
 */