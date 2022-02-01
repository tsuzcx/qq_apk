import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bggw
{
  private HashMap<Integer, bghb> a = new HashMap();
  
  public static bggw a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JoinTroopSecurityTipsConfig.config", 2, "content : " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      int i;
      bghb localbghb;
      int j;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("ui");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = 0;
          if (i < paramString.length())
          {
            Object localObject = paramString.getJSONObject(i);
            if (localObject == null) {
              break label307;
            }
            localbghb = new bghb();
            localbghb.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("id", 0);
            localbghb.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("title", "");
            localbghb.b = ((JSONObject)localObject).optString("text", "");
            localObject = ((JSONObject)localObject).getJSONArray("btns");
            if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
              break label292;
            }
            j = 0;
            if (j >= ((JSONArray)localObject).length()) {
              break label292;
            }
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
            if (localJSONObject == null) {
              break label314;
            }
            localbghb.getClass();
            bghc localbghc = new bghc(localbghb);
            localbghc.jdField_a_of_type_JavaLangString = localJSONObject.optString("text", "");
            localbghc.b = localJSONObject.optString("action", "");
            localbghc.c = localJSONObject.optString("url", "");
            localbghb.jdField_a_of_type_JavaUtilList.add(localbghc);
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = new bggw();
        paramString.a = localHashMap;
        return paramString;
      }
      label292:
      localHashMap.put(Integer.valueOf(localbghb.jdField_a_of_type_Int), localbghb);
      label307:
      i += 1;
      continue;
      label314:
      j += 1;
    }
  }
  
  private boolean a(bghb parambghb)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((parambghb == null) || (TextUtils.isEmpty(parambghb.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parambghb.b)))
    {
      bool1 = true;
      return bool1;
    }
    if ((parambghb.jdField_a_of_type_JavaUtilList == null) || (parambghb.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if (i >= parambghb.jdField_a_of_type_JavaUtilList.size()) {
        break label139;
      }
      bghc localbghc = (bghc)parambghb.jdField_a_of_type_JavaUtilList.get(i);
      if (localbghc != null)
      {
        if (TextUtils.isEmpty(localbghc.jdField_a_of_type_JavaLangString)) {
          return true;
        }
        bool1 = bool2;
        if (!"web".equals(localbghc.b)) {
          break;
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(localbghc.c)) {
          break;
        }
        return true;
      }
      i += 1;
    }
    label139:
    return true;
  }
  
  public bghb a(int paramInt)
  {
    bghb localbghb2 = (bghb)this.a.get(Integer.valueOf(paramInt));
    bghb localbghb1 = localbghb2;
    if (a(localbghb2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JoinTroopSecurityTipsConfig.config", 2, "getItem isInvalidItem");
      }
      localbghb1 = null;
    }
    return localbghb1;
  }
  
  public bghb a(Context paramContext)
  {
    bghb localbghb = new bghb();
    localbghb.jdField_a_of_type_Int = 0;
    localbghb.jdField_a_of_type_JavaLangString = paramContext.getString(2131693166);
    localbghb.b = paramContext.getString(2131693165);
    localbghb.getClass();
    bghc localbghc = new bghc(localbghb);
    localbghc.jdField_a_of_type_JavaLangString = paramContext.getString(2131693164);
    localbghb.jdField_a_of_type_JavaUtilList.add(localbghc);
    return localbghb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggw
 * JD-Core Version:    0.7.0.1
 */