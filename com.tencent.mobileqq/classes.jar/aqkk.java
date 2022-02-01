import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqkk
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static aqkk a(aptx[] paramArrayOfaptx)
  {
    int j = 0;
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    aqkk localaqkk = new aqkk();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
      if (!paramArrayOfaptx.has("DocsImportFileInfo")) {
        break label412;
      }
      paramArrayOfaptx = paramArrayOfaptx.getJSONObject("DocsImportFileInfo");
      if (paramArrayOfaptx.has("importFileMaxSize"))
      {
        localObject1 = paramArrayOfaptx.getString("importFileMaxSize");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localaqkk.jdField_a_of_type_Long = Long.parseLong((String)localObject1);
        }
      }
      if (!paramArrayOfaptx.has("importFileType")) {
        break label245;
      }
      localObject1 = paramArrayOfaptx.getJSONArray("importFileType");
      localStringBuilder = new StringBuilder();
      localObject2 = new StringBuilder();
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
        break label227;
      }
      i = 0;
    }
    catch (JSONException paramArrayOfaptx)
    {
      label412:
      for (;;)
      {
        Object localObject1;
        StringBuilder localStringBuilder;
        Object localObject2;
        int i;
        JSONObject localJSONObject;
        label227:
        label245:
        if (QLog.isColorLevel())
        {
          QLog.e("TencentDocImportFileInfoBean", 1, "exception = " + paramArrayOfaptx.toString());
          continue;
          i += 1;
          continue;
          i += 1;
        }
      }
    }
    if (i < ((JSONArray)localObject1).length())
    {
      localJSONObject = (JSONObject)((JSONArray)localObject1).get(i);
      if (localJSONObject.has("suffix"))
      {
        localStringBuilder.append(localJSONObject.getString("suffix"));
        ((StringBuilder)localObject2).append(localJSONObject.getString("suffix"));
        if (localJSONObject.has("maxSize")) {
          ((StringBuilder)localObject2).append("_").append(localJSONObject.getString("maxSize")).append("#");
        }
      }
    }
    else
    {
      localaqkk.b = ((StringBuilder)localObject2).toString();
      localaqkk.c = localStringBuilder.toString();
      if (paramArrayOfaptx.has("fileGroupType"))
      {
        localObject1 = paramArrayOfaptx.getJSONArray("fileGroupType");
        localStringBuilder = new StringBuilder();
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = j;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
            if ((!((JSONObject)localObject2).has("group")) || (!((JSONObject)localObject2).has("suffix"))) {
              break label459;
            }
            localStringBuilder.append(((JSONObject)localObject2).getString("group") + "_" + ((JSONObject)localObject2).getString("suffix") + "&");
            break label459;
          }
        }
        localaqkk.d = localStringBuilder.toString();
      }
      if (paramArrayOfaptx.has("importFileTips"))
      {
        paramArrayOfaptx = paramArrayOfaptx.getString("importFileTips");
        if (!TextUtils.isEmpty(paramArrayOfaptx)) {
          localaqkk.jdField_a_of_type_JavaLangString = paramArrayOfaptx;
        }
      }
      return localaqkk;
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqkk
 * JD-Core Version:    0.7.0.1
 */