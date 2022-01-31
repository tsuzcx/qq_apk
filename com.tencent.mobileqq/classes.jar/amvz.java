import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amvz
{
  private amwa[] a = new amwa[0];
  
  public static amvz a(String paramString)
  {
    int i = 0;
    amvz localamvz = new amvz();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localamvz;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localamvz.a = new amwa[paramString.length()];
          while (i < paramString.length())
          {
            amwa localamwa = amwa.a(paramString.getJSONObject(i));
            localamvz.a[i] = localamwa;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localamvz);
            return localamvz;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localamvz;
  }
  
  public amwa a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    amwa[] arrayOfamwa = this.a;
    int j = arrayOfamwa.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      amwa localamwa = arrayOfamwa[i];
      localObject = localamwa;
      if (localamwa.a == paramInt) {
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
      amwa[] arrayOfamwa = this.a;
      int j = arrayOfamwa.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfamwa[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvz
 * JD-Core Version:    0.7.0.1
 */