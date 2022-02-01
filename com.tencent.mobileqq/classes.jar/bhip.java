import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class bhip
{
  public static bhil a(Activity paramActivity, @NonNull JSONObject paramJSONObject, azfe paramazfe, String paramString)
  {
    if ((paramazfe == null) || (paramazfe.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramazfe.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == azfl.l) {}
    for (paramActivity = new bhiq(paramActivity, paramJSONObject, paramazfe);; paramActivity = new bhir(paramActivity, paramJSONObject, paramazfe))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != azfl.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhip
 * JD-Core Version:    0.7.0.1
 */