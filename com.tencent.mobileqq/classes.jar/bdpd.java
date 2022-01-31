import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.wadl.WadlJsBridgeService;
import cooperation.wadl.ipc.WadlParams;

public final class bdpd
  extends Handler
{
  public bdpd(WadlJsBridgeService paramWadlJsBridgeService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    bdot.b(WadlJsBridgeService.a(), "The obj field of msg:" + paramMessage.what + "," + paramMessage.obj);
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
        bicp.a().b(4, str);
      }
    case 5: 
      bicp.a().a(4, str);
      return;
    }
    paramMessage = new WadlParams(str, "");
    paramMessage.d = 4;
    bicp.a().b(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdpd
 * JD-Core Version:    0.7.0.1
 */