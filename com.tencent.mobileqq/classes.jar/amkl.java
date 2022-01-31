import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class amkl
{
  private HashMap<String, amkm> a = new HashMap();
  
  public static amkl a(alzs paramalzs)
  {
    amkl localamkl = new amkl();
    if (paramalzs != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramalzs = new JSONObject(paramalzs.jdField_a_of_type_JavaLangString);
      if (paramalzs.has("emoji"))
      {
        paramalzs = paramalzs.optJSONObject("emoji");
        if (paramalzs != null)
        {
          amkm localamkm = new amkm();
          localamkm.jdField_a_of_type_Int = paramalzs.optInt("switch", 0);
          localamkm.jdField_a_of_type_JavaLangString = paramalzs.optString("url", "");
          localamkl.a.put("emoji", localamkm);
        }
      }
    }
    catch (Exception paramalzs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramalzs.toString());
    }
    return localamkl;
    return localamkl;
  }
  
  public String a()
  {
    amkm localamkm = (amkm)this.a.get("emoji");
    if (localamkm != null) {
      return localamkm.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    amkm localamkm = (amkm)this.a.get("emoji");
    if (localamkm != null) {
      return localamkm.jdField_a_of_type_Int == 1;
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
 * Qualified Name:     amkl
 * JD-Core Version:    0.7.0.1
 */