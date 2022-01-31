import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoxx
{
  public String a;
  public List<aoya> a;
  public Map<String, Long> a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public aoxx()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aoxx a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    localaoxx = new aoxx();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramArrayOfaoko.has("report"))
      {
        localObject = paramArrayOfaoko.getJSONObject("report");
        localaoxx.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("inviteTShow");
        localaoxx.b = ((JSONObject)localObject).optString("inviteTClick");
        localaoxx.c = ((JSONObject)localObject).optString("stateTShow");
        localaoxx.d = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfaoko.has("viewTogether"))
      {
        localObject = new aoya(paramArrayOfaoko.getJSONObject("viewTogether"));
        ((aoya)localObject).a = false;
        localaoxx.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaoko.has("editTogether"))
      {
        localObject = new aoya(paramArrayOfaoko.getJSONObject("editTogether"));
        ((aoya)localObject).a = true;
        localaoxx.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaoko.has("editSupport"))
      {
        paramArrayOfaoko = paramArrayOfaoko.getJSONObject("editSupport");
        localObject = paramArrayOfaoko.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localaoxx.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaoko.getLong(str)));
        }
      }
      return localaoxx;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfaoko.getLocalizedMessage(), paramArrayOfaoko);
    }
  }
  
  public static aoxz a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          aoxz localaoxz = new aoxz();
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
                aoxy localaoxy = new aoxy();
                localaoxy.b = localJSONObject.getString("avatar");
                localaoxy.jdField_a_of_type_JavaLangString = localJSONObject.getString("nick");
                localArrayList.add(localaoxy);
                i += 1;
              }
              localaoxz.jdField_a_of_type_JavaUtilList = localArrayList;
            }
          }
          if (paramJSONObject.has("mem_count")) {
            localaoxz.jdField_a_of_type_Int = paramJSONObject.getInt("mem_count");
          }
          return localaoxz;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    return null;
  }
  
  public aoya a(String paramString)
  {
    paramString = baic.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      aoya localaoya = (aoya)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localaoya.a(paramString)) {
        return localaoya;
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
 * Qualified Name:     aoxx
 * JD-Core Version:    0.7.0.1
 */