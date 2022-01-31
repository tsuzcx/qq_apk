import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class bebn
{
  public static bebj a(Activity paramActivity, @NonNull JSONObject paramJSONObject, awqt paramawqt, String paramString)
  {
    if ((paramawqt == null) || (paramawqt.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramawqt.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == awra.l) {}
    for (paramActivity = new bebo(paramActivity, paramJSONObject, paramawqt);; paramActivity = new bebp(paramActivity, paramJSONObject, paramawqt))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != awra.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebn
 * JD-Core Version:    0.7.0.1
 */