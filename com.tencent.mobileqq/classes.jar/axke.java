import com.tencent.mobileqq.qipc.QIPCModule;

public class axke
{
  private static volatile axke jdField_a_of_type_Axke;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new axkf(this, "Module_VideoPlayIPCServer");
  
  public static axke a()
  {
    if (jdField_a_of_type_Axke == null) {}
    try
    {
      if (jdField_a_of_type_Axke == null) {
        jdField_a_of_type_Axke = new axke();
      }
      return jdField_a_of_type_Axke;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axke
 * JD-Core Version:    0.7.0.1
 */