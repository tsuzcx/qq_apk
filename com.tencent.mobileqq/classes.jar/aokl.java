import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aokl
{
  private static final aokl jdField_a_of_type_Aokl = new aokl();
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  
  public static aokl a(aogf[] paramArrayOfaogf)
  {
    Object localObject;
    if (paramArrayOfaogf == null) {
      localObject = jdField_a_of_type_Aokl;
    }
    for (;;)
    {
      return localObject;
      try
      {
        aokl localaokl = new aokl();
        int j = paramArrayOfaogf.length;
        int i = 0;
        localObject = localaokl;
        if (i >= j) {
          continue;
        }
        localObject = new JSONObject(paramArrayOfaogf[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("visible", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaokl.jdField_a_of_type_Boolean = bool;
          localaokl.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("guideText", "");
          localaokl.b = ((JSONObject)localObject).optString("guideHighlightText", "");
          localaokl.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("showIntervalMs", 0L);
          i += 1;
          break;
        }
        return jdField_a_of_type_Aokl;
      }
      catch (Exception paramArrayOfaogf)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfaogf);
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
 * Qualified Name:     aokl
 * JD-Core Version:    0.7.0.1
 */