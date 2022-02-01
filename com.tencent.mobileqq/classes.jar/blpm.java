import common.config.service.QzoneConfig;

public class blpm
{
  private static volatile blpm jdField_a_of_type_Blpm;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static blpm a()
  {
    if (jdField_a_of_type_Blpm == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Blpm == null) {
        jdField_a_of_type_Blpm = new blpm();
      }
      return jdField_a_of_type_Blpm;
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpm
 * JD-Core Version:    0.7.0.1
 */