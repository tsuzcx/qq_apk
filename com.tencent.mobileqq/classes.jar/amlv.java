import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amlv
{
  public String a;
  public List<amly> a;
  public Map<String, Long> a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public amlv()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static amlv a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    localamlv = new amlv();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramArrayOfalzs.has("report"))
      {
        localObject = paramArrayOfalzs.getJSONObject("report");
        localamlv.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("inviteTShow");
        localamlv.b = ((JSONObject)localObject).optString("inviteTClick");
        localamlv.c = ((JSONObject)localObject).optString("stateTShow");
        localamlv.d = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfalzs.has("viewTogether"))
      {
        localObject = new amly(paramArrayOfalzs.getJSONObject("viewTogether"));
        ((amly)localObject).a = false;
        localamlv.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfalzs.has("editTogether"))
      {
        localObject = new amly(paramArrayOfalzs.getJSONObject("editTogether"));
        ((amly)localObject).a = true;
        localamlv.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfalzs.has("editSupport"))
      {
        paramArrayOfalzs = paramArrayOfalzs.getJSONObject("editSupport");
        localObject = paramArrayOfalzs.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localamlv.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfalzs.getLong(str)));
        }
      }
      return localamlv;
    }
    catch (JSONException paramArrayOfalzs)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfalzs.getLocalizedMessage(), paramArrayOfalzs);
    }
  }
  
  public static amlx a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          amlx localamlx = new amlx();
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
                amlw localamlw = new amlw();
                localamlw.b = localJSONObject.getString("avatar");
                localamlw.jdField_a_of_type_JavaLangString = localJSONObject.getString("nick");
                localArrayList.add(localamlw);
                i += 1;
              }
              localamlx.jdField_a_of_type_JavaUtilList = localArrayList;
            }
          }
          if (paramJSONObject.has("mem_count")) {
            localamlx.jdField_a_of_type_Int = paramJSONObject.getInt("mem_count");
          }
          return localamlx;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    return null;
  }
  
  public amly a(String paramString)
  {
    paramString = axfs.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      amly localamly = (amly)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localamly.a(paramString)) {
        return localamly;
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
 * Qualified Name:     amlv
 * JD-Core Version:    0.7.0.1
 */