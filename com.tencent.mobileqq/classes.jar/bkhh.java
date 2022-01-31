import com.tencent.mobileqq.utils.httputils.HttpCommunicator;

public class bkhh
{
  private static bapv jdField_a_of_type_Bapv;
  private static bdlp jdField_a_of_type_Bdlp = new bkhi();
  private static bapv jdField_b_of_type_Bapv;
  private static bdlp jdField_b_of_type_Bdlp = new bkhj();
  
  public static bapv a()
  {
    if (jdField_a_of_type_Bapv == null) {}
    try
    {
      if (jdField_a_of_type_Bapv == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_Bdlp, 128);
        localHttpCommunicator.a();
        jdField_a_of_type_Bapv = new baqy(localHttpCommunicator, true);
      }
      return jdField_a_of_type_Bapv;
    }
    finally {}
  }
  
  public static bapv b()
  {
    if (jdField_b_of_type_Bapv == null) {}
    try
    {
      if (jdField_b_of_type_Bapv == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_b_of_type_Bdlp, 128);
        localHttpCommunicator.a();
        jdField_b_of_type_Bapv = new baqy(localHttpCommunicator, true);
      }
      return jdField_b_of_type_Bapv;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhh
 * JD-Core Version:    0.7.0.1
 */