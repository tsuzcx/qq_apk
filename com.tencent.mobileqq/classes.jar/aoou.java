import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoou
{
  private static final aoou jdField_a_of_type_Aoou = new aoou();
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  
  public static aoou a(aoko[] paramArrayOfaoko)
  {
    Object localObject;
    if (paramArrayOfaoko == null) {
      localObject = jdField_a_of_type_Aoou;
    }
    for (;;)
    {
      return localObject;
      try
      {
        aoou localaoou = new aoou();
        int j = paramArrayOfaoko.length;
        int i = 0;
        localObject = localaoou;
        if (i >= j) {
          continue;
        }
        localObject = new JSONObject(paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("visible", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaoou.jdField_a_of_type_Boolean = bool;
          localaoou.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("guideText", "");
          localaoou.b = ((JSONObject)localObject).optString("guideHighlightText", "");
          localaoou.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("showIntervalMs", 0L);
          i += 1;
          break;
        }
        return jdField_a_of_type_Aoou;
      }
      catch (Exception paramArrayOfaoko)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfaoko);
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
 * Qualified Name:     aoou
 * JD-Core Version:    0.7.0.1
 */