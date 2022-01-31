import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aorn
{
  private aoro[] a = new aoro[0];
  
  public static aorn a(String paramString)
  {
    int i = 0;
    aorn localaorn = new aorn();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localaorn;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localaorn.a = new aoro[paramString.length()];
          while (i < paramString.length())
          {
            aoro localaoro = aoro.a(paramString.getJSONObject(i));
            localaorn.a[i] = localaoro;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localaorn);
            return localaorn;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localaorn;
  }
  
  public aoro a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    aoro[] arrayOfaoro = this.a;
    int j = arrayOfaoro.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      aoro localaoro = arrayOfaoro[i];
      localObject = localaoro;
      if (localaoro.a == paramInt) {
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
      aoro[] arrayOfaoro = this.a;
      int j = arrayOfaoro.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfaoro[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aorn
 * JD-Core Version:    0.7.0.1
 */