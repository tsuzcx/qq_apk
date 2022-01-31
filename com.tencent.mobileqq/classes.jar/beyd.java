import common.config.service.QzoneConfig;

public class beyd
{
  private static volatile beyd jdField_a_of_type_Beyd;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static beyd a()
  {
    if (jdField_a_of_type_Beyd == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Beyd == null) {
        jdField_a_of_type_Beyd = new beyd();
      }
      return jdField_a_of_type_Beyd;
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyd
 * JD-Core Version:    0.7.0.1
 */