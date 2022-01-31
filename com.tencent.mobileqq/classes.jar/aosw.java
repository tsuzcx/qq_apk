import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aosw
{
  private ArrayList<aosx> a = new ArrayList(3);
  
  public static aosw a(aoko paramaoko)
  {
    aosw localaosw = new aosw();
    if (paramaoko != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramaoko = new JSONObject(paramaoko.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramaoko != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramaoko.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramaoko.optJSONObject(i);
            if (localJSONObject == null) {
              break label298;
            }
            aosx localaosx = new aosx();
            localaosx.jdField_a_of_type_Long = localJSONObject.optLong("appID");
            localaosx.f = localJSONObject.optString("type");
            localaosx.jdField_a_of_type_JavaLangString = localJSONObject.optString("bgBeginColor");
            localaosx.b = localJSONObject.optString("bgEndColor");
            localaosx.c = localJSONObject.optString("title");
            localaosx.d = localJSONObject.optString("subTitle");
            localaosx.b = localJSONObject.optString("bgEndColor");
            localaosx.e = localJSONObject.optString("icon");
            localaosx.g = localJSONObject.optString("schemeOrUrl");
            localaosx.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("extra");
            localArrayList.add(localaosx);
            break label298;
          }
          localaosw.a(localArrayList);
        }
      }
      catch (Exception paramaoko)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramaoko.toString());
        return localaosw;
      }
      return localaosw;
      label298:
      i += 1;
    }
  }
  
  private void a(ArrayList<aosx> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<aosx> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aosw
 * JD-Core Version:    0.7.0.1
 */