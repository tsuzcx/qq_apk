import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class bije
{
  public static bija a(Activity paramActivity, @NonNull JSONObject paramJSONObject, azxr paramazxr, String paramString)
  {
    if ((paramazxr == null) || (paramazxr.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramazxr.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == azxy.l) {}
    for (paramActivity = new bijf(paramActivity, paramJSONObject, paramazxr);; paramActivity = new bijg(paramActivity, paramJSONObject, paramazxr))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != azxy.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bije
 * JD-Core Version:    0.7.0.1
 */