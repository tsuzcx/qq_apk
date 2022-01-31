import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class atvj
{
  public String a;
  public String b;
  public String c;
  
  public static atvj a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      for (;;)
      {
        try
        {
          localObject = new atvj();
          try
          {
            if (paramJSONObject.has("tip"))
            {
              ((atvj)localObject).a = paramJSONObject.getString("tip");
              if (!paramJSONObject.has("key_word")) {
                continue;
              }
              ((atvj)localObject).b = paramJSONObject.getString("key_word");
              if (!paramJSONObject.has("jump_url")) {
                continue;
              }
              ((atvj)localObject).c = paramJSONObject.getString("jump_url");
              return localObject;
            }
            ((atvj)localObject).a = "";
            continue;
            localObject = paramJSONObject;
          }
          catch (Exception localException1)
          {
            paramJSONObject = (JSONObject)localObject;
          }
        }
        catch (Exception localException2)
        {
          paramJSONObject = null;
          continue;
        }
        if (!QLog.isColorLevel()) {
          return localObject;
        }
        QLog.i("CUOpenCardGuideMng", 2, "GuideEntry-parse", localException1);
        return paramJSONObject;
        ((atvj)localObject).b = "";
        continue;
        ((atvj)localObject).c = "";
        return localObject;
      }
    }
    Object localObject = null;
    return localObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[tip:").append(this.a).append(", key_word:").append(this.b).append(", jump_url:").append(this.c).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvj
 * JD-Core Version:    0.7.0.1
 */