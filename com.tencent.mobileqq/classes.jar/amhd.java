import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class amhd
{
  private ArrayList<amhe> a = new ArrayList(3);
  
  public static amhd a(alzs paramalzs)
  {
    amhd localamhd = new amhd();
    if (paramalzs != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramalzs = new JSONObject(paramalzs.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramalzs != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramalzs.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramalzs.optJSONObject(i);
            if (localJSONObject == null) {
              break label286;
            }
            amhe localamhe = new amhe();
            localamhe.jdField_a_of_type_Int = localJSONObject.optInt("appID");
            localamhe.f = localJSONObject.optString("type");
            localamhe.jdField_a_of_type_JavaLangString = localJSONObject.optString("bgBeginColor");
            localamhe.b = localJSONObject.optString("bgEndColor");
            localamhe.c = localJSONObject.optString("title");
            localamhe.d = localJSONObject.optString("subTitle");
            localamhe.b = localJSONObject.optString("bgEndColor");
            localamhe.e = localJSONObject.optString("icon");
            localamhe.g = localJSONObject.optString("schemeOrUrl");
            localArrayList.add(localamhe);
            break label286;
          }
          localamhd.a(localArrayList);
        }
      }
      catch (Exception paramalzs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramalzs.toString());
        return localamhd;
      }
      return localamhd;
      label286:
      i += 1;
    }
  }
  
  private void a(ArrayList<amhe> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<amhe> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhd
 * JD-Core Version:    0.7.0.1
 */