import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import org.json.JSONObject;

public class azxl
  implements baic
{
  public azxl(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.n();
    if ((paramJSONObject != null) && (paramJSONObject.has("retcode")))
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramInt == 0)
      {
        bcql.a(this.a.getActivity(), 2131697697, 0).a();
        paramJSONObject = actj.a(new Intent(this.a.getActivity(), SplashActivity.class), new int[] { 2 });
        paramJSONObject.addFlags(268435456);
        paramJSONObject.putExtra("uin", this.a.b);
        paramJSONObject.putExtra("uintype", 1);
        this.a.getActivity().startActivity(paramJSONObject);
        this.a.getActivity().overridePendingTransition(2130771990, 2130772280);
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
 * Qualified Name:     azxl
 * JD-Core Version:    0.7.0.1
 */