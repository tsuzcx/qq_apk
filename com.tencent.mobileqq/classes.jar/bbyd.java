import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class bbyd
{
  public static bbxz a(Activity paramActivity, @NonNull JSONObject paramJSONObject, auuy paramauuy, String paramString)
  {
    if ((paramauuy == null) || (paramauuy.a == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramauuy.a.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == auvf.l) {}
    for (paramActivity = new bbye(paramActivity, paramJSONObject, paramauuy);; paramActivity = new bbyf(paramActivity, paramJSONObject, paramauuy))
    {
      paramActivity.a(paramString);
      return paramActivity;
      if (l2 != auvf.m) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbyd
 * JD-Core Version:    0.7.0.1
 */