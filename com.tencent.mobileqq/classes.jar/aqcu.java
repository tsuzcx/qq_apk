import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqcu
{
  private aqcv[] a = new aqcv[0];
  
  public static aqcu a(String paramString)
  {
    int i = 0;
    aqcu localaqcu = new aqcu();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localaqcu;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localaqcu.a = new aqcv[paramString.length()];
          while (i < paramString.length())
          {
            aqcv localaqcv = aqcv.a(paramString.getJSONObject(i));
            localaqcu.a[i] = localaqcv;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localaqcu);
            return localaqcu;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localaqcu;
  }
  
  public aqcv a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    aqcv[] arrayOfaqcv = this.a;
    int j = arrayOfaqcv.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      aqcv localaqcv = arrayOfaqcv[i];
      localObject = localaqcv;
      if (localaqcv.a == paramInt) {
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
      aqcv[] arrayOfaqcv = this.a;
      int j = arrayOfaqcv.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfaqcv[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqcu
 * JD-Core Version:    0.7.0.1
 */