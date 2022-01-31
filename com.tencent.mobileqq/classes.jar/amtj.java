import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amtj
{
  private static final amtj jdField_a_of_type_Amtj = new amtj();
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  
  public static amtj a(amph[] paramArrayOfamph)
  {
    Object localObject;
    if (paramArrayOfamph == null) {
      localObject = jdField_a_of_type_Amtj;
    }
    for (;;)
    {
      return localObject;
      try
      {
        amtj localamtj = new amtj();
        int j = paramArrayOfamph.length;
        int i = 0;
        localObject = localamtj;
        if (i >= j) {
          continue;
        }
        localObject = new JSONObject(paramArrayOfamph[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("visible", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localamtj.jdField_a_of_type_Boolean = bool;
          localamtj.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("guideText", "");
          localamtj.b = ((JSONObject)localObject).optString("guideHighlightText", "");
          localamtj.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("showIntervalMs", 0L);
          i += 1;
          break;
        }
        return jdField_a_of_type_Amtj;
      }
      catch (Exception paramArrayOfamph)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfamph);
      }
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amtj
 * JD-Core Version:    0.7.0.1
 */