import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class arhv
{
  private ArrayList<arhw> a = new ArrayList(3);
  
  public static arhv a(aqxa paramaqxa)
  {
    arhv localarhv = new arhv();
    if (paramaqxa != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramaqxa = new JSONObject(paramaqxa.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramaqxa != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramaqxa.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramaqxa.optJSONObject(i);
            if (localJSONObject == null) {
              break label298;
            }
            arhw localarhw = new arhw();
            localarhw.jdField_a_of_type_Long = localJSONObject.optLong("appID");
            localarhw.f = localJSONObject.optString("type");
            localarhw.jdField_a_of_type_JavaLangString = localJSONObject.optString("bgBeginColor");
            localarhw.b = localJSONObject.optString("bgEndColor");
            localarhw.c = localJSONObject.optString("title");
            localarhw.d = localJSONObject.optString("subTitle");
            localarhw.b = localJSONObject.optString("bgEndColor");
            localarhw.e = localJSONObject.optString("icon");
            localarhw.g = localJSONObject.optString("schemeOrUrl");
            localarhw.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("extra");
            localArrayList.add(localarhw);
            break label298;
          }
          localarhv.a(localArrayList);
        }
      }
      catch (Exception paramaqxa)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramaqxa.toString());
        return localarhv;
      }
      return localarhv;
      label298:
      i += 1;
    }
  }
  
  private void a(ArrayList<arhw> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<arhw> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhv
 * JD-Core Version:    0.7.0.1
 */