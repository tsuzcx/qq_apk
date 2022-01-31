import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amfw
{
  private amfx[] a = new amfx[0];
  
  public static amfw a(String paramString)
  {
    int i = 0;
    amfw localamfw = new amfw();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localamfw;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localamfw.a = new amfx[paramString.length()];
          while (i < paramString.length())
          {
            amfx localamfx = amfx.a(paramString.getJSONObject(i));
            localamfw.a[i] = localamfx;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localamfw);
            return localamfw;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localamfw;
  }
  
  public amfx a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    amfx[] arrayOfamfx = this.a;
    int j = arrayOfamfx.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      amfx localamfx = arrayOfamfx[i];
      localObject = localamfx;
      if (localamfx.a == paramInt) {
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
      amfx[] arrayOfamfx = this.a;
      int j = arrayOfamfx.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfamfx[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfw
 * JD-Core Version:    0.7.0.1
 */