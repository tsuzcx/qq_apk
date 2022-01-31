import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.ui.MainPageFragment;
import org.json.JSONObject;

public class bffr
  implements AsyncResult
{
  public bffr(MainPageFragment paramMainPageFragment) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.optString("token");
      MainPageFragment.a(this.a, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffr
 * JD-Core Version:    0.7.0.1
 */