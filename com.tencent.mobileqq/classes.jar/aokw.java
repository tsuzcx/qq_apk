import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.tencent.mobileqq.richmedia.LOG;
import dov.com.tencent.mobileqq.richmedia.RichmediaClient;
import dov.com.tencent.mobileqq.richmedia.VideoCompoundController;
import java.lang.ref.WeakReference;

public class aokw
  extends Handler
{
  final WeakReference a;
  
  public aokw(Looper paramLooper, RichmediaClient paramRichmediaClient)
  {
    super(paramLooper);
    this.a = new WeakReference(paramRichmediaClient);
  }
  
  public void handleMessage(Message paramMessage)
  {
    LOG.a("PTV.RichmediaClient", "handleMessage, msg.what = " + paramMessage.what);
    RichmediaClient localRichmediaClient = (RichmediaClient)this.a.get();
    if (localRichmediaClient == null) {}
    do
    {
      return;
      if (paramMessage.getData() != null) {
        paramMessage.getData().getInt("msg_sub_cmd");
      }
      switch (paramMessage.what)
      {
      case 1001: 
      default: 
        super.handleMessage(paramMessage);
        return;
      case 1000: 
        LOG.a("PTV.RichmediaClient", "handleMessage MSG_S2C_TEST");
        return;
      }
      LOG.a("PTV.RichmediaClient", "handleMessage MSG_S2C_VIDEO_SLICE_UPLOAD_FINISH");
      paramMessage = paramMessage.getData();
    } while (paramMessage == null);
    paramMessage = paramMessage.getString("vidoe_record_uniseq");
    localRichmediaClient.a().a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aokw
 * JD-Core Version:    0.7.0.1
 */