import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ancf
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static ancf a(amph[] paramArrayOfamph)
  {
    int j = 0;
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    ancf localancf = new ancf();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
      if (!paramArrayOfamph.has("DocsImportFileInfo")) {
        break label412;
      }
      paramArrayOfamph = paramArrayOfamph.getJSONObject("DocsImportFileInfo");
      if (paramArrayOfamph.has("importFileMaxSize"))
      {
        localObject1 = paramArrayOfamph.getString("importFileMaxSize");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localancf.jdField_a_of_type_Long = Long.parseLong((String)localObject1);
        }
      }
      if (!paramArrayOfamph.has("importFileType")) {
        break label245;
      }
      localObject1 = paramArrayOfamph.getJSONArray("importFileType");
      localStringBuilder = new StringBuilder();
      localObject2 = new StringBuilder();
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
        break label227;
      }
      i = 0;
    }
    catch (JSONException paramArrayOfamph)
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
          QLog.e("TencentDocImportFileInfoBean", 1, "exception = " + paramArrayOfamph.toString());
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
      localancf.b = ((StringBuilder)localObject2).toString();
      localancf.c = localStringBuilder.toString();
      if (paramArrayOfamph.has("fileGroupType"))
      {
        localObject1 = paramArrayOfamph.getJSONArray("fileGroupType");
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
        localancf.d = localStringBuilder.toString();
      }
      if (paramArrayOfamph.has("importFileTips"))
      {
        paramArrayOfamph = paramArrayOfamph.getString("importFileTips");
        if (!TextUtils.isEmpty(paramArrayOfamph)) {
          localancf.jdField_a_of_type_JavaLangString = paramArrayOfamph;
        }
      }
      return localancf;
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
 * Qualified Name:     ancf
 * JD-Core Version:    0.7.0.1
 */