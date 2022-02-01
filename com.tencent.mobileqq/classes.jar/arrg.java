import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.danmaku.core.DanmakuManager;
import java.lang.ref.WeakReference;

public class arrg
  implements Handler.Callback
{
  private WeakReference<DanmakuManager> a;
  
  private arrg(DanmakuManager paramDanmakuManager)
  {
    this.a = new WeakReference(paramDanmakuManager);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    DanmakuManager localDanmakuManager = (DanmakuManager)this.a.get();
    if (localDanmakuManager == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      DanmakuManager.a(localDanmakuManager, paramMessage);
      DanmakuManager.a(localDanmakuManager);
      return false;
    case 2: 
      DanmakuManager.a(localDanmakuManager);
      return false;
    case 4: 
      DanmakuManager.b(localDanmakuManager);
      return false;
    case 3: 
      DanmakuManager.c(localDanmakuManager);
      return false;
    case 5: 
      DanmakuManager.b(localDanmakuManager, paramMessage);
      return false;
    case 6: 
      DanmakuManager.d(localDanmakuManager);
      return false;
    case 7: 
      DanmakuManager.e(localDanmakuManager);
      return false;
    case 8: 
      DanmakuManager.f(localDanmakuManager);
      return false;
    case 9: 
      DanmakuManager.g(localDanmakuManager);
      return false;
    case 10: 
      DanmakuManager.h(localDanmakuManager);
      return false;
    }
    DanmakuManager.i(localDanmakuManager);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrg
 * JD-Core Version:    0.7.0.1
 */