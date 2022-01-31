import com.tencent.mobileqq.utils.httputils.HttpCommunicator;

public class bklo
{
  private static baue jdField_a_of_type_Baue;
  private static bdpy jdField_a_of_type_Bdpy = new bklp();
  private static baue jdField_b_of_type_Baue;
  private static bdpy jdField_b_of_type_Bdpy = new bklq();
  
  public static baue a()
  {
    if (jdField_a_of_type_Baue == null) {}
    try
    {
      if (jdField_a_of_type_Baue == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_Bdpy, 128);
        localHttpCommunicator.a();
        jdField_a_of_type_Baue = new bavh(localHttpCommunicator, true);
      }
      return jdField_a_of_type_Baue;
    }
    finally {}
  }
  
  public static baue b()
  {
    if (jdField_b_of_type_Baue == null) {}
    try
    {
      if (jdField_b_of_type_Baue == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_b_of_type_Bdpy, 128);
        localHttpCommunicator.a();
        jdField_b_of_type_Baue = new bavh(localHttpCommunicator, true);
      }
      return jdField_b_of_type_Baue;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklo
 * JD-Core Version:    0.7.0.1
 */