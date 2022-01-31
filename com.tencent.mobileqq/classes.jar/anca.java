import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anca
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static anca a(ampi[] paramArrayOfampi)
  {
    int j = 0;
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    anca localanca = new anca();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
      if (!paramArrayOfampi.has("DocsImportFileInfo")) {
        break label412;
      }
      paramArrayOfampi = paramArrayOfampi.getJSONObject("DocsImportFileInfo");
      if (paramArrayOfampi.has("importFileMaxSize"))
      {
        localObject1 = paramArrayOfampi.getString("importFileMaxSize");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localanca.jdField_a_of_type_Long = Long.parseLong((String)localObject1);
        }
      }
      if (!paramArrayOfampi.has("importFileType")) {
        break label245;
      }
      localObject1 = paramArrayOfampi.getJSONArray("importFileType");
      localStringBuilder = new StringBuilder();
      localObject2 = new StringBuilder();
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
        break label227;
      }
      i = 0;
    }
    catch (JSONException paramArrayOfampi)
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
          QLog.e("TencentDocImportFileInfoBean", 1, "exception = " + paramArrayOfampi.toString());
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
      localanca.b = ((StringBuilder)localObject2).toString();
      localanca.c = localStringBuilder.toString();
      if (paramArrayOfampi.has("fileGroupType"))
      {
        localObject1 = paramArrayOfampi.getJSONArray("fileGroupType");
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
        localanca.d = localStringBuilder.toString();
      }
      if (paramArrayOfampi.has("importFileTips"))
      {
        paramArrayOfampi = paramArrayOfampi.getString("importFileTips");
        if (!TextUtils.isEmpty(paramArrayOfampi)) {
          localanca.jdField_a_of_type_JavaLangString = paramArrayOfampi;
        }
      }
      return localanca;
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
 * Qualified Name:     anca
 * JD-Core Version:    0.7.0.1
 */