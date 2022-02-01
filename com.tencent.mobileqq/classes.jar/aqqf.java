import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqqf
{
  private static final aqqf jdField_a_of_type_Aqqf = new aqqf();
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  
  public static aqqf a(aqlg[] paramArrayOfaqlg)
  {
    Object localObject;
    if (paramArrayOfaqlg == null) {
      localObject = jdField_a_of_type_Aqqf;
    }
    for (;;)
    {
      return localObject;
      try
      {
        aqqf localaqqf = new aqqf();
        int j = paramArrayOfaqlg.length;
        int i = 0;
        localObject = localaqqf;
        if (i >= j) {
          continue;
        }
        localObject = new JSONObject(paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("visible", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaqqf.jdField_a_of_type_Boolean = bool;
          localaqqf.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("guideText", "");
          localaqqf.b = ((JSONObject)localObject).optString("guideHighlightText", "");
          localaqqf.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("showIntervalMs", 0L);
          i += 1;
          break;
        }
        return jdField_a_of_type_Aqqf;
      }
      catch (Exception paramArrayOfaqlg)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfaqlg);
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
 * Qualified Name:     aqqf
 * JD-Core Version:    0.7.0.1
 */