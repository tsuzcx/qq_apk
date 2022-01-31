import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import org.json.JSONObject;

public class azxf
  implements baho
{
  public azxf(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.n();
    if ((paramJSONObject != null) && (paramJSONObject.has("retcode")))
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramInt == 0)
      {
        bcpw.a(this.a.getActivity(), 2131697692, 0).a();
        paramJSONObject = actn.a(new Intent(this.a.getActivity(), SplashActivity.class), new int[] { 2 });
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
      bcpw.a(this.a.getActivity(), 2131697691, 0).a();
      return;
    }
    bcpw.a(this.a.getActivity(), 2131697744, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azxf
 * JD-Core Version:    0.7.0.1
 */