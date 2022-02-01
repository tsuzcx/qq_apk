import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class awgp
{
  public long a;
  public awgn a;
  public String a;
  public ArrayList<awgo> a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public String c;
  
  public static awgp a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localawgp = new awgp();
    try
    {
      localawgp.jdField_a_of_type_JavaLangString = paramJSONObject.optString("id");
      localawgp.jdField_a_of_type_Long = awfy.b(localawgp.jdField_a_of_type_JavaLangString);
      localawgp.jdField_b_of_type_Long = awfy.a(localawgp.jdField_a_of_type_JavaLangString);
      localawgp.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
      if (paramJSONObject.optInt("enable") == 1)
      {
        bool = true;
        localawgp.jdField_a_of_type_Boolean = bool;
        localawgp.c = paramJSONObject.optString("ruleWording");
        if (paramJSONObject.optInt("maybe_spread_user") != 1) {
          break label174;
        }
      }
      label174:
      for (boolean bool = true;; bool = false)
      {
        localawgp.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("subLevelInfo")) {
          return localawgp;
        }
        paramJSONObject = paramJSONObject.optJSONArray("subLevelInfo");
        localawgp.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          awgo localawgo = awgo.a(paramJSONObject.getJSONObject(i));
          if (localawgo != null) {
            localawgp.jdField_a_of_type_JavaUtilArrayList.add(localawgo);
          }
          i += 1;
        }
        bool = false;
        break;
      }
      return localawgp;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("MutualMarkConfigIRType", 1, "parse error->" + paramJSONObject.toString());
      return null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("type=").append(this.jdField_a_of_type_Long).append("|");
    localStringBuilder.append("level=").append(this.jdField_b_of_type_Long).append("|");
    localStringBuilder.append("name=").append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuilder.append("enable=").append(this.jdField_a_of_type_Boolean).append("|");
    localStringBuilder.append("maybeSpreadUser=").append(this.jdField_b_of_type_Boolean).append("|");
    localStringBuilder.append("subLevelInfoArrayList=").append(this.jdField_a_of_type_JavaUtilArrayList).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgp
 * JD-Core Version:    0.7.0.1
 */