import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class athr
  extends BroadcastReceiver
{
  private athr(athn paramathn) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "!!!extCard changed[" + paramIntent.getAction() + "]!!!");
    paramContext = paramIntent.getAction();
    if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTABLE")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_EJECT")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED"))) {
      audf.a().a("externalSdCard");
    }
    try
    {
      this.a.a.getFileManagerRSCenter().a(true);
      label96:
      if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_MOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_SCANNER_STARTED"))) {
        audf.a().a();
      }
      this.a.a.getFileManagerNotifyCenter().a(true, 3, null);
      return;
    }
    catch (Exception paramIntent)
    {
      break label96;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     athr
 * JD-Core Version:    0.7.0.1
 */