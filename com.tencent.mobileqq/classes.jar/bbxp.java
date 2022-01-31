import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class bbxp
{
  public static bbxl a(Activity paramActivity, @NonNull JSONObject paramJSONObject, auuw paramauuw, String paramString)
  {
    if ((paramauuw == null) || (paramauuw.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramauuw.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == auvd.l) {}
    for (paramActivity = new bbxq(paramActivity, paramJSONObject, paramauuw);; paramActivity = new bbxr(paramActivity, paramJSONObject, paramauuw))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != auvd.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbxp
 * JD-Core Version:    0.7.0.1
 */