import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class anaw
{
  private HashMap<String, anax> a = new HashMap();
  
  public static anaw a(amph paramamph)
  {
    anaw localanaw = new anaw();
    if (paramamph != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramamph = new JSONObject(paramamph.jdField_a_of_type_JavaLangString);
      if (paramamph.has("emoji"))
      {
        paramamph = paramamph.optJSONObject("emoji");
        if (paramamph != null)
        {
          anax localanax = new anax();
          localanax.jdField_a_of_type_Int = paramamph.optInt("switch", 0);
          localanax.jdField_a_of_type_JavaLangString = paramamph.optString("url", "");
          localanaw.a.put("emoji", localanax);
        }
      }
    }
    catch (Exception paramamph)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramamph.toString());
    }
    return localanaw;
    return localanaw;
  }
  
  public String a()
  {
    anax localanax = (anax)this.a.get("emoji");
    if (localanax != null) {
      return localanax.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    anax localanax = (anax)this.a.get("emoji");
    if (localanax != null) {
      return localanax.jdField_a_of_type_Int == 1;
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
 * Qualified Name:     anaw
 * JD-Core Version:    0.7.0.1
 */