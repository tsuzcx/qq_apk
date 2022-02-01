import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.json.JSONException;
import org.json.JSONObject;

class awaz
  extends Handler
{
  awaz(awax paramawax, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if ((i < awax.b(this.a)) || (i > 95)) {
      return;
    }
    awax.b(this.a, i);
    awax.a(this.a, "STATE_Loading:" + i);
    paramMessage = new JSONObject();
    try
    {
      paramMessage.putOpt("state", Integer.valueOf(4));
      paramMessage.putOpt("totalSize", Integer.valueOf(100));
      paramMessage.putOpt("pro", Integer.valueOf(i));
      this.a.callJs(this.a.a, new String[] { paramMessage.toString() });
      paramMessage = Message.obtain();
      paramMessage.arg1 = (i + 5);
      sendMessageDelayed(paramMessage, 500L);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awaz
 * JD-Core Version:    0.7.0.1
 */