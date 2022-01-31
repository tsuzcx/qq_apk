import android.os.Bundle;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

public class bbvv
  implements bcgo
{
  public bbvv(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.o();
    if ((paramJSONObject != null) && (paramJSONObject.has("retcode")))
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramInt == 0) {
        this.a.j();
      }
    }
    else
    {
      return;
    }
    if (paramInt == 111000)
    {
      QQToast.a(this.a.getActivity(), 2131697871, 0).a();
      return;
    }
    QQToast.a(this.a.getActivity(), 2131697931, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvv
 * JD-Core Version:    0.7.0.1
 */