import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class bauv
{
  public static baur a(Activity paramActivity, @NonNull JSONObject paramJSONObject, atwx paramatwx, String paramString)
  {
    if ((paramatwx == null) || (paramatwx.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramatwx.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == atxe.l) {}
    for (paramActivity = new bauw(paramActivity, paramJSONObject, paramatwx);; paramActivity = new baux(paramActivity, paramJSONObject, paramatwx))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != atxe.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bauv
 * JD-Core Version:    0.7.0.1
 */