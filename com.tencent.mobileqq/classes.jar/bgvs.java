import com.tencent.mobileqq.utils.httputils.HttpCommunicator;

public class bgvs
{
  private static axrr jdField_a_of_type_Axrr;
  private static bakx jdField_a_of_type_Bakx = new bgvt();
  private static axrr jdField_b_of_type_Axrr;
  private static bakx jdField_b_of_type_Bakx = new bgvu();
  
  public static axrr a()
  {
    if (jdField_a_of_type_Axrr == null) {}
    try
    {
      if (jdField_a_of_type_Axrr == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_Bakx, 128);
        localHttpCommunicator.a();
        jdField_a_of_type_Axrr = new axss(localHttpCommunicator, true);
      }
      return jdField_a_of_type_Axrr;
    }
    finally {}
  }
  
  public static axrr b()
  {
    if (jdField_b_of_type_Axrr == null) {}
    try
    {
      if (jdField_b_of_type_Axrr == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_b_of_type_Bakx, 128);
        localHttpCommunicator.a();
        jdField_b_of_type_Axrr = new axss(localHttpCommunicator, true);
      }
      return jdField_b_of_type_Axrr;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvs
 * JD-Core Version:    0.7.0.1
 */