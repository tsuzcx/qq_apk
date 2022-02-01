import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aywy
  implements aywl
{
  aywy(aywx paramaywx, int paramInt, aywz paramaywz) {}
  
  public void a(int paramInt, String paramString)
  {
    aywx.a(this.jdField_a_of_type_Aywx, false);
    if (aywx.a(this.jdField_a_of_type_Aywx).size() == 0) {
      this.jdField_a_of_type_Aywx.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aywz, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d(aywx.a(this.jdField_a_of_type_Aywx), 2, "Focus cmd:1718 sub cmd:100 errCode:" + paramInt + " msg:" + paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    aywx.a(this.jdField_a_of_type_Aywx, false);
    try
    {
      aywx.a(this.jdField_a_of_type_Aywx, 0);
      if ((this.jdField_a_of_type_Aywx.a(this.jdField_a_of_type_Int, paramArrayOfByte) == -1) && (aywx.a(this.jdField_a_of_type_Aywx).size() == 0)) {
        this.jdField_a_of_type_Aywx.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aywz, true);
      }
      this.jdField_a_of_type_Aywz.a(aywx.a(this.jdField_a_of_type_Aywx));
      aywx.a(this.jdField_a_of_type_Aywx, System.currentTimeMillis());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(aywx.a(this.jdField_a_of_type_Aywx), 2, "Focus cmd:1718 sub cmd:100 Exception:" + paramArrayOfByte.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywy
 * JD-Core Version:    0.7.0.1
 */