import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class azab
{
  static HashMap<String, Integer> a = new HashMap();
  
  static
  {
    a.put("str", Integer.valueOf(0));
    a.put("img", Integer.valueOf(1));
    a.put("video", Integer.valueOf(2));
    a.put("voice", Integer.valueOf(3));
    a.put("recite", Integer.valueOf(4));
    a.put("calculation", Integer.valueOf(7));
  }
  
  public static azaa a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static azaa a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.getString("type");
      localObject = (Integer)a.get(localObject);
      if (localObject == null) {
        return null;
      }
      switch (((Integer)localObject).intValue())
      {
      case 0: 
        paramJSONObject = new azaj(paramJSONObject);
        return paramJSONObject;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      break label142;
      return new azaf(paramJSONObject);
      return new azal(paramJSONObject);
      return new ayzz(paramJSONObject);
      return new azac(paramJSONObject);
      paramJSONObject = new ayzx(paramJSONObject);
      return paramJSONObject;
    }
    label142:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azab
 * JD-Core Version:    0.7.0.1
 */