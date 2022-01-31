import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class artp
{
  public String a;
  public List<String> a;
  public boolean a;
  
  public artp()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static artp a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      artp localartp = new artp();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("mainswitch", 0) == 1) {}
      for (;;)
      {
        localartp.jdField_a_of_type_Boolean = bool;
        localartp.jdField_a_of_type_JavaLangString = paramString.optString("qmcf", "");
        paramString = a(paramString.optJSONArray("black"));
        localartp.jdField_a_of_type_JavaUtilList.addAll(paramString);
        return localartp;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("MultiAIOEntranceConfigProcessor", 2, "MultiAIOEntranceConfigData parse error", paramString);
    }
  }
  
  private static List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            localArrayList.add(paramJSONArray.getString(i).trim());
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("MultiAIOEntranceConfigProcessor", 2, "MultiAIOEntranceConfigData processJsonArray error", localException);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     artp
 * JD-Core Version:    0.7.0.1
 */