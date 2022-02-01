import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ayql
  implements aypy
{
  ayql(ayqk paramayqk, int paramInt, ayqm paramayqm) {}
  
  public void a(int paramInt, String paramString)
  {
    ayqk.a(this.jdField_a_of_type_Ayqk, false);
    if (ayqk.a(this.jdField_a_of_type_Ayqk).size() == 0) {
      this.jdField_a_of_type_Ayqk.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ayqm, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d(ayqk.a(this.jdField_a_of_type_Ayqk), 2, "Focus cmd:1718 sub cmd:100 errCode:" + paramInt + " msg:" + paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    ayqk.a(this.jdField_a_of_type_Ayqk, false);
    try
    {
      ayqk.a(this.jdField_a_of_type_Ayqk, 0);
      if ((this.jdField_a_of_type_Ayqk.a(this.jdField_a_of_type_Int, paramArrayOfByte) == -1) && (ayqk.a(this.jdField_a_of_type_Ayqk).size() == 0)) {
        this.jdField_a_of_type_Ayqk.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ayqm, true);
      }
      this.jdField_a_of_type_Ayqm.a(ayqk.a(this.jdField_a_of_type_Ayqk));
      ayqk.a(this.jdField_a_of_type_Ayqk, System.currentTimeMillis());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(ayqk.a(this.jdField_a_of_type_Ayqk), 2, "Focus cmd:1718 sub cmd:100 Exception:" + paramArrayOfByte.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayql
 * JD-Core Version:    0.7.0.1
 */