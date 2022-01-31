import com.tencent.qqprotect.qsec.CrashProtector.IProtectedMethod;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qqprotect.qsec.QSecLibMgr;
import com.tencent.qqprotect.qsec.RundownProtection;
import com.tencent.qqprotect.singleupdate.VerifyFileUtil;
import java.io.File;

public final class amfb
  implements CrashProtector.IProtectedMethod
{
  public amfe a;
  
  public amfb(QSecLibMgr paramQSecLibMgr) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_Amfe.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_Amfe.jdField_b_of_type_JavaLangString.contains("..")))
    {
      this.jdField_a_of_type_Amfe.d = 15;
      return;
    }
    Object localObject = new File(this.jdField_a_of_type_Amfe.jdField_b_of_type_JavaLangString);
    if (!((File)localObject).exists())
    {
      this.jdField_a_of_type_Amfe.d = 12;
      return;
    }
    this.jdField_a_of_type_Amfe.jdField_a_of_type_ComTencentQqprotectQsecRundownProtection = new RundownProtection();
    if ((this.jdField_a_of_type_Amfe.jdField_b_of_type_Int == 2) || (this.jdField_a_of_type_Amfe.jdField_b_of_type_Int == 1)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 1) && (!VerifyFileUtil.a((File)localObject, null)))
      {
        this.jdField_a_of_type_Amfe.d = 10;
        return;
      }
      localObject = new Object[1];
      this.jdField_a_of_type_Amfe.d = QSecFramework.a(2, this.jdField_a_of_type_Amfe.jdField_b_of_type_Int, this.jdField_a_of_type_Amfe.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Amfe.jdField_b_of_type_JavaLangString, null, null, (Object[])localObject);
      if ((localObject[0] == null) || (!(localObject[0] instanceof Integer))) {
        break;
      }
      this.jdField_a_of_type_Amfe.f = ((Integer)localObject[0]).intValue();
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Amfe.d = 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amfb
 * JD-Core Version:    0.7.0.1
 */