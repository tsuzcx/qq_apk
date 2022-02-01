import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class axej
{
  public String a;
  public List<String> a;
  public boolean a;
  
  public axej()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static axej a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      axej localaxej = new axej();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("mainswitch", 0) == 1) {}
      for (;;)
      {
        localaxej.jdField_a_of_type_Boolean = bool;
        localaxej.jdField_a_of_type_JavaLangString = paramString.optString("qmcf", "");
        paramString = a(paramString.optJSONArray("black"));
        localaxej.jdField_a_of_type_JavaUtilList.addAll(paramString);
        return localaxej;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axej
 * JD-Core Version:    0.7.0.1
 */