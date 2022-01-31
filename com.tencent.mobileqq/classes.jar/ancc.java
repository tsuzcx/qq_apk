import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ancc
{
  public String a;
  public List<ancf> a;
  public Map<String, Long> a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public ancc()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static ancc a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    localancc = new ancc();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramArrayOfampi.has("report"))
      {
        localObject = paramArrayOfampi.getJSONObject("report");
        localancc.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("inviteTShow");
        localancc.b = ((JSONObject)localObject).optString("inviteTClick");
        localancc.c = ((JSONObject)localObject).optString("stateTShow");
        localancc.d = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfampi.has("viewTogether"))
      {
        localObject = new ancf(paramArrayOfampi.getJSONObject("viewTogether"));
        ((ancf)localObject).a = false;
        localancc.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfampi.has("editTogether"))
      {
        localObject = new ancf(paramArrayOfampi.getJSONObject("editTogether"));
        ((ancf)localObject).a = true;
        localancc.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfampi.has("editSupport"))
      {
        paramArrayOfampi = paramArrayOfampi.getJSONObject("editSupport");
        localObject = paramArrayOfampi.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localancc.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfampi.getLong(str)));
        }
      }
      return localancc;
    }
    catch (JSONException paramArrayOfampi)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfampi.getLocalizedMessage(), paramArrayOfampi);
    }
  }
  
  public static ance a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          ance localance = new ance();
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
                ancd localancd = new ancd();
                localancd.b = localJSONObject.getString("avatar");
                localancd.jdField_a_of_type_JavaLangString = localJSONObject.getString("nick");
                localArrayList.add(localancd);
                i += 1;
              }
              localance.jdField_a_of_type_JavaUtilList = localArrayList;
            }
          }
          if (paramJSONObject.has("mem_count")) {
            localance.jdField_a_of_type_Int = paramJSONObject.getInt("mem_count");
          }
          return localance;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    return null;
  }
  
  public ancf a(String paramString)
  {
    paramString = ayfv.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ancf localancf = (ancf)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localancf.a(paramString)) {
        return localancf;
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
 * Qualified Name:     ancc
 * JD-Core Version:    0.7.0.1
 */