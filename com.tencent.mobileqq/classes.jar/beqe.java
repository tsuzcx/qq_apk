import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class beqe
{
  private HashMap<Integer, beqj> a = new HashMap();
  
  public static beqe a(String paramString)
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
      beqj localbeqj;
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
            localbeqj = new beqj();
            localbeqj.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("id", 0);
            localbeqj.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("title", "");
            localbeqj.b = ((JSONObject)localObject).optString("text", "");
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
            localbeqj.getClass();
            beqk localbeqk = new beqk(localbeqj);
            localbeqk.jdField_a_of_type_JavaLangString = localJSONObject.optString("text", "");
            localbeqk.b = localJSONObject.optString("action", "");
            localbeqk.c = localJSONObject.optString("url", "");
            localbeqj.jdField_a_of_type_JavaUtilList.add(localbeqk);
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = new beqe();
        paramString.a = localHashMap;
        return paramString;
      }
      label292:
      localHashMap.put(Integer.valueOf(localbeqj.jdField_a_of_type_Int), localbeqj);
      label307:
      i += 1;
      continue;
      label314:
      j += 1;
    }
  }
  
  private boolean a(beqj parambeqj)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((parambeqj == null) || (TextUtils.isEmpty(parambeqj.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parambeqj.b)))
    {
      bool1 = true;
      return bool1;
    }
    if ((parambeqj.jdField_a_of_type_JavaUtilList == null) || (parambeqj.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if (i >= parambeqj.jdField_a_of_type_JavaUtilList.size()) {
        break label139;
      }
      beqk localbeqk = (beqk)parambeqj.jdField_a_of_type_JavaUtilList.get(i);
      if (localbeqk != null)
      {
        if (TextUtils.isEmpty(localbeqk.jdField_a_of_type_JavaLangString)) {
          return true;
        }
        bool1 = bool2;
        if (!"web".equals(localbeqk.b)) {
          break;
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(localbeqk.c)) {
          break;
        }
        return true;
      }
      i += 1;
    }
    label139:
    return true;
  }
  
  public beqj a(int paramInt)
  {
    beqj localbeqj2 = (beqj)this.a.get(Integer.valueOf(paramInt));
    beqj localbeqj1 = localbeqj2;
    if (a(localbeqj2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JoinTroopSecurityTipsConfig.config", 2, "getItem isInvalidItem");
      }
      localbeqj1 = null;
    }
    return localbeqj1;
  }
  
  public beqj a(Context paramContext)
  {
    beqj localbeqj = new beqj();
    localbeqj.jdField_a_of_type_Int = 0;
    localbeqj.jdField_a_of_type_JavaLangString = paramContext.getString(2131693229);
    localbeqj.b = paramContext.getString(2131693228);
    localbeqj.getClass();
    beqk localbeqk = new beqk(localbeqj);
    localbeqk.jdField_a_of_type_JavaLangString = paramContext.getString(2131693227);
    localbeqj.jdField_a_of_type_JavaUtilList.add(localbeqk);
    return localbeqj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqe
 * JD-Core Version:    0.7.0.1
 */