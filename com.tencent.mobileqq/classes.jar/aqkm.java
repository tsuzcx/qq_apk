import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aqkm
{
  public String a;
  public List<aqkn> a;
  public Map<String, Long> a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public aqkm()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aqkm a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    localaqkm = new aqkm();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramArrayOfaptx.has("report"))
      {
        localObject = paramArrayOfaptx.getJSONObject("report");
        localaqkm.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("inviteTShow");
        localaqkm.b = ((JSONObject)localObject).optString("inviteTClick");
        localaqkm.c = ((JSONObject)localObject).optString("stateTShow");
        localaqkm.d = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfaptx.has("viewTogether"))
      {
        localObject = new aqkn(paramArrayOfaptx.getJSONObject("viewTogether"));
        ((aqkn)localObject).a = false;
        localaqkm.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaptx.has("editTogether"))
      {
        localObject = new aqkn(paramArrayOfaptx.getJSONObject("editTogether"));
        ((aqkn)localObject).a = true;
        localaqkm.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaptx.has("viewPrivate"))
      {
        localObject = new aqkn(paramArrayOfaptx.getJSONObject("viewPrivate"));
        ((aqkn)localObject).b = true;
        localaqkm.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaptx.has("editSupport"))
      {
        paramArrayOfaptx = paramArrayOfaptx.getJSONObject("editSupport");
        localObject = paramArrayOfaptx.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localaqkm.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaptx.getLong(str)));
        }
      }
      return localaqkm;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfaptx.getLocalizedMessage(), paramArrayOfaptx);
    }
  }
  
  public aqkn a(String paramString)
  {
    paramString = bcvs.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      aqkn localaqkn = (aqkn)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localaqkn.a(paramString)) {
        return localaqkn;
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
 * Qualified Name:     aqkm
 * JD-Core Version:    0.7.0.1
 */