import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class beov
  implements Handler.Callback
{
  beov(beou parambeou) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage.getData().setClassLoader(beou.a(this.a).getClassLoader());
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramMessage.getData().getParcelable("KEY_APPINFO");
    ResultReceiver localResultReceiver = (ResultReceiver)paramMessage.getData().getParcelable("receiver");
    beou.a(this.a, i, paramMessage.getData(), localMiniAppInfo, localResultReceiver);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beov
 * JD-Core Version:    0.7.0.1
 */