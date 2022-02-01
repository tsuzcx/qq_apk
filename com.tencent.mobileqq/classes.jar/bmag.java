import common.config.service.QzoneConfig;

public class bmag
{
  private static volatile bmag jdField_a_of_type_Bmag;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bmag a()
  {
    if (jdField_a_of_type_Bmag == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bmag == null) {
        jdField_a_of_type_Bmag = new bmag();
      }
      return jdField_a_of_type_Bmag;
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmag
 * JD-Core Version:    0.7.0.1
 */