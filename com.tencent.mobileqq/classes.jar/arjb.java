import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arjb
{
  private arjc[] a = new arjc[0];
  
  public static arjb a(String paramString)
  {
    int i = 0;
    arjb localarjb = new arjb();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localarjb;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localarjb.a = new arjc[paramString.length()];
          while (i < paramString.length())
          {
            arjc localarjc = arjc.a(paramString.getJSONObject(i));
            localarjb.a[i] = localarjc;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localarjb);
            return localarjb;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localarjb;
  }
  
  public arjc a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    arjc[] arrayOfarjc = this.a;
    int j = arrayOfarjc.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      arjc localarjc = arrayOfarjc[i];
      localObject = localarjc;
      if (localarjc.a == paramInt) {
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
      arjc[] arrayOfarjc = this.a;
      int j = arrayOfarjc.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfarjc[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjb
 * JD-Core Version:    0.7.0.1
 */