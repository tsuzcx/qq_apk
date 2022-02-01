import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class befi
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, String paramString, int paramInt5, befk parambefk)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("start", paramInt1);
      localJSONObject.put("num", paramInt2);
      localJSONObject.put("type", paramInt3);
      if ((paramInt3 == 1) || (paramInt3 == 2)) {
        localJSONObject.put("theme_id", paramInt4);
      }
      localJSONObject.put("from", 2);
      localJSONObject.put("bid", paramLong);
      localJSONObject.put("pid", paramString);
      if (paramInt5 != -1) {
        localJSONObject.put("recommend_by_bid", paramInt5);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        WebSsoBody.WebSsoRequestBody localWebSsoRequestBody;
        paramString.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, localJSONObject.toString());
    }
    paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), niq.class);
    paramString.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.shortvideo_feeds");
    localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.type.set(0);
    localWebSsoRequestBody.data.set(localJSONObject.toString());
    paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
    paramString.setObserver(new befj(parambefk));
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befi
 * JD-Core Version:    0.7.0.1
 */