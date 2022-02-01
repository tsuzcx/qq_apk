import common.config.service.QzoneConfig;

public class bkzd
{
  private static volatile bkzd jdField_a_of_type_Bkzd;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bkzd a()
  {
    if (jdField_a_of_type_Bkzd == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bkzd == null) {
        jdField_a_of_type_Bkzd = new bkzd();
      }
      return jdField_a_of_type_Bkzd;
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzd
 * JD-Core Version:    0.7.0.1
 */