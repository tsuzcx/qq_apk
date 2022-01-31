import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amwm
{
  public int a;
  public int b;
  
  public static amwm a(ampi[] paramArrayOfampi)
  {
    amwm localamwm = new amwm();
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      int j = paramArrayOfampi.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfampi[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((ampi)localObject).a;
          try
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("gtcSwitch")) {
              localamwm.a = ((JSONObject)localObject).optInt("gtcSwitch");
            }
            if (((JSONObject)localObject).has("groupMemberCount")) {
              localamwm.b = ((JSONObject)localObject).optInt("groupMemberCount");
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberRecommend.ConfBean", 2, "parse: " + localamwm.toString());
          }
        }
      }
    }
    return localamwm;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("TroopMemRecommendConfBean [gtcSwitch: ").append(this.a).append(", groupMemberCount: ").append(this.b).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwm
 * JD-Core Version:    0.7.0.1
 */