import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aotm
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static aotm a(aogf[] paramArrayOfaogf)
  {
    int j = 0;
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aotm localaotm = new aotm();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
      if (!paramArrayOfaogf.has("DocsImportFileInfo")) {
        break label412;
      }
      paramArrayOfaogf = paramArrayOfaogf.getJSONObject("DocsImportFileInfo");
      if (paramArrayOfaogf.has("importFileMaxSize"))
      {
        localObject1 = paramArrayOfaogf.getString("importFileMaxSize");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localaotm.jdField_a_of_type_Long = Long.parseLong((String)localObject1);
        }
      }
      if (!paramArrayOfaogf.has("importFileType")) {
        break label245;
      }
      localObject1 = paramArrayOfaogf.getJSONArray("importFileType");
      localStringBuilder = new StringBuilder();
      localObject2 = new StringBuilder();
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
        break label227;
      }
      i = 0;
    }
    catch (JSONException paramArrayOfaogf)
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
          QLog.e("TencentDocImportFileInfoBean", 1, "exception = " + paramArrayOfaogf.toString());
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
      localaotm.b = ((StringBuilder)localObject2).toString();
      localaotm.c = localStringBuilder.toString();
      if (paramArrayOfaogf.has("fileGroupType"))
      {
        localObject1 = paramArrayOfaogf.getJSONArray("fileGroupType");
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
        localaotm.d = localStringBuilder.toString();
      }
      if (paramArrayOfaogf.has("importFileTips"))
      {
        paramArrayOfaogf = paramArrayOfaogf.getString("importFileTips");
        if (!TextUtils.isEmpty(paramArrayOfaogf)) {
          localaotm.jdField_a_of_type_JavaLangString = paramArrayOfaogf;
        }
      }
      return localaotm;
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
 * Qualified Name:     aotm
 * JD-Core Version:    0.7.0.1
 */