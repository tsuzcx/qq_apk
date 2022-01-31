import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aone
{
  private aonf[] a = new aonf[0];
  
  public static aone a(String paramString)
  {
    int i = 0;
    aone localaone = new aone();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localaone;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localaone.a = new aonf[paramString.length()];
          while (i < paramString.length())
          {
            aonf localaonf = aonf.a(paramString.getJSONObject(i));
            localaone.a[i] = localaonf;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localaone);
            return localaone;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localaone;
  }
  
  public aonf a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    aonf[] arrayOfaonf = this.a;
    int j = arrayOfaonf.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      aonf localaonf = arrayOfaonf[i];
      localObject = localaonf;
      if (localaonf.a == paramInt) {
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
      aonf[] arrayOfaonf = this.a;
      int j = arrayOfaonf.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfaonf[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aone
 * JD-Core Version:    0.7.0.1
 */