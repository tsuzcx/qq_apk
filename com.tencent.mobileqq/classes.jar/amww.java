import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amww
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d = "";
  
  public amww()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_c_of_type_JavaLangString = "0";
  }
  
  public static amww a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        amww localamww = new amww();
        paramString = new JSONObject(paramString);
        if (paramString.has("wvShouldReportPerf"))
        {
          if (paramString.optInt("wvShouldReportPerf") == 1)
          {
            bool = true;
            localamww.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          if (paramString.has("wvShouldReportJsapiCall"))
          {
            if (paramString.optInt("wvShouldReportJsapiCall") != 1) {
              break label212;
            }
            bool = true;
            label70:
            localamww.jdField_b_of_type_Boolean = bool;
          }
          if (paramString.has("wvShouldReportOpenapiCall")) {
            if (paramString.optInt("wvShouldReportOpenapiCall") != 1) {
              break label217;
            }
          }
        }
        label212:
        label217:
        for (boolean bool = true;; bool = false)
        {
          localamww.jdField_c_of_type_Boolean = bool;
          if (paramString.has("wvPerformanceRate")) {
            localamww.jdField_a_of_type_JavaLangString = paramString.optString("wvPerformanceRate");
          }
          if (paramString.has("wvJsapiCallRate")) {
            localamww.jdField_b_of_type_JavaLangString = paramString.optString("wvJsapiCallRate");
          }
          if (paramString.has("wvSchemeRate")) {
            localamww.jdField_c_of_type_JavaLangString = paramString.optString("wvSchemeRate");
          }
          if (paramString.has("recogniseText")) {
            localamww.d = paramString.optString("recogniseText");
          }
          QLog.d("ConfBean", 2, "confBean = " + localamww.toString());
          return localamww;
          bool = false;
          break;
          bool = false;
          break label70;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("reportPerformance:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" reportJsapi:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" reportOpenapi:").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(" performanceRate:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" jsapiRate:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" schemeRate:").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" recogniseText:").append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amww
 * JD-Core Version:    0.7.0.1
 */