import android.os.Bundle;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class auyl
  implements bckx
{
  public auyl(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      paramInt = paramJSONObject.optInt("retcode", -1);
      paramBundle = new ArrayList();
      if (paramInt == 0)
      {
        paramJSONObject = paramJSONObject.optJSONObject("data");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optJSONArray("rpt_board_items");
          if (paramJSONObject != null)
          {
            paramInt = 0;
            while (paramInt < paramJSONObject.length())
            {
              paramBundle.add(paramJSONObject.optJSONObject(paramInt).optString("uint64_uin"));
              paramInt += 1;
            }
          }
        }
      }
      this.a.jdField_a_of_type_Auzt.a(this.a.b, "" + this.a.jdField_a_of_type_Long, paramBundle, new auym(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auyl
 * JD-Core Version:    0.7.0.1
 */