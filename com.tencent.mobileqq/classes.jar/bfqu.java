import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

public class bfqu
  implements bghi
{
  public bfqu(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.o();
    if (paramJSONObject != null) {}
    try
    {
      if (paramJSONObject.has("retcode"))
      {
        paramInt = paramJSONObject.optInt("retcode");
        if (paramInt == 0)
        {
          this.a.j();
          return;
        }
        paramBundle = "";
        if (paramJSONObject.has("wording")) {
          paramBundle = paramJSONObject.optString("wording", "");
        }
        if (!TextUtils.isEmpty(paramBundle))
        {
          QQToast.a(this.a.getActivity(), paramBundle, 0).a();
          return;
        }
        if (paramInt == 111000)
        {
          QQToast.a(this.a.getActivity(), 2131697181, 0).a();
          return;
        }
        QQToast.a(this.a.getActivity(), 2131697241, 0).a();
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqu
 * JD-Core Version:    0.7.0.1
 */