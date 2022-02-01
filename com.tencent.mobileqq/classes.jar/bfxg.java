import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfxg
{
  private HashMap<Integer, bfxl> a = new HashMap();
  
  public static bfxg a(String paramString)
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
      bfxl localbfxl;
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
            localbfxl = new bfxl();
            localbfxl.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("id", 0);
            localbfxl.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("title", "");
            localbfxl.b = ((JSONObject)localObject).optString("text", "");
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
            localbfxl.getClass();
            bfxm localbfxm = new bfxm(localbfxl);
            localbfxm.jdField_a_of_type_JavaLangString = localJSONObject.optString("text", "");
            localbfxm.b = localJSONObject.optString("action", "");
            localbfxm.c = localJSONObject.optString("url", "");
            localbfxl.jdField_a_of_type_JavaUtilList.add(localbfxm);
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = new bfxg();
        paramString.a = localHashMap;
        return paramString;
      }
      label292:
      localHashMap.put(Integer.valueOf(localbfxl.jdField_a_of_type_Int), localbfxl);
      label307:
      i += 1;
      continue;
      label314:
      j += 1;
    }
  }
  
  private boolean a(bfxl parambfxl)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((parambfxl == null) || (TextUtils.isEmpty(parambfxl.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parambfxl.b)))
    {
      bool1 = true;
      return bool1;
    }
    if ((parambfxl.jdField_a_of_type_JavaUtilList == null) || (parambfxl.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if (i >= parambfxl.jdField_a_of_type_JavaUtilList.size()) {
        break label139;
      }
      bfxm localbfxm = (bfxm)parambfxl.jdField_a_of_type_JavaUtilList.get(i);
      if (localbfxm != null)
      {
        if (TextUtils.isEmpty(localbfxm.jdField_a_of_type_JavaLangString)) {
          return true;
        }
        bool1 = bool2;
        if (!"web".equals(localbfxm.b)) {
          break;
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(localbfxm.c)) {
          break;
        }
        return true;
      }
      i += 1;
    }
    label139:
    return true;
  }
  
  public bfxl a(int paramInt)
  {
    bfxl localbfxl2 = (bfxl)this.a.get(Integer.valueOf(paramInt));
    bfxl localbfxl1 = localbfxl2;
    if (a(localbfxl2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JoinTroopSecurityTipsConfig.config", 2, "getItem isInvalidItem");
      }
      localbfxl1 = null;
    }
    return localbfxl1;
  }
  
  public bfxl a(Context paramContext)
  {
    bfxl localbfxl = new bfxl();
    localbfxl.jdField_a_of_type_Int = 0;
    localbfxl.jdField_a_of_type_JavaLangString = paramContext.getString(2131693409);
    localbfxl.b = paramContext.getString(2131693408);
    localbfxl.getClass();
    bfxm localbfxm = new bfxm(localbfxl);
    localbfxm.jdField_a_of_type_JavaLangString = paramContext.getString(2131693407);
    localbfxl.jdField_a_of_type_JavaUtilList.add(localbfxm);
    return localbfxl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxg
 * JD-Core Version:    0.7.0.1
 */