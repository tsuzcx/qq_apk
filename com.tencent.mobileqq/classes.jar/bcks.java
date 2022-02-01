import com.tencent.mobileqq.qipc.QIPCModule;

public class bcks
{
  private static volatile bcks jdField_a_of_type_Bcks;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new bckt(this, "Module_VideoPlayIPCServer");
  
  public static bcks a()
  {
    if (jdField_a_of_type_Bcks == null) {}
    try
    {
      if (jdField_a_of_type_Bcks == null) {
        jdField_a_of_type_Bcks = new bcks();
      }
      return jdField_a_of_type_Bcks;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcks
 * JD-Core Version:    0.7.0.1
 */