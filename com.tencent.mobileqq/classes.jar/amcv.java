import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amcv
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public amcv()
  {
    this.jdField_a_of_type_JavaLangString = "0.0f|0.0f|0.0f|0.0f";
    this.jdField_b_of_type_JavaLangString = "-1";
    this.jdField_c_of_type_JavaLangString = "-1";
  }
  
  public static amcv a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        amcv localamcv = new amcv();
        paramString = new JSONObject(paramString);
        localamcv.jdField_a_of_type_JavaLangString = paramString.optString("userratio_new", "0.0f|0.0f|0.0f|0.0f");
        localamcv.jdField_b_of_type_JavaLangString = paramString.optString("extralsteps_new", "-1");
        localamcv.jdField_c_of_type_JavaLangString = paramString.optString("predownloadwhitelist_new", "-1");
        localamcv.e = paramString.optBoolean("useapm_new", false);
        float f1;
        float f2;
        float f3;
        float f4;
        if (!localamcv.jdField_a_of_type_JavaLangString.isEmpty())
        {
          paramString = localamcv.jdField_a_of_type_JavaLangString.split("\\|");
          if (paramString.length == 4)
          {
            f1 = Float.parseFloat(paramString[0]);
            f2 = Float.parseFloat(paramString[1]);
            f3 = Float.parseFloat(paramString[2]);
            f4 = Float.parseFloat(paramString[3]);
            if (f1 <= Math.random()) {
              break label300;
            }
            bool = true;
            localamcv.jdField_a_of_type_Boolean = bool;
            if (f2 <= Math.random()) {
              break label306;
            }
            bool = true;
            label163:
            localamcv.jdField_b_of_type_Boolean = bool;
            if (f3 <= Math.random()) {
              break label312;
            }
            bool = true;
            label182:
            localamcv.jdField_c_of_type_Boolean = bool;
            if (f4 <= Math.random()) {
              break label318;
            }
          }
        }
        label300:
        label306:
        label312:
        label318:
        for (boolean bool = true;; bool = false)
        {
          localamcv.d = bool;
          QLog.d("Perf", 1, "disable_preload_user_ratio = " + f1 + ",disable_predownload_user_ratio = " + f2 + ",disable_gettroop_user_ratio = " + f3 + ",enable_auto_user_ratio = " + f4);
          if (QLog.isColorLevel()) {
            QLog.d("Perf", 2, "confBean = " + localamcv.toString());
          }
          return localamcv;
          bool = false;
          break;
          bool = false;
          break label163;
          bool = false;
          break label182;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Throwable paramString) {}
    }
    QLog.e("Perf", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public boolean a()
  {
    return !this.e;
  }
  
  public String toString()
  {
    return "LowEndPerfBean{mDisablePreloadProcess=" + this.jdField_a_of_type_Boolean + ",mDisablePredownload=" + this.jdField_b_of_type_Boolean + ",mDisableGetTroopList=" + this.jdField_c_of_type_Boolean + ",mEnableAutomatorDelay=" + this.d + ",mUserRatio=" + this.jdField_a_of_type_JavaLangString + ",mExtraSteps=" + this.jdField_b_of_type_JavaLangString + ",mPredownLoadWhiteList=" + this.jdField_c_of_type_JavaLangString + ",mUseApmConfig=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcv
 * JD-Core Version:    0.7.0.1
 */