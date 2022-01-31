import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;

final class bhkp
  implements bhjk
{
  public bhks a;
  
  bhkp(bhkn parambhkn) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bhks.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_Bhks.jdField_b_of_type_JavaLangString.contains("..")))
    {
      this.jdField_a_of_type_Bhks.d = 15;
      return;
    }
    Object localObject = new File(this.jdField_a_of_type_Bhks.jdField_b_of_type_JavaLangString);
    if (!((File)localObject).exists())
    {
      this.jdField_a_of_type_Bhks.d = 12;
      return;
    }
    this.jdField_a_of_type_Bhks.jdField_a_of_type_Bhld = new bhld();
    if ((this.jdField_a_of_type_Bhks.jdField_b_of_type_Int == 2) || (this.jdField_a_of_type_Bhks.jdField_b_of_type_Int == 1)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 1) && (!bhlq.a((File)localObject, null)))
      {
        this.jdField_a_of_type_Bhks.d = 10;
        return;
      }
      localObject = new Object[1];
      this.jdField_a_of_type_Bhks.d = QSecFramework.a(2L, this.jdField_a_of_type_Bhks.jdField_b_of_type_Int, this.jdField_a_of_type_Bhks.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Bhks.jdField_b_of_type_JavaLangString, null, null, (Object[])localObject);
      if ((localObject[0] == null) || (!(localObject[0] instanceof Integer))) {
        break;
      }
      this.jdField_a_of_type_Bhks.f = ((Integer)localObject[0]).intValue();
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bhks.d = 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkp
 * JD-Core Version:    0.7.0.1
 */