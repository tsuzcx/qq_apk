import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arfn
{
  private static final arfn jdField_a_of_type_Arfn = new arfn();
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  
  public static arfn a(araj[] paramArrayOfaraj)
  {
    Object localObject;
    if (paramArrayOfaraj == null) {
      localObject = jdField_a_of_type_Arfn;
    }
    for (;;)
    {
      return localObject;
      try
      {
        arfn localarfn = new arfn();
        int j = paramArrayOfaraj.length;
        int i = 0;
        localObject = localarfn;
        if (i >= j) {
          continue;
        }
        localObject = new JSONObject(paramArrayOfaraj[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("visible", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localarfn.jdField_a_of_type_Boolean = bool;
          localarfn.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("guideText", "");
          localarfn.b = ((JSONObject)localObject).optString("guideHighlightText", "");
          localarfn.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("showIntervalMs", 0L);
          i += 1;
          break;
        }
        return jdField_a_of_type_Arfn;
      }
      catch (Exception paramArrayOfaraj)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfaraj);
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
 * Qualified Name:     arfn
 * JD-Core Version:    0.7.0.1
 */