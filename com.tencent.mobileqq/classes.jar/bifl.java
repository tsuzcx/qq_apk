import com.tencent.mobileqq.utils.httputils.HttpCommunicator;

public class bifl
{
  private static aysa jdField_a_of_type_Aysa;
  private static bbmv jdField_a_of_type_Bbmv = new bifm();
  private static aysa jdField_b_of_type_Aysa;
  private static bbmv jdField_b_of_type_Bbmv = new bifn();
  
  public static aysa a()
  {
    if (jdField_a_of_type_Aysa == null) {}
    try
    {
      if (jdField_a_of_type_Aysa == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_Bbmv, 128);
        localHttpCommunicator.a();
        jdField_a_of_type_Aysa = new aytb(localHttpCommunicator, true);
      }
      return jdField_a_of_type_Aysa;
    }
    finally {}
  }
  
  public static aysa b()
  {
    if (jdField_b_of_type_Aysa == null) {}
    try
    {
      if (jdField_b_of_type_Aysa == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_b_of_type_Bbmv, 128);
        localHttpCommunicator.a();
        jdField_b_of_type_Aysa = new aytb(localHttpCommunicator, true);
      }
      return jdField_b_of_type_Aysa;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifl
 * JD-Core Version:    0.7.0.1
 */