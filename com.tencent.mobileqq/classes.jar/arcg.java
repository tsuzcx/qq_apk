import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arcg
{
  private static final arcg jdField_a_of_type_Arcg = new arcg();
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  
  public static arcg a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject;
    if (paramArrayOfaqxa == null) {
      localObject = jdField_a_of_type_Arcg;
    }
    for (;;)
    {
      return localObject;
      try
      {
        arcg localarcg = new arcg();
        int j = paramArrayOfaqxa.length;
        int i = 0;
        localObject = localarcg;
        if (i >= j) {
          continue;
        }
        localObject = new JSONObject(paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("visible", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localarcg.jdField_a_of_type_Boolean = bool;
          localarcg.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("guideText", "");
          localarcg.b = ((JSONObject)localObject).optString("guideHighlightText", "");
          localarcg.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("showIntervalMs", 0L);
          i += 1;
          break;
        }
        return jdField_a_of_type_Arcg;
      }
      catch (Exception paramArrayOfaqxa)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfaqxa);
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
 * Qualified Name:     arcg
 * JD-Core Version:    0.7.0.1
 */