import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class bdxe
{
  public static bdxa a(Activity paramActivity, @NonNull JSONObject paramJSONObject, awmk paramawmk, String paramString)
  {
    if ((paramawmk == null) || (paramawmk.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramawmk.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == awmr.l) {}
    for (paramActivity = new bdxf(paramActivity, paramJSONObject, paramawmk);; paramActivity = new bdxg(paramActivity, paramJSONObject, paramawmk))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != awmr.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxe
 * JD-Core Version:    0.7.0.1
 */