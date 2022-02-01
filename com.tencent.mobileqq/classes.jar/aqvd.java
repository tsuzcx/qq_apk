import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqvd
{
  private ArrayList<aqve> a = new ArrayList(3);
  
  public static aqvd a(aqlg paramaqlg)
  {
    aqvd localaqvd = new aqvd();
    if (paramaqlg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramaqlg = new JSONObject(paramaqlg.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramaqlg != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramaqlg.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramaqlg.optJSONObject(i);
            if (localJSONObject == null) {
              break label298;
            }
            aqve localaqve = new aqve();
            localaqve.jdField_a_of_type_Long = localJSONObject.optLong("appID");
            localaqve.f = localJSONObject.optString("type");
            localaqve.jdField_a_of_type_JavaLangString = localJSONObject.optString("bgBeginColor");
            localaqve.b = localJSONObject.optString("bgEndColor");
            localaqve.c = localJSONObject.optString("title");
            localaqve.d = localJSONObject.optString("subTitle");
            localaqve.b = localJSONObject.optString("bgEndColor");
            localaqve.e = localJSONObject.optString("icon");
            localaqve.g = localJSONObject.optString("schemeOrUrl");
            localaqve.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("extra");
            localArrayList.add(localaqve);
            break label298;
          }
          localaqvd.a(localArrayList);
        }
      }
      catch (Exception paramaqlg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramaqlg.toString());
        return localaqvd;
      }
      return localaqvd;
      label298:
      i += 1;
    }
  }
  
  private void a(ArrayList<aqve> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<aqve> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqvd
 * JD-Core Version:    0.7.0.1
 */