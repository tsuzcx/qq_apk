import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class bhzx
{
  public static bhzt a(Activity paramActivity, @NonNull JSONObject paramJSONObject, azrb paramazrb, String paramString)
  {
    if ((paramazrb == null) || (paramazrb.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramazrb.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == azri.l) {}
    for (paramActivity = new bhzy(paramActivity, paramJSONObject, paramazrb);; paramActivity = new bhzz(paramActivity, paramJSONObject, paramazrb))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != azri.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzx
 * JD-Core Version:    0.7.0.1
 */