import com.tencent.qphone.base.util.QLog;
import java.util.List;

class axkg
  implements axjt
{
  axkg(axkf paramaxkf, int paramInt, axkh paramaxkh) {}
  
  public void a(int paramInt, String paramString)
  {
    axkf.a(this.jdField_a_of_type_Axkf, false);
    if (axkf.a(this.jdField_a_of_type_Axkf).size() == 0) {
      this.jdField_a_of_type_Axkf.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Axkh, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d(axkf.a(this.jdField_a_of_type_Axkf), 2, "Focus cmd:1718 sub cmd:100 errCode:" + paramInt + " msg:" + paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    axkf.a(this.jdField_a_of_type_Axkf, false);
    try
    {
      axkf.a(this.jdField_a_of_type_Axkf, 0);
      if ((this.jdField_a_of_type_Axkf.a(this.jdField_a_of_type_Int, paramArrayOfByte) == -1) && (axkf.a(this.jdField_a_of_type_Axkf).size() == 0)) {
        this.jdField_a_of_type_Axkf.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Axkh, true);
      }
      this.jdField_a_of_type_Axkh.a(axkf.a(this.jdField_a_of_type_Axkf));
      axkf.a(this.jdField_a_of_type_Axkf, System.currentTimeMillis());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(axkf.a(this.jdField_a_of_type_Axkf), 2, "Focus cmd:1718 sub cmd:100 Exception:" + paramArrayOfByte.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkg
 * JD-Core Version:    0.7.0.1
 */