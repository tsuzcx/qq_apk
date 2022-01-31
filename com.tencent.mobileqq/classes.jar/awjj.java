import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicPreDownloader.ScreenBroadcastReceiver.1;

public class awjj
  extends BroadcastReceiver
{
  public String a;
  
  public awjj(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent))
    {
      PicPreDownloader.b = PicPreDownloader.a;
      if (!a(paramContext)) {
        bool = true;
      }
      PicPreDownloader.a = bool;
    }
    for (;;)
    {
      awiw.a("PIC_TAG_PRELOAD", "onReceive", "isScreenOn:" + PicPreDownloader.a + ",lastScreenOnState:" + PicPreDownloader.b);
      if ((PicPreDownloader.b != PicPreDownloader.a) || (PicPreDownloader.a)) {
        break;
      }
      return;
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
      {
        PicPreDownloader.b = PicPreDownloader.a;
        PicPreDownloader.a = false;
      }
      else if ("android.intent.action.USER_PRESENT".equals(paramIntent))
      {
        PicPreDownloader.b = PicPreDownloader.a;
        PicPreDownloader.a = true;
      }
    }
    ThreadManager.post(new PicPreDownloader.ScreenBroadcastReceiver.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjj
 * JD-Core Version:    0.7.0.1
 */