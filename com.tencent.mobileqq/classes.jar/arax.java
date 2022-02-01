import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arax
{
  public String a;
  public List<arba> a;
  public Map<String, Long> a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public arax()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static arax a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    localarax = new arax();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramArrayOfaqlg.has("report"))
      {
        localObject = paramArrayOfaqlg.getJSONObject("report");
        localarax.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("inviteTShow");
        localarax.b = ((JSONObject)localObject).optString("inviteTClick");
        localarax.c = ((JSONObject)localObject).optString("stateTShow");
        localarax.d = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfaqlg.has("viewTogether"))
      {
        localObject = new arba(paramArrayOfaqlg.getJSONObject("viewTogether"));
        ((arba)localObject).a = false;
        localarax.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaqlg.has("editTogether"))
      {
        localObject = new arba(paramArrayOfaqlg.getJSONObject("editTogether"));
        ((arba)localObject).a = true;
        localarax.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaqlg.has("editSupport"))
      {
        paramArrayOfaqlg = paramArrayOfaqlg.getJSONObject("editSupport");
        localObject = paramArrayOfaqlg.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localarax.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaqlg.getLong(str)));
        }
      }
      return localarax;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfaqlg.getLocalizedMessage(), paramArrayOfaqlg);
    }
  }
  
  public static araz a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          araz localaraz = new araz();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject.has("mem_list"))
          {
            JSONArray localJSONArray = paramJSONObject.getJSONArray("mem_list");
            if (localJSONArray != null)
            {
              ArrayList localArrayList = new ArrayList();
              int i = 0;
              while (i < localJSONArray.length())
              {
                JSONObject localJSONObject = localJSONArray.getJSONObject(i);
                aray localaray = new aray();
                localaray.b = localJSONObject.getString("avatar");
                localaray.jdField_a_of_type_JavaLangString = localJSONObject.getString("nick");
                localArrayList.add(localaray);
                i += 1;
              }
              localaraz.jdField_a_of_type_JavaUtilList = localArrayList;
            }
          }
          if (paramJSONObject.has("mem_count")) {
            localaraz.jdField_a_of_type_Int = paramJSONObject.getInt("mem_count");
          }
          return localaraz;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    return null;
  }
  
  public arba a(String paramString)
  {
    paramString = bdjg.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      arba localarba = (arba)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localarba.a(paramString)) {
        return localarba;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arax
 * JD-Core Version:    0.7.0.1
 */