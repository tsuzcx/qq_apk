import com.tencent.mobileqq.qipc.QIPCModule;

public class bbwn
{
  private static volatile bbwn jdField_a_of_type_Bbwn;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new bbwo(this, "Module_VideoPlayIPCServer");
  
  public static bbwn a()
  {
    if (jdField_a_of_type_Bbwn == null) {}
    try
    {
      if (jdField_a_of_type_Bbwn == null) {
        jdField_a_of_type_Bbwn = new bbwn();
      }
      return jdField_a_of_type_Bbwn;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwn
 * JD-Core Version:    0.7.0.1
 */