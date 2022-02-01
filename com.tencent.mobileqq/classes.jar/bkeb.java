import common.config.service.QzoneConfig;

public class bkeb
{
  private static volatile bkeb jdField_a_of_type_Bkeb;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bkeb a()
  {
    if (jdField_a_of_type_Bkeb == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bkeb == null) {
        jdField_a_of_type_Bkeb = new bkeb();
      }
      return jdField_a_of_type_Bkeb;
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkeb
 * JD-Core Version:    0.7.0.1
 */