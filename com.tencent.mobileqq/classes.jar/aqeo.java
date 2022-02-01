import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqeo
{
  private ArrayList<aqep> a = new ArrayList(3);
  
  public static aqeo a(aptx paramaptx)
  {
    aqeo localaqeo = new aqeo();
    if (paramaptx != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramaptx = new JSONObject(paramaptx.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramaptx != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramaptx.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramaptx.optJSONObject(i);
            if (localJSONObject == null) {
              break label298;
            }
            aqep localaqep = new aqep();
            localaqep.jdField_a_of_type_Long = localJSONObject.optLong("appID");
            localaqep.f = localJSONObject.optString("type");
            localaqep.jdField_a_of_type_JavaLangString = localJSONObject.optString("bgBeginColor");
            localaqep.b = localJSONObject.optString("bgEndColor");
            localaqep.c = localJSONObject.optString("title");
            localaqep.d = localJSONObject.optString("subTitle");
            localaqep.b = localJSONObject.optString("bgEndColor");
            localaqep.e = localJSONObject.optString("icon");
            localaqep.g = localJSONObject.optString("schemeOrUrl");
            localaqep.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("extra");
            localArrayList.add(localaqep);
            break label298;
          }
          localaqeo.a(localArrayList);
        }
      }
      catch (Exception paramaptx)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramaptx.toString());
        return localaqeo;
      }
      return localaqeo;
      label298:
      i += 1;
    }
  }
  
  private void a(ArrayList<aqep> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<aqep> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqeo
 * JD-Core Version:    0.7.0.1
 */