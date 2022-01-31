import common.config.service.QzoneConfig;

public class bihj
{
  private static volatile bihj jdField_a_of_type_Bihj;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bihj a()
  {
    if (jdField_a_of_type_Bihj == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bihj == null) {
        jdField_a_of_type_Bihj = new bihj();
      }
      return jdField_a_of_type_Bihj;
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bihj
 * JD-Core Version:    0.7.0.1
 */