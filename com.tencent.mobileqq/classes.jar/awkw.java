import com.tencent.mobileqq.qipc.QIPCModule;

public class awkw
{
  private static volatile awkw jdField_a_of_type_Awkw;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new awkx(this, "Module_VideoPlayIPCServer");
  
  public static awkw a()
  {
    if (jdField_a_of_type_Awkw == null) {}
    try
    {
      if (jdField_a_of_type_Awkw == null) {
        jdField_a_of_type_Awkw = new awkw();
      }
      return jdField_a_of_type_Awkw;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awkw
 * JD-Core Version:    0.7.0.1
 */