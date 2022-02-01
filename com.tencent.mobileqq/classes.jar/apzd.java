import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apzd
{
  private static final apzd jdField_a_of_type_Apzd = new apzd();
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  
  public static apzd a(aptx[] paramArrayOfaptx)
  {
    Object localObject;
    if (paramArrayOfaptx == null) {
      localObject = jdField_a_of_type_Apzd;
    }
    for (;;)
    {
      return localObject;
      try
      {
        apzd localapzd = new apzd();
        int j = paramArrayOfaptx.length;
        int i = 0;
        localObject = localapzd;
        if (i >= j) {
          continue;
        }
        localObject = new JSONObject(paramArrayOfaptx[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("visible", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localapzd.jdField_a_of_type_Boolean = bool;
          localapzd.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("guideText", "");
          localapzd.b = ((JSONObject)localObject).optString("guideHighlightText", "");
          localapzd.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("showIntervalMs", 0L);
          i += 1;
          break;
        }
        return jdField_a_of_type_Apzd;
      }
      catch (Exception paramArrayOfaptx)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfaptx);
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
 * Qualified Name:     apzd
 * JD-Core Version:    0.7.0.1
 */