import com.tencent.mobileqq.qipc.QIPCModule;

public class axkc
{
  private static volatile axkc jdField_a_of_type_Axkc;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new axkd(this, "Module_VideoPlayIPCServer");
  
  public static axkc a()
  {
    if (jdField_a_of_type_Axkc == null) {}
    try
    {
      if (jdField_a_of_type_Axkc == null) {
        jdField_a_of_type_Axkc = new axkc();
      }
      return jdField_a_of_type_Axkc;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axkc
 * JD-Core Version:    0.7.0.1
 */