import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class arqo
{
  public String a;
  public List<arqp> a;
  public Map<String, Long> a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public arqo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static arqo a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    localarqo = new arqo();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramArrayOfaraj.has("report"))
      {
        localObject = paramArrayOfaraj.getJSONObject("report");
        localarqo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("inviteTShow");
        localarqo.b = ((JSONObject)localObject).optString("inviteTClick");
        localarqo.c = ((JSONObject)localObject).optString("stateTShow");
        localarqo.d = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfaraj.has("viewTogether"))
      {
        localObject = new arqp(paramArrayOfaraj.getJSONObject("viewTogether"));
        ((arqp)localObject).a = false;
        localarqo.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaraj.has("editTogether"))
      {
        localObject = new arqp(paramArrayOfaraj.getJSONObject("editTogether"));
        ((arqp)localObject).a = true;
        localarqo.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaraj.has("viewPrivate"))
      {
        localObject = new arqp(paramArrayOfaraj.getJSONObject("viewPrivate"));
        ((arqp)localObject).b = true;
        localarqo.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfaraj.has("editSupport"))
      {
        paramArrayOfaraj = paramArrayOfaraj.getJSONObject("editSupport");
        localObject = paramArrayOfaraj.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localarqo.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaraj.getLong(str)));
        }
      }
      return localarqo;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfaraj.getLocalizedMessage(), paramArrayOfaraj);
    }
  }
  
  public arqp a(String paramString)
  {
    paramString = becb.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      arqp localarqp = (arqp)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localarqp.a(paramString)) {
        return localarqp;
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
 * Qualified Name:     arqo
 * JD-Core Version:    0.7.0.1
 */