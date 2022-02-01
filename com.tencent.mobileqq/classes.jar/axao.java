import org.json.JSONObject;

public class axao
{
  public long a;
  public axan a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public String c;
  
  public static axao a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if (paramJSONObject == null) {
      return null;
    }
    axao localaxao = new axao();
    localaxao.jdField_a_of_type_JavaLangString = paramJSONObject.optString("id");
    localaxao.jdField_a_of_type_Long = awzy.b(localaxao.jdField_a_of_type_JavaLangString);
    localaxao.jdField_b_of_type_Long = awzy.a(localaxao.jdField_a_of_type_JavaLangString);
    localaxao.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
    if (paramJSONObject.optInt("enable") == 1)
    {
      bool1 = true;
      localaxao.jdField_a_of_type_Boolean = bool1;
      localaxao.c = paramJSONObject.optString("ruleWording");
      if (paramJSONObject.optInt("maybe_spread_user") != 1) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localaxao.jdField_b_of_type_Boolean = bool1;
      return localaxao;
      bool1 = false;
      break;
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
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axao
 * JD-Core Version:    0.7.0.1
 */