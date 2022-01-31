import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amwl
{
  public int a;
  public int b;
  
  public static amwl a(amph[] paramArrayOfamph)
  {
    amwl localamwl = new amwl();
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      int j = paramArrayOfamph.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfamph[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((amph)localObject).a;
          try
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("gtcSwitch")) {
              localamwl.a = ((JSONObject)localObject).optInt("gtcSwitch");
            }
            if (((JSONObject)localObject).has("groupMemberCount")) {
              localamwl.b = ((JSONObject)localObject).optInt("groupMemberCount");
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
            QLog.d("TroopMemberRecommend.ConfBean", 2, "parse: " + localamwl.toString());
          }
        }
      }
    }
    return localamwl;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("TroopMemRecommendConfBean [gtcSwitch: ").append(this.a).append(", groupMemberCount: ").append(this.b).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwl
 * JD-Core Version:    0.7.0.1
 */