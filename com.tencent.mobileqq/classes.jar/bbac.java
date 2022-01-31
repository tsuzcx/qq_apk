import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

final class bbac
  implements BusinessObserver
{
  bbac(bbad parambbad) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    String str = localContext.getString(2131696744);
    Object localObject2 = null;
    int i = -1;
    if (paramBoolean) {
      paramInt = i;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        paramInt = i;
        localObject1 = new WebSsoBody.WebSsoResponseBody();
        paramInt = i;
        ((WebSsoBody.WebSsoResponseBody)localObject1).mergeFrom(paramBundle);
        paramInt = i;
        i = ((WebSsoBody.WebSsoResponseBody)localObject1).ret.get();
        paramInt = i;
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject1).data.get());
        if (i == 0) {
          continue;
        }
        paramInt = i;
        str = paramBundle.optString("msg");
        localObject1 = localObject2;
        paramBundle = str;
        paramInt = i;
        if (TextUtils.isEmpty(str))
        {
          paramInt = i;
          paramBundle = localContext.getString(2131696745, new Object[] { Integer.valueOf(i) });
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        paramInt = i;
        localObject1 = paramBundle;
        paramBundle = localObject2;
      }
      catch (Exception paramBundle)
      {
        Object localObject1 = localContext.getString(2131696745, new Object[] { Integer.valueOf(9992) });
        paramBundle = null;
        continue;
      }
      this.a.a(paramInt, (String)localObject1, paramBundle);
      return;
      paramInt = i;
      localObject1 = bbaa.a(paramBundle.getJSONObject("result").optJSONArray("feeds"));
      paramBundle = str;
      continue;
      paramInt = i;
      localObject1 = localContext.getString(2131696745, new Object[] { Integer.valueOf(9991) });
      paramBundle = null;
      paramInt = -1;
      continue;
      paramInt = i;
      localObject1 = localContext.getString(2131696745, new Object[] { Integer.valueOf(9992) });
      paramBundle = null;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbac
 * JD-Core Version:    0.7.0.1
 */