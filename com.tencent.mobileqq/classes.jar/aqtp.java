import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqtp
{
  private aqtq[] a = new aqtq[0];
  
  public static aqtp a(String paramString)
  {
    int i = 0;
    aqtp localaqtp = new aqtp();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localaqtp;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localaqtp.a = new aqtq[paramString.length()];
          while (i < paramString.length())
          {
            aqtq localaqtq = aqtq.a(paramString.getJSONObject(i));
            localaqtp.a[i] = localaqtq;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localaqtp);
            return localaqtp;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localaqtp;
  }
  
  public aqtq a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    aqtq[] arrayOfaqtq = this.a;
    int j = arrayOfaqtq.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      aqtq localaqtq = arrayOfaqtq[i];
      localObject = localaqtq;
      if (localaqtq.a == paramInt) {
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
      aqtq[] arrayOfaqtq = this.a;
      int j = arrayOfaqtq.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfaqtq[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqtp
 * JD-Core Version:    0.7.0.1
 */