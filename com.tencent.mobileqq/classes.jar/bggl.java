import common.config.service.QzoneConfig;

public class bggl
{
  private static volatile bggl jdField_a_of_type_Bggl;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bggl a()
  {
    if (jdField_a_of_type_Bggl == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bggl == null) {
        jdField_a_of_type_Bggl = new bggl();
      }
      return jdField_a_of_type_Bggl;
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bggl
 * JD-Core Version:    0.7.0.1
 */