import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class amxh
{
  private ArrayList<amxi> a = new ArrayList(3);
  
  public static amxh a(ampi paramampi)
  {
    amxh localamxh = new amxh();
    if (paramampi != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramampi = new JSONObject(paramampi.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramampi != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramampi.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramampi.optJSONObject(i);
            if (localJSONObject == null) {
              break label286;
            }
            amxi localamxi = new amxi();
            localamxi.jdField_a_of_type_Long = localJSONObject.optLong("appID");
            localamxi.f = localJSONObject.optString("type");
            localamxi.jdField_a_of_type_JavaLangString = localJSONObject.optString("bgBeginColor");
            localamxi.b = localJSONObject.optString("bgEndColor");
            localamxi.c = localJSONObject.optString("title");
            localamxi.d = localJSONObject.optString("subTitle");
            localamxi.b = localJSONObject.optString("bgEndColor");
            localamxi.e = localJSONObject.optString("icon");
            localamxi.g = localJSONObject.optString("schemeOrUrl");
            localArrayList.add(localamxi);
            break label286;
          }
          localamxh.a(localArrayList);
        }
      }
      catch (Exception paramampi)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramampi.toString());
        return localamxh;
      }
      return localamxh;
      label286:
      i += 1;
    }
  }
  
  private void a(ArrayList<amxi> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<amxi> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxh
 * JD-Core Version:    0.7.0.1
 */