import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;

final class bebo
  implements beaj
{
  public bebr a;
  
  bebo(bebm parambebm) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bebr.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_Bebr.jdField_b_of_type_JavaLangString.contains("..")))
    {
      this.jdField_a_of_type_Bebr.d = 15;
      return;
    }
    Object localObject = new File(this.jdField_a_of_type_Bebr.jdField_b_of_type_JavaLangString);
    if (!((File)localObject).exists())
    {
      this.jdField_a_of_type_Bebr.d = 12;
      return;
    }
    this.jdField_a_of_type_Bebr.jdField_a_of_type_Becc = new becc();
    if ((this.jdField_a_of_type_Bebr.jdField_b_of_type_Int == 2) || (this.jdField_a_of_type_Bebr.jdField_b_of_type_Int == 1)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 1) && (!becp.a((File)localObject, null)))
      {
        this.jdField_a_of_type_Bebr.d = 10;
        return;
      }
      localObject = new Object[1];
      this.jdField_a_of_type_Bebr.d = QSecFramework.a(2, this.jdField_a_of_type_Bebr.jdField_b_of_type_Int, this.jdField_a_of_type_Bebr.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Bebr.jdField_b_of_type_JavaLangString, null, null, (Object[])localObject);
      if ((localObject[0] == null) || (!(localObject[0] instanceof Integer))) {
        break;
      }
      this.jdField_a_of_type_Bebr.f = ((Integer)localObject[0]).intValue();
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bebr.d = 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bebo
 * JD-Core Version:    0.7.0.1
 */