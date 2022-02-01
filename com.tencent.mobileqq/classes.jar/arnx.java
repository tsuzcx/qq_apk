import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class arnx
{
  public String a;
  public List<arny> a;
  public Map<String, Long> a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public arnx()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static arnx a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    localarnx = new arnx();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramArrayOfaqxa.has("report"))
      {
        localObject = paramArrayOfaqxa.getJSONObject("report");
        localarnx.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("inviteTShow");
        localarnx.b = ((JSONObject)localObject).optString("inviteTClick");
        localarnx.c = ((JSONObject)localObject).optString("stateTShow");
        localarnx.d = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfaqxa.has("viewTogether"))
      {
        localObject = new arny(paramArrayOfaqxa.getJSONObject("viewTogether"));
        ((arny)localObject).a = false;
        localarnx.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaqxa.has("editTogether"))
      {
        localObject = new arny(paramArrayOfaqxa.getJSONObject("editTogether"));
        ((arny)localObject).a = true;
        localarnx.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaqxa.has("viewPrivate"))
      {
        localObject = new arny(paramArrayOfaqxa.getJSONObject("viewPrivate"));
        ((arny)localObject).b = true;
        localarnx.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaqxa.has("editSupport"))
      {
        paramArrayOfaqxa = paramArrayOfaqxa.getJSONObject("editSupport");
        localObject = paramArrayOfaqxa.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localarnx.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaqxa.getLong(str)));
        }
      }
      return localarnx;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfaqxa.getLocalizedMessage(), paramArrayOfaqxa);
    }
  }
  
  public arny a(String paramString)
  {
    paramString = becr.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      arny localarny = (arny)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localarny.a(paramString)) {
        return localarny;
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
  
  public boolean b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnx
 * JD-Core Version:    0.7.0.1
 */