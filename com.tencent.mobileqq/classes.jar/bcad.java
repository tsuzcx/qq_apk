import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

public class bcad
  implements bckx
{
  public bcad(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.o();
    if ((paramJSONObject != null) && (paramJSONObject.has("retcode")))
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramInt == 0)
      {
        QQToast.a(this.a.getActivity(), 2131697874, 0).a();
        paramJSONObject = aepi.a(new Intent(this.a.getActivity(), SplashActivity.class), new int[] { 2 });
        paramJSONObject.addFlags(268435456);
        paramJSONObject.putExtra("uin", this.a.b);
        paramJSONObject.putExtra("uintype", 1);
        this.a.getActivity().startActivity(paramJSONObject);
        this.a.getActivity().overridePendingTransition(2130771990, 2130772295);
      }
    }
    else
    {
      return;
    }
    if (paramInt == 111000)
    {
      QQToast.a(this.a.getActivity(), 2131697873, 0).a();
      return;
    }
    QQToast.a(this.a.getActivity(), 2131697933, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcad
 * JD-Core Version:    0.7.0.1
 */