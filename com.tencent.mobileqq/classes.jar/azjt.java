import com.tencent.mobileqq.qipc.QIPCModule;

public class azjt
{
  private static volatile azjt jdField_a_of_type_Azjt;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new azju(this, "Module_VideoPlayIPCServer");
  
  public static azjt a()
  {
    if (jdField_a_of_type_Azjt == null) {}
    try
    {
      if (jdField_a_of_type_Azjt == null) {
        jdField_a_of_type_Azjt = new azjt();
      }
      return jdField_a_of_type_Azjt;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjt
 * JD-Core Version:    0.7.0.1
 */