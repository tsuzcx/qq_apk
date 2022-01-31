import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aoon
{
  private ArrayList<aooo> a = new ArrayList(3);
  
  public static aoon a(aogf paramaogf)
  {
    aoon localaoon = new aoon();
    if (paramaogf != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramaogf = new JSONObject(paramaogf.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramaogf != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramaogf.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramaogf.optJSONObject(i);
            if (localJSONObject == null) {
              break label298;
            }
            aooo localaooo = new aooo();
            localaooo.jdField_a_of_type_Long = localJSONObject.optLong("appID");
            localaooo.f = localJSONObject.optString("type");
            localaooo.jdField_a_of_type_JavaLangString = localJSONObject.optString("bgBeginColor");
            localaooo.b = localJSONObject.optString("bgEndColor");
            localaooo.c = localJSONObject.optString("title");
            localaooo.d = localJSONObject.optString("subTitle");
            localaooo.b = localJSONObject.optString("bgEndColor");
            localaooo.e = localJSONObject.optString("icon");
            localaooo.g = localJSONObject.optString("schemeOrUrl");
            localaooo.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("extra");
            localArrayList.add(localaooo);
            break label298;
          }
          localaoon.a(localArrayList);
        }
      }
      catch (Exception paramaogf)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramaogf.toString());
        return localaoon;
      }
      return localaoon;
      label298:
      i += 1;
    }
  }
  
  private void a(ArrayList<aooo> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<aooo> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoon
 * JD-Core Version:    0.7.0.1
 */