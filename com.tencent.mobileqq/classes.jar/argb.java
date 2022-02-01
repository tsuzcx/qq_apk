import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class argb
{
  private argc[] a = new argc[0];
  
  public static argb a(String paramString)
  {
    int i = 0;
    argb localargb = new argb();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localargb;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localargb.a = new argc[paramString.length()];
          while (i < paramString.length())
          {
            argc localargc = argc.a(paramString.getJSONObject(i));
            localargb.a[i] = localargc;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localargb);
            return localargb;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localargb;
  }
  
  public argc a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    argc[] arrayOfargc = this.a;
    int j = arrayOfargc.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      argc localargc = arrayOfargc[i];
      localObject = localargc;
      if (localargc.a == paramInt) {
        break;
      }
      i += 1;
    }
    label64:
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString()).append(" ");
    if ((this.a != null) && (this.a.length > 0))
    {
      argc[] arrayOfargc = this.a;
      int j = arrayOfargc.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfargc[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argb
 * JD-Core Version:    0.7.0.1
 */