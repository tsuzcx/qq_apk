import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class amxg
{
  private ArrayList<amxh> a = new ArrayList(3);
  
  public static amxg a(amph paramamph)
  {
    amxg localamxg = new amxg();
    if (paramamph != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramamph = new JSONObject(paramamph.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramamph != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramamph.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramamph.optJSONObject(i);
            if (localJSONObject == null) {
              break label286;
            }
            amxh localamxh = new amxh();
            localamxh.jdField_a_of_type_Long = localJSONObject.optLong("appID");
            localamxh.f = localJSONObject.optString("type");
            localamxh.jdField_a_of_type_JavaLangString = localJSONObject.optString("bgBeginColor");
            localamxh.b = localJSONObject.optString("bgEndColor");
            localamxh.c = localJSONObject.optString("title");
            localamxh.d = localJSONObject.optString("subTitle");
            localamxh.b = localJSONObject.optString("bgEndColor");
            localamxh.e = localJSONObject.optString("icon");
            localamxh.g = localJSONObject.optString("schemeOrUrl");
            localArrayList.add(localamxh);
            break label286;
          }
          localamxg.a(localArrayList);
        }
      }
      catch (Exception paramamph)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramamph.toString());
        return localamxg;
      }
      return localamxg;
      label286:
      i += 1;
    }
  }
  
  private void a(ArrayList<amxh> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<amxh> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxg
 * JD-Core Version:    0.7.0.1
 */