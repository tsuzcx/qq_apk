import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.wadl.WadlJsBridgeService;
import cooperation.wadl.ipc.WadlParams;

public final class bfsj
  extends Handler
{
  public bfsj(WadlJsBridgeService paramWadlJsBridgeService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    bfrz.c(WadlJsBridgeService.a(), "The obj field of msg:" + paramMessage.what + "," + paramMessage.obj);
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
        bkis.a().b(4, str);
      }
    case 5: 
      bkis.a().a(4, str);
      return;
    }
    paramMessage = new WadlParams(str, "");
    paramMessage.d = 4;
    bkis.a().b(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfsj
 * JD-Core Version:    0.7.0.1
 */