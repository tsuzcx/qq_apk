import com.tencent.mobileqq.qipc.QIPCModule;

public class azfk
{
  private static volatile azfk jdField_a_of_type_Azfk;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new azfl(this, "Module_VideoPlayIPCServer");
  
  public static azfk a()
  {
    if (jdField_a_of_type_Azfk == null) {}
    try
    {
      if (jdField_a_of_type_Azfk == null) {
        jdField_a_of_type_Azfk = new azfk();
      }
      return jdField_a_of_type_Azfk;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfk
 * JD-Core Version:    0.7.0.1
 */