import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.wadl.WadlJsBridgeService;
import cooperation.wadl.ipc.WadlParams;

public final class bfoa
  extends Handler
{
  public bfoa(WadlJsBridgeService paramWadlJsBridgeService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    bfnq.c(WadlJsBridgeService.a(), "The obj field of msg:" + paramMessage.what + "," + paramMessage.obj);
    switch (paramMessage.what)
    {
    case 2: 
    case 3: 
    default: 
    case 0: 
    case 4: 
      for (;;)
      {
        this.a.stopSelf(paramMessage.arg1);
        return;
        bkel.a().b(4, str);
      }
    case 5: 
      bkel.a().a(4, str);
      return;
    }
    paramMessage = new WadlParams(str, "");
    paramMessage.d = 4;
    bkel.a().b(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfoa
 * JD-Core Version:    0.7.0.1
 */