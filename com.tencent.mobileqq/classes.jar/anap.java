import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class anap
{
  private HashMap<String, anaq> a = new HashMap();
  
  public static anap a(ampi paramampi)
  {
    anap localanap = new anap();
    if (paramampi != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramampi = new JSONObject(paramampi.jdField_a_of_type_JavaLangString);
      if (paramampi.has("emoji"))
      {
        paramampi = paramampi.optJSONObject("emoji");
        if (paramampi != null)
        {
          anaq localanaq = new anaq();
          localanaq.jdField_a_of_type_Int = paramampi.optInt("switch", 0);
          localanaq.jdField_a_of_type_JavaLangString = paramampi.optString("url", "");
          localanap.a.put("emoji", localanaq);
        }
      }
    }
    catch (Exception paramampi)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramampi.toString());
    }
    return localanap;
    return localanap;
  }
  
  public String a()
  {
    anaq localanaq = (anaq)this.a.get("emoji");
    if (localanaq != null) {
      return localanaq.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    anaq localanaq = (anaq)this.a.get("emoji");
    if (localanaq != null) {
      return localanaq.jdField_a_of_type_Int == 1;
    }
    return false;
  }
  
  public String toString()
  {
    if (this.a != null) {}
    for (String str = this.a.toString();; str = "null") {
      return String.format("mConfigData:%s ", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anap
 * JD-Core Version:    0.7.0.1
 */