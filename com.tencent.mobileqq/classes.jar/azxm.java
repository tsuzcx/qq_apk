import android.os.Bundle;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import org.json.JSONObject;

public class azxm
  implements baic
{
  public azxm(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.n();
    if ((paramJSONObject != null) && (paramJSONObject.has("retcode")))
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramInt == 0) {
        this.a.i();
      }
    }
    else
    {
      return;
    }
    if (paramInt == 111000)
    {
      bcql.a(this.a.getActivity(), 2131697696, 0).a();
      return;
    }
    bcql.a(this.a.getActivity(), 2131697754, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azxm
 * JD-Core Version:    0.7.0.1
 */