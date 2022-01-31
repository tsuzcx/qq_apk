import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbyu
{
  public int a;
  public String a;
  public List<bbyw> a;
  public boolean a;
  public String b;
  public String c;
  
  public bbyu()
  {
    this.jdField_a_of_type_Int = -30009;
  }
  
  public bbyu(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = -30009;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("msg");
    if (paramJSONObject.optInt("openflag") == 1)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = paramJSONObject.optInt("ret", -30009);
      this.c = paramJSONObject.optString("content");
      this.b = paramJSONObject.optString("url");
      paramJSONObject = paramJSONObject.optString("list");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        break label96;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label96:
      paramJSONObject = new JSONArray(paramJSONObject);
      int j = paramJSONObject.length();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null) {
          this.jdField_a_of_type_JavaUtilList.add(new bbyw(localJSONObject.optString("num"), localJSONObject.optString("light")));
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    return "LiangHaoRsp{openFlag=" + this.jdField_a_of_type_Boolean + ", ret=" + this.jdField_a_of_type_Int + ", msg='" + this.jdField_a_of_type_JavaLangString + '\'' + ", moreUrl='" + this.b + '\'' + ", content='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbyu
 * JD-Core Version:    0.7.0.1
 */