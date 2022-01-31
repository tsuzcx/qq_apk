import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amwa
{
  private amwb[] a = new amwb[0];
  
  public static amwa a(String paramString)
  {
    int i = 0;
    amwa localamwa = new amwa();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localamwa;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localamwa.a = new amwb[paramString.length()];
          while (i < paramString.length())
          {
            amwb localamwb = amwb.a(paramString.getJSONObject(i));
            localamwa.a[i] = localamwb;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localamwa);
            return localamwa;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localamwa;
  }
  
  public amwb a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    amwb[] arrayOfamwb = this.a;
    int j = arrayOfamwb.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      amwb localamwb = arrayOfamwb[i];
      localObject = localamwb;
      if (localamwb.a == paramInt) {
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
      amwb[] arrayOfamwb = this.a;
      int j = arrayOfamwb.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfamwb[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwa
 * JD-Core Version:    0.7.0.1
 */