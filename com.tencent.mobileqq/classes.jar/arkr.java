import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class arkr
{
  private ArrayList<arks> a = new ArrayList(3);
  
  public static arkr a(araj paramaraj)
  {
    arkr localarkr = new arkr();
    if (paramaraj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramaraj = new JSONObject(paramaraj.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramaraj != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramaraj.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramaraj.optJSONObject(i);
            if (localJSONObject == null) {
              break label298;
            }
            arks localarks = new arks();
            localarks.jdField_a_of_type_Long = localJSONObject.optLong("appID");
            localarks.f = localJSONObject.optString("type");
            localarks.jdField_a_of_type_JavaLangString = localJSONObject.optString("bgBeginColor");
            localarks.b = localJSONObject.optString("bgEndColor");
            localarks.c = localJSONObject.optString("title");
            localarks.d = localJSONObject.optString("subTitle");
            localarks.b = localJSONObject.optString("bgEndColor");
            localarks.e = localJSONObject.optString("icon");
            localarks.g = localJSONObject.optString("schemeOrUrl");
            localarks.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("extra");
            localArrayList.add(localarks);
            break label298;
          }
          localarkr.a(localArrayList);
        }
      }
      catch (Exception paramaraj)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramaraj.toString());
        return localarkr;
      }
      return localarkr;
      label298:
      i += 1;
    }
  }
  
  private void a(ArrayList<arks> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<arks> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkr
 * JD-Core Version:    0.7.0.1
 */