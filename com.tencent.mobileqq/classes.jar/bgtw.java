import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class bgtw
  implements Handler.Callback
{
  bgtw(bgtv parambgtv) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage.getData().setClassLoader(bgtv.a(this.a).getClassLoader());
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramMessage.getData().getParcelable("KEY_APPINFO");
    ResultReceiver localResultReceiver = (ResultReceiver)paramMessage.getData().getParcelable("receiver");
    bgtv.a(this.a, i, paramMessage.getData(), localMiniAppInfo, localResultReceiver);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtw
 * JD-Core Version:    0.7.0.1
 */