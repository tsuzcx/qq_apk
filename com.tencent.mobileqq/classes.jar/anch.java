import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anch
{
  public String a;
  public List<anck> a;
  public Map<String, Long> a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public anch()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static anch a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    localanch = new anch();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramArrayOfamph.has("report"))
      {
        localObject = paramArrayOfamph.getJSONObject("report");
        localanch.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("inviteTShow");
        localanch.b = ((JSONObject)localObject).optString("inviteTClick");
        localanch.c = ((JSONObject)localObject).optString("stateTShow");
        localanch.d = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfamph.has("viewTogether"))
      {
        localObject = new anck(paramArrayOfamph.getJSONObject("viewTogether"));
        ((anck)localObject).a = false;
        localanch.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfamph.has("editTogether"))
      {
        localObject = new anck(paramArrayOfamph.getJSONObject("editTogether"));
        ((anck)localObject).a = true;
        localanch.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfamph.has("editSupport"))
      {
        paramArrayOfamph = paramArrayOfamph.getJSONObject("editSupport");
        localObject = paramArrayOfamph.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localanch.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfamph.getLong(str)));
        }
      }
      return localanch;
    }
    catch (JSONException paramArrayOfamph)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfamph.getLocalizedMessage(), paramArrayOfamph);
    }
  }
  
  public static ancj a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          ancj localancj = new ancj();
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
                anci localanci = new anci();
                localanci.b = localJSONObject.getString("avatar");
                localanci.jdField_a_of_type_JavaLangString = localJSONObject.getString("nick");
                localArrayList.add(localanci);
                i += 1;
              }
              localancj.jdField_a_of_type_JavaUtilList = localArrayList;
            }
          }
          if (paramJSONObject.has("mem_count")) {
            localancj.jdField_a_of_type_Int = paramJSONObject.getInt("mem_count");
          }
          return localancj;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    return null;
  }
  
  public anck a(String paramString)
  {
    paramString = ayfx.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      anck localanck = (anck)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localanck.a(paramString)) {
        return localanck;
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
 * Qualified Name:     anch
 * JD-Core Version:    0.7.0.1
 */