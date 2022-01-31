import common.config.service.QzoneConfig;

public class bgfu
{
  private static volatile bgfu jdField_a_of_type_Bgfu;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bgfu a()
  {
    if (jdField_a_of_type_Bgfu == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bgfu == null) {
        jdField_a_of_type_Bgfu = new bgfu();
      }
      return jdField_a_of_type_Bgfu;
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgfu
 * JD-Core Version:    0.7.0.1
 */