import java.util.HashMap;

public class bady
  extends badz
{
  public int a;
  public boolean a;
  
  public bady()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public HashMap<String, String> a(String paramString)
  {
    if ("RealShortVideo.Record".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_cameraID", String.valueOf(this.jdField_a_of_type_Int));
      paramString.put("param_hasMultiSegments", String.valueOf(this.jdField_a_of_type_Boolean));
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bady
 * JD-Core Version:    0.7.0.1
 */