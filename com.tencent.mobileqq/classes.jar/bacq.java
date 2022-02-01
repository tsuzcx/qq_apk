import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bacq
{
  public int a = 1;
  public int b = 1;
  public int c = 1;
  
  public static bacq a(aqxa[] paramArrayOfaqxa)
  {
    int i = 0;
    bacq localbacq = new bacq();
    if (i < paramArrayOfaqxa.length)
    {
      Object localObject = paramArrayOfaqxa[i].a;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localObject = new JSONObject((String)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("TroopFansEntryConfig", 2, "jsonObj:" + ((JSONObject)localObject).toString());
          }
          localbacq.a = ((JSONObject)localObject).optInt("profileCardEntranceSwitch", 0);
          localbacq.b = ((JSONObject)localObject).optInt("groupEntranceSwitch", 0);
          localbacq.c = ((JSONObject)localObject).optInt("guideSwitch", 0);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFansEntryConfig", 2, "config:" + localbacq.toString());
    }
    return localbacq;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public boolean b()
  {
    return this.b == 1;
  }
  
  public boolean c()
  {
    return this.c == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mProfileCardEntranceSwitch:").append(this.a).append("\r\n");
    localStringBuilder.append("mGroupEntranceSwitch:").append(this.b).append("\r\n");
    localStringBuilder.append("mGuideSwitch:").append(this.c).append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacq
 * JD-Core Version:    0.7.0.1
 */