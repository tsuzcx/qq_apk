import com.tencent.mobileqq.shortvideo.resource.GestureResource;

public class bflp
  implements GestureResource
{
  public static String a;
  public static boolean a;
  public static String b = "200";
  public static String c = "20";
  
  static
  {
    jdField_a_of_type_JavaLangString = "5";
  }
  
  public String getGestureGapFrame()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public String getGestureGapTime()
  {
    return b;
  }
  
  public boolean getGestureShouldUpload()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public String getGestureThreadColdTime()
  {
    return c;
  }
  
  public String getModelPath()
  {
    return axgw.a();
  }
  
  public String getSoPathDir()
  {
    return axgw.b();
  }
  
  public boolean isGestureEnable()
  {
    return axgp.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bflp
 * JD-Core Version:    0.7.0.1
 */