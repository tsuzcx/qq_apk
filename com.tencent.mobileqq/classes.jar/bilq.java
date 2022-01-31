import common.config.service.QzoneConfig;

public class bilq
{
  private static volatile bilq jdField_a_of_type_Bilq;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bilq a()
  {
    if (jdField_a_of_type_Bilq == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bilq == null) {
        jdField_a_of_type_Bilq = new bilq();
      }
      return jdField_a_of_type_Bilq;
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bilq
 * JD-Core Version:    0.7.0.1
 */