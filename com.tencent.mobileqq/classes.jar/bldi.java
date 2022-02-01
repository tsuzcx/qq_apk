import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;

final class bldi
  implements blcd
{
  public bldl a;
  
  bldi(bldg parambldg) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bldl.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_Bldl.jdField_b_of_type_JavaLangString.contains("..")))
    {
      this.jdField_a_of_type_Bldl.d = 15;
      return;
    }
    Object localObject = new File(this.jdField_a_of_type_Bldl.jdField_b_of_type_JavaLangString);
    if (!((File)localObject).exists())
    {
      this.jdField_a_of_type_Bldl.d = 12;
      return;
    }
    this.jdField_a_of_type_Bldl.jdField_a_of_type_Bldw = new bldw();
    if ((this.jdField_a_of_type_Bldl.jdField_b_of_type_Int == 2) || (this.jdField_a_of_type_Bldl.jdField_b_of_type_Int == 1)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 1) && (!blej.a((File)localObject, null)))
      {
        this.jdField_a_of_type_Bldl.d = 10;
        return;
      }
      localObject = new Object[1];
      this.jdField_a_of_type_Bldl.d = QSecFramework.a(2L, this.jdField_a_of_type_Bldl.jdField_b_of_type_Int, this.jdField_a_of_type_Bldl.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Bldl.jdField_b_of_type_JavaLangString, null, null, (Object[])localObject);
      if ((localObject[0] == null) || (!(localObject[0] instanceof Integer))) {
        break;
      }
      this.jdField_a_of_type_Bldl.f = ((Integer)localObject[0]).intValue();
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bldl.d = 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldi
 * JD-Core Version:    0.7.0.1
 */