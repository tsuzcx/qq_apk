import android.content.Intent;
import android.widget.Toast;
import com.tencent.open.agent.ChallengeBragBase;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class bdan
  implements bdje
{
  public bdan(ChallengeBragBase paramChallengeBragBase) {}
  
  protected void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0)
    {
      Toast.makeText(this.a, paramIntent.getStringExtra("key_error_msg"), 0).show();
      bdii.e("qqBaseActivity", "onSendChallengeComplete error:{KEY_ERROR_CODE:" + i + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    this.a.setResult(-1, paramIntent);
    this.a.finish();
  }
  
  public void a(Exception paramException)
  {
    this.a.d();
    bdii.c("qqBaseActivity", "SendChallenge exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bdjm.e);
    }
    for (;;)
    {
      a(localIntent);
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bdjm.f);
      }
      else if ((paramException instanceof MalformedURLException))
      {
        localIntent.putExtra("key_error_code", -3);
        localIntent.putExtra("key_error_msg", "访问url有误!");
      }
      else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
      {
        localIntent.putExtra("key_error_code", -10);
        localIntent.putExtra("key_error_msg", "Http返回码异常!");
      }
      else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
      {
        localIntent.putExtra("key_error_code", -9);
        localIntent.putExtra("key_error_msg", bdjm.g);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bdjm.a);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bdjm.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      this.a.d();
      int j = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      Object localObject;
      if (j == 0)
      {
        localObject = null;
        if (!"action_brag".equals(this.a.p)) {
          break label131;
        }
        localObject = "ANDROIDQQ.BRAG.ASSISTANT";
        i = 2131690936;
      }
      for (;;)
      {
        if (localObject != null)
        {
          bdjr.a("400", (String)localObject, this.a.c);
          Toast.makeText(this.a, i, 0).show();
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_error_code", j);
        ((Intent)localObject).putExtra("key_error_msg", str);
        ((Intent)localObject).putExtra("key_response", paramJSONObject.toString());
        a((Intent)localObject);
        return;
        label131:
        if ("action_challenge".equals(this.a.p))
        {
          localObject = "ANDROIDQQ.PK.ASSISTANT";
          i = 2131690937;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      bdii.c("qqBaseActivity", "SendChallenge exception." + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", bdjm.b);
      a(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      a(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdan
 * JD-Core Version:    0.7.0.1
 */