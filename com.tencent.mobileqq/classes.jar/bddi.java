import com.tencent.mobileqq.qipc.QIPCModule;

public class bddi
{
  private static volatile bddi jdField_a_of_type_Bddi;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new bddj(this, "Module_VideoPlayIPCServer");
  
  public static bddi a()
  {
    if (jdField_a_of_type_Bddi == null) {}
    try
    {
      if (jdField_a_of_type_Bddi == null) {
        jdField_a_of_type_Bddi = new bddi();
      }
      return jdField_a_of_type_Bddi;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddi
 * JD-Core Version:    0.7.0.1
 */