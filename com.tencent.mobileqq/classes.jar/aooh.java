import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aooh
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  
  public aooh()
  {
    this.jdField_a_of_type_JavaLangString = "0.0f|0.0f|0.0f|0.0f";
    this.jdField_b_of_type_JavaLangString = "-1";
    this.jdField_c_of_type_JavaLangString = "-1";
  }
  
  public static aooh a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        aooh localaooh = new aooh();
        paramString = new JSONObject(paramString);
        localaooh.jdField_a_of_type_JavaLangString = paramString.optString("userratio_new", "0.0f|0.0f|0.0f|0.0f");
        localaooh.jdField_b_of_type_JavaLangString = paramString.optString("extralsteps_new", "-1");
        localaooh.jdField_c_of_type_JavaLangString = paramString.optString("predownloadwhitelist_new", "-1");
        localaooh.e = paramString.optBoolean("useapm_new", false);
        paramString = Float.valueOf(Float.parseFloat(paramString.optString("suspend_user_ratio", "0.0f")));
        float f1;
        float f2;
        float f3;
        float f4;
        if (paramString != null)
        {
          if (paramString.floatValue() > Math.random())
          {
            bool = true;
            localaooh.f = bool;
          }
        }
        else if (!localaooh.jdField_a_of_type_JavaLangString.isEmpty())
        {
          paramString = localaooh.jdField_a_of_type_JavaLangString.split("\\|");
          if (paramString.length == 4)
          {
            f1 = Float.parseFloat(paramString[0]);
            f2 = Float.parseFloat(paramString[1]);
            f3 = Float.parseFloat(paramString[2]);
            f4 = Float.parseFloat(paramString[3]);
            if (f1 <= Math.random()) {
              break label347;
            }
            bool = true;
            label185:
            localaooh.jdField_a_of_type_Boolean = bool;
            if (f2 <= Math.random()) {
              break label353;
            }
            bool = true;
            label204:
            localaooh.jdField_b_of_type_Boolean = bool;
            if (f3 <= Math.random()) {
              break label359;
            }
            bool = true;
            label223:
            localaooh.jdField_c_of_type_Boolean = bool;
            if (f4 <= Math.random()) {
              break label365;
            }
          }
        }
        label347:
        label353:
        label359:
        label365:
        for (boolean bool = true;; bool = false)
        {
          localaooh.d = bool;
          QLog.d("Perf", 1, "disable_preload_user_ratio = " + f1 + ",disable_predownload_user_ratio = " + f2 + ",disable_gettroop_user_ratio = " + f3 + ",enable_auto_user_ratio = " + f4);
          if (QLog.isColorLevel()) {
            QLog.d("Perf", 2, "confBean = " + localaooh.toString());
          }
          return localaooh;
          bool = false;
          break;
          bool = false;
          break label185;
          bool = false;
          break label204;
          bool = false;
          break label223;
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
    return "LowEndPerfBean{mDisablePreloadProcess=" + this.jdField_a_of_type_Boolean + ",mDisablePredownload=" + this.jdField_b_of_type_Boolean + ",mDisableGetTroopList=" + this.jdField_c_of_type_Boolean + ",mEnableAutomatorDelay=" + this.d + ",mUserRatio=" + this.jdField_a_of_type_JavaLangString + ",mExtraSteps=" + this.jdField_b_of_type_JavaLangString + ",mPredownLoadWhiteList=" + this.jdField_c_of_type_JavaLangString + ",mUseApmConfig=" + this.e + ",mSuspend_Thread=" + this.f + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aooh
 * JD-Core Version:    0.7.0.1
 */