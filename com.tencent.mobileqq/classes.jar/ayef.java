import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ayef
  implements ayds
{
  ayef(ayee paramayee, int paramInt, ayeg paramayeg) {}
  
  public void a(int paramInt, String paramString)
  {
    ayee.a(this.jdField_a_of_type_Ayee, false);
    if (ayee.a(this.jdField_a_of_type_Ayee).size() == 0) {
      this.jdField_a_of_type_Ayee.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ayeg, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d(ayee.a(this.jdField_a_of_type_Ayee), 2, "Focus cmd:20736 sub cmd:100 errCode:" + paramInt + " msg:" + paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    ayee.a(this.jdField_a_of_type_Ayee, false);
    try
    {
      ayee.a(this.jdField_a_of_type_Ayee, 0);
      if ((this.jdField_a_of_type_Ayee.a(this.jdField_a_of_type_Int, paramArrayOfByte) == -1) && (ayee.a(this.jdField_a_of_type_Ayee).size() == 0)) {
        this.jdField_a_of_type_Ayee.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ayeg, true);
      }
      this.jdField_a_of_type_Ayeg.a(ayee.a(this.jdField_a_of_type_Ayee));
      ayee.a(this.jdField_a_of_type_Ayee, System.currentTimeMillis());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(ayee.a(this.jdField_a_of_type_Ayee), 2, "Focus cmd:20736 sub cmd:100 Exception:" + paramArrayOfByte.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayef
 * JD-Core Version:    0.7.0.1
 */