import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amgi
{
  public int a;
  public int b;
  
  public static amgi a(alzs[] paramArrayOfalzs)
  {
    amgi localamgi = new amgi();
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      int j = paramArrayOfalzs.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfalzs[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((alzs)localObject).a;
          try
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("gtcSwitch")) {
              localamgi.a = ((JSONObject)localObject).optInt("gtcSwitch");
            }
            if (((JSONObject)localObject).has("groupMemberCount")) {
              localamgi.b = ((JSONObject)localObject).optInt("groupMemberCount");
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
            QLog.d("TroopMemberRecommend.ConfBean", 2, "parse: " + localamgi.toString());
          }
        }
      }
    }
    return localamgi;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("TroopMemRecommendConfBean [gtcSwitch: ").append(this.a).append(", groupMemberCount: ").append(this.b).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgi
 * JD-Core Version:    0.7.0.1
 */