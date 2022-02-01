import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arbp
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
  public boolean g;
  public boolean h = true;
  
  public arbp()
  {
    this.jdField_a_of_type_JavaLangString = "0.0f|0.0f|0.0f|0.0f";
    this.jdField_b_of_type_JavaLangString = "-1";
    this.jdField_c_of_type_JavaLangString = "-1";
  }
  
  public static arbp a(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      try
      {
        arbp localarbp = new arbp();
        Object localObject = new JSONObject(paramString);
        localarbp.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("userratio_new", "0.0f|0.0f|0.0f|0.0f");
        localarbp.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("extralsteps_new", "-1");
        localarbp.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("predownloadwhitelist_new", "-1");
        localarbp.e = ((JSONObject)localObject).optBoolean("useapm_new", false);
        localarbp.h = ((JSONObject)localObject).optBoolean("suspendWhiteListOnly", true);
        paramString = Float.valueOf(Float.parseFloat(((JSONObject)localObject).optString("suspend_user_ratio", "0.0f")));
        if (paramString != null)
        {
          if (paramString.floatValue() > Math.random())
          {
            bool = true;
            localarbp.f = bool;
          }
        }
        else
        {
          localObject = Float.valueOf(Float.parseFloat(((JSONObject)localObject).optString("fake_suspend_user_ratio", "0.0f")));
          if (localObject != null)
          {
            if (((Float)localObject).floatValue() <= Math.random()) {
              break label472;
            }
            bool = true;
            localarbp.g = bool;
          }
          if (!localarbp.jdField_a_of_type_JavaLangString.isEmpty())
          {
            String[] arrayOfString = localarbp.jdField_a_of_type_JavaLangString.split("\\|");
            if (arrayOfString.length == 4)
            {
              float f1 = Float.parseFloat(arrayOfString[0]);
              float f2 = Float.parseFloat(arrayOfString[1]);
              float f3 = Float.parseFloat(arrayOfString[2]);
              float f4 = Float.parseFloat(arrayOfString[3]);
              if (f1 <= Math.random()) {
                break label478;
              }
              bool = true;
              localarbp.jdField_a_of_type_Boolean = bool;
              if (f2 <= Math.random()) {
                break label484;
              }
              bool = true;
              localarbp.jdField_b_of_type_Boolean = bool;
              if (f3 <= Math.random()) {
                break label490;
              }
              bool = true;
              localarbp.jdField_c_of_type_Boolean = bool;
              if (f4 <= Math.random()) {
                break label496;
              }
              bool = true;
              localarbp.d = bool;
              QLog.d("Perf", 1, "disable_preload_user_ratio = " + f1 + ",disable_predownload_user_ratio = " + f2 + ",disable_gettroop_user_ratio = " + f3 + ",enable_auto_user_ratio = " + f4 + ",suspend_user_ratio = " + paramString + ",fake_suspend_user_ratio = " + localObject);
            }
          }
          paramString = localarbp;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Perf", 2, "confBean = " + localarbp.toString());
          return localarbp;
        }
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Perf", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
      continue;
      label472:
      bool = false;
      continue;
      label478:
      bool = false;
      continue;
      label484:
      bool = false;
      continue;
      label490:
      bool = false;
      continue;
      label496:
      bool = false;
    }
  }
  
  public boolean a()
  {
    return !this.e;
  }
  
  public String toString()
  {
    return "LowEndPerfBean{mDisablePreloadProcess=" + this.jdField_a_of_type_Boolean + ",mDisablePredownload=" + this.jdField_b_of_type_Boolean + ",mDisableGetTroopList=" + this.jdField_c_of_type_Boolean + ",mEnableAutomatorDelay=" + this.d + ",mUserRatio=" + this.jdField_a_of_type_JavaLangString + ",mExtraSteps=" + this.jdField_b_of_type_JavaLangString + ",mPredownLoadWhiteList=" + this.jdField_c_of_type_JavaLangString + ",mUseApmConfig=" + this.e + ",mSuspend_Thread=" + this.f + ",mFake_Suspend_Thread = " + this.g + ",mSuspendWhiteListThreadOnly = " + this.h + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbp
 * JD-Core Version:    0.7.0.1
 */