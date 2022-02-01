import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class apus
{
  public int a;
  public int b;
  
  public apus()
  {
    a();
  }
  
  public static apus a(String paramString)
  {
    int j = 0;
    QLog.d("TroopNotificationEntryConfig", 1, "parse, newConf = " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    label86:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("showNewEntryFlag", 0);
        int k;
        paramString.printStackTrace();
      }
      catch (JSONException paramString)
      {
        try
        {
          k = paramString.optInt("oddEvenFlag", 0);
          j = k;
          paramString = new apus();
          paramString.a = i;
          paramString.b = j;
          return paramString;
        }
        catch (JSONException paramString)
        {
          break label86;
        }
        paramString = paramString;
        i = 0;
      }
    }
  }
  
  private void a()
  {
    this.a = 2;
    this.b = 0;
  }
  
  public boolean a(String paramString)
  {
    if (this.a == 0) {
      if ((paramString != null) && (!paramString.isEmpty())) {}
    }
    while (this.a != 1)
    {
      int i;
      do
      {
        do
        {
          do
          {
            return false;
            i = paramString.charAt(paramString.length() - 1);
          } while (this.b == 0);
          if (this.b != 1) {
            break;
          }
        } while (i % 2 == 0);
        return true;
      } while ((this.b != 2) || (i % 2 != 0));
      return true;
    }
    return true;
  }
  
  public String toString()
  {
    return "TroopNotificationEntryConfig{showNewEntryFlag=" + this.a + ", oddEvenFlag=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apus
 * JD-Core Version:    0.7.0.1
 */