import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class bgpn
{
  public static bgpj a(Activity paramActivity, @NonNull JSONObject paramJSONObject, aymg paramaymg, String paramString)
  {
    if ((paramaymg == null) || (paramaymg.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramaymg.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == aymn.l) {}
    for (paramActivity = new bgpo(paramActivity, paramJSONObject, paramaymg);; paramActivity = new bgpp(paramActivity, paramJSONObject, paramaymg))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != aymn.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpn
 * JD-Core Version:    0.7.0.1
 */